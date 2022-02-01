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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
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

public final class b
{
  private boolean imf;
  private d.a.a imk;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private Point pbD;
  private Point sRF;
  private Point sRG;
  private boolean sRH;
  private int sRI;
  private Point sRK;
  d.b sVF;
  private MMTextureView sYY;
  HandlerThread sYZ;
  MMHandler sZa;
  public v sZb;
  private boolean sZc;
  public boolean sZd;
  public int sZh;
  int sZl;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(186512);
    this.sRF = null;
    this.pbD = null;
    this.sRG = null;
    this.sRK = null;
    this.sZh = 0;
    this.sVF = new d.b()
    {
      public final void bC(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(186510);
        com.tencent.mm.plugin.facedetect.model.c.sQB.k(paramAnonymousArrayOfByte);
        AppMethodBeat.o(186510);
      }
      
      public final a<byte[]> cSS()
      {
        return com.tencent.mm.plugin.facedetect.model.c.sQB;
      }
    };
    this.mContext = paramContext;
    this.sZc = false;
    this.sZd = false;
    this.sYZ = null;
    this.sZc = false;
    AppMethodBeat.o(186512);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(186521);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new b.b((byte)0));
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
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!k(k, m, l))) {
            break label359;
          }
          paramParameters = new Point(i, j);
          Log.i("MicroMsg.FaceFlashManagerCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(186521);
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
          if ((f2 >= f1) || (!k(i, j, l))) {
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
        AppMethodBeat.o(186521);
        return paramPoint;
        Log.e("MicroMsg.FaceFlashManagerCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static void a(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(186522);
    if (ae.gKt.gFP > 0)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(186522);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(186522);
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
        break label384;
      }
      i2 = i;
      i1 = j;
      if (arrayOfInt.length <= 1) {
        break label384;
      }
      int i5 = arrayOfInt[0];
      int i4 = arrayOfInt[1];
      Log.i("MicroMsg.FaceFlashManagerCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
      i2 = i;
      i1 = j;
      if (i5 < 0) {
        break label384;
      }
      i2 = i;
      i1 = j;
      if (i4 < i5) {
        break label384;
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
        break label384;
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
        AppMethodBeat.o(186522);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        Log.i("MicroMsg.FaceFlashManagerCamera", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(186522);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.i("MicroMsg.FaceFlashManagerCamera", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(186522);
        return;
      }
      label384:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private void cUd()
  {
    AppMethodBeat.i(186520);
    if (this.sYZ == null)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "start camera thread");
      this.sYZ = com.tencent.f.c.d.hB("cameraBackground", 5);
      this.sYZ.start();
      this.sZa = new MMHandler(this.sYZ.getLooper());
    }
    AppMethodBeat.o(186520);
  }
  
  private static boolean k(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(186524);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    Log.d("MicroMsg.FaceFlashManagerCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(186524);
      return true;
    }
    AppMethodBeat.o(186524);
    return false;
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(186515);
    if (k(paramSurfaceTexture)) {
      this.sZb.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(186507);
          if (paramPreviewCallback != null) {
            paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
          }
          paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
          AppMethodBeat.o(186507);
        }
      });
    }
    AppMethodBeat.o(186515);
  }
  
  public final void a(MMTextureView paramMMTextureView, final a parama)
  {
    AppMethodBeat.i(186513);
    Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraForSurfaceTexture");
    this.sYY = paramMMTextureView;
    cUd();
    if (this.sZa != null)
    {
      this.sZa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186506);
          boolean bool2 = b.this.cUc();
          boolean bool1 = bool2;
          h localh;
          if (!bool2)
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "reopen Camera");
            localh = h.CyF;
            if (b.this.sZl == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              bool1 = b.this.cUc();
            }
          }
          else
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "isOpenCamera：%s", new Object[] { Boolean.valueOf(bool1) });
            localh = h.CyF;
            if (b.this.sZl != 1) {
              break label144;
            }
          }
          label144:
          for (long l = 2L;; l = 38L)
          {
            localh.idkeyStat(917L, l, 1L, false);
            parama.a(Boolean.valueOf(bool1), b.this);
            AppMethodBeat.o(186506);
            return;
            l = 39L;
            break;
          }
        }
      });
      AppMethodBeat.o(186513);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
    AppMethodBeat.o(186513);
  }
  
  public final boolean a(final SurfaceTexture paramSurfaceTexture, final a parama)
  {
    AppMethodBeat.i(186516);
    Log.i("MicroMsg.FaceFlashManagerCamera", "mIsPreviewing is " + this.sZd);
    if ((this.sZb != null) && (!this.sZd))
    {
      this.sZd = true;
      this.sZa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186508);
          try
          {
            b.this.sZb.setPreviewTexture(paramSurfaceTexture);
            com.tencent.mm.plugin.facedetect.model.c.dj(b.this.mDesiredPreviewWidth, b.this.mDesiredPreviewHeight);
            b.this.sZb.startPreview();
            AppMethodBeat.o(186508);
            return;
          }
          catch (IOException localIOException)
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "start Preview failed ：" + localIOException.getMessage());
            b.this.sZd = false;
            if (parama != null) {
              parama.a(Boolean.FALSE, null);
            }
            AppMethodBeat.o(186508);
          }
        }
      });
      Log.i("MicroMsg.FaceFlashManagerCamera", "start preview, is previewing");
    }
    boolean bool = this.sZd;
    AppMethodBeat.o(186516);
    return bool;
  }
  
  final boolean cUc()
  {
    AppMethodBeat.i(186514);
    Log.i("MicroMsg.FaceFlashManagerCamera", "start open camera");
    this.sZc = false;
    this.imf = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Camera.CameraInfo localCameraInfo;
    if (i < j)
    {
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i, localCameraInfo);
      if ((localCameraInfo.facing == 1) && (this.imf)) {
        Log.e("MicroMsg.FaceFlashManagerCamera", "openCamera found front Camera ");
      }
    }
    for (;;)
    {
      if (i == -1)
      {
        Log.i("MicroMsg.FaceFlashManagerCamera", "not found available camera id");
        AppMethodBeat.o(186514);
        return false;
        if ((localCameraInfo.facing == 0) && (!this.imf))
        {
          Log.e("MicroMsg.FaceFlashManagerCamera", "openCamera found front Camera");
          continue;
        }
        i += 1;
        break;
      }
      long l = Util.currentTicks();
      if (this.imk == null) {
        Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraRes is null");
      }
      try
      {
        this.imk = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i, null);
        if (this.imk == null)
        {
          Log.e("MicroMsg.FaceFlashManagerCamera", "in open(), openCameraRes == null");
          AppMethodBeat.o(186514);
          return false;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException1, "MicroMsg.FaceFlashManagerError", new Object[0]);
        AppMethodBeat.o(186514);
        return false;
      }
      this.sZh = i;
      this.sZc = true;
      Log.i("MicroMsg.FaceFlashManagerCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.sRI = this.imk.dYT;
      if (this.imk.dYT % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.sRH = bool;
        this.sZb = this.imk.gGr;
        if (this.sZb != null) {
          break;
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.sRH) });
        AppMethodBeat.o(186514);
        return false;
      }
      Camera.Parameters localParameters;
      try
      {
        localParameters = this.sZb.getParameters();
        if (localParameters == null)
        {
          Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), parameters == null");
          AppMethodBeat.o(186514);
          return false;
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(186514);
        return false;
      }
      this.pbD = new Point(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
      Point localPoint2 = this.pbD;
      Point localPoint1 = this.sRG;
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
        this.sRF = ((Point)localObject2);
        this.sRK = new Point(this.sRF);
        Log.d("MicroMsg.FaceFlashManagerCamera", "getCameraResolution: " + this.pbD + " camera:" + this.sRF + "bestVideoEncodeSize: " + this.sRK);
        this.mDesiredPreviewWidth = this.sRF.x;
        this.mDesiredPreviewHeight = this.sRF.y;
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
              break label1198;
            }
            j = ((Integer)((Iterator)localObject2).next()).intValue();
            Log.d("MicroMsg.FaceFlashManagerCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            if (j == 0) {
              break label1019;
            }
            localParameters.setPreviewFormat(17);
            label826:
            if (this.sRH) {
              localParameters.setRotation(this.sRI);
            }
            Log.d("MicroMsg.FaceFlashManagerCamera", "new ratio=".concat(String.valueOf(this.mDesiredPreviewWidth / this.mDesiredPreviewHeight)));
            a(localParameters);
            localObject1 = localParameters.getSupportedPreviewFpsRange();
            Log.d("MicroMsg.FaceFlashManagerCamera", "range:" + ((List)localObject1).size());
            i = 0;
            label909:
            if (i >= ((List)localObject1).size()) {
              break label1094;
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
              label1019:
              if (i != 0)
              {
                Log.e("MicroMsg.FaceFlashManagerCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                localParameters.setPreviewFormat(842094169);
                break label826;
              }
              Log.e("MicroMsg.FaceFlashManagerCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { localException3.get(0) });
              localParameters.setPreviewFormat(((Integer)localException3.get(0)).intValue());
              break label826;
              i += 1;
              break label909;
              label1094:
              Log.i("MicroMsg.FaceFlashManagerCamera", "Camera preview-fps-range：" + localParameters.get("preview-fps-range"));
              Log.i("MicroMsg.FaceFlashManagerCamera", "Camera preview-fps-range：" + localParameters.get("preview-frame-rate"));
              try
              {
                this.sZb.setParameters(localParameters);
                bool = this.sZc;
                AppMethodBeat.o(186514);
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
            label1198:
            j = 0;
          }
        }
      }
      i = -1;
    }
  }
  
  public final void dKU()
  {
    AppMethodBeat.i(186523);
    if (this.sZa != null)
    {
      this.sZa.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186511);
          b localb = b.this;
          Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera start");
          com.tencent.mm.plugin.facedetect.model.d.cSR().b(localb.sVF);
          if (localb.sZb != null) {}
          try
          {
            if (localb.sZd)
            {
              localb.sZd = false;
              localb.sZb.stopPreview();
              localb.sZb.setPreviewCallback(null);
              Log.i("MicroMsg.FaceFlashManagerCamera", "stop preview, not previewing");
            }
            try
            {
              localb.sZb.release();
              localb.sZb = null;
              localb.sZb = null;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.i("MicroMsg.FaceFlashManagerCamera", "Error setting camera preview: " + localException2.getMessage());
                localb.sZb = null;
              }
            }
            finally
            {
              localb.sZb = null;
              AppMethodBeat.o(186511);
            }
            Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera end");
            localb = b.this;
            if (localb.sYZ == null)
            {
              AppMethodBeat.o(186511);
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
          if (localb.sZa != null) {
            localb.sZa.removeCallbacksAndMessages(null);
          }
          Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread");
          if (Build.VERSION.SDK_INT >= 18) {
            localb.sYZ.quitSafely();
          }
          for (;;)
          {
            localb.sYZ = null;
            localb.sZa = null;
            localb.mContext = null;
            Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread finish");
            AppMethodBeat.o(186511);
            return;
            localb.sYZ.quit();
          }
        }
      });
      AppMethodBeat.o(186523);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
    AppMethodBeat.o(186523);
  }
  
  public final float getAspectRatio()
  {
    AppMethodBeat.i(186526);
    try
    {
      Object localObject = this.sZb.getParameters().get("preview-size");
      Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", new Object[] { localObject });
      localObject = ((String)localObject).split("x");
      float f = Integer.parseInt(localObject[0]);
      int i = Integer.parseInt(localObject[1]);
      f = f * 1.0F / i;
      AppMethodBeat.o(186526);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(186526);
    }
    return 1.0F;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(186525);
    try
    {
      Object localObject = this.sZb.getParameters().get("preview-size");
      Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", new Object[] { localObject });
      localObject = ((String)localObject).split("x");
      this.mDesiredPreviewWidth = Integer.parseInt(localObject[0]);
      this.mDesiredPreviewHeight = Integer.parseInt(localObject[1]);
      label64:
      localObject = new Point(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
      AppMethodBeat.o(186525);
      return localObject;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  public final boolean k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(186517);
    boolean bool = a(paramSurfaceTexture, new a()
    {
      public final void a(Boolean paramAnonymousBoolean, b paramAnonymousb) {}
    });
    AppMethodBeat.o(186517);
    return bool;
  }
  
  public final void setPreviewCallback(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(186518);
    if (this.sZb == null)
    {
      Log.w("MicroMsg.FaceFlashManagerCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(186518);
      return;
    }
    int j = this.mDesiredPreviewWidth * this.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(this.sZb.getParameters().getPreviewFormat()) / 8;
    int i = 0;
    while (i < 5)
    {
      byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.sQB.h(Integer.valueOf(j));
      this.sZb.addCallbackBuffer(arrayOfByte);
      i += 1;
    }
    this.sZb.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(186509);
        if (paramPreviewCallback != null) {
          paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
        }
        paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
        AppMethodBeat.o(186509);
      }
    });
    com.tencent.mm.plugin.facedetect.model.d.cSR().a(this.sVF);
    AppMethodBeat.o(186518);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(186519);
    Log.i("MicroMsg.FaceFlashManagerCamera", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.sZd) });
    if ((this.sZb != null) && (!this.sZb.gIJ) && (this.sZd))
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "just stopPreview");
      this.sZb.stopPreview();
      this.sZd = false;
      com.tencent.mm.plugin.facedetect.model.c.sQB.aRR();
    }
    AppMethodBeat.o(186519);
  }
  
  public static abstract interface a
  {
    public abstract void a(Boolean paramBoolean, b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b
 * JD-Core Version:    0.7.0.1
 */