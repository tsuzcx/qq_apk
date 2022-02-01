package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.q;

public final class o
  implements d
{
  protected int bufId;
  protected boolean gEz;
  protected Point hpQ;
  protected boolean htY;
  private final Object huL;
  protected String huM;
  protected int huN;
  protected float huO;
  private int huP;
  private float huQ;
  protected c huR;
  protected int huT;
  protected int huU;
  protected int huV;
  protected int huW;
  protected int huX;
  protected t huY;
  protected int huZ;
  protected com.tencent.mm.plugin.mmsight.model.g hvD;
  protected String hvb;
  protected boolean hvc;
  protected String hvd;
  protected boolean hve;
  protected com.tencent.mm.plugin.mmsight.model.c hvf;
  protected com.tencent.mm.plugin.mmsight.model.c hvg;
  protected VideoTransPara hvh;
  protected n hvi;
  protected boolean hvj;
  protected int hvk;
  protected d.a hvl;
  protected Runnable hvm;
  protected boolean hvn;
  protected boolean hvo;
  protected boolean hvp;
  protected boolean hwb;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  protected volatile r vQj;
  protected HandlerThread vQk;
  protected ap vQl;
  protected int vQm;
  
  public o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.huL = new Object();
    this.huM = "";
    this.huN = 0;
    this.huO = 0.0F;
    this.huP = -1;
    this.huQ = -1.0F;
    this.huT = 480;
    this.huU = 640;
    this.huV = 1600000;
    this.huW = 480;
    this.huX = 640;
    this.hvb = null;
    this.vQm = 0;
    this.hwb = false;
    this.hvc = false;
    this.thumbPath = null;
    this.hvd = null;
    this.hve = false;
    this.hpQ = null;
    this.hvf = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hvg = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gEz = false;
    this.hvj = false;
    this.md5 = "";
    this.htY = false;
    this.hvk = 0;
    this.hvm = null;
    this.hvn = false;
    this.hvo = true;
    this.hvp = false;
    this.hvD = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((o.this.huY.vQE == d.c.vPp) || (o.this.huY.vQE == d.c.vPq))
        {
          if (o.this.huY.vQE == d.c.vPq)
          {
            o.this.huY.vQE = d.c.vPr;
            ad.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          o.this.hvg.yf(1L);
          if (o.this.huR != null) {
            o.this.huR.dni();
          }
          o.this.bs(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.hvh = paramVideoTransPara;
    this.huT = paramVideoTransPara.width;
    this.huU = paramVideoTransPara.height;
    this.huV = paramVideoTransPara.videoBitrate;
    l.dno();
    int i = l.dnq();
    if (i == -1) {}
    for (this.huV = paramVideoTransPara.videoBitrate;; this.huV = i)
    {
      this.huY = new t();
      ad.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.huT), Integer.valueOf(this.huU), Integer.valueOf(this.huV) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean oc(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = bt.HI();
    this.hwb = com.tencent.mm.plugin.mmsight.model.k.vOq.hwb;
    int i = this.huV;
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.huW, this.huX, paramInt, this.huT, this.huU, this.hvh.fps, i, this.hvh.hVf, 8, this.hvh.hVe, 23.0F, false, false, this.hvh.duration, false);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.dmY();
      AppMethodBeat.o(89552);
      return false;
    }
    this.huZ = paramInt;
    this.vQj = new r(this.huW, this.huX, this.huT, this.huU, this.huV, this.hvh.hmx, this.hvh.fps, this.hwb);
    int j = this.vQj.gz(this.bufId, paramInt);
    paramInt = 0;
    if (!this.hvp)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(al.a.IwK, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.hvh.audioSampleRate;
        i = this.hvh.audioBitrate;
        k = this.hvh.audioChannelCount;
        if (this.hvh.hVC == 1) {}
        for (bool = true;; bool = false)
        {
          this.huR = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.ag(false, bool));
          this.huR.os(this.hvn);
          paramInt = this.huR.E(this.bufId, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
          if ((j >= 0) && (paramInt >= 0)) {
            break label788;
          }
          ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          ad.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.huR.clear();
          this.huR = new i(this.hvh.audioSampleRate, this.hvh.audioBitrate, this.hvh.audioChannelCount);
          this.huR.os(this.hvn);
          paramInt = this.huR.E(this.bufId, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
          ad.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.l.dmY();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.hvh.audioSampleRate;
        i = this.hvh.audioBitrate;
        k = this.hvh.audioChannelCount;
        if (this.hvh.hVC == 1)
        {
          bool = true;
          this.huR = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.ag(false, bool));
          this.huR.os(this.hvn);
          paramInt = this.huR.E(this.bufId, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label788;
        }
        ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.l.dmY();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.huR = new i(this.hvh.audioSampleRate, this.hvh.audioBitrate, this.hvh.audioChannelCount);
          this.huR.os(this.hvn);
          paramInt = this.huR.E(this.bufId, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
        }
      }
    }
    if (j < 0)
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      com.tencent.mm.plugin.mmsight.model.l.dmY();
      AppMethodBeat.o(89552);
      return false;
    }
    label788:
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void D(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.hvm = paramRunnable;
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.vQj == null) || ((this.huR == null) && (!this.hvp)))
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.huY != null) && (this.huY.vQE == d.c.vPs))
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.huR != null) {
        this.huR.clear();
      }
      if (this.vQj != null) {
        this.vQj.clear();
      }
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.hvD = null;
    this.huN = ((int)this.vQj.atw());
    if (this.huY != null) {
      this.huY.a(d.c.vPq);
    }
    if (this.vQj != null) {
      this.vQj.a(new f.a()
      {
        public final void dnl()
        {
          AppMethodBeat.i(89544);
          com.tencent.mm.sdk.g.b.c(new o.6(o.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.huR != null) {
      this.huR.a(new c.b()
      {
        public final void aye()
        {
          AppMethodBeat.i(89545);
          ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89545);
        }
      });
    }
    AppMethodBeat.o(89556);
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.huY != null) && (this.huY.vQE == d.c.vPx))
    {
      if (this.vQj != null)
      {
        r localr = this.vQj;
        localr.vQx = paramInt1;
        localr.vQy = paramInt2;
        localr.vQz = paramInt3;
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.huY.a(d.c.vPp);
    }
    AppMethodBeat.o(89567);
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(89558);
    String str = bt.bI(this.md5, "");
    AppMethodBeat.o(89558);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.hvl = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(89570);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.huQ = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final boolean aol()
  {
    return this.htY;
  }
  
  public final String axA()
  {
    return this.thumbPath;
  }
  
  final boolean axP()
  {
    AppMethodBeat.i(89557);
    long l = bt.HI();
    int i;
    if ((this.vQk != null) && (this.vQl != null))
    {
      if (com.tencent.mm.compatible.util.d.ly(18))
      {
        this.vQk.quitSafely();
        this.vQl = null;
      }
    }
    else
    {
      i = this.vQj.frameCount;
      this.huO = (i * 1000.0F / this.huN);
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.huO), Integer.valueOf(this.huN), this.huM, Long.valueOf(bt.aO(l)), Integer.valueOf(this.huP), Float.valueOf(this.huQ) });
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.hvg.getValue() });
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.hvf.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label377;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (bt.isNullOrNil(str)) {
        break label412;
      }
    }
    label412:
    for (String str = com.tencent.mm.plugin.mmsight.d.aqK(str);; str = this.huM)
    {
      i = this.huN;
      if (this.huP > 0) {
        i = this.huP;
      }
      float f = this.huO;
      if (this.huQ > 0.0F) {
        f = this.huQ;
      }
      this.hvi = new n(this.bufId, str, f, this.huV, i, this.hvh.audioSampleRate, this.hvp, false, false);
      l = bt.HI();
      boolean bool = this.hvi.dnk();
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aO(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label421;
      }
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      com.tencent.mm.plugin.mmsight.model.l.dmZ();
      AppMethodBeat.o(89557);
      return false;
      this.vQk.quit();
      break;
      label377:
      if (bt.isNullOrNil(this.huM)) {
        break label210;
      }
      str = q.B(new com.tencent.mm.vfs.e(this.huM).fOJ().fOK());
      break label210;
    }
    label421:
    if (((this.htY) && (this.hwb)) || ((!this.hwb) && (!this.htY)) || ((this.htY) && (Math.abs(this.huZ - this.hvk) == 0)) || (this.hvk == 180))
    {
      l = bt.HI();
      if ((this.hwb) || (this.htY)) {
        break label759;
      }
      i = this.huZ;
    }
    for (;;)
    {
      int j = i;
      if (this.hvk == 180)
      {
        j = i;
        if (!this.hwb)
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
        SightVideoJNI.tagRotateVideoVFS(str, this.hvb, j);
        this.hve = true;
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.huZ), Boolean.valueOf(this.htY), Integer.valueOf(this.hvk), Integer.valueOf(j) });
        l = bt.HI();
      }
      try
      {
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.mA(this.hvb, str);
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bt.aO(l)) });
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89548);
            try
            {
              com.tencent.mm.vfs.i.deleteFile(this.hvL);
              AppMethodBeat.o(89548);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
              AppMethodBeat.o(89548);
            }
          }
        }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.huY.a(d.c.vPs);
        this.md5 = com.tencent.mm.vfs.i.aPK(str);
        if ((!bt.isNullOrNil(str)) && (!str.equals(this.huM)))
        {
          com.tencent.mm.vfs.i.mA(str, this.huM);
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label759:
        ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.hwb) {
        i = this.hvk;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String axR()
  {
    return this.hvd;
  }
  
  public final float axS()
  {
    return this.huO;
  }
  
  public final long axT()
  {
    AppMethodBeat.i(89562);
    if (this.vQj != null)
    {
      long l = this.vQj.atw();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c axU()
  {
    return this.huY.vQE;
  }
  
  public final int axV()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.huN / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point axW()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.huW, this.huX);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int axX()
  {
    return this.huZ;
  }
  
  public final boolean axY()
  {
    return this.hvj;
  }
  
  public final com.tencent.mm.audio.b.c.a axZ()
  {
    AppMethodBeat.i(89568);
    if (this.huR != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.huR.dnj();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void aya()
  {
    this.hvo = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hvf.reset();
    this.huN = 0;
    this.hvg.reset();
    this.hvc = false;
    this.htY = paramBoolean;
    this.hvk = paramInt2;
    this.huY.a(d.c.vPo);
    if (bt.isNullOrNil(this.huM))
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.i.aYt(this.huM);
      String str2 = com.tencent.mm.vfs.i.aYr(this.huM);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.hvb = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.huY.a(d.c.vPw);
        continue;
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.vQj.start();
        this.huY.a(d.c.vPp);
        this.hvj = false;
        com.tencent.mm.plugin.mmsight.model.l.dmW();
        com.tencent.mm.plugin.mmsight.model.l.auz();
        paramInt1 = 0;
      }
    }
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.huM, this.hvb });
    this.huZ = paramInt1;
    this.vQk = com.tencent.e.c.d.gY("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.vQk.start();
    this.vQl = new ap(this.vQk.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (o.this.vQj != null)) {
            o.a(o.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.gEz)
    {
      oc(paramInt1);
      this.gEz = true;
    }
    if ((!this.hvp) && (!this.hvn))
    {
      paramInt1 = this.huR.a(new c.a()
      {
        public final void ayf()
        {
          AppMethodBeat.i(89543);
          ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (o.this.axU() != d.c.vPw)
          {
            ad.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          o.this.vQj.start();
          o.this.huY.a(d.c.vPp);
          AppMethodBeat.o(89543);
        }
      });
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.hvj = false;
      if (paramInt1 != 0)
      {
        this.huY.a(d.c.vPv);
        com.tencent.mm.plugin.mmsight.model.l.dmW();
        com.tencent.mm.plugin.mmsight.model.l.auz();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  protected final void bs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.vQj != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.vQl != null) {
        this.vQl.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.vQj == null) || ((this.huR == null) && (!this.hvp)))
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.huY.a(d.c.vPr);
    this.vQj.a(null);
    if (this.huR != null) {
      this.huR.a(new c.b()
      {
        public final void aye()
        {
          AppMethodBeat.i(89549);
          ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89549);
        }
      });
    }
    if ((this.vQk != null) && (this.vQl != null))
    {
      this.vQl.removeMessages(0);
      this.vQk.quit();
      this.vQl = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.huY.a(d.c.vPs);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.huR != null) {
        this.huR.clear();
      }
      if (this.vQj != null) {
        this.vQj.clear();
      }
      AppMethodBeat.o(89560);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89560);
    }
  }
  
  public final void es(boolean paramBoolean)
  {
    this.hvn = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.huM;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.hvD;
  }
  
  public final boolean od(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.gEz)
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = oc(paramInt);
      this.gEz = true;
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89554);
      return bool;
    }
    AppMethodBeat.o(89554);
    return true;
  }
  
  public final void oe(int paramInt)
  {
    AppMethodBeat.i(89569);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.huP = paramInt;
    AppMethodBeat.o(89569);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.huY != null) && (this.huY.vQE == d.c.vPp)) {
      this.huY.a(d.c.vPx);
    }
    AppMethodBeat.o(89566);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.vQj, this.huR, this.hvi });
    synchronized (this.huL)
    {
      this.vQj = null;
      this.huR = null;
      this.hvi = null;
      this.gEz = false;
      this.hvj = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.huT = paramInt3;
    this.huU = paramInt4;
    this.huW = paramInt1;
    this.huX = paramInt2;
    if (k.vQc.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.HI();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.vQc.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final void setFilePath(String paramString)
  {
    this.huM = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.hvp = paramBoolean;
  }
  
  public final void yo(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void yp(String paramString)
  {
    this.hvd = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */