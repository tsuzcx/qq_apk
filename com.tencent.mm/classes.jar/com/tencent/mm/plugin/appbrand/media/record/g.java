package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class g
{
  private static Object cTX;
  private static g kQT;
  private com.tencent.mm.plugin.appbrand.media.record.a.d dag;
  public boolean dai;
  public com.tencent.mm.plugin.appbrand.media.record.record_imp.a kQH;
  public RecordParam kQI;
  a kQJ;
  private boolean kQK;
  private int kQL;
  private long kQM;
  private int kQN;
  private ap kQO;
  boolean kQP;
  boolean kQQ;
  private a.a kQR;
  private d.a kQS;
  private e kQU;
  private av kQu;
  private long mDuration;
  private String mFilePath;
  private Object mLockObj;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new g.1());
    cTX = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.kQH = null;
    this.dai = false;
    this.mLockObj = new Object();
    this.kQJ = a.kQX;
    this.dag = null;
    this.kQK = false;
    this.kQL = 0;
    this.kQu = null;
    this.mDuration = 0L;
    this.kQM = 0L;
    this.kQN = 0;
    this.mStartTime = 0L;
    this.kQP = false;
    this.kQQ = false;
    this.kQR = new a.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        ad.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.onError(1);
        AppMethodBeat.o(146157);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146156);
        if ((g.a(g.this) != null) && (g.b(g.this) != null))
        {
          g localg = g.this;
          int j = g.c(g.this);
          com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = g.b(g.this);
          if (locala.cXI != null) {}
          for (int i = locala.cXI.cYf;; i = 20)
          {
            g.a(localg, i + j);
            try
            {
              if (!g.a(g.this).a(g.d(g.this), paramAnonymousArrayOfByte, paramAnonymousInt)) {
                ad.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
              }
              AppMethodBeat.o(146156);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              ad.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramAnonymousArrayOfByte, "onRecPcmDataReady", new Object[0]);
              if ((g.e(g.this) == null) || (!"mp3".equalsIgnoreCase(g.e(g.this).jBY))) {
                break;
              }
              j.th(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.e(g.this) == null) || (!"aac".equalsIgnoreCase(g.e(g.this).jBY))) {
                break label204;
              }
              j.th(23);
            }
          }
        }
        label204:
        AppMethodBeat.o(146156);
      }
    };
    this.kQS = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        ad.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        ns localns = new ns();
        localns.dsO.state = "frameRecorded";
        if (((g)localObject).kQI != null) {
          localns.dsO.appId = ((g)localObject).kQI.appId;
        }
        localns.dsO.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localns.dsO.frameBuffer = ((byte[])localObject);
        localns.dsO.dsP = paramAnonymousBoolean;
        com.tencent.mm.sdk.b.a.ESL.a(localns, Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.kQU = new e()
    {
      public final void bhO()
      {
        AppMethodBeat.i(146154);
        if (!g.l(g.this))
        {
          g.this.bhY();
          AppMethodBeat.o(146154);
          return;
        }
        ad.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void bhP()
      {
        AppMethodBeat.i(146155);
        if (g.l(g.this))
        {
          g localg = g.this;
          localg.kQQ = false;
          ad.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          ns localns = new ns();
          localns.dsO.action = 7;
          localns.dsO.state = "interruptionEnd";
          if (localg.kQI != null) {
            localns.dsO.appId = localg.kQI.appId;
          }
          com.tencent.mm.sdk.b.a.ESL.a(localns, Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        ad.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean Ol()
  {
    AppMethodBeat.i(146172);
    ad.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.kQH != null)
    {
      this.kQH.Ob();
      this.kQH = null;
      ad.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.kQH == null)
    {
      this.kQH = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.kQI);
      this.kQH.kRE = this.kQR;
    }
    com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = this.kQH;
    ad.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.cXI != null)
    {
      locala.cXI.Ob();
      locala.cXI = null;
    }
    locala.kRD = System.currentTimeMillis();
    ad.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.kRD) });
    locala.cXI = new c(locala.sampleRate, locala.channelCount, locala.cYj);
    if ("mp3".equalsIgnoreCase(locala.kRC.jBY))
    {
      locala.cXI.hX(40);
      locala.cXI.cr(false);
      locala.cXI.cYv = locala.kRF;
      locala.cXI.setAudioSource(locala.kRC.kRH.kvZ);
      if (!locala.cXI.Ok()) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.cXI.hX(20);
      break;
    }
  }
  
  public static g bhT()
  {
    AppMethodBeat.i(146170);
    synchronized (cTX)
    {
      if (kQT == null) {
        kQT = new g();
      }
      g localg = kQT;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean bhU()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    ad.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.dag != null)
    {
      this.dag.close();
      this.dag = null;
    }
    this.mFilePath = h.dF(this.kQI.jBY, this.kQI.fGf);
    ad.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.dag = com.tencent.mm.plugin.appbrand.media.record.a.b.KO(this.kQI.jBY);
    if (this.dag != null)
    {
      boolean bool2 = h.KL(this.mFilePath);
      if (!bool2)
      {
        ad.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.dag.i(this.mFilePath, this.kQI.sampleRate, this.kQI.kwc, this.kQI.kwd);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.dag.a(this.kQS);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void bhW()
  {
    AppMethodBeat.i(146175);
    ad.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (Nc())
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.kQH == null) {
          continue;
        }
        bool = this.kQH.Ob();
        this.kQH = null;
        this.kQK = true;
        ad.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.kQL) });
        if (this.dag != null)
        {
          this.dag.flush();
          this.dag.close();
          this.dag = null;
        }
        bhX().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.k(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!Nb()) {
          continue;
        }
        ad.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        ns localns;
        long l1;
        long l2;
        ad.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        onError(9);
        ad.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      ad.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      ad.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.kQJ = a.kRb;
      this.dai = false;
      localns = new ns();
      localns.dsO.action = 2;
      localns.dsO.state = "stop";
      if (this.kQI != null) {
        localns.dsO.appId = this.kQI.appId;
      }
      ad.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.kQL), Integer.valueOf(this.kQN) });
      localns.dsO.duration = Math.min(this.kQL, this.kQN);
      localns.dsO.filePath = this.mFilePath;
      localns.dsO.fileSize = ((int)h.KM(this.mFilePath));
      com.tencent.mm.sdk.b.a.ESL.a(localns, Looper.getMainLooper());
      ad.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.kQI = null;
      d.bhN();
      AppMethodBeat.o(146175);
      return;
      ad.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      ad.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.kQN) });
      this.kQN = ((int)(this.kQN + l2));
      this.kQM = (this.mDuration - this.kQN);
      ad.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.kQM), Integer.valueOf(this.kQN) });
    }
  }
  
  private ap bhX()
  {
    AppMethodBeat.i(146176);
    if (this.kQO == null) {
      this.kQO = new ap(Looper.getMainLooper());
    }
    ap localap = this.kQO;
    AppMethodBeat.o(146176);
    return localap;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    ad.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.kQu != null) {
      this.kQu.stopTimer();
    }
    this.kQu = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean Nb()
  {
    return this.kQJ == a.kRa;
  }
  
  public final boolean Nc()
  {
    return this.kQJ == a.kRb;
  }
  
  public final boolean Ob()
  {
    AppMethodBeat.i(146171);
    ad.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.kQH == null) && (this.dag == null))
    {
      ad.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
      AppMethodBeat.o(146171);
      return false;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146163);
        synchronized (g.f(g.this))
        {
          g.i(g.this);
          AppMethodBeat.o(146163);
          return;
        }
      }
    }, "app_brand_stop_record");
    AppMethodBeat.o(146171);
    return true;
  }
  
  final void bhV()
  {
    AppMethodBeat.i(146174);
    ad.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (Nb())
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.kQH == null) {
          break label416;
        }
        bool1 = this.kQH.Ob();
        this.kQH = null;
        if ((this.kQI != null) && (this.kQI.kRI != null))
        {
          boolean bool2 = this.kQI.kRI.bhQ();
          ad.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.kQQ), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.kQQ)) {
            bhY();
          }
        }
        bhX().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146152);
            g.k(g.this);
            AppMethodBeat.o(146152);
          }
        });
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.mStartTime;
        ad.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.kQN) });
        this.kQN = ((int)(this.kQN + l2));
        this.kQM = (this.mDuration - this.kQN);
        ad.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.kQM), Integer.valueOf(this.kQN) });
      }
      catch (Exception localException)
      {
        ns localns;
        ad.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        onError(8);
        ad.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(146174);
        return;
      }
      ad.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        ad.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.kQJ = a.kRa;
        this.dai = false;
        localns = new ns();
        localns.dsO.action = 3;
        localns.dsO.state = "pause";
        if (this.kQI != null) {
          localns.dsO.appId = this.kQI.appId;
        }
        com.tencent.mm.sdk.b.a.ESL.a(localns, Looper.getMainLooper());
        ad.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void bhY()
  {
    AppMethodBeat.i(146178);
    this.kQQ = true;
    ad.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    ns localns = new ns();
    localns.dsO.action = 6;
    localns.dsO.state = "interruptionBegin";
    if (this.kQI != null) {
      localns.dsO.appId = this.kQI.appId;
    }
    com.tencent.mm.sdk.b.a.ESL.a(localns, Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  protected final void onError(int paramInt)
  {
    AppMethodBeat.i(146177);
    ad.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.kQJ != a.kRc) {
      j.tg(paramInt);
    }
    this.kQJ = a.kRc;
    this.dai = false;
    ns localns = new ns();
    localns.dsO.action = 4;
    localns.dsO.state = "error";
    if (this.kQI != null) {
      localns.dsO.appId = this.kQI.appId;
    }
    localns.dsO.errCode = paramInt;
    localns.dsO.errMsg = i.te(paramInt);
    com.tencent.mm.sdk.b.a.ESL.a(localns, Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      kQX = new a("INITIALIZING", 0);
      kQY = new a("START", 1);
      kQZ = new a("RESUME", 2);
      kRa = new a("PAUSE", 3);
      kRb = new a("STOP", 4);
      kRc = new a("ERROR", 5);
      kRd = new a[] { kQX, kQY, kQZ, kRa, kRb, kRc };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */