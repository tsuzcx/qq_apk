package com.tencent.mm.modelvoiceaddr;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dye;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  private com.tencent.mm.ak.f callback;
  private String filename;
  private int gxu;
  private boolean iAA;
  private int iAB;
  private cxn iAC;
  private int iAD;
  private String[] iAE;
  private int iAF;
  private aq iAG;
  public h iAy;
  private boolean iAz;
  private int iqq;
  private boolean iyX;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.gxu = 120;
    this.iyX = false;
    this.iAz = false;
    this.iAA = false;
    this.iqq = 0;
    this.iAB = 0;
    this.filename = null;
    this.iAC = null;
    this.scene = 0;
    this.iAE = new String[0];
    this.iAF = 3960;
    this.iAG = new c.2(this, g.ajU().IxZ.getLooper());
    this.filename = paramString1;
    this.iAy = paramh;
    this.iAC = new cxn().aQV(paramString2);
    this.iAD = paramInt;
    this.scene = 10;
    ae.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.gxu = 120;
    this.iyX = false;
    this.iAz = false;
    this.iAA = false;
    this.iqq = 0;
    this.iAB = 0;
    this.filename = null;
    this.iAC = null;
    this.scene = 0;
    this.iAE = new String[0];
    this.iAF = 3960;
    this.iAG = new c.2(this, g.ajU().IxZ.getLooper());
    this.filename = paramString1;
    this.iAy = new h(paramString2);
    this.iAC = new cxn().aQV(paramString3);
    this.iAD = paramInt1;
    this.scene = paramInt2;
    ae.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void aOm()
  {
    AppMethodBeat.i(148523);
    ae.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abr());
    if (this.iAG != null) {
      this.iAG.removeMessages(291);
    }
    this.iAz = true;
    AppMethodBeat.o(148523);
  }
  
  public final void aOf()
  {
    this.iyX = true;
  }
  
  public final String[] aOg()
  {
    return this.iAE;
  }
  
  public final long aOh()
  {
    return 0L;
  }
  
  public final int aOi()
  {
    return this.retCode;
  }
  
  public final List<String> aOj()
  {
    AppMethodBeat.i(148515);
    h localh = this.iAy;
    ArrayList localArrayList = new ArrayList();
    localh.iBy.readLock().lock();
    Iterator localIterator = localh.iBx.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.iBB) {
        localArrayList.add(locala.iBA);
      }
    }
    localh.iBy.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean aOk()
  {
    AppMethodBeat.i(148518);
    ae.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.iAG.removeMessages(291);
    if (((this.iAy.aOu()) && (this.iyX)) || (this.iAz))
    {
      ae.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.iAy.qx(this.iqq);
    if (locala != null)
    {
      long l1 = o.aZR(this.filename);
      long l2 = Math.min(l1, locala.iBD);
      ae.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.iBD), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        ae.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        this.iAB = 0;
        aOl();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.iAB = ((int)(l2 - this.iqq));
      if (this.iAB < 0)
      {
        ae.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.iAB) });
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        this.iAG.sendEmptyMessageDelayed(291, this.gxu * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      ae.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.iAB), Integer.valueOf(locala.iBE), Integer.valueOf(this.gxu) });
      if ((this.iAB < 500) && (locala.iBE > 5))
      {
        ae.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.iAB) });
        this.iAG.sendEmptyMessageDelayed(291, this.gxu * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.iAG.sendEmptyMessageDelayed(291, this.gxu);
      }
    }
    this.iAG.sendEmptyMessageDelayed(291, this.gxu * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void aOl()
  {
    AppMethodBeat.i(148522);
    ae.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abr());
    if (this.iAA)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.iAA = true;
    aOm();
    g.ajj().oW(hashCode());
    h.a locala = this.iAy.qx(this.iqq);
    if (locala != null)
    {
      this.iAB = 0;
      g.ajU().aw(new c.1(this, locala));
    }
    AppMethodBeat.o(148522);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(148519);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new dye();
    paramf.hQG = new dyg();
    paramf.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramf.funcId = 235;
    paramf.hQH = 381;
    paramf.respCmdId = 1000000381;
    paramf = paramf.aDS();
    paramf.getReqObj().setShortSupport(false);
    Object localObject1 = (dye)paramf.hQD.hQJ;
    Object localObject2 = this.iAy.qx(this.iqq);
    ((dye)localObject1).Scene = this.scene;
    if (localObject2 == null)
    {
      ((dye)localObject1).xsE = new SKBuiltinBuffer_t();
      ((dye)localObject1).GeT = this.iqq;
      ((dye)localObject1).HZg = "0";
      ((dye)localObject1).ijY = 1;
      ((dye)localObject1).HZi = 2;
      ((dye)localObject1).Gdy = 0;
      ((dye)localObject1).Ide = this.iAy.aOt();
      if (((dye)localObject1).Ide == null) {}
      for (i = 0;; i = ((dye)localObject1).Ide.size())
      {
        ((dye)localObject1).Idd = i;
        ((dye)localObject1).HGC = this.iAC;
        ((dye)localObject1).Idf = this.iAD;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((dye)localObject1).Ide.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((cxn)((Iterator)localObject1).next()).HId).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      ae.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).iBB = true;
    if (this.iAA)
    {
      ((h.a)localObject2).iBC = true;
      ((dye)localObject1).xsE = new SKBuiltinBuffer_t();
      ae.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((dye)localObject1).GeT = this.iqq;
      ((dye)localObject1).HZg = ((h.a)localObject2).iBA;
      if (!((h.a)localObject2).iBC) {
        break label836;
      }
      i = 1;
      label417:
      ((dye)localObject1).ijY = i;
      ((dye)localObject1).HZi = 2;
      i = ((h.a)localObject2).iBE + 1;
      ((h.a)localObject2).iBE = i;
      ((dye)localObject1).Gdy = i;
      ((dye)localObject1).Ide = this.iAy.aOt();
      if (((dye)localObject1).Ide != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((dye)localObject1).Ide.size())
    {
      ((dye)localObject1).Idd = i;
      ((dye)localObject1).HGC = this.iAC;
      ((dye)localObject1).Idf = this.iAD;
      ae.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { com.tencent.mm.compatible.util.f.abr(), this.filename, Integer.valueOf(((h.a)localObject2).iBD), Integer.valueOf(this.iqq), Integer.valueOf(this.iAB), Integer.valueOf(((dye)localObject1).xsE.getILen()), Boolean.valueOf(((h.a)localObject2).iBC), Integer.valueOf(((dye)localObject1).Gdy), ((dye)localObject1).Ide, ((dye)localObject1).HGC, Integer.valueOf(((dye)localObject1).Scene) });
      i = this.iqq;
      this.iqq = (((dye)localObject1).xsE.getILen() + i);
      ae.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).iBA, Integer.valueOf(this.iqq) });
      if (((h.a)localObject2).iBE == 1) {
        ae.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      ae.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.iAB > this.iAF) {
        this.iAB = this.iAF;
      }
      for (((h.a)localObject2).iBC = false;; ((h.a)localObject2).iBC = true) {
        do
        {
          byte[] arrayOfByte = o.bb(this.filename, this.iqq, this.iAB);
          ((dye)localObject1).xsE = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          break;
        } while ((this.iAB > this.iAF) || ((((h.a)localObject2).iBD == 2147483647) && (!this.iyX)));
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
    ae.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { com.tencent.mm.compatible.util.f.abr(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      ae.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bu.fpN(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (dye)((b)paramq).hQD.hQJ;
    paramq = (dyg)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abr() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      aOl();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    ae.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.HZg, Integer.valueOf(paramArrayOfByte.Gdy), Long.valueOf(System.currentTimeMillis()) });
    this.iAy.az(paramq.Idi);
    if ((this.iAy.aOu()) && (this.iyX))
    {
      ae.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      aOm();
    }
    this.iAE = new String[] { this.iAy.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq.Idj <= 0)
    {
      paramInt1 = this.iAF;
      this.iAF = paramInt1;
      if (paramq.HBX >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = paramq.HBX)
    {
      this.gxu = paramInt1;
      ae.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.iAF), Integer.valueOf(this.gxu) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = paramq.Idj;
      break;
    }
  }
  
  public final void qw(int paramInt)
  {
    AppMethodBeat.i(148524);
    ae.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { com.tencent.mm.compatible.util.f.abr(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.iAy.qw(paramInt);
    AppMethodBeat.o(148524);
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148520);
    ae.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abr() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == n.a.hRf)
    {
      aOl();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */