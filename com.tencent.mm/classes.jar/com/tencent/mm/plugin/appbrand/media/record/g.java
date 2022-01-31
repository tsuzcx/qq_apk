package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;

public final class g
{
  private static Object ceY;
  private static g ipG;
  private com.tencent.mm.plugin.appbrand.media.record.a.d clh;
  private d.a cli;
  private long ipA;
  private int ipB;
  private ak ipC;
  boolean ipD;
  boolean ipE;
  private a.a ipF;
  private e ipH;
  private ap iph;
  public com.tencent.mm.plugin.appbrand.media.record.record_imp.a ipu;
  private Object ipv;
  public RecordParam ipw;
  g.a ipx;
  private boolean ipy;
  private int ipz;
  private long mDuration;
  private String mFilePath;
  public boolean mIsRecording;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(105634);
    j.a(new g.1());
    ceY = new Object();
    AppMethodBeat.o(105634);
  }
  
  private g()
  {
    AppMethodBeat.i(105619);
    this.ipu = null;
    this.mIsRecording = false;
    this.ipv = new Object();
    this.ipx = g.a.ipK;
    this.clh = null;
    this.ipy = false;
    this.ipz = 0;
    this.iph = null;
    this.mDuration = 0L;
    this.ipA = 0L;
    this.ipB = 0;
    this.mStartTime = 0L;
    this.ipD = false;
    this.ipE = false;
    this.ipF = new g.6(this);
    this.cli = new g.7(this);
    this.ipH = new g.5(this);
    AppMethodBeat.o(105619);
  }
  
  private boolean ED()
  {
    AppMethodBeat.i(105622);
    ab.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.ipu != null)
    {
      this.ipu.Et();
      this.ipu = null;
      ab.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.ipu == null)
    {
      this.ipu = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.ipw);
      this.ipu.iqp = this.ipF;
    }
    com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = this.ipu;
    ab.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.ciR != null)
    {
      locala.ciR.Et();
      locala.ciR = null;
    }
    locala.iqo = System.currentTimeMillis();
    ab.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.iqo) });
    locala.ciR = new c(locala.sampleRate, locala.awU, locala.cjr);
    if ("mp3".equalsIgnoreCase(locala.iqn.hCu))
    {
      locala.ciR.gA(40);
      locala.ciR.bz(false);
      locala.ciR.cjD = locala.iqq;
      c localc = locala.ciR;
      int i = locala.iqn.iqs.ifE;
      localc.cjl = i;
      ab.i("MicroMsg.MMPcmRecorder", "mAudioSource: ".concat(String.valueOf(i)));
      if (!locala.ciR.EC()) {
        break label284;
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(105622);
      return bool;
      locala.ciR.gA(20);
      break;
    }
  }
  
  public static g aHT()
  {
    AppMethodBeat.i(105620);
    synchronized (ceY)
    {
      if (ipG == null) {
        ipG = new g();
      }
      g localg = ipG;
      AppMethodBeat.o(105620);
      return localg;
    }
  }
  
  private boolean aHU()
  {
    boolean bool1 = false;
    AppMethodBeat.i(105623);
    ab.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.clh != null)
    {
      this.clh.close();
      this.clh = null;
    }
    this.mFilePath = h.cI(this.ipw.hCu, this.ipw.ese);
    ab.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.clh = com.tencent.mm.plugin.appbrand.media.record.a.b.DH(this.ipw.hCu);
    if (this.clh != null)
    {
      boolean bool2 = h.DE(this.mFilePath);
      if (!bool2)
      {
        ab.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(105623);
        return bool2;
      }
      try
      {
        bool2 = this.clh.h(this.mFilePath, this.ipw.sampleRate, this.ipw.ifH, this.ipw.ifJ);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.clh.a(this.cli);
      AppMethodBeat.o(105623);
      return bool1;
    }
    AppMethodBeat.o(105623);
    return false;
  }
  
  private void aHW()
  {
    AppMethodBeat.i(105625);
    ab.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (Dt())
        {
          ab.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(105625);
          return;
        }
        if (this.ipu == null) {
          continue;
        }
        bool = this.ipu.Et();
        this.ipu = null;
        this.ipy = true;
        ab.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.ipz) });
        if (this.clh != null)
        {
          this.clh.flush();
          this.clh.close();
          this.clh = null;
        }
        aHX().post(new g.4(this));
        if (!Ds()) {
          continue;
        }
        ab.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        mg localmg;
        long l1;
        long l2;
        ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        onError(9);
        ab.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      ab.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      ab.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.ipx = g.a.ipO;
      this.mIsRecording = false;
      localmg = new mg();
      localmg.cCp.action = 2;
      localmg.cCp.state = "stop";
      if (this.ipw != null) {
        localmg.cCp.appId = this.ipw.appId;
      }
      ab.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.ipz), Integer.valueOf(this.ipB) });
      localmg.cCp.duration = Math.min(this.ipz, this.ipB);
      localmg.cCp.filePath = this.mFilePath;
      localmg.cCp.fileSize = ((int)h.DF(this.mFilePath));
      com.tencent.mm.sdk.b.a.ymk.a(localmg, Looper.getMainLooper());
      ab.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.ipw = null;
      d.aHN();
      AppMethodBeat.o(105625);
      return;
      ab.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      ab.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.ipB) });
      this.ipB = ((int)(this.ipB + l2));
      this.ipA = (this.mDuration - this.ipB);
      ab.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.ipA), Integer.valueOf(this.ipB) });
    }
  }
  
  private ak aHX()
  {
    AppMethodBeat.i(105626);
    if (this.ipC == null) {
      this.ipC = new ak(Looper.getMainLooper());
    }
    ak localak = this.ipC;
    AppMethodBeat.o(105626);
    return localak;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(105618);
    ab.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.iph != null) {
      this.iph.stopTimer();
    }
    this.iph = null;
    AppMethodBeat.o(105618);
  }
  
  public final boolean Ds()
  {
    return this.ipx == g.a.ipN;
  }
  
  public final boolean Dt()
  {
    return this.ipx == g.a.ipO;
  }
  
  public final boolean Et()
  {
    AppMethodBeat.i(105621);
    ab.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.ipu == null) && (this.clh == null))
    {
      ab.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
      AppMethodBeat.o(105621);
      return false;
    }
    com.tencent.mm.sdk.g.d.post(new g.12(this), "app_brand_stop_record");
    AppMethodBeat.o(105621);
    return true;
  }
  
  final void aHV()
  {
    AppMethodBeat.i(105624);
    ab.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (Ds())
        {
          ab.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(105624);
          return;
        }
        if (this.ipu == null) {
          break label416;
        }
        bool1 = this.ipu.Et();
        this.ipu = null;
        if ((this.ipw != null) && (this.ipw.iqt != null))
        {
          boolean bool2 = this.ipw.iqt.aHQ();
          ab.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.ipE), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.ipE)) {
            aHY();
          }
        }
        aHX().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(105604);
            g.k(g.this);
            AppMethodBeat.o(105604);
          }
        });
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.mStartTime;
        ab.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.ipB) });
        this.ipB = ((int)(this.ipB + l2));
        this.ipA = (this.mDuration - this.ipB);
        ab.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.ipA), Integer.valueOf(this.ipB) });
      }
      catch (Exception localException)
      {
        mg localmg;
        ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        onError(8);
        ab.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(105624);
        return;
      }
      ab.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        ab.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.ipx = g.a.ipN;
        this.mIsRecording = false;
        localmg = new mg();
        localmg.cCp.action = 3;
        localmg.cCp.state = "pause";
        if (this.ipw != null) {
          localmg.cCp.appId = this.ipw.appId;
        }
        com.tencent.mm.sdk.b.a.ymk.a(localmg, Looper.getMainLooper());
        ab.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(105624);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void aHY()
  {
    AppMethodBeat.i(105628);
    this.ipE = true;
    ab.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    mg localmg = new mg();
    localmg.cCp.action = 6;
    localmg.cCp.state = "interruptionBegin";
    if (this.ipw != null) {
      localmg.cCp.appId = this.ipw.appId;
    }
    com.tencent.mm.sdk.b.a.ymk.a(localmg, Looper.getMainLooper());
    AppMethodBeat.o(105628);
  }
  
  protected final void onError(int paramInt)
  {
    AppMethodBeat.i(105627);
    ab.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.ipx != g.a.ipP) {
      j.oR(paramInt);
    }
    this.ipx = g.a.ipP;
    this.mIsRecording = false;
    mg localmg = new mg();
    localmg.cCp.action = 4;
    localmg.cCp.state = "error";
    if (this.ipw != null) {
      localmg.cCp.appId = this.ipw.appId;
    }
    localmg.cCp.errCode = paramInt;
    localmg.cCp.errMsg = i.oP(paramInt);
    com.tencent.mm.sdk.b.a.ymk.a(localmg, Looper.getMainLooper());
    AppMethodBeat.o(105627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */