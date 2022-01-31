package com.tencent.mm.modelvoiceaddr;

import android.os.HandlerThread;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.p.4;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cdw;
import com.tencent.mm.protocal.c.cdy;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class c
  extends a
  implements k
{
  private int dDr = 120;
  private f dmL;
  private int eBa = 0;
  private boolean eJS = false;
  h eLp;
  private boolean eLq = false;
  private boolean eLr = false;
  private int eLs = 0;
  private bml eLt = null;
  private int eLu;
  private String[] eLv = new String[0];
  private int eLw = 3960;
  private ah eLx = new c.2(this, com.tencent.mm.kernel.g.DS().mnU.getLooper());
  private String filename = null;
  private int retCode = 0;
  private int scene = 0;
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.filename = paramString1;
    this.eLp = new h(paramString2);
    this.eLt = new bml().YI(paramString3);
    this.eLu = paramInt1;
    this.scene = paramInt2;
    y.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void Tw()
  {
    y.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zI());
    if (this.eLx != null) {
      this.eLx.removeMessages(291);
    }
    this.eLq = true;
  }
  
  protected final int Ka()
  {
    return 2000;
  }
  
  protected final boolean Kz()
  {
    return true;
  }
  
  public final void Tp()
  {
    this.eJS = true;
  }
  
  public final String[] Tq()
  {
    return this.eLv;
  }
  
  public final long Tr()
  {
    return 0L;
  }
  
  public final int Ts()
  {
    return this.retCode;
  }
  
  public final Set<String> Tt()
  {
    h localh = this.eLp;
    HashSet localHashSet = new HashSet();
    localh.eMl.readLock().lock();
    Iterator localIterator = localh.eMk.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.eMo) {
        localHashSet.add(locala.eMn);
      }
    }
    localh.eMl.readLock().unlock();
    return localHashSet;
  }
  
  public final boolean Tu()
  {
    y.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.eLx.removeMessages(291);
    if (((this.eLp.TE()) && (this.eJS)) || (this.eLq))
    {
      y.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      return false;
    }
    h.a locala = this.eLp.jB(this.eBa);
    if (locala != null)
    {
      long l1 = com.tencent.mm.vfs.e.aeQ(this.filename);
      long l2 = Math.min(l1, locala.eMq);
      y.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.eMq), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        y.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        this.eLs = 0;
        Tv();
        this.dmL.onSceneEnd(3, -1, "ReadFileLengthError", null);
        return false;
      }
      this.eLs = ((int)(l2 - this.eBa));
      if (this.eLs < 0)
      {
        y.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.eLs) });
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        this.eLx.sendEmptyMessageDelayed(291, this.dDr * 2);
        return false;
      }
      y.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.eLs), Integer.valueOf(locala.eMr), Integer.valueOf(this.dDr) });
      if ((this.eLs < 500) && (locala.eMr > 5))
      {
        y.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.eLs) });
        this.eLx.sendEmptyMessageDelayed(291, this.dDr * 2);
      }
      for (;;)
      {
        return true;
        this.eLx.sendEmptyMessageDelayed(291, this.dDr);
      }
    }
    this.eLx.sendEmptyMessageDelayed(291, this.dDr * 2);
    return true;
  }
  
  public final void Tv()
  {
    y.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zI());
    if (this.eLr) {}
    Object localObject;
    do
    {
      return;
      this.eLr = true;
      Tw();
      localObject = com.tencent.mm.kernel.g.Dk();
      int i = hashCode();
      y.l("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(i) });
      ((p)localObject).edy.O(new p.4((p)localObject, i));
      localObject = this.eLp.jB(this.eBa);
    } while (localObject == null);
    this.eLs = 0;
    com.tencent.mm.kernel.g.DS().O(new c.1(this, (h.a)localObject));
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new cdw();
    paramf.ecI = new cdy();
    paramf.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramf.ecG = 235;
    paramf.ecJ = 381;
    paramf.ecK = 1000000381;
    paramf = paramf.Kt();
    paramf.Kv().spJ = false;
    Object localObject1 = (cdw)paramf.ecE.ecN;
    Object localObject2 = this.eLp.jB(this.eBa);
    ((cdw)localObject1).pyo = this.scene;
    if (localObject2 == null)
    {
      ((cdw)localObject1).ndi = new bmk();
      ((cdw)localObject1).sDT = this.eBa;
      ((cdw)localObject1).tQb = "0";
      ((cdw)localObject1).euw = 1;
      ((cdw)localObject1).tQd = 2;
      ((cdw)localObject1).sEE = 0;
      ((cdw)localObject1).tSy = this.eLp.TD();
      if (((cdw)localObject1).tSy == null) {}
      for (i = 0;; i = ((cdw)localObject1).tSy.size())
      {
        ((cdw)localObject1).tSx = i;
        ((cdw)localObject1).tEU = this.eLt;
        ((cdw)localObject1).tSz = this.eLu;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((cdw)localObject1).tSy.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((bml)((Iterator)localObject1).next()).tFO).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      y.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      return a(parame, paramf, this);
    }
    ((h.a)localObject2).eMo = true;
    if (this.eLr)
    {
      ((h.a)localObject2).eMp = true;
      ((cdw)localObject1).ndi = new bmk();
      y.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((cdw)localObject1).sDT = this.eBa;
      ((cdw)localObject1).tQb = ((h.a)localObject2).eMn;
      if (!((h.a)localObject2).eMp) {
        break label814;
      }
      i = 1;
      label403:
      ((cdw)localObject1).euw = i;
      ((cdw)localObject1).tQd = 2;
      i = ((h.a)localObject2).eMr + 1;
      ((h.a)localObject2).eMr = i;
      ((cdw)localObject1).sEE = i;
      ((cdw)localObject1).tSy = this.eLp.TD();
      if (((cdw)localObject1).tSy != null) {
        break label819;
      }
    }
    label814:
    label819:
    for (int i = 0;; i = ((cdw)localObject1).tSy.size())
    {
      ((cdw)localObject1).tSx = i;
      ((cdw)localObject1).tEU = this.eLt;
      ((cdw)localObject1).tSz = this.eLu;
      y.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { com.tencent.mm.compatible.util.g.zI(), this.filename, Integer.valueOf(((h.a)localObject2).eMq), Integer.valueOf(this.eBa), Integer.valueOf(this.eLs), Integer.valueOf(((cdw)localObject1).ndi.tFK), Boolean.valueOf(((h.a)localObject2).eMp), Integer.valueOf(((cdw)localObject1).sEE), ((cdw)localObject1).tSy, ((cdw)localObject1).tEU, Integer.valueOf(((cdw)localObject1).pyo) });
      i = this.eBa;
      this.eBa = (((cdw)localObject1).ndi.tFK + i);
      y.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).eMn, Integer.valueOf(this.eBa) });
      if (((h.a)localObject2).eMr == 1) {
        y.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      y.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      return a(parame, paramf, this);
      if (this.eLs > this.eLw) {
        this.eLs = this.eLw;
      }
      for (((h.a)localObject2).eMp = false;; ((h.a)localObject2).eMp = true) {
        do
        {
          byte[] arrayOfByte = com.tencent.mm.vfs.e.c(this.filename, this.eBa, this.eLs);
          ((cdw)localObject1).ndi = new bmk().bs(arrayOfByte);
          break;
        } while ((this.eLs > this.eLw) || ((((h.a)localObject2).eMq == 2147483647) && (!this.eJS)));
      }
      i = 0;
      break label403;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { com.tencent.mm.compatible.util.g.zI(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      y.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bk.csb(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (cdw)((b)paramq).ecE.ecN;
    paramq = (cdy)((b)paramq).ecF.ecN;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zI() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      Tv();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.tQb, Integer.valueOf(paramArrayOfByte.sEE), Long.valueOf(System.currentTimeMillis()) });
    this.eLp.ac(paramq.tSC);
    if ((this.eLp.TE()) && (this.eJS))
    {
      y.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      Tw();
    }
    this.eLv = new String[] { this.eLp.getResult() };
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq.tSD <= 0)
    {
      paramInt1 = this.eLw;
      this.eLw = paramInt1;
      if (paramq.tCw >= 0) {
        break label386;
      }
    }
    label386:
    for (paramInt1 = 120;; paramInt1 = paramq.tCw)
    {
      this.dDr = paramInt1;
      y.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.eLw), Integer.valueOf(this.dDr) });
      return;
      paramInt1 = paramq.tSD;
      break;
    }
  }
  
  protected final void a(m.a parama)
  {
    y.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zI() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == m.a.edo)
    {
      Tv();
      this.dmL.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 235;
  }
  
  public final void jA(int paramInt)
  {
    y.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { com.tencent.mm.compatible.util.g.zI(), Integer.valueOf(paramInt) });
    if (paramInt < 0) {
      throw new IllegalStateException();
    }
    this.eLp.jA(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */