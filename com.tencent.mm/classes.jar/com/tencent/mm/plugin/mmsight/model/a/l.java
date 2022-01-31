package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;

public final class l
  implements d
{
  private String bIW = "";
  private boolean dNv = false;
  int eJL = -1;
  boolean fwq = false;
  private String goM = null;
  int jWo = 0;
  private String mFileName;
  VideoTransPara mfr;
  boolean mhL = false;
  String mjA = null;
  private HandlerThread mjB = null;
  ah mjC = null;
  int mjD = -1;
  private boolean mjE = false;
  boolean mjF = false;
  private int mjG = -1;
  boolean mjH = false;
  int mjI = 0;
  d.a mjJ;
  private boolean mjK = false;
  boolean mjL = true;
  public boolean mjM = false;
  private f mjN = new f()
  {
    public final boolean M(byte[] paramAnonymousArrayOfByte)
    {
      boolean bool = true;
      if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0)) {
        bool = false;
      }
      do
      {
        return bool;
        if (l.this.mjn.mkz != d.c.miA) {
          break;
        }
        localObject = l.this;
        if ((!((l)localObject).mjF) && (((l)localObject).mjL))
        {
          ((l)localObject).mjF = true;
          byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
          System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
          com.tencent.mm.sdk.f.e.post(new l.7((l)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
        }
      } while (l.this.mjC == null);
      Object localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramAnonymousArrayOfByte;
      l.this.mjC.sendMessage((Message)localObject);
      return true;
      return false;
    }
  };
  c mjl;
  p mjm;
  s mjn;
  private l.a mjo = null;
  e mjp;
  String mjq = "";
  private int mjr = 0;
  private float mjs = 0.0F;
  int mjt = -1;
  float mju = -1.0F;
  private int mjv = 480;
  private int mjw = 640;
  int mjx = 1600000;
  int mjy = 480;
  int mjz = 640;
  String thumbPath = null;
  
  public l(VideoTransPara paramVideoTransPara)
  {
    this.mfr = paramVideoTransPara;
    this.mjv = paramVideoTransPara.width;
    this.mjw = paramVideoTransPara.height;
    this.mjx = paramVideoTransPara.videoBitrate;
    k.bjA();
    int i = k.bjC();
    if (i == -1) {}
    for (this.mjx = paramVideoTransPara.videoBitrate;; this.mjx = i)
    {
      this.mjn = new s();
      this.dNv = false;
      y.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.mjv), Integer.valueOf(this.mjw), Integer.valueOf(this.mjx), Integer.valueOf(i) });
      return;
    }
  }
  
  private boolean uc(int paramInt)
  {
    if ((this.mjo != null) && (!this.mjo.mjV))
    {
      if (!this.mjo.mjS)
      {
        this.mjo.bFJ = null;
        this.mjo.mjU = true;
        this.mjo.mjT = true;
        com.tencent.mm.sdk.f.e.remove(this.mjo);
      }
      synchronized (this.mjo.eJN)
      {
        SightVideoJNI.releaseBigSightDataBuffer(paramInt);
        if (this.mjo.mjP != paramInt) {
          SightVideoJNI.releaseBigSightDataBuffer(this.mjo.mjP);
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean ud(int paramInt)
  {
    long l = bk.UZ();
    this.mhL = com.tencent.mm.plugin.mmsight.model.j.mhB.mhL;
    this.jWo = paramInt;
    int j;
    label59:
    int n;
    int m;
    if (!this.mhL) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.mjy;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label161;
        }
        j = this.mjz;
        k = this.mjv;
        n = this.mjw;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.mjx;
      j = SightVideoJNI.initDataBufferForMMSight(m, j, paramInt, k, i, this.mfr.fps, n, this.mfr.ejP, 8, this.mfr.ejO, 23.0F, this.mhL, true, this.mfr.duration, false);
      if (j >= 0) {
        break label284;
      }
      y.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.biW();
      return false;
      i = this.mjz;
      break;
      label161:
      j = this.mjy;
      break label59;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.mjy;
        label185:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label252;
        }
        j = this.mjz;
        label201:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label260;
        }
      }
      label260:
      for (k = this.mjv;; k = this.mjw)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label269;
        }
        n = this.mjw;
        m = i;
        i = n;
        break;
        i = this.mjz;
        break label185;
        label252:
        j = this.mjy;
        break label201;
      }
      label269:
      n = this.mjv;
      m = i;
      i = n;
    }
    label284:
    this.mjG = j;
    this.mjm = new p(this.mhL, paramInt, k, i);
    int k = this.mjm.ue(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ac.a.utZ, -1);
    }
    if (i < 0)
    {
      this.mjl = new g(this.mfr.audioSampleRate, this.mfr.ejM);
      this.mjl.ht(this.mjK);
      paramInt = this.mjl.au(j, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
      if ((k < 0) || (paramInt < 0))
      {
        y.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt < 0) && (k >= 0))
        {
          y.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
          this.mjl.clear();
          this.mjl = new i(this.mfr.audioSampleRate, this.mfr.ejM);
          this.mjl.ht(this.mjK);
          paramInt = this.mjl.au(j, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
          y.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt >= 0) {
            return true;
          }
        }
        SightVideoJNI.releaseBigSightDataBuffer(j);
        com.tencent.mm.plugin.mmsight.model.k.biW();
        return false;
      }
    }
    else
    {
      if (i == 1)
      {
        this.mjl = new g(this.mfr.audioSampleRate, this.mfr.ejM);
        this.mjl.ht(this.mjK);
        paramInt = this.mjl.au(j, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
      }
      while ((k < 0) || (paramInt < 0))
      {
        y.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBuffer(j);
        com.tencent.mm.plugin.mmsight.model.k.biW();
        return false;
        if (i == 2)
        {
          this.mjl = new i(this.mfr.audioSampleRate, this.mfr.ejM);
          this.mjl.ht(this.mjK);
          paramInt = this.mjl.au(j, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
        }
      }
    }
    y.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
    return true;
  }
  
  public final void In(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void Io(String paramString)
  {
    this.goM = paramString;
  }
  
  public final void M(final Runnable paramRunnable)
  {
    boolean bool1;
    boolean bool2;
    if (this.mjo == null)
    {
      bool1 = true;
      if ((this.mjo == null) || (!this.mjo.mjS)) {
        break label211;
      }
      bool2 = true;
      label28:
      if ((this.mjo == null) || (!this.mjo.mjT)) {
        break label216;
      }
    }
    label211:
    label216:
    for (boolean bool3 = true;; bool3 = false)
    {
      y.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((this.mjo != null) && (this.mjo.mjS)) {
        synchronized (this.mjo.eJN)
        {
          reset();
          ai.d(paramRunnable);
          return;
        }
      }
      y.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.mjM), this.mjC });
      if ((this.mjM) && (this.mjC != null))
      {
        this.mjC.post(new Runnable()
        {
          public final void run()
          {
            l.a(l.this, paramRunnable);
          }
        });
        return;
      }
      com.tencent.mm.sdk.f.e.post(new l.3(this, paramRunnable), "MMSightFFMpegRecorder_stop");
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
    }
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.mjn != null) && (this.mjn.mkz == d.c.miI))
    {
      if (this.mjm != null)
      {
        p localp = this.mjm;
        y.i("MicroMsg.MMSightX264YUVRecorder", "resume, newRotate: %s, frameWidth: %s, frameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        localp.mks = paramInt1;
        localp.mkt = paramInt2;
        localp.mku = paramInt3;
      }
      this.mjn.a(d.c.miA);
    }
  }
  
  public final String Wv()
  {
    return bk.aM(this.bIW, "");
  }
  
  public final void a(d.a parama)
  {
    this.mjJ = parama;
  }
  
  public final String aXs()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.mju = paramFloat;
  }
  
  public final boolean biH()
  {
    return this.fwq;
  }
  
  final void bjj()
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.mjo != null) && (!this.mjo.mjV)) {
      y.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.mjo });
    }
    synchronized (this.mjo.eJN)
    {
      uc(this.mjo.mjP);
      if (this.mjn.mkz != d.c.miH)
      {
        y.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        return;
      }
    }
    this.mjn.a(d.c.miA);
    this.mjo = new l.a(this);
    this.mjo.mjP = this.mjG;
    com.tencent.mm.sdk.f.e.a(this.mjo, "SightCustomAsyncMediaRecorder_encode_" + bk.UZ(), 5);
  }
  
  final void bjk()
  {
    if (this.mjo != null) {
      this.mjo.mjT = true;
    }
  }
  
  public final String bjl()
  {
    return this.mjq;
  }
  
  public final String bjm()
  {
    return this.goM;
  }
  
  public final float bjn()
  {
    return this.mjs;
  }
  
  public final long bjo()
  {
    return this.mjm.bjH();
  }
  
  public final f bjp()
  {
    return this.mjN;
  }
  
  public final d.c bjq()
  {
    return this.mjn.mkz;
  }
  
  public final int bjr()
  {
    return Math.round(this.mjr / 1000.0F);
  }
  
  public final Point bjs()
  {
    return new Point(this.mjy, this.mjz);
  }
  
  public final int bjt()
  {
    return this.jWo;
  }
  
  public final boolean bju()
  {
    return this.mjH;
  }
  
  public final c.a bjv()
  {
    if (this.mjl != null) {
      return this.mjl.bji();
    }
    return null;
  }
  
  public final void bjw()
  {
    this.mjL = false;
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.mjn.a(d.c.miC);
    clear();
    this.mjn.a(d.c.miD);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    int i = -1;
    if (this.mjm != null)
    {
      i = this.mjm.mkq;
      if (i < 0)
      {
        y.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        return;
      }
      this.mjm.stop();
    }
    if (this.mjl != null) {
      this.mjl.a(null);
    }
    boolean bool1;
    if (this.mjo == null)
    {
      bool1 = true;
      label66:
      if ((this.mjo == null) || (!this.mjo.mjU)) {
        break label144;
      }
    }
    for (;;)
    {
      y.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i < 0) || (uc(i))) {
        break;
      }
      SightVideoJNI.releaseRecorderBufferRef("clear");
      SightVideoJNI.releaseBigSightDataBuffer(i);
      return;
      bool1 = false;
      break label66;
      label144:
      bool2 = false;
    }
  }
  
  public final int d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.mjn.mkz, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.fwq = paramBoolean;
    this.mjr = 0;
    this.mjI = paramInt2;
    this.mjn.a(d.c.miz);
    Object localObject = this.mjq;
    if (this.mjo == null)
    {
      paramBoolean = true;
      if ((this.mjo != null) && (!this.mjo.mjV)) {
        break label169;
      }
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { localObject, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.mjo == null) || (this.mjo.mjV)) {
        break label175;
      }
      y.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      paramInt2 = -1;
      return paramInt2;
      paramBoolean = false;
      break;
    }
    label175:
    if (bk.bl(this.mjq))
    {
      y.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.e.aeV(this.mjq);
    y.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.mjq });
    this.jWo = paramInt1;
    y.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.jWo) });
    if (!this.dNv)
    {
      ud(paramInt1);
      this.dNv = true;
    }
    localObject = this.mjm;
    if (0L == ((p)localObject).ibp) {
      ((p)localObject).ibp = System.currentTimeMillis();
    }
    if (!this.mjK)
    {
      paramInt1 = this.mjl.a(new l.5(this));
      label319:
      y.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.mjB = com.tencent.mm.sdk.f.e.ds("BigSightWriteCameraData", 0);
      this.mjB.start();
      this.mjC = new l.6(this, this.mjB.getLooper());
      this.mjH = false;
      if (paramInt1 == 0) {
        break label438;
      }
      this.mjn.a(d.c.miG);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.k.biU();
      y.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.nFQ.a(440L, 1L, 1L, false);
      paramInt2 = paramInt1;
      if (!this.mjK) {
        break;
      }
      bjj();
      return paramInt1;
      paramInt1 = 0;
      break label319;
      label438:
      this.mjn.a(d.c.miH);
    }
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final void hu(boolean paramBoolean)
  {
    this.mjK = paramBoolean;
  }
  
  public final void pause()
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.mjn != null) && (this.mjn.mkz == d.c.miA)) {
      this.mjn.a(d.c.miI);
    }
  }
  
  public final void reset()
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.mjn.mkz = d.c.miD;
    this.mjH = false;
    if (this.mjl != null) {
      this.mjl.clear();
    }
    p localp;
    if (this.mjm != null)
    {
      localp = this.mjm;
      SightVideoJNI.releaseBigSightDataBuffer(localp.mkq);
      localp.mkq = -1;
    }
    try
    {
      localp.frameCount = 0;
      localp.ibp = 0L;
      clear();
      return;
    }
    finally {}
  }
  
  public final void setFilePath(String paramString)
  {
    this.mjq = paramString;
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mjv = paramInt3;
    this.mjw = paramInt4;
    this.mjy = paramInt1;
    this.mjz = paramInt2;
    if (j.mji.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      y.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bk.UZ();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.mji.z(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      y.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
    }
  }
  
  public final boolean ua(int paramInt)
  {
    if (!this.dNv)
    {
      y.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = ud(paramInt);
      this.dNv = true;
      y.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    return true;
  }
  
  public final void ub(int paramInt)
  {
    y.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.mjt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */