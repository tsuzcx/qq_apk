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
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class m
  implements d
{
  private boolean htU;
  boolean iqo;
  private float irA;
  int irB;
  float irC;
  private int irF;
  private int irG;
  int irH;
  int irI;
  int irJ;
  t irK;
  int irL;
  String irN;
  boolean irO;
  private String irP;
  private boolean irQ;
  VideoTransPara irT;
  boolean irV;
  int irW;
  d.a irX;
  String iry;
  private int irz;
  c isI;
  q isJ;
  e isL;
  private HandlerThread isM;
  MMHandler isN;
  int isO;
  int isP;
  boolean isQ;
  private boolean isR;
  private int isS;
  private boolean isT;
  public boolean isU;
  boolean isa;
  private com.tencent.mm.plugin.mmsight.model.g iss;
  private String mFileName;
  private String md5;
  String thumbPath;
  private a zwl;
  
  public m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.zwl = null;
    this.iry = "";
    this.irz = 0;
    this.irA = 0.0F;
    this.irB = -1;
    this.irC = -1.0F;
    this.irF = 480;
    this.irG = 640;
    this.irH = 1600000;
    this.irI = 480;
    this.irJ = 640;
    this.irL = 0;
    this.irN = null;
    this.isM = null;
    this.isN = null;
    this.isO = -1;
    this.isP = -1;
    this.isQ = false;
    this.isR = false;
    this.thumbPath = null;
    this.irP = null;
    this.irQ = false;
    this.irO = false;
    this.htU = false;
    this.isS = -1;
    this.irV = false;
    this.md5 = "";
    this.iqo = false;
    this.irW = 0;
    this.isT = false;
    this.isa = true;
    this.isU = false;
    this.iss = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (m.this.irK.zwJ == d.c.zvu)
        {
          Object localObject = m.this;
          if ((!((m)localObject).irO) && (((m)localObject).isa))
          {
            ((m)localObject).irO = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            ThreadPool.post(new m.7((m)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (m.this.isN != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            m.this.isN.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
        return false;
      }
    };
    this.irT = paramVideoTransPara;
    this.irF = paramVideoTransPara.width;
    this.irG = paramVideoTransPara.height;
    this.irH = paramVideoTransPara.videoBitrate;
    l.ekc();
    int i = l.eke();
    if (i == -1) {}
    for (this.irH = paramVideoTransPara.videoBitrate;; this.irH = i)
    {
      this.irK = new t();
      this.htU = false;
      Log.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.irF), Integer.valueOf(this.irG), Integer.valueOf(this.irH), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean rB(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = Util.currentTicks();
    this.isQ = com.tencent.mm.plugin.mmsight.model.k.zuy.isQ;
    this.irL = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.isQ) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.irI;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label173;
        }
        j = this.irJ;
        k = this.irF;
        n = this.irG;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.irH;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.irT.fps, n, this.irT.iSV, 8, this.irT.iSU, 23.0F, this.isQ, true, this.irT.duration, false);
      if (j >= 0) {
        break label296;
      }
      Log.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.ejK();
      AppMethodBeat.o(89527);
      return false;
      i = this.irJ;
      break;
      label173:
      j = this.irI;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.irI;
        label197:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label264;
        }
        j = this.irJ;
        label213:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label272;
        }
      }
      label264:
      label272:
      for (k = this.irF;; k = this.irG)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label281;
        }
        n = this.irG;
        m = i;
        i = n;
        break;
        i = this.irJ;
        break label197;
        j = this.irI;
        break label213;
      }
      label281:
      n = this.irF;
      m = i;
      i = n;
    }
    label296:
    this.isS = j;
    this.isJ = new q(this.isQ, paramInt, k, i, this.isR);
    int k = this.isJ.QO(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ar.a.NZk, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.irT.audioSampleRate;
      i = this.irT.audioBitrate;
      m = this.irT.audioChannelCount;
      if (this.irT.iTs == 1) {}
      for (bool = true;; bool = false)
      {
        this.isI = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.ak(true, bool));
        this.isI.rc(this.isT);
        paramInt = this.isI.H(j, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
        if ((k >= 0) && (paramInt >= 0)) {
          break label851;
        }
        Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        Log.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.isI.clear();
        this.isI = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
        this.isI.rc(this.isT);
        paramInt = this.isI.H(j, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
        Log.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.ejK();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.irT.audioSampleRate;
      i = this.irT.audioBitrate;
      m = this.irT.audioChannelCount;
      if (this.irT.iTs == 1)
      {
        bool = true;
        this.isI = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.ak(true, bool));
        this.isI.rc(this.isT);
        paramInt = this.isI.H(j, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label851;
      }
      Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.ejK();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.isI = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
        this.isI.rc(this.isT);
        paramInt = this.isI.H(j, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
      }
    }
    label851:
    Log.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(89527);
    return true;
  }
  
  private boolean rE(int paramInt)
  {
    AppMethodBeat.i(89520);
    if ((this.zwl != null) && (!this.zwl.itd))
    {
      if (!this.zwl.ita)
      {
        this.zwl.callback = null;
        this.zwl.itc = true;
        this.zwl.itb = true;
        this.zwl.cancel();
      }
      synchronized (this.zwl.ite)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.zwl.isY != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.zwl.isY);
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
    if (this.zwl == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.zwl != null) && (this.zwl.ita))
      {
        bool2 = true;
        if ((this.zwl == null) || (!this.zwl.itb)) {
          break label145;
        }
        bool3 = true;
        Log.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.zwl == null) || (!this.zwl.ita)) {
          break;
        }
      }
      synchronized (this.zwl.ite)
      {
        reset();
        MMHandlerThread.postToMainThread(paramRunnable);
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
    Log.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.isU), this.isN });
    if ((this.isU) && (this.isN != null))
    {
      this.isN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89507);
          m.a(m.this, paramRunnable);
          AppMethodBeat.o(89507);
        }
      });
      AppMethodBeat.o(89523);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89508);
        m.a(m.this, paramRunnable);
        AppMethodBeat.o(89508);
      }
    }, "MMSightFFMpegRecorder_stop");
    AppMethodBeat.o(89523);
  }
  
  public final void HA(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void HB(String paramString)
  {
    this.irP = paramString;
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89534);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvC))
    {
      if (this.isJ != null) {
        this.isJ.M(paramInt1, paramInt2, paramInt3);
      }
      this.irK.a(d.c.zvu);
    }
    AppMethodBeat.o(89534);
  }
  
  public final void a(d.a parama)
  {
    this.irX = parama;
  }
  
  public final String aQK()
  {
    return this.irP;
  }
  
  public final float aQL()
  {
    return this.irA;
  }
  
  public final long aQM()
  {
    AppMethodBeat.i(89525);
    long l = this.isJ.aMm();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c aQN()
  {
    return this.irK.zwJ;
  }
  
  public final int aQO()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.irz / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point aQP()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.irI, this.irJ);
    AppMethodBeat.o(89532);
    return localPoint;
  }
  
  public final int aQQ()
  {
    return this.irL;
  }
  
  public final boolean aQR()
  {
    return this.irV;
  }
  
  public final com.tencent.mm.audio.b.c.a aQS()
  {
    AppMethodBeat.i(89535);
    if (this.isI != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.isI.ejX();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void aQT()
  {
    this.isa = false;
  }
  
  final void aQX()
  {
    if (this.zwl != null) {
      this.zwl.itb = true;
    }
  }
  
  final void aQY()
  {
    AppMethodBeat.i(89530);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.zwl != null) && (!this.zwl.itd)) {
      Log.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.zwl });
    }
    synchronized (this.zwl.ite)
    {
      rE(this.zwl.isY);
      if (this.irK.zwJ != d.c.zvB)
      {
        Log.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.irK.a(d.c.zvu);
    this.zwl = new a();
    this.zwl.isY = this.isS;
    ThreadPool.post(this.zwl, "SightCustomAsyncMediaRecorder_encode_" + Util.currentTicks(), 5);
    AppMethodBeat.o(89530);
  }
  
  public final String aQn()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(89537);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.irC = paramFloat;
    AppMethodBeat.o(89537);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.irK.zwJ, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.iqo = paramBoolean;
    this.irz = 0;
    this.irW = paramInt2;
    this.irK.a(d.c.zvt);
    String str = this.iry;
    if (this.zwl == null)
    {
      paramBoolean = true;
      if ((this.zwl != null) && (!this.zwl.itd)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.zwl == null) || (this.zwl.itd)) {
        break label185;
      }
      Log.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (Util.isNullOrNil(this.iry))
    {
      Log.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = s.bpb(this.iry);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.iry });
    this.irL = paramInt1;
    Log.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.irL) });
    if (!this.htU)
    {
      rB(paramInt1);
      this.htU = true;
    }
    this.isJ.start();
    if (!this.isT)
    {
      paramInt1 = this.isI.a(new c.a()
      {
        public final void aQY()
        {
          AppMethodBeat.i(89510);
          m.this.aQY();
          AppMethodBeat.o(89510);
        }
      });
      Log.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.isM = com.tencent.f.c.d.hA("BigSightWriteCameraData", 0);
      this.isM.start();
      this.isN = new MMHandler(this.isM.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (m.this.isO == -1)
          {
            m.this.isO = Process.myTid();
            Log.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(m.this.isO) });
          }
          m localm;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            m.this.isI.ejW();
            localm = m.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!localm.isQ) {
              break label149;
            }
            paramAnonymousMessage = localm.isJ;
            k = arrayOfByte.length;
            j = localm.irI;
            i = localm.irJ;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            k.zwi.k(arrayOfByte);
            localm.irV = true;
            AppMethodBeat.o(89511);
            return;
            label149:
            paramAnonymousMessage = localm.isJ;
            k = arrayOfByte.length;
            if ((localm.irL == 0) || (localm.irL == 180)) {}
            for (i = localm.irI;; i = localm.irJ)
            {
              if ((localm.irL != 0) && (localm.irL != 180)) {
                break label228;
              }
              m = localm.irJ;
              j = i;
              i = m;
              break;
            }
            label228:
            int m = localm.irI;
            j = i;
            i = m;
          }
        }
      };
      this.irV = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.irK.a(d.c.zvA);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.l.ejJ();
      Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.CyF.idkeyStat(440L, 1L, 1L, false);
      if (this.isT) {
        aQY();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.irK.a(d.c.zvB);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.irK.a(d.c.zvw);
    clear();
    this.irK.a(d.c.zvx);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.isJ != null)
    {
      i = this.isJ.zwA;
      if (i < 0)
      {
        Log.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.isJ.stop();
    }
    if (this.isI != null) {
      this.isI.a(null);
    }
    boolean bool1;
    if (this.zwl == null)
    {
      bool1 = true;
      if ((this.zwl == null) || (!this.zwl.itc)) {
        break label177;
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!rE(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.isM != null) {
        this.isM.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
  }
  
  public final void fk(boolean paramBoolean)
  {
    this.isT = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.iry;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.iss;
  }
  
  public final String getMd5()
  {
    AppMethodBeat.i(89524);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(89524);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.iqo;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvu)) {
      this.irK.a(d.c.zvC);
    }
    AppMethodBeat.o(89533);
  }
  
  public final boolean rC(int paramInt)
  {
    AppMethodBeat.i(89528);
    if (!this.htU)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = rB(paramInt);
      this.htU = true;
      Log.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89528);
      return bool;
    }
    AppMethodBeat.o(89528);
    return true;
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(89536);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.irB = paramInt;
    AppMethodBeat.o(89536);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.irK.zwJ = d.c.zvx;
    this.irV = false;
    if (this.isI != null) {
      this.isI.clear();
    }
    if (this.isJ != null) {
      this.isJ.clear();
    }
    clear();
    AppMethodBeat.o(89526);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89519);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.irF = paramInt3;
    this.irG = paramInt4;
    this.irI = paramInt1;
    this.irJ = paramInt2;
    if (k.zwi.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.zwi.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(89519);
  }
  
  public final void setFilePath(String paramString)
  {
    this.iry = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.isR = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  final class a
    extends com.tencent.f.i.b
  {
    float cKu;
    Runnable callback;
    int duration;
    volatile int ifA;
    int isY;
    volatile boolean isZ;
    boolean ita;
    boolean itb;
    boolean itc;
    boolean itd;
    final Object ite;
    
    public a()
    {
      AppMethodBeat.i(89516);
      this.ifA = 0;
      this.isZ = true;
      this.ita = false;
      this.itb = false;
      this.itc = false;
      this.itd = false;
      this.ite = new Object();
      this.callback = null;
      synchronized (this.ite)
      {
        try
        {
          String str2 = s.boZ(m.this.iry);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          m.this.irN = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { m.this.getMessage() });
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
      if (m.this.isP == -1)
      {
        m.this.isP = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(m.this.isP) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.ite)
        {
          if (this.itb) {
            break label201;
          }
          l = Util.currentTicks();
          i = SightVideoJNI.triggerEncode(this.isY, Math.max(0, this.ifA), false);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.ifA);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.ifA = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89517);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
          }
        }
      }
      label201:
      long l = Util.currentTicks();
      if (!this.itc) {
        this.ifA = SightVideoJNI.triggerEncode(this.isY, this.ifA, true);
      }
      Log.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Boolean.valueOf(this.itc), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.itc)
      {
        i = Math.max(1000, this.duration);
        if (m.this.irB > 0) {
          i = m.this.irB;
        }
        float f = this.cKu;
        if (m.this.irC > 0.0F) {
          f = m.this.irC;
        }
        m.this.isL = new n(this.isY, m.this.iry, f, m.this.irH, i, m.this.irT.audioSampleRate, false, true, false);
        l = Util.currentTicks();
        boolean bool = m.this.isL.ejY();
        Log.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (m.this.irX != null) {
                m.this.irX.bqP();
              }
              AppMethodBeat.o(89513);
            }
          });
          Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          h.CyF.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((m.this.iqo) && (m.this.isQ)) || ((!m.this.isQ) && (!m.this.iqo)) || ((m.this.iqo) && (Math.abs(m.this.irL - m.this.irW) == 0)) || (m.this.irW == 180))
        {
          l = Util.currentTicks();
          if ((m.this.isQ) || (m.this.iqo)) {
            break label895;
          }
          i = m.this.irL;
        }
      }
      for (;;)
      {
        j = i;
        if (m.this.irW == 180)
        {
          j = i;
          if (!m.this.isQ)
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        final String str;
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(m.this.iry, m.this.irN, j);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(m.this.irL), Boolean.valueOf(m.this.iqo), Integer.valueOf(m.this.irW), Integer.valueOf(j) });
          str = m.this.irN;
        }
        try
        {
          s.nw(m.this.irN, m.this.iry);
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89515);
              try
              {
                s.deleteFile(str);
                AppMethodBeat.o(89515);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(89515);
              }
            }
          }, "BigSightFFMpegRecorder_tagRotate_after_process");
          Log.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          m.this.reset();
          MMHandlerThread.postToMainThread(this.callback);
          this.itd = true;
          m.this.isP = -1;
          m.this.isO = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label895:
          Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (m.this.irX != null) {
                m.this.irX.bqP();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (m.this.isQ) {
          i = m.this.irW;
        } else {
          i = 180;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */