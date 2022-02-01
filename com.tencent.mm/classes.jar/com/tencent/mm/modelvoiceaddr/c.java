package com.tencent.mm.modelvoiceaddr;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
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
  private com.tencent.mm.ak.g callback;
  private String filename;
  private int gbd;
  private int hUb;
  private boolean icI;
  public h iek;
  private boolean iel;
  private boolean iem;
  private int ien;
  private crm ieo;
  private int iep;
  private String[] ieq;
  private int ier;
  private ao ies;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.gbd = 120;
    this.icI = false;
    this.iel = false;
    this.iem = false;
    this.hUb = 0;
    this.ien = 0;
    this.filename = null;
    this.ieo = null;
    this.scene = 0;
    this.ieq = new String[0];
    this.ier = 3960;
    this.ies = new c.2(this, com.tencent.mm.kernel.g.agU().GrZ.getLooper());
    this.filename = paramString1;
    this.iek = paramh;
    this.ieo = new crm().aJV(paramString2);
    this.iep = paramInt;
    this.scene = 10;
    ac.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.gbd = 120;
    this.icI = false;
    this.iel = false;
    this.iem = false;
    this.hUb = 0;
    this.ien = 0;
    this.filename = null;
    this.ieo = null;
    this.scene = 0;
    this.ieq = new String[0];
    this.ier = 3960;
    this.ies = new c.2(this, com.tencent.mm.kernel.g.agU().GrZ.getLooper());
    this.filename = paramString1;
    this.iek = new h(paramString2);
    this.ieo = new crm().aJV(paramString3);
    this.iep = paramInt1;
    this.scene = paramInt2;
    ac.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void aKF()
  {
    AppMethodBeat.i(148523);
    ac.d("MicroMsg.NetSceneNewVoiceInput", f.YG());
    if (this.ies != null) {
      this.ies.removeMessages(291);
    }
    this.iel = true;
    AppMethodBeat.o(148523);
  }
  
  public final long aKA()
  {
    return 0L;
  }
  
  public final int aKB()
  {
    return this.retCode;
  }
  
  public final List<String> aKC()
  {
    AppMethodBeat.i(148515);
    h localh = this.iek;
    ArrayList localArrayList = new ArrayList();
    localh.ifl.readLock().lock();
    Iterator localIterator = localh.ifk.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.ifo) {
        localArrayList.add(locala.ifn);
      }
    }
    localh.ifl.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean aKD()
  {
    AppMethodBeat.i(148518);
    ac.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.ies.removeMessages(291);
    if (((this.iek.aKN()) && (this.icI)) || (this.iel))
    {
      ac.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.iek.pS(this.hUb);
    if (locala != null)
    {
      long l1 = i.aSp(this.filename);
      long l2 = Math.min(l1, locala.ifq);
      ac.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.ifq), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        ac.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (f.getLine() + 40000);
        this.ien = 0;
        aKE();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.ien = ((int)(l2 - this.hUb));
      if (this.ien < 0)
      {
        ac.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.ien) });
        this.retCode = (f.getLine() + 40000);
        this.ies.sendEmptyMessageDelayed(291, this.gbd * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      ac.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.ien), Integer.valueOf(locala.ifr), Integer.valueOf(this.gbd) });
      if ((this.ien < 500) && (locala.ifr > 5))
      {
        ac.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.ien) });
        this.ies.sendEmptyMessageDelayed(291, this.gbd * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.ies.sendEmptyMessageDelayed(291, this.gbd);
      }
    }
    this.ies.sendEmptyMessageDelayed(291, this.gbd * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void aKE()
  {
    AppMethodBeat.i(148522);
    ac.d("MicroMsg.NetSceneNewVoiceInput", f.YG());
    if (this.iem)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.iem = true;
    aKF();
    com.tencent.mm.kernel.g.agi().ot(hashCode());
    h.a locala = this.iek.pS(this.hUb);
    if (locala != null)
    {
      this.ien = 0;
      com.tencent.mm.kernel.g.agU().az(new c.1(this, locala));
    }
    AppMethodBeat.o(148522);
  }
  
  public final void aKy()
  {
    this.icI = true;
  }
  
  public final String[] aKz()
  {
    return this.ieq;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(148519);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new dqt();
    paramg.hvu = new dqv();
    paramg.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramg.funcId = 235;
    paramg.reqCmdId = 381;
    paramg.respCmdId = 1000000381;
    paramg = paramg.aAz();
    paramg.getReqObj().setShortSupport(false);
    Object localObject1 = (dqt)paramg.hvr.hvw;
    Object localObject2 = this.iek.pS(this.hUb);
    ((dqt)localObject1).Scene = this.scene;
    if (localObject2 == null)
    {
      ((dqt)localObject1).vTK = new SKBuiltinBuffer_t();
      ((dqt)localObject1).EfV = this.hUb;
      ((dqt)localObject1).FUF = "0";
      ((dqt)localObject1).hNR = 1;
      ((dqt)localObject1).FUH = 2;
      ((dqt)localObject1).EeA = 0;
      ((dqt)localObject1).FYa = this.iek.aKM();
      if (((dqt)localObject1).FYa == null) {}
      for (i = 0;; i = ((dqt)localObject1).FYa.size())
      {
        ((dqt)localObject1).FXZ = i;
        ((dqt)localObject1).FCP = this.ieo;
        ((dqt)localObject1).FYb = this.iep;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((dqt)localObject1).FYa.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((crm)((Iterator)localObject1).next()).FEm).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      ac.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).ifo = true;
    if (this.iem)
    {
      ((h.a)localObject2).ifp = true;
      ((dqt)localObject1).vTK = new SKBuiltinBuffer_t();
      ac.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((dqt)localObject1).EfV = this.hUb;
      ((dqt)localObject1).FUF = ((h.a)localObject2).ifn;
      if (!((h.a)localObject2).ifp) {
        break label836;
      }
      i = 1;
      label417:
      ((dqt)localObject1).hNR = i;
      ((dqt)localObject1).FUH = 2;
      i = ((h.a)localObject2).ifr + 1;
      ((h.a)localObject2).ifr = i;
      ((dqt)localObject1).EeA = i;
      ((dqt)localObject1).FYa = this.iek.aKM();
      if (((dqt)localObject1).FYa != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((dqt)localObject1).FYa.size())
    {
      ((dqt)localObject1).FXZ = i;
      ((dqt)localObject1).FCP = this.ieo;
      ((dqt)localObject1).FYb = this.iep;
      ac.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { f.YG(), this.filename, Integer.valueOf(((h.a)localObject2).ifq), Integer.valueOf(this.hUb), Integer.valueOf(this.ien), Integer.valueOf(((dqt)localObject1).vTK.getILen()), Boolean.valueOf(((h.a)localObject2).ifp), Integer.valueOf(((dqt)localObject1).EeA), ((dqt)localObject1).FYa, ((dqt)localObject1).FCP, Integer.valueOf(((dqt)localObject1).Scene) });
      i = this.hUb;
      this.hUb = (((dqt)localObject1).vTK.getILen() + i);
      ac.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).ifn, Integer.valueOf(this.hUb) });
      if (((h.a)localObject2).ifr == 1) {
        ac.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      ac.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.ien > this.ier) {
        this.ien = this.ier;
      }
      for (((h.a)localObject2).ifp = false;; ((h.a)localObject2).ifp = true) {
        do
        {
          byte[] arrayOfByte = i.aU(this.filename, this.hUb, this.ien);
          ((dqt)localObject1).vTK = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          break;
        } while ((this.ien > this.ier) || ((((h.a)localObject2).ifq == 2147483647) && (!this.icI)));
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148521);
    ac.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { f.YG(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      ac.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bs.eWi(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (dqt)((b)paramq).hvr.hvw;
    paramq = (dqv)((b)paramq).hvs.hvw;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.i("MicroMsg.NetSceneNewVoiceInput", f.YG() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      aKE();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    ac.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.FUF, Integer.valueOf(paramArrayOfByte.EeA), Long.valueOf(System.currentTimeMillis()) });
    this.iek.ay(paramq.FYe);
    if ((this.iek.aKN()) && (this.icI))
    {
      ac.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      aKF();
    }
    this.ieq = new String[] { this.iek.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq.FYf <= 0)
    {
      paramInt1 = this.ier;
      this.ier = paramInt1;
      if (paramq.Fys >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = paramq.Fys)
    {
      this.gbd = paramInt1;
      ac.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.ier), Integer.valueOf(this.gbd) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = paramq.FYf;
      break;
    }
  }
  
  public final void pR(int paramInt)
  {
    AppMethodBeat.i(148524);
    ac.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { f.YG(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.iek.pR(paramInt);
    AppMethodBeat.o(148524);
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148520);
    ac.w("MicroMsg.NetSceneNewVoiceInput", f.YG() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == n.a.hvX)
    {
      aKE();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */