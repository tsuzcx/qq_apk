package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
  implements TextureView.SurfaceTextureListener
{
  String djD;
  private boolean isFrontCamera;
  private Point jOD = null;
  private Point jOE = null;
  private Point jOF = null;
  private boolean jOG;
  private int jOH;
  private Point jOK = null;
  byte[] jQQ;
  public boolean jRs;
  private Camera.PreviewCallback jUf = new a.2(this);
  d.b jUg = new a.10(this);
  public int jVL;
  public String jVM;
  private FaceActionUI jVN;
  private com.tencent.mm.plugin.facedetectaction.b.a.a jVP;
  public FaceActionMask jWF;
  private MMTextureView jXi;
  private HandlerThread jXj;
  private ah jXk;
  public boolean jXl;
  private FaceReflectUI jXm;
  public TextView jXn;
  FaceReflectMask jXo;
  public PreviewFrameLayout jXp;
  private int jXq = 0;
  String jXr;
  public ImageView jXs;
  public ImageView jXt;
  private Bitmap jXu;
  private boolean jXv;
  private int jXw;
  private d.a.a jXx;
  private ai jXy = new ai("mPreviewHandlerThread");
  String mAppId;
  public Camera mCamera;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private boolean mIsCameraOpened;
  
  public a(FaceActionUI paramFaceActionUI, com.tencent.mm.plugin.facedetectaction.b.a.a parama)
  {
    this.jXw = 2;
    this.jVN = paramFaceActionUI;
    this.mIsCameraOpened = false;
    this.jRs = false;
    this.jXj = null;
    this.mIsCameraOpened = false;
    this.jXv = false;
    this.jVP = parama;
  }
  
  public a(FaceReflectUI paramFaceReflectUI)
  {
    this.jXw = 1;
    this.jXm = paramFaceReflectUI;
    this.mIsCameraOpened = false;
    this.jRs = false;
    this.jXj = null;
    this.mIsCameraOpened = false;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    y.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bk.fQ(ae.getContext());
    y.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
    int i = paramPoint.x;
    i = paramPoint.y;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int j;
    label235:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      y.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 983040))
      {
        if (i > j)
        {
          m = 1;
          if (m == 0) {
            break label342;
          }
          k = j;
          if (m == 0) {
            break label349;
          }
        }
        label342:
        label349:
        for (int m = i;; m = j)
        {
          y.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!f(k, m, l))) {
            break label356;
          }
          paramParameters = new Point(i, j);
          y.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: " + paramParameters);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label235;
        }
        label356:
        f2 = Math.abs(k / m - f3);
        if ((f2 >= f1) || (!f(i, j, l))) {
          break label541;
        }
        localPoint = new Point(i, j);
        f1 = f2;
      }
    }
    label527:
    label541:
    for (;;)
    {
      y.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label527;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        y.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: " + paramPoint);
      }
      for (;;)
      {
        y.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: " + paramPoint);
        return paramPoint;
        y.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static void a(Camera.Parameters paramParameters)
  {
    if (q.dyd.dwn > 0) {
      y.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
    }
    List localList;
    do
    {
      return;
      localList = paramParameters.getSupportedPreviewFpsRange();
    } while ((localList == null) || (localList.size() == 0));
    int j = -2147483648;
    int i = -2147483648;
    int n = 0;
    int i6 = localList.size();
    int i3 = 0;
    label62:
    int i2;
    int i1;
    int k;
    if (i3 < i6)
    {
      int[] arrayOfInt = (int[])localList.get(i3);
      i2 = i;
      i1 = j;
      if (arrayOfInt == null) {
        break label353;
      }
      i2 = i;
      i1 = j;
      if (arrayOfInt.length <= 1) {
        break label353;
      }
      int i5 = arrayOfInt[0];
      int i4 = arrayOfInt[1];
      y.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
      i2 = i;
      i1 = j;
      if (i5 < 0) {
        break label353;
      }
      i2 = i;
      i1 = j;
      if (i4 < i5) {
        break label353;
      }
      k = i;
      int m = j;
      if (i4 >= i)
      {
        k = i;
        m = j;
        if (n == 0)
        {
          k = i4;
          m = i5;
        }
      }
      i2 = k;
      i1 = m;
      if (i4 < 30000) {
        break label353;
      }
      n = 1;
      j = m;
      i = k;
      k = n;
    }
    for (;;)
    {
      i3 += 1;
      n = k;
      break label62;
      y.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647)) {
        break;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        y.i("MicroMsg.FaceReflectCam", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        return;
      }
      catch (Exception paramParameters)
      {
        y.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        return;
      }
      label353:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private boolean aPB()
  {
    y.i("MicroMsg.FaceReflectCam", "start open camera");
    this.mIsCameraOpened = false;
    this.isFrontCamera = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    if (i < j)
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i, localCameraInfo);
      if ((localCameraInfo.facing == 1) && (this.isFrontCamera)) {
        y.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
      }
    }
    label898:
    label1035:
    label1294:
    for (;;)
    {
      label73:
      long l = bk.UZ();
      y.i("MicroMsg.FaceReflectCam", "openCameraRes：" + this.jXx);
      if (this.jXx == null)
      {
        y.i("MicroMsg.FaceReflectCam", "openCameraRes is null");
        if (this.jXw != 1) {
          break label241;
        }
        y.i("MicroMsg.FaceReflectCam", "mFaceReflectUI openCameraRe");
      }
      for (this.jXx = com.tencent.mm.compatible.e.d.u(this.jXm.mController.uMN, i);; this.jXx = com.tencent.mm.compatible.e.d.u(this.jVN.mController.uMN, i))
      {
        if (this.jXx != null) {
          break label271;
        }
        y.i("MicroMsg.FaceReflectCam", "in open(), openCameraRes == null");
        try
        {
          throw new IOException();
        }
        catch (IOException localIOException1)
        {
          y.i("MicroMsg.FaceReflectCam", "set cameraRes exception" + localIOException1.getMessage());
          return false;
        }
        if ((localIOException1.facing == 0) && (!this.isFrontCamera))
        {
          y.d("MicroMsg.FaceReflectCam", "hy: front Camera found");
          break label73;
        }
        i += 1;
        break;
        label241:
        y.i("MicroMsg.FaceReflectCam", "mFaceActionUI openCameraRe");
      }
      label271:
      this.jXq = i;
      this.mIsCameraOpened = true;
      y.d("MicroMsg.FaceReflectCam", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
      this.jOH = this.jXx.rotate;
      boolean bool;
      Camera.Parameters localParameters;
      label470:
      Point localPoint2;
      Point localPoint1;
      Object localObject2;
      if (this.jXx.rotate % 180 != 0)
      {
        bool = true;
        this.jOG = bool;
        this.mCamera = this.jXx.dwJ;
        if (this.mCamera == null)
        {
          y.e("MicroMsg.FaceReflectCam", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.jOG) });
          try
          {
            throw new IOException();
          }
          catch (IOException localIOException2)
          {
            y.i("MicroMsg.FaceReflectCam", "set cameraRotation exception" + localIOException2.getMessage());
          }
        }
        localParameters = this.mCamera.getParameters();
        if (this.jXw != 1) {
          break label1110;
        }
        j = this.jXm.getResources().getDisplayMetrics().widthPixels;
        i = this.jXm.getResources().getDisplayMetrics().heightPixels;
        this.jOE = new Point(j, i);
        localPoint2 = this.jOE;
        localPoint1 = this.jOF;
        localObject2 = localParameters.get("preview-size-values");
        if (localObject2 != null) {
          break label1375;
        }
        localObject2 = localParameters.get("preview-size-value");
      }
      label1110:
      label1369:
      label1375:
      for (;;)
      {
        for (;;)
        {
          Object localObject1 = null;
          if (localObject2 != null)
          {
            y.d("MicroMsg.FaceReflectCam", "preview-size-values parameter: " + (String)localObject2);
            localObject1 = a(localParameters, localPoint2);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
          }
          this.jOD = ((Point)localObject2);
          this.jOK = new Point(this.jOD);
          y.d("MicroMsg.FaceReflectCam", "getCameraResolution: " + this.jOE + " camera:" + this.jOD + "bestVideoEncodeSize: " + this.jOK);
          this.mDesiredPreviewWidth = this.jOD.x;
          this.mDesiredPreviewHeight = this.jOD.y;
          localParameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
          y.e("MicroMsg.FaceReflectCam", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
          y.e("MicroMsg.FaceReflectCam", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
          localParameters.setZoom(0);
          localParameters.setSceneMode("auto");
          try
          {
            if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
            {
              y.i("MicroMsg.FaceReflectCam", "set FocusMode to FOCUS_MODE_AUTO");
              localParameters.setFocusMode("auto");
            }
            for (;;)
            {
              localObject1 = localParameters.getSupportedPreviewFormats();
              localObject2 = ((List)localObject1).iterator();
              i = 0;
              if (!((Iterator)localObject2).hasNext()) {
                break label1369;
              }
              j = ((Integer)((Iterator)localObject2).next()).intValue();
              y.d("MicroMsg.FaceReflectCam", "supportedPreviewFormat: " + j);
              if (j != 17) {
                break label1179;
              }
              j = 1;
              if (j == 0) {
                break label1193;
              }
              localParameters.setPreviewFormat(17);
              if (this.jOG) {
                localParameters.setRotation(this.jOH);
              }
              double d1 = this.jXp.getmAspectRatio();
              y.d("MicroMsg.FaceReflectCam", "original ratio=" + d1);
              d2 = this.mDesiredPreviewWidth / this.mDesiredPreviewHeight;
              y.d("MicroMsg.FaceReflectCam", "new ratio=" + d2);
              if (d1 != d2) {
                break label1262;
              }
              y.d("MicroMsg.FaceReflectCam", "NO NEED reset ratio");
              label992:
              a(localParameters);
              localObject1 = localParameters.getSupportedPreviewFpsRange();
              y.d("MicroMsg.FaceReflectCam", "range:" + ((List)localObject1).size());
              i = 0;
              if (i >= ((List)localObject1).size()) {
                break label1294;
              }
              localObject2 = (int[])((List)localObject1).get(i);
              j = 0;
              while (j < localObject2.length)
              {
                y.i("MicroMsg.FaceReflectCam", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject2[j]) });
                j += 1;
              }
              bool = false;
              break;
              j = this.jVN.getResources().getDisplayMetrics().widthPixels;
              i = this.jVN.getResources().getDisplayMetrics().heightPixels;
              break label470;
              y.i("MicroMsg.FaceReflectCam", "camera not support FOCUS_MODE_AUTO");
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              double d2;
              y.e("MicroMsg.FaceReflectCam", "set focus mode error: %s", new Object[] { localException.getMessage() });
              continue;
              if (j == 842094169) {
                i = 1;
              }
              for (;;)
              {
                break;
                if (i != 0)
                {
                  y.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                  localParameters.setPreviewFormat(842094169);
                  break label898;
                }
                y.e("MicroMsg.FaceReflectCam", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException.get(0) });
                localParameters.setPreviewFormat(((Integer)localException.get(0)).intValue());
                break label898;
                label1262:
                y.d("MicroMsg.FaceReflectCam", "start reset ratio");
                ai.d(new a.6(this, d2));
                break label992;
                i += 1;
                break label1035;
                y.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
                y.i("MicroMsg.FaceReflectCam", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
                this.mCamera.setParameters(localParameters);
                return this.mIsCameraOpened;
              }
              j = 0;
            }
          }
        }
      }
      label1179:
      label1193:
      i = -1;
    }
  }
  
  private static boolean f(int paramInt1, int paramInt2, long paramLong)
  {
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    y.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    return paramLong / d >= 5.0D;
  }
  
  private void i(final SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.jXw == 1) {
      this.jXo.setVisibility(0);
    }
    for (;;)
    {
      aPD();
      if (this.jXk == null) {
        break;
      }
      this.jXk.post(new Runnable()
      {
        public final void run()
        {
          h localh;
          if (!a.d(a.this))
          {
            localh = h.nFQ;
            if (a.e(a.this) == 1)
            {
              l = 3L;
              localh.a(917L, l, 1L, false);
              a.d(a.this);
            }
          }
          else
          {
            localh = h.nFQ;
            if (a.e(a.this) != 1) {
              break label95;
            }
          }
          label95:
          for (long l = 2L;; l = 38L)
          {
            localh.a(917L, l, 1L, false);
            ai.d(new a.3.1(this));
            return;
            l = 39L;
            break;
          }
        }
      });
      this.jXk.post(new Runnable()
      {
        public final void run()
        {
          try
          {
            a.a(a.this, paramSurfaceTexture);
            a locala = a.this;
            Camera.PreviewCallback localPreviewCallback = a.u(a.this);
            if (locala.mCamera == null)
            {
              y.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
              return;
            }
            int j = locala.mDesiredPreviewWidth * locala.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(locala.mCamera.getParameters().getPreviewFormat()) / 8;
            int i = 0;
            while (i < 5)
            {
              byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.jNB.f(Integer.valueOf(j));
              locala.mCamera.addCallbackBuffer(arrayOfByte);
              i += 1;
            }
            locala.mCamera.setPreviewCallbackWithBuffer(new a.9(locala, localPreviewCallback));
            com.tencent.mm.plugin.facedetect.model.d.aOf().a(locala.jUg);
            return;
          }
          catch (Exception localException)
          {
            if (a.e(a.this) == 1)
            {
              a.f(a.this).k(90016, "preview error", ae.getContext().getString(a.i.soter_face_err_msg_retry));
              return;
            }
            y.i("MicroMsg.FaceReflectCam", "preview error");
          }
        }
      });
      return;
      this.jWF.setVisibility(0);
    }
    y.i("MicroMsg.FaceReflectCam", "back thread is not running");
  }
  
  public final void a(MMTextureView paramMMTextureView)
  {
    this.jXi = paramMMTextureView;
    if (this.jXi.isAvailable()) {
      i(paramMMTextureView.getSurfaceTexture());
    }
    this.jXi.setSurfaceTextureListener(this);
    this.jXi.setVisibility(0);
    this.jXi.setAlpha(0.0F);
    if ((this.jXw == 2) && (!this.jXv)) {
      ai.l(new a.1(this), 700L);
    }
  }
  
  public final void aPC()
  {
    y.i("MicroMsg.FaceReflectCam", "closeCamera start");
    if (this.mCamera != null) {}
    try
    {
      if (this.jRs)
      {
        this.jRs = false;
        this.mCamera.stopPreview();
        this.mCamera.setPreviewCallback(null);
        y.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.mCamera.release();
        this.mCamera = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.mCamera = null;
        }
      }
      finally
      {
        this.mCamera = null;
      }
      y.i("MicroMsg.FaceReflectCam", "closeCamera end");
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        y.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException1.getMessage());
      }
    }
  }
  
  public final void aPD()
  {
    if (this.jXj == null)
    {
      y.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.jXj = e.aap("ameraBackground");
      this.jXj.start();
      this.jXk = new ah(this.jXj.getLooper());
    }
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    i(paramSurfaceTexture);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.jXk != null)
    {
      this.jXk.post(new a.5(this));
      if (this.jXj != null) {
        y.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.jXj.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          for (;;)
          {
            this.jXj.join();
            this.jXj = null;
            this.jXk = null;
            y.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
            return false;
            paramSurfaceTexture = paramSurfaceTexture;
            y.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
            continue;
            this.jXj.quit();
          }
        }
        catch (InterruptedException paramSurfaceTexture)
        {
          for (;;)
          {
            y.i("MicroMsg.FaceReflectCam", "stop background thread error：" + paramSurfaceTexture.getMessage());
          }
        }
      }
    }
    y.i("MicroMsg.FaceReflectCam", "back thread is not running");
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void stopPreview()
  {
    y.i("MicroMsg.FaceReflectCam", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.jXl) });
    if (this.mCamera != null)
    {
      this.mCamera.stopPreview();
      this.jXl = false;
      com.tencent.mm.plugin.facedetect.model.c.jNB.ET();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */