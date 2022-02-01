package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.autogen.a.rm;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class g
{
  private static Object hrB;
  private static g tiL;
  public boolean Kf;
  private long mDuration;
  private String mFilePath;
  private long mStartTime;
  a tiA;
  private com.tencent.mm.plugin.appbrand.media.record.a.d tiB;
  private boolean tiC;
  private int tiD;
  private long tiE;
  private int tiF;
  private MMHandler tiG;
  boolean tiH;
  boolean tiI;
  private a.a tiJ;
  private d.a tiK;
  private e tiM;
  private MTimerHandler tij;
  public a tix;
  private Object tiy;
  public RecordParam tiz;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new g.1());
    hrB = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.tix = null;
    this.Kf = false;
    this.tiy = new Object();
    this.tiA = a.tiP;
    this.tiB = null;
    this.tiC = false;
    this.tiD = 0;
    this.tij = null;
    this.mDuration = 0L;
    this.tiE = 0L;
    this.tiF = 0;
    this.mStartTime = 0L;
    this.tiH = false;
    this.tiI = false;
    this.tiJ = new a.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        Log.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.oc(1);
        AppMethodBeat.o(146157);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146156);
        if ((g.a(g.this) != null) && (g.b(g.this) != null))
        {
          g localg = g.this;
          a locala = g.b(g.this);
          if (locala.hvI != null) {}
          for (int i = locala.hvI.hwi;; i = 20)
          {
            g.a(localg, i);
            try
            {
              if (!g.a(g.this).a(g.c(g.this), paramAnonymousArrayOfByte, paramAnonymousInt)) {
                Log.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
              }
              AppMethodBeat.o(146156);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramAnonymousArrayOfByte, "onRecPcmDataReady", new Object[0]);
              if ((g.d(g.this) == null) || (!"mp3".equalsIgnoreCase(g.d(g.this).rDV))) {
                break;
              }
              j.Co(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.d(g.this) == null) || (!"aac".equalsIgnoreCase(g.d(g.this).rDV))) {
                break label192;
              }
              j.Co(23);
            }
          }
        }
        label192:
        AppMethodBeat.o(146156);
      }
    };
    this.tiK = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        Log.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        rm localrm = new rm();
        localrm.hUA.state = "frameRecorded";
        if (((g)localObject).tiz != null) {
          localrm.hUA.appId = ((g)localObject).tiz.appId;
        }
        localrm.hUA.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localrm.hUA.frameBuffer = ((byte[])localObject);
        localrm.hUA.hUB = paramAnonymousBoolean;
        localrm.asyncPublish(Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.tiM = new e()
    {
      public final void cBF()
      {
        AppMethodBeat.i(146154);
        if (!g.k(g.this))
        {
          g.this.cBP();
          AppMethodBeat.o(146154);
          return;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void cBG()
      {
        AppMethodBeat.i(146155);
        if (g.k(g.this))
        {
          g localg = g.this;
          localg.tiI = false;
          Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          rm localrm = new rm();
          localrm.hUA.action = 7;
          localrm.hUA.state = "interruptionEnd";
          if (localg.tiz != null) {
            localrm.hUA.appId = localg.tiz.appId;
          }
          localrm.asyncPublish(Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean aGS()
  {
    AppMethodBeat.i(146172);
    Log.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.tix != null)
    {
      this.tix.aGH();
      this.tix = null;
      Log.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.tix == null)
    {
      this.tix = new a(this.tiz);
      this.tix.tjv = this.tiJ;
    }
    a locala = this.tix;
    Log.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.hvI != null)
    {
      locala.hvI.aGH();
      locala.hvI = null;
    }
    locala.tju = System.currentTimeMillis();
    Log.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.tju) });
    locala.hvI = new c(locala.sampleRate, locala.channelCount, locala.hwm);
    if ("mp3".equalsIgnoreCase(locala.tjt.rDV))
    {
      locala.hvI.ok(40);
      locala.hvI.eo(false);
      locala.hvI.hwy = locala.tjw;
      locala.hvI.ol(locala.tjt.tjB.sKh);
      if (!locala.hvI.aGR()) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.hvI.ok(20);
      break;
    }
  }
  
  public static g cBK()
  {
    AppMethodBeat.i(146170);
    synchronized (hrB)
    {
      if (tiL == null) {
        tiL = new g();
      }
      g localg = tiL;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean cBL()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    Log.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.tiB != null)
    {
      this.tiB.close();
      this.tiB = null;
    }
    this.mFilePath = h.eY(this.tiz.rDV, this.tiz.lYI);
    Log.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.tiB = com.tencent.mm.plugin.appbrand.media.record.a.b.adL(this.tiz.rDV);
    if (this.tiB != null)
    {
      boolean bool2 = h.adI(this.mFilePath);
      if (!bool2)
      {
        Log.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.tiB.j(this.mFilePath, this.tiz.sampleRate, this.tiz.tjy, this.tiz.tjz);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.tiB.a(this.tiK);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void cBN()
  {
    AppMethodBeat.i(146175);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (aFG())
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.tix == null) {
          continue;
        }
        bool = this.tix.aGH();
        this.tix = null;
        this.tiC = true;
        Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.tiD) });
        if (this.tiB != null)
        {
          this.tiB.flush();
          this.tiB.close();
          this.tiB = null;
        }
        cBO().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.j(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!aFF()) {
          continue;
        }
        Log.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        rm localrm;
        long l1;
        long l2;
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        oc(9);
        Log.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.tiA = a.tiT;
      this.Kf = false;
      localrm = new rm();
      localrm.hUA.action = 2;
      localrm.hUA.state = "stop";
      if (this.tiz != null) {
        localrm.hUA.appId = this.tiz.appId;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.tiD), Integer.valueOf(this.tiF) });
      localrm.hUA.duration = Math.min(this.tiD, this.tiF);
      localrm.hUA.filePath = this.mFilePath;
      localrm.hUA.fileSize = ((int)h.adJ(this.mFilePath));
      localrm.asyncPublish(Looper.getMainLooper());
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.tiz = null;
      d.cBE();
      AppMethodBeat.o(146175);
      return;
      Log.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.tiF) });
      this.tiF = ((int)(this.tiF + l2));
      this.tiE = (this.mDuration - this.tiF);
      Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.tiE), Integer.valueOf(this.tiF) });
    }
  }
  
  private MMHandler cBO()
  {
    AppMethodBeat.i(146176);
    if (this.tiG == null) {
      this.tiG = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.tiG;
    AppMethodBeat.o(146176);
    return localMMHandler;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.tij != null) {
      this.tij.stopTimer();
    }
    this.tij = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean aFF()
  {
    return this.tiA == a.tiS;
  }
  
  public final boolean aFG()
  {
    return this.tiA == a.tiT;
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(146171);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.tix == null) && (this.tiB == null))
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
        synchronized (g.e(g.this))
        {
          g.h(g.this);
          AppMethodBeat.o(146163);
          return;
        }
      }
    }, "app_brand_stop_record");
    AppMethodBeat.o(146171);
    return true;
  }
  
  final void cBM()
  {
    AppMethodBeat.i(146174);
    Log.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (aFF())
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.tix == null) {
          break label413;
        }
        bool1 = this.tix.aGH();
        this.tix = null;
        if ((this.tiz != null) && (this.tiz.tjC != null))
        {
          boolean bool2 = this.tiz.tjC.cBH();
          Log.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.tiI), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.tiI)) {
            cBP();
          }
        }
        cBO().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146152);
            g.j(g.this);
            AppMethodBeat.o(146152);
          }
        });
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.mStartTime;
        Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.tiF) });
        this.tiF = ((int)(this.tiF + l2));
        this.tiE = (this.mDuration - this.tiF);
        Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.tiE), Integer.valueOf(this.tiF) });
      }
      catch (Exception localException)
      {
        rm localrm;
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        oc(8);
        Log.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(146174);
        return;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        Log.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.tiA = a.tiS;
        this.Kf = false;
        localrm = new rm();
        localrm.hUA.action = 3;
        localrm.hUA.state = "pause";
        if (this.tiz != null) {
          localrm.hUA.appId = this.tiz.appId;
        }
        localrm.asyncPublish(Looper.getMainLooper());
        Log.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label413:
      boolean bool1 = false;
    }
  }
  
  protected final void cBP()
  {
    AppMethodBeat.i(146178);
    this.tiI = true;
    Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    rm localrm = new rm();
    localrm.hUA.action = 6;
    localrm.hUA.state = "interruptionBegin";
    if (this.tiz != null) {
      localrm.hUA.appId = this.tiz.appId;
    }
    localrm.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  protected final void oc(int paramInt)
  {
    AppMethodBeat.i(146177);
    Log.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.tiA != a.tiU) {
      j.Cn(paramInt);
    }
    this.tiA = a.tiU;
    this.Kf = false;
    rm localrm = new rm();
    localrm.hUA.action = 4;
    localrm.hUA.state = "error";
    if (this.tiz != null) {
      localrm.hUA.appId = this.tiz.appId;
    }
    localrm.hUA.errCode = paramInt;
    localrm.hUA.errMsg = i.Cl(paramInt);
    localrm.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      tiP = new a("INITIALIZING", 0);
      tiQ = new a("START", 1);
      tiR = new a("RESUME", 2);
      tiS = new a("PAUSE", 3);
      tiT = new a("STOP", 4);
      tiU = new a("ERROR", 5);
      tiV = new a[] { tiP, tiQ, tiR, tiS, tiT, tiU };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */