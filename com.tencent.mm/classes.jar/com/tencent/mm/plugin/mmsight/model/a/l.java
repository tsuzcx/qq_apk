package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ah.a;
import java.io.ByteArrayOutputStream;

public final class l
  implements d
{
  private boolean gkP;
  boolean hbQ;
  String hcE;
  private int hcF;
  private float hcG;
  int hcH;
  float hcI;
  private int hcL;
  private int hcM;
  int hcN;
  int hcO;
  int hcP;
  s hcQ;
  int hcR;
  String hcT;
  boolean hcU;
  private String hcV;
  private boolean hcW;
  VideoTransPara hcZ;
  c hdL;
  p hdM;
  e hdO;
  private HandlerThread hdP;
  ao hdQ;
  int hdR;
  int hdS;
  boolean hdT;
  private boolean hdU;
  private int hdV;
  private boolean hdW;
  public boolean hdX;
  boolean hdb;
  int hdc;
  d.a hdd;
  boolean hdg;
  private com.tencent.mm.plugin.mmsight.model.g hdv;
  private String mFileName;
  private String md5;
  String thumbPath;
  private a uMY;
  
  public l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.uMY = null;
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
    this.hcR = 0;
    this.hcT = null;
    this.hdP = null;
    this.hdQ = null;
    this.hdR = -1;
    this.hdS = -1;
    this.hdT = false;
    this.hdU = false;
    this.thumbPath = null;
    this.hcV = null;
    this.hcW = false;
    this.hcU = false;
    this.gkP = false;
    this.hdV = -1;
    this.hdb = false;
    this.md5 = "";
    this.hbQ = false;
    this.hdc = 0;
    this.hdW = false;
    this.hdg = true;
    this.hdX = false;
    this.hdv = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (l.this.hcQ.uNv == d.c.uMj)
        {
          Object localObject = l.this;
          if ((!((l)localObject).hcU) && (((l)localObject).hdg))
          {
            ((l)localObject).hcU = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.mm.sdk.g.b.c(new l.7((l)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (l.this.hdQ != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            l.this.hdQ.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
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
      this.gkP = false;
      ac.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.hcL), Integer.valueOf(this.hcM), Integer.valueOf(this.hcN), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean nD(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = bs.Gn();
    this.hdT = com.tencent.mm.plugin.mmsight.model.k.uLk.hdT;
    this.hcR = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.hdT) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.hcO;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label173;
        }
        j = this.hcP;
        k = this.hcL;
        n = this.hcM;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.hcN;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.hcZ.fps, n, this.hcZ.hCA, 8, this.hcZ.hCz, 23.0F, this.hdT, true, this.hcZ.duration, false);
      if (j >= 0) {
        break label296;
      }
      ac.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.ddB();
      AppMethodBeat.o(89527);
      return false;
      i = this.hcP;
      break;
      label173:
      j = this.hcO;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.hcO;
        label197:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label264;
        }
        j = this.hcP;
        label213:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label272;
        }
      }
      label264:
      label272:
      for (k = this.hcL;; k = this.hcM)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label281;
        }
        n = this.hcM;
        m = i;
        i = n;
        break;
        i = this.hcP;
        break label197;
        j = this.hcO;
        break label213;
      }
      label281:
      n = this.hcL;
      m = i;
      i = n;
    }
    label296:
    this.hdV = j;
    this.hdM = new p(this.hdT, paramInt, k, i, this.hdU);
    int k = this.hdM.IQ(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ah.a.GKs, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.hcZ.audioSampleRate;
      i = this.hcZ.audioBitrate;
      m = this.hcZ.gOt;
      if (this.hcZ.hCX == 1) {}
      for (bool = true;; bool = false)
      {
        this.hdL = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.ac(true, bool));
        this.hdL.nY(this.hdW);
        paramInt = this.hdL.E(j, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
        if ((k >= 0) && (paramInt >= 0)) {
          break label851;
        }
        ac.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        ac.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.hdL.clear();
        this.hdL = new i(this.hcZ.audioSampleRate, this.hcZ.audioBitrate, this.hcZ.gOt);
        this.hdL.nY(this.hdW);
        paramInt = this.hdL.E(j, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
        ac.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.ddB();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.hcZ.audioSampleRate;
      i = this.hcZ.audioBitrate;
      m = this.hcZ.gOt;
      if (this.hcZ.hCX == 1)
      {
        bool = true;
        this.hdL = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.ac(true, bool));
        this.hdL.nY(this.hdW);
        paramInt = this.hdL.E(j, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label851;
      }
      ac.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.ddB();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.hdL = new i(this.hcZ.audioSampleRate, this.hcZ.audioBitrate, this.hcZ.gOt);
        this.hdL.nY(this.hdW);
        paramInt = this.hdL.E(j, com.tencent.mm.plugin.sight.base.e.asv(this.hcE));
      }
    }
    label851:
    ac.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(89527);
    return true;
  }
  
  private boolean nG(int paramInt)
  {
    AppMethodBeat.i(89520);
    if ((this.uMY != null) && (!this.uMY.heg))
    {
      if (!this.uMY.hed)
      {
        this.uMY.callback = null;
        this.uMY.hef = true;
        this.uMY.hee = true;
        this.uMY.cancel();
      }
      synchronized (this.uMY.heh)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.uMY.heb != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.uMY.heb);
        }
        AppMethodBeat.o(89520);
        return true;
      }
    }
    AppMethodBeat.o(89520);
    return false;
  }
  
  public final void E(final Runnable paramRunnable)
  {
    AppMethodBeat.i(89523);
    boolean bool1;
    if (this.uMY == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.uMY != null) && (this.uMY.hed))
      {
        bool2 = true;
        if ((this.uMY == null) || (!this.uMY.hee)) {
          break label145;
        }
        bool3 = true;
        ac.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.uMY == null) || (!this.uMY.hed)) {
          break;
        }
      }
      synchronized (this.uMY.heh)
      {
        reset();
        ap.f(paramRunnable);
        AppMethodBeat.o(89523);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        break label34;
        label145:
        bool3 = false;
      }
    }
    ac.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.hdX), this.hdQ });
    if ((this.hdX) && (this.hdQ != null))
    {
      this.hdQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89507);
          l.a(l.this, paramRunnable);
          AppMethodBeat.o(89507);
        }
      });
      AppMethodBeat.o(89523);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89508);
        l.a(l.this, paramRunnable);
        AppMethodBeat.o(89508);
      }
    }, "MMSightFFMpegRecorder_stop");
    AppMethodBeat.o(89523);
  }
  
  public final String JC()
  {
    AppMethodBeat.i(89524);
    String str = bs.bG(this.md5, "");
    AppMethodBeat.o(89524);
    return str;
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89534);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMr))
    {
      if (this.hdM != null) {
        this.hdM.K(paramInt1, paramInt2, paramInt3);
      }
      this.hcQ.a(d.c.uMj);
    }
    AppMethodBeat.o(89534);
  }
  
  public final void a(d.a parama)
  {
    this.hdd = parama;
  }
  
  public final void aj(float paramFloat)
  {
    AppMethodBeat.i(89537);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hcI = paramFloat;
    AppMethodBeat.o(89537);
  }
  
  public final boolean aly()
  {
    return this.hbQ;
  }
  
  public final String auN()
  {
    return this.thumbPath;
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
    AppMethodBeat.i(89525);
    long l = this.hdM.aqI();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c avh()
  {
    return this.hcQ.uNv;
  }
  
  public final int avi()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.hcF / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point avj()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.hcO, this.hcP);
    AppMethodBeat.o(89532);
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
    AppMethodBeat.i(89535);
    if (this.hdL != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hdL.ddN();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void avn()
  {
    this.hdg = false;
  }
  
  final void avr()
  {
    if (this.uMY != null) {
      this.uMY.hee = true;
    }
  }
  
  final void avs()
  {
    AppMethodBeat.i(89530);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.uMY != null) && (!this.uMY.heg)) {
      ac.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.uMY });
    }
    synchronized (this.uMY.heh)
    {
      nG(this.uMY.heb);
      if (this.hcQ.uNv != d.c.uMq)
      {
        ac.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.hcQ.a(d.c.uMj);
    this.uMY = new a();
    this.uMY.heb = this.hdV;
    com.tencent.mm.sdk.g.b.d(this.uMY, "SightCustomAsyncMediaRecorder_encode_" + bs.Gn());
    AppMethodBeat.o(89530);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.hcQ.uNv, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hbQ = paramBoolean;
    this.hcF = 0;
    this.hdc = paramInt2;
    this.hcQ.a(d.c.uMi);
    String str = this.hcE;
    if (this.uMY == null)
    {
      paramBoolean = true;
      if ((this.uMY != null) && (!this.uMY.heg)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.uMY == null) || (this.uMY.heg)) {
        break label185;
      }
      ac.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (bs.isNullOrNil(this.hcE))
    {
      ac.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.i.aSu(this.hcE);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.hcE });
    this.hcR = paramInt1;
    ac.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.hcR) });
    if (!this.gkP)
    {
      nD(paramInt1);
      this.gkP = true;
    }
    this.hdM.start();
    if (!this.hdW)
    {
      paramInt1 = this.hdL.a(new c.a()
      {
        public final void avs()
        {
          AppMethodBeat.i(89510);
          l.this.avs();
          AppMethodBeat.o(89510);
        }
      });
      ac.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.hdP = com.tencent.e.c.d.gz("BigSightWriteCameraData", 0);
      this.hdP.start();
      this.hdQ = new ao(this.hdP.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (l.this.hdR == -1)
          {
            l.this.hdR = Process.myTid();
            ac.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(l.this.hdR) });
          }
          l locall;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            l.this.hdL.ddM();
            locall = l.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locall.hdT) {
              break label149;
            }
            paramAnonymousMessage = locall.hdM;
            k = arrayOfByte.length;
            j = locall.hcO;
            i = locall.hcP;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            j.uMV.k(arrayOfByte);
            locall.hdb = true;
            AppMethodBeat.o(89511);
            return;
            label149:
            paramAnonymousMessage = locall.hdM;
            k = arrayOfByte.length;
            if ((locall.hcR == 0) || (locall.hcR == 180)) {}
            for (i = locall.hcO;; i = locall.hcP)
            {
              if ((locall.hcR != 0) && (locall.hcR != 180)) {
                break label228;
              }
              m = locall.hcP;
              j = i;
              i = m;
              break;
            }
            label228:
            int m = locall.hcO;
            j = i;
            i = m;
          }
        }
      };
      this.hdb = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.hcQ.a(d.c.uMp);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.l.ddA();
      ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.wUl.idkeyStat(440L, 1L, 1L, false);
      if (this.hdW) {
        avs();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.hcQ.a(d.c.uMq);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.hcQ.a(d.c.uMl);
    clear();
    this.hcQ.a(d.c.uMm);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.hdM != null)
    {
      i = this.hdM.uNm;
      if (i < 0)
      {
        ac.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.hdM.stop();
    }
    if (this.hdL != null) {
      this.hdL.a(null);
    }
    boolean bool1;
    if (this.uMY == null)
    {
      bool1 = true;
      if ((this.uMY == null) || (!this.uMY.hef)) {
        break label177;
      }
    }
    for (;;)
    {
      ac.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!nG(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.hdP != null) {
        this.hdP.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
  }
  
  public final void eq(boolean paramBoolean)
  {
    this.hdW = paramBoolean;
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
    AppMethodBeat.i(89528);
    if (!this.gkP)
    {
      ac.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = nD(paramInt);
      this.gkP = true;
      ac.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89528);
      return bool;
    }
    AppMethodBeat.o(89528);
    return true;
  }
  
  public final void nF(int paramInt)
  {
    AppMethodBeat.i(89536);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hcH = paramInt;
    AppMethodBeat.o(89536);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMj)) {
      this.hcQ.a(d.c.uMr);
    }
    AppMethodBeat.o(89533);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.hcQ.uNv = d.c.uMm;
    this.hdb = false;
    if (this.hdL != null) {
      this.hdL.clear();
    }
    if (this.hdM != null) {
      this.hdM.clear();
    }
    clear();
    AppMethodBeat.o(89526);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89519);
    ac.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hcL = paramInt3;
    this.hcM = paramInt4;
    this.hcO = paramInt1;
    this.hcP = paramInt2;
    if (j.uMV.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ac.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bs.Gn();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.uMV.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ac.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    }
    AppMethodBeat.o(89519);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hcE = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.hdU = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void vx(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void vy(String paramString)
  {
    this.hcV = paramString;
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    Runnable callback;
    float clj;
    int duration;
    volatile int gRy;
    int heb;
    volatile boolean hec;
    boolean hed;
    boolean hee;
    boolean hef;
    boolean heg;
    final Object heh;
    
    public a()
    {
      AppMethodBeat.i(89516);
      this.gRy = 0;
      this.hec = true;
      this.hed = false;
      this.hee = false;
      this.hef = false;
      this.heg = false;
      this.heh = new Object();
      this.callback = null;
      synchronized (this.heh)
      {
        try
        {
          String str2 = com.tencent.mm.vfs.i.aSs(l.this.hcE);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          l.this.hcT = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ac.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { l.this.getMessage() });
          }
        }
        AppMethodBeat.o(89516);
        return;
      }
    }
    
    public final String getKey()
    {
      return "MicroMsg.MMSightFFMpegRecorder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89517);
      if (l.this.hdS == -1)
      {
        l.this.hdS = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ac.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(l.this.hdS) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.heh)
        {
          if (this.hee) {
            break label201;
          }
          l = bs.Gn();
          i = SightVideoJNI.triggerEncode(this.heb, Math.max(0, this.gRy), false);
          ac.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.gRy);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.gRy = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89517);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
          }
        }
      }
      label201:
      long l = bs.Gn();
      if (!this.hef) {
        this.gRy = SightVideoJNI.triggerEncode(this.heb, this.gRy, true);
      }
      ac.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Boolean.valueOf(this.hef), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.hef)
      {
        i = Math.max(1000, this.duration);
        if (l.this.hcH > 0) {
          i = l.this.hcH;
        }
        float f = this.clj;
        if (l.this.hcI > 0.0F) {
          f = l.this.hcI;
        }
        l.this.hdO = new m(this.heb, l.this.hcE, f, l.this.hcN, i, l.this.hcZ.audioSampleRate, false, true, false);
        l = bs.Gn();
        boolean bool = l.this.hdO.ddO();
        ac.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bs.aO(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          ac.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.heb);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (l.this.hdd != null) {
                l.this.hdd.aSh();
              }
              AppMethodBeat.o(89513);
            }
          });
          ac.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          h.wUl.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((l.this.hbQ) && (l.this.hdT)) || ((!l.this.hdT) && (!l.this.hbQ)) || ((l.this.hbQ) && (Math.abs(l.this.hcR - l.this.hdc) == 0)) || (l.this.hdc == 180))
        {
          l = bs.Gn();
          if ((l.this.hdT) || (l.this.hbQ)) {
            break label895;
          }
          i = l.this.hcR;
        }
      }
      for (;;)
      {
        j = i;
        if (l.this.hdc == 180)
        {
          j = i;
          if (!l.this.hdT)
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        String str;
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(l.this.hcE, l.this.hcT, j);
          ac.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(l.this.hcR), Boolean.valueOf(l.this.hbQ), Integer.valueOf(l.this.hdc), Integer.valueOf(j) });
          str = l.this.hcT;
        }
        try
        {
          com.tencent.mm.vfs.i.lZ(l.this.hcT, l.this.hcE);
          com.tencent.mm.sdk.g.b.c(new l.a.3(this, str), "BigSightFFMpegRecorder_tagRotate_after_process");
          ac.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.heb);
          ac.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          l.this.reset();
          ap.f(this.callback);
          this.heg = true;
          l.this.hdS = -1;
          l.this.hdR = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label895:
          ac.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.heb);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (l.this.hdd != null) {
                l.this.hdd.aSh();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (l.this.hdT) {
          i = l.this.hdc;
        } else {
          i = 180;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */