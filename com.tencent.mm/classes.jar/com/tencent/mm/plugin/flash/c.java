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
  private boolean isFrontCamera;
  private d.a.a lbk;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private Point sdD;
  d.b wBD;
  private MMTextureView wFa;
  HandlerThread wFb;
  MMHandler wFc;
  public w wFd;
  private boolean wFe;
  public boolean wFf;
  public int wFj;
  int wFn;
  private Point wxB;
  private Point wxC;
  private boolean wxD;
  private int wxE;
  private Point wxG;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(198617);
    this.wxB = null;
    this.sdD = null;
    this.wxC = null;
    this.wxG = null;
    this.wFj = 0;
    this.wBD = new d.b()
    {
      public final void bQ(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(198386);
        com.tencent.mm.plugin.facedetect.model.c.wwx.as(paramAnonymousArrayOfByte);
        AppMethodBeat.o(198386);
      }
      
      public final a<byte[]> dhW()
      {
        return com.tencent.mm.plugin.facedetect.model.c.wwx;
      }
    };
    this.mContext = paramContext;
    this.wFe = false;
    this.wFf = false;
    this.wFb = null;
    this.wFe = false;
    AppMethodBeat.o(198617);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(198679);
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
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!l(k, m, l))) {
            break label359;
          }
          paramParameters = new Point(i, j);
          Log.i("MicroMsg.FaceFlashManagerCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(198679);
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
          if ((f2 >= f1) || (!l(i, j, l))) {
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
        AppMethodBeat.o(198679);
        return paramPoint;
        Log.e("MicroMsg.FaceFlashManagerCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static void d(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(198692);
    if (af.juH.jpZ > 0)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(198692);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(198692);
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
        AppMethodBeat.o(198692);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        Log.i("MicroMsg.FaceFlashManagerCamera", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(198692);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.i("MicroMsg.FaceFlashManagerCamera", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(198692);
        return;
      }
      label384:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private void djj()
  {
    AppMethodBeat.i(198657);
    if (this.wFb == null)
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "start camera thread");
      this.wFb = com.tencent.e.c.d.il("cameraBackground", 5);
      this.wFb.start();
      this.wFc = new MMHandler(this.wFb.getLooper());
    }
    AppMethodBeat.o(198657);
  }
  
  private static boolean l(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(198698);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    Log.d("MicroMsg.FaceFlashManagerCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(198698);
      return true;
    }
    AppMethodBeat.o(198698);
    return false;
  }
  
  public final void TL()
  {
    AppMethodBeat.i(198653);
    Log.i("MicroMsg.FaceFlashManagerCamera", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.wFf) });
    if ((this.wFd != null) && (!this.wFd.jtb) && (this.wFf))
    {
      Log.i("MicroMsg.FaceFlashManagerCamera", "just stopPreview");
      this.wFd.TL();
      this.wFf = false;
      com.tencent.mm.plugin.facedetect.model.c.wwx.baL();
    }
    AppMethodBeat.o(198653);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(198644);
    if (n(paramSurfaceTexture)) {
      this.wFd.b(new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(195430);
          if (paramPreviewCallback != null) {
            paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
          }
          paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
          AppMethodBeat.o(195430);
        }
      });
    }
    AppMethodBeat.o(198644);
  }
  
  public final void a(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(198651);
    if (this.wFd == null)
    {
      Log.w("MicroMsg.FaceFlashManagerCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(198651);
      return;
    }
    int j = this.mDesiredPreviewWidth * this.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(this.wFd.avd().getPreviewFormat()) / 8;
    int i = 0;
    while (i < 5)
    {
      byte[] arrayOfByte = com.tencent.mm.plugin.facedetect.model.c.wwx.k(Integer.valueOf(j));
      this.wFd.aj(arrayOfByte);
      i += 1;
    }
    this.wFd.b(new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(198479);
        if (paramPreviewCallback != null) {
          paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
        }
        paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
        AppMethodBeat.o(198479);
      }
    });
    com.tencent.mm.plugin.facedetect.model.d.dhV().a(this.wBD);
    AppMethodBeat.o(198651);
  }
  
  public final void a(MMTextureView paramMMTextureView, final a parama)
  {
    AppMethodBeat.i(198618);
    Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraForSurfaceTexture");
    this.wFa = paramMMTextureView;
    djj();
    if (this.wFc != null)
    {
      this.wFc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(189960);
          boolean bool2 = c.this.dji();
          boolean bool1 = bool2;
          h localh;
          if (!bool2)
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "reopen Camera");
            localh = h.IzE;
            if (c.this.wFn == 1)
            {
              l = 3L;
              localh.idkeyStat(917L, l, 1L, false);
              bool1 = c.this.dji();
            }
          }
          else
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "isOpenCamera：%s", new Object[] { Boolean.valueOf(bool1) });
            localh = h.IzE;
            if (c.this.wFn != 1) {
              break label144;
            }
          }
          label144:
          for (long l = 2L;; l = 38L)
          {
            localh.idkeyStat(917L, l, 1L, false);
            parama.a(Boolean.valueOf(bool1), c.this);
            AppMethodBeat.o(189960);
            return;
            l = 39L;
            break;
          }
        }
      });
      AppMethodBeat.o(198618);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
    AppMethodBeat.o(198618);
  }
  
  public final boolean a(final SurfaceTexture paramSurfaceTexture, final a parama)
  {
    AppMethodBeat.i(198648);
    Log.i("MicroMsg.FaceFlashManagerCamera", "mIsPreviewing is " + this.wFf);
    if ((this.wFd != null) && (!this.wFf))
    {
      this.wFf = true;
      this.wFc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197573);
          try
          {
            c.this.wFd.f(paramSurfaceTexture);
            com.tencent.mm.plugin.facedetect.model.c.dE(c.this.mDesiredPreviewWidth, c.this.mDesiredPreviewHeight);
            c.this.wFd.ave();
            AppMethodBeat.o(197573);
            return;
          }
          catch (IOException localIOException)
          {
            Log.i("MicroMsg.FaceFlashManagerCamera", "start Preview failed:" + localIOException.getMessage());
            c.this.wFf = false;
            if (parama != null) {
              parama.a(Boolean.FALSE, null);
            }
            AppMethodBeat.o(197573);
          }
        }
      });
      Log.i("MicroMsg.FaceFlashManagerCamera", "start preview, is previewing");
    }
    boolean bool = this.wFf;
    AppMethodBeat.o(198648);
    return bool;
  }
  
  final boolean dji()
  {
    AppMethodBeat.i(198642);
    Log.i("MicroMsg.FaceFlashManagerCamera", "start open camera");
    this.wFe = false;
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
        AppMethodBeat.o(198642);
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
      if (this.lbk == null) {
        Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraRes is null");
      }
      try
      {
        this.lbk = com.tencent.mm.compatible.deviceinfo.d.D(this.mContext, i);
        if (this.lbk == null)
        {
          Log.e("MicroMsg.FaceFlashManagerCamera", "in open(), openCameraRes == null");
          AppMethodBeat.o(198642);
          return false;
        }
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException1, "MicroMsg.FaceFlashManagerError", new Object[0]);
        AppMethodBeat.o(198642);
        return false;
      }
      this.wFj = i;
      this.wFe = true;
      Log.i("MicroMsg.FaceFlashManagerCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.wxE = this.lbk.fSM;
      if (this.lbk.fSM % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.wxD = bool;
        this.wFd = this.lbk.jqD;
        if (this.wFd != null) {
          break;
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.wxD) });
        AppMethodBeat.o(198642);
        return false;
      }
      Camera.Parameters localParameters;
      try
      {
        localParameters = this.wFd.avd();
        if (localParameters == null)
        {
          Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), parameters == null");
          AppMethodBeat.o(198642);
          return false;
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", localException2, "camera getParameters error: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(198642);
        return false;
      }
      this.sdD = new Point(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
      Point localPoint2 = this.sdD;
      Point localPoint1 = this.wxC;
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
        this.wxB = ((Point)localObject2);
        this.wxG = new Point(this.wxB);
        Log.d("MicroMsg.FaceFlashManagerCamera", "getCameraResolution: " + this.sdD + " camera:" + this.wxB + "bestVideoEncodeSize: " + this.wxG);
        this.mDesiredPreviewWidth = this.wxB.x;
        this.mDesiredPreviewHeight = this.wxB.y;
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
            if (this.wxD) {
              localParameters.setRotation(this.wxE);
            }
            Log.d("MicroMsg.FaceFlashManagerCamera", "new ratio=".concat(String.valueOf(this.mDesiredPreviewWidth / this.mDesiredPreviewHeight)));
            d(localParameters);
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
                this.wFd.c(localParameters);
                bool = this.wFe;
                AppMethodBeat.o(198642);
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
    AppMethodBeat.i(198707);
    try
    {
      Object localObject = this.wFd.avd().get("preview-size");
      Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", new Object[] { localObject });
      localObject = ((String)localObject).split("x");
      float f = Integer.parseInt(localObject[0]);
      int i = Integer.parseInt(localObject[1]);
      f = f * 1.0F / i;
      AppMethodBeat.o(198707);
      return f;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(198707);
    }
    return 1.0F;
  }
  
  public final Point getPreviewSize()
  {
    AppMethodBeat.i(198700);
    try
    {
      Object localObject = this.wFd.avd().get("preview-size");
      Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", new Object[] { localObject });
      localObject = ((String)localObject).split("x");
      this.mDesiredPreviewWidth = Integer.parseInt(localObject[0]);
      this.mDesiredPreviewHeight = Integer.parseInt(localObject[1]);
      label64:
      localObject = new Point(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
      AppMethodBeat.o(198700);
      return localObject;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  public final boolean n(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(198649);
    boolean bool = a(paramSurfaceTexture, new a()
    {
      public final void a(Boolean paramAnonymousBoolean, c paramAnonymousc) {}
    });
    AppMethodBeat.o(198649);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(198694);
    this.wFa = null;
    if (this.wFc != null)
    {
      this.wFc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197976);
          c localc = c.this;
          Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera start");
          com.tencent.mm.plugin.facedetect.model.d.dhV().b(localc.wBD);
          if (localc.wFd != null) {}
          try
          {
            if (localc.wFf)
            {
              localc.wFf = false;
              localc.wFd.TL();
              localc.wFd.a(null);
              Log.i("MicroMsg.FaceFlashManagerCamera", "stop preview, not previewing");
            }
            try
            {
              localc.wFd.a(null);
              localc.wFd.release();
              localc.wFd = null;
              localc.wFd = null;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.i("MicroMsg.FaceFlashManagerCamera", "Error setting camera preview: " + localException2.getMessage());
                localc.wFd = null;
              }
            }
            finally
            {
              localc.wFd = null;
              AppMethodBeat.o(197976);
            }
            Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera end");
            localc = c.this;
            if (localc.wFb == null)
            {
              AppMethodBeat.o(197976);
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
          if (localc.wFc != null) {
            localc.wFc.removeCallbacksAndMessages(null);
          }
          Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread");
          if (Build.VERSION.SDK_INT >= 18) {
            localc.wFb.quitSafely();
          }
          for (;;)
          {
            localc.wFb = null;
            localc.wFc = null;
            localc.mContext = null;
            Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread finish");
            AppMethodBeat.o(197976);
            return;
            localc.wFb.quit();
          }
        }
      });
      AppMethodBeat.o(198694);
      return;
    }
    Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
    AppMethodBeat.o(198694);
  }
  
  public static abstract interface a
  {
    public abstract void a(Boolean paramBoolean, c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.c
 * JD-Core Version:    0.7.0.1
 */