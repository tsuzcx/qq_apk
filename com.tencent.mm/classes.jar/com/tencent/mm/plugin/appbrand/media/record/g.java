package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.ArrayList;

public final class g
{
  private static Object cRu;
  private static g lst;
  private com.tencent.mm.plugin.appbrand.media.record.a.d cXC;
  public boolean cXE;
  private au lrT;
  public com.tencent.mm.plugin.appbrand.media.record.record_imp.a lsh;
  public RecordParam lsi;
  a lsj;
  private boolean lsk;
  private int lsl;
  private long lsm;
  private int lsn;
  private ao lso;
  boolean lsp;
  boolean lsq;
  private a.a lsr;
  private d.a lss;
  private e lsu;
  private long mDuration;
  private String mFilePath;
  private Object mLockObj;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new j.b()
    {
      public final void D(ArrayList<IDKey> paramAnonymousArrayList)
      {
        AppMethodBeat.i(146150);
        com.tencent.mm.plugin.report.service.h.wUl.b(paramAnonymousArrayList, true);
        AppMethodBeat.o(146150);
      }
      
      public final void oQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(146149);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(689L, paramAnonymousLong, 1L, true);
        AppMethodBeat.o(146149);
      }
    });
    cRu = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.lsh = null;
    this.cXE = false;
    this.mLockObj = new Object();
    this.lsj = a.lsx;
    this.cXC = null;
    this.lsk = false;
    this.lsl = 0;
    this.lrT = null;
    this.mDuration = 0L;
    this.lsm = 0L;
    this.lsn = 0;
    this.mStartTime = 0L;
    this.lsp = false;
    this.lsq = false;
    this.lsr = new a.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        ac.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
          if (locala.cVe != null) {}
          for (int i = locala.cVe.cVB;; i = 20)
          {
            g.a(localg, i + j);
            try
            {
              if (!g.a(g.this).a(g.d(g.this), paramAnonymousArrayOfByte, paramAnonymousInt)) {
                ac.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
              }
              AppMethodBeat.o(146156);
              return;
            }
            catch (Exception paramAnonymousArrayOfByte)
            {
              ac.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramAnonymousArrayOfByte, "onRecPcmDataReady", new Object[0]);
              if ((g.e(g.this) == null) || (!"mp3".equalsIgnoreCase(g.e(g.this).kcu))) {
                break;
              }
              j.tY(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.e(g.this) == null) || (!"aac".equalsIgnoreCase(g.e(g.this).kcu))) {
                break label204;
              }
              j.tY(23);
            }
          }
        }
        label204:
        AppMethodBeat.o(146156);
      }
    };
    this.lss = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        ac.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        ob localob = new ob();
        localob.dqy.state = "frameRecorded";
        if (((g)localObject).lsi != null) {
          localob.dqy.appId = ((g)localObject).lsi.appId;
        }
        localob.dqy.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localob.dqy.frameBuffer = ((byte[])localObject);
        localob.dqy.dqz = paramAnonymousBoolean;
        com.tencent.mm.sdk.b.a.GpY.a(localob, Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.lsu = new e()
    {
      public final void boI()
      {
        AppMethodBeat.i(146154);
        if (!g.l(g.this))
        {
          g.this.boS();
          AppMethodBeat.o(146154);
          return;
        }
        ac.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void boJ()
      {
        AppMethodBeat.i(146155);
        if (g.l(g.this))
        {
          g localg = g.this;
          localg.lsq = false;
          ac.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          ob localob = new ob();
          localob.dqy.action = 7;
          localob.dqy.state = "interruptionEnd";
          if (localg.lsi != null) {
            localob.dqy.appId = localg.lsi.appId;
          }
          com.tencent.mm.sdk.b.a.GpY.a(localob, Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        ac.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean Oh()
  {
    AppMethodBeat.i(146172);
    ac.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.lsh != null)
    {
      this.lsh.NX();
      this.lsh = null;
      ac.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.lsh == null)
    {
      this.lsh = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.lsi);
      this.lsh.lte = this.lsr;
    }
    com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = this.lsh;
    ac.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.cVe != null)
    {
      locala.cVe.NX();
      locala.cVe = null;
    }
    locala.ltd = System.currentTimeMillis();
    ac.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.ltd) });
    locala.cVe = new c(locala.sampleRate, locala.channelCount, locala.cVF);
    if ("mp3".equalsIgnoreCase(locala.ltc.kcu))
    {
      locala.cVe.hH(40);
      locala.cVe.cs(false);
      locala.cVe.cVR = locala.ltf;
      locala.cVe.setAudioSource(locala.ltc.lth.kXn);
      if (!locala.cVe.Og()) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.cVe.hH(20);
      break;
    }
  }
  
  public static g boN()
  {
    AppMethodBeat.i(146170);
    synchronized (cRu)
    {
      if (lst == null) {
        lst = new g();
      }
      g localg = lst;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean boO()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    ac.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.cXC != null)
    {
      this.cXC.close();
      this.cXC = null;
    }
    this.mFilePath = h.dR(this.lsi.kcu, this.lsi.fJM);
    ac.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.cXC = com.tencent.mm.plugin.appbrand.media.record.a.b.OV(this.lsi.kcu);
    if (this.cXC != null)
    {
      boolean bool2 = h.OS(this.mFilePath);
      if (!bool2)
      {
        ac.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.cXC.i(this.mFilePath, this.lsi.sampleRate, this.lsi.kXq, this.lsi.kXr);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.cXC.a(this.lss);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void boQ()
  {
    AppMethodBeat.i(146175);
    ac.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (Na())
        {
          ac.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.lsh == null) {
          continue;
        }
        bool = this.lsh.NX();
        this.lsh = null;
        this.lsk = true;
        ac.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.lsl) });
        if (this.cXC != null)
        {
          this.cXC.flush();
          this.cXC.close();
          this.cXC = null;
        }
        boR().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.k(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!MZ()) {
          continue;
        }
        ac.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        ob localob;
        long l1;
        long l2;
        ac.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        onError(9);
        ac.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      ac.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      ac.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.lsj = a.lsB;
      this.cXE = false;
      localob = new ob();
      localob.dqy.action = 2;
      localob.dqy.state = "stop";
      if (this.lsi != null) {
        localob.dqy.appId = this.lsi.appId;
      }
      ac.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.lsl), Integer.valueOf(this.lsn) });
      localob.dqy.duration = Math.min(this.lsl, this.lsn);
      localob.dqy.filePath = this.mFilePath;
      localob.dqy.fileSize = ((int)h.OT(this.mFilePath));
      com.tencent.mm.sdk.b.a.GpY.a(localob, Looper.getMainLooper());
      ac.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.lsi = null;
      d.boH();
      AppMethodBeat.o(146175);
      return;
      ac.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      ac.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.lsn) });
      this.lsn = ((int)(this.lsn + l2));
      this.lsm = (this.mDuration - this.lsn);
      ac.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.lsm), Integer.valueOf(this.lsn) });
    }
  }
  
  private ao boR()
  {
    AppMethodBeat.i(146176);
    if (this.lso == null) {
      this.lso = new ao(Looper.getMainLooper());
    }
    ao localao = this.lso;
    AppMethodBeat.o(146176);
    return localao;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    ac.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.lrT != null) {
      this.lrT.stopTimer();
    }
    this.lrT = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean MZ()
  {
    return this.lsj == a.lsA;
  }
  
  public final boolean NX()
  {
    AppMethodBeat.i(146171);
    ac.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.lsh == null) && (this.cXC == null))
    {
      ac.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
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
  
  public final boolean Na()
  {
    return this.lsj == a.lsB;
  }
  
  final void boP()
  {
    AppMethodBeat.i(146174);
    ac.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (MZ())
        {
          ac.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.lsh == null) {
          break label416;
        }
        bool1 = this.lsh.NX();
        this.lsh = null;
        if ((this.lsi != null) && (this.lsi.lti != null))
        {
          boolean bool2 = this.lsi.lti.boK();
          ac.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.lsq), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.lsq)) {
            boS();
          }
        }
        boR().post(new Runnable()
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
        ac.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.lsn) });
        this.lsn = ((int)(this.lsn + l2));
        this.lsm = (this.mDuration - this.lsn);
        ac.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.lsm), Integer.valueOf(this.lsn) });
      }
      catch (Exception localException)
      {
        ob localob;
        ac.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        onError(8);
        ac.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        AppMethodBeat.o(146174);
        return;
      }
      ac.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        ac.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.lsj = a.lsA;
        this.cXE = false;
        localob = new ob();
        localob.dqy.action = 3;
        localob.dqy.state = "pause";
        if (this.lsi != null) {
          localob.dqy.appId = this.lsi.appId;
        }
        com.tencent.mm.sdk.b.a.GpY.a(localob, Looper.getMainLooper());
        ac.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void boS()
  {
    AppMethodBeat.i(146178);
    this.lsq = true;
    ac.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    ob localob = new ob();
    localob.dqy.action = 6;
    localob.dqy.state = "interruptionBegin";
    if (this.lsi != null) {
      localob.dqy.appId = this.lsi.appId;
    }
    com.tencent.mm.sdk.b.a.GpY.a(localob, Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  protected final void onError(int paramInt)
  {
    AppMethodBeat.i(146177);
    ac.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.lsj != a.lsC) {
      j.tX(paramInt);
    }
    this.lsj = a.lsC;
    this.cXE = false;
    ob localob = new ob();
    localob.dqy.action = 4;
    localob.dqy.state = "error";
    if (this.lsi != null) {
      localob.dqy.appId = this.lsi.appId;
    }
    localob.dqy.errCode = paramInt;
    localob.dqy.errMsg = i.tV(paramInt);
    com.tencent.mm.sdk.b.a.GpY.a(localob, Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      lsx = new a("INITIALIZING", 0);
      lsy = new a("START", 1);
      lsz = new a("RESUME", 2);
      lsA = new a("PAUSE", 3);
      lsB = new a("STOP", 4);
      lsC = new a("ERROR", 5);
      lsD = new a[] { lsx, lsy, lsz, lsA, lsB, lsC };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */