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
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import java.io.ByteArrayOutputStream;

public final class e
  implements b
{
  private boolean gEz;
  boolean htY;
  String huM;
  private int huN;
  private float huO;
  int huP;
  float huQ;
  private int huT;
  private int huU;
  int huV;
  int huW;
  int huX;
  t huY;
  int huZ;
  private boolean hvA;
  private com.tencent.mm.plugin.mmsight.model.g hvD;
  c hvT;
  q hvU;
  a hvV;
  com.tencent.mm.plugin.mmsight.model.a.e hvW;
  HandlerThread hvX;
  ap hvY;
  int hvZ;
  String hvb;
  boolean hvc;
  private String hvd;
  private boolean hve;
  VideoTransPara hvh;
  boolean hvj;
  int hvk;
  d.a hvl;
  boolean hvo;
  private boolean hvp;
  long hvz;
  int hwa;
  boolean hwb;
  private boolean hwc;
  private int hwd;
  private boolean hwe;
  private boolean hwf;
  long hwg;
  private String mFileName;
  private String md5;
  String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.hvV = null;
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
    this.huZ = 0;
    this.hvb = null;
    this.hvX = null;
    this.hvY = null;
    this.hvZ = -1;
    this.hwa = -1;
    this.hwb = false;
    this.hwc = false;
    this.thumbPath = null;
    this.hvd = null;
    this.hve = false;
    this.hvc = false;
    this.gEz = false;
    this.hwd = -1;
    this.hvj = false;
    this.md5 = "";
    this.htY = false;
    this.hvk = 0;
    this.hwe = false;
    this.hvo = true;
    this.hwf = false;
    this.hvz = 0L;
    this.hwg = 0L;
    this.hvp = false;
    this.hvD = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.this.huY.vQE == d.c.vPp)
        {
          Object localObject = e.this;
          if ((!((e)localObject).hvc) && (((e)localObject).hvo))
          {
            ((e)localObject).hvc = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.e.h.LTJ.aR(new e.8((e)localObject, arrayOfByte));
          }
          if (e.this.hvY != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            e.this.hvY.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(93431);
          return true;
        }
        AppMethodBeat.o(93431);
        return false;
      }
    };
    this.hvA = false;
    this.hvh = paramVideoTransPara;
    this.huT = paramVideoTransPara.width;
    this.huU = paramVideoTransPara.height;
    this.huV = paramVideoTransPara.videoBitrate;
    this.huY = new t();
    this.gEz = false;
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.huT), Integer.valueOf(this.huU), Integer.valueOf(this.huV), Integer.valueOf(paramVideoTransPara.hVC) });
    com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.aur();
    if (paramVideoTransPara.hVC == 1)
    {
      paramVideoTransPara = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.avr();
    }
    AppMethodBeat.o(93444);
  }
  
  private boolean oc(int paramInt)
  {
    AppMethodBeat.i(93453);
    long l = bt.HI();
    if (com.tencent.mm.plugin.mmsight.model.k.vOq != null) {
      this.hwb = com.tencent.mm.plugin.mmsight.model.k.vOq.hwb;
    }
    this.huZ = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int i1;
    int n;
    if (!this.hwb) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.huW;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label337;
        }
        i = this.huX;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label345;
        }
        k = this.huU;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label354;
        }
        m = this.huT;
        i1 = j;
        j = m;
        n = i;
        i = i1;
        i1 = this.huV;
        m = k;
        if (k % 2 != 0) {
          m = k + 1;
        }
        if (j % 2 == 0) {
          break label698;
        }
        j += 1;
      }
    }
    label400:
    label419:
    label692:
    label698:
    for (;;)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
      float f = this.hvh.fps;
      k = this.hvh.hVf;
      int i2 = this.hvh.hVe;
      boolean bool3 = this.hwb;
      int i3 = this.hvh.duration;
      if (this.hvh.hVC == 1)
      {
        bool1 = true;
        label248:
        if (this.hvh.hVC != 1) {
          break label490;
        }
      }
      com.tencent.mm.media.k.d locald;
      label337:
      label345:
      label354:
      label490:
      for (boolean bool2 = true;; bool2 = false)
      {
        i = SightVideoJNI.initDataBufferForMMSightLock(i, n, paramInt, m, j, f, i1, k, 8, i2, 23.0F, bool3, true, i3, false, bool1, com.tencent.mm.plugin.sight.base.b.ag(true, bool2));
        if (i >= 0) {
          break label496;
        }
        ad.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        locald = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.aus();
        AppMethodBeat.o(93453);
        return false;
        j = this.huX;
        break;
        i = this.huW;
        break label76;
        k = this.huT;
        break label95;
        m = this.huU;
        break label114;
        if ((paramInt == 90) || (paramInt == 270))
        {
          i = this.huW;
          label381:
          if ((paramInt != 90) && (paramInt != 270)) {
            break label457;
          }
          j = this.huX;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label466;
          }
          k = this.huT;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label475;
          }
        }
        for (m = this.huU;; m = this.huT)
        {
          n = j;
          j = m;
          break;
          i = this.huX;
          break label381;
          j = this.huW;
          break label400;
          k = this.huU;
          break label419;
        }
        bool1 = false;
        break label248;
      }
      label457:
      label466:
      label475:
      label496:
      this.hwd = i;
      this.hvU = new q(this.hwb, paramInt, m, j, this.hwc);
      this.hvU.Kn(i);
      if (CaptureMMProxy.getInstance() != null) {
        CaptureMMProxy.getInstance().getInt(al.a.IwK, -1);
      }
      if (!this.hvp)
      {
        paramInt = this.hvh.audioSampleRate;
        j = this.hvh.audioBitrate;
        k = this.hvh.audioChannelCount;
        if (this.hvh.hVC != 1) {
          break label692;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.hvT = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.b.ag(true, bool1));
        this.hvT.os(this.hwe);
        if (this.hvT.E(i, com.tencent.mm.plugin.sight.base.e.axv(this.huM)) < 0)
        {
          locald = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auu();
        }
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
        AppMethodBeat.o(93453);
        return true;
      }
    }
  }
  
  public final void D(final Runnable paramRunnable)
  {
    AppMethodBeat.i(93449);
    boolean bool1;
    if (this.hvV == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.hvV != null) && (this.hvV.hwl))
      {
        bool2 = true;
        if ((this.hvV == null) || (!this.hvV.hwm)) {
          break label145;
        }
        bool3 = true;
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.hvV == null) || (!this.hvV.hwl)) {
          break;
        }
      }
      synchronized (this.hvV.hwp)
      {
        reset();
        aq.f(paramRunnable);
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
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.hwf), this.hvY });
    if ((this.hwf) && (this.hvY != null))
    {
      this.hvY.post(new Runnable()
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
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
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
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93460);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.hwg) });
    if ((this.huY != null) && (this.huY.vQE == d.c.vPx))
    {
      if (this.hvU != null) {
        this.hvU.L(paramInt1, paramInt2, paramInt3);
      }
      this.huY.a(d.c.vPp);
      if (this.hwg > 0L) {
        this.hvz += System.currentTimeMillis() - this.hwg;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(93450);
    String str = bt.bI(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.hvA = true;
      paramc.ob(this.hwd);
    }
    AppMethodBeat.o(93464);
  }
  
  public final void a(d.a parama)
  {
    this.hvl = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(93463);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.huQ = paramFloat;
    AppMethodBeat.o(93463);
  }
  
  public final boolean aol()
  {
    return this.htY;
  }
  
  public final String axA()
  {
    return this.thumbPath;
  }
  
  public final void axN() {}
  
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
    AppMethodBeat.i(93451);
    long l = this.hvU.atw();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c axU()
  {
    return this.huY.vQE;
  }
  
  public final int axV()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.huN / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point axW()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.huW, this.huX);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.hvT != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hvT.dnj();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
    return null;
  }
  
  public final void aya()
  {
    this.hvo = false;
  }
  
  public final c ayc()
  {
    return this.hvT;
  }
  
  final void aye()
  {
    if (this.hvV != null) {
      this.hvV.hwm = true;
    }
  }
  
  final void ayf()
  {
    AppMethodBeat.i(93456);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.hvV != null) && (!this.hvV.hwo)) {
      ad.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.hvV });
    }
    synchronized (this.hvV.hwp)
    {
      of(this.hvV.hwj);
      if (this.huY.vQE != d.c.vPw)
      {
        ad.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.huY.a(d.c.vPp);
    this.hvV = new a();
    this.hvV.hwj = this.hwd;
    com.tencent.e.h.LTJ.aR(this.hvV);
    AppMethodBeat.o(93456);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.huY.vQE, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.htY = paramBoolean;
    this.hvz = 0L;
    this.hwg = 0L;
    this.huN = 0;
    this.hvk = paramInt2;
    this.huY.a(d.c.vPo);
    String str = this.huM;
    if (this.hvV == null)
    {
      paramBoolean = true;
      if ((this.hvV != null) && (!this.hvV.hwo)) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.hvV == null) || (this.hvV.hwo)) {
        break label195;
      }
      ad.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label195:
    if (bt.isNullOrNil(this.huM))
    {
      ad.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.i.aYt(this.huM);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.huM });
    this.huZ = paramInt1;
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.huZ) });
    if (!this.gEz)
    {
      oc(paramInt1);
      this.gEz = true;
    }
    this.hvU.start();
    if ((!this.hwe) && (this.hvT != null))
    {
      paramInt1 = this.hvT.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void ayf()
        {
          AppMethodBeat.i(93436);
          e.this.ayf();
          AppMethodBeat.o(93436);
        }
      });
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.hvX = com.tencent.e.c.d.gX("BigSightWriteCameraData", 5);
      this.hvX.start();
      this.hvY = new ap(this.hvX.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(93437);
          if (e.this.hvZ == -1)
          {
            e.this.hvZ = Process.myTid();
            ad.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(e.this.hvZ) });
          }
          e locale;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            if (e.this.hvT != null) {
              e.this.hvT.dni();
            }
            locale = e.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locale.hwb) {
              break label159;
            }
            paramAnonymousMessage = locale.hvU;
            k = arrayOfByte.length;
            j = locale.huW;
            i = locale.huX;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            com.tencent.mm.plugin.mmsight.model.a.k.vQc.k(arrayOfByte);
            locale.hvj = true;
            AppMethodBeat.o(93437);
            return;
            label159:
            paramAnonymousMessage = locale.hvU;
            k = arrayOfByte.length;
            if ((locale.huZ == 90) || (locale.huZ == 270)) {}
            for (i = locale.huW;; i = locale.huX)
            {
              if ((locale.huZ != 90) && (locale.huZ != 270)) {
                break label242;
              }
              m = locale.huX;
              j = i;
              i = m;
              break;
            }
            label242:
            int m = locale.huW;
            j = i;
            i = m;
          }
        }
      };
      this.hvj = false;
      if (paramInt1 == 0) {
        break label434;
      }
      this.huY.a(d.c.vPv);
    }
    for (;;)
    {
      if (this.hwe) {
        ayf();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label434:
      this.huY.a(d.c.vPw);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "cancel");
    this.huY.a(d.c.vPr);
    clear();
    this.huY.a(d.c.vPs);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    com.tencent.e.h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = true;
        AppMethodBeat.i(93432);
        int i = -1;
        if (e.this.hvU != null)
        {
          i = e.this.hvU.vQv;
          if (i < 0)
          {
            ad.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
            AppMethodBeat.o(93432);
            return;
          }
          e.this.hvU.stop();
        }
        if (e.this.hvT != null) {
          e.this.hvT.a(null);
        }
        boolean bool1;
        if (e.this.hvV == null)
        {
          bool1 = true;
          if ((e.this.hvV == null) || (!e.this.hvV.hwn)) {
            break label220;
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((i >= 0) && (!e.this.of(i)))
          {
            SightVideoJNI.releaseRecorderBufferRefLock("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(i);
          }
          if (e.this.hvX != null) {
            e.this.hvX.quit();
          }
          e.this.hvz = 0L;
          e.this.hwg = 0L;
          AppMethodBeat.o(93432);
          return;
          bool1 = false;
          break;
          label220:
          bool2 = false;
        }
      }
    });
    AppMethodBeat.o(93447);
  }
  
  public final void es(boolean paramBoolean)
  {
    this.hwe = paramBoolean;
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
    AppMethodBeat.i(93454);
    if (!this.gEz)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = oc(paramInt);
      this.gEz = true;
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93454);
      return bool;
    }
    AppMethodBeat.o(93454);
    return true;
  }
  
  public final void oe(int paramInt)
  {
    AppMethodBeat.i(93462);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.huP = paramInt;
    AppMethodBeat.o(93462);
  }
  
  final boolean of(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.hvV != null) && (!this.hvV.hwo))
    {
      if (!this.hvV.hwl)
      {
        this.hvV.callback = null;
        this.hvV.hwn = true;
        this.hvV.hwm = true;
        this.hvV.cancel();
      }
      synchronized (this.hvV.hwp)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.hvV.hwj != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.hvV.hwj);
        }
        AppMethodBeat.o(93446);
        return true;
      }
    }
    AppMethodBeat.o(93446);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93459);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.huY != null) && (this.huY.vQE == d.c.vPp))
    {
      this.huY.a(d.c.vPx);
      this.hwg = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.huY.vQE = d.c.vPs;
    this.hvj = false;
    if (this.hvT != null) {
      this.hvT.clear();
    }
    if (this.hvU != null) {
      this.hvU.clear();
    }
    clear();
    AppMethodBeat.o(93452);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93445);
    ad.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.huW = paramInt1;
    this.huX = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.HI();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.k.vQc.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final void setFilePath(String paramString)
  {
    this.huM = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.hwc = paramBoolean;
    if (this.hvU != null) {
      this.hvU.hwc = paramBoolean;
    }
  }
  
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
  
  final class a
    extends com.tencent.e.i.b
  {
    Runnable callback;
    float cvL;
    int duration;
    volatile int hjQ;
    int hwj;
    volatile boolean hwk;
    boolean hwl;
    boolean hwm;
    boolean hwn;
    boolean hwo;
    final Object hwp;
    
    public a()
    {
      AppMethodBeat.i(93442);
      this.hjQ = 0;
      this.hwk = true;
      this.hwl = false;
      this.hwm = false;
      this.hwn = false;
      this.hwo = false;
      this.hwp = new Object();
      this.callback = null;
      synchronized (this.hwp)
      {
        try
        {
          String str2 = com.tencent.mm.vfs.i.aYr(e.this.huM);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          e.this.hvb = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ad.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { e.this.getMessage() });
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
      boolean bool = true;
      AppMethodBeat.i(93443);
      if (e.this.hwa == -1)
      {
        e.this.hwa = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(e.this.hwa) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.hwp)
        {
          if (this.hwm) {
            break label204;
          }
          l = bt.HI();
          i = SightVideoJNI.triggerEncode(this.hwj, Math.max(0, this.hjQ), false);
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.hjQ);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.hjQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(93443);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
          }
        }
      }
      label204:
      long l = bt.HI();
      if (!this.hwn) {
        this.hjQ = SightVideoJNI.triggerEncode(this.hwj, this.hjQ, true);
      }
      ad.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Boolean.valueOf(this.hwn), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.hwn)
      {
        i = Math.max(1000, this.duration);
        if (e.this.huP > 0) {
          i = e.this.huP;
        }
        float f = this.cvL;
        if (e.this.huQ > 0.0F) {
          f = e.this.huQ;
        }
        localObject3 = e.this;
        j = this.hwj;
        localObject4 = e.this.huM;
        int k = e.this.huV;
        int m = e.this.hvh.audioSampleRate;
        if (e.this.hvh.hVC == 1) {}
        for (;;)
        {
          ((e)localObject3).hvW = new n(j, (String)localObject4, f, k, i, m, false, true, bool);
          l = bt.HI();
          bool = e.this.hvW.dnk();
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aO(l)), Boolean.valueOf(bool) });
          if (bool) {
            break;
          }
          ad.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hwj);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.this.hvl != null) {
                e.this.hvl.aVt();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.aux();
          AppMethodBeat.o(93443);
          return;
          bool = false;
        }
        localObject3 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auy();
        if (((e.this.htY) && (e.this.hwb)) || ((!e.this.hwb) && (!e.this.htY)) || ((e.this.htY) && (Math.abs(e.this.huZ - e.this.hvk) == 0)) || (e.this.hvk == 180))
        {
          l = bt.HI();
          if ((e.this.hwb) || (e.this.htY)) {
            break label968;
          }
          i = e.this.huZ;
        }
      }
      for (;;)
      {
        j = i;
        if (e.this.hvk == 180)
        {
          j = i;
          if (!e.this.hwb)
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
          SightVideoJNI.tagRotateVideoVFS(e.this.huM, e.this.hvb, j);
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(e.this.huZ), Boolean.valueOf(e.this.htY), Integer.valueOf(e.this.hvk), Integer.valueOf(j) });
          localObject3 = e.this.hvb;
        }
        try
        {
          com.tencent.mm.vfs.i.mz(e.this.hvb, e.this.huM);
          com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
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
                com.tencent.mm.vfs.i.deleteFile(this.hvL);
                AppMethodBeat.o(93441);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(93441);
              }
            }
          });
          ad.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
        }
        catch (Exception localException2)
        {
          label898:
          ad.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hwj);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.this.hvl != null) {
                e.this.hvl.aVt();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.e.axx(e.this.huM);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.cX(((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label898;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.hwj);
        ad.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        aq.f(this.callback);
        this.hwo = true;
        e.this.hwa = -1;
        e.this.hvZ = -1;
        AppMethodBeat.o(93443);
        return;
        label968:
        if (e.this.hwb) {
          i = e.this.hvk;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e
 * JD-Core Version:    0.7.0.1
 */