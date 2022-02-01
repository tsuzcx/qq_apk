package com.tencent.mm.modelvoiceaddr;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.protocal.protobuf.fcy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  private int interval;
  private int mbD;
  private boolean mjP;
  public h mlq;
  private boolean mlr;
  private boolean mls;
  private int mlt;
  private eaf mlu;
  private int mlv;
  private String[] mlw;
  private int mlx;
  private MMHandler mly;
  private int retCode;
  private int scene;
  
  public c(String paramString1, h paramh, String paramString2, int paramInt)
  {
    AppMethodBeat.i(148517);
    this.retCode = 0;
    this.interval = 120;
    this.mjP = false;
    this.mlr = false;
    this.mls = false;
    this.mbD = 0;
    this.mlt = 0;
    this.filename = null;
    this.mlu = null;
    this.scene = 0;
    this.mlw = new String[0];
    this.mlx = 3960;
    this.mly = new MMHandler(com.tencent.mm.kernel.h.aHJ().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148514);
        if (paramAnonymousMessage.what != 291)
        {
          AppMethodBeat.o(148514);
          return;
        }
        if (c.this.brP()) {
          com.tencent.mm.kernel.h.aGY().a(c.this, 0);
        }
        AppMethodBeat.o(148514);
      }
    };
    this.filename = paramString1;
    this.mlq = paramh;
    this.mlu = new eaf().btQ(paramString2);
    this.mlv = paramInt;
    this.scene = 10;
    Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,container:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramh, paramString2, Integer.valueOf(paramInt), Integer.valueOf(10) });
    AppMethodBeat.o(148517);
  }
  
  public c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148516);
    this.retCode = 0;
    this.interval = 120;
    this.mjP = false;
    this.mlr = false;
    this.mls = false;
    this.mbD = 0;
    this.mlt = 0;
    this.filename = null;
    this.mlu = null;
    this.scene = 0;
    this.mlw = new String[0];
    this.mlx = 3960;
    this.mly = new MMHandler(com.tencent.mm.kernel.h.aHJ().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(148514);
        if (paramAnonymousMessage.what != 291)
        {
          AppMethodBeat.o(148514);
          return;
        }
        if (c.this.brP()) {
          com.tencent.mm.kernel.h.aGY().a(c.this, 0);
        }
        AppMethodBeat.o(148514);
      }
    };
    this.filename = paramString1;
    this.mlq = new h(paramString2);
    this.mlu = new eaf().btQ(paramString3);
    this.mlv = paramInt1;
    this.scene = paramInt2;
    Log.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s, langType:%d, scene:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(148516);
  }
  
  private void brR()
  {
    AppMethodBeat.i(148523);
    Log.d("MicroMsg.NetSceneNewVoiceInput", f.avD());
    if (this.mly != null) {
      this.mly.removeMessages(291);
    }
    this.mlr = true;
    AppMethodBeat.o(148523);
  }
  
  public final void brK()
  {
    this.mjP = true;
  }
  
  public final String[] brL()
  {
    return this.mlw;
  }
  
  public final long brM()
  {
    return 0L;
  }
  
  public final int brN()
  {
    return this.retCode;
  }
  
  public final List<String> brO()
  {
    AppMethodBeat.i(148515);
    h localh = this.mlq;
    ArrayList localArrayList = new ArrayList();
    localh.mmq.readLock().lock();
    Iterator localIterator = localh.mmp.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.mmt) {
        localArrayList.add(locala.mms);
      }
    }
    localh.mmq.readLock().unlock();
    AppMethodBeat.o(148515);
    return localArrayList;
  }
  
  public final boolean brP()
  {
    AppMethodBeat.i(148518);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
    this.mly.removeMessages(291);
    if (((this.mlq.brZ()) && (this.mjP)) || (this.mlr))
    {
      Log.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
      AppMethodBeat.o(148518);
      return false;
    }
    h.a locala = this.mlq.xm(this.mbD);
    if (locala != null)
    {
      long l1 = u.bBQ(this.filename);
      long l2 = Math.min(l1, locala.mmv);
      Log.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.mmv), Long.valueOf(l2) });
      if (l2 <= 0L)
      {
        Log.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", new Object[] { this.filename });
        this.retCode = (f.getLine() + 40000);
        this.mlt = 0;
        brQ();
        if (this.callback != null) {
          this.callback.onSceneEnd(3, -1, "ReadFileLengthError", this);
        }
        AppMethodBeat.o(148518);
        return false;
      }
      this.mlt = ((int)(l2 - this.mbD));
      if (this.mlt < 0)
      {
        Log.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", new Object[] { Integer.valueOf(this.mlt) });
        this.retCode = (f.getLine() + 40000);
        this.mly.sendEmptyMessageDelayed(291, this.interval * 2);
        AppMethodBeat.o(148518);
        return false;
      }
      Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", new Object[] { Integer.valueOf(this.mlt), Integer.valueOf(locala.mmw), Integer.valueOf(this.interval) });
      if ((this.mlt < 500) && (locala.mmw > 5))
      {
        Log.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", new Object[] { Integer.valueOf(this.mlt) });
        this.mly.sendEmptyMessageDelayed(291, this.interval * 2);
      }
      for (;;)
      {
        AppMethodBeat.o(148518);
        return true;
        this.mly.sendEmptyMessageDelayed(291, this.interval);
      }
    }
    this.mly.sendEmptyMessageDelayed(291, this.interval * 2);
    AppMethodBeat.o(148518);
    return true;
  }
  
  public final void brQ()
  {
    AppMethodBeat.i(148522);
    Log.d("MicroMsg.NetSceneNewVoiceInput", f.avD());
    if (this.mls)
    {
      AppMethodBeat.o(148522);
      return;
    }
    this.mls = true;
    brR();
    com.tencent.mm.kernel.h.aGY().vH(hashCode());
    final h.a locala = this.mlq.xm(this.mbD);
    if (locala != null)
    {
      this.mlt = 0;
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(148513);
          Log.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { locala.mms, Integer.valueOf(locala.mmv), Integer.valueOf(c.this.hashCode()) });
          com.tencent.mm.kernel.h.aGY().a(c.this, 0);
          AppMethodBeat.o(148513);
        }
      });
    }
    AppMethodBeat.o(148522);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(148519);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new fcw();
    parami.lBV = new fcy();
    parami.uri = "/cgi-bin/micromsg-bin/voicetrans";
    parami.funcId = 235;
    parami.lBW = 381;
    parami.respCmdId = 1000000381;
    parami = parami.bgN();
    parami.getReqObj().setShortSupport(false);
    Object localObject1 = (fcw)d.b.b(parami.lBR);
    Object localObject2 = this.mlq.xm(this.mbD);
    ((fcw)localObject1).CPw = this.scene;
    if (localObject2 == null)
    {
      ((fcw)localObject1).Hnc = new eae();
      ((fcw)localObject1).Sat = this.mbD;
      ((fcw)localObject1).UxY = "0";
      ((fcw)localObject1).lVs = 1;
      ((fcw)localObject1).Uya = 2;
      ((fcw)localObject1).RYY = 0;
      ((fcw)localObject1).UCy = this.mlq.brY();
      if (((fcw)localObject1).UCy == null) {}
      for (i = 0;; i = ((fcw)localObject1).UCy.size())
      {
        ((fcw)localObject1).UCx = i;
        ((fcw)localObject1).UdT = this.mlu;
        ((fcw)localObject1).UCz = this.mlv;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        localObject1 = ((fcw)localObject1).UCy.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((StringBuilder)localObject2).append(((eaf)((Iterator)localObject1).next()).Ufy).append(", ");
        }
      }
      ((StringBuilder)localObject2).append("]");
      Log.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", new Object[] { ((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(148519);
      return i;
    }
    ((h.a)localObject2).mmt = true;
    if (this.mls)
    {
      ((h.a)localObject2).mmu = true;
      ((fcw)localObject1).Hnc = new eae();
      Log.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
      ((fcw)localObject1).Sat = this.mbD;
      ((fcw)localObject1).UxY = ((h.a)localObject2).mms;
      if (!((h.a)localObject2).mmu) {
        break label836;
      }
      i = 1;
      label417:
      ((fcw)localObject1).lVs = i;
      ((fcw)localObject1).Uya = 2;
      i = ((h.a)localObject2).mmw + 1;
      ((h.a)localObject2).mmw = i;
      ((fcw)localObject1).RYY = i;
      ((fcw)localObject1).UCy = this.mlq.brY();
      if (((fcw)localObject1).UCy != null) {
        break label841;
      }
    }
    label836:
    label841:
    for (int i = 0;; i = ((fcw)localObject1).UCy.size())
    {
      ((fcw)localObject1).UCx = i;
      ((fcw)localObject1).UdT = this.mlu;
      ((fcw)localObject1).UCz = this.mlv;
      Log.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s, scene:%s", new Object[] { f.avD(), this.filename, Integer.valueOf(((h.a)localObject2).mmv), Integer.valueOf(this.mbD), Integer.valueOf(this.mlt), Integer.valueOf(((fcw)localObject1).Hnc.Ufv), Boolean.valueOf(((h.a)localObject2).mmu), Integer.valueOf(((fcw)localObject1).RYY), ((fcw)localObject1).UCy, ((fcw)localObject1).UdT, Integer.valueOf(((fcw)localObject1).CPw) });
      i = this.mbD;
      this.mbD = (((fcw)localObject1).Hnc.Ufv + i);
      Log.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", new Object[] { ((h.a)localObject2).mms, Integer.valueOf(this.mbD) });
      if (((h.a)localObject2).mmw == 1) {
        Log.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      Log.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(148519);
      return i;
      if (this.mlt > this.mlx) {
        this.mlt = this.mlx;
      }
      for (((h.a)localObject2).mmu = false;; ((h.a)localObject2).mmu = true) {
        do
        {
          byte[] arrayOfByte = u.aY(this.filename, this.mbD, this.mlt);
          ((fcw)localObject1).Hnc = new eae().dc(arrayOfByte);
          break;
        } while ((this.mlt > this.mlx) || ((((h.a)localObject2).mmv == 2147483647) && (!this.mjP)));
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148521);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", new Object[] { f.avD(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 3) && (paramInt3 == -1)) {
      Log.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", new Object[] { Util.getStack(), Long.valueOf(Thread.currentThread().getId()) });
    }
    paramArrayOfByte = (fcw)d.b.b(((d)params).lBR);
    params = (fcy)d.c.b(((d)params).lBS);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.NetSceneNewVoiceInput", f.avD() + " onGYNetEnd file: %s errType:%s errCode:%s", new Object[] { this.filename, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      brQ();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148521);
      return;
    }
    Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", new Object[] { paramArrayOfByte.UxY, Integer.valueOf(paramArrayOfByte.RYY), Long.valueOf(System.currentTimeMillis()) });
    this.mlq.aG(params.UCC);
    if ((this.mlq.brZ()) && (this.mjP))
    {
      Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
      brR();
    }
    this.mlw = new String[] { this.mlq.getResult() };
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (params.UCD <= 0)
    {
      paramInt1 = this.mlx;
      this.mlx = paramInt1;
      if (params.TYF >= 0) {
        break label404;
      }
    }
    label404:
    for (paramInt1 = 120;; paramInt1 = params.TYF)
    {
      this.interval = paramInt1;
      Log.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", new Object[] { Integer.valueOf(this.mlx), Integer.valueOf(this.interval) });
      AppMethodBeat.o(148521);
      return;
      paramInt1 = params.UCD;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return 2000;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(148520);
    Log.w("MicroMsg.NetSceneNewVoiceInput", f.avD() + " setSecurityCheckError e: %s", new Object[] { parama });
    if (parama == q.a.lCu)
    {
      brQ();
      this.callback.onSceneEnd(3, -1, "SecurityCheckError", this);
    }
    AppMethodBeat.o(148520);
  }
  
  public final void xl(int paramInt)
  {
    AppMethodBeat.i(148524);
    Log.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", new Object[] { f.avD(), Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(148524);
      throw localIllegalStateException;
    }
    this.mlq.xl(paramInt);
    AppMethodBeat.o(148524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c
 * JD-Core Version:    0.7.0.1
 */