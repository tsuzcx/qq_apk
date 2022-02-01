package com.tencent.mm.modelvoiceaddr;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private com.tencent.mm.al.f callback;
  private String filename;
  private int guN;
  private int inw;
  private boolean iwe;
  public h ixF;
  private boolean ixG;
  private boolean ixH;
  private int ixI;
  private cwt ixJ;
  private int ixK;
  private String[] ixL;
  private int ixM;
  private ap ixN;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.guN = 120;
    this.iwe = false;
    this.ixG = false;
    this.ixH = false;
    this.inw = 0;
    this.ixI = 0;
    this.filename = null;
    this.ixJ = null;
    this.scene = 0;
    this.ixL = new String[0];
    this.ixM = 3960;
    this.ixN = new c.2(this, g.ajF().IdO.getLooper());
    this.filename = paramString1;
    this.ixF = paramh;
    this.ixJ = new cwt().aPy(paramString2);
    this.ixK = paramInt;
    this.scene = 10;
    ad.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.guN = 120;
    this.iwe = false;
    this.ixG = false;
    this.ixH = false;
    this.inw = 0;
    this.ixI = 0;
    this.filename = null;
    this.ixJ = null;
    this.scene = 0;
    this.ixL = new String[0];
    this.ixM = 3960;
    this.ixN = new c.2(this, g.ajF().IdO.getLooper());
    this.filename = paramString1;
    this.ixF = new h(paramString2);
    this.ixJ = new cwt().aPy(paramString3);
    this.ixK = paramInt1;
    this.scene = paramInt2;
    ad.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void aNO()
  {
    AppMethodBeat.i(148523);
    ad.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abi());
    if (this.ixN != null) {
      this.ixN.removeMessages(291);
    }
    this.ixG = true;
    AppMethodBeat.o(148523);
  }
  
  public final void aNH()
  {
    this.iwe = true;
  }
  
  public final String[] aNI()
  {
    return this.ixL;
  }
  
  public final long aNJ()
  {
    return 0L;
  }
  
  public final int aNK()
  {
    return this.retCode;
  }
  
  public final List<String> aNL()
  {
    AppMethodBeat.i(148515);
    h localh = this.ixF;
    ArrayList localArrayList = new ArrayList();
    localh.iyF.readLock().lock();
    Iterator localIterator = localh.iyE.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.iyI) {
        localArrayList.add(locala.iyH);
      }
    }
    localh.iyF.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean aNM()
  {
    AppMethodBeat.i(148518);
    ad.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.ixN.removeMessages(291);
    if (((this.ixF.aNW()) && (this.iwe)) || (this.ixG))
    {
      ad.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.ixF.qu(this.inw);
    if (locala != null)
    {
      long l1 = i.aYo(this.filename);
      long l2 = Math.min(l1, locala.iyK);
      ad.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.iyK), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        ad.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        this.ixI = 0;
        aNN();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.ixI = ((int)(l2 - this.inw));
      if (this.ixI < 0)
      {
        ad.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.ixI) });
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        this.ixN.sendEmptyMessageDelayed(291, this.guN * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      ad.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.ixI), Integer.valueOf(locala.iyL), Integer.valueOf(this.guN) });
      if ((this.ixI < 500) && (locala.iyL > 5))
      {
        ad.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.ixI) });
        this.ixN.sendEmptyMessageDelayed(291, this.guN * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.ixN.sendEmptyMessageDelayed(291, this.guN);
      }
    }
    this.ixN.sendEmptyMessageDelayed(291, this.guN * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void aNN()
  {
    AppMethodBeat.i(148522);
    ad.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abi());
    if (this.ixH)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.ixH = true;
    aNO();
    g.aiU().oT(hashCode());
    h.a locala = this.ixF.qu(this.inw);
    if (locala != null)
    {
      this.ixI = 0;
      g.ajF().ay(new c.1(this, locala));
    }
    AppMethodBeat.o(148522);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(148519);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new dwn();
    paramf.hNN = new dwp();
    paramf.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramf.funcId = 235;
    paramf.hNO = 381;
    paramf.respCmdId = 1000000381;
    paramf = paramf.aDC();
    paramf.getReqObj().setShortSupport(false);
    Object localObject1 = (dwn)paramf.hNK.hNQ;
    Object localObject2 = this.ixF.qu(this.inw);
    ((dwn)localObject1).Scene = this.scene;
    if (localObject2 == null)
    {
      ((dwn)localObject1).xcN = new SKBuiltinBuffer_t();
      ((dwn)localObject1).FMu = this.inw;
      ((dwn)localObject1).HFt = "0";
      ((dwn)localObject1).ihf = 1;
      ((dwn)localObject1).HFv = 2;
      ((dwn)localObject1).FKZ = 0;
      ((dwn)localObject1).HIW = this.ixF.aNV();
      if (((dwn)localObject1).HIW == null) {}
      for (i = 0;; i = ((dwn)localObject1).HIW.size())
      {
        ((dwn)localObject1).HIV = i;
        ((dwn)localObject1).Hnc = this.ixJ;
        ((dwn)localObject1).HIX = this.ixK;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((dwn)localObject1).HIW.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((cwt)((Iterator)localObject1).next()).HoB).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      ad.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).iyI = true;
    if (this.ixH)
    {
      ((h.a)localObject2).iyJ = true;
      ((dwn)localObject1).xcN = new SKBuiltinBuffer_t();
      ad.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((dwn)localObject1).FMu = this.inw;
      ((dwn)localObject1).HFt = ((h.a)localObject2).iyH;
      if (!((h.a)localObject2).iyJ) {
        break label836;
      }
      i = 1;
      label417:
      ((dwn)localObject1).ihf = i;
      ((dwn)localObject1).HFv = 2;
      i = ((h.a)localObject2).iyL + 1;
      ((h.a)localObject2).iyL = i;
      ((dwn)localObject1).FKZ = i;
      ((dwn)localObject1).HIW = this.ixF.aNV();
      if (((dwn)localObject1).HIW != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((dwn)localObject1).HIW.size())
    {
      ((dwn)localObject1).HIV = i;
      ((dwn)localObject1).Hnc = this.ixJ;
      ((dwn)localObject1).HIX = this.ixK;
      ad.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { com.tencent.mm.compatible.util.f.abi(), this.filename, Integer.valueOf(((h.a)localObject2).iyK), Integer.valueOf(this.inw), Integer.valueOf(this.ixI), Integer.valueOf(((dwn)localObject1).xcN.getILen()), Boolean.valueOf(((h.a)localObject2).iyJ), Integer.valueOf(((dwn)localObject1).FKZ), ((dwn)localObject1).HIW, ((dwn)localObject1).Hnc, Integer.valueOf(((dwn)localObject1).Scene) });
      i = this.inw;
      this.inw = (((dwn)localObject1).xcN.getILen() + i);
      ad.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).iyH, Integer.valueOf(this.inw) });
      if (((h.a)localObject2).iyL == 1) {
        ad.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      ad.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramf, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.ixI > this.ixM) {
        this.ixI = this.ixM;
      }
      for (((h.a)localObject2).iyJ = false;; ((h.a)localObject2).iyJ = true) {
        do
        {
          byte[] arrayOfByte = i.aY(this.filename, this.inw, this.ixI);
          ((dwn)localObject1).xcN = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          break;
        } while ((this.ixI > this.ixM) || ((((h.a)localObject2).iyK == 2147483647) && (!this.iwe)));
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
    ad.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { com.tencent.mm.compatible.util.f.abi(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      ad.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bt.flS(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (dwn)((b)paramq).hNK.hNQ;
    paramq = (dwp)((b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abi() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      aNN();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    ad.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.HFt, Integer.valueOf(paramArrayOfByte.FKZ), Long.valueOf(System.currentTimeMillis()) });
    this.ixF.az(paramq.HJa);
    if ((this.ixF.aNW()) && (this.iwe))
    {
      ad.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      aNO();
    }
    this.ixL = new String[] { this.ixF.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq.HJb <= 0)
    {
      paramInt1 = this.ixM;
      this.ixM = paramInt1;
      if (paramq.Hix >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = paramq.Hix)
    {
      this.guN = paramInt1;
      ad.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.ixM), Integer.valueOf(this.guN) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = paramq.HJb;
      break;
    }
  }
  
  public final void qt(int paramInt)
  {
    AppMethodBeat.i(148524);
    ad.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { com.tencent.mm.compatible.util.f.abi(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.ixF.qt(paramInt);
    AppMethodBeat.o(148524);
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148520);
    ad.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.f.abi() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == n.a.hOm)
    {
      aNN();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */