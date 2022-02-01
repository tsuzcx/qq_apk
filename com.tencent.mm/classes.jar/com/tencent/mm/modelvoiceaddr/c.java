package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.protocal.protobuf.esn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  implements m
{
  private i callback;
  private String filename;
  private int gTn;
  private int jlB;
  private boolean jul;
  public h jvN;
  private boolean jvO;
  private boolean jvP;
  private int jvQ;
  private dqi jvR;
  private int jvS;
  private String[] jvT;
  private int jvU;
  private MMHandler jvV;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.gTn = 120;
    this.jul = false;
    this.jvO = false;
    this.jvP = false;
    this.jlB = 0;
    this.jvQ = 0;
    this.filename = null;
    this.jvR = null;
    this.scene = 0;
    this.jvT = new String[0];
    this.jvU = 3960;
    this.jvV = new c.2(this, com.tencent.mm.kernel.g.aAk().getLooper());
    this.filename = paramString1;
    this.jvN = paramh;
    this.jvR = new dqi().bhy(paramString2);
    this.jvS = paramInt;
    this.scene = 10;
    Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.gTn = 120;
    this.jul = false;
    this.jvO = false;
    this.jvP = false;
    this.jlB = 0;
    this.jvQ = 0;
    this.filename = null;
    this.jvR = null;
    this.scene = 0;
    this.jvT = new String[0];
    this.jvU = 3960;
    this.jvV = new c.2(this, com.tencent.mm.kernel.g.aAk().getLooper());
    this.filename = paramString1;
    this.jvN = new h(paramString2);
    this.jvR = new dqi().bhy(paramString3);
    this.jvS = paramInt1;
    this.scene = paramInt2;
    Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void bit()
  {
    AppMethodBeat.i(148523);
    Log.d("MicroMsg.NetSceneNewVoiceInput", f.apq());
    if (this.jvV != null) {
      this.jvV.removeMessages(291);
    }
    this.jvO = true;
    AppMethodBeat.o(148523);
  }
  
  public final void bim()
  {
    this.jul = true;
  }
  
  public final String[] bin()
  {
    return this.jvT;
  }
  
  public final long bio()
  {
    return 0L;
  }
  
  public final int bip()
  {
    return this.retCode;
  }
  
  public final List<String> biq()
  {
    AppMethodBeat.i(148515);
    h localh = this.jvN;
    ArrayList localArrayList = new ArrayList();
    localh.jwN.readLock().lock();
    Iterator localIterator = localh.jwM.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.jwQ) {
        localArrayList.add(locala.jwP);
      }
    }
    localh.jwN.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean bir()
  {
    AppMethodBeat.i(148518);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.jvV.removeMessages(291);
    if (((this.jvN.biB()) && (this.jul)) || (this.jvO))
    {
      Log.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.jvN.um(this.jlB);
    if (locala != null)
    {
      long l1 = com.tencent.mm.vfs.s.boW(this.filename);
      long l2 = Math.min(l1, locala.jwS);
      Log.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.jwS), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        Log.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (f.getLine() + 40000);
        this.jvQ = 0;
        bis();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.jvQ = ((int)(l2 - this.jlB));
      if (this.jvQ < 0)
      {
        Log.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.jvQ) });
        this.retCode = (f.getLine() + 40000);
        this.jvV.sendEmptyMessageDelayed(291, this.gTn * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.jvQ), Integer.valueOf(locala.jwT), Integer.valueOf(this.gTn) });
      if ((this.jvQ < 500) && (locala.jwT > 5))
      {
        Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.jvQ) });
        this.jvV.sendEmptyMessageDelayed(291, this.gTn * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.jvV.sendEmptyMessageDelayed(291, this.gTn);
      }
    }
    this.jvV.sendEmptyMessageDelayed(291, this.gTn * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void bis()
  {
    AppMethodBeat.i(148522);
    Log.d("MicroMsg.NetSceneNewVoiceInput", f.apq());
    if (this.jvP)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.jvP = true;
    bit();
    com.tencent.mm.kernel.g.azz().sK(hashCode());
    h.a locala = this.jvN.um(this.jlB);
    if (locala != null)
    {
      this.jvQ = 0;
      com.tencent.mm.kernel.g.aAk().postToWorker(new c.1(this, locala));
    }
    AppMethodBeat.o(148522);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(148519);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new esl();
    parami.iLO = new esn();
    parami.uri = "/cgi-bin/micromsg-bin/voicetrans";
    parami.funcId = 235;
    parami.iLP = 381;
    parami.respCmdId = 1000000381;
    parami = parami.aXF();
    parami.getReqObj().setShortSupport(false);
    Object localObject1 = (esl)parami.iLK.iLR;
    Object localObject2 = this.jvN.um(this.jlB);
    ((esl)localObject1).Scene = this.scene;
    if (localObject2 == null)
    {
      ((esl)localObject1).BsI = new SKBuiltinBuffer_t();
      ((esl)localObject1).KZk = this.jlB;
      ((esl)localObject1).Nln = "0";
      ((esl)localObject1).jeU = 1;
      ((esl)localObject1).Nlp = 2;
      ((esl)localObject1).KXP = 0;
      ((esl)localObject1).NpC = this.jvN.biA();
      if (((esl)localObject1).NpC == null) {}
      for (i = 0;; i = ((esl)localObject1).NpC.size())
      {
        ((esl)localObject1).NpB = i;
        ((esl)localObject1).MRM = this.jvR;
        ((esl)localObject1).NpD = this.jvS;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((esl)localObject1).NpC.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((dqi)((Iterator)localObject1).next()).MTo).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      Log.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).jwQ = true;
    if (this.jvP)
    {
      ((h.a)localObject2).jwR = true;
      ((esl)localObject1).BsI = new SKBuiltinBuffer_t();
      Log.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((esl)localObject1).KZk = this.jlB;
      ((esl)localObject1).Nln = ((h.a)localObject2).jwP;
      if (!((h.a)localObject2).jwR) {
        break label836;
      }
      i = 1;
      label417:
      ((esl)localObject1).jeU = i;
      ((esl)localObject1).Nlp = 2;
      i = ((h.a)localObject2).jwT + 1;
      ((h.a)localObject2).jwT = i;
      ((esl)localObject1).KXP = i;
      ((esl)localObject1).NpC = this.jvN.biA();
      if (((esl)localObject1).NpC != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((esl)localObject1).NpC.size())
    {
      ((esl)localObject1).NpB = i;
      ((esl)localObject1).MRM = this.jvR;
      ((esl)localObject1).NpD = this.jvS;
      Log.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { f.apq(), this.filename, Integer.valueOf(((h.a)localObject2).jwS), Integer.valueOf(this.jlB), Integer.valueOf(this.jvQ), Integer.valueOf(((esl)localObject1).BsI.getILen()), Boolean.valueOf(((h.a)localObject2).jwR), Integer.valueOf(((esl)localObject1).KXP), ((esl)localObject1).NpC, ((esl)localObject1).MRM, Integer.valueOf(((esl)localObject1).Scene) });
      i = this.jlB;
      this.jlB = (((esl)localObject1).BsI.getILen() + i);
      Log.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).jwP, Integer.valueOf(this.jlB) });
      if (((h.a)localObject2).jwT == 1) {
        Log.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      Log.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.jvQ > this.jvU) {
        this.jvQ = this.jvU;
      }
      for (((h.a)localObject2).jwR = false;; ((h.a)localObject2).jwR = true) {
        do
        {
          byte[] arrayOfByte = com.tencent.mm.vfs.s.aW(this.filename, this.jlB, this.jvQ);
          ((esl)localObject1).BsI = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          break;
        } while ((this.jvQ > this.jvU) || ((((h.a)localObject2).jwS == 2147483647) && (!this.jul)));
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148521);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { f.apq(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      Log.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { Util.getStack(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (esl)((d)params).iLK.iLR;
    params = (esn)((d)params).iLL.iLR;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.NetSceneNewVoiceInput", f.apq() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      bis();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.Nln, Integer.valueOf(paramArrayOfByte.KXP), Long.valueOf(System.currentTimeMillis()) });
    this.jvN.aI(params.NpG);
    if ((this.jvN.biB()) && (this.jul))
    {
      Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      bit();
    }
    this.jvT = new String[] { this.jvN.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (params.NpH <= 0)
    {
      paramInt1 = this.jvU;
      this.jvU = paramInt1;
      if (params.MML >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = params.MML)
    {
      this.gTn = paramInt1;
      Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.jvU), Integer.valueOf(this.gTn) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = params.NpH;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148520);
    Log.w("MicroMsg.NetSceneNewVoiceInput", f.apq() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == q.a.iMn)
    {
      bis();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
  
  public final void ul(int paramInt)
  {
    AppMethodBeat.i(148524);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { f.apq(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.jvN.ul(paramInt);
    AppMethodBeat.o(148524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */