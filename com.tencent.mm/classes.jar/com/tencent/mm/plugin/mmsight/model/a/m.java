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
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import java.io.ByteArrayOutputStream;

public final class m
  implements d
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
  private com.tencent.mm.plugin.mmsight.model.g hvD;
  c hvT;
  q hvU;
  e hvW;
  private HandlerThread hvX;
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
  int hwa;
  boolean hwb;
  private boolean hwc;
  private int hwd;
  private boolean hwe;
  public boolean hwf;
  private String mFileName;
  private String md5;
  String thumbPath;
  private a vQf;
  
  public m(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.vQf = null;
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
    this.hvD = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (m.this.huY.vQE == d.c.vPp)
        {
          Object localObject = m.this;
          if ((!((m)localObject).hvc) && (((m)localObject).hvo))
          {
            ((m)localObject).hvc = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.mm.sdk.g.b.c(new m.7((m)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (m.this.hvY != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            m.this.hvY.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
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
      this.gEz = false;
      ad.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.huT), Integer.valueOf(this.huU), Integer.valueOf(this.huV), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean oc(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = bt.HI();
    this.hwb = com.tencent.mm.plugin.mmsight.model.k.vOq.hwb;
    this.huZ = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.hwb) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.huW;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label173;
        }
        j = this.huX;
        k = this.huT;
        n = this.huU;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.huV;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.hvh.fps, n, this.hvh.hVf, 8, this.hvh.hVe, 23.0F, this.hwb, true, this.hvh.duration, false);
      if (j >= 0) {
        break label296;
      }
      ad.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.dmX();
      AppMethodBeat.o(89527);
      return false;
      i = this.huX;
      break;
      label173:
      j = this.huW;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.huW;
        label197:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label264;
        }
        j = this.huX;
        label213:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label272;
        }
      }
      label264:
      label272:
      for (k = this.huT;; k = this.huU)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label281;
        }
        n = this.huU;
        m = i;
        i = n;
        break;
        i = this.huX;
        break label197;
        j = this.huW;
        break label213;
      }
      label281:
      n = this.huT;
      m = i;
      i = n;
    }
    label296:
    this.hwd = j;
    this.hvU = new q(this.hwb, paramInt, k, i, this.hwc);
    int k = this.hvU.Kn(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(al.a.IwK, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.hvh.audioSampleRate;
      i = this.hvh.audioBitrate;
      m = this.hvh.audioChannelCount;
      if (this.hvh.hVC == 1) {}
      for (bool = true;; bool = false)
      {
        this.hvT = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.ag(true, bool));
        this.hvT.os(this.hwe);
        paramInt = this.hvT.E(j, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
        if ((k >= 0) && (paramInt >= 0)) {
          break label851;
        }
        ad.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        ad.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.hvT.clear();
        this.hvT = new i(this.hvh.audioSampleRate, this.hvh.audioBitrate, this.hvh.audioChannelCount);
        this.hvT.os(this.hwe);
        paramInt = this.hvT.E(j, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
        ad.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.dmX();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.hvh.audioSampleRate;
      i = this.hvh.audioBitrate;
      m = this.hvh.audioChannelCount;
      if (this.hvh.hVC == 1)
      {
        bool = true;
        this.hvT = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.b.ag(true, bool));
        this.hvT.os(this.hwe);
        paramInt = this.hvT.E(j, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label851;
      }
      ad.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.l.dmX();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.hvT = new i(this.hvh.audioSampleRate, this.hvh.audioBitrate, this.hvh.audioChannelCount);
        this.hvT.os(this.hwe);
        paramInt = this.hvT.E(j, com.tencent.mm.plugin.sight.base.e.axv(this.huM));
      }
    }
    label851:
    ad.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(89527);
    return true;
  }
  
  private boolean of(int paramInt)
  {
    AppMethodBeat.i(89520);
    if ((this.vQf != null) && (!this.vQf.hwo))
    {
      if (!this.vQf.hwl)
      {
        this.vQf.callback = null;
        this.vQf.hwn = true;
        this.vQf.hwm = true;
        this.vQf.cancel();
      }
      synchronized (this.vQf.hwp)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.vQf.hwj != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.vQf.hwj);
        }
        AppMethodBeat.o(89520);
        return true;
      }
    }
    AppMethodBeat.o(89520);
    return false;
  }
  
  public final void D(final Runnable paramRunnable)
  {
    AppMethodBeat.i(89523);
    boolean bool1;
    if (this.vQf == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.vQf != null) && (this.vQf.hwl))
      {
        bool2 = true;
        if ((this.vQf == null) || (!this.vQf.hwm)) {
          break label145;
        }
        bool3 = true;
        ad.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.vQf == null) || (!this.vQf.hwl)) {
          break;
        }
      }
      synchronized (this.vQf.hwp)
      {
        reset();
        aq.f(paramRunnable);
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
    ad.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.hwf), this.hvY });
    if ((this.hwf) && (this.hvY != null))
    {
      this.hvY.post(new Runnable()
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
    com.tencent.mm.sdk.g.b.c(new Runnable()
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
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89534);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.huY != null) && (this.huY.vQE == d.c.vPx))
    {
      if (this.hvU != null) {
        this.hvU.L(paramInt1, paramInt2, paramInt3);
      }
      this.huY.a(d.c.vPp);
    }
    AppMethodBeat.o(89534);
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(89524);
    String str = bt.bI(this.md5, "");
    AppMethodBeat.o(89524);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.hvl = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(89537);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.huQ = paramFloat;
    AppMethodBeat.o(89537);
  }
  
  public final boolean aol()
  {
    return this.htY;
  }
  
  public final String axA()
  {
    return this.thumbPath;
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
    AppMethodBeat.i(89525);
    long l = this.hvU.atw();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c axU()
  {
    return this.huY.vQE;
  }
  
  public final int axV()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.huN / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point axW()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.huW, this.huX);
    AppMethodBeat.o(89532);
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
    AppMethodBeat.i(89535);
    if (this.hvT != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hvT.dnj();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void aya()
  {
    this.hvo = false;
  }
  
  final void aye()
  {
    if (this.vQf != null) {
      this.vQf.hwm = true;
    }
  }
  
  final void ayf()
  {
    AppMethodBeat.i(89530);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.vQf != null) && (!this.vQf.hwo)) {
      ad.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.vQf });
    }
    synchronized (this.vQf.hwp)
    {
      of(this.vQf.hwj);
      if (this.huY.vQE != d.c.vPw)
      {
        ad.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.huY.a(d.c.vPp);
    this.vQf = new a();
    this.vQf.hwj = this.hwd;
    com.tencent.mm.sdk.g.b.d(this.vQf, "SightCustomAsyncMediaRecorder_encode_" + bt.HI());
    AppMethodBeat.o(89530);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.huY.vQE, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.htY = paramBoolean;
    this.huN = 0;
    this.hvk = paramInt2;
    this.huY.a(d.c.vPo);
    String str = this.huM;
    if (this.vQf == null)
    {
      paramBoolean = true;
      if ((this.vQf != null) && (!this.vQf.hwo)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.vQf == null) || (this.vQf.hwo)) {
        break label185;
      }
      ad.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (bt.isNullOrNil(this.huM))
    {
      ad.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.i.aYt(this.huM);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.huM });
    this.huZ = paramInt1;
    ad.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.huZ) });
    if (!this.gEz)
    {
      oc(paramInt1);
      this.gEz = true;
    }
    this.hvU.start();
    if (!this.hwe)
    {
      paramInt1 = this.hvT.a(new c.a()
      {
        public final void ayf()
        {
          AppMethodBeat.i(89510);
          m.this.ayf();
          AppMethodBeat.o(89510);
        }
      });
      ad.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.hvX = com.tencent.e.c.d.gX("BigSightWriteCameraData", 0);
      this.hvX.start();
      this.hvY = new ap(this.hvX.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (m.this.hvZ == -1)
          {
            m.this.hvZ = Process.myTid();
            ad.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(m.this.hvZ) });
          }
          m localm;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            m.this.hvT.dni();
            localm = m.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!localm.hwb) {
              break label149;
            }
            paramAnonymousMessage = localm.hvU;
            k = arrayOfByte.length;
            j = localm.huW;
            i = localm.huX;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            k.vQc.k(arrayOfByte);
            localm.hvj = true;
            AppMethodBeat.o(89511);
            return;
            label149:
            paramAnonymousMessage = localm.hvU;
            k = arrayOfByte.length;
            if ((localm.huZ == 0) || (localm.huZ == 180)) {}
            for (i = localm.huW;; i = localm.huX)
            {
              if ((localm.huZ != 0) && (localm.huZ != 180)) {
                break label228;
              }
              m = localm.huX;
              j = i;
              i = m;
              break;
            }
            label228:
            int m = localm.huW;
            j = i;
            i = m;
          }
        }
      };
      this.hvj = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.huY.a(d.c.vPv);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.l.dmW();
      ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 1L, 1L, false);
      if (this.hwe) {
        ayf();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.huY.a(d.c.vPw);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.huY.a(d.c.vPr);
    clear();
    this.huY.a(d.c.vPs);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.hvU != null)
    {
      i = this.hvU.vQv;
      if (i < 0)
      {
        ad.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.hvU.stop();
    }
    if (this.hvT != null) {
      this.hvT.a(null);
    }
    boolean bool1;
    if (this.vQf == null)
    {
      bool1 = true;
      if ((this.vQf == null) || (!this.vQf.hwn)) {
        break label177;
      }
    }
    for (;;)
    {
      ad.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!of(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.hvX != null) {
        this.hvX.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
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
    AppMethodBeat.i(89528);
    if (!this.gEz)
    {
      ad.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = oc(paramInt);
      this.gEz = true;
      ad.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89528);
      return bool;
    }
    AppMethodBeat.o(89528);
    return true;
  }
  
  public final void oe(int paramInt)
  {
    AppMethodBeat.i(89536);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.huP = paramInt;
    AppMethodBeat.o(89536);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.huY != null) && (this.huY.vQE == d.c.vPp)) {
      this.huY.a(d.c.vPx);
    }
    AppMethodBeat.o(89533);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.huY.vQE = d.c.vPs;
    this.hvj = false;
    if (this.hvT != null) {
      this.hvT.clear();
    }
    if (this.hvU != null) {
      this.hvU.clear();
    }
    clear();
    AppMethodBeat.o(89526);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89519);
    ad.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.huT = paramInt3;
    this.huU = paramInt4;
    this.huW = paramInt1;
    this.huX = paramInt2;
    if (k.vQc.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.HI();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.vQc.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    }
    AppMethodBeat.o(89519);
  }
  
  public final void setFilePath(String paramString)
  {
    this.huM = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.hwc = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
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
      AppMethodBeat.i(89516);
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
          String str2 = com.tencent.mm.vfs.i.aYr(m.this.huM);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          m.this.hvb = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { m.this.getMessage() });
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
      if (m.this.hwa == -1)
      {
        m.this.hwa = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ad.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(m.this.hwa) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.hwp)
        {
          if (this.hwm) {
            break label201;
          }
          l = bt.HI();
          i = SightVideoJNI.triggerEncode(this.hwj, Math.max(0, this.hjQ), false);
          ad.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.hjQ);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.hjQ = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89517);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ad.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
          }
        }
      }
      label201:
      long l = bt.HI();
      if (!this.hwn) {
        this.hjQ = SightVideoJNI.triggerEncode(this.hwj, this.hjQ, true);
      }
      ad.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(this.hjQ), Boolean.valueOf(this.hwn), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.hwn)
      {
        i = Math.max(1000, this.duration);
        if (m.this.huP > 0) {
          i = m.this.huP;
        }
        float f = this.cvL;
        if (m.this.huQ > 0.0F) {
          f = m.this.huQ;
        }
        m.this.hvW = new n(this.hwj, m.this.huM, f, m.this.huV, i, m.this.hvh.audioSampleRate, false, true, false);
        l = bt.HI();
        boolean bool = m.this.hvW.dnk();
        ad.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aO(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          ad.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hwj);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (m.this.hvl != null) {
                m.this.hvl.aVt();
              }
              AppMethodBeat.o(89513);
            }
          });
          ad.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((m.this.htY) && (m.this.hwb)) || ((!m.this.hwb) && (!m.this.htY)) || ((m.this.htY) && (Math.abs(m.this.huZ - m.this.hvk) == 0)) || (m.this.hvk == 180))
        {
          l = bt.HI();
          if ((m.this.hwb) || (m.this.htY)) {
            break label895;
          }
          i = m.this.huZ;
        }
      }
      for (;;)
      {
        j = i;
        if (m.this.hvk == 180)
        {
          j = i;
          if (!m.this.hwb)
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
          SightVideoJNI.tagRotateVideoVFS(m.this.huM, m.this.hvb, j);
          ad.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aO(l)), Integer.valueOf(m.this.huZ), Boolean.valueOf(m.this.htY), Integer.valueOf(m.this.hvk), Integer.valueOf(j) });
          str = m.this.hvb;
        }
        try
        {
          com.tencent.mm.vfs.i.mz(m.this.hvb, m.this.huM);
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89515);
              try
              {
                com.tencent.mm.vfs.i.deleteFile(str);
                AppMethodBeat.o(89515);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(89515);
              }
            }
          }, "BigSightFFMpegRecorder_tagRotate_after_process");
          ad.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.hwj);
          ad.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          m.this.reset();
          aq.f(this.callback);
          this.hwo = true;
          m.this.hwa = -1;
          m.this.hvZ = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label895:
          ad.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.hwj);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (m.this.hvl != null) {
                m.this.hvl.aVt();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (m.this.hwb) {
          i = m.this.hvk;
        } else {
          i = 180;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.m
 * JD-Core Version:    0.7.0.1
 */