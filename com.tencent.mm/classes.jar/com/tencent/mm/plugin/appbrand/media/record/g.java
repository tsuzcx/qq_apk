package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.plugin.appbrand.media.record.a.d.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class g
{
  private static Object dcK;
  private static g lRC;
  private com.tencent.mm.plugin.appbrand.media.record.a.d diU;
  public boolean diW;
  private a.a lRA;
  private d.a lRB;
  private e lRD;
  private av lRd;
  public com.tencent.mm.plugin.appbrand.media.record.record_imp.a lRq;
  public RecordParam lRr;
  a lRs;
  private boolean lRt;
  private int lRu;
  private long lRv;
  private int lRw;
  private ap lRx;
  boolean lRy;
  boolean lRz;
  private long mDuration;
  private String mFilePath;
  private Object mLockObj;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(146184);
    j.a(new g.1());
    dcK = new Object();
    AppMethodBeat.o(146184);
  }
  
  private g()
  {
    AppMethodBeat.i(146169);
    this.lRq = null;
    this.diW = false;
    this.mLockObj = new Object();
    this.lRs = a.lRG;
    this.diU = null;
    this.lRt = false;
    this.lRu = 0;
    this.lRd = null;
    this.mDuration = 0L;
    this.lRv = 0L;
    this.lRw = 0;
    this.mStartTime = 0L;
    this.lRy = false;
    this.lRz = false;
    this.lRA = new a.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(146157);
        ad.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
          if (locala.dgu != null) {}
          for (int i = locala.dgu.dgR;; i = 20)
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
              if ((g.e(g.this) == null) || (!"mp3".equalsIgnoreCase(g.e(g.this).kwT))) {
                break;
              }
              j.uC(19);
              AppMethodBeat.o(146156);
              return;
              if ((g.e(g.this) == null) || (!"aac".equalsIgnoreCase(g.e(g.this).kwT))) {
                break label204;
              }
              j.uC(23);
            }
          }
        }
        label204:
        AppMethodBeat.o(146156);
      }
    };
    this.lRB = new d.a()
    {
      public final void c(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146158);
        Object localObject = g.this;
        ad.i("MicroMsg.Record.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        oj localoj = new oj();
        localoj.dCl.state = "frameRecorded";
        if (((g)localObject).lRr != null) {
          localoj.dCl.appId = ((g)localObject).lRr.appId;
        }
        localoj.dCl.action = 5;
        localObject = new byte[paramAnonymousInt];
        System.arraycopy(paramAnonymousArrayOfByte, 0, localObject, 0, paramAnonymousInt);
        localoj.dCl.frameBuffer = ((byte[])localObject);
        localoj.dCl.dCm = paramAnonymousBoolean;
        com.tencent.mm.sdk.b.a.IbL.a(localoj, Looper.getMainLooper());
        AppMethodBeat.o(146158);
      }
    };
    this.lRD = new e()
    {
      public final void bsH()
      {
        AppMethodBeat.i(146154);
        if (!g.l(g.this))
        {
          g.this.bsR();
          AppMethodBeat.o(146154);
          return;
        }
        ad.i("MicroMsg.Record.AudioRecordMgr", "is interrupting");
        AppMethodBeat.o(146154);
      }
      
      public final void bsI()
      {
        AppMethodBeat.i(146155);
        if (g.l(g.this))
        {
          g localg = g.this;
          localg.lRz = false;
          ad.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionEnd");
          oj localoj = new oj();
          localoj.dCl.action = 7;
          localoj.dCl.state = "interruptionEnd";
          if (localg.lRr != null) {
            localoj.dCl.appId = localg.lRr.appId;
          }
          com.tencent.mm.sdk.b.a.IbL.a(localoj, Looper.getMainLooper());
          AppMethodBeat.o(146155);
          return;
        }
        ad.i("MicroMsg.Record.AudioRecordMgr", "not call onInterruptionEnd");
        AppMethodBeat.o(146155);
      }
    };
    AppMethodBeat.o(146169);
  }
  
  private boolean PQ()
  {
    AppMethodBeat.i(146172);
    ad.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.lRq != null)
    {
      this.lRq.PG();
      this.lRq = null;
      ad.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.lRq == null)
    {
      this.lRq = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.lRr);
      this.lRq.lSn = this.lRA;
    }
    com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = this.lRq;
    ad.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.dgu != null)
    {
      locala.dgu.PG();
      locala.dgu = null;
    }
    locala.lSm = System.currentTimeMillis();
    ad.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.lSm) });
    locala.dgu = new c(locala.sampleRate, locala.channelCount, locala.dgV);
    if ("mp3".equalsIgnoreCase(locala.lSl.kwT))
    {
      locala.dgu.hO(40);
      locala.dgu.cu(false);
      locala.dgu.dhh = locala.lSo;
      locala.dgu.setAudioSource(locala.lSl.lSq.lum);
      if (!locala.dgu.PP()) {
        break label264;
      }
    }
    label264:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(146172);
      return bool;
      locala.dgu.hO(20);
      break;
    }
  }
  
  public static g bsM()
  {
    AppMethodBeat.i(146170);
    synchronized (dcK)
    {
      if (lRC == null) {
        lRC = new g();
      }
      g localg = lRC;
      AppMethodBeat.o(146170);
      return localg;
    }
  }
  
  private boolean bsN()
  {
    boolean bool1 = false;
    AppMethodBeat.i(146173);
    ad.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.diU != null)
    {
      this.diU.close();
      this.diU = null;
    }
    this.mFilePath = h.ea(this.lRr.kwT, this.lRr.gdn);
    ad.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    this.diU = com.tencent.mm.plugin.appbrand.media.record.a.b.Sy(this.lRr.kwT);
    if (this.diU != null)
    {
      boolean bool2 = h.Sv(this.mFilePath);
      if (!bool2)
      {
        ad.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
        AppMethodBeat.o(146173);
        return bool2;
      }
      try
      {
        bool2 = this.diU.i(this.mFilePath, this.lRr.sampleRate, this.lRr.lup, this.lRr.luq);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        }
      }
      this.diU.a(this.lRB);
      AppMethodBeat.o(146173);
      return bool1;
    }
    AppMethodBeat.o(146173);
    return false;
  }
  
  private void bsP()
  {
    AppMethodBeat.i(146175);
    ad.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (OJ())
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          AppMethodBeat.o(146175);
          return;
        }
        if (this.lRq == null) {
          continue;
        }
        bool = this.lRq.PG();
        this.lRq = null;
        this.lRt = true;
        ad.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.lRu) });
        if (this.diU != null)
        {
          this.diU.flush();
          this.diU.close();
          this.diU = null;
        }
        bsQ().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146153);
            g.k(g.this);
            AppMethodBeat.o(146153);
          }
        });
        if (!OI()) {
          continue;
        }
        ad.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        oj localoj;
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
      this.lRs = a.lRK;
      this.diW = false;
      localoj = new oj();
      localoj.dCl.action = 2;
      localoj.dCl.state = "stop";
      if (this.lRr != null) {
        localoj.dCl.appId = this.lRr.appId;
      }
      ad.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.lRu), Integer.valueOf(this.lRw) });
      localoj.dCl.duration = Math.min(this.lRu, this.lRw);
      localoj.dCl.filePath = this.mFilePath;
      localoj.dCl.fileSize = ((int)h.Sw(this.mFilePath));
      com.tencent.mm.sdk.b.a.IbL.a(localoj, Looper.getMainLooper());
      ad.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.lRr = null;
      d.bsG();
      AppMethodBeat.o(146175);
      return;
      ad.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      ad.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.lRw) });
      this.lRw = ((int)(this.lRw + l2));
      this.lRv = (this.mDuration - this.lRw);
      ad.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.lRv), Integer.valueOf(this.lRw) });
    }
  }
  
  private ap bsQ()
  {
    AppMethodBeat.i(146176);
    if (this.lRx == null) {
      this.lRx = new ap(Looper.getMainLooper());
    }
    ap localap = this.lRx;
    AppMethodBeat.o(146176);
    return localap;
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(146168);
    ad.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.lRd != null) {
      this.lRd.stopTimer();
    }
    this.lRd = null;
    AppMethodBeat.o(146168);
  }
  
  public final boolean OI()
  {
    return this.lRs == a.lRJ;
  }
  
  public final boolean OJ()
  {
    return this.lRs == a.lRK;
  }
  
  public final boolean PG()
  {
    AppMethodBeat.i(146171);
    ad.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.lRq == null) && (this.diU == null))
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
  
  final void bsO()
  {
    AppMethodBeat.i(146174);
    ad.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (OI())
        {
          ad.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          AppMethodBeat.o(146174);
          return;
        }
        if (this.lRq == null) {
          break label416;
        }
        bool1 = this.lRq.PG();
        this.lRq = null;
        if ((this.lRr != null) && (this.lRr.lSr != null))
        {
          boolean bool2 = this.lRr.lSr.bsJ();
          ad.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.lRz), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.lRz)) {
            bsR();
          }
        }
        bsQ().post(new Runnable()
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
        ad.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.lRw) });
        this.lRw = ((int)(this.lRw + l2));
        this.lRv = (this.mDuration - this.lRw);
        ad.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.lRv), Integer.valueOf(this.lRw) });
      }
      catch (Exception localException)
      {
        oj localoj;
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
        this.lRs = a.lRJ;
        this.diW = false;
        localoj = new oj();
        localoj.dCl.action = 3;
        localoj.dCl.state = "pause";
        if (this.lRr != null) {
          localoj.dCl.appId = this.lRr.appId;
        }
        com.tencent.mm.sdk.b.a.IbL.a(localoj, Looper.getMainLooper());
        ad.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        AppMethodBeat.o(146174);
        return;
      }
      label416:
      boolean bool1 = false;
    }
  }
  
  protected final void bsR()
  {
    AppMethodBeat.i(146178);
    this.lRz = true;
    ad.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    oj localoj = new oj();
    localoj.dCl.action = 6;
    localoj.dCl.state = "interruptionBegin";
    if (this.lRr != null) {
      localoj.dCl.appId = this.lRr.appId;
    }
    com.tencent.mm.sdk.b.a.IbL.a(localoj, Looper.getMainLooper());
    AppMethodBeat.o(146178);
  }
  
  protected final void onError(int paramInt)
  {
    AppMethodBeat.i(146177);
    ad.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.lRs != a.lRL) {
      j.uB(paramInt);
    }
    this.lRs = a.lRL;
    this.diW = false;
    oj localoj = new oj();
    localoj.dCl.action = 4;
    localoj.dCl.state = "error";
    if (this.lRr != null) {
      localoj.dCl.appId = this.lRr.appId;
    }
    localoj.dCl.errCode = paramInt;
    localoj.dCl.errMsg = i.uz(paramInt);
    com.tencent.mm.sdk.b.a.IbL.a(localoj, Looper.getMainLooper());
    AppMethodBeat.o(146177);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(146167);
      lRG = new a("INITIALIZING", 0);
      lRH = new a("START", 1);
      lRI = new a("RESUME", 2);
      lRJ = new a("PAUSE", 3);
      lRK = new a("STOP", 4);
      lRL = new a("ERROR", 5);
      lRM = new a[] { lRG, lRH, lRI, lRJ, lRK, lRL };
      AppMethodBeat.o(146167);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */