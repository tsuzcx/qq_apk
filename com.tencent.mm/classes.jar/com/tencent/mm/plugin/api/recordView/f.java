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
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.f.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  float gWZ;
  private com.tencent.mm.plugin.mmsight.model.a.d jbB;
  com.tencent.mm.plugin.mmsight.model.f jbC;
  int jbD;
  private int jbE;
  int jbF;
  private int jbG;
  private boolean jbH;
  private ObservableTextureView jbI;
  MMSightCameraGLSurfaceView jbJ;
  boolean jbK;
  private MMSightRecordView.a jbL;
  boolean jbM;
  boolean jbN;
  int jbO;
  Point jbP;
  private Point jbQ;
  private boolean jbR;
  private boolean jbS;
  private boolean jbT;
  private g jbU;
  MMSightRecordView.d jbV;
  private MMSightRecordView.c jbW;
  private boolean jbX;
  private float jbY;
  h jbZ;
  private Point jca;
  private com.tencent.tinker.a.c.b jcb;
  private byte[] jcc;
  private int videoBitrate;
  private String videoPath;
  private WindowManager windowManager;
  
  public f()
  {
    AppMethodBeat.i(89226);
    this.jbF = 0;
    this.jbH = true;
    this.jbK = false;
    this.jbM = false;
    this.jbN = false;
    this.jbO = -1;
    this.jbR = true;
    this.jbS = true;
    this.jbT = false;
    this.jbX = false;
    this.jbY = 1.0F;
    this.windowManager = null;
    this.jbZ = null;
    this.jca = new Point(0, 0);
    this.jcc = null;
    AppMethodBeat.o(89226);
  }
  
  private void aSc()
  {
    AppMethodBeat.i(89250);
    if ((this.jbC != null) && (this.jbC.cDz())) {
      if (!this.jbC.uKP) {
        break label98;
      }
    }
    label98:
    int i;
    for (this.jbQ = new Point(com.tencent.mm.plugin.mmsight.d.gh((int)(this.jbC.getPreviewWidth() / this.gWZ), this.jbC.getPreviewHeight()), this.jbC.getPreviewWidth());; this.jbQ = new Point(this.jbC.getPreviewHeight(), i))
    {
      ac.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.jbQ });
      AppMethodBeat.o(89250);
      return;
      i = com.tencent.mm.plugin.mmsight.d.gh((int)(this.jbC.getPreviewHeight() * this.gWZ), this.jbC.getPreviewWidth());
    }
  }
  
  private int getScreenRotation()
  {
    AppMethodBeat.i(89265);
    if (this.windowManager == null) {
      this.windowManager = ((WindowManager)ai.getContext().getSystemService("window"));
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
  
  public final void D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(89262);
    if ((this.jbC != null) && (this.jbC.cDz()) && (this.jbS)) {
      this.jbC.dds();
    }
    AppMethodBeat.o(89262);
  }
  
  public final boolean Og()
  {
    AppMethodBeat.i(89238);
    ac.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.jbB });
    aSb();
    if (this.jbB == null)
    {
      ac.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      AppMethodBeat.o(89238);
      return false;
    }
    int i = getScreenRotation();
    ac.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.jbB.b(this.jbC.getOrientation(), true, 360 - i);; i = this.jbB.b(this.jbC.getOrientation(), false, i))
    {
      ac.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      AppMethodBeat.o(89238);
      return true;
    }
    AppMethodBeat.o(89238);
    return false;
  }
  
  public final boolean V(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89260);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(89260);
      return false;
    }
    if ((this.jbW != null) && (!this.jbT))
    {
      this.jbW.bgo();
      this.jbT = true;
    }
    if (this.jbZ != null)
    {
      i = getScreenRotation();
      this.jbZ.C(paramArrayOfByte, i);
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
    if ((this.gWZ > 0.0F) && (this.jbD > 0) && (this.jbC != null))
    {
      j = this.jbC.getPreviewWidth();
      i = this.jbC.getPreviewHeight();
      if (this.jbC.uKP)
      {
        k = (int)(this.jbC.getPreviewWidth() / this.gWZ);
        if (k >= i) {
          break label1107;
        }
        if ((!this.jbM) && (this.jcc == null))
        {
          this.jcc = new byte[j * k * 3 >> 1];
          localObject1 = this.jcc;
          bs.Gn();
          if (this.jbF != 1) {
            break label895;
          }
          SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramArrayOfByte, (byte[])localObject1, i, this.jbQ.x, j);
          i = k;
          if (this.jbM) {
            i = this.jbQ.x;
          }
          this.jbX = true;
          localObject2 = localObject1;
          if (this.jbJ != null)
          {
            localObject2 = this.jbJ;
            k = this.jbC.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).jbj) || (j != ((MMSightCameraGLSurfaceView)localObject2).jbk) || (k != ((MMSightCameraGLSurfaceView)localObject2).hbZ))
            {
              ac.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).jbj = i;
              ((MMSightCameraGLSurfaceView)localObject2).jbk = j;
              ((MMSightCameraGLSurfaceView)localObject2).hbZ = k;
            }
            j = getScreenRotation();
            localObject2 = this.jbJ;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).jbt == null) || (((MMSightCameraGLSurfaceView)localObject2).jbt.jbi)) {
              break label1057;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).jbt;
            k = ((MMSightCameraGLSurfaceView)localObject2).jbj;
            m = ((MMSightCameraGLSurfaceView)localObject2).jbk;
            n = ((MMSightCameraGLSurfaceView)localObject2).hbZ;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      try
      {
        if ((locala.jbk != m) || (locala.jbj != k) || (locala.duc != n) || (locala.jbs != j)) {
          continue;
        }
        if (i != 0) {
          ac.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.hbQ), Boolean.TRUE, locala });
        }
        locala.frameData = ((byte[])localObject1);
        locala.jbj = k;
        locala.jbk = m;
        locala.duc = n;
        locala.jbs = j;
        if (i != 0)
        {
          locala.gWs = ByteBuffer.allocateDirect(m * k);
          locala.gWz = ByteBuffer.allocateDirect(k * m / 2);
          locala.gWs.order(ByteOrder.nativeOrder());
          locala.gWz.order(ByteOrder.nativeOrder());
          if (locala.jbq != null)
          {
            locala.grE.put(locala.jbq);
            locala.grE.position(0);
          }
        }
        if ((locala.gWs != null) && (locala.gWz != null))
        {
          locala.gWs.put((byte[])localObject1, 0, k * m);
          locala.gWs.position(0);
          locala.gWz.put((byte[])localObject1, k * m, k * m / 2);
          locala.gWz.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label717:
          boolean bool2;
          label895:
          ac.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.jbL != null)
      {
        localObject1 = getPreviewSize();
        this.jbL.s(paramArrayOfByte, ((Point)localObject1).x, ((Point)localObject1).y);
      }
      bool2 = true;
      j = 0;
      boolean bool1 = bool2;
      i = j;
      if (this.jbB != null)
      {
        bool1 = bool2;
        i = j;
        if (this.jbB.getFrameDataCallback() != null)
        {
          if ((!this.jbM) || (!this.jbX)) {
            break label1079;
          }
          bool1 = this.jbB.getFrameDataCallback().V((byte[])localObject2);
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.jbB == null) || (this.jbB.avh() != d.c.uMj))) {
          j.uMV.k((byte[])localObject2);
        }
        AppMethodBeat.o(89260);
        return bool1;
        localObject1 = j.uMV.g(Integer.valueOf(this.jbQ.x * this.jbQ.y * 3 >> 1));
        break;
        SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.jbQ.x, j);
        break label197;
        k = (int)(i * this.gWZ);
        if (k < j)
        {
          if ((!this.jbM) && (this.jcc == null)) {
            this.jcc = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.jcc;; localObject1 = j.uMV.g(Integer.valueOf(this.jbQ.x * this.jbQ.y * 3 >> 1)))
          {
            bs.Gn();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.jbQ.y);
            j = this.jbQ.y;
            this.jbX = true;
            break;
          }
          label1057:
          ac.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label717;
          localObject2 = paramArrayOfByte;
          break label717;
          label1079:
          bool1 = this.jbB.getFrameDataCallback().V(paramArrayOfByte);
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
    if ((paramg != null) && (this.jbC != null) && (this.jbC.cDz()))
    {
      if (paramBoolean) {
        this.jbC.ddv();
      }
      if (paramBoolean)
      {
        ap.n(new Runnable()
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
    if (this.jbB != null)
    {
      ac.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramh });
      this.jbB.a(new d.a()
      {
        public final void aSh()
        {
          AppMethodBeat.i(89221);
          if (paramh != null) {
            paramh.gq(true);
          }
          AppMethodBeat.o(89221);
        }
      });
      this.jbB.E(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89222);
          f.this.jbK = false;
          if (paramh != null) {
            paramh.gq(false);
          }
          AppMethodBeat.o(89222);
        }
      });
      this.jbB = null;
    }
    AppMethodBeat.o(89239);
  }
  
  public final void a(final ByteBuffer paramByteBuffer, final MMSightRecordView.f paramf)
  {
    AppMethodBeat.i(89266);
    if ((paramf == null) && (paramByteBuffer == null))
    {
      if (this.jbZ != null)
      {
        this.jbZ.release();
        this.jbZ = null;
      }
      AppMethodBeat.o(89266);
      return;
    }
    if (this.jbZ == null)
    {
      this.jbZ = new h();
      aSk();
      this.jbZ.jco = new i.a()
      {
        public final void aSl()
        {
          AppMethodBeat.i(89225);
          if (paramf != null) {
            paramf.bgr();
          }
          AppMethodBeat.o(89225);
        }
        
        public final ByteBuffer getBuffer()
        {
          return paramByteBuffer;
        }
      };
      this.jbZ.b(this.jbJ.getEglContext());
    }
    AppMethodBeat.o(89266);
  }
  
  public final void aSa()
  {
    AppMethodBeat.i(89236);
    aSb();
    AppMethodBeat.o(89236);
  }
  
  final void aSb()
  {
    AppMethodBeat.i(89237);
    if (this.jbK)
    {
      ac.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
      AppMethodBeat.o(89237);
      return;
    }
    if (this.jbB != null)
    {
      ac.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
      this.jbB.cancel();
      if (this.jbC != null) {
        this.jbC.b(this.jbB.getFrameDataCallback());
      }
      this.jbB = null;
    }
    if ((this.jbD > 0) && (this.jbG > 0) && (this.videoBitrate > 0) && (this.fps > 0) && (this.audioBitrate > 0) && (this.audioSampleRate > 0) && (this.jbC != null) && (this.jbC.getEncodeVideoBestSize() != null))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.jbD;
      localVideoTransPara.height = ((int)(this.jbD / this.gWZ));
      localVideoTransPara.duration = this.jbG;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.audioBitrate = this.audioBitrate;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.hCz = 2;
      localVideoTransPara.hCA = 1;
      localVideoTransPara.hCy = 1;
      com.tencent.mm.plugin.mmsight.model.k.uLk.hcZ = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.k.uLk.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.k.uLk.gXd = this.jbD;
      com.tencent.mm.plugin.mmsight.model.a.k.ddS();
      this.jbB = com.tencent.mm.plugin.mmsight.model.a.k.q(localVideoTransPara);
      if (this.jbB == null)
      {
        ac.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
        if (this.jbV != null) {
          this.jbV.bgn();
        }
        AppMethodBeat.o(89237);
        return;
      }
      this.jbB.setFilePath(this.videoPath);
      if ((this.jbM) && (this.jbC != null) && (this.jbC.cDz())) {
        aSc();
      }
      int k = this.jbC.getEncodeVideoBestSize().x;
      int m = this.jbC.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.jbQ != null)
      {
        i = m;
        j = k;
        if (this.jbM)
        {
          j = this.jbQ.x;
          i = this.jbQ.y;
        }
      }
      j = (int)(j * this.jbY);
      i = (int)(i * this.jbY);
      j = com.tencent.mm.plugin.mmsight.d.IL(j);
      i = com.tencent.mm.plugin.mmsight.d.IL(i);
      ac.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.jbY) });
      if ((this.jbQ != null) && (this.jbM)) {
        this.jbB.s(this.jbQ.y, this.jbQ.x, j, i);
      }
      for (;;)
      {
        this.jbB.avn();
        this.jbB.a(this);
        if (this.jbB.nE(this.jbC.getOrientation())) {
          break;
        }
        ac.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
        if (this.jbV != null) {
          this.jbV.bgn();
        }
        AppMethodBeat.o(89237);
        return;
        this.jbB.s(this.jbC.getPreviewWidth(), this.jbC.getPreviewHeight(), j, i);
      }
      this.jbK = true;
    }
    AppMethodBeat.o(89237);
  }
  
  final void aSd()
  {
    AppMethodBeat.i(89252);
    if ((this.jbC != null) && (this.jbC.cDz()))
    {
      if (this.jbC.uKP)
      {
        int i = (int)(this.jbC.getPreviewWidth() / this.gWZ);
        this.jbP = new Point(this.jbC.getPreviewWidth(), i);
        AppMethodBeat.o(89252);
        return;
      }
      this.jbP = new Point((int)(this.jbC.getPreviewHeight() * this.gWZ), this.jbC.getPreviewHeight());
    }
    AppMethodBeat.o(89252);
  }
  
  final void aSe()
  {
    AppMethodBeat.i(89254);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.jbO) });
    switch (this.jbO)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89254);
      return;
      this.jbC.ddv();
      AppMethodBeat.o(89254);
      return;
      this.jbC.ddw();
      AppMethodBeat.o(89254);
      return;
      this.jbC.ddx();
    }
  }
  
  public final void aSf()
  {
    AppMethodBeat.i(89256);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.jbY = 0.5F;
    AppMethodBeat.o(89256);
  }
  
  public final void aSg()
  {
    AppMethodBeat.i(89257);
    ac.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.jbY = 0.75F;
    AppMethodBeat.o(89257);
  }
  
  public final void aSh()
  {
    AppMethodBeat.i(89261);
    ac.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.jbB.reset();
    AppMethodBeat.o(89261);
  }
  
  public final void aSi()
  {
    AppMethodBeat.i(89263);
    if ((this.jbC != null) && (this.jbC.cDz()) && (this.jbR)) {
      this.jbC.c(true, false, 1);
    }
    AppMethodBeat.o(89263);
  }
  
  public final void aSj()
  {
    AppMethodBeat.i(89264);
    if ((this.jbC != null) && (this.jbC.cDz()) && (this.jbR)) {
      this.jbC.c(false, false, 1);
    }
    AppMethodBeat.o(89264);
  }
  
  final void aSk()
  {
    AppMethodBeat.i(89267);
    Point localPoint = getPreviewSize();
    this.jca.y = this.jbE;
    this.jca.x = (localPoint.x * this.jbE / localPoint.y);
    if ((getScreenRotation() == 0) || (getScreenRotation() == 180))
    {
      int i = this.jca.y;
      this.jca.y = this.jca.x;
      this.jca.x = i;
    }
    if (this.jbZ != null) {
      this.jbZ.h(localPoint.x, localPoint.y, this.jbC.getOrientation(), this.jca.x, this.jca.y);
    }
    AppMethodBeat.o(89267);
  }
  
  public final boolean aq(float paramFloat)
  {
    AppMethodBeat.i(89255);
    List localList = this.jbC.ddt();
    if ((this.jcb != null) && (this.jcb.mSize != 0)) {
      if (this.jcb.indexOfKey(Math.round(paramFloat * 10.0F)) < 0) {
        break label63;
      }
    }
    label63:
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    i = localList.indexOf(Integer.valueOf(this.jcb.afv(Math.round(paramFloat * 10.0F))));
    if (i < 0)
    {
      AppMethodBeat.o(89255);
      return false;
    }
    this.jbC.IO(i);
    AppMethodBeat.o(89255);
    return true;
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(89227);
    this.context = paramContext;
    this.jbI = new ObservableTextureView(paramContext);
    this.jbJ = new MMSightCameraGLSurfaceView(paramContext);
    this.jbJ.setBackgroundColor(Color.argb(0, 0, 0, 0));
    int i = com.tencent.mm.cc.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.jbI, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.jbJ, (ViewGroup.LayoutParams)localObject);
    this.jbU = new g();
    this.jbU.jcm = this;
    this.jbJ.setOnTouchListener(this.jbU);
    com.tencent.mm.plugin.mmsight.model.k.ddz();
    ac.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
    AppMethodBeat.o(89227);
  }
  
  final void b(final MMSightRecordView.g paramg, final boolean paramBoolean)
  {
    AppMethodBeat.i(89241);
    this.jbC.a(new f.b()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(89224);
        if (paramBoolean) {
          f.this.jbC.ddw();
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt2 < 0) || (paramAnonymousInt3 < 0))
        {
          ac.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
          paramg.bgq();
          AppMethodBeat.o(89224);
          return;
        }
        for (;;)
        {
          try
          {
            if (!f.this.jbN) {
              break label473;
            }
            f.this.aSd();
            if (f.this.jbC.uKP)
            {
              if (f.this.jbP.y >= paramAnonymousInt1) {
                break label473;
              }
              localObject = new byte[f.this.jbP.x * f.this.jbP.y * 3 >> 1];
              if (f.this.jbF == 1)
              {
                SightVideoJNI.cropCameraDataLongEdgeCenterCrop(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.jbP.y, paramAnonymousInt2);
                paramAnonymousInt1 = f.this.jbP.y;
                paramAnonymousInt2 = f.this.jbP.x;
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
                ac.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject.toString() });
                ((Bitmap)localObject).recycle();
                paramg.N(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89224);
                return;
              }
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, f.this.jbP.y, paramAnonymousInt2);
              continue;
            }
            if (f.this.jbP.x >= paramAnonymousInt2) {
              break label473;
            }
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            ac.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", paramAnonymousArrayOfByte, "saveCaptureYuvDataToBitmap error: %s", new Object[] { paramAnonymousArrayOfByte.getMessage() });
            paramg.bgq();
            AppMethodBeat.o(89224);
            return;
          }
          Object localObject = new byte[f.this.jbP.x * f.this.jbP.y * 3 >> 1];
          SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, (byte[])localObject, paramAnonymousInt1, paramAnonymousInt2, f.this.jbP.x);
          paramAnonymousInt1 = f.this.jbP.y;
          paramAnonymousInt2 = f.this.jbP.x;
          paramAnonymousArrayOfByte = (byte[])localObject;
          continue;
          label473:
          label476:
          label490:
          do
          {
            paramAnonymousArrayOfByte = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, paramAnonymousInt1);
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
    if (this.jbC != null)
    {
      int i = this.jbC.getOrientation();
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
    if ((this.jbC != null) && (this.jbC.cDz()))
    {
      localObject2 = this.jbC;
      if (((com.tencent.mm.plugin.mmsight.model.f)localObject2).gXT != null)
      {
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).gXS = true;
        localObject1 = new byte[((com.tencent.mm.plugin.mmsight.model.f)localObject2).gXT.length];
        System.arraycopy(((com.tencent.mm.plugin.mmsight.model.f)localObject2).gXT, 0, localObject1, 0, ((com.tencent.mm.plugin.mmsight.model.f)localObject2).gXT.length);
        ((com.tencent.mm.plugin.mmsight.model.f)localObject2).gXS = false;
        if (localObject1 == null) {
          break label495;
        }
        j = this.jbC.getPreviewWidth();
        i = this.jbC.getPreviewHeight();
        if (!this.jbC.uKP) {
          break label379;
        }
        k = (int)(this.jbC.getPreviewWidth() / this.gWZ);
        if (k >= i) {
          break label506;
        }
        if ((this.jbM) || (this.jcc != null)) {
          break label327;
        }
        this.jcc = new byte[j * k * 3 >> 1];
        localObject2 = this.jcc;
        label161:
        if (this.jbF != 1) {
          break label360;
        }
        SightVideoJNI.cropCameraDataLongEdgeCenterCrop((byte[])localObject1, (byte[])localObject2, i, this.jbQ.x, j);
        label185:
        i = k;
        if (this.jbM) {
          i = this.jbQ.x;
        }
        this.jbX = true;
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
        localObject2 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject1, this.jbC.getOrientation());
        ac.i("MicroMsg.MMSightRecordViewImpl", "bitmap recycle %s", new Object[] { localObject1 });
        ((Bitmap)localObject1).recycle();
        AppMethodBeat.o(89258);
        return localObject2;
        localObject1 = null;
        break;
        label327:
        localObject2 = j.uMV.g(Integer.valueOf(this.jbQ.x * this.jbQ.y * 3 >> 1));
        break label161;
        label360:
        SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.jbQ.x, j);
        break label185;
        label379:
        k = (int)(i * this.gWZ);
        if (k < j)
        {
          if ((!this.jbM) && (this.jcc == null)) {
            this.jcc = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.jcc;; localObject2 = j.uMV.g(Integer.valueOf(this.jbQ.x * this.jbQ.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.jbQ.y);
            j = this.jbQ.y;
            this.jbX = true;
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
    ac.i("MicroMsg.MMSightRecordViewImpl", "getDrawSizePoint : %s", new Object[] { this.jca.toString() });
    Point localPoint = this.jca;
    AppMethodBeat.o(89246);
    return localPoint;
  }
  
  public final int getFlashMode()
  {
    return this.jbO;
  }
  
  public final Point getPictureSize()
  {
    AppMethodBeat.i(89243);
    if ((this.jbC != null) && (this.jbC.cDz()))
    {
      if (!this.jbN)
      {
        localPoint = new Point(this.jbC.getPreviewWidth(), this.jbC.getPreviewHeight());
        AppMethodBeat.o(89243);
        return localPoint;
      }
      aSd();
      Point localPoint = this.jbP;
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
    if ((this.jbC.getOrientation() == 0) || (this.jbC.getOrientation() == 180))
    {
      j = 1;
      if (j == 0) {
        break label78;
      }
      i = this.jbC.getPreviewWidth();
      label43:
      if (j == 0) {
        break label89;
      }
    }
    label78:
    label89:
    for (int j = this.jbC.getPreviewHeight();; j = this.jbC.getPreviewWidth())
    {
      Point localPoint = new Point(i, j);
      AppMethodBeat.o(89245);
      return localPoint;
      j = 0;
      break;
      i = this.jbC.getPreviewHeight();
      break label43;
    }
  }
  
  public final float[] getSupportZoomMultiple()
  {
    int i = 0;
    if ((this.jcb == null) || (this.jcb.mSize == 0)) {
      return new float[0];
    }
    float[] arrayOfFloat = new float[this.jcb.mSize];
    while (i < this.jcb.mSize)
    {
      arrayOfFloat[i] = (this.jcb.Nf[i] * 1.0F / 10.0F);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public final String getVideoFilePath()
  {
    AppMethodBeat.i(89235);
    if ((this.jbB != null) && (this.jbK))
    {
      str = this.jbB.getFilePath();
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
    if ((this.jbC != null) && (this.jbC.cDz()))
    {
      int k = this.jbC.getEncodeVideoBestSize().x;
      int m = this.jbC.getEncodeVideoBestSize().y;
      int i = m;
      int j = k;
      if (this.jbQ != null)
      {
        i = m;
        j = k;
        if (this.jbM)
        {
          j = this.jbQ.x;
          i = this.jbQ.y;
        }
      }
      j = (int)(j * this.jbY);
      i = (int)(i * this.jbY);
      Point localPoint = new Point(com.tencent.mm.plugin.mmsight.d.IL(j), com.tencent.mm.plugin.mmsight.d.IL(i));
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
    ac.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.jbC, this.jbB });
    if (this.jbC != null)
    {
      this.jbC.b(this);
      this.jbC.ddu();
    }
    if (this.jbB != null)
    {
      this.jbB.a(null);
      this.jbB.E(null);
      this.jbB = null;
    }
    if (this.jbZ != null) {
      this.jbZ.release();
    }
    if (this.jcb != null) {
      this.jcb.mSize = 0;
    }
    this.jcb = null;
    this.jbK = false;
    this.jbM = false;
    this.jbN = false;
    this.jbP = null;
    this.jbQ = null;
    this.jbO = -1;
    this.jbR = true;
    this.jbS = true;
    this.jbT = false;
    j.uMV.avJ();
    AppMethodBeat.o(89259);
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89251);
    this.jbN = paramBoolean;
    if ((this.jbN) && (this.jbC != null) && (this.jbC.cDz())) {
      aSd();
    }
    AppMethodBeat.o(89251);
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    AppMethodBeat.i(89249);
    this.jbM = paramBoolean;
    if ((this.jbM) && (this.jbC != null) && (this.jbC.cDz())) {
      aSc();
    }
    AppMethodBeat.o(89249);
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    AppMethodBeat.i(89228);
    int i = getScreenRotation();
    ac.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.gWZ = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.gWZ = (1.0F / this.gWZ);
    }
    AppMethodBeat.o(89228);
  }
  
  public final void setDisplayScreenSize(Size paramSize) {}
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.jbR = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.jbS = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(89253);
    this.jbO = paramInt;
    com.tencent.mm.plugin.mmsight.model.f localf = this.jbC;
    if ((this.jbC != null) && (this.jbC.cDz())) {}
    for (;;)
    {
      ac.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), localf, Boolean.valueOf(bool) });
      if ((this.jbC != null) && (this.jbC.cDz())) {
        aSe();
      }
      AppMethodBeat.o(89253);
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.jbL = parama;
  }
  
  public final void setInitDoneCallback(MMSightRecordView.c paramc)
  {
    this.jbW = paramc;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.d paramd)
  {
    this.jbV = paramd;
  }
  
  public final void setPreviewMode(int paramInt)
  {
    AppMethodBeat.i(89231);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setPreviewMode: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jbF = paramInt;
    AppMethodBeat.o(89231);
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89229);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jbD = paramInt;
    AppMethodBeat.o(89229);
  }
  
  public final void setRGBSizeLimit(int paramInt)
  {
    AppMethodBeat.i(89230);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setRGBSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.jbE = paramInt;
    AppMethodBeat.o(89230);
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(89242);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jbH = paramBoolean;
    AppMethodBeat.o(89242);
  }
  
  public final void setVideoFilePath(String paramString)
  {
    AppMethodBeat.i(89234);
    ac.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
    AppMethodBeat.o(89234);
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    AppMethodBeat.i(89233);
    this.jbG = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.audioBitrate = 64000;
    this.audioSampleRate = 44100;
    ac.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
    AppMethodBeat.o(89233);
  }
  
  public final void startPreview()
  {
    AppMethodBeat.i(89232);
    ac.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.gWZ), Integer.valueOf(this.jbD) });
    this.jbT = false;
    if ((this.gWZ > 0.0F) && (this.jbD > 0))
    {
      Object localObject = new VideoTransPara();
      ((VideoTransPara)localObject).width = this.jbD;
      ((VideoTransPara)localObject).height = ((int)(this.jbD / this.gWZ));
      ac.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
      this.jbC = new com.tencent.mm.plugin.mmsight.model.f((VideoTransPara)localObject, -1);
      this.jbC.a(this);
      if (!this.jbC.y(this.context, this.jbH))
      {
        ac.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
        if (this.jbV != null) {
          this.jbV.bgn();
        }
        AppMethodBeat.o(89232);
        return;
      }
      ac.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
      localObject = this.jbC.ddt();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (this.jbI.isAvailable())
        {
          if (this.jbC.a(this.jbI.getSurfaceTexture(), this.jbD, this.gWZ, this.jbM) < 0)
          {
            ac.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (this.jbV != null) {
              this.jbV.bgn();
            }
          }
          if (this.jbO != -1) {
            aSe();
          }
          this.jbC.ddq();
          ac.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
          aSb();
          aSk();
          if (this.jbZ != null) {
            this.jbZ.b(this.jbJ.getEglContext());
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
        this.jcb = new com.tencent.tinker.a.c.b(j);
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
            this.jcb.append(k, k * i - m);
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
            this.jcb.append(k, m + k * i);
          }
          else
          {
            m += 1;
            break label467;
            label558:
            this.jcb.append(k, k * i);
          }
        }
      }
      this.jbI.setTextureChangeCallback(new com.tencent.mm.plugin.video.b()
      {
        public final void f(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(89220);
          if (f.this.jbC.a(paramAnonymousSurfaceTexture, f.this.jbD, f.this.gWZ, f.this.jbM) < 0)
          {
            ac.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
            if (f.this.jbV != null) {
              f.this.jbV.bgn();
            }
          }
          if (f.this.jbO != -1) {
            f.this.aSe();
          }
          f.this.jbC.ddq();
          f.this.aSb();
          f.this.aSk();
          if (f.this.jbZ != null) {
            f.this.jbZ.b(f.this.jbJ.getEglContext());
          }
          ac.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
          AppMethodBeat.o(89220);
        }
      });
    }
    AppMethodBeat.o(89232);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(89248);
    if ((this.jbC != null) && (this.jbC.cDz()) && ((this.jbB == null) || (this.jbB.avh() != d.c.uMj)))
    {
      this.jbC.a(this.context, this.jbI.getSurfaceTexture(), this.jbD, this.gWZ, this.jbM);
      if (this.jbZ != null) {
        aSk();
      }
    }
    AppMethodBeat.o(89248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */