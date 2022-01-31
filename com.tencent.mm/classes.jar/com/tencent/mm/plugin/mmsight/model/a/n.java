package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class n
  implements d
{
  protected String cqq;
  protected boolean eLc;
  protected int eRm;
  protected Point fav;
  private final Object fbZ;
  protected Runnable fcA;
  protected boolean fcB;
  protected boolean fcC;
  protected boolean fcD;
  protected f fcP;
  protected String fca;
  protected int fcb;
  protected float fcc;
  private int fcd;
  private float fce;
  protected c fcf;
  protected int fch;
  protected int fci;
  protected int fcj;
  protected int fck;
  protected int fcl;
  protected s fcm;
  protected int fcn;
  protected String fco;
  protected boolean fcp;
  protected String fcq;
  protected boolean fcr;
  protected b fcs;
  protected b fct;
  protected VideoTransPara fcu;
  protected m fcv;
  protected boolean fcw;
  protected boolean fcx;
  protected int fcy;
  protected d.a fcz;
  protected boolean fdl;
  protected String mFileName;
  protected volatile q oJw;
  protected HandlerThread oJx;
  protected ak oJy;
  protected int oJz;
  protected String thumbPath;
  
  public n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76639);
    this.fbZ = new Object();
    this.fca = "";
    this.fcb = 0;
    this.fcc = 0.0F;
    this.fcd = -1;
    this.fce = -1.0F;
    this.fch = 480;
    this.fci = 640;
    this.fcj = 1600000;
    this.fck = 480;
    this.fcl = 640;
    this.fco = null;
    this.oJz = 0;
    this.fdl = false;
    this.fcp = false;
    this.thumbPath = null;
    this.fcq = null;
    this.fcr = false;
    this.fav = null;
    this.fcs = new b("yuvRecorderWriteData");
    this.fct = new b("frameCountCallback");
    this.eLc = false;
    this.fcw = false;
    this.cqq = "";
    this.fcx = false;
    this.fcy = 0;
    this.fcA = null;
    this.fcB = false;
    this.fcC = true;
    this.fcD = false;
    this.fcP = new n.1(this);
    this.fcu = paramVideoTransPara;
    this.fch = paramVideoTransPara.width;
    this.fci = paramVideoTransPara.height;
    this.fcj = paramVideoTransPara.videoBitrate;
    k.bRq();
    int i = k.bRs();
    if (i == -1) {}
    for (this.fcj = paramVideoTransPara.videoBitrate;; this.fcj = i)
    {
      this.fcm = new s();
      ab.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.fch), Integer.valueOf(this.fci), Integer.valueOf(this.fcj) });
      AppMethodBeat.o(76639);
      return;
    }
  }
  
  private boolean kl(int paramInt)
  {
    AppMethodBeat.i(76640);
    long l = bo.yB();
    this.fdl = com.tencent.mm.plugin.mmsight.model.j.oHG.fdl;
    int i = this.fcj;
    this.eRm = SightVideoJNI.initDataBufferForMMSightLock(this.fck, this.fcl, paramInt, this.fch, this.fci, this.fcu.fps, i, this.fcu.fzW, 8, this.fcu.fzV, 23.0F, false, false, this.fcu.duration, false);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.eRm) });
    if (this.eRm < 0)
    {
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.bQZ();
      AppMethodBeat.o(76640);
      return false;
    }
    this.fcn = paramInt;
    this.oJw = new q(this.fck, this.fcl, this.fch, this.fci, this.fcj, this.fcu.fzU, this.fcu.fps, this.fdl);
    int j = this.oJw.eF(this.eRm, paramInt);
    paramInt = 0;
    if (!this.fcD)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(ac.a.yEc, -1);
      }
      if (i < 0)
      {
        this.fcf = new g(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
        this.fcf.jn(this.fcB);
        paramInt = this.fcf.t(this.eRm, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
        if ((j < 0) || (paramInt < 0))
        {
          ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt < 0) && (j >= 0))
          {
            ab.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
            this.fcf.clear();
            this.fcf = new i(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
            this.fcf.jn(this.fcB);
            paramInt = this.fcf.t(this.eRm, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
            ab.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
            if (paramInt >= 0)
            {
              AppMethodBeat.o(76640);
              return true;
            }
          }
          SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
          com.tencent.mm.plugin.mmsight.model.k.bQZ();
          AppMethodBeat.o(76640);
          return false;
        }
      }
      else
      {
        if (i == 1)
        {
          this.fcf = new g(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
          this.fcf.jn(this.fcB);
          paramInt = this.fcf.t(this.eRm, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
        }
        while ((j < 0) || (paramInt < 0))
        {
          ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
          com.tencent.mm.plugin.mmsight.model.k.bQZ();
          AppMethodBeat.o(76640);
          return false;
          if (i == 2)
          {
            this.fcf = new i(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
            this.fcf.jn(this.fcB);
            paramInt = this.fcf.t(this.eRm, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
          }
        }
      }
    }
    else if (j < 0)
    {
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
      com.tencent.mm.plugin.mmsight.model.k.bQZ();
      AppMethodBeat.o(76640);
      return false;
    }
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(76640);
    return true;
  }
  
  public final String Al()
  {
    AppMethodBeat.i(76646);
    String str = bo.bf(this.cqq, "");
    AppMethodBeat.o(76646);
    return str;
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76655);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIO))
    {
      if (this.oJw != null)
      {
        q localq = this.oJw;
        localq.oJI = paramInt1;
        localq.oJJ = paramInt2;
        localq.oJK = paramInt3;
        ab.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.fcm.a(d.c.oIG);
    }
    AppMethodBeat.o(76655);
  }
  
  public final boolean XA()
  {
    return this.fcw;
  }
  
  public final c.a XB()
  {
    AppMethodBeat.i(76656);
    if (this.fcf != null)
    {
      c.a locala = this.fcf.bRl();
      AppMethodBeat.o(76656);
      return locala;
    }
    AppMethodBeat.o(76656);
    return null;
  }
  
  public final void XC()
  {
    this.fcC = false;
  }
  
  public final long Xf()
  {
    AppMethodBeat.i(76650);
    if (this.oJw != null)
    {
      long l = this.oJw.UQ();
      AppMethodBeat.o(76650);
      return l;
    }
    AppMethodBeat.o(76650);
    return 0L;
  }
  
  public final String Xi()
  {
    return this.thumbPath;
  }
  
  final boolean Xs()
  {
    AppMethodBeat.i(76645);
    long l = bo.yB();
    int i;
    if ((this.oJx != null) && (this.oJy != null))
    {
      if (com.tencent.mm.compatible.util.d.fv(18))
      {
        this.oJx.quitSafely();
        this.oJy = null;
      }
    }
    else
    {
      i = this.oJw.frameCount;
      this.fcc = (i * 1000.0F / this.fcb);
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.fcc), Integer.valueOf(this.fcb), this.fca, Long.valueOf(bo.av(l)), Integer.valueOf(this.fcd), Float.valueOf(this.fce) });
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.fct.getValue() });
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.fcs.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label375;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (bo.isNullOrNil(str)) {
        break label407;
      }
    }
    label407:
    for (String str = com.tencent.mm.plugin.mmsight.d.TV(str);; str = this.fca)
    {
      i = this.fcb;
      if (this.fcd > 0) {
        i = this.fcd;
      }
      float f = this.fcc;
      if (this.fce > 0.0F) {
        f = this.fce;
      }
      this.fcv = new m(this.eRm, str, f, this.fcj, i, this.fcu.audioSampleRate, this.fcD);
      l = bo.yB();
      boolean bool = this.fcv.bRm();
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bo.av(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label416;
      }
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      com.tencent.mm.plugin.mmsight.model.k.bRa();
      AppMethodBeat.o(76645);
      return false;
      this.oJx.quit();
      break;
      label375:
      if (bo.isNullOrNil(this.fca)) {
        break label210;
      }
      str = new File(this.fca).getParentFile().getAbsolutePath();
      break label210;
    }
    label416:
    if (((this.fcx) && (this.fdl)) || ((!this.fdl) && (!this.fcx)) || ((this.fcx) && (Math.abs(this.fcn - this.fcy) == 0)) || (this.fcy == 180))
    {
      l = bo.yB();
      if ((this.fdl) || (this.fcx)) {
        break label754;
      }
      i = this.fcn;
    }
    for (;;)
    {
      int j = i;
      if (this.fcy == 180)
      {
        j = i;
        if (!this.fdl)
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
        SightVideoJNI.tagRotateVideo(str, this.fco, j);
        this.fcr = true;
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.fcn), Boolean.valueOf(this.fcx), Integer.valueOf(this.fcy), Integer.valueOf(j) });
        l = bo.yB();
      }
      try
      {
        e.deleteFile(str);
        e.aT(this.fco, str);
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bo.av(l)) });
        com.tencent.mm.sdk.g.d.post(new n.7(this, this.fco), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
        this.fcm.a(d.c.oIJ);
        this.cqq = com.tencent.mm.c.g.getMD5(str);
        if ((!bo.isNullOrNil(str)) && (!str.equals(this.fca)))
        {
          e.aT(str, this.fca);
          e.deleteFile(str);
        }
        AppMethodBeat.o(76645);
        return true;
      }
      catch (Exception localException)
      {
        label754:
        ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(76645);
      }
      if (this.fdl) {
        i = this.fcy;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String Xu()
  {
    return this.fcq;
  }
  
  public final float Xv()
  {
    return this.fcc;
  }
  
  public final d.c Xw()
  {
    return this.fcm.oJP;
  }
  
  public final int Xx()
  {
    AppMethodBeat.i(76652);
    int i = Math.round(this.fcb / 1000.0F);
    AppMethodBeat.o(76652);
    return i;
  }
  
  public final Point Xy()
  {
    AppMethodBeat.i(76653);
    Point localPoint = new Point(this.fck, this.fcl);
    AppMethodBeat.o(76653);
    return localPoint;
  }
  
  public final int Xz()
  {
    return this.fcn;
  }
  
  public final void a(d.a parama)
  {
    this.fcz = parama;
  }
  
  public final void ag(float paramFloat)
  {
    AppMethodBeat.i(76658);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.fce = paramFloat;
    AppMethodBeat.o(76658);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(76643);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.fcs.reset();
    this.fcb = 0;
    this.fct.reset();
    this.fcp = false;
    this.fcx = paramBoolean;
    this.fcy = paramInt2;
    this.fcm.a(d.c.oIF);
    if (bo.isNullOrNil(this.fca))
    {
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(76643);
      return -1;
    }
    try
    {
      this.mFileName = e.avM(this.fca);
      String str2 = e.avK(this.fca);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.fco = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.fcm.a(d.c.oIN);
        continue;
        ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.oJw.start();
        this.fcm.a(d.c.oIG);
        this.fcw = false;
        com.tencent.mm.plugin.mmsight.model.k.bQX();
        com.tencent.mm.plugin.mmsight.model.k.VF();
        paramInt1 = 0;
      }
    }
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.fca, this.fco });
    this.fcn = paramInt1;
    this.oJx = com.tencent.mm.sdk.g.d.ey("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.oJx.start();
    this.oJy = new n.2(this, this.oJx.getLooper());
    if (!this.eLc)
    {
      kl(paramInt1);
      this.eLc = true;
    }
    if ((!this.fcD) && (!this.fcB))
    {
      paramInt1 = this.fcf.a(new n.3(this));
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.fcw = false;
      if (paramInt1 != 0)
      {
        this.fcm.a(d.c.oIM);
        com.tencent.mm.plugin.mmsight.model.k.bQX();
        com.tencent.mm.plugin.mmsight.model.k.VF();
        AppMethodBeat.o(76643);
        return paramInt1;
      }
    }
  }
  
  protected final void ba(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76641);
    if (this.oJw != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.oJy != null) {
        this.oJy.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(76641);
  }
  
  public final void cG(boolean paramBoolean)
  {
    this.fcB = paramBoolean;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(76647);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.oJw == null) || ((this.fcf == null) && (!this.fcD)))
    {
      ab.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(76647);
      return;
    }
    this.fcm.a(d.c.oII);
    this.oJw.a(null);
    if (this.fcf != null) {
      this.fcf.a(new n.8(this));
    }
    if ((this.oJx != null) && (this.oJy != null))
    {
      this.oJy.removeMessages(0);
      this.oJx.quit();
      this.oJy = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
    this.fcm.a(d.c.oIJ);
    reset();
    AppMethodBeat.o(76647);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(76648);
    try
    {
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.fcf != null) {
        this.fcf.clear();
      }
      if (this.oJw != null) {
        this.oJw.clear();
      }
      AppMethodBeat.o(76648);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76648);
    }
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.fca;
  }
  
  public final f getFrameDataCallback()
  {
    return this.fcP;
  }
  
  public final boolean isLandscape()
  {
    return this.fcx;
  }
  
  public final boolean km(int paramInt)
  {
    AppMethodBeat.i(76642);
    if (!this.eLc)
    {
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = kl(paramInt);
      this.eLc = true;
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(76642);
      return bool;
    }
    AppMethodBeat.o(76642);
    return true;
  }
  
  public final void kn(int paramInt)
  {
    AppMethodBeat.i(76657);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.fcd = paramInt;
    AppMethodBeat.o(76657);
  }
  
  public final void mV(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void mW(String paramString)
  {
    this.fcq = paramString;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(76654);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIG)) {
      this.fcm.a(d.c.oIO);
    }
    AppMethodBeat.o(76654);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76649);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.oJw, this.fcf, this.fcv });
    synchronized (this.fbZ)
    {
      this.oJw = null;
      this.fcf = null;
      this.fcv = null;
      this.eLc = false;
      this.fcw = false;
      AppMethodBeat.o(76649);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76651);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.fch = paramInt3;
    this.fci = paramInt4;
    this.fck = paramInt1;
    this.fcl = paramInt2;
    if (j.oJp.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bo.yB();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.oJp.O(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    }
    AppMethodBeat.o(76651);
  }
  
  public final void setFilePath(String paramString)
  {
    this.fca = paramString;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fcD = paramBoolean;
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(76644);
    this.fcA = paramRunnable;
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.oJw == null) || ((this.fcf == null) && (!this.fcD)))
    {
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        al.d(paramRunnable);
      }
      AppMethodBeat.o(76644);
      return;
    }
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIJ))
    {
      ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.fcf != null) {
        this.fcf.clear();
      }
      if (this.oJw != null) {
        this.oJw.clear();
      }
      if (paramRunnable != null) {
        al.d(paramRunnable);
      }
      AppMethodBeat.o(76644);
      return;
    }
    this.fcP = null;
    this.fcb = ((int)this.oJw.UQ());
    if (this.fcm != null) {
      this.fcm.a(d.c.oIH);
    }
    if (this.oJw != null) {
      this.oJw.a(new n.4(this));
    }
    if (this.fcf != null) {
      this.fcf.a(new n.5(this));
    }
    AppMethodBeat.o(76644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */