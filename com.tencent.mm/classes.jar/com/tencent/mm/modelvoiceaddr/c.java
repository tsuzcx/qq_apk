package com.tencent.mm.modelvoiceaddr;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class c
  extends a
  implements k
{
  private f callback;
  private int eAS;
  private int fQS;
  private boolean fZu;
  private String filename;
  public h gaW;
  private boolean gaX;
  private boolean gaY;
  private int gaZ;
  private bwc gba;
  private int gbb;
  private String[] gbc;
  private int gbd;
  private ak gbe;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(155550);
    this.retCode = 0;
    this.eAS = 120;
    this.fZu = false;
    this.gaX = false;
    this.gaY = false;
    this.fQS = 0;
    this.gaZ = 0;
    this.filename = null;
    this.gba = null;
    this.scene = 0;
    this.gbc = new String[0];
    this.gbd = 3960;
    this.gbe = new c.2(this, com.tencent.mm.kernel.g.RO().oNc.getLooper());
    this.filename = paramString1;
    this.gaW = paramh;
    this.gba = new bwc().aoF(paramString2);
    this.gbb = paramInt;
    this.scene = 10;
    ab.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(155550);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116675);
    this.retCode = 0;
    this.eAS = 120;
    this.fZu = false;
    this.gaX = false;
    this.gaY = false;
    this.fQS = 0;
    this.gaZ = 0;
    this.filename = null;
    this.gba = null;
    this.scene = 0;
    this.gbc = new String[0];
    this.gbd = 3960;
    this.gbe = new c.2(this, com.tencent.mm.kernel.g.RO().oNc.getLooper());
    this.filename = paramString1;
    this.gaW = new h(paramString2);
    this.gba = new bwc().aoF(paramString3);
    this.gbb = paramInt1;
    this.scene = paramInt2;
    ab.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(116675);
  }
  
  private void amI()
  {
    AppMethodBeat.i(116681);
    ab.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ml());
    if (this.gbe != null) {
      this.gbe.removeMessages(291);
    }
    this.gaX = true;
    AppMethodBeat.o(116681);
  }
  
  public final void amB()
  {
    this.fZu = true;
  }
  
  public final String[] amC()
  {
    return this.gbc;
  }
  
  public final long amD()
  {
    return 0L;
  }
  
  public final int amE()
  {
    return this.retCode;
  }
  
  public final List<String> amF()
  {
    AppMethodBeat.i(138328);
    h localh = this.gaW;
    ArrayList localArrayList = new ArrayList();
    localh.gbR.readLock().lock();
    Iterator localIterator = localh.gbQ.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.gbU) {
        localArrayList.add(locala.gbT);
      }
    }
    localh.gbR.readLock().unlock();
    AppMethodBeat.o(138328);
    return localArrayList;
  }
  
  public final boolean amG()
  {
    AppMethodBeat.i(116676);
    ab.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.gbe.removeMessages(291);
    if (((this.gaW.amQ()) && (this.fZu)) || (this.gaX))
    {
      ab.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(116676);
      return false;
    }
    h.a locala = this.gaW.mu(this.fQS);
    if (locala != null)
    {
      long l1 = com.tencent.mm.vfs.e.avI(this.filename);
      long l2 = Math.min(l1, locala.gbW);
      ab.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.gbW), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        ab.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        this.gaZ = 0;
        amH();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(116676);
        return false;
      }
      this.gaZ = ((int)(l2 - this.fQS));
      if (this.gaZ < 0)
      {
        ab.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.gaZ) });
        this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 40000);
        this.gbe.sendEmptyMessageDelayed(291, this.eAS * 2);
        AppMethodBeat.o(116676);
        return false;
      }
      ab.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.gaZ), Integer.valueOf(locala.gbX), Integer.valueOf(this.eAS) });
      if ((this.gaZ < 500) && (locala.gbX > 5))
      {
        ab.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.gaZ) });
        this.gbe.sendEmptyMessageDelayed(291, this.eAS * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(116676);
        return true;
        this.gbe.sendEmptyMessageDelayed(291, this.eAS);
      }
    }
    this.gbe.sendEmptyMessageDelayed(291, this.eAS * 2);
    AppMethodBeat.o(116676);
    return true;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(116680);
    ab.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ml());
    if (this.gaY)
    {
      AppMethodBeat.o(116680);
      return;
    }
    this.gaY = true;
    amI();
    com.tencent.mm.kernel.g.Rc().kW(hashCode());
    h.a locala = this.gaW.mu(this.fQS);
    if (locala != null)
    {
      this.gaZ = 0;
      com.tencent.mm.kernel.g.RO().ac(new c.1(this, locala));
    }
    AppMethodBeat.o(116680);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(116677);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new crh();
    paramf.fsY = new crj();
    paramf.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramf.funcId = 235;
    paramf.reqCmdId = 381;
    paramf.respCmdId = 1000000381;
    paramf = paramf.ado();
    paramf.getReqObj().setShortSupport(false);
    Object localObject1 = (crh)paramf.fsV.fta;
    Object localObject2 = this.gaW.mu(this.fQS);
    ((crh)localObject1).Scene = this.scene;
    if (localObject2 == null)
    {
      ((crh)localObject1).pIA = new SKBuiltinBuffer_t();
      ((crh)localObject1).wzS = this.fQS;
      ((crh)localObject1).xWW = "0";
      ((crh)localObject1).fKi = 1;
      ((crh)localObject1).xWY = 2;
      ((crh)localObject1).wAK = 0;
      ((crh)localObject1).xZQ = this.gaW.amP();
      if (((crh)localObject1).xZQ == null) {}
      for (i = 0;; i = ((crh)localObject1).xZQ.size())
      {
        ((crh)localObject1).xZP = i;
        ((crh)localObject1).xIA = this.gba;
        ((crh)localObject1).xZR = this.gbb;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((crh)localObject1).xZQ.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((bwc)((Iterator)localObject1).next()).xJE).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      ab.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(116677);
      return i;
    }
    ((h.a)localObject2).gbU = true;
    if (this.gaY)
    {
      ((h.a)localObject2).gbV = true;
      ((crh)localObject1).pIA = new SKBuiltinBuffer_t();
      ab.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((crh)localObject1).wzS = this.fQS;
      ((crh)localObject1).xWW = ((h.a)localObject2).gbT;
      if (!((h.a)localObject2).gbV) {
        break label836;
      }
      i = 1;
      label417:
      ((crh)localObject1).fKi = i;
      ((crh)localObject1).xWY = 2;
      i = ((h.a)localObject2).gbX + 1;
      ((h.a)localObject2).gbX = i;
      ((crh)localObject1).wAK = i;
      ((crh)localObject1).xZQ = this.gaW.amP();
      if (((crh)localObject1).xZQ != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((crh)localObject1).xZQ.size())
    {
      ((crh)localObject1).xZP = i;
      ((crh)localObject1).xIA = this.gba;
      ((crh)localObject1).xZR = this.gbb;
      ab.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { com.tencent.mm.compatible.util.g.Ml(), this.filename, Integer.valueOf(((h.a)localObject2).gbW), Integer.valueOf(this.fQS), Integer.valueOf(this.gaZ), Integer.valueOf(((crh)localObject1).pIA.getILen()), Boolean.valueOf(((h.a)localObject2).gbV), Integer.valueOf(((crh)localObject1).wAK), ((crh)localObject1).xZQ, ((crh)localObject1).xIA, Integer.valueOf(((crh)localObject1).Scene) });
      i = this.fQS;
      this.fQS = (((crh)localObject1).pIA.getILen() + i);
      ab.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).gbT, Integer.valueOf(this.fQS) });
      if (((h.a)localObject2).gbX == 1) {
        ab.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      ab.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(116677);
      return i;
      if (this.gaZ > this.gbd) {
        this.gaZ = this.gbd;
      }
      for (((h.a)localObject2).gbV = false;; ((h.a)localObject2).gbV = true) {
        do
        {
          byte[] arrayOfByte = com.tencent.mm.vfs.e.i(this.filename, this.fQS, this.gaZ);
          ((crh)localObject1).pIA = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          break;
        } while ((this.gaZ > this.gbd) || ((((h.a)localObject2).gbW == 2147483647) && (!this.fZu)));
      }
      i = 0;
      break label417;
    }
  }
  
  public final int getType()
  {
    return 235;
  }
  
  public final boolean isSupportConcurrent()
  {
    return true;
  }
  
  public final void mt(int paramInt)
  {
    AppMethodBeat.i(116682);
    ab.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { com.tencent.mm.compatible.util.g.Ml(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(116682);
      throw localIllegalStateException;
    }
    this.gaW.mt(paramInt);
    AppMethodBeat.o(116682);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116679);
    ab.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { com.tencent.mm.compatible.util.g.Ml(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      ab.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bo.dtY(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (crh)((b)paramq).fsV.fta;
    paramq = (crj)((b)paramq).fsW.fta;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      amH();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116679);
      return;
    }
    ab.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.xWW, Integer.valueOf(paramArrayOfByte.wAK), Long.valueOf(System.currentTimeMillis()) });
    this.gaW.aj(paramq.xZU);
    if ((this.gaW.amQ()) && (this.fZu))
    {
      ab.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      amI();
    }
    this.gbc = new String[] { this.gaW.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq.xZV <= 0)
    {
      paramInt1 = this.gbd;
      this.gbd = paramInt1;
      if (paramq.xEz >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = paramq.xEz)
    {
      this.eAS = paramInt1;
      ab.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.gbd), Integer.valueOf(this.eAS) });
      AppMethodBeat.o(116679);
      return;
      paramInt1 = paramq.xZV;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(116678);
    ab.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.Ml() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == m.a.ftr)
    {
      amH();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(116678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */