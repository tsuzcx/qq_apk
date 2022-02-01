package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class g
{
  private static Object ddM;
  private static g lWd;
  private com.tencent.mm.plugin.appbrand.media.record.a.d djW;
  public boolean djY;
  private aw lVE;
  public com.tencent.mm.plugin.appbrand.media.record.record_imp.a lVR;
  public RecordParam lVS;
  a lVT;
  private boolean lVU;
  private int lVV;
  private long lVW;
  private int lVX;
  private aq lVY;
  boolean lVZ;
  boolean lWa;
  private a.a lWb;
  private d.a lWc;
  private e lWe;
  private long mDuration;
  private String mFilePath;
  private Object mLockObj;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new g.1());
    ddM = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.lVR = null;
    this.djY = false;
    this.mLockObj = new Object();
    this.lVT = a.lWh;
    this.djW = null;
    this.lVU = false;
    this.lVV = 0;
    this.lVE = null;
    this.mDuration = 0L;
    this.lVW = 0L;
    this.lVX = 0;
    this.mStartTime = 0L;
    this.lVZ = false;
    this.lWa = false;
    this.lWb = new a.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        ae.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.this.onError(1);
        AppMethodBeat.o(146157);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(146156);
        if ((g.a(g.this) != null) && (g.b(g.this) != null))
        {
          g localg = g.this;
          int j = g.c(g.this);
          com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = g.b(g.this);
          if (locala.dhw != null) {}
          for (int i = locala.dhw.dhT;; i = 20)
          {
            g.a(localg, i + j);
            try
            {
              if (!g.a(g.this).a(g.d(g.this), paramAnonymousArrayOfByte, paramAnonymousInt)) {
                ae.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
              }
              AppMethodBeat.o(146156);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              ae.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramAnonymousArrayOfByte, "onRecPcmDataReady", new Object[0]);
              if ((g.e(g.this) == null) || (!"mp3".equalsIgnoreCase(g.e(g.this).kAi))) {
                break;
              }
              j.uI(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.e(g.this) == null) || (!"aac".equalsIgnoreCase(g.e(g.this).kAi))) {
                break label204;
              }
              j.uI(23);
            }
          }
        }
        label204:
        AppMethodBeat.o(146156);
      }
    };
    this.lWc = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        ae.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        ok localok = new ok();
        localok.dDq.state = "frameRecorded";
        if (((g)localObject).lVS != null) {
          localok.dDq.appId = ((g)localObject).lVS.appId;
        }
        localok.dDq.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localok.dDq.frameBuffer = ((byte[])localObject);
        localok.dDq.dDr = paramAnonymousBoolean;
        com.tencent.mm.sdk.b.a.IvT.a(localok, Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.lWe = new e()
    {
      public final void bts()
      {
        AppMethodBeat.i(146154);
        if (!g.l(g.this))
        {
          g.this.btC();
          AppMethodBeat.o(146154);
          return;
        }
        ae.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void btt()
      {
        AppMethodBeat.i(146155);
        if (g.l(g.this))
        {
          g localg = g.this;
          localg.lWa = false;
          ae.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          ok localok = new ok();
          localok.dDq.action = 7;
          localok.dDq.state = "interruptionEnd";
          if (localg.lVS != null) {
            localok.dDq.appId = localg.lVS.appId;
          }
          com.tencent.mm.sdk.b.a.IvT.a(localok, Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        ae.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean PP()
  {
    AppMethodBeat.i(146172);
    ae.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.lVR != null)
    {
      this.lVR.PF();
      this.lVR = null;
      ae.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.lVR == null)
    {
      this.lVR = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.lVS);
      this.lVR.lWO = this.lWb;
    }
    com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = this.lVR;
    ae.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.dhw != null)
    {
      locala.dhw.PF();
      locala.dhw = null;
    }
    locala.lWN = System.currentTimeMillis();
    ae.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.lWN) });
    locala.dhw = new c(locala.sampleRate, locala.channelCount, locala.dhX);
    if ("mp3".equalsIgnoreCase(locala.lWM.kAi))
    {
      locala.dhw.hQ(40);
      locala.dhw.cu(false);
      locala.dhw.dij = locala.lWP;
      locala.dhw.setAudioSource(locala.lWM.lWR.lyL);
      if (!locala.dhw.PO()) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.dhw.hQ(20);
      break;
    }
  }
  
  private void btA()
  {
    AppMethodBeat.i(146175);
    ae.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (OH())
        {
          ae.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.lVR == null) {
          continue;
        }
        bool = this.lVR.PF();
        this.lVR = null;
        this.lVU = true;
        ae.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.lVV) });
        if (this.djW != null)
        {
          this.djW.flush();
          this.djW.close();
          this.djW = null;
        }
        btB().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.k(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!OG()) {
          continue;
        }
        ae.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        ok localok;
        long l1;
        long l2;
        ae.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        onError(9);
        ae.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      ae.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      ae.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.lVT = a.lWl;
      this.djY = false;
      localok = new ok();
      localok.dDq.action = 2;
      localok.dDq.state = "stop";
      if (this.lVS != null) {
        localok.dDq.appId = this.lVS.appId;
      }
      ae.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.lVV), Integer.valueOf(this.lVX) });
      localok.dDq.duration = Math.min(this.lVV, this.lVX);
      localok.dDq.filePath = this.mFilePath;
      localok.dDq.fileSize = ((int)h.Tf(this.mFilePath));
      com.tencent.mm.sdk.b.a.IvT.a(localok, Looper.getMainLooper());
      ae.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.lVS = null;
      d.btr();
      AppMethodBeat.o(146175);
      return;
      ae.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      ae.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.lVX) });
      this.lVX = ((int)(this.lVX + l2));
      this.lVW = (this.mDuration - this.lVX);
      ae.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.lVW), Integer.valueOf(this.lVX) });
    }
  }
  
  private aq btB()
  {
    AppMethodBeat.i(146176);
    if (this.lVY == null) {
      this.lVY = new aq(Looper.getMainLooper());
    }
    aq localaq = this.lVY;
    AppMethodBeat.o(146176);
    return localaq;
  }
  
  public static g btx()
  {
    AppMethodBeat.i(146170);
    synchronized (ddM)
    {
      if (lWd == null) {
        lWd = new g();
      }
      g localg = lWd;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean bty()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    ae.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.djW != null)
    {
      this.djW.close();
      this.djW = null;
    }
    this.mFilePath = h.ec(this.lVS.kAi, this.lVS.gfv);
    ae.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.djW = com.tencent.mm.plugin.appbrand.media.record.a.b.Th(this.lVS.kAi);
    if (this.djW != null)
    {
      boolean bool2 = h.Te(this.mFilePath);
      if (!bool2)
      {
        ae.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.djW.i(this.mFilePath, this.lVS.sampleRate, this.lVS.lyO, this.lVS.lyP);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.djW.a(this.lWc);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    ae.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.lVE != null) {
      this.lVE.stopTimer();
    }
    this.lVE = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean OG()
  {
    return this.lVT == a.lWk;
  }
  
  public final boolean OH()
  {
    return this.lVT == a.lWl;
  }
  
  public final boolean PF()
  {
    AppMethodBeat.i(146171);
    ae.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.lVR == null) && (this.djW == null))
    {
      ae.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
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
  
  protected final void btC()
  {
    AppMethodBeat.i(146178);
    this.lWa = true;
    ae.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    ok localok = new ok();
    localok.dDq.action = 6;
    localok.dDq.state = "interruptionBegin";
    if (this.lVS != null) {
      localok.dDq.appId = this.lVS.appId;
    }
    com.tencent.mm.sdk.b.a.IvT.a(localok, Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  final void btz()
  {
    AppMethodBeat.i(146174);
    ae.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (OG())
        {
          ae.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.lVR == null) {
          break label416;
        }
        bool1 = this.lVR.PF();
        this.lVR = null;
        if ((this.lVS != null) && (this.lVS.lWS != null))
        {
          boolean bool2 = this.lVS.lWS.btu();
          ae.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.lWa), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.lWa)) {
            btC();
          }
        }
        btB().post(new Runnable()
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
        ae.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.lVX) });
        this.lVX = ((int)(this.lVX + l2));
        this.lVW = (this.mDuration - this.lVX);
        ae.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.lVW), Integer.valueOf(this.lVX) });
      }
      catch (Exception localException)
      {
        ok localok;
        ae.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        onError(8);
        ae.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(146174);
        return;
      }
      ae.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        ae.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.lVT = a.lWk;
        this.djY = false;
        localok = new ok();
        localok.dDq.action = 3;
        localok.dDq.state = "pause";
        if (this.lVS != null) {
          localok.dDq.appId = this.lVS.appId;
        }
        com.tencent.mm.sdk.b.a.IvT.a(localok, Looper.getMainLooper());
        ae.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void onError(int paramInt)
  {
    AppMethodBeat.i(146177);
    ae.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.lVT != a.lWm) {
      j.uH(paramInt);
    }
    this.lVT = a.lWm;
    this.djY = false;
    ok localok = new ok();
    localok.dDq.action = 4;
    localok.dDq.state = "error";
    if (this.lVS != null) {
      localok.dDq.appId = this.lVS.appId;
    }
    localok.dDq.errCode = paramInt;
    localok.dDq.errMsg = i.uF(paramInt);
    com.tencent.mm.sdk.b.a.IvT.a(localok, Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      lWh = new a("INITIALIZING", 0);
      lWi = new a("START", 1);
      lWj = new a("RESUME", 2);
      lWk = new a("PAUSE", 3);
      lWl = new a("STOP", 4);
      lWm = new a("ERROR", 5);
      lWn = new a[] { lWh, lWi, lWj, lWk, lWl, lWm };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */