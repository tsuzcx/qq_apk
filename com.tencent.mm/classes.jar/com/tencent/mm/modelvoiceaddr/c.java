package com.tencent.mm.modelvoiceaddr;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dle;
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
  private com.tencent.mm.al.g callback;
  private int fWw;
  private String filename;
  private boolean hCh;
  public h hDI;
  private boolean hDJ;
  private boolean hDK;
  private int hDL;
  private cmf hDM;
  private int hDN;
  private String[] hDO;
  private int hDP;
  private ap hDQ;
  private int htz;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.fWw = 120;
    this.hCh = false;
    this.hDJ = false;
    this.hDK = false;
    this.htz = 0;
    this.hDL = 0;
    this.filename = null;
    this.hDM = null;
    this.scene = 0;
    this.hDO = new String[0];
    this.hDP = 3960;
    this.hDQ = new ap(com.tencent.mm.kernel.g.afE().EUN.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148514);
        if (paramAnonymousMessage.what != 291)
        {
          AppMethodBeat.o(148514);
          return;
        }
        if (c.this.aDM()) {
          com.tencent.mm.kernel.g.aeS().a(c.this, 0);
        }
        AppMethodBeat.o(148514);
      }
    };
    this.filename = paramString1;
    this.hDI = paramh;
    this.hDM = new cmf().aEE(paramString2);
    this.hDN = paramInt;
    this.scene = 10;
    ad.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.fWw = 120;
    this.hCh = false;
    this.hDJ = false;
    this.hDK = false;
    this.htz = 0;
    this.hDL = 0;
    this.filename = null;
    this.hDM = null;
    this.scene = 0;
    this.hDO = new String[0];
    this.hDP = 3960;
    this.hDQ = new ap(com.tencent.mm.kernel.g.afE().EUN.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148514);
        if (paramAnonymousMessage.what != 291)
        {
          AppMethodBeat.o(148514);
          return;
        }
        if (c.this.aDM()) {
          com.tencent.mm.kernel.g.aeS().a(c.this, 0);
        }
        AppMethodBeat.o(148514);
      }
    };
    this.filename = paramString1;
    this.hDI = new h(paramString2);
    this.hDM = new cmf().aEE(paramString3);
    this.hDN = paramInt1;
    this.scene = paramInt2;
    ad.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void aDO()
  {
    AppMethodBeat.i(148523);
    ad.d("MicroMsg.NetSceneNewVoiceInput", f.XJ());
    if (this.hDQ != null) {
      this.hDQ.removeMessages(291);
    }
    this.hDJ = true;
    AppMethodBeat.o(148523);
  }
  
  public final void aDH()
  {
    this.hCh = true;
  }
  
  public final String[] aDI()
  {
    return this.hDO;
  }
  
  public final long aDJ()
  {
    return 0L;
  }
  
  public final int aDK()
  {
    return this.retCode;
  }
  
  public final List<String> aDL()
  {
    AppMethodBeat.i(148515);
    h localh = this.hDI;
    ArrayList localArrayList = new ArrayList();
    localh.hEJ.readLock().lock();
    Iterator localIterator = localh.hEI.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.hEM) {
        localArrayList.add(locala.hEL);
      }
    }
    localh.hEJ.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean aDM()
  {
    AppMethodBeat.i(148518);
    ad.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.hDQ.removeMessages(291);
    if (((this.hDI.aDW()) && (this.hCh)) || (this.hDJ))
    {
      ad.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.hDI.pd(this.htz);
    if (locala != null)
    {
      long l1 = i.aMN(this.filename);
      long l2 = Math.min(l1, locala.hEO);
      ad.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.hEO), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        ad.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (f.getLine() + 40000);
        this.hDL = 0;
        aDN();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.hDL = ((int)(l2 - this.htz));
      if (this.hDL < 0)
      {
        ad.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.hDL) });
        this.retCode = (f.getLine() + 40000);
        this.hDQ.sendEmptyMessageDelayed(291, this.fWw * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      ad.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.hDL), Integer.valueOf(locala.hEP), Integer.valueOf(this.fWw) });
      if ((this.hDL < 500) && (locala.hEP > 5))
      {
        ad.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.hDL) });
        this.hDQ.sendEmptyMessageDelayed(291, this.fWw * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.hDQ.sendEmptyMessageDelayed(291, this.fWw);
      }
    }
    this.hDQ.sendEmptyMessageDelayed(291, this.fWw * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void aDN()
  {
    AppMethodBeat.i(148522);
    ad.d("MicroMsg.NetSceneNewVoiceInput", f.XJ());
    if (this.hDK)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.hDK = true;
    aDO();
    com.tencent.mm.kernel.g.aeS().nF(hashCode());
    final h.a locala = this.hDI.pd(this.htz);
    if (locala != null)
    {
      this.hDL = 0;
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148513);
          ad.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { locala.hEL, Integer.valueOf(locala.hEO), Integer.valueOf(c.this.hashCode()) });
          com.tencent.mm.kernel.g.aeS().a(c.this, 0);
          AppMethodBeat.o(148513);
        }
      });
    }
    AppMethodBeat.o(148522);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(148519);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new dlc();
    paramg.gUV = new dle();
    paramg.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramg.funcId = 235;
    paramg.reqCmdId = 381;
    paramg.respCmdId = 1000000381;
    paramg = paramg.atI();
    paramg.getReqObj().setShortSupport(false);
    Object localObject1 = (dlc)paramg.gUS.gUX;
    Object localObject2 = this.hDI.pd(this.htz);
    ((dlc)localObject1).Scene = this.scene;
    if (localObject2 == null)
    {
      ((dlc)localObject1).uKT = new SKBuiltinBuffer_t();
      ((dlc)localObject1).CNt = this.htz;
      ((dlc)localObject1).ExD = "0";
      ((dlc)localObject1).hno = 1;
      ((dlc)localObject1).ExF = 2;
      ((dlc)localObject1).CLY = 0;
      ((dlc)localObject1).EAN = this.hDI.aDV();
      if (((dlc)localObject1).EAN == null) {}
      for (i = 0;; i = ((dlc)localObject1).EAN.size())
      {
        ((dlc)localObject1).EAM = i;
        ((dlc)localObject1).EfP = this.hDM;
        ((dlc)localObject1).EAO = this.hDN;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((dlc)localObject1).EAN.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((cmf)((Iterator)localObject1).next()).Ehn).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      ad.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).hEM = true;
    if (this.hDK)
    {
      ((h.a)localObject2).hEN = true;
      ((dlc)localObject1).uKT = new SKBuiltinBuffer_t();
      ad.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((dlc)localObject1).CNt = this.htz;
      ((dlc)localObject1).ExD = ((h.a)localObject2).hEL;
      if (!((h.a)localObject2).hEN) {
        break label836;
      }
      i = 1;
      label417:
      ((dlc)localObject1).hno = i;
      ((dlc)localObject1).ExF = 2;
      i = ((h.a)localObject2).hEP + 1;
      ((h.a)localObject2).hEP = i;
      ((dlc)localObject1).CLY = i;
      ((dlc)localObject1).EAN = this.hDI.aDV();
      if (((dlc)localObject1).EAN != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((dlc)localObject1).EAN.size())
    {
      ((dlc)localObject1).EAM = i;
      ((dlc)localObject1).EfP = this.hDM;
      ((dlc)localObject1).EAO = this.hDN;
      ad.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { f.XJ(), this.filename, Integer.valueOf(((h.a)localObject2).hEO), Integer.valueOf(this.htz), Integer.valueOf(this.hDL), Integer.valueOf(((dlc)localObject1).uKT.getILen()), Boolean.valueOf(((h.a)localObject2).hEN), Integer.valueOf(((dlc)localObject1).CLY), ((dlc)localObject1).EAN, ((dlc)localObject1).EfP, Integer.valueOf(((dlc)localObject1).Scene) });
      i = this.htz;
      this.htz = (((dlc)localObject1).uKT.getILen() + i);
      ad.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).hEL, Integer.valueOf(this.htz) });
      if (((h.a)localObject2).hEP == 1) {
        ad.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      ad.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(parame, paramg, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.hDL > this.hDP) {
        this.hDL = this.hDP;
      }
      for (((h.a)localObject2).hEN = false;; ((h.a)localObject2).hEN = true) {
        do
        {
          byte[] arrayOfByte = i.aR(this.filename, this.htz, this.hDL);
          ((dlc)localObject1).uKT = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          break;
        } while ((this.hDL > this.hDP) || ((((h.a)localObject2).hEO == 2147483647) && (!this.hCh)));
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
    ad.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { f.XJ(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      ad.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { bt.eGN(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (dlc)((b)paramq).gUS.gUX;
    paramq = (dle)((b)paramq).gUT.gUX;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.i("MicroMsg.NetSceneNewVoiceInput", f.XJ() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      aDN();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    ad.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.ExD, Integer.valueOf(paramArrayOfByte.CLY), Long.valueOf(System.currentTimeMillis()) });
    this.hDI.aB(paramq.EAR);
    if ((this.hDI.aDW()) && (this.hCh))
    {
      ad.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      aDO();
    }
    this.hDO = new String[] { this.hDI.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (paramq.EAS <= 0)
    {
      paramInt1 = this.hDP;
      this.hDP = paramInt1;
      if (paramq.Ebx >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = paramq.Ebx)
    {
      this.fWw = paramInt1;
      ad.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.hDP), Integer.valueOf(this.fWw) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = paramq.EAS;
      break;
    }
  }
  
  public final void pc(int paramInt)
  {
    AppMethodBeat.i(148524);
    ad.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { f.XJ(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.hDI.pc(paramInt);
    AppMethodBeat.o(148524);
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148520);
    ad.w("MicroMsg.NetSceneNewVoiceInput", f.XJ() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == n.a.gVy)
    {
      aDN();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */