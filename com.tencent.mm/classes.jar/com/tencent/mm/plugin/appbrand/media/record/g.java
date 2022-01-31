package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.h.a.lq;
import com.tencent.mm.h.a.lq.a;
import com.tencent.mm.plugin.appbrand.media.record.a.c.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class g
{
  private static Object bjn = new Object();
  private static g gNV;
  public com.tencent.mm.plugin.appbrand.media.record.record_imp.a gNH = null;
  private Object gNI = new Object();
  public RecordParam gNJ;
  g.a gNK = g.a.gNZ;
  private com.tencent.mm.plugin.appbrand.media.record.a.c gNL = null;
  private boolean gNM = false;
  private int gNN = 0;
  private long gNO = 0L;
  private int gNP = 0;
  private ah gNQ;
  boolean gNR = false;
  boolean gNS = false;
  private a.a gNT = new g.1(this);
  private c.a gNU = new g.5(this);
  private e gNW = new g.4(this);
  private am gNn = null;
  private long mDuration = 0L;
  private String mFilePath;
  public boolean mIsRecording = false;
  private long mStartTime = 0L;
  
  public static g amm()
  {
    synchronized (bjn)
    {
      if (gNV == null) {
        gNV = new g();
      }
      g localg = gNV;
      return localg;
    }
  }
  
  private boolean amo()
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "startRecordInternal");
    if (this.gNH != null)
    {
      this.gNH.uh();
      this.gNH = null;
      y.i("MicroMsg.Record.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
    }
    if (this.gNH == null)
    {
      this.gNH = new com.tencent.mm.plugin.appbrand.media.record.record_imp.a(this.gNJ);
      this.gNH.gOD = this.gNT;
    }
    com.tencent.mm.plugin.appbrand.media.record.record_imp.a locala = this.gNH;
    y.i("MicroMsg.Record.AppBrandRecorder", "startRecord");
    if (locala.bCc != null)
    {
      locala.bCc.uh();
      locala.bCc = null;
    }
    locala.gOC = System.currentTimeMillis();
    y.i("MicroMsg.Record.AppBrandRecorder", "start time ticket:%d", new Object[] { Long.valueOf(locala.gOC) });
    locala.bCc = new com.tencent.mm.f.b.c(locala.sampleRate, locala.auC, locala.bCD);
    if ("mp3".equalsIgnoreCase(locala.gOB.gja))
    {
      locala.bCc.ey(40);
      locala.bCc.aX(false);
      locala.bCc.bCP = locala.gOE;
      com.tencent.mm.f.b.c localc = locala.bCc;
      int i = locala.gOB.gOJ.gNu;
      localc.bCx = i;
      y.i("MicroMsg.MMPcmRecorder", "mAudioSource: " + i);
      if (!locala.bCc.uq()) {
        break label282;
      }
    }
    label282:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.Record.AudioRecordMgr", "record start:%b", new Object[] { Boolean.valueOf(bool) });
      return bool;
      locala.bCc.ey(20);
      break;
    }
  }
  
  private boolean amp()
  {
    Object localObject2 = null;
    y.i("MicroMsg.Record.AudioRecordMgr", "initEncode");
    if (this.gNL != null)
    {
      this.gNL.close();
      this.gNL = null;
    }
    this.mFilePath = h.bT(this.gNJ.gja, this.gNJ.dzp);
    y.i("MicroMsg.Record.AudioRecordMgr", "mFilePath:%s", new Object[] { this.mFilePath });
    String str = this.gNJ.gja;
    y.i("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", new Object[] { str });
    Object localObject1 = localObject2;
    if (h.vh(str))
    {
      if (!"aac".equalsIgnoreCase(str)) {
        break label161;
      }
      localObject1 = new com.tencent.mm.plugin.appbrand.media.record.a.a();
    }
    boolean bool;
    for (;;)
    {
      this.gNL = ((com.tencent.mm.plugin.appbrand.media.record.a.c)localObject1);
      if (this.gNL == null) {
        break label275;
      }
      bool = h.vi(this.mFilePath);
      if (bool) {
        break;
      }
      y.e("MicroMsg.Record.AudioRecordMgr", "prepare cache file fail");
      return bool;
      label161:
      if ("mp3".equalsIgnoreCase(str))
      {
        localObject1 = new com.tencent.mm.plugin.appbrand.media.record.a.d();
      }
      else
      {
        localObject1 = localObject2;
        if ("wav".equalsIgnoreCase(str)) {
          localObject1 = new com.tencent.mm.plugin.appbrand.media.record.a.e();
        }
      }
    }
    try
    {
      bool = this.gNL.f(this.mFilePath, this.gNJ.sampleRate, this.gNJ.gOG, this.gNJ.gOH);
      this.gNL.a(this.gNU);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "init encoder fail", new Object[0]);
        bool = false;
      }
    }
    label275:
    return false;
  }
  
  private void amr()
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "stop record in runnable");
    for (;;)
    {
      try
      {
        if (amn())
        {
          y.e("MicroMsg.Record.AudioRecordMgr", "is stopped, don't stop again");
          return;
        }
        if (this.gNH == null) {
          continue;
        }
        bool = this.gNH.uh();
        this.gNH = null;
        this.gNM = true;
        y.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d", new Object[] { Integer.valueOf(this.gNN) });
        if (this.gNL != null)
        {
          this.gNL.flush();
          this.gNL.close();
          this.gNL = null;
        }
        ams().post(new g.3(this));
        if (!uf()) {
          continue;
        }
        y.e("MicroMsg.Record.AudioRecordMgr", "don't calculate time again if it is pause state");
      }
      catch (Exception localException)
      {
        lq locallq;
        long l1;
        long l2;
        y.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_stop", new Object[0]);
        boolean bool = false;
        continue;
        onError(9);
        y.e("MicroMsg.Record.AudioRecordMgr", "stop record fail");
        continue;
      }
      y.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        continue;
      }
      y.i("MicroMsg.Record.AudioRecordMgr", "onStop");
      this.gNK = g.a.gOd;
      this.mIsRecording = false;
      locallq = new lq();
      locallq.bUI.action = 2;
      locallq.bUI.state = "stop";
      if (this.gNJ != null) {
        locallq.bUI.appId = this.gNJ.appId;
      }
      y.i("MicroMsg.Record.AudioRecordMgr", "mPcmDuration:%d, mRealRecordedTime%d", new Object[] { Integer.valueOf(this.gNN), Integer.valueOf(this.gNP) });
      locallq.bUI.duration = Math.min(this.gNN, this.gNP);
      locallq.bUI.filePath = this.mFilePath;
      locallq.bUI.fileSize = ((int)h.vj(this.mFilePath));
      com.tencent.mm.sdk.b.a.udP.a(locallq, Looper.getMainLooper());
      y.i("MicroMsg.Record.AudioRecordMgr", "stop record success");
      this.gNJ = null;
      d.amg();
      return;
      y.e("MicroMsg.Record.AudioRecordMgr", "mRecorder is null, has stop record!");
      bool = true;
      continue;
      l1 = System.currentTimeMillis();
      l2 = System.currentTimeMillis() - this.mStartTime;
      y.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.gNP) });
      this.gNP = ((int)(this.gNP + l2));
      this.gNO = (this.mDuration - this.gNP);
      y.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.gNO), Integer.valueOf(this.gNP) });
    }
  }
  
  private ah ams()
  {
    if (this.gNQ == null) {
      this.gNQ = new ah(Looper.getMainLooper());
    }
    return this.gNQ;
  }
  
  private void stopTimer()
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "stopTimer");
    if (this.gNn != null) {
      this.gNn.stopTimer();
    }
    this.gNn = null;
  }
  
  public final boolean amn()
  {
    return this.gNK == g.a.gOd;
  }
  
  final void amq()
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "pause record in runnable");
    for (;;)
    {
      try
      {
        if (uf())
        {
          y.e("MicroMsg.Record.AudioRecordMgr", "is paused, don't pause again");
          return;
        }
        if (this.gNH == null) {
          break label392;
        }
        bool1 = this.gNH.uh();
        this.gNH = null;
        if ((this.gNJ != null) && (this.gNJ.gOK != null))
        {
          boolean bool2 = this.gNJ.gOK.amj();
          y.i("MicroMsg.Record.AudioRecordMgr", "isInterrupted:%b, interrupted:%b", new Object[] { Boolean.valueOf(this.gNS), Boolean.valueOf(bool2) });
          if ((bool2) && (!this.gNS)) {
            amt();
          }
        }
        ams().post(new Runnable()
        {
          public final void run()
          {
            g.k(g.this);
          }
        });
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.mStartTime;
        y.i("MicroMsg.Record.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.gNP) });
        this.gNP = ((int)(this.gNP + l2));
        this.gNO = (this.mDuration - this.gNP);
        y.i("MicroMsg.Record.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[] { Long.valueOf(this.gNO), Integer.valueOf(this.gNP) });
      }
      catch (Exception localException)
      {
        lq locallq;
        y.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", localException, "_pause", new Object[0]);
        bool1 = false;
        continue;
        onError(8);
        y.e("MicroMsg.Record.AudioRecordMgr", "pause record fail");
        return;
      }
      y.i("MicroMsg.Record.AudioRecordMgr", "stop:%b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        y.i("MicroMsg.Record.AudioRecordMgr", "onPause");
        this.gNK = g.a.gOc;
        this.mIsRecording = false;
        locallq = new lq();
        locallq.bUI.action = 3;
        locallq.bUI.state = "pause";
        if (this.gNJ != null) {
          locallq.bUI.appId = this.gNJ.appId;
        }
        com.tencent.mm.sdk.b.a.udP.a(locallq, Looper.getMainLooper());
        y.i("MicroMsg.Record.AudioRecordMgr", "pause record success");
        return;
      }
      label392:
      boolean bool1 = false;
    }
  }
  
  protected final void amt()
  {
    this.gNS = true;
    y.i("MicroMsg.Record.AudioRecordMgr", "onInterruptionBegin");
    lq locallq = new lq();
    locallq.bUI.action = 6;
    locallq.bUI.state = "interruptionBegin";
    if (this.gNJ != null) {
      locallq.bUI.appId = this.gNJ.appId;
    }
    com.tencent.mm.sdk.b.a.udP.a(locallq, Looper.getMainLooper());
  }
  
  protected final void onError(int paramInt)
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "onError errType:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.gNK != g.a.gOe)
    {
      localObject1 = new ArrayList();
      localObject2 = new IDKey();
      ((IDKey)localObject2).SetID(689);
      ((IDKey)localObject2).SetKey(1);
      ((IDKey)localObject2).SetValue(1L);
      localObject3 = new IDKey();
      ((IDKey)localObject3).SetID(689);
      ((IDKey)localObject3).SetKey(i.lT(paramInt));
      ((IDKey)localObject3).SetValue(1L);
      ((ArrayList)localObject1).add(localObject2);
      ((ArrayList)localObject1).add(localObject3);
      com.tencent.mm.plugin.report.service.h.nFQ.b((ArrayList)localObject1, true);
    }
    this.gNK = g.a.gOe;
    this.mIsRecording = false;
    Object localObject1 = new lq();
    ((lq)localObject1).bUI.action = 4;
    ((lq)localObject1).bUI.state = "error";
    if (this.gNJ != null) {
      ((lq)localObject1).bUI.appId = this.gNJ.appId;
    }
    ((lq)localObject1).bUI.errCode = paramInt;
    Object localObject2 = ((lq)localObject1).bUI;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("errType:" + paramInt + ", err:");
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    default: 
      ((StringBuilder)localObject3).append("unknow error");
    }
    for (;;)
    {
      ((lq.a)localObject2).aox = ((StringBuilder)localObject3).toString();
      com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
      return;
      ((StringBuilder)localObject3).append("error PCM record callback");
      continue;
      ((StringBuilder)localObject3).append("init encoder fail, occur exception");
      continue;
      ((StringBuilder)localObject3).append("encoder un initial occur exception");
      continue;
      ((StringBuilder)localObject3).append("start record occur exception");
      continue;
      ((StringBuilder)localObject3).append("resume record occur exception");
      continue;
      ((StringBuilder)localObject3).append("fail to start record");
      continue;
      ((StringBuilder)localObject3).append("fail to resume record");
      continue;
      ((StringBuilder)localObject3).append("fail to pause record");
      continue;
      ((StringBuilder)localObject3).append("fail to stop record");
      continue;
      ((StringBuilder)localObject3).append("check param invalid");
      continue;
      ((StringBuilder)localObject3).append("not support format type");
      continue;
      ((StringBuilder)localObject3).append("fail to init mp3 encoder");
      continue;
      ((StringBuilder)localObject3).append("mp3 file not found exception");
      continue;
      ((StringBuilder)localObject3).append("mp3 encode exception");
      continue;
      ((StringBuilder)localObject3).append("mp3 write buffer exception");
      continue;
      ((StringBuilder)localObject3).append("fail to init aac encoder");
      continue;
      ((StringBuilder)localObject3).append("fail to create mp4 file");
      continue;
      ((StringBuilder)localObject3).append("aac encode exception");
      continue;
      ((StringBuilder)localObject3).append("create cache file fail");
      continue;
      ((StringBuilder)localObject3).append("init encoder fail");
      continue;
      ((StringBuilder)localObject3).append("not support sample rate");
    }
  }
  
  public final boolean uf()
  {
    return this.gNK == g.a.gOc;
  }
  
  public final boolean uh()
  {
    y.i("MicroMsg.Record.AudioRecordMgr", "stopRecord");
    if ((this.gNH == null) && (this.gNL == null))
    {
      y.e("MicroMsg.Record.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
      return false;
    }
    com.tencent.mm.sdk.f.e.post(new g.10(this), "app_brand_stop_record");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g
 * JD-Core Version:    0.7.0.1
 */