package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.f.a.pz;
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
  private static Object fnq;
  private static g qdW;
  private long mDuration;
  private String mFilePath;
  private long mStartTime;
  public a qdH;
  public boolean qdI;
  private Object qdJ;
  public RecordParam qdK;
  a qdL;
  private com.tencent.mm.plugin.appbrand.media.record.a.d qdM;
  private boolean qdN;
  private int qdO;
  private long qdP;
  private int qdQ;
  private MMHandler qdR;
  boolean qdS;
  boolean qdT;
  private a.a qdU;
  private d.a qdV;
  private e qdX;
  private MTimerHandler qdu;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new g.1());
    fnq = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.qdH = null;
    this.qdI = false;
    this.qdJ = new Object();
    this.qdL = a.qea;
    this.qdM = null;
    this.qdN = false;
    this.qdO = 0;
    this.qdu = null;
    this.mDuration = 0L;
    this.qdP = 0L;
    this.qdQ = 0;
    this.mStartTime = 0L;
    this.qdS = false;
    this.qdT = false;
    this.qdU = new a.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        Log.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.kv(1);
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
          if (locala.frx != null) {}
          for (int i = locala.frx.frU;; i = 20)
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
              if ((g.e(g.this) == null) || (!"mp3".equalsIgnoreCase(g.e(g.this).oAc))) {
                break;
              }
              j.BZ(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.e(g.this) == null) || (!"aac".equalsIgnoreCase(g.e(g.this).oAc))) {
                break label204;
              }
              j.BZ(23);
            }
          }
        }
        label204:
        AppMethodBeat.o(146156);
      }
    };
    this.qdV = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        Log.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        pz localpz = new pz();
        localpz.fOH.state = "frameRecorded";
        if (((g)localObject).qdK != null) {
          localpz.fOH.appId = ((g)localObject).qdK.appId;
        }
        localpz.fOH.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localpz.fOH.frameBuffer = ((byte[])localObject);
        localpz.fOH.fOI = paramAnonymousBoolean;
        EventCenter.instance.asyncPublish(localpz, Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.qdX = new e()
    {
      public final void cbl()
      {
        AppMethodBeat.i(146154);
        if (!g.l(g.this))
        {
          g.this.cbv();
          AppMethodBeat.o(146154);
          return;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void cbm()
      {
        AppMethodBeat.i(146155);
        if (g.l(g.this))
        {
          g localg = g.this;
          localg.qdT = false;
          Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          pz localpz = new pz();
          localpz.fOH.action = 7;
          localpz.fOH.state = "interruptionEnd";
          if (localg.qdK != null) {
            localpz.fOH.appId = localg.qdK.appId;
          }
          EventCenter.instance.asyncPublish(localpz, Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        Log.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean aeV()
  {
    AppMethodBeat.i(146172);
    Log.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.qdH != null)
    {
      this.qdH.aeJ();
      this.qdH = null;
      Log.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.qdH == null)
    {
      this.qdH = new a(this.qdK);
      this.qdH.qeH = this.qdU;
    }
    a locala = this.qdH;
    Log.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.frx != null)
    {
      locala.frx.aeJ();
      locala.frx = null;
    }
    locala.qeG = System.currentTimeMillis();
    Log.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.qeG) });
    locala.frx = new c(locala.sampleRate, locala.channelCount, locala.frY);
    if ("mp3".equalsIgnoreCase(locala.qeF.oAc))
    {
      locala.frx.kD(40);
      locala.frx.dC(false);
      locala.frx.fsk = locala.qeI;
      locala.frx.kE(locala.qeF.qeN.pEW);
      if (!locala.frx.aeU()) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.frx.kD(20);
      break;
    }
  }
  
  public static g cbq()
  {
    AppMethodBeat.i(146170);
    synchronized (fnq)
    {
      if (qdW == null) {
        qdW = new g();
      }
      g localg = qdW;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean cbr()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    Log.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.qdM != null)
    {
      this.qdM.close();
      this.qdM = null;
    }
    this.mFilePath = h.eH(this.qdK.oAc, this.qdK.jvr);
    Log.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.qdM = com.tencent.mm.plugin.appbrand.media.record.a.b.akF(this.qdK.oAc);
    if (this.qdM != null)
    {
      boolean bool2 = h.akC(this.mFilePath);
      if (!bool2)
      {
        Log.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.qdM.j(this.mFilePath, this.qdK.sampleRate, this.qdK.qeK, this.qdK.qeL);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.qdM.a(this.qdV);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void cbt()
  {
    AppMethodBeat.i(146175);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (adI())
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.qdH == null) {
          continue;
        }
        bool = this.qdH.aeJ();
        this.qdH = null;
        this.qdN = true;
        Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.qdO) });
        if (this.qdM != null)
        {
          this.qdM.flush();
          this.qdM.close();
          this.qdM = null;
        }
        cbu().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.k(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!adH()) {
          continue;
        }
        Log.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        pz localpz;
        long l1;
        long l2;
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        kv(9);
        Log.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.qdL = a.qee;
      this.qdI = false;
      localpz = new pz();
      localpz.fOH.action = 2;
      localpz.fOH.state = "stop";
      if (this.qdK != null) {
        localpz.fOH.appId = this.qdK.appId;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.qdO), Integer.valueOf(this.qdQ) });
      localpz.fOH.duration = Math.min(this.qdO, this.qdQ);
      localpz.fOH.filePath = this.mFilePath;
      localpz.fOH.fileSize = ((int)h.akD(this.mFilePath));
      EventCenter.instance.asyncPublish(localpz, Looper.getMainLooper());
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.qdK = null;
      d.cbk();
      AppMethodBeat.o(146175);
      return;
      Log.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.qdQ) });
      this.qdQ = ((int)(this.qdQ + l2));
      this.qdP = (this.mDuration - this.qdQ);
      Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.qdP), Integer.valueOf(this.qdQ) });
    }
  }
  
  private MMHandler cbu()
  {
    AppMethodBeat.i(146176);
    if (this.qdR == null) {
      this.qdR = new MMHandler(Looper.getMainLooper());
    }
    MMHandler localMMHandler = this.qdR;
    AppMethodBeat.o(146176);
    return localMMHandler;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.qdu != null) {
      this.qdu.stopTimer();
    }
    this.qdu = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean adH()
  {
    return this.qdL == a.qed;
  }
  
  public final boolean adI()
  {
    return this.qdL == a.qee;
  }
  
  public final boolean aeJ()
  {
    AppMethodBeat.i(146171);
    Log.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.qdH == null) && (this.qdM == null))
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
  
  final void cbs()
  {
    AppMethodBeat.i(146174);
    Log.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (adH())
        {
          Log.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.qdH == null) {
          break label416;
        }
        bool1 = this.qdH.aeJ();
        this.qdH = null;
        if ((this.qdK != null) && (this.qdK.qeO != null))
        {
          boolean bool2 = this.qdK.qeO.cbn();
          Log.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.qdT), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.qdT)) {
            cbv();
          }
        }
        cbu().post(new Runnable()
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
        Log.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.qdQ) });
        this.qdQ = ((int)(this.qdQ + l2));
        this.qdP = (this.mDuration - this.qdQ);
        Log.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.qdP), Integer.valueOf(this.qdQ) });
      }
      catch (Exception localException)
      {
        pz localpz;
        Log.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        kv(8);
        Log.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(146174);
        return;
      }
      Log.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        Log.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.qdL = a.qed;
        this.qdI = false;
        localpz = new pz();
        localpz.fOH.action = 3;
        localpz.fOH.state = "pause";
        if (this.qdK != null) {
          localpz.fOH.appId = this.qdK.appId;
        }
        EventCenter.instance.asyncPublish(localpz, Looper.getMainLooper());
        Log.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void cbv()
  {
    AppMethodBeat.i(146178);
    this.qdT = true;
    Log.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    pz localpz = new pz();
    localpz.fOH.action = 6;
    localpz.fOH.state = "interruptionBegin";
    if (this.qdK != null) {
      localpz.fOH.appId = this.qdK.appId;
    }
    EventCenter.instance.asyncPublish(localpz, Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  protected final void kv(int paramInt)
  {
    AppMethodBeat.i(146177);
    Log.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.qdL != a.qef) {
      j.BY(paramInt);
    }
    this.qdL = a.qef;
    this.qdI = false;
    pz localpz = new pz();
    localpz.fOH.action = 4;
    localpz.fOH.state = "error";
    if (this.qdK != null) {
      localpz.fOH.appId = this.qdK.appId;
    }
    localpz.fOH.errCode = paramInt;
    localpz.fOH.errMsg = i.BW(paramInt);
    EventCenter.instance.asyncPublish(localpz, Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      qea = new a("INITIALIZING", 0);
      qeb = new a("START", 1);
      qec = new a("RESUME", 2);
      qed = new a("PAUSE", 3);
      qee = new a("STOP", 4);
      qef = new a("ERROR", 5);
      qeg = new a[] { qea, qeb, qec, qed, qee, qef };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */