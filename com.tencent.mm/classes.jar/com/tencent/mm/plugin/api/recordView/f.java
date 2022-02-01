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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  float hrT;
  private com.tencent.mm.plugin.mmsight.model.a.d jxF;
  com.tencent.mm.plugin.mmsight.model.f jxG;
  int jxH;
  private int jxI;
  int jxJ;
  private int jxK;
  private boolean jxL;
  private ObservableTextureView jxM;
  MMSightCameraGLSurfaceView jxN;
  boolean jxO;
  private MMSightRecordView.a jxP;
  boolean jxQ;
  boolean jxR;
  int jxS;
  Point jxT;
  private Point jxU;
  private boolean jxV;
  private boolean jxW;
  private boolean jxX;
  private g jxY;
  MMSightRecordView.d jxZ;
  private MMSightRecordView.c jya;
  private boolean jyb;
  private float jyc;
  h jyd;
  private Point jye;
  private com.tencent.tinker.a.c.b jyf;
  private byte[] jyg;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.jxJ = 0;
    this.jxL = true;
    this.jxO = false;
    this.jxQ = false;
    this.jxR = false;
    this.jxS = -1;
    this.jxV = true;
    this.jxW = true;
    this.jxX = false;
    this.jyb = false;
    this.jyc = 1.0F;
    this.windowManager = null;
    this.jyd = null;
    this.jye = new Point(0, 0);
    this.jyg = null;
    AppMethodBeat.o(89226);
  }
  
  private void aVN()
  {
    AppMethodBeat.i(89250);
    if ((this.jxG != null) && (this.jxG.cOB())) {
      if (!this.jxG.vZY) {
        break label98;
      }
    }
    label98:
    int i;
    for (this.jxU = new Point(com.tencent.mm.plugin.mmsight.d.gy((int)(this.jxG.getPreviewWidth() / this.hrT), this.jxG.getPreviewHeight()), this.jxG.getPreviewWidth());; this.jxU = new Point(this.jxG.getPreviewHeight(), i))
    {
      ae.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.jxU });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.gy((int)(this.jxG.getPreviewHeight() * this.hrT), this.jxG.getPreviewWidth());
    }
  }
  
  private int getScreenRotation()
  {
    AppMethodBeat.i(89265);
    if (this.windowManager == null) {
      this.windowManager = ((WindowManager)ak.getContext().getSystemService("window"));
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
    if ((this.jxG != null) && (this.jxG.cOB()) && (this.jxW)) {
      this.jxG.dpM();
    }
    AppMethodBeat.o(89262);
  }
  
  public final boolean PO()
  {
    AppMethodBeat.i(89238);
    ae.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.jxF });
    aVM();
    if (this.jxF == null)
    {
      ae.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(89238);
      return false;
    }
    int i = getScreenRotation();
    ae.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.jxF.b(this.jxG.getOrientation(), true, 360 - i);; i = this.jxF.b(this.jxG.getOrientation(), false, i))
    {
      ae.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
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
    if ((this.jya != null) && (!this.jxX))
    {
      this.jya.bkB();
      this.jxX = true;
    }
    if (this.jyd != null)
    {
      i = getScreenRotation();
      this.jyd.C(paramArrayOfByte, i);
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
    if ((this.hrT > 0.0F) && (this.jxH > 0) && (this.jxG != null))
    {
      j = this.jxG.getPreviewWidth();
      i = this.jxG.getPreviewHeight();
      if (this.jxG.vZY)
      {
        k = (int)(this.jxG.getPreviewWidth() / this.hrT);
        if (k >= i) {
          break label1107;
        }
        if ((!this.jxQ) && (this.jyg == null))
        {
          this.jyg = new byte[j * k * 3 >> 1];
          localObject1 = this.jyg;
          bu.HQ();
          if (this.jxJ != 1) {
            break label895;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.jxU.x, j);
          i = k;
          if (this.jxQ) {
            i = this.jxU.x;
          }
          this.jyb = true;
          localObject2 = localObject1;
          if (this.jxN != null)
          {
            localObject2 = this.jxN;
            k = this.jxG.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).jxn) || (j != ((MMSightCameraGLSurfaceView)localObject2).jxo) || (k != ((MMSightCameraGLSurfaceView)localObject2).hwV))
            {
              ae.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).jxn = i;
              ((MMSightCameraGLSurfaceView)localObject2).jxo = j;
              ((MMSightCameraGLSurfaceView)localObject2).hwV = k;
            }
            j = getScreenRotation();
            localObject2 = this.jxN;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).jxx == null) || (((MMSightCameraGLSurfaceView)localObject2).jxx.jxm)) {
              break label1057;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).jxx;
            k = ((MMSightCameraGLSurfaceView)localObject2).jxn;
            m = ((MMSightCameraGLSurfaceView)localObject2).jxo;
            n = ((MMSightCameraGLSurfaceView)localObject2).hwV;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.jxo != m) || (locala.jxn != k) || (locala.dHi != n) || (locala.jxw != j)) {
          continue;
        }
        if (i != 0) {
          ae.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.hwM), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.jxn = k;
        locala.jxo = m;
        locala.dHi = n;
        locala.jxw = j;
        if (i != 0)
        {
          locala.hrm = ByteBuffer.allocateDirect(m * k);
          locala.hrt = ByteBuffer.allocateDirect(k * m / 2);
          locala.hrm.order(ByteOrder.nativeOrder());
          locala.hrt.order(ByteOrder.nativeOrder());
          if (locala.jxu != null)
          {
            locala.gNV.put(locala.jxu);
            locala.gNV.position(0);
          }
        }
        if ((locala.hrm != null) && (locala.hrt != null))
        {
          locala.hrm.put((byte[])localObject1, 0, k * m);
          locala.hrm.position(0);
          locala.hrt.put((byte[])localObject1, k * m, k * m / 2);
          locala.hrt.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label717:
          boolean bool2;
          label895:
          ae.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.jxP != null)
      {
        localObject1 = getPreviewSize();
        this.jxP.s(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.jxF != null)
      {
        bool1 = bool2;
        i = j;
        if (this.jxF.getFrameDataCallback() != null)
        {
          if ((!this.jxQ) || (!this.jyb)) {
            break label1079;
          }
          bool1 = this.jxF.getFrameDataCallback().U((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.jxF == null) || (this.jxF.ayj() != d.c.wbs))) {
          com.tencent.mm.plugin.mmsight.model.a.k.wcg.k((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(this.jxU.x * this.jxU.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.jxU.x, j);
        break label197;
        k = (int)(i * this.hrT);
        if (k < j)
        {
          if ((!this.jxQ) && (this.jyg == null)) {
            this.jyg = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.jyg;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(this.jxU.x * this.jxU.y * 3 >> 1)))
          {
            bu.HQ();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.jxU.y);
            j = this.jxU.y;
            this.jyb = true;
            break;
          }
          label1057:
          ae.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label717;
          localObject2 = paramArrayOfByte;
          break label717;
          label1079:
          bool1 = this.jxF.getFrameDataCallback().U(paramArrayOfByte);
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
    if ((paramg != null) && (this.jxG != null) && (this.jxG.cOB()))
    {
      if (paramBoolean) {
        this.jxG.dpP();
      }
      if (paramBoolean)
      {
        ar.o(new Runnable()
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
    if (this.jxF != null)
    {
      ae.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.jxF.a(new d.a()
      {
        public final void aVS()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.gu(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.jxF.B(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.this.jxO = false;
          if (paramh != null) {
            paramh.gu(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.jxF = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, final MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.jyd != null)
      {
        this.jyd.release();
        this.jyd = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.jyd == null)
    {
      this.jyd = new h();
      aVV();
      this.jyd.jys = new i.a()
      {
        public final void aVW()
        {
          AppMethodBeat.i(89225);
          if (paramf != null) {
            paramf.bkE();
          }
          AppMethodBeat.o(89225);
        }
        
        public final ByteBuffer getBuffer()
        {
          return paramByteBuffer;
        }
      };
      this.jyd.b(this.jxN.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final void aVL()
  {
    AppMethodBeat.i(89236);
    aVM();
    AppMethodBeat.o(89236);
  }
  
  final void aVM()
  {
    AppMethodBeat.i(89237);
    if (this.jxO)
    {
      ae.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.jxF != null)
    {
      ae.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.jxF.cancel();
      if (this.jxG != null) {
        this.jxG.b(this.jxF.getFrameDataCallback());
      }
      this.jxF = null;
    }
    if ((this.jxH > 0) && (this.jxK > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.jxG != null) && (this.jxG.getEncodeVideoBestSize() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.jxH;
      localVideoTransPara.height = ((int)(this.jxH / this.hrT));
      localVideoTransPara.duration = this.jxK;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.hXW = 2;
      localVideoTransPara.hXX = 1;
      localVideoTransPara.hpl = 1;
      com.tencent.mm.plugin.mmsight.model.k.wat.hxV = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.k.wat.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.k.wat.hrX = this.jxH;
      l.dqm();
      this.jxF = l.q(localVideoTransPara);
      if (this.jxF == null)
      {
        ae.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.jxZ != null) {
          this.jxZ.bkA();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.jxF.setFilePath(this.videoPath);
      if ((this.jxQ) && (this.jxG != null) && (this.jxG.cOB())) {
        aVN();
      }
      int k = this.jxG.getEncodeVideoBestSize().x;
      int m = this.jxG.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.jxU != null)
      {
        i = m;
        j = k;
        if (this.jxQ)
        {
          j = this.jxU.x;
          i = this.jxU.y;
        }
      }
      j = (int)(j * this.jyc);
      i = (int)(i * this.jyc);
      j = com.tencent.mm.plugin.mmsight.d.KI(j);
      i = com.tencent.mm.plugin.mmsight.d.KI(i);
      ae.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.jyc) });
      if ((this.jxU != null) && (this.jxQ)) {
        this.jxF.s(this.jxU.y, this.jxU.x, j, i);
      }
      for (;;)
      {
        this.jxF.ayp();
        this.jxF.a(this);
        if (this.jxF.og(this.jxG.getOrientation())) {
          break;
        }
        ae.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.jxZ != null) {
          this.jxZ.bkA();
        }
        AppMethodBeat.o(89237);
        return;
        this.jxF.s(this.jxG.getPreviewWidth(), this.jxG.getPreviewHeight(), j, i);
      }
      this.jxO = true;
    }
    AppMethodBeat.o(89237);
  }
  
  final void aVO()
  {
    AppMethodBeat.i(89252);
    if ((this.jxG != null) && (this.jxG.cOB()))
    {
      if (this.jxG.vZY)
      {
        int i = (int)(this.jxG.getPreviewWidth() / this.hrT);
        this.jxT = new Point(this.jxG.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.jxT = new Point((int)(this.jxG.getPreviewHeight() * this.hrT), this.jxG.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  final void aVP()
  {
    AppMethodBeat.i(89254);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.jxS) });
    switch (this.jxS)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.jxG.dpP();
      AppMethodBeat.o(89254);
      return;
      this.jxG.dpQ();
      AppMethodBeat.o(89254);
      return;
      this.jxG.dpR();
    }
  }
  
  public final void aVQ()
  {
    AppMethodBeat.i(89256);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.jyc = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void aVR()
  {
    AppMethodBeat.i(89257);
    ae.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.jyc = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void aVS()
  {
    AppMethodBeat.i(89261);
    ae.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.jxF.reset();
    AppMethodBeat.o(89261);
  }
  
  public final void aVT()
  {
    AppMethodBeat.i(89263);
    if ((this.jxG != null) && (this.jxG.cOB()) && (this.jxV)) {
      this.jxG.d(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void aVU()
  {
    AppMethodBeat.i(89264);
    if ((this.jxG != null) && (this.jxG.cOB()) && (this.jxV)) {
      this.jxG.d(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  final void aVV()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.jye.y = this.jxI;
    this.jye.x = (localPoint.x * this.jxI / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.jye.y;
      this.jye.y = this.jye.x;
      this.jye.x = i;
    }
    if (this.jyd != null) {
      this.jyd.i(localPoint.x, localPoint.y, this.jxG.getOrientation(), this.jye.x, this.jye.y);
    }
    AppMethodBeat.o(89267);
  }
  
  public final boolean at(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.jxG.dpN();
    if ((this.jyf != null) && (this.jyf.mSize != 0)) {
      if (this.jyf.indexOfKey(Math.round(paramFloat * 10.0F)) < 0) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    i = localList.indexOf(Integer.valueOf(this.jyf.aiE(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.jxG.KL(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.jxM = new ObservableTextureView(paramContext);
    this.jxN = new MMSightCameraGLSurfaceView(paramContext);
    this.jxN.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.jxM, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.jxN, (ViewGroup.LayoutParams)localObject);
    this.jxY = new g();
    this.jxY.jyq = this;
    this.jxN.setOnTouchListener(this.jxY);
    com.tencent.mm.plugin.mmsight.model.k.dpT();
    ae.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  final void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.jxG.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.this.jxG.dpQ();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          ae.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.bkD();
          AppMethodBeat.o(89224);
          return;
        }
        for (;;)
        {
          try
          {
            if (!f.this.jxR) {
              break label473;
            }
            f.this.aVO();
            if (f.this.jxG.vZY)
            {
              if (f.this.jxT.y >= paramAnonymousInt1) {
                break label473;
              }
              localObject = new byte[f.this.jxT.x * f.this.jxT.y * 3 >> 1];
              if (f.this.jxJ == 1)
              {
                SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.jxT.y, paramAnonymousInt2);
                paramAnonymousInt1 = f.this.jxT.y;
                paramAnonymousInt2 = f.this.jxT.x;
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
                ae.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject.toString() });
                ((Bitmap)localObject).recycle();
                paramg.O(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89224);
                return;
              }
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.jxT.y, paramAnonymousInt2);
              continue;
            }
            if (f.this.jxT.x >= paramAnonymousInt2) {
              break label473;
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ae.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.bkD();
            AppMethodBeat.o(89224);
            return;
          }
          Object localObject = new byte[f.this.jxT.x * f.this.jxT.y * 3 >> 1];
          SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.this.jxT.x);
          paramAnonymousInt1 = f.this.jxT.y;
          paramAnonymousInt2 = f.this.jxT.x;
          paramAnonymousArrayOfByte = (byte[])localObject;
          continue;
          label473:
          label476:
          label490:
          do
          {
            paramAnonymousArrayOfByte = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, paramAnonymousInt1);
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
    if (this.jxG != null)
    {
      int i = this.jxG.getOrientation();
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
    if ((this.jxG != null) && (this.jxG.cOB()))
    {
      localObject2 = this.jxG;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).hsN != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).hsM = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).hsN.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).hsN, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).hsN.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).hsM = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.jxG.getPreviewWidth();
        i = this.jxG.getPreviewHeight();
        if (!this.jxG.vZY) {
          break label379;
        }
        k = (int)(this.jxG.getPreviewWidth() / this.hrT);
        if (k >= i) {
          break label506;
        }
        if ((this.jxQ) || (this.jyg != null)) {
          break label327;
        }
        this.jyg = new byte[j * k * 3 >> 1];
        localObject2 = this.jyg;
        label161:
        if (this.jxJ != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.jxU.x, j);
        label185:
        i = k;
        if (this.jxQ) {
          i = this.jxU.x;
        }
        this.jyb = true;
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
        localObject2 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, this.jxG.getOrientation());
        ae.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(this.jxU.x * this.jxU.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.jxU.x, j);
        break label185;
        label379:
        k = (int)(i * this.hrT);
        if (k < j)
        {
          if ((!this.jxQ) && (this.jyg == null)) {
            this.jyg = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.jyg;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(this.jxU.x * this.jxU.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.jxU.y);
            j = this.jxU.y;
            this.jyb = true;
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
    ae.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.jye.toString() });
    Point localPoint = this.jye;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.jxS;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.jxG != null) && (this.jxG.cOB()))
    {
      if (!this.jxR)
      {
        localPoint = new Point(this.jxG.getPreviewWidth(), this.jxG.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      aVO();
      Point localPoint = this.jxT;
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
    if ((this.jxG.getOrientation() == 0) || (this.jxG.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.jxG.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.jxG.getPreviewHeight();; j = this.jxG.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.jxG.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    if ((this.jyf == null) || (this.jyf.mSize == 0)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.jyf.mSize];
    while (i < this.jyf.mSize)
    {
      arrayOfFloat[i] = (this.jyf.OW[i] * 1.0F / 10.0F);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.jxF != null) && (this.jxO))
    {
      str = this.jxF.getFilePath();
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
    if ((this.jxG != null) && (this.jxG.cOB()))
    {
      int k = this.jxG.getEncodeVideoBestSize().x;
      int m = this.jxG.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.jxU != null)
      {
        i = m;
        j = k;
        if (this.jxQ)
        {
          j = this.jxU.x;
          i = this.jxU.y;
        }
      }
      j = (int)(j * this.jyc);
      i = (int)(i * this.jyc);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.KI(j), com.tencent.mm.plugin.mmsight.d.KI(i));
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
    ae.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.jxG, this.jxF });
    if (this.jxG != null)
    {
      this.jxG.b(this);
      this.jxG.dpO();
    }
    if (this.jxF != null)
    {
      this.jxF.a(null);
      this.jxF.B(null);
      this.jxF = null;
    }
    if (this.jyd != null) {
      this.jyd.release();
    }
    if (this.jyf != null) {
      this.jyf.mSize = 0;
    }
    this.jyf = null;
    this.jxO = false;
    this.jxQ = false;
    this.jxR = false;
    this.jxT = null;
    this.jxU = null;
    this.jxS = -1;
    this.jxV = true;
    this.jxW = true;
    this.jxX = false;
    com.tencent.mm.plugin.mmsight.model.a.k.wcg.ayL();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.jxR = paramBoolean;
    if ((this.jxR) && (this.jxG != null) && (this.jxG.cOB())) {
      aVO();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.jxQ = paramBoolean;
    if ((this.jxQ) && (this.jxG != null) && (this.jxG.cOB())) {
      aVN();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    ae.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.hrT = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.hrT = (1.0F / this.hrT);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.jxV = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.jxW = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.jxS = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.jxG;
    if ((this.jxG != null) && (this.jxG.cOB())) {}
    for (;;)
    {
      ae.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.jxG != null) && (this.jxG.cOB())) {
        aVP();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.jxP = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.jya = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.jxZ = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jxJ = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jxH = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jxI = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jxL = paramBoolean;
    AppMethodBeat.o(89242);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(89234);
    ae.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(89234);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.jxK = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.audioBitrate = 64000;
    this.audioSampleRate = 44100;
    ae.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(89233);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(89232);
    ae.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.hrT), Integer.valueOf(this.jxH) });
    this.jxX = false;
    if ((this.hrT > 0.0F) && (this.jxH > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.jxH;
      ((VideoTransPara)localObject).height = ((int)(this.jxH / this.hrT));
      ae.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.jxG = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.jxG.a(this);
      if (!this.jxG.A(this.context, this.jxL))
      {
        ae.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.jxZ != null) {
          this.jxZ.bkA();
        }
        AppMethodBeat.o(89232);
        return;
      }
      ae.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.jxG.dpN();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.jxM.isAvailable())
        {
          if (this.jxG.a(this.jxM.getSurfaceTexture(), this.jxH, this.hrT, this.jxQ) < 0)
          {
            ae.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.jxZ != null) {
              this.jxZ.bkA();
            }
          }
          if (this.jxS != -1) {
            aVP();
          }
          this.jxG.dpK();
          ae.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          aVM();
          aVV();
          if (this.jyd != null) {
            this.jyd.b(this.jxN.getEglContext());
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
        this.jyf = new com.tencent.tinker.a.c.b(j);
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
            this.jyf.append(k, k * i - m);
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
            this.jyf.append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.jyf.append(k, k * i);
          }
        }
      }
      this.jxM.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.this.jxG.a(paramAnonymousSurfaceTexture, f.this.jxH, f.this.hrT, f.this.jxQ) < 0)
          {
            ae.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.this.jxZ != null) {
              f.this.jxZ.bkA();
            }
          }
          if (f.this.jxS != -1) {
            f.this.aVP();
          }
          f.this.jxG.dpK();
          f.this.aVM();
          f.this.aVV();
          if (f.this.jyd != null) {
            f.this.jyd.b(f.this.jxN.getEglContext());
          }
          ae.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(89248);
    if ((this.jxG != null) && (this.jxG.cOB()) && ((this.jxF == null) || (this.jxF.ayj() != d.c.wbs)))
    {
      this.jxG.a(this.context, this.jxM.getSurfaceTexture(), this.jxH, this.hrT, this.jxQ);
      if (this.jyd != null) {
        aVV();
      }
    }
    AppMethodBeat.o(89248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */