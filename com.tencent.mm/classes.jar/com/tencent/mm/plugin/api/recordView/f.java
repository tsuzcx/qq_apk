package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.e.3;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public final class f
  extends MMSightRecordView.d
  implements g.a, d.a, com.tencent.mm.plugin.mmsight.model.f
{
  private int audioSampleRate;
  private Context context;
  private int ejM;
  private int fps;
  private com.tencent.mm.plugin.mmsight.model.a.d fwN;
  e fwO;
  int fwP;
  float fwQ;
  private int fwR;
  private boolean fwS = true;
  private ObservableTextureView fwT;
  private MMSightCameraGLSurfaceView fwU;
  boolean fwV = false;
  private MMSightRecordView.a fwW;
  boolean fwX = false;
  boolean fwY = false;
  int fwZ = -1;
  Point fxa;
  private Point fxb;
  private boolean fxc = true;
  private boolean fxd = true;
  private g fxe;
  MMSightRecordView.c fxf;
  private boolean fxg = false;
  private float fxh = 1.0F;
  private WindowManager fxi = null;
  private byte[] fxj = null;
  private int videoBitrate;
  private String videoPath;
  
  private void Za()
  {
    if ((this.fwO != null) && (this.fwO.mgy)) {
      if (!this.fwO.mgZ) {
        break label88;
      }
    }
    label88:
    int i;
    for (this.fxb = new Point(com.tencent.mm.plugin.mmsight.d.df((int)(this.fwO.getPreviewWidth() / this.fwQ), this.fwO.getPreviewHeight()), this.fwO.getPreviewWidth());; this.fxb = new Point(this.fwO.getPreviewHeight(), i))
    {
      y.i("MicroMsg.MMSightRecordViewImpl", "initVideoSize: %s", new Object[] { this.fxb });
      return;
      i = com.tencent.mm.plugin.mmsight.d.df((int)(this.fwO.getPreviewHeight() * this.fwQ), this.fwO.getPreviewWidth());
    }
  }
  
  private int Zj()
  {
    if (this.fxi == null) {
      this.fxi = ((WindowManager)ae.getContext().getSystemService("window"));
    }
    if (this.fxi == null) {
      return 0;
    }
    switch (this.fxi.getDefaultDisplay().getRotation())
    {
    default: 
      return 0;
    case 0: 
      return 0;
    case 1: 
      return 90;
    case 2: 
      return 180;
    }
    return 270;
  }
  
  public final boolean M(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    int j;
    int k;
    Object localObject1;
    label153:
    Object localObject2;
    a locala;
    int m;
    int n;
    if ((this.fwQ > 0.0F) && (this.fwP > 0) && (this.fwO != null))
    {
      j = this.fwO.getPreviewWidth();
      i = this.fwO.getPreviewHeight();
      if (this.fwO.mgZ)
      {
        k = (int)(this.fwO.getPreviewWidth() / this.fwQ);
        if (k >= i) {
          break label1086;
        }
        if ((!this.fwX) && (this.fxj == null))
        {
          this.fxj = new byte[j * k * 3 >> 1];
          localObject1 = this.fxj;
          bk.UZ();
          SightVideoJNI.cropCameraDataLongEdge(paramArrayOfByte, (byte[])localObject1, i, this.fxb.x, j);
          i = k;
          if (this.fwX) {
            i = this.fxb.x;
          }
          this.fxg = true;
          localObject2 = localObject1;
          if (this.fwU != null)
          {
            localObject2 = this.fwU;
            k = this.fwO.getOrientation();
            if ((i != ((MMSightCameraGLSurfaceView)localObject2).fvY) || (j != ((MMSightCameraGLSurfaceView)localObject2).fvZ) || (k != ((MMSightCameraGLSurfaceView)localObject2).fwu))
            {
              y.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), localObject2 });
              ((MMSightCameraGLSurfaceView)localObject2).fvY = i;
              ((MMSightCameraGLSurfaceView)localObject2).fvZ = j;
              ((MMSightCameraGLSurfaceView)localObject2).fwu = k;
            }
            j = Zj();
            localObject2 = this.fwU;
            if ((localObject1 == null) || (((MMSightCameraGLSurfaceView)localObject2).fws == null) || (((MMSightCameraGLSurfaceView)localObject2).fws.brU)) {
              break label1015;
            }
            locala = ((MMSightCameraGLSurfaceView)localObject2).fws;
            k = ((MMSightCameraGLSurfaceView)localObject2).fvY;
            m = ((MMSightCameraGLSurfaceView)localObject2).fvZ;
            n = ((MMSightCameraGLSurfaceView)localObject2).fwu;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      label647:
      label691:
      label722:
      boolean bool1;
      try
      {
        if ((locala.fvZ != m) || (locala.fvY != k) || (locala.rotate != n) || (locala.fwr != j)) {
          continue;
        }
        if (i != 0) {
          y.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { localObject1, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Boolean.valueOf(locala.fwq), Boolean.valueOf(true), locala });
        }
        locala.fvX = ((byte[])localObject1);
        locala.fvY = k;
        locala.fvZ = m;
        locala.rotate = n;
        locala.fwr = j;
        if (i != 0)
        {
          locala.fwa = ByteBuffer.allocateDirect(m * k);
          locala.fwb = ByteBuffer.allocateDirect(k * m / 2);
          locala.fwa.order(ByteOrder.nativeOrder());
          locala.fwb.order(ByteOrder.nativeOrder());
          if (locala.fwo != null)
          {
            locala.fwk.put(locala.fwo);
            locala.fwk.position(0);
          }
        }
        if ((locala.fwa != null) && (locala.fwb != null))
        {
          locala.fwa.put((byte[])localObject1, 0, k * m);
          locala.fwa.position(0);
          locala.fwb.put((byte[])localObject1, k * m, k * m / 2);
          locala.fwb.position(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool2;
          y.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { localException.getMessage() });
        }
      }
      ((MMSightCameraGLSurfaceView)localObject2).requestRender();
      localObject2 = localObject1;
      if (this.fwW != null)
      {
        localObject1 = this.fwW;
        if ((this.fwO.getOrientation() == 0) || (this.fwO.getOrientation() == 180))
        {
          i = this.fwO.getPreviewWidth();
          if ((this.fwO.getOrientation() != 0) && (this.fwO.getOrientation() != 180)) {
            break label1047;
          }
          j = this.fwO.getPreviewHeight();
          ((MMSightRecordView.a)localObject1).n(paramArrayOfByte, i, j);
        }
      }
      else
      {
        bool2 = true;
        j = 0;
        bool1 = bool2;
        i = j;
        if (this.fwN != null)
        {
          bool1 = bool2;
          i = j;
          if (this.fwN.bjp() != null)
          {
            if ((!this.fwX) || (!this.fxg)) {
              break label1058;
            }
            bool1 = this.fwN.bjp().M((byte[])localObject2);
            i = 1;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) && ((this.fwN == null) || (this.fwN.bjq() != d.c.miA))) {
          com.tencent.mm.plugin.mmsight.model.a.j.mji.z((byte[])localObject2);
        }
        return bool1;
        localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(this.fxb.x * this.fxb.y * 3 >> 1));
        break;
        k = (int)(i * this.fwQ);
        if (k < j)
        {
          if ((!this.fwX) && (this.fxj == null)) {
            this.fxj = new byte[k * i * 3 >> 1];
          }
          for (localObject1 = this.fxj;; localObject1 = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(this.fxb.x * this.fxb.y * 3 >> 1)))
          {
            bk.UZ();
            SightVideoJNI.cropCameraData(paramArrayOfByte, (byte[])localObject1, i, j, this.fxb.y);
            j = this.fxb.y;
            this.fxg = true;
            break;
          }
          label1015:
          y.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
          localObject2 = localObject1;
          break label647;
          localObject2 = paramArrayOfByte;
          break label647;
          i = this.fwO.getPreviewHeight();
          break label691;
          label1047:
          j = this.fwO.getPreviewWidth();
          break label722;
          label1058:
          bool1 = this.fwN.bjp().M(paramArrayOfByte);
          i = j;
          continue;
        }
        localObject1 = paramArrayOfByte;
        break label153;
        label1086:
        localObject1 = paramArrayOfByte;
        break label153;
      }
    }
  }
  
  public final void YY()
  {
    YZ();
  }
  
  final void YZ()
  {
    if (this.fwV) {
      y.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
    }
    do
    {
      do
      {
        return;
        if (this.fwN != null)
        {
          y.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
          this.fwN.cancel();
          if (this.fwO != null) {
            this.fwO.b(this.fwN.bjp());
          }
          this.fwN = null;
        }
      } while ((this.fwP <= 0) || (this.fwR <= 0) || (this.videoBitrate <= 0) || (this.fps <= 0) || (this.ejM <= 0) || (this.audioSampleRate <= 0) || (this.fwO == null) || (this.fwO.mgG == null));
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.fwP;
      localVideoTransPara.height = ((int)(this.fwP / this.fwQ));
      localVideoTransPara.duration = this.fwR;
      localVideoTransPara.videoBitrate = this.videoBitrate;
      localVideoTransPara.fps = this.fps;
      localVideoTransPara.ejM = this.ejM;
      localVideoTransPara.audioSampleRate = this.audioSampleRate;
      localVideoTransPara.ejO = 2;
      localVideoTransPara.ejP = 1;
      localVideoTransPara.ejN = 1;
      com.tencent.mm.plugin.mmsight.model.j.mhB.mfr = localVideoTransPara;
      com.tencent.mm.plugin.mmsight.model.j.mhB.videoBitrate = this.videoBitrate;
      com.tencent.mm.plugin.mmsight.model.j.mhB.mgf = this.fwP;
      k.bjA();
      this.fwN = k.d(localVideoTransPara);
      if (this.fwN != null) {
        break;
      }
      y.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
    } while (this.fxf == null);
    this.fxf.aiO();
    return;
    this.fwN.setFilePath(this.videoPath);
    if ((this.fwX) && (this.fwO != null) && (this.fwO.mgy)) {
      Za();
    }
    int k = this.fwO.mgG.x;
    int m = this.fwO.mgG.y;
    int i = m;
    int j = k;
    if (this.fxb != null)
    {
      i = m;
      j = k;
      if (this.fwX)
      {
        j = this.fxb.x;
        i = this.fxb.y;
      }
    }
    j = (int)(j * this.fxh);
    i = (int)(i * this.fxh);
    j = com.tencent.mm.plugin.mmsight.d.tV(j);
    i = com.tencent.mm.plugin.mmsight.d.tV(i);
    y.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(this.fxh) });
    if ((this.fxb != null) && (this.fwX)) {
      this.fwN.u(this.fxb.y, this.fxb.x, j, i);
    }
    for (;;)
    {
      this.fwN.bjw();
      this.fwN.a(this);
      if (this.fwN.ua(this.fwO.getOrientation())) {
        break label595;
      }
      y.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
      if (this.fxf == null) {
        break;
      }
      this.fxf.aiO();
      return;
      this.fwN.u(this.fwO.getPreviewWidth(), this.fwO.getPreviewHeight(), j, i);
    }
    label595:
    this.fwV = true;
  }
  
  final void Zb()
  {
    if ((this.fwO != null) && (this.fwO.mgy))
    {
      if (this.fwO.mgZ)
      {
        int i = (int)(this.fwO.getPreviewWidth() / this.fwQ);
        this.fxa = new Point(this.fwO.getPreviewWidth(), i);
      }
    }
    else {
      return;
    }
    this.fxa = new Point((int)(this.fwO.getPreviewHeight() * this.fwQ), this.fwO.getPreviewHeight());
  }
  
  final void Zc()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[] { Integer.valueOf(this.fwZ) });
    switch (this.fwZ)
    {
    default: 
      return;
    case 1: 
      this.fwO.biO();
      return;
    case 2: 
      this.fwO.biP();
      return;
    }
    this.fwO.biQ();
  }
  
  public final void Zd()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
    this.fxh = 0.5F;
  }
  
  public final void Ze()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
    this.fxh = 0.75F;
  }
  
  public final void Zf()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[] { Integer.valueOf(1) });
    this.fwN.reset();
  }
  
  public final void Zg()
  {
    if ((this.fwO != null) && (this.fwO.mgy) && (this.fxd))
    {
      e locale = this.fwO;
      if ((locale.dwJ != null) && (locale.mgy))
      {
        Camera.Parameters localParameters = locale.dwJ.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          y.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          locale.dwJ.setParameters(localParameters);
        }
        locale.dwJ.cancelAutoFocus();
        locale.dwJ.autoFocus(new e.3(locale));
      }
    }
  }
  
  public final void Zh()
  {
    if ((this.fwO != null) && (this.fwO.mgy) && (this.fxc)) {
      this.fwO.c(true, false, 1);
    }
  }
  
  public final void Zi()
  {
    if ((this.fwO != null) && (this.fwO.mgy) && (this.fxc)) {
      this.fwO.c(false, false, 1);
    }
  }
  
  public final void a(MMSightRecordView.e parame, boolean paramBoolean)
  {
    if ((parame != null) && (this.fwO != null) && (this.fwO.mgy))
    {
      if (paramBoolean) {
        this.fwO.biO();
      }
      if (paramBoolean) {
        ai.l(new f.4(this, parame, paramBoolean), 100L);
      }
    }
    else
    {
      return;
    }
    b(parame, paramBoolean);
  }
  
  public final void a(MMSightRecordView.f paramf)
  {
    if (this.fwN != null)
    {
      y.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[] { paramf });
      this.fwN.a(new f.2(this, paramf));
      this.fwN.M(new f.3(this, paramf));
      this.fwN = null;
    }
  }
  
  public final void b(Context paramContext, ViewGroup paramViewGroup)
  {
    this.context = paramContext;
    this.fwT = new ObservableTextureView(paramContext);
    this.fwU = new MMSightCameraGLSurfaceView(paramContext);
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 1);
    Object localObject = new FrameLayout.LayoutParams(i, i);
    paramViewGroup.addView(this.fwT, (ViewGroup.LayoutParams)localObject);
    localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    paramViewGroup.addView(this.fwU, (ViewGroup.LayoutParams)localObject);
    this.fxe = new g();
    this.fxe.fxr = this;
    this.fwU.setOnTouchListener(this.fxe);
    com.tencent.mm.plugin.mmsight.model.j.biT();
    y.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[] { paramContext });
  }
  
  final void b(MMSightRecordView.e parame, boolean paramBoolean)
  {
    this.fwO.a(new f.5(this, paramBoolean, parame), false, Zj());
  }
  
  public final int getCameraRotation()
  {
    if (this.fwO != null) {
      return this.fwO.getOrientation();
    }
    return 0;
  }
  
  public final Bitmap getCurrentFramePicture()
  {
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1;
    int j;
    int i;
    int k;
    if (this.fwO != null)
    {
      localObject2 = localObject3;
      if (this.fwO.mgy)
      {
        localObject2 = this.fwO;
        if (((e)localObject2).mgX == null) {
          break label299;
        }
        ((e)localObject2).mgY = true;
        localObject1 = new byte[((e)localObject2).mgX.length];
        System.arraycopy(((e)localObject2).mgX, 0, localObject1, 0, ((e)localObject2).mgX.length);
        ((e)localObject2).mgY = false;
        localObject2 = localObject3;
        if (localObject1 != null)
        {
          j = this.fwO.getPreviewWidth();
          i = this.fwO.getPreviewHeight();
          if (!this.fwO.mgZ) {
            break label338;
          }
          k = (int)(this.fwO.getPreviewWidth() / this.fwQ);
          if (k >= i) {
            break label457;
          }
          if ((this.fwX) || (this.fxj != null)) {
            break label305;
          }
          this.fxj = new byte[j * k * 3 >> 1];
          localObject2 = this.fxj;
          label170:
          SightVideoJNI.cropCameraDataLongEdge((byte[])localObject1, (byte[])localObject2, i, this.fxb.x, j);
          i = k;
          if (this.fwX) {
            i = this.fxb.x;
          }
          this.fxg = true;
        }
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
        localObject2 = c.b((Bitmap)localObject1, this.fwO.getOrientation());
        ((Bitmap)localObject1).recycle();
        return localObject2;
        label299:
        localObject1 = null;
        break;
        label305:
        localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(this.fxb.x * this.fxb.y * 3 >> 1));
        break label170;
        label338:
        k = (int)(i * this.fwQ);
        if (k < j)
        {
          if ((!this.fwX) && (this.fxj == null)) {
            this.fxj = new byte[k * i * 3 >> 1];
          }
          for (localObject2 = this.fxj;; localObject2 = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(this.fxb.x * this.fxb.y * 3 >> 1)))
          {
            SightVideoJNI.cropCameraData((byte[])localObject1, (byte[])localObject2, i, j, this.fxb.y);
            j = this.fxb.y;
            this.fxg = true;
            localObject1 = localObject2;
            break;
          }
        }
      }
      label457:
      localObject2 = localObject1;
    }
  }
  
  public final int getFlashMode()
  {
    return this.fwZ;
  }
  
  public final Point getPictureSize()
  {
    if ((this.fwO != null) && (this.fwO.mgy))
    {
      if (!this.fwY) {
        return new Point(this.fwO.getPreviewWidth(), this.fwO.getPreviewHeight());
      }
      Zb();
      return this.fxa;
    }
    return null;
  }
  
  public final String getVideoFilePath()
  {
    if ((this.fwN != null) && (this.fwV)) {
      return this.fwN.bjl();
    }
    return this.videoPath;
  }
  
  public final Point getVideoSize()
  {
    if ((this.fwO != null) && (this.fwO.mgy))
    {
      int k = this.fwO.mgG.x;
      int m = this.fwO.mgG.y;
      int i = m;
      int j = k;
      if (this.fxb != null)
      {
        i = m;
        j = k;
        if (this.fwX)
        {
          j = this.fxb.x;
          i = this.fxb.y;
        }
      }
      j = (int)(j * this.fxh);
      i = (int)(i * this.fxh);
      return new Point(com.tencent.mm.plugin.mmsight.d.tV(j), com.tencent.mm.plugin.mmsight.d.tV(i));
    }
    return null;
  }
  
  public final void release()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[] { this.fwO, this.fwN });
    if (this.fwO != null) {
      this.fwO.biN();
    }
    if (this.fwN != null)
    {
      this.fwN.M(null);
      this.fwN = null;
    }
    this.fwV = false;
    this.fwX = false;
    this.fwY = false;
    this.fxa = null;
    this.fxb = null;
    this.fwZ = -1;
    this.fxc = true;
    this.fxd = true;
    com.tencent.mm.plugin.mmsight.model.a.j.mji.ET();
  }
  
  public final void setClipPictureSize(boolean paramBoolean)
  {
    this.fwY = paramBoolean;
    if ((this.fwY) && (this.fwO != null) && (this.fwO.mgy)) {
      Zb();
    }
  }
  
  public final void setClipVideoSize(boolean paramBoolean)
  {
    this.fwX = paramBoolean;
    if ((this.fwX) && (this.fwO != null) && (this.fwO.mgy)) {
      Za();
    }
  }
  
  public final void setDisplayRatio(float paramFloat)
  {
    int i = Zj();
    y.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s, screenRotation: %s", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(i) });
    this.fwQ = paramFloat;
    if ((i == 90) || (i == 270)) {
      this.fwQ = (1.0F / this.fwQ);
    }
  }
  
  public final void setEnableDragZoom(boolean paramBoolean)
  {
    this.fxc = paramBoolean;
  }
  
  public final void setEnableTouchFocus(boolean paramBoolean)
  {
    this.fxd = paramBoolean;
  }
  
  public final void setFlashMode(int paramInt)
  {
    boolean bool = true;
    this.fwZ = paramInt;
    e locale = this.fwO;
    if ((this.fwO != null) && (this.fwO.mgy)) {}
    for (;;)
    {
      y.i("MicroMsg.MMSightRecordViewImpl", "setFlashMode: %s, camera: %s, previewing: %s", new Object[] { Integer.valueOf(paramInt), locale, Boolean.valueOf(bool) });
      if ((this.fwO != null) && (this.fwO.mgy)) {
        Zc();
      }
      return;
      bool = false;
    }
  }
  
  public final void setFrameDataCallback(MMSightRecordView.a parama)
  {
    this.fwW = parama;
  }
  
  public final void setInitErrorCallback(MMSightRecordView.c paramc)
  {
    this.fxf = paramc;
  }
  
  public final void setPreviewSizeLimit(int paramInt)
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[] { Integer.valueOf(paramInt) });
    this.fwP = paramInt;
  }
  
  public final void setUseBackCamera(boolean paramBoolean)
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fwS = paramBoolean;
  }
  
  public final void setVideoFilePath(String paramString)
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[] { paramString });
    this.videoPath = paramString;
  }
  
  public final void setVideoPara$2e715812(int paramInt)
  {
    this.fwR = paramInt;
    this.videoBitrate = 4800000;
    this.fps = 30;
    this.ejM = 64000;
    this.audioSampleRate = 44100;
    y.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100) });
  }
  
  public final void startPreview()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[] { Float.valueOf(this.fwQ), Integer.valueOf(this.fwP) });
    if ((this.fwQ > 0.0F) && (this.fwP > 0))
    {
      VideoTransPara localVideoTransPara = new VideoTransPara();
      localVideoTransPara.width = this.fwP;
      localVideoTransPara.height = ((int)(this.fwP / this.fwQ));
      y.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[] { Integer.valueOf(localVideoTransPara.width), Integer.valueOf(localVideoTransPara.height) });
      this.fwO = new e(localVideoTransPara, -1);
      this.fwO.a(this);
      if (this.fwO.r(this.context, this.fwS)) {
        break label175;
      }
      y.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
      if (this.fxf != null) {
        this.fxf.aiO();
      }
    }
    return;
    label175:
    y.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
    if (this.fwT.isAvailable())
    {
      if (this.fwO.a(this.fwT.getSurfaceTexture(), this.fwP, this.fwQ, this.fwX) < 0)
      {
        y.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
        if (this.fxf != null) {
          this.fxf.aiO();
        }
      }
      if (this.fwZ != -1) {
        Zc();
      }
      this.fwO.biJ();
      y.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
      YZ();
      return;
    }
    this.fwT.setTextureChangeCallback(new f.1(this));
  }
  
  public final void switchCamera()
  {
    if ((this.fwO != null) && (this.fwO.mgy) && ((this.fwN == null) || (this.fwN.bjq() != d.c.miA))) {
      this.fwO.a(this.context, this.fwT.getSurfaceTexture(), this.fwP, this.fwQ, this.fwX);
    }
  }
  
  public final boolean uq()
  {
    y.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[] { this.fwN });
    YZ();
    if (this.fwN == null)
    {
      y.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
      return false;
    }
    int i = Zj();
    y.i("MicroMsg.MMSightRecordViewImpl", "screen rotate: %s", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (i = this.fwN.d(this.fwO.getOrientation(), true, 360 - i);; i = this.fwN.d(this.fwO.getOrientation(), false, i))
    {
      y.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[] { Integer.valueOf(i) });
      if (i < 0) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.f
 * JD-Core Version:    0.7.0.1
 */