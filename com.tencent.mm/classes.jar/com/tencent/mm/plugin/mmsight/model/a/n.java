package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.f.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import java.io.File;

public class n
  implements d
{
  protected String bIW = "";
  protected boolean dNv = false;
  protected int eIz;
  protected boolean fwq = false;
  protected boolean gEx = false;
  protected String goM = null;
  protected int jWo;
  protected String mFileName;
  protected VideoTransPara mfr;
  protected Point mgH = null;
  protected boolean mhL = false;
  protected String mjA = null;
  protected boolean mjE = false;
  protected boolean mjF = false;
  protected boolean mjH = false;
  protected int mjI = 0;
  protected d.a mjJ;
  protected boolean mjL = true;
  protected f mjN = new n.1(this);
  private final Object mjZ = new Object();
  public s mjn;
  protected String mjq = "";
  protected int mjr = 0;
  protected float mjs = 0.0F;
  private int mjt = -1;
  private float mju = -1.0F;
  protected int mjv = 480;
  protected int mjw = 640;
  protected int mjx = 1600000;
  protected int mjy = 480;
  protected int mjz = 640;
  protected c mka;
  protected volatile q mkb;
  protected m mkc;
  protected HandlerThread mkd;
  protected ah mke;
  protected int mkf = 0;
  protected b mkg = new b("yuvRecorderWriteData");
  public b mkh = new b("frameCountCallback");
  protected Runnable mki = null;
  protected boolean mkj = false;
  protected String thumbPath = null;
  
  public n(VideoTransPara paramVideoTransPara)
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
      y.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.mjv), Integer.valueOf(this.mjw), Integer.valueOf(this.mjx) });
      return;
    }
  }
  
  private boolean ud(int paramInt)
  {
    long l = bk.UZ();
    this.mhL = com.tencent.mm.plugin.mmsight.model.j.mhB.mhL;
    int i = this.mjx;
    this.eIz = SightVideoJNI.initDataBufferForMMSightLock(this.mjy, this.mjz, paramInt, this.mjv, this.mjw, this.mfr.fps, i, this.mfr.ejP, 8, this.mfr.ejO, 23.0F, false, false, this.mfr.duration, false);
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.eIz) });
    if (this.eIz < 0)
    {
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.biX();
      return false;
    }
    this.jWo = paramInt;
    this.mkb = new q(this.mjy, this.mjz, this.mjv, this.mjw, this.mjx, this.mfr.ejN, this.mfr.fps, this.mhL);
    int j = this.mkb.dg(this.eIz, paramInt);
    paramInt = 0;
    if (!this.gEx)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(ac.a.utZ, -1);
      }
      if (i < 0)
      {
        this.mka = new g(this.mfr.audioSampleRate, this.mfr.ejM);
        this.mka.ht(this.mkj);
        paramInt = this.mka.au(this.eIz, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
        if ((j < 0) || (paramInt < 0))
        {
          y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt < 0) && (j >= 0))
          {
            y.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
            this.mka.clear();
            this.mka = new i(this.mfr.audioSampleRate, this.mfr.ejM);
            this.mka.ht(this.mkj);
            paramInt = this.mka.au(this.eIz, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
            y.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
            if (paramInt >= 0) {
              return true;
            }
          }
          SightVideoJNI.releaseBigSightDataBufferLock(this.eIz);
          com.tencent.mm.plugin.mmsight.model.k.biX();
          return false;
        }
      }
      else
      {
        if (i == 1)
        {
          this.mka = new g(this.mfr.audioSampleRate, this.mfr.ejM);
          this.mka.ht(this.mkj);
          paramInt = this.mka.au(this.eIz, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
        }
        while ((j < 0) || (paramInt < 0))
        {
          y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.eIz);
          com.tencent.mm.plugin.mmsight.model.k.biX();
          return false;
          if (i == 2)
          {
            this.mka = new i(this.mfr.audioSampleRate, this.mfr.ejM);
            this.mka.ht(this.mkj);
            paramInt = this.mka.au(this.eIz, com.tencent.mm.plugin.sight.base.d.MF(this.mjq));
          }
        }
      }
    }
    else if (j < 0)
    {
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBuffer(this.eIz);
      com.tencent.mm.plugin.mmsight.model.k.biX();
      return false;
    }
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
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
  
  public final void M(Runnable paramRunnable)
  {
    this.mki = paramRunnable;
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.mkb == null) || ((this.mka == null) && (!this.gEx)))
    {
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        ai.d(paramRunnable);
      }
    }
    do
    {
      do
      {
        return;
        if ((this.mjn == null) || (this.mjn.mkz != d.c.miD)) {
          break;
        }
        y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
        if (this.mka != null) {
          this.mka.clear();
        }
        if (this.mkb != null) {
          this.mkb.clear();
        }
      } while (paramRunnable == null);
      ai.d(paramRunnable);
      return;
      this.mjN = null;
      this.mjr = ((int)this.mkb.bjH());
      if (this.mjn != null) {
        this.mjn.a(d.c.miB);
      }
      if (this.mkb != null) {
        this.mkb.a(new n.4(this));
      }
    } while (this.mka == null);
    this.mka.a(new n.5(this));
  }
  
  public final void N(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.mjn != null) && (this.mjn.mkz == d.c.miI))
    {
      if (this.mkb != null)
      {
        q localq = this.mkb;
        localq.mks = paramInt1;
        localq.mkt = paramInt2;
        localq.mku = paramInt3;
        y.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
  
  public final void aC(byte[] paramArrayOfByte)
  {
    if (this.mkb != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.mke != null) {
        this.mke.sendMessage(localMessage);
      }
    }
  }
  
  public final String aXs()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.mju = paramFloat;
  }
  
  public final boolean biH()
  {
    return this.fwq;
  }
  
  final boolean bjF()
  {
    long l = bk.UZ();
    int i;
    if ((this.mkd != null) && (this.mke != null))
    {
      if (com.tencent.mm.compatible.util.d.gF(18))
      {
        this.mkd.quitSafely();
        this.mke = null;
      }
    }
    else
    {
      i = this.mkb.frameCount;
      this.mjs = (i * 1000.0F / this.mjr);
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.mjs), Integer.valueOf(this.mjr), this.mjq, Long.valueOf(bk.cp(l)), Integer.valueOf(this.mjt), Float.valueOf(this.mju) });
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.mkh.getValue() });
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.mkg.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label383;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label204:
      if (bk.bl(str)) {
        break label415;
      }
    }
    label415:
    for (String str = com.tencent.mm.plugin.mmsight.d.Ij(str);; str = this.mjq)
    {
      i = this.mjr;
      if (this.mjt > 0) {
        i = this.mjt;
      }
      float f = this.mjs;
      if (this.mju > 0.0F) {
        f = this.mju;
      }
      this.mkc = new m(this.eIz, str, f, this.mjx, i, this.mfr.audioSampleRate, this.gEx);
      l = bk.UZ();
      boolean bool = this.mkc.bjx();
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bk.cp(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label424;
      }
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      y.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
      h.nFQ.a(440L, 31L, 1L, false);
      return false;
      this.mkd.quit();
      break;
      label383:
      if (bk.bl(this.mjq)) {
        break label204;
      }
      str = new File(this.mjq).getParentFile().getAbsolutePath();
      break label204;
    }
    label424:
    if (((this.fwq) && (this.mhL)) || ((!this.mhL) && (!this.fwq)) || ((this.fwq) && (Math.abs(this.jWo - this.mjI) == 0)) || (this.mjI == 180))
    {
      l = bk.UZ();
      if ((this.mhL) || (this.fwq)) {
        break label755;
      }
      i = this.jWo;
    }
    for (;;)
    {
      int j = i;
      if (this.mjI == 180)
      {
        j = i;
        if (!this.mhL)
        {
          i += 180;
          j = i;
          if (i > 360) {
            j = i - 360;
          }
        }
      }
      if (j > 0)
      {
        SightVideoJNI.tagRotateVideo(str, this.mjA, j);
        this.mjE = true;
        y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.jWo), Boolean.valueOf(this.fwq), Integer.valueOf(this.mjI), Integer.valueOf(j) });
        l = bk.UZ();
      }
      try
      {
        com.tencent.mm.vfs.e.deleteFile(str);
        com.tencent.mm.vfs.e.aA(this.mjA, str);
        y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bk.cp(l)) });
        com.tencent.mm.sdk.f.e.post(new n.7(this, this.mjA), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.eIz);
        this.mjn.a(d.c.miD);
        this.bIW = com.tencent.mm.c.g.bQ(str);
        if ((!bk.bl(str)) && (!str.equals(this.mjq)))
        {
          com.tencent.mm.vfs.e.aA(str, this.mjq);
          com.tencent.mm.vfs.e.deleteFile(str);
        }
        return true;
      }
      catch (Exception localException)
      {
        label755:
        y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
      }
      if (this.mhL) {
        i = this.mjI;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final void bjG()
  {
    this.gEx = true;
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
    if (this.mkb != null) {
      return this.mkb.bjH();
    }
    return 0L;
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
    if (this.mka != null) {
      return this.mka.bji();
    }
    return null;
  }
  
  public final void bjw()
  {
    this.mjL = false;
  }
  
  public void cancel()
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.mkb == null) || ((this.mka == null) && (!this.gEx)))
    {
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      return;
    }
    this.mjn.a(d.c.miC);
    this.mkb.a(null);
    if (this.mka != null) {
      this.mka.a(new n.8(this));
    }
    if ((this.mkd != null) && (this.mke != null))
    {
      this.mke.removeMessages(0);
      this.mkd.quit();
      this.mke = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.eIz);
    this.mjn.a(d.c.miD);
    reset();
  }
  
  public final void clear()
  {
    try
    {
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.mka != null) {
        this.mka.clear();
      }
      if (this.mkb != null) {
        this.mkb.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final int d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.mkg.reset();
    this.mjr = 0;
    this.mkh.reset();
    this.mjF = false;
    this.fwq = paramBoolean;
    this.mjI = paramInt2;
    this.mjn.a(d.c.miz);
    if (bk.bl(this.mjq))
    {
      y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.e.aeV(this.mjq);
      String str2 = com.tencent.mm.vfs.e.aeS(this.mjq);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.mjA = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.mjn.a(d.c.miH);
      }
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
      this.mkb.start();
      this.mjn.a(d.c.miA);
      this.mjH = false;
      com.tencent.mm.plugin.mmsight.model.k.biU();
      com.tencent.mm.plugin.mmsight.model.k.biV();
    }
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.mjq, this.mjA });
    this.jWo = paramInt1;
    this.mkd = com.tencent.mm.sdk.f.e.ds("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.mkd.start();
    this.mke = new n.2(this, this.mkd.getLooper());
    if (!this.dNv)
    {
      ud(paramInt1);
      this.dNv = true;
    }
    if ((!this.gEx) && (!this.mkj))
    {
      paramInt1 = this.mka.a(new n.3(this));
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.mjH = false;
      if (paramInt1 != 0)
      {
        this.mjn.a(d.c.miG);
        com.tencent.mm.plugin.mmsight.model.k.biU();
        com.tencent.mm.plugin.mmsight.model.k.biV();
        return paramInt1;
      }
    }
    return 0;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final int getFrameCount()
  {
    if (this.mkb != null) {
      return this.mkb.frameCount;
    }
    return 0;
  }
  
  public final void hu(boolean paramBoolean)
  {
    this.mkj = paramBoolean;
  }
  
  public final void pause()
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.mjn != null) && (this.mjn.mkz == d.c.miA)) {
      this.mjn.a(d.c.miI);
    }
  }
  
  public final void reset()
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.mkb, this.mka, this.mkc });
    synchronized (this.mjZ)
    {
      this.mkb = null;
      this.mka = null;
      this.mkc = null;
      this.dNv = false;
      this.mjH = false;
      return;
    }
  }
  
  public final void setFilePath(String paramString)
  {
    this.mjq = paramString;
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.mjv = paramInt3;
    this.mjw = paramInt4;
    this.mjy = paramInt1;
    this.mjz = paramInt2;
    if (j.mji.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bk.UZ();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.mji.z(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bk.cp(l)) });
    }
  }
  
  public final boolean ua(int paramInt)
  {
    if (!this.dNv)
    {
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = ud(paramInt);
      this.dNv = true;
      y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    return true;
  }
  
  public final void ub(int paramInt)
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.mjt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */