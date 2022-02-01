package com.tencent.mm.modelvoiceaddr;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fzi;
import com.tencent.mm.protocal.protobuf.fzk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
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
  private com.tencent.mm.am.h callback;
  private String filename;
  private int interval;
  private int oUy;
  private boolean pdm;
  public h pfc;
  private boolean pfd;
  private boolean pfe;
  private int pff;
  private etl pfg;
  private int pfh;
  private String[] pfi;
  private int pfj;
  private MMHandler pfk;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.interval = 120;
    this.pdm = false;
    this.pfd = false;
    this.pfe = false;
    this.oUy = 0;
    this.pff = 0;
    this.filename = null;
    this.pfg = null;
    this.scene = 0;
    this.pfi = new String[0];
    this.pfj = 3960;
    this.pfk = new MMHandler(com.tencent.mm.kernel.h.baH().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148514);
        if (paramAnonymousMessage.what != 291)
        {
          AppMethodBeat.o(148514);
          return;
        }
        if (c.this.bPv()) {
          com.tencent.mm.kernel.h.aZW().a(c.this, 0);
        }
        AppMethodBeat.o(148514);
      }
    };
    this.filename = paramString1;
    this.pfc = paramh;
    this.pfg = new etl().btH(paramString2);
    this.pfh = paramInt;
    this.scene = 10;
    Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.interval = 120;
    this.pdm = false;
    this.pfd = false;
    this.pfe = false;
    this.oUy = 0;
    this.pff = 0;
    this.filename = null;
    this.pfg = null;
    this.scene = 0;
    this.pfi = new String[0];
    this.pfj = 3960;
    this.pfk = new MMHandler(com.tencent.mm.kernel.h.baH().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148514);
        if (paramAnonymousMessage.what != 291)
        {
          AppMethodBeat.o(148514);
          return;
        }
        if (c.this.bPv()) {
          com.tencent.mm.kernel.h.aZW().a(c.this, 0);
        }
        AppMethodBeat.o(148514);
      }
    };
    this.filename = paramString1;
    this.pfc = new h(paramString2);
    this.pfg = new etl().btH(paramString3);
    this.pfh = paramInt1;
    this.scene = paramInt2;
    Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void bPx()
  {
    AppMethodBeat.i(148523);
    Log.d("MicroMsg.NetSceneNewVoiceInput", f.aPX());
    if (this.pfk != null) {
      this.pfk.removeMessages(291);
    }
    this.pfd = true;
    AppMethodBeat.o(148523);
  }
  
  public final void bPq()
  {
    this.pdm = true;
  }
  
  public final String[] bPr()
  {
    return this.pfi;
  }
  
  public final long bPs()
  {
    return 0L;
  }
  
  public final int bPt()
  {
    return this.retCode;
  }
  
  public final List<String> bPu()
  {
    AppMethodBeat.i(148515);
    h localh = this.pfc;
    ArrayList localArrayList = new ArrayList();
    localh.pgd.readLock().lock();
    Iterator localIterator = localh.pgc.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.pgg) {
        localArrayList.add(locala.pgf);
      }
    }
    localh.pgd.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean bPv()
  {
    AppMethodBeat.i(148518);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.pfk.removeMessages(291);
    if (((this.pfc.bPF()) && (this.pdm)) || (this.pfd))
    {
      Log.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.pfc.xm(this.oUy);
    if (locala != null)
    {
      long l1 = y.bEl(this.filename);
      long l2 = Math.min(l1, locala.pgi);
      Log.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.pgi), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        Log.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (f.getLine() + 40000);
        this.pff = 0;
        bPw();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.pff = ((int)(l2 - this.oUy));
      if (this.pff < 0)
      {
        Log.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.pff) });
        this.retCode = (f.getLine() + 40000);
        this.pfk.sendEmptyMessageDelayed(291, this.interval * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.pff), Integer.valueOf(locala.pgj), Integer.valueOf(this.interval) });
      if ((this.pff < 500) && (locala.pgj > 5))
      {
        Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.pff) });
        this.pfk.sendEmptyMessageDelayed(291, this.interval * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.pfk.sendEmptyMessageDelayed(291, this.interval);
      }
    }
    this.pfk.sendEmptyMessageDelayed(291, this.interval * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void bPw()
  {
    AppMethodBeat.i(148522);
    Log.d("MicroMsg.NetSceneNewVoiceInput", f.aPX());
    if (this.pfe)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.pfe = true;
    bPx();
    com.tencent.mm.kernel.h.aZW().vM(hashCode());
    final h.a locala = this.pfc.xm(this.oUy);
    if (locala != null)
    {
      this.pff = 0;
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148513);
          Log.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { locala.pgf, Integer.valueOf(locala.pgi), Integer.valueOf(c.this.hashCode()) });
          com.tencent.mm.kernel.h.aZW().a(c.this, 0);
          AppMethodBeat.o(148513);
        }
      });
    }
    AppMethodBeat.o(148522);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(148519);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new fzi();
    paramh.otF = new fzk();
    paramh.uri = "/cgi-bin/micromsg-bin/voicetrans";
    paramh.funcId = 235;
    paramh.otG = 381;
    paramh.respCmdId = 1000000381;
    paramh = paramh.bEF();
    paramh.getReqObj().setShortSupport(false);
    Object localObject1 = (fzi)c.b.b(paramh.otB);
    Object localObject2 = this.pfc.xm(this.oUy);
    ((fzi)localObject1).IJG = this.scene;
    if (localObject2 == null)
    {
      ((fzi)localObject1).NkQ = new gol();
      ((fzi)localObject1).YYs = this.oUy;
      ((fzi)localObject1).abRF = "0";
      ((fzi)localObject1).oOu = 1;
      ((fzi)localObject1).abRH = 2;
      ((fzi)localObject1).YWY = 0;
      ((fzi)localObject1).abWI = this.pfc.bPE();
      if (((fzi)localObject1).abWI == null) {}
      for (i = 0;; i = ((fzi)localObject1).abWI.size())
      {
        ((fzi)localObject1).abWH = i;
        ((fzi)localObject1).abvh = this.pfg;
        ((fzi)localObject1).abWJ = this.pfh;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((fzi)localObject1).abWI.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((etl)((Iterator)localObject1).next()).abwM).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      Log.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(paramg, paramh, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).pgg = true;
    if (this.pfe)
    {
      ((h.a)localObject2).pgh = true;
      ((fzi)localObject1).NkQ = new gol();
      Log.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((fzi)localObject1).YYs = this.oUy;
      ((fzi)localObject1).abRF = ((h.a)localObject2).pgf;
      if (!((h.a)localObject2).pgh) {
        break label833;
      }
      i = 1;
      label414:
      ((fzi)localObject1).oOu = i;
      ((fzi)localObject1).abRH = 2;
      i = ((h.a)localObject2).pgj + 1;
      ((h.a)localObject2).pgj = i;
      ((fzi)localObject1).YWY = i;
      ((fzi)localObject1).abWI = this.pfc.bPE();
      if (((fzi)localObject1).abWI != null) {
        break label838;
      }
    }
    label833:
    label838:
    for (int i = 0;; i = ((fzi)localObject1).abWI.size())
    {
      ((fzi)localObject1).abWH = i;
      ((fzi)localObject1).abvh = this.pfg;
      ((fzi)localObject1).abWJ = this.pfh;
      Log.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { f.aPX(), this.filename, Integer.valueOf(((h.a)localObject2).pgi), Integer.valueOf(this.oUy), Integer.valueOf(this.pff), Integer.valueOf(((fzi)localObject1).NkQ.abwJ), Boolean.valueOf(((h.a)localObject2).pgh), Integer.valueOf(((fzi)localObject1).YWY), ((fzi)localObject1).abWI, ((fzi)localObject1).abvh, Integer.valueOf(((fzi)localObject1).IJG) });
      i = this.oUy;
      this.oUy = (((fzi)localObject1).NkQ.abwJ + i);
      Log.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).pgf, Integer.valueOf(this.oUy) });
      if (((h.a)localObject2).pgj == 1) {
        Log.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      Log.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(paramg, paramh, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.pff > this.pfj) {
        this.pff = this.pfj;
      }
      for (((h.a)localObject2).pgh = false;; ((h.a)localObject2).pgh = true) {
        do
        {
          byte[] arrayOfByte = y.bi(this.filename, this.oUy, this.pff);
          ((fzi)localObject1).NkQ = new gol().df(arrayOfByte);
          break;
        } while ((this.pff > this.pfj) || ((((h.a)localObject2).pgi == 2147483647) && (!this.pdm)));
      }
      i = 0;
      break label414;
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
    Log.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { f.aPX(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      Log.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { Util.getStack(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (fzi)c.b.b(((com.tencent.mm.am.c)params).otB);
    params = (fzk)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.NetSceneNewVoiceInput", f.aPX() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      bPw();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.abRF, Integer.valueOf(paramArrayOfByte.YWY), Long.valueOf(System.currentTimeMillis()) });
    this.pfc.cl(params.abWM);
    if ((this.pfc.bPF()) && (this.pdm))
    {
      Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      bPx();
    }
    this.pfi = new String[] { this.pfc.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (params.abWN <= 0)
    {
      paramInt1 = this.pfj;
      this.pfj = paramInt1;
      if (params.abpC >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = params.abpC)
    {
      this.interval = paramInt1;
      Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.pfj), Integer.valueOf(this.interval) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = params.abWN;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(148520);
    Log.w("MicroMsg.NetSceneNewVoiceInput", f.aPX() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == p.a.oue)
    {
      bPw();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
  
  public final void xl(int paramInt)
  {
    AppMethodBeat.i(148524);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { f.aPX(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.pfc.xl(paramInt);
    AppMethodBeat.o(148524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */