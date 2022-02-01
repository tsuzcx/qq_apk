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
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ah.a;
import java.io.ByteArrayOutputStream;

public final class e
  implements b
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
  com.tencent.mm.plugin.mmsight.model.a.p hdM;
  a hdN;
  com.tencent.mm.plugin.mmsight.model.a.e hdO;
  HandlerThread hdP;
  ao hdQ;
  int hdR;
  int hdS;
  boolean hdT;
  private boolean hdU;
  private int hdV;
  private boolean hdW;
  private boolean hdX;
  long hdY;
  boolean hdb;
  int hdc;
  d.a hdd;
  boolean hdg;
  private boolean hdh;
  long hdr;
  private boolean hds;
  private g hdv;
  private String mFileName;
  private String md5;
  String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.hdN = null;
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
    this.hdr = 0L;
    this.hdY = 0L;
    this.hdh = false;
    this.hdv = new g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.this.hcQ.uNv == d.c.uMj)
        {
          Object localObject = e.this;
          if ((!((e)localObject).hcU) && (((e)localObject).hdg))
          {
            ((e)localObject).hcU = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            com.tencent.e.h.JZN.aS(new e.8((e)localObject, arrayOfByte));
          }
          if (e.this.hdQ != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            e.this.hdQ.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(93431);
          return true;
        }
        AppMethodBeat.o(93431);
        return false;
      }
    };
    this.hds = false;
    this.hcZ = paramVideoTransPara;
    this.hcL = paramVideoTransPara.width;
    this.hcM = paramVideoTransPara.height;
    this.hcN = paramVideoTransPara.videoBitrate;
    this.hcQ = new s();
    this.gkP = false;
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.hcL), Integer.valueOf(this.hcM), Integer.valueOf(this.hcN), Integer.valueOf(paramVideoTransPara.hCX) });
    com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.arE();
    if (paramVideoTransPara.hCX == 1)
    {
      paramVideoTransPara = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asE();
    }
    AppMethodBeat.o(93444);
  }
  
  private boolean nD(int paramInt)
  {
    AppMethodBeat.i(93453);
    long l = bs.Gn();
    if (k.uLk != null) {
      this.hdT = k.uLk.hdT;
    }
    this.hcR = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int i1;
    int n;
    if (!this.hdT) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.hcO;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label337;
        }
        i = this.hcP;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label345;
        }
        k = this.hcM;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label354;
        }
        m = this.hcL;
        i1 = j;
        j = m;
        n = i;
        i = i1;
        i1 = this.hcN;
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
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
      float f = this.hcZ.fps;
      k = this.hcZ.hCA;
      int i2 = this.hcZ.hCz;
      boolean bool3 = this.hdT;
      int i3 = this.hcZ.duration;
      if (this.hcZ.hCX == 1)
      {
        bool1 = true;
        label248:
        if (this.hcZ.hCX != 1) {
          break label490;
        }
      }
      com.tencent.mm.media.j.d locald;
      label337:
      label345:
      label354:
      label490:
      for (boolean bool2 = true;; bool2 = false)
      {
        i = SightVideoJNI.initDataBufferForMMSightLock(i, n, paramInt, m, j, f, i1, k, 8, i2, 23.0F, bool3, true, i3, false, bool1, com.tencent.mm.plugin.sight.base.b.ac(true, bool2));
        if (i >= 0) {
          break label496;
        }
        ac.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        locald = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arF();
        AppMethodBeat.o(93453);
        return false;
        j = this.hcP;
        break;
        i = this.hcO;
        break label76;
        k = this.hcL;
        break label95;
        m = this.hcM;
        break label114;
        if ((paramInt == 90) || (paramInt == 270))
        {
          i = this.hcO;
          label381:
          if ((paramInt != 90) && (paramInt != 270)) {
            break label457;
          }
          j = this.hcP;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label466;
          }
          k = this.hcL;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label475;
          }
        }
        for (m = this.hcM;; m = this.hcL)
        {
          n = j;
          j = m;
          break;
          i = this.hcP;
          break label381;
          j = this.hcO;
          break label400;
          k = this.hcM;
          break label419;
        }
        bool1 = false;
        break label248;
      }
      label457:
      label466:
      label475:
      label496:
      this.hdV = i;
      this.hdM = new com.tencent.mm.plugin.mmsight.model.a.p(this.hdT, paramInt, m, j, this.hdU);
      this.hdM.IQ(i);
      if (CaptureMMProxy.getInstance() != null) {
        CaptureMMProxy.getInstance().getInt(ah.a.GKs, -1);
      }
      if (!this.hdh)
      {
        paramInt = this.hcZ.audioSampleRate;
        j = this.hcZ.audioBitrate;
        k = this.hcZ.gOt;
        if (this.hcZ.hCX != 1) {
          break label692;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        this.hdL = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.b.ac(true, bool1));
        this.hdL.nY(this.hdW);
        if (this.hdL.E(i, com.tencent.mm.plugin.sight.base.e.asv(this.hcE)) < 0)
        {
          locald = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.arH();
        }
        ac.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
        AppMethodBeat.o(93453);
        return true;
      }
    }
  }
  
  public final void E(final Runnable paramRunnable)
  {
    AppMethodBeat.i(93449);
    boolean bool1;
    if (this.hdN == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.hdN != null) && (this.hdN.hed))
      {
        bool2 = true;
        if ((this.hdN == null) || (!this.hdN.hee)) {
          break label145;
        }
        bool3 = true;
        ac.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.hdN == null) || (!this.hdN.hed)) {
          break;
        }
      }
      synchronized (this.hdN.heh)
      {
        reset();
        ap.f(paramRunnable);
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
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.hdX), this.hdQ });
    if ((this.hdX) && (this.hdQ != null))
    {
      this.hdQ.post(new Runnable()
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
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
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
  
  public final String JC()
  {
    AppMethodBeat.i(93450);
    String str = bs.bG(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93460);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.hdY) });
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMr))
    {
      if (this.hdM != null) {
        this.hdM.K(paramInt1, paramInt2, paramInt3);
      }
      this.hcQ.a(d.c.uMj);
      if (this.hdY > 0L) {
        this.hdr += System.currentTimeMillis() - this.hdY;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.hds = true;
      paramc.nC(this.hdV);
    }
    AppMethodBeat.o(93464);
  }
  
  public final void a(d.a parama)
  {
    this.hdd = parama;
  }
  
  public final void aj(float paramFloat)
  {
    AppMethodBeat.i(93463);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hcI = paramFloat;
    AppMethodBeat.o(93463);
  }
  
  public final boolean aly()
  {
    return this.hbQ;
  }
  
  public final String auN()
  {
    return this.thumbPath;
  }
  
  public final void ava() {}
  
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
    AppMethodBeat.i(93451);
    long l = this.hdM.aqI();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c avh()
  {
    return this.hcQ.uNv;
  }
  
  public final int avi()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.hcF / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point avj()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.hcO, this.hcP);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.hdL != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hdL.ddN();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
    return null;
  }
  
  public final void avn()
  {
    this.hdg = false;
  }
  
  public final c avp()
  {
    return this.hdL;
  }
  
  final void avr()
  {
    if (this.hdN != null) {
      this.hdN.hee = true;
    }
  }
  
  final void avs()
  {
    AppMethodBeat.i(93456);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.hdN != null) && (!this.hdN.heg)) {
      ac.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.hdN });
    }
    synchronized (this.hdN.heh)
    {
      nG(this.hdN.heb);
      if (this.hcQ.uNv != d.c.uMq)
      {
        ac.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.hcQ.a(d.c.uMj);
    this.hdN = new a();
    this.hdN.heb = this.hdV;
    com.tencent.e.h.JZN.aS(this.hdN);
    AppMethodBeat.o(93456);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.hcQ.uNv, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hbQ = paramBoolean;
    this.hdr = 0L;
    this.hdY = 0L;
    this.hcF = 0;
    this.hdc = paramInt2;
    this.hcQ.a(d.c.uMi);
    String str = this.hcE;
    if (this.hdN == null)
    {
      paramBoolean = true;
      if ((this.hdN != null) && (!this.hdN.heg)) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.hdN == null) || (this.hdN.heg)) {
        break label195;
      }
      ac.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label195:
    if (bs.isNullOrNil(this.hcE))
    {
      ac.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.i.aSu(this.hcE);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.hcE });
    this.hcR = paramInt1;
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.hcR) });
    if (!this.gkP)
    {
      nD(paramInt1);
      this.gkP = true;
    }
    this.hdM.start();
    if ((!this.hdW) && (this.hdL != null))
    {
      paramInt1 = this.hdL.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void avs()
        {
          AppMethodBeat.i(93436);
          e.this.avs();
          AppMethodBeat.o(93436);
        }
      });
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.hdP = com.tencent.e.c.d.gz("BigSightWriteCameraData", 5);
      this.hdP.start();
      this.hdQ = new ao(this.hdP.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(93437);
          if (e.this.hdR == -1)
          {
            e.this.hdR = Process.myTid();
            ac.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(e.this.hdR) });
          }
          e locale;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            if (e.this.hdL != null) {
              e.this.hdL.ddM();
            }
            locale = e.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locale.hdT) {
              break label159;
            }
            paramAnonymousMessage = locale.hdM;
            k = arrayOfByte.length;
            j = locale.hcO;
            i = locale.hcP;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            j.uMV.k(arrayOfByte);
            locale.hdb = true;
            AppMethodBeat.o(93437);
            return;
            label159:
            paramAnonymousMessage = locale.hdM;
            k = arrayOfByte.length;
            if ((locale.hcR == 90) || (locale.hcR == 270)) {}
            for (i = locale.hcO;; i = locale.hcP)
            {
              if ((locale.hcR != 90) && (locale.hcR != 270)) {
                break label242;
              }
              m = locale.hcP;
              j = i;
              i = m;
              break;
            }
            label242:
            int m = locale.hcO;
            j = i;
            i = m;
          }
        }
      };
      this.hdb = false;
      if (paramInt1 == 0) {
        break label434;
      }
      this.hcQ.a(d.c.uMp);
    }
    for (;;)
    {
      if (this.hdW) {
        avs();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label434:
      this.hcQ.a(d.c.uMq);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "cancel");
    this.hcQ.a(d.c.uMl);
    clear();
    this.hcQ.a(d.c.uMm);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = true;
        AppMethodBeat.i(93432);
        int i = -1;
        if (e.this.hdM != null)
        {
          i = e.this.hdM.uNm;
          if (i < 0)
          {
            ac.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
            AppMethodBeat.o(93432);
            return;
          }
          e.this.hdM.stop();
        }
        if (e.this.hdL != null) {
          e.this.hdL.a(null);
        }
        boolean bool1;
        if (e.this.hdN == null)
        {
          bool1 = true;
          if ((e.this.hdN == null) || (!e.this.hdN.hef)) {
            break label220;
          }
        }
        for (;;)
        {
          ac.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((i >= 0) && (!e.this.nG(i)))
          {
            SightVideoJNI.releaseRecorderBufferRefLock("clear");
            SightVideoJNI.releaseBigSightDataBufferLock(i);
          }
          if (e.this.hdP != null) {
            e.this.hdP.quit();
          }
          e.this.hdr = 0L;
          e.this.hdY = 0L;
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
  
  public final g getFrameDataCallback()
  {
    return this.hdv;
  }
  
  public final boolean nE(int paramInt)
  {
    AppMethodBeat.i(93454);
    if (!this.gkP)
    {
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = nD(paramInt);
      this.gkP = true;
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93454);
      return bool;
    }
    AppMethodBeat.o(93454);
    return true;
  }
  
  public final void nF(int paramInt)
  {
    AppMethodBeat.i(93462);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hcH = paramInt;
    AppMethodBeat.o(93462);
  }
  
  final boolean nG(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.hdN != null) && (!this.hdN.heg))
    {
      if (!this.hdN.hed)
      {
        this.hdN.callback = null;
        this.hdN.hef = true;
        this.hdN.hee = true;
        this.hdN.cancel();
      }
      synchronized (this.hdN.heh)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.hdN.heb != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.hdN.heb);
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
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMj))
    {
      this.hcQ.a(d.c.uMr);
      this.hdY = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.hcQ.uNv = d.c.uMm;
    this.hdb = false;
    if (this.hdL != null) {
      this.hdL.clear();
    }
    if (this.hdM != null) {
      this.hdM.clear();
    }
    clear();
    AppMethodBeat.o(93452);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93445);
    ac.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.hcO = paramInt1;
    this.hcP = paramInt2;
    if (j.uMV.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bs.Gn();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.uMV.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hcE = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.hdU = paramBoolean;
    if (this.hdM != null) {
      this.hdM.hdU = paramBoolean;
    }
  }
  
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
      AppMethodBeat.i(93442);
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
          String str2 = com.tencent.mm.vfs.i.aSs(e.this.hcE);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          e.this.hcT = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            ac.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { e.this.getMessage() });
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
      if (e.this.hdS == -1)
      {
        e.this.hdS = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        ac.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(e.this.hdS) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.heh)
        {
          if (this.hee) {
            break label204;
          }
          l = bs.Gn();
          i = SightVideoJNI.triggerEncode(this.heb, Math.max(0, this.gRy), false);
          ac.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.gRy);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.gRy = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(93443);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            ac.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
          }
        }
      }
      label204:
      long l = bs.Gn();
      if (!this.hef) {
        this.gRy = SightVideoJNI.triggerEncode(this.heb, this.gRy, true);
      }
      ac.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(this.gRy), Boolean.valueOf(this.hef), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.hef)
      {
        i = Math.max(1000, this.duration);
        if (e.this.hcH > 0) {
          i = e.this.hcH;
        }
        float f = this.clj;
        if (e.this.hcI > 0.0F) {
          f = e.this.hcI;
        }
        localObject3 = e.this;
        j = this.heb;
        localObject4 = e.this.hcE;
        int k = e.this.hcN;
        int m = e.this.hcZ.audioSampleRate;
        if (e.this.hcZ.hCX == 1) {}
        for (;;)
        {
          ((e)localObject3).hdO = new m(j, (String)localObject4, f, k, i, m, false, true, bool);
          l = bs.Gn();
          bool = e.this.hdO.ddO();
          ac.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bs.aO(l)), Boolean.valueOf(bool) });
          if (bool) {
            break;
          }
          ac.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.heb);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.this.hdd != null) {
                e.this.hdd.aSh();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.arK();
          AppMethodBeat.o(93443);
          return;
          bool = false;
        }
        localObject3 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arL();
        if (((e.this.hbQ) && (e.this.hdT)) || ((!e.this.hdT) && (!e.this.hbQ)) || ((e.this.hbQ) && (Math.abs(e.this.hcR - e.this.hdc) == 0)) || (e.this.hdc == 180))
        {
          l = bs.Gn();
          if ((e.this.hdT) || (e.this.hbQ)) {
            break label968;
          }
          i = e.this.hcR;
        }
      }
      for (;;)
      {
        j = i;
        if (e.this.hdc == 180)
        {
          j = i;
          if (!e.this.hdT)
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
          SightVideoJNI.tagRotateVideoVFS(e.this.hcE, e.this.hcT, j);
          ac.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(e.this.hcR), Boolean.valueOf(e.this.hbQ), Integer.valueOf(e.this.hdc), Integer.valueOf(j) });
          localObject3 = e.this.hcT;
        }
        try
        {
          com.tencent.mm.vfs.i.lZ(e.this.hcT, e.this.hcE);
          com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
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
                com.tencent.mm.vfs.i.deleteFile(this.hdD);
                AppMethodBeat.o(93441);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(93441);
              }
            }
          });
          ac.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
        }
        catch (Exception localException2)
        {
          label898:
          ac.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.heb);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.this.hdd != null) {
                e.this.hdd.aSh();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.e.asx(e.this.hcE);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.cV(((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label898;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.heb);
        ac.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        ap.f(this.callback);
        this.heg = true;
        e.this.hdS = -1;
        e.this.hdR = -1;
        AppMethodBeat.o(93443);
        return;
        label968:
        if (e.this.hdT) {
          i = e.this.hdc;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e
 * JD-Core Version:    0.7.0.1
 */