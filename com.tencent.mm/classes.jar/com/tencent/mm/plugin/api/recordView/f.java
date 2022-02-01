package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.l;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public final class f
  extends MMSightRecordView.e
  implements g.a, d.a, com.tencent.mm.plugin.mmsight.model.g
{
  private int audioBitrate;
  private int audioSampleRate;
  private Context context;
  private int fps;
  float hpf;
  private com.tencent.mm.plugin.mmsight.model.a.d juK;
  com.tencent.mm.plugin.mmsight.model.f juL;
  int juM;
  private int juN;
  int juO;
  private int juP;
  private boolean juQ;
  private ObservableTextureView juR;
  MMSightCameraGLSurfaceView juS;
  boolean juT;
  private MMSightRecordView.a juU;
  boolean juV;
  boolean juW;
  int juX;
  Point juY;
  private Point juZ;
  private boolean jva;
  private boolean jvb;
  private boolean jvc;
  private g jvd;
  MMSightRecordView.d jve;
  private MMSightRecordView.c jvf;
  private boolean jvg;
  private float jvh;
  h jvi;
  private Point jvj;
  private com.tencent.tinker.a.c.b jvk;
  private byte[] jvl;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.juO = 0;
    this.juQ = true;
    this.juT = false;
    this.juV = false;
    this.juW = false;
    this.juX = -1;
    this.jva = true;
    this.jvb = true;
    this.jvc = false;
    this.jvg = false;
    this.jvh = 1.0F;
    this.windowManager = null;
    this.jvi = null;
    this.jvj = new Point(0, 0);
    this.jvl = null;
    AppMethodBeat.o(89226);
  }
  
  private void aVo()
  {
    AppMethodBeat.i(89250);
    if ((this.juL != null) && (this.juL.cLT())) {
      if (!this.juL.vNV) {
        break label98;
      }
    }
    label98:
    int i;
    for (this.juZ = new Point(com.tencent.mm.plugin.mmsight.d.gy((int)(this.juL.getPreviewWidth() / this.hpf), this.juL.getPreviewHeight()), this.juL.getPreviewWidth());; this.juZ = new Point(this.juL.getPreviewHeight(), i))
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.juZ });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.gy((int)(this.juL.getPreviewHeight() * this.hpf), this.juL.getPreviewWidth());
    }
  }
  
  private int getScreenRotation()
  {
    AppMethodBeat.i(89265);
    if (this.windowManager == null) {
      this.windowManager = ((WindowManager)aj.getContext().getSystemService("window"));
    }
    if (this.windowManager == null)
    {
      AppMethodBeat.o(89265);
      return 0;
    }
    switch (this.windowManager.getDefaultDisplay().getRotation())
    {
    default: 
      AppMethodBeat.o(89265);
      return 0;
    case 0: 
      AppMethodBeat.o(89265);
      return 0;
    case 1: 
      AppMethodBeat.o(89265);
      return 90;
    case 2: 
      AppMethodBeat.o(89265);
      return 180;
    }
    AppMethodBeat.o(89265);
    return 270;
  }
  
  public final void E(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(89262);
    if ((this.juL != null) && (this.juL.cLT()) && (this.jvb)) {
      this.juL.dmO();
    }
    AppMethodBeat.o(89262);
  }
  
  public final boolean PP()
  {
    AppMethodBeat.i(89238);
    ad.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.juK });
    aVn();
    if (this.juK == null)
    {
      ad.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(89238);
      return false;
    }
    int i = getScreenRotation();
    ad.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.juK.b(this.juL.getOrientation(), true, 360 - i);; i = this.juK.b(this.juL.getOrientation(), false, i))
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(89238);
      return true;
    }
    AppMethodBeat.o(89238);
    return false;
  }
  
  public final boolean U(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89260);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(89260);
      return false;
    }
    if ((this.jvf != null) && (!this.jvc))
    {
      this.jvf.bjS();
      this.jvc = true;
    }
    if (this.jvi != null)
    {
      i = getScreenRotation();
      this.jvi.C(paramArrayOfByte, i);
    }
    int j;
    int k;
    Object localObject1;
    label197:
    label220:
    Object localObject2;
    a locala;
    int m;
    int n;
    if ((this.hpf > 0.0F) && (this.juM > 0) && (this.juL != null))
    {
      j = this.juL.getPreviewWidth();
      i = this.juL.getPreviewHeight();
      if (this.juL.vNV)
      {
        k = (int)(this.juL.getPreviewWidth() / this.hpf);
        if (k >= i) {
          break label1107;
        }
        if ((!this.juV) && (this.jvl == null))
        {
          this.jvl = new byte[j * k * 3 >> 1];
          localObject1 = this.jvl;
          bt.HI();
          if (this.juO != 1) {
            break label895;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.juZ.x, j);
          i = k;
          if (this.juV) {
            i = this.juZ.x;
          }
          this.jvg = true;
          localObject2 = localObject1;
          if (this.juS != null)
          {
            localObject2 = this.juS;
            k = this.juL.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).jus) || (j != ((MMSightCameraGLSurfaceView)localObject2).jut) || (k != ((MMSightCameraGLSurfaceView)localObject2).huh))
            {
              ad.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).jus = i;
              ((MMSightCameraGLSurfaceView)localObject2).jut = j;
              ((MMSightCameraGLSurfaceView)localObject2).huh = k;
            }
            j = getScreenRotation();
            localObject2 = this.juS;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).juC == null) || (((MMSightCameraGLSurfaceView)localObject2).juC.jur)) {
              break label1057;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).juC;
            k = ((MMSightCameraGLSurfaceView)localObject2).jus;
            m = ((MMSightCameraGLSurfaceView)localObject2).jut;
            n = ((MMSightCameraGLSurfaceView)localObject2).huh;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.jut != m) || (locala.jus != k) || (locala.dGc != n) || (locala.juB != j)) {
          continue;
        }
        if (i != 0) {
          ad.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.htY), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.jus = k;
        locala.jut = m;
        locala.dGc = n;
        locala.juB = j;
        if (i != 0)
        {
          locala.hoy = ByteBuffer.allocateDirect(m * k);
          locala.hoF = ByteBuffer.allocateDirect(k * m / 2);
          locala.hoy.order(ByteOrder.nativeOrder());
          locala.hoF.order(ByteOrder.nativeOrder());
          if (locala.juz != null)
          {
            locala.gLm.put(locala.juz);
            locala.gLm.position(0);
          }
        }
        if ((locala.hoy != null) && (locala.hoF != null))
        {
          locala.hoy.put((byte[])localObject1, 0, k * m);
          locala.hoy.position(0);
          locala.hoF.put((byte[])localObject1, k * m, k * m / 2);
          locala.hoF.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label717:
          boolean bool2;
          label895:
          ad.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.juU != null)
      {
        localObject1 = getPreviewSize();
        this.juU.s(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.juK != null)
      {
        bool1 = bool2;
        i = j;
        if (this.juK.getFrameDataCallback() != null)
        {
          if ((!this.juV) || (!this.jvg)) {
            break label1079;
          }
          bool1 = this.juK.getFrameDataCallback().U((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.juK == null) || (this.juK.axU() != d.c.vPp))) {
          com.tencent.mm.plugin.mmsight.model.a.k.vQc.k((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(this.juZ.x * this.juZ.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.juZ.x, j);
        break label197;
        k = (int)(i * this.hpf);
        if (k < j)
        {
          if ((!this.juV) && (this.jvl == null)) {
            this.jvl = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.jvl;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(this.juZ.x * this.juZ.y * 3 >> 1)))
          {
            bt.HI();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.juZ.y);
            j = this.juZ.y;
            this.jvg = true;
            break;
          }
          label1057:
          ad.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label717;
          localObject2 = paramArrayOfByte;
          break label717;
          label1079:
          bool1 = this.juK.getFrameDataCallback().U(paramArrayOfByte);
          i = j;
          continue;
        }
        localObject1 = paramArrayOfByte;
        break label220;
        label1107:
        localObject1 = paramArrayOfByte;
        break label220;
      }
    }
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void a(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89240);
    if ((paramg != null) && (this.juL != null) && (this.juL.cLT()))
    {
      if (paramBoolean) {
        this.juL.dmR();
      }
      if (paramBoolean)
      {
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89223);
            f.this.b(paramg, paramBoolean);
            AppMethodBeat.o(89223);
          }
        }, 100L);
        AppMethodBeat.o(89240);
        return;
      }
      b(paramg, paramBoolean);
    }
    AppMethodBeat.o(89240);
  }
  
  public final void a(final MMSightRecordView.h paramh)
  {
    AppMethodBeat.i(89239);
    if (this.juK != null)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.juK.a(new d.a()
      {
        public final void aVt()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.gw(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.juK.D(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.this.juT = false;
          if (paramh != null) {
            paramh.gw(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.juK = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, final MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.jvi != null)
      {
        this.jvi.release();
        this.jvi = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.jvi == null)
    {
      this.jvi = new h();
      aVw();
      this.jvi.jvx = new i.a()
      {
        public final void aVx()
        {
          AppMethodBeat.i(89225);
          if (paramf != null) {
            paramf.bjV();
          }
          AppMethodBeat.o(89225);
        }
        
        public final ByteBuffer getBuffer()
        {
          return paramByteBuffer;
        }
      };
      this.jvi.b(this.juS.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final void aVm()
  {
    AppMethodBeat.i(89236);
    aVn();
    AppMethodBeat.o(89236);
  }
  
  final void aVn()
  {
    AppMethodBeat.i(89237);
    if (this.juT)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.juK != null)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.juK.cancel();
      if (this.juL != null) {
        this.juL.b(this.juK.getFrameDataCallback());
      }
      this.juK = null;
    }
    if ((this.juM > 0) && (this.juP > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.juL != null) && (this.juL.getEncodeVideoBestSize() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.juM;
      localVideoTransPara.height = ((int)(this.juM / this.hpf));
      localVideoTransPara.duration = this.juP;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.hVe = 2;
      localVideoTransPara.hVf = 1;
      localVideoTransPara.hmx = 1;
      com.tencent.mm.plugin.mmsight.model.k.vOq.hvh = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.k.vOq.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.k.vOq.hpj = this.juM;
      l.dno();
      this.juK = l.q(localVideoTransPara);
      if (this.juK == null)
      {
        ad.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.jve != null) {
          this.jve.bjR();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.juK.setFilePath(this.videoPath);
      if ((this.juV) && (this.juL != null) && (this.juL.cLT())) {
        aVo();
      }
      int k = this.juL.getEncodeVideoBestSize().x;
      int m = this.juL.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.juZ != null)
      {
        i = m;
        j = k;
        if (this.juV)
        {
          j = this.juZ.x;
          i = this.juZ.y;
        }
      }
      j = (int)(j * this.jvh);
      i = (int)(i * this.jvh);
      j = com.tencent.mm.plugin.mmsight.d.Ki(j);
      i = com.tencent.mm.plugin.mmsight.d.Ki(i);
      ad.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.jvh) });
      if ((this.juZ != null) && (this.juV)) {
        this.juK.s(this.juZ.y, this.juZ.x, j, i);
      }
      for (;;)
      {
        this.juK.aya();
        this.juK.a(this);
        if (this.juK.od(this.juL.getOrientation())) {
          break;
        }
        ad.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.jve != null) {
          this.jve.bjR();
        }
        AppMethodBeat.o(89237);
        return;
        this.juK.s(this.juL.getPreviewWidth(), this.juL.getPreviewHeight(), j, i);
      }
      this.juT = true;
    }
    AppMethodBeat.o(89237);
  }
  
  final void aVp()
  {
    AppMethodBeat.i(89252);
    if ((this.juL != null) && (this.juL.cLT()))
    {
      if (this.juL.vNV)
      {
        int i = (int)(this.juL.getPreviewWidth() / this.hpf);
        this.juY = new Point(this.juL.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.juY = new Point((int)(this.juL.getPreviewHeight() * this.hpf), this.juL.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  final void aVq()
  {
    AppMethodBeat.i(89254);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.juX) });
    switch (this.juX)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.juL.dmR();
      AppMethodBeat.o(89254);
      return;
      this.juL.dmS();
      AppMethodBeat.o(89254);
      return;
      this.juL.dmT();
    }
  }
  
  public final void aVr()
  {
    AppMethodBeat.i(89256);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.jvh = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void aVs()
  {
    AppMethodBeat.i(89257);
    ad.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.jvh = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void aVt()
  {
    AppMethodBeat.i(89261);
    ad.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.juK.reset();
    AppMethodBeat.o(89261);
  }
  
  public final void aVu()
  {
    AppMethodBeat.i(89263);
    if ((this.juL != null) && (this.juL.cLT()) && (this.jva)) {
      this.juL.c(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void aVv()
  {
    AppMethodBeat.i(89264);
    if ((this.juL != null) && (this.juL.cLT()) && (this.jva)) {
      this.juL.c(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  final void aVw()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.jvj.y = this.juN;
    this.jvj.x = (localPoint.x * this.juN / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.jvj.y;
      this.jvj.y = this.jvj.x;
      this.jvj.x = i;
    }
    if (this.jvi != null) {
      this.jvi.i(localPoint.x, localPoint.y, this.juL.getOrientation(), this.jvj.x, this.jvj.y);
    }
    AppMethodBeat.o(89267);
  }
  
  public final boolean at(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.juL.dmP();
    if ((this.jvk != null) && (this.jvk.mSize != 0)) {
      if (this.jvk.indexOfKey(Math.round(paramFloat * 10.0F)) < 0) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    i = localList.indexOf(Integer.valueOf(this.jvk.ahV(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.juL.Kl(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.juR = new ObservableTextureView(paramContext);
    this.juS = new MMSightCameraGLSurfaceView(paramContext);
    this.juS.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.cc.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.juR, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.juS, (ViewGroup.LayoutParams)localObject);
    this.jvd = new g();
    this.jvd.jvv = this;
    this.juS.setOnTouchListener(this.jvd);
    com.tencent.mm.plugin.mmsight.model.k.dmV();
    ad.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  final void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.juL.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.this.juL.dmS();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          ad.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.bjU();
          AppMethodBeat.o(89224);
          return;
        }
        for (;;)
        {
          try
          {
            if (!f.this.juW) {
              break label473;
            }
            f.this.aVp();
            if (f.this.juL.vNV)
            {
              if (f.this.juY.y >= paramAnonymousInt1) {
                break label473;
              }
              localObject = new byte[f.this.juY.x * f.this.juY.y * 3 >> 1];
              if (f.this.juO == 1)
              {
                SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.juY.y, paramAnonymousInt2);
                paramAnonymousInt1 = f.this.juY.y;
                paramAnonymousInt2 = f.this.juY.x;
                paramAnonymousArrayOfByte = (byte[])localObject;
                paramAnonymousArrayOfByte = new YuvImage(paramAnonymousArrayOfByte, 17, paramAnonymousInt1, paramAnonymousInt2, null);
                localObject = new ByteArrayOutputStream();
                paramAnonymousArrayOfByte.compressToJpeg(new Rect(0, 0, paramAnonymousInt1, paramAnonymousInt2), 100, (OutputStream)localObject);
                paramAnonymousArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
                localObject = MMBitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
                if (paramAnonymousInt4 == 90) {
                  break label476;
                }
                paramAnonymousInt1 = paramAnonymousInt3;
                if (paramAnonymousInt4 != 270) {
                  break label490;
                }
                break label476;
                label267:
                paramAnonymousArrayOfByte = ((Bitmap)localObject).copy(Bitmap.Config.ARGB_8888, false);
                label277:
                ad.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject.toString() });
                ((Bitmap)localObject).recycle();
                paramg.N(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89224);
                return;
              }
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.juY.y, paramAnonymousInt2);
              continue;
            }
            if (f.this.juY.x >= paramAnonymousInt2) {
              break label473;
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ad.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.bjU();
            AppMethodBeat.o(89224);
            return;
          }
          Object localObject = new byte[f.this.juY.x * f.this.juY.y * 3 >> 1];
          SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.this.juY.x);
          paramAnonymousInt1 = f.this.juY.y;
          paramAnonymousInt2 = f.this.juY.x;
          paramAnonymousArrayOfByte = (byte[])localObject;
          continue;
          label473:
          label476:
          label490:
          do
          {
            paramAnonymousArrayOfByte = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, paramAnonymousInt1);
            break label277;
            break;
            paramAnonymousInt1 = (paramAnonymousInt3 - paramAnonymousInt4 + 360) % 360;
            if (paramAnonymousInt1 == 0) {
              break label267;
            }
          } while (paramAnonymousInt1 != 360);
        }
      }
    }, false, getScreenRotation());
    AppMethodBeat.o(89241);
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(89247);
    if (this.juL != null)
    {
      int i = this.juL.getOrientation();
      AppMethodBeat.o(89247);
      return i;
    }
    AppMethodBeat.o(89247);
    return 0;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    AppMethodBeat.i(89258);
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    int k;
    if ((this.juL != null) && (this.juL.cLT()))
    {
      localObject2 = this.juL;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).hpZ != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).hpY = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).hpZ.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).hpZ, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).hpZ.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).hpY = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.juL.getPreviewWidth();
        i = this.juL.getPreviewHeight();
        if (!this.juL.vNV) {
          break label379;
        }
        k = (int)(this.juL.getPreviewWidth() / this.hpf);
        if (k >= i) {
          break label506;
        }
        if ((this.juV) || (this.jvl != null)) {
          break label327;
        }
        this.jvl = new byte[j * k * 3 >> 1];
        localObject2 = this.jvl;
        label161:
        if (this.juO != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.juZ.x, j);
        label185:
        i = k;
        if (this.juV) {
          i = this.juZ.x;
        }
        this.jvg = true;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      for (;;)
      {
        localObject1 = new YuvImage((byte[])localObject1, 17, i, j, null);
        localObject2 = new ByteArrayOutputStream();
        ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, i, j), 100, (OutputStream)localObject2);
        localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
        localObject1 = MMBitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        localObject2 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, this.juL.getOrientation());
        ad.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(this.juZ.x * this.juZ.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.juZ.x, j);
        break label185;
        label379:
        k = (int)(i * this.hpf);
        if (k < j)
        {
          if ((!this.juV) && (this.jvl == null)) {
            this.jvl = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.jvl;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(this.juZ.x * this.juZ.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.juZ.y);
            j = this.juZ.y;
            this.jvg = true;
            localObject1 = localObject2;
            break;
          }
          label495:
          AppMethodBeat.o(89258);
          return null;
        }
      }
      label506:
      localObject2 = localObject1;
    }
  }
  
  public final Point getDrawSizePoint()
  {
    AppMethodBeat.i(89246);
    ad.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.jvj.toString() });
    Point localPoint = this.jvj;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.juX;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.juL != null) && (this.juL.cLT()))
    {
      if (!this.juW)
      {
        localPoint = new Point(this.juL.getPreviewWidth(), this.juL.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      aVp();
      Point localPoint = this.juY;
      AppMethodBeat.o(89243);
      return localPoint;
    }
    AppMethodBeat.o(89243);
    return null;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(89245);
    int i;
    if ((this.juL.getOrientation() == 0) || (this.juL.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.juL.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.juL.getPreviewHeight();; j = this.juL.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.juL.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    if ((this.jvk == null) || (this.jvk.mSize == 0)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.jvk.mSize];
    while (i < this.jvk.mSize)
    {
      arrayOfFloat[i] = (this.jvk.OW[i] * 1.0F / 10.0F);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.juK != null) && (this.juT))
    {
      str = this.juK.getFilePath();
      AppMethodBeat.o(89235);
      return str;
    }
    String str = this.videoPath;
    AppMethodBeat.o(89235);
    return str;
  }
  
  public final Point getVideoSize()
  {
    AppMethodBeat.i(89244);
    if ((this.juL != null) && (this.juL.cLT()))
    {
      int k = this.juL.getEncodeVideoBestSize().x;
      int m = this.juL.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.juZ != null)
      {
        i = m;
        j = k;
        if (this.juV)
        {
          j = this.juZ.x;
          i = this.juZ.y;
        }
      }
      j = (int)(j * this.jvh);
      i = (int)(i * this.jvh);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.Ki(j), com.tencent.mm.plugin.mmsight.d.Ki(i));
      AppMethodBeat.o(89244);
      return localPoint;
    }
    AppMethodBeat.o(89244);
    return null;
  }
  
  public final void l(MotionEvent paramMotionEvent) {}
  
  public final void release()
  {
    AppMethodBeat.i(89259);
    ad.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.juL, this.juK });
    if (this.juL != null)
    {
      this.juL.b(this);
      this.juL.dmQ();
    }
    if (this.juK != null)
    {
      this.juK.a(null);
      this.juK.D(null);
      this.juK = null;
    }
    if (this.jvi != null) {
      this.jvi.release();
    }
    if (this.jvk != null) {
      this.jvk.mSize = 0;
    }
    this.jvk = null;
    this.juT = false;
    this.juV = false;
    this.juW = false;
    this.juY = null;
    this.juZ = null;
    this.juX = -1;
    this.jva = true;
    this.jvb = true;
    this.jvc = false;
    com.tencent.mm.plugin.mmsight.model.a.k.vQc.ayw();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.juW = paramBoolean;
    if ((this.juW) && (this.juL != null) && (this.juL.cLT())) {
      aVp();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.juV = paramBoolean;
    if ((this.juV) && (this.juL != null) && (this.juL.cLT())) {
      aVo();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    ad.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.hpf = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.hpf = (1.0F / this.hpf);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.jva = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.jvb = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.juX = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.juL;
    if ((this.juL != null) && (this.juL.cLT())) {}
    for (;;)
    {
      ad.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.juL != null) && (this.juL.cLT())) {
        aVq();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.juU = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.jvf = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.jve = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.juO = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.juM = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.juN = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.juQ = paramBoolean;
    AppMethodBeat.o(89242);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(89234);
    ad.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(89234);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.juP = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.audioBitrate = 64000;
    this.audioSampleRate = 44100;
    ad.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(89233);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(89232);
    ad.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.hpf), Integer.valueOf(this.juM) });
    this.jvc = false;
    if ((this.hpf > 0.0F) && (this.juM > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.juM;
      ((VideoTransPara)localObject).height = ((int)(this.juM / this.hpf));
      ad.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.juL = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.juL.a(this);
      if (!this.juL.A(this.context, this.juQ))
      {
        ad.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.jve != null) {
          this.jve.bjR();
        }
        AppMethodBeat.o(89232);
        return;
      }
      ad.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.juL.dmP();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.juR.isAvailable())
        {
          if (this.juL.a(this.juR.getSurfaceTexture(), this.juM, this.hpf, this.juV) < 0)
          {
            ad.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.jve != null) {
              this.jve.bjR();
            }
          }
          if (this.juX != -1) {
            aVq();
          }
          this.juL.dmM();
          ad.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          aVn();
          aVw();
          if (this.jvi != null) {
            this.jvi.b(this.juS.getEglContext());
          }
          AppMethodBeat.o(89232);
        }
      }
      else
      {
        int k = ((Integer)((List)localObject).get(((List)localObject).size() - 1)).intValue();
        int j = k;
        int i = 1;
        while (j / 10 >= 10)
        {
          i *= 10;
          j /= 10;
        }
        int m = k / i;
        j = m;
        if ((k + 4) / i > m) {
          j = m + 1;
        }
        this.jvk = new com.tencent.tinker.a.c.b(j);
        k = 10;
        label443:
        if (k <= j)
        {
          if (((List)localObject).indexOf(Integer.valueOf(k * i)) >= 0) {
            break label558;
          }
          m = 1;
          label467:
          if (m <= 4)
          {
            if (((List)localObject).indexOf(Integer.valueOf(k * i - m)) <= 0) {
              break label513;
            }
            this.jvk.append(k, k * i - m);
          }
        }
        for (;;)
        {
          k += 1;
          break label443;
          break;
          label513:
          if (((List)localObject).indexOf(Integer.valueOf(k * i + m)) > 0)
          {
            this.jvk.append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.jvk.append(k, k * i);
          }
        }
      }
      this.juR.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.this.juL.a(paramAnonymousSurfaceTexture, f.this.juM, f.this.hpf, f.this.juV) < 0)
          {
            ad.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.this.jve != null) {
              f.this.jve.bjR();
            }
          }
          if (f.this.juX != -1) {
            f.this.aVq();
          }
          f.this.juL.dmM();
          f.this.aVn();
          f.this.aVw();
          if (f.this.jvi != null) {
            f.this.jvi.b(f.this.juS.getEglContext());
          }
          ad.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(89248);
    if ((this.juL != null) && (this.juL.cLT()) && ((this.juK == null) || (this.juK.axU() != d.c.vPp)))
    {
      this.juL.a(this.context, this.juR.getSurfaceTexture(), this.juM, this.hpf, this.juV);
      if (this.jvi != null) {
        aVw();
      }
    }
    AppMethodBeat.o(89248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */