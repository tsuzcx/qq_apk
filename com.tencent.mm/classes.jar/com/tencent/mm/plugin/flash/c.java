package com.tencent.mm.plugin.flash;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private MMTextureView Abl;
  HandlerThread Abm;
  MMHandler Abn;
  public w Abo;
  public int Abs;
  int Abw;
  private boolean isFrontCamera;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private boolean mIsCameraOpened;
  private d.a.a nGr;
  public boolean nvB;
  private Point vpf;
  private Point zTH;
  private Point zTI;
  private boolean zTJ;
  private int zTK;
  private Point zTM;
  d.b zXO;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(264443);
    this.zTH = null;
    this.vpf = null;
    this.zTI = null;
    this.zTM = null;
    this.Abs = 0;
    this.zXO = new d.b()
    {
      public final void bQ(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(264463);
        com.tencent.mm.plugin.facedetect.model.c.zSD.as(paramAnonymousArrayOfByte);
        AppMethodBeat.o(264463);
      }
      
      public final a<byte[]> dOH()
      {
        return com.tencent.mm.plugin.facedetect.model.c.zSD;
      }
    };
    this.mContext = paramContext;
    this.mIsCameraOpened = false;
    this.nvB = false;
    this.Abm = null;
    this.mIsCameraOpened = false;
    AppMethodBeat.o(264443);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(264471);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new c.b((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    Log.d("MicroMsg.FaceFlashManagerCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = Util.getAvailableMemoryMB(MMApplicationContext.getContext());
    Log.d("MicroMsg.FaceFlashManagerCamera", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
    int i = paramPoint.x;
    i = paramPoint.y;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int j;
    label240:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      Log.i("MicroMsg.FaceFlashManagerCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 983040))
      {
        if (i > j)
        {
          m = 1;
          if (m == 0) {
            break label345;
          }
          k = j;
          if (m == 0) {
            break label352;
          }
        }
        label345:
        label352:
        for (int m = i;; m = j)
        {
          Log.d("MicroMsg.FaceFlashManagerCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!m(k, m, l))) {
            break label359;
          }
          paramParameters = new Point(i, j);
          Log.i("MicroMsg.FaceFlashManagerCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(264471);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label240;
        }
        label359:
        f2 = Math.abs(k / m - f3);
        if (i % 10 == 0)
        {
          if ((f2 >= f1) || (!m(i, j, l))) {
            break label539;
          }
          localPoint = new Point(i, j);
          f1 = f2;
        }
      }
    }
    label526:
    label539:
    for (;;)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label526;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        Log.i("MicroMsg.FaceFlashManagerCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        Log.i("MicroMsg.FaceFlashManagerCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(264471);
        return paramPoint;
        Log.e("MicroMsg.FaceFlashManagerCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private void dPU()
  {
    AppMethodBeat.i(264455);
    if (this.Abm == null)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "start camera thread");
      this.Abm = com.tencent.threadpool.c.d.jx("cameraBackground", 5);
      this.Abm.start();
      this.Abn = new MMHandler(this.Abm.getLooper());
    }
    AppMethodBeat.o(264455);
  }
  
  private static void f(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(264482);
    if (af.lXY.lTg > 0)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(264482);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(264482);
      return;
    }
    int j = -2147483648;
    int i = -2147483648;
    int n = 0;
    int i6 = localList.size();
    int i3 = 0;
    int i2;
    int i1;
    int k;
    if (i3 < i6)
    {
      int[] arrayOfInt = (int[])localList.get(i3);
      i2 = i;
      i1 = j;
      if (arrayOfInt == null) {
        break label391;
      }
      i2 = i;
      i1 = j;
      if (arrayOfInt.length <= 1) {
        break label391;
      }
      int i5 = arrayOfInt[0];
      int i4 = arrayOfInt[1];
      Log.i("MicroMsg.FaceFlashManagerCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
      i2 = i;
      i1 = j;
      if (i5 < 0) {
        break label391;
      }
      i2 = i;
      i1 = j;
      if (i4 < i5) {
        break label391;
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
        break label391;
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
      break;
      Log.i("MicroMsg.FaceFlashManagerCamera", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(264482);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        Log.i("MicroMsg.FaceFlashManagerCamera", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(264482);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.i("MicroMsg.FaceFlashManagerCamera", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(264482);
        return;
      }
      label391:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private static boolean m(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(264489);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    Log.d("MicroMsg.FaceFlashManagerCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(264489);
      return true;
    }
    AppMethodBeat.o(264489);
    return false;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(264538);
    if (m(paramSurfaceTexture)) {
      this.Abo.b(new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(264504);
          if (paramPreviewCallback != null) {
            paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
          }
          paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
          AppMethodBeat.o(264504);
        }
      });
    }
    AppMethodBeat.o(264538);
  }
  
  public final void a(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(264565);
    if (this.Abo == null)
    {
      Log.w("MicroMsg.FaceFlashManagerCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(264565);
      return;
    }
    int j = this.mDesiredPreviewWidth * this.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(this.Abo.aPy().getPreviewFormat()) / 8;
    int i = 0;
    while (i < 5)
    {
      byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.zSD.m(Integer.valueOf(j));
      this.Abo.aj(arrayOfByte);
      i += 1;
    }
    this.Abo.b(new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(264454);
        if (paramPreviewCallback != null) {
          paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
        }
        paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
        AppMethodBeat.o(264454);
      }
    });
    com.tencent.mm.plugin.facedetect.model.d.dOG().a(this.zXO);
    AppMethodBeat.o(264565);
  }
  
  public final void a(MMTextureView paramMMTextureView, final a parama)
  {
    AppMethodBeat.i(264498);
    Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraForSurfaceTexture");
    this.Abl = paramMMTextureView;
    dPU();
    if (this.Abn != null)
    {
      this.Abn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264497);
          boolean bool2 = c.this.dPT();
          boolean bool1 = bool2;
          h localh;
          if (!bool2)
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "reopen Camera");
            localh = h.OAn;
            if (c.this.Abw == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              bool1 = c.this.dPT();
            }
          }
          else
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "isOpenCamera：%s", new Object[] { Boolean.valueOf(bool1) });
            localh = h.OAn;
            if (c.this.Abw != 1) {
              break label144;
            }
          }
          label144:
          for (long l = 2L;; l = 38L)
          {
            localh.idkeyStat(917L, l, 1L, false);
            parama.a(Boolean.valueOf(bool1), c.this);
            AppMethodBeat.o(264497);
            return;
            l = 39L;
            break;
          }
        }
      });
      AppMethodBeat.o(264498);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
    AppMethodBeat.o(264498);
  }
  
  public final boolean a(final SurfaceTexture paramSurfaceTexture, final a parama)
  {
    AppMethodBeat.i(264548);
    Log.i("MicroMsg.FaceFlashManagerCamera", "mIsPreviewing is " + this.nvB);
    if ((this.Abo != null) && (!this.nvB))
    {
      this.nvB = true;
      this.Abn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264511);
          try
          {
            c.this.Abo.f(paramSurfaceTexture);
            com.tencent.mm.plugin.facedetect.model.c.ey(c.this.mDesiredPreviewWidth, c.this.mDesiredPreviewHeight);
            c.this.Abo.aPz();
            AppMethodBeat.o(264511);
            return;
          }
          catch (IOException localIOException)
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "start Preview failed:" + localIOException.getMessage());
            c.this.nvB = false;
            if (parama != null) {
              parama.a(Boolean.FALSE, null);
            }
            AppMethodBeat.o(264511);
          }
        }
      });
      Log.i("MicroMsg.FaceFlashManagerCamera", "start preview, is previewing");
    }
    boolean bool = this.nvB;
    AppMethodBeat.o(264548);
    return bool;
  }
  
  public final void auq()
  {
    AppMethodBeat.i(264574);
    Log.i("MicroMsg.FaceFlashManagerCamera", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.nvB) });
    if ((this.Abo != null) && (!this.Abo.lWt) && (this.nvB))
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "just stopPreview");
      this.Abo.auq();
      this.nvB = false;
      com.tencent.mm.plugin.facedetect.model.c.zSD.bvG();
    }
    AppMethodBeat.o(264574);
  }
  
  final boolean dPT()
  {
    AppMethodBeat.i(264529);
    Log.i("MicroMsg.FaceFlashManagerCamera", "start open camera");
    this.mIsCameraOpened = false;
    this.isFrontCamera = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Camera.CameraInfo localCameraInfo;
    if (i < j)
    {
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i, localCameraInfo);
      if ((localCameraInfo.facing == 1) && (this.isFrontCamera)) {
        Log.e("MicroMsg.FaceFlashManagerCamera", "openCamera found front Camera ");
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        Log.i("MicroMsg.FaceFlashManagerCamera", "not found available camera id");
        AppMethodBeat.o(264529);
        return false;
        if ((localCameraInfo.facing == 0) && (!this.isFrontCamera))
        {
          Log.e("MicroMsg.FaceFlashManagerCamera", "openCamera found front Camera");
          continue;
        }
        i += 1;
        break;
      }
      long l = Util.currentTicks();
      if (this.nGr == null) {
        Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraRes is null");
      }
      try
      {
        this.nGr = com.tencent.mm.compatible.deviceinfo.d.G(this.mContext, i);
        if (this.nGr == null)
        {
          Log.e("MicroMsg.FaceFlashManagerCamera", "in open(), openCameraRes == null");
          AppMethodBeat.o(264529);
          return false;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException1, "MicroMsg.FaceFlashManagerError", new Object[0]);
        AppMethodBeat.o(264529);
        return false;
      }
      this.Abs = i;
      this.mIsCameraOpened = true;
      Log.i("MicroMsg.FaceFlashManagerCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.zTK = this.nGr.hYK;
      if (this.nGr.hYK % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.zTJ = bool;
        this.Abo = this.nGr.lTN;
        if (this.Abo != null) {
          break;
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.zTJ) });
        AppMethodBeat.o(264529);
        return false;
      }
      Camera.Parameters localParameters;
      try
      {
        localParameters = this.Abo.aPy();
        if (localParameters == null)
        {
          Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), parameters == null");
          AppMethodBeat.o(264529);
          return false;
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(264529);
        return false;
      }
      this.vpf = new Point(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
      Point localPoint2 = this.vpf;
      Point localPoint1 = this.zTI;
      Object localObject2 = localParameters.get("preview-size-values");
      if (localObject2 == null) {
        localObject2 = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        Object localObject1 = null;
        if (localObject2 != null)
        {
          Log.d("MicroMsg.FaceFlashManagerCamera", "preview-size-values parameter: ".concat(String.valueOf(localObject2)));
          localObject1 = a(localParameters, localPoint2);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.zTH = ((Point)localObject2);
        this.zTM = new Point(this.zTH);
        Log.d("MicroMsg.FaceFlashManagerCamera", "getCameraResolution: " + this.vpf + " camera:" + this.zTH + "bestVideoEncodeSize: " + this.zTM);
        this.mDesiredPreviewWidth = this.zTH.x;
        this.mDesiredPreviewHeight = this.zTH.y;
        localParameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
        Log.d("MicroMsg.FaceFlashManagerCamera", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
        Log.d("MicroMsg.FaceFlashManagerCamera", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            localObject1 = localParameters.getSupportedPreviewFormats();
            localObject2 = ((List)localObject1).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label1197;
            }
            j = ((Integer)((Iterator)localObject2).next()).intValue();
            Log.d("MicroMsg.FaceFlashManagerCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1018;
            }
            localParameters.setPreviewFormat(17);
            label825:
            if (this.zTJ) {
              localParameters.setRotation(this.zTK);
            }
            Log.d("MicroMsg.FaceFlashManagerCamera", "new ratio=".concat(String.valueOf(this.mDesiredPreviewWidth / this.mDesiredPreviewHeight)));
            f(localParameters);
            localObject1 = localParameters.getSupportedPreviewFpsRange();
            Log.d("MicroMsg.FaceFlashManagerCamera", "range:" + ((List)localObject1).size());
            i = 0;
            label908:
            if (i >= ((List)localObject1).size()) {
              break label1093;
            }
            localObject2 = (int[])((List)localObject1).get(i);
            j = 0;
            while (j < localObject2.length)
            {
              Log.i("MicroMsg.FaceFlashManagerCamera", "Camera SupportedPreviewFpsRange：", new Object[] { Integer.valueOf(localObject2[j]) });
              j += 1;
            }
            Log.i("MicroMsg.FaceFlashManagerCamera", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.FaceFlashManagerCamera", "set focus mode error: %s", new Object[] { localException3.getMessage() });
            continue;
            if (j == 842094169) {
              i = 1;
            }
            for (;;)
            {
              break;
              label1018:
              if (i != 0)
              {
                Log.e("MicroMsg.FaceFlashManagerCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label825;
              }
              Log.e("MicroMsg.FaceFlashManagerCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label825;
              i += 1;
              break label908;
              label1093:
              Log.i("MicroMsg.FaceFlashManagerCamera", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              Log.i("MicroMsg.FaceFlashManagerCamera", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.Abo.c(localParameters);
                bool = this.mIsCameraOpened;
                AppMethodBeat.o(264529);
                return bool;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException4, "setParameters error", new Object[0]);
                }
              }
            }
            label1197:
            j = 0;
          }
        }
      }
      i = -1;
    }
  }
  
  public final float getAspectRatio()
  {
    AppMethodBeat.i(264592);
    try
    {
      Object localObject = this.Abo.aPy().get("preview-size");
      Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", new Object[] { localObject });
      localObject = ((String)localObject).split("x");
      float f = Integer.parseInt(localObject[0]);
      int i = Integer.parseInt(localObject[1]);
      f = f * 1.0F / i;
      AppMethodBeat.o(264592);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(264592);
    }
    return 1.0F;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(264585);
    try
    {
      Object localObject = this.Abo.aPy().get("preview-size");
      Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", new Object[] { localObject });
      localObject = ((String)localObject).split("x");
      this.mDesiredPreviewWidth = Integer.parseInt(localObject[0]);
      this.mDesiredPreviewHeight = Integer.parseInt(localObject[1]);
      label64:
      localObject = new Point(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
      AppMethodBeat.o(264585);
      return localObject;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  public final boolean m(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(264555);
    boolean bool = a(paramSurfaceTexture, new a()
    {
      public final void a(Boolean paramAnonymousBoolean, c paramAnonymousc) {}
    });
    AppMethodBeat.o(264555);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(264580);
    this.Abl = null;
    if (this.Abn != null)
    {
      this.Abn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264469);
          c localc = c.this;
          Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera start");
          com.tencent.mm.plugin.facedetect.model.d.dOG().b(localc.zXO);
          if (localc.Abo != null) {}
          try
          {
            if (localc.nvB)
            {
              localc.nvB = false;
              localc.Abo.auq();
              localc.Abo.a(null);
              Log.i("MicroMsg.FaceFlashManagerCamera", "stop preview, not previewing");
            }
            try
            {
              localc.Abo.a(null);
              localc.Abo.release();
              localc.Abo = null;
              localc.Abo = null;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.i("MicroMsg.FaceFlashManagerCamera", "Error setting camera preview: " + localException2.getMessage());
                localc.Abo = null;
              }
            }
            finally
            {
              localc.Abo = null;
              AppMethodBeat.o(264469);
            }
            Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera end");
            localc = c.this;
            if (localc.Abm == null)
            {
              AppMethodBeat.o(264469);
              return;
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Log.i("MicroMsg.FaceFlashManagerCamera", "Error setting camera preview: " + localException1.getMessage());
            }
          }
          if (localc.Abn != null) {
            localc.Abn.removeCallbacksAndMessages(null);
          }
          Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread");
          if (Build.VERSION.SDK_INT >= 18) {
            localc.Abm.quitSafely();
          }
          for (;;)
          {
            localc.Abm = null;
            localc.Abn = null;
            localc.mContext = null;
            Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread finish");
            AppMethodBeat.o(264469);
            return;
            localc.Abm.quit();
          }
        }
      });
      AppMethodBeat.o(264580);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
    AppMethodBeat.o(264580);
  }
  
  public static abstract interface a
  {
    public abstract void a(Boolean paramBoolean, c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.c
 * JD-Core Version:    0.7.0.1
 */