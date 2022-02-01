package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;

public final class n
  implements d
{
  protected int gNJ;
  protected Point gXK;
  protected boolean gkP;
  protected boolean hbQ;
  private final Object hcD;
  protected String hcE;
  protected int hcF;
  protected float hcG;
  private int hcH;
  private float hcI;
  protected c hcJ;
  protected int hcL;
  protected int hcM;
  protected int hcN;
  protected int hcO;
  protected int hcP;
  protected s hcQ;
  protected int hcR;
  protected String hcT;
  protected boolean hcU;
  protected String hcV;
  protected boolean hcW;
  protected com.tencent.mm.plugin.mmsight.model.c hcX;
  protected com.tencent.mm.plugin.mmsight.model.c hcY;
  protected VideoTransPara hcZ;
  protected boolean hdT;
  protected m hda;
  protected boolean hdb;
  protected int hdc;
  protected d.a hdd;
  protected Runnable hde;
  protected boolean hdf;
  protected boolean hdg;
  protected boolean hdh;
  protected com.tencent.mm.plugin.mmsight.model.g hdv;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  protected volatile q uNc;
  protected HandlerThread uNd;
  protected ao uNe;
  protected int uNf;
  
  public n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.hcD = new Object();
    this.hcE = "";
    this.hcF = 0;
    this.hcG = 0.0F;
    this.hcH = -1;
    this.hcI = -1.0F;
    this.hcL = 480;
    this.hcM = 640;
    this.hcN = 1600000;
    this.hcO = 480;
    this.hcP = 640;
    this.hcT = null;
    this.uNf = 0;
    this.hdT = false;
    this.hcU = false;
    this.thumbPath = null;
    this.hcV = null;
    this.hcW = false;
    this.gXK = null;
    this.hcX = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hcY = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gkP = false;
    this.hdb = false;
    this.md5 = "";
    this.hbQ = false;
    this.hdc = 0;
    this.hde = null;
    this.hdf = false;
    this.hdg = true;
    this.hdh = false;
    this.hdv = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((n.this.hcQ.uNv == d.c.uMj) || (n.this.hcQ.uNv == d.c.uMk))
        {
          if (n.this.hcQ.uNv == d.c.uMk)
          {
            n.this.hcQ.uNv = d.c.uMl;
            ac.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          n.this.hcY.vW(1L);
          if (n.this.hcJ != null) {
            n.this.hcJ.ddM();
          }
          n.this.bp(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.hcZ = paramVideoTransPara;
    this.hcL = paramVideoTransPara.width;
    this.hcM = paramVideoTransPara.height;
    this.hcN = paramVideoTransPara.videoBitrate;
    k.ddS();
    int i = k.ddU();
    if (i == -1) {}
    for (this.hcN = paramVideoTransPara.videoBitrate;; this.hcN = i)
    {
      this.hcQ = new s();
      ac.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.hcL), Integer.valueOf(this.hcM), Integer.valueOf(this.hcN) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean nD(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = bs.Gn();
    this.hdT = com.tencent.mm.plugin.mmsight.model.k.uLk.hdT;
    int i = this.hcN;
    this.gNJ = SightVideoJNI.initDataBufferForMMSightLock(this.hcO, this.hcP, paramInt, this.hcL, this.hcM, this.hcZ.fps, i, this.hcZ.hCA, 8, this.hcZ.hCz, 23.0F, false, false, this.hcZ.duration, false);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.gNJ) });
    if (this.gNJ < 0)
    {
      ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      l.ddC();
      AppMethodBeat.o(89552);
      return false;
    }
    this.hcR = paramInt;
    this.uNc = new q(this.hcO, this.hcP, this.hcL, this.hcM, this.hcN, this.hcZ.hCy, this.hcZ.fps, this.hdT);
    int j = this.uNc.gi(this.gNJ, paramInt);
    paramInt = 0;
    if (!this.hdh)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(ah.a.GKs, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.hcZ.audioSampleRate;
        i = this.hcZ.audioBitrate;
        k = this.hcZ.gOt;
        if (this.hcZ.hCX == 1) {}
        for (bool = true;; bool = false)
        {
          this.hcJ = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.ac(false, bool));
          this.hcJ.nY(this.hdf);
          paramInt = this.hcJ.E(this.gNJ, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
          if ((j >= 0) && (paramInt >= 0)) {
            break label788;
          }
          ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          ac.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.hcJ.clear();
          this.hcJ = new i(this.hcZ.audioSampleRate, this.hcZ.audioBitrate, this.hcZ.gOt);
          this.hcJ.nY(this.hdf);
          paramInt = this.hcJ.E(this.gNJ, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
          ac.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
        l.ddC();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.hcZ.audioSampleRate;
        i = this.hcZ.audioBitrate;
        k = this.hcZ.gOt;
        if (this.hcZ.hCX == 1)
        {
          bool = true;
          this.hcJ = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.ac(false, bool));
          this.hcJ.nY(this.hdf);
          paramInt = this.hcJ.E(this.gNJ, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label788;
        }
        ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
        l.ddC();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.hcJ = new i(this.hcZ.audioSampleRate, this.hcZ.audioBitrate, this.hcZ.gOt);
          this.hcJ.nY(this.hdf);
          paramInt = this.hcJ.E(this.gNJ, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
        }
      }
    }
    if (j < 0)
    {
      ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
      l.ddC();
      AppMethodBeat.o(89552);
      return false;
    }
    label788:
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.hde = paramRunnable;
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.uNc == null) || ((this.hcJ == null) && (!this.hdh)))
    {
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        ap.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMm))
    {
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.hcJ != null) {
        this.hcJ.clear();
      }
      if (this.uNc != null) {
        this.uNc.clear();
      }
      if (paramRunnable != null) {
        ap.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.hdv = null;
    this.hcF = ((int)this.uNc.aqI());
    if (this.hcQ != null) {
      this.hcQ.a(d.c.uMk);
    }
    if (this.uNc != null) {
      this.uNc.a(new f.a()
      {
        public final void ddP()
        {
          AppMethodBeat.i(89544);
          com.tencent.mm.sdk.g.b.c(new n.6(n.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.hcJ != null) {
      this.hcJ.a(new n.5(this));
    }
    AppMethodBeat.o(89556);
  }
  
  public final String JC()
  {
    AppMethodBeat.i(89558);
    String str = bs.bG(this.md5, "");
    AppMethodBeat.o(89558);
    return str;
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMr))
    {
      if (this.uNc != null)
      {
        q localq = this.uNc;
        localq.uNo = paramInt1;
        localq.uNp = paramInt2;
        localq.uNq = paramInt3;
        ac.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.hcQ.a(d.c.uMj);
    }
    AppMethodBeat.o(89567);
  }
  
  public final void a(d.a parama)
  {
    this.hdd = parama;
  }
  
  public final void aj(float paramFloat)
  {
    AppMethodBeat.i(89570);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hcI = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final boolean aly()
  {
    return this.hbQ;
  }
  
  public final String auN()
  {
    return this.thumbPath;
  }
  
  final boolean avc()
  {
    AppMethodBeat.i(89557);
    long l = bs.Gn();
    int i;
    if ((this.uNd != null) && (this.uNe != null))
    {
      if (com.tencent.mm.compatible.util.d.kZ(18))
      {
        this.uNd.quitSafely();
        this.uNe = null;
      }
    }
    else
    {
      i = this.uNc.frameCount;
      this.hcG = (i * 1000.0F / this.hcF);
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.hcG), Integer.valueOf(this.hcF), this.hcE, Long.valueOf(bs.aO(l)), Integer.valueOf(this.hcH), Float.valueOf(this.hcI) });
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.hcY.getValue() });
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.hcX.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label377;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (bs.isNullOrNil(str)) {
        break label412;
      }
    }
    label412:
    for (String str = com.tencent.mm.plugin.mmsight.d.alV(str);; str = this.hcE)
    {
      i = this.hcF;
      if (this.hcH > 0) {
        i = this.hcH;
      }
      float f = this.hcG;
      if (this.hcI > 0.0F) {
        f = this.hcI;
      }
      this.hda = new m(this.gNJ, str, f, this.hcN, i, this.hcZ.audioSampleRate, this.hdh, false, false);
      l = bs.Gn();
      boolean bool = this.hda.ddO();
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bs.aO(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label421;
      }
      ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      l.ddD();
      AppMethodBeat.o(89557);
      return false;
      this.uNd.quit();
      break;
      label377:
      if (bs.isNullOrNil(this.hcE)) {
        break label210;
      }
      str = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(this.hcE).fxU().fxV());
      break label210;
    }
    label421:
    if (((this.hbQ) && (this.hdT)) || ((!this.hdT) && (!this.hbQ)) || ((this.hbQ) && (Math.abs(this.hcR - this.hdc) == 0)) || (this.hdc == 180))
    {
      l = bs.Gn();
      if ((this.hdT) || (this.hbQ)) {
        break label759;
      }
      i = this.hcR;
    }
    for (;;)
    {
      int j = i;
      if (this.hdc == 180)
      {
        j = i;
        if (!this.hdT)
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
        SightVideoJNI.tagRotateVideoVFS(str, this.hcT, j);
        this.hcW = true;
        ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.hcR), Boolean.valueOf(this.hbQ), Integer.valueOf(this.hdc), Integer.valueOf(j) });
        l = bs.Gn();
      }
      try
      {
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.ma(this.hcT, str);
        ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bs.aO(l)) });
        com.tencent.mm.sdk.g.b.c(new n.7(this, this.hcT), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
        this.hcQ.a(d.c.uMm);
        this.md5 = com.tencent.mm.vfs.i.aKe(str);
        if ((!bs.isNullOrNil(str)) && (!str.equals(this.hcE)))
        {
          com.tencent.mm.vfs.i.ma(str, this.hcE);
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label759:
        ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.hdT) {
        i = this.hdc;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String ave()
  {
    return this.hcV;
  }
  
  public final float avf()
  {
    return this.hcG;
  }
  
  public final long avg()
  {
    AppMethodBeat.i(89562);
    if (this.uNc != null)
    {
      long l = this.uNc.aqI();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c avh()
  {
    return this.hcQ.uNv;
  }
  
  public final int avi()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.hcF / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point avj()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.hcO, this.hcP);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int avk()
  {
    return this.hcR;
  }
  
  public final boolean avl()
  {
    return this.hdb;
  }
  
  public final com.tencent.mm.audio.b.c.a avm()
  {
    AppMethodBeat.i(89568);
    if (this.hcJ != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hcJ.ddN();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void avn()
  {
    this.hdg = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hcX.reset();
    this.hcF = 0;
    this.hcY.reset();
    this.hcU = false;
    this.hbQ = paramBoolean;
    this.hdc = paramInt2;
    this.hcQ.a(d.c.uMi);
    if (bs.isNullOrNil(this.hcE))
    {
      ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.i.aSu(this.hcE);
      String str2 = com.tencent.mm.vfs.i.aSs(this.hcE);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.hcT = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.hcQ.a(d.c.uMq);
        continue;
        ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.uNc.start();
        this.hcQ.a(d.c.uMj);
        this.hdb = false;
        l.ddA();
        l.arM();
        paramInt1 = 0;
      }
    }
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.hcE, this.hcT });
    this.hcR = paramInt1;
    this.uNd = com.tencent.e.c.d.gA("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.uNd.start();
    this.uNe = new ao(this.uNd.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (n.this.uNc != null)) {
            n.a(n.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.gkP)
    {
      nD(paramInt1);
      this.gkP = true;
    }
    if ((!this.hdh) && (!this.hdf))
    {
      paramInt1 = this.hcJ.a(new c.a()
      {
        public final void avs()
        {
          AppMethodBeat.i(89543);
          ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (n.this.avh() != d.c.uMq)
          {
            ac.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          n.this.uNc.start();
          n.this.hcQ.a(d.c.uMj);
          AppMethodBeat.o(89543);
        }
      });
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.hdb = false;
      if (paramInt1 != 0)
      {
        this.hcQ.a(d.c.uMp);
        l.ddA();
        l.arM();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  protected final void bp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.uNc != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.uNe != null) {
        this.uNe.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.uNc == null) || ((this.hcJ == null) && (!this.hdh)))
    {
      ac.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.hcQ.a(d.c.uMl);
    this.uNc.a(null);
    if (this.hcJ != null) {
      this.hcJ.a(new n.8(this));
    }
    if ((this.uNd != null) && (this.uNe != null))
    {
      this.uNe.removeMessages(0);
      this.uNd.quit();
      this.uNe = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
    this.hcQ.a(d.c.uMm);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.hcJ != null) {
        this.hcJ.clear();
      }
      if (this.uNc != null) {
        this.uNc.clear();
      }
      AppMethodBeat.o(89560);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89560);
    }
  }
  
  public final void eq(boolean paramBoolean)
  {
    this.hdf = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.hcE;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.hdv;
  }
  
  public final boolean nE(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.gkP)
    {
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = nD(paramInt);
      this.gkP = true;
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89554);
      return bool;
    }
    AppMethodBeat.o(89554);
    return true;
  }
  
  public final void nF(int paramInt)
  {
    AppMethodBeat.i(89569);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hcH = paramInt;
    AppMethodBeat.o(89569);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMj)) {
      this.hcQ.a(d.c.uMr);
    }
    AppMethodBeat.o(89566);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.uNc, this.hcJ, this.hda });
    synchronized (this.hcD)
    {
      this.uNc = null;
      this.hcJ = null;
      this.hda = null;
      this.gkP = false;
      this.hdb = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.hcL = paramInt3;
    this.hcM = paramInt4;
    this.hcO = paramInt1;
    this.hcP = paramInt2;
    if (j.uMV.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bs.Gn();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.uMV.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ac.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hcE = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.hdh = paramBoolean;
  }
  
  public final void vx(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void vy(String paramString)
  {
    this.hcV = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */