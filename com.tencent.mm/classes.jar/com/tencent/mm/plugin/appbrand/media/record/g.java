package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.pc;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class g
{
  private static Object duI;
  private static g ndF;
  private com.tencent.mm.plugin.appbrand.media.record.a.d dBg;
  public boolean dBi;
  private long mDuration;
  private String mFilePath;
  private long mStartTime;
  private MMHandler ndA;
  boolean ndB;
  boolean ndC;
  private a.a ndD;
  private d.a ndE;
  private e ndG;
  private MTimerHandler ndf;
  public a nds;
  private Object ndt;
  public RecordParam ndu;
  a ndv;
  private boolean ndw;
  private int ndx;
  private long ndy;
  private int ndz;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new g.1());
    duI = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.nds = null;
    this.dBi = false;
    this.ndt = new Object();
    this.ndv = a.ndJ;
    this.dBg = null;
    this.ndw = false;
    this.ndx = 0;
    this.ndf = null;
    this.mDuration = 0L;
    this.ndy = 0L;
    this.ndz = 0;
    this.mStartTime = 0L;
    this.ndB = false;
    this.ndC = false;
    this.ndD = new a.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        Log.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
          a locala = g.b(g.this);
          if (locala.dyI != null) {}
          for (int i = locala.dyI.dzf;; i = 20)
          {
            g.a(localg, i + j);
            try
            {
              if (!g.a(g.this).a(g.d(g.this), paramAnonymousArrayOfByte, paramAnonymousInt)) {
                Log.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
              }
              AppMethodBeat.o(146156);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramAnonymousArrayOfByte, "onRecPcmDataReady", new Object[0]);
              if ((g.e(g.this) == null) || (!"mp3".equalsIgnoreCase(g.e(g.this).lEB))) {
                break;
              }
              j.yz(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.e(g.this) == null) || (!"aac".equalsIgnoreCase(g.e(g.this).lEB))) {
                break label204;
              }
              j.yz(23);
            }
          }
        }
        label204:
        AppMethodBeat.o(146156);
      }
    };
    this.ndE = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        Log.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        pc localpc = new pc();
        localpc.dVf.state = "frameRecorded";
        if (((g)localObject).ndu != null) {
          localpc.dVf.appId = ((g)localObject).ndu.appId;
        }
        localpc.dVf.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localpc.dVf.frameBuffer = ((byte[])localObject);
        localpc.dVf.dVg = paramAnonymousBoolean;
        EventCenter.instance.asyncPublish(localpc, Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.ndG = new e()
    {
      public final void bOV()
      {
        AppMethodBeat.i(146154);
        if (!g.l(g.this))
        {
          g.this.bPf();
          AppMethodBeat.o(146154);
          return;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void bOW()
      {
        AppMethodBeat.i(146155);
        if (g.l(g.this))
        {
          g localg = g.this;
          localg.ndC = false;
          Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          pc localpc = new pc();
          localpc.dVf.action = 7;
          localpc.dVf.state = "interruptionEnd";
          if (localg.ndu != null) {
            localpc.dVf.appId = localg.ndu.appId;
          }
          EventCenter.instance.asyncPublish(localpc, Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean aaj()
  {
    AppMethodBeat.i(146172);
    Log.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.nds != null)
    {
      this.nds.ZZ();
      this.nds = null;
      Log.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.nds == null)
    {
      this.nds = new a(this.ndu);
      this.nds.neq = this.ndD;
    }
    a locala = this.nds;
    Log.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.dyI != null)
    {
      locala.dyI.ZZ();
      locala.dyI = null;
    }
    locala.nep = System.currentTimeMillis();
    Log.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.nep) });
    locala.dyI = new c(locala.sampleRate, locala.channelCount, locala.dzj);
    if ("mp3".equalsIgnoreCase(locala.neo.lEB))
    {
      locala.dyI.jk(40);
      locala.dyI.dc(false);
      locala.dyI.dzv = locala.ner;
      locala.dyI.setAudioSource(locala.neo.neu.mFN);
      if (!locala.dyI.aai()) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.dyI.jk(20);
      break;
    }
  }
  
  public static g bPa()
  {
    AppMethodBeat.i(146170);
    synchronized (duI)
    {
      if (ndF == null) {
        ndF = new g();
      }
      g localg = ndF;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean bPb()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    Log.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.dBg != null)
    {
      this.dBg.close();
      this.dBg = null;
    }
    this.mFilePath = h.et(this.ndu.lEB, this.ndu.gLc);
    Log.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.dBg = com.tencent.mm.plugin.appbrand.media.record.a.b.acL(this.ndu.lEB);
    if (this.dBg != null)
    {
      boolean bool2 = h.acI(this.mFilePath);
      if (!bool2)
      {
        Log.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.dBg.i(this.mFilePath, this.ndu.sampleRate, this.ndu.mFQ, this.ndu.mFR);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.dBg.a(this.ndE);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void bPd()
  {
    AppMethodBeat.i(146175);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (YZ())
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.nds == null) {
          continue;
        }
        bool = this.nds.ZZ();
        this.nds = null;
        this.ndw = true;
        Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.ndx) });
        if (this.dBg != null)
        {
          this.dBg.flush();
          this.dBg.close();
          this.dBg = null;
        }
        bPe().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.k(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!YY()) {
          continue;
        }
        Log.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        pc localpc;
        long l1;
        long l2;
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        onError(9);
        Log.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.ndv = a.ndN;
      this.dBi = false;
      localpc = new pc();
      localpc.dVf.action = 2;
      localpc.dVf.state = "stop";
      if (this.ndu != null) {
        localpc.dVf.appId = this.ndu.appId;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.ndx), Integer.valueOf(this.ndz) });
      localpc.dVf.duration = Math.min(this.ndx, this.ndz);
      localpc.dVf.filePath = this.mFilePath;
      localpc.dVf.fileSize = ((int)h.acJ(this.mFilePath));
      EventCenter.instance.asyncPublish(localpc, Looper.getMainLooper());
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.ndu = null;
      d.bOU();
      AppMethodBeat.o(146175);
      return;
      Log.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.ndz) });
      this.ndz = ((int)(this.ndz + l2));
      this.ndy = (this.mDuration - this.ndz);
      Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.ndy), Integer.valueOf(this.ndz) });
    }
  }
  
  private MMHandler bPe()
  {
    AppMethodBeat.i(146176);
    if (this.ndA == null) {
      this.ndA = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.ndA;
    AppMethodBeat.o(146176);
    return localMMHandler;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.ndf != null) {
      this.ndf.stopTimer();
    }
    this.ndf = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean YY()
  {
    return this.ndv == a.ndM;
  }
  
  public final boolean YZ()
  {
    return this.ndv == a.ndN;
  }
  
  public final boolean ZZ()
  {
    AppMethodBeat.i(146171);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.nds == null) && (this.dBg == null))
    {
      Log.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
      AppMethodBeat.o(146171);
      return false;
    }
    ThreadPool.post(new Runnable()
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
  
  final void bPc()
  {
    AppMethodBeat.i(146174);
    Log.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (YY())
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.nds == null) {
          break label416;
        }
        bool1 = this.nds.ZZ();
        this.nds = null;
        if ((this.ndu != null) && (this.ndu.nev != null))
        {
          boolean bool2 = this.ndu.nev.bOX();
          Log.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.ndC), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.ndC)) {
            bPf();
          }
        }
        bPe().post(new Runnable()
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
        Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.ndz) });
        this.ndz = ((int)(this.ndz + l2));
        this.ndy = (this.mDuration - this.ndz);
        Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.ndy), Integer.valueOf(this.ndz) });
      }
      catch (Exception localException)
      {
        pc localpc;
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        onError(8);
        Log.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(146174);
        return;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        Log.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.ndv = a.ndM;
        this.dBi = false;
        localpc = new pc();
        localpc.dVf.action = 3;
        localpc.dVf.state = "pause";
        if (this.ndu != null) {
          localpc.dVf.appId = this.ndu.appId;
        }
        EventCenter.instance.asyncPublish(localpc, Looper.getMainLooper());
        Log.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void bPf()
  {
    AppMethodBeat.i(146178);
    this.ndC = true;
    Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    pc localpc = new pc();
    localpc.dVf.action = 6;
    localpc.dVf.state = "interruptionBegin";
    if (this.ndu != null) {
      localpc.dVf.appId = this.ndu.appId;
    }
    EventCenter.instance.asyncPublish(localpc, Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  protected final void onError(int paramInt)
  {
    AppMethodBeat.i(146177);
    Log.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.ndv != a.ndO) {
      j.yy(paramInt);
    }
    this.ndv = a.ndO;
    this.dBi = false;
    pc localpc = new pc();
    localpc.dVf.action = 4;
    localpc.dVf.state = "error";
    if (this.ndu != null) {
      localpc.dVf.appId = this.ndu.appId;
    }
    localpc.dVf.errCode = paramInt;
    localpc.dVf.errMsg = i.yw(paramInt);
    EventCenter.instance.asyncPublish(localpc, Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      ndJ = new a("INITIALIZING", 0);
      ndK = new a("START", 1);
      ndL = new a("RESUME", 2);
      ndM = new a("PAUSE", 3);
      ndN = new a("STOP", 4);
      ndO = new a("ERROR", 5);
      ndP = new a[] { ndJ, ndK, ndL, ndM, ndN, ndO };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */