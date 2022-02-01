package com.tencent.mm.media.widget.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.f.c.d;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.q;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;

public final class e
  implements b
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
  private a isK;
  com.tencent.mm.plugin.mmsight.model.a.e isL;
  private HandlerThread isM;
  MMHandler isN;
  int isO;
  int isP;
  boolean isQ;
  private boolean isR;
  private int isS;
  private boolean isT;
  private boolean isU;
  private long isV;
  boolean isa;
  boolean isb;
  private long isl;
  private boolean ism;
  private g iss;
  private String mFileName;
  private String md5;
  String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.isK = null;
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
    this.isl = 0L;
    this.isV = 0L;
    this.isb = false;
    this.iss = new g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.this.irK.zwJ == d.c.zvu)
        {
          Object localObject = e.this;
          if ((!((e)localObject).irO) && (((e)localObject).isa))
          {
            ((e)localObject).irO = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.f.h.RTc.aX(new e.8((e)localObject, arrayOfByte));
          }
          if (e.this.isN != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            e.this.isN.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(93431);
          return true;
        }
        AppMethodBeat.o(93431);
        return false;
      }
    };
    this.ism = false;
    this.irT = paramVideoTransPara;
    this.irF = paramVideoTransPara.width;
    this.irG = paramVideoTransPara.height;
    this.irH = paramVideoTransPara.videoBitrate;
    this.irK = new t();
    this.htU = false;
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.irF), Integer.valueOf(this.irG), Integer.valueOf(this.irH), Integer.valueOf(paramVideoTransPara.iTs) });
    com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNt();
    if (paramVideoTransPara.iTs == 1)
    {
      paramVideoTransPara = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aOt();
    }
    AppMethodBeat.o(93444);
  }
  
  private boolean rB(int paramInt)
  {
    AppMethodBeat.i(93453);
    long l = Util.currentTicks();
    if (com.tencent.mm.plugin.mmsight.model.k.zuy != null) {
      this.isQ = com.tencent.mm.plugin.mmsight.model.k.zuy.isQ;
    }
    this.irL = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int i1;
    int n;
    if (!this.isQ) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.irI;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label337;
        }
        i = this.irJ;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label345;
        }
        k = this.irG;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label354;
        }
        m = this.irF;
        i1 = j;
        j = m;
        n = i;
        i = i1;
        i1 = this.irH;
        m = k;
        if (k % 2 != 0) {
          m = k + 1;
        }
        if (j % 2 == 0) {
          break label705;
        }
        j += 1;
      }
    }
    label400:
    label419:
    label699:
    label705:
    for (;;)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
      float f = this.irT.fps;
      k = this.irT.iSV;
      int i2 = this.irT.iSU;
      boolean bool3 = this.isQ;
      int i3 = this.irT.duration;
      if (this.irT.iTs == 1)
      {
        bool1 = true;
        label248:
        if (this.irT.iTs != 1) {
          break label490;
        }
      }
      com.tencent.mm.media.k.e locale;
      label337:
      label345:
      label354:
      label490:
      for (boolean bool2 = true;; bool2 = false)
      {
        i = SightVideoJNI.initDataBufferForMMSightLock(i, n, paramInt, m, j, f, i1, k, 8, i2, 23.0F, bool3, true, i3, false, bool1, com.tencent.mm.plugin.sight.base.b.ak(true, bool2));
        if (i >= 0) {
          break label496;
        }
        Log.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        locale = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNu();
        AppMethodBeat.o(93453);
        return false;
        j = this.irJ;
        break;
        i = this.irI;
        break label76;
        k = this.irF;
        break label95;
        m = this.irG;
        break label114;
        if ((paramInt == 90) || (paramInt == 270))
        {
          i = this.irI;
          label381:
          if ((paramInt != 90) && (paramInt != 270)) {
            break label457;
          }
          j = this.irJ;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label466;
          }
          k = this.irF;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label475;
          }
        }
        for (m = this.irG;; m = this.irF)
        {
          n = j;
          j = m;
          break;
          i = this.irJ;
          break label381;
          j = this.irI;
          break label400;
          k = this.irG;
          break label419;
        }
        bool1 = false;
        break label248;
      }
      label457:
      label466:
      label475:
      label496:
      this.isS = i;
      this.isJ = new q(this.isQ, paramInt, m, j, this.isR);
      this.isJ.QO(i);
      if (CaptureMMProxy.getInstance() != null) {
        CaptureMMProxy.getInstance().getInt(ar.a.NZk, -1);
      }
      if (!this.isb)
      {
        paramInt = this.irT.audioSampleRate;
        j = this.irT.audioBitrate;
        k = this.irT.audioChannelCount;
        if (this.irT.iTs != 1) {
          break label699;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.isI = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.b.ak(true, bool1));
        this.isI.rc(this.isT);
        if (this.isI.H(i, com.tencent.mm.plugin.sight.base.e.aNv(this.iry)) < 0)
        {
          locale = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aNw();
        }
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms, bufferId:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(i) });
        AppMethodBeat.o(93453);
        return true;
      }
    }
  }
  
  private boolean rE(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.isK != null) && (!this.isK.itd))
    {
      if (!this.isK.ita)
      {
        this.isK.callback = null;
        this.isK.itc = true;
        this.isK.itb = true;
        this.isK.cancel();
      }
      synchronized (this.isK.ite)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.isK.isY != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.isK.isY);
        }
        AppMethodBeat.o(93446);
        return true;
      }
    }
    AppMethodBeat.o(93446);
    return false;
  }
  
  public final void E(final Runnable paramRunnable)
  {
    AppMethodBeat.i(93449);
    boolean bool1;
    if (this.isK == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.isK != null) && (this.isK.ita))
      {
        bool2 = true;
        if ((this.isK == null) || (!this.isK.itb)) {
          break label145;
        }
        bool3 = true;
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.isK == null) || (!this.isK.ita)) {
          break;
        }
      }
      synchronized (this.isK.ite)
      {
        reset();
        MMHandlerThread.postToMainThread(paramRunnable);
        AppMethodBeat.o(93449);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        break label34;
        label145:
        bool3 = false;
      }
    }
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.isU), this.isN });
    if ((this.isU) && (this.isN != null))
    {
      this.isN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(93433);
          e.a(e.this, paramRunnable);
          AppMethodBeat.o(93433);
        }
      });
      AppMethodBeat.o(93449);
      return;
    }
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "MMSightFFMpegRecorder_stop";
      }
      
      public final void run()
      {
        AppMethodBeat.i(93434);
        e.a(e.this, paramRunnable);
        AppMethodBeat.o(93434);
      }
    });
    AppMethodBeat.o(93449);
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
    AppMethodBeat.i(93460);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.isV) });
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvC))
    {
      if (this.isJ != null) {
        this.isJ.M(paramInt1, paramInt2, paramInt3);
      }
      this.irK.a(d.c.zvu);
      if (this.isV > 0L) {
        this.isl += System.currentTimeMillis() - this.isV;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.ism = true;
      paramc.rA(this.isS);
    }
    AppMethodBeat.o(93464);
  }
  
  public final void a(d.a parama)
  {
    this.irX = parama;
  }
  
  public final void aQG() {}
  
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
    AppMethodBeat.i(93451);
    long l = this.isJ.aMm();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c aQN()
  {
    return this.irK.zwJ;
  }
  
  public final int aQO()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.irz / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point aQP()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.irI, this.irJ);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.isI != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.isI.ejX();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
    return null;
  }
  
  public final void aQT()
  {
    this.isa = false;
  }
  
  public final c aQW()
  {
    return this.isI;
  }
  
  final void aQX()
  {
    if (this.isK != null) {
      this.isK.itb = true;
    }
  }
  
  final void aQY()
  {
    AppMethodBeat.i(93456);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.isK != null) && (!this.isK.itd)) {
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.isK });
    }
    synchronized (this.isK.ite)
    {
      rE(this.isK.isY);
      if (this.irK.zwJ != d.c.zvB)
      {
        Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.irK.a(d.c.zvu);
    this.isK = new a();
    this.isK.isY = this.isS;
    com.tencent.f.h.RTc.aX(this.isK);
    AppMethodBeat.o(93456);
  }
  
  public final String aQn()
  {
    return this.thumbPath;
  }
  
  final void aRa()
  {
    boolean bool2 = true;
    AppMethodBeat.i(218971);
    int i = -1;
    if (this.isJ != null)
    {
      i = this.isJ.zwA;
      if (i < 0)
      {
        Log.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
        AppMethodBeat.o(218971);
        return;
      }
      this.isJ.stop();
    }
    boolean bool1;
    if (this.isK == null)
    {
      bool1 = true;
      if ((this.isK == null) || (!this.isK.itc)) {
        break label177;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!rE(i)))
      {
        SightVideoJNI.releaseRecorderBufferRefLock("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.isI != null) {
        this.isI.a(null);
      }
      if (this.isM != null) {
        this.isM.quit();
      }
      AppMethodBeat.o(218971);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(93463);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.irC = paramFloat;
    AppMethodBeat.o(93463);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s, bufId:%S", new Object[] { this.irK.zwJ, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(this.isS) });
    this.iqo = paramBoolean;
    this.isl = 0L;
    this.isV = 0L;
    this.irz = 0;
    this.irW = paramInt2;
    this.irK.a(d.c.zvt);
    String str = this.iry;
    if (this.isK == null)
    {
      paramBoolean = true;
      if ((this.isK != null) && (!this.isK.itd)) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.isK == null) || (this.isK.itd)) {
        break label205;
      }
      Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label205:
    if (Util.isNullOrNil(this.iry))
    {
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = s.bpb(this.iry);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.iry });
    this.irL = paramInt1;
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s, mute:%s", new Object[] { Integer.valueOf(this.irL), Boolean.valueOf(this.isb) });
    if (!this.htU)
    {
      rB(paramInt1);
      this.htU = true;
    }
    this.isJ.start();
    if ((!this.isT) && (this.isI != null))
    {
      paramInt1 = this.isI.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void aQY()
        {
          AppMethodBeat.i(93436);
          e.this.aQY();
          AppMethodBeat.o(93436);
        }
      });
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.isM = d.hA("BigSightWriteCameraData", 5);
      this.isM.start();
      this.isN = new MMHandler(this.isM.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(93437);
          if (e.this.isO == -1)
          {
            e.this.isO = Process.myTid();
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(e.this.isO) });
          }
          e locale;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            if (e.this.isI != null) {
              e.this.isI.ejW();
            }
            locale = e.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locale.isQ) {
              break label159;
            }
            paramAnonymousMessage = locale.isJ;
            k = arrayOfByte.length;
            j = locale.irI;
            i = locale.irJ;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            com.tencent.mm.plugin.mmsight.model.a.k.zwi.k(arrayOfByte);
            locale.irV = true;
            AppMethodBeat.o(93437);
            return;
            label159:
            paramAnonymousMessage = locale.isJ;
            k = arrayOfByte.length;
            if ((locale.irL == 90) || (locale.irL == 270)) {}
            for (i = locale.irI;; i = locale.irJ)
            {
              if ((locale.irL != 90) && (locale.irL != 270)) {
                break label242;
              }
              m = locale.irJ;
              j = i;
              i = m;
              break;
            }
            label242:
            int m = locale.irI;
            j = i;
            i = m;
          }
        }
      };
      this.irV = false;
      if (paramInt1 == 0) {
        break label461;
      }
      this.irK.a(d.c.zvA);
    }
    for (;;)
    {
      if ((this.isT) || (this.isb)) {
        aQY();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label461:
      this.irK.a(d.c.zvB);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    Log.printInfoStack("MicroMsg.X264YUVMP4MuxRecorder", "cancel", new Object[0]);
    this.irK.a(d.c.zvw);
    if (this.isN != null) {
      this.isN.removeMessages(1);
    }
    clear();
    this.irK.a(d.c.zvx);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "clear, hasWriteCameraData:%s", new Object[] { Boolean.valueOf(this.irV) });
    if (this.irV) {
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(93432);
          e.this.aRa();
          AppMethodBeat.o(93432);
        }
      });
    }
    for (;;)
    {
      this.isl = 0L;
      this.isV = 0L;
      AppMethodBeat.o(93447);
      return;
      aRa();
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
  
  public final g getFrameDataCallback()
  {
    return this.iss;
  }
  
  public final String getMd5()
  {
    AppMethodBeat.i(93450);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.iqo;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93459);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvu))
    {
      this.irK.a(d.c.zvC);
      this.isV = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final boolean rC(int paramInt)
  {
    AppMethodBeat.i(93454);
    if (!this.htU)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = rB(paramInt);
      this.htU = true;
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93454);
      return bool;
    }
    AppMethodBeat.o(93454);
    return true;
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(93462);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.irB = paramInt;
    AppMethodBeat.o(93462);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.irK.zwJ = d.c.zvx;
    if (this.isN != null) {
      this.isN.removeMessages(1);
    }
    if (this.isI != null) {
      this.isI.clear();
    }
    if (this.isJ != null) {
      this.isJ.clear();
    }
    clear();
    this.irV = false;
    AppMethodBeat.o(93452);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93445);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.irI = paramInt1;
    this.irJ = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.k.zwi.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.k.zwi.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final void setFilePath(String paramString)
  {
    this.iry = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.isR = paramBoolean;
    if (this.isJ != null) {
      this.isJ.isR = paramBoolean;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(218972);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.isb = paramBoolean;
    AppMethodBeat.o(218972);
  }
  
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
      AppMethodBeat.i(93442);
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
          String str2 = s.boZ(e.this.iry);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          e.this.irN = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { e.this.getMessage() });
          }
        }
        AppMethodBeat.o(93442);
        return;
      }
    }
    
    public final String getKey()
    {
      return "SightCustomAsyncMediaRecorder_encode";
    }
    
    public final void run()
    {
      boolean bool1 = true;
      AppMethodBeat.i(93443);
      if (e.this.isP == -1)
      {
        e.this.isP = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(e.this.isP) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.ite)
        {
          if (this.itb) {
            break label204;
          }
          l = Util.currentTicks();
          i = SightVideoJNI.triggerEncode(this.isY, Math.max(0, this.ifA), false);
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.ifA);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.ifA = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(93443);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
          }
        }
      }
      label204:
      long l = Util.currentTicks();
      if (!this.itc) {
        this.ifA = SightVideoJNI.triggerEncode(this.isY, this.ifA, true);
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.ifA), Boolean.valueOf(this.itc), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.itc)
      {
        i = Math.max(1000, this.duration);
        if (e.this.irB > 0) {
          i = e.this.irB;
        }
        float f = this.cKu;
        if (e.this.irC > 0.0F) {
          f = e.this.irC;
        }
        localObject3 = e.this;
        j = this.isY;
        localObject4 = e.this.iry;
        int k = e.this.irH;
        int m = e.this.irT.audioSampleRate;
        boolean bool2 = e.this.isb;
        if (e.this.irT.iTs == 1) {}
        for (;;)
        {
          ((e)localObject3).isL = new n(j, (String)localObject4, f, k, i, m, bool2, true, bool1);
          l = Util.currentTicks();
          bool1 = e.this.isL.ejY();
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool1) });
          if (bool1) {
            break;
          }
          Log.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.this.irX != null) {
                e.this.irX.bqP();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aNz();
          AppMethodBeat.o(93443);
          return;
          bool1 = false;
        }
        localObject3 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNA();
        if (((e.this.iqo) && (e.this.isQ)) || ((!e.this.isQ) && (!e.this.iqo)) || ((e.this.iqo) && (Math.abs(e.this.irL - e.this.irW) == 0)) || (e.this.irW == 180))
        {
          l = Util.currentTicks();
          if ((e.this.isQ) || (e.this.iqo)) {
            break label978;
          }
          i = e.this.irL;
        }
      }
      for (;;)
      {
        j = i;
        if (e.this.irW == 180)
        {
          j = i;
          if (!e.this.isQ)
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
          SightVideoJNI.tagRotateVideoVFS(e.this.iry, e.this.irN, j);
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(e.this.irL), Boolean.valueOf(e.this.iqo), Integer.valueOf(e.this.irW), Integer.valueOf(j) });
          localObject3 = e.this.irN;
        }
        try
        {
          s.nw(e.this.irN, e.this.iry);
          com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
          {
            public final String getKey()
            {
              return "BigSightFFMpegRecorder_tagRotate_after_process";
            }
            
            public final void run()
            {
              AppMethodBeat.i(93441);
              try
              {
                s.deleteFile(this.isA);
                AppMethodBeat.o(93441);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(93441);
              }
            }
          });
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        }
        catch (Exception localException2)
        {
          label908:
          Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.this.irX != null) {
                e.this.irX.bqP();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.e.aNx(e.this.iry);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.dd(((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label908;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.isY);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        MMHandlerThread.postToMainThread(this.callback);
        this.itd = true;
        e.this.isP = -1;
        e.this.isO = -1;
        AppMethodBeat.o(93443);
        return;
        label978:
        if (e.this.isQ) {
          i = e.this.irW;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e
 * JD-Core Version:    0.7.0.1
 */