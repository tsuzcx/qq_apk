package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private Context context;
  private boolean isFrontCamera = true;
  public w lTN;
  public boolean phG = false;
  public Point vpf = null;
  public boolean zTG = false;
  public Point zTH = null;
  private Point zTI = null;
  private boolean zTJ;
  public int zTK;
  private boolean zTL = false;
  public Point zTM = null;
  
  public j(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(103778);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new j.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    Log.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = Util.getAvailableMemoryMB(MMApplicationContext.getContext());
    Log.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
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
      Log.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          Log.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!m(k, m, l))) {
            break label359;
          }
          paramParameters = new Point(i, j);
          Log.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(103778);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label240;
        }
        label359:
        f2 = Math.abs(k / m - f3);
        if ((f2 >= f1) || (!m(i, j, l))) {
          break label531;
        }
        localPoint = new Point(i, j);
        f1 = f2;
      }
    }
    label518:
    label531:
    for (;;)
    {
      Log.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label518;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        Log.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        Log.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(103778);
        return paramPoint;
        Log.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static boolean m(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(103779);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    Log.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(103779);
      return true;
    }
    AppMethodBeat.o(103779);
    return false;
  }
  
  public final void a(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(103780);
    if (this.lTN == null)
    {
      Log.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(103780);
      return;
    }
    try
    {
      int i = getPreviewWidth() * getPreviewHeight() * ImageFormat.getBitsPerPixel(this.lTN.aPy().getPreviewFormat()) / 8;
      byte[] arrayOfByte = c.zSD.m(Integer.valueOf(i));
      this.lTN.aj(arrayOfByte);
      this.lTN.b(new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(103773);
          if (paramPreviewCallback != null) {
            paramPreviewCallback.onPreviewFrame(paramAnonymousArrayOfByte, paramAnonymousCamera);
          }
          paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
          AppMethodBeat.o(103773);
        }
      });
      AppMethodBeat.o(103780);
      return;
    }
    catch (Exception paramPreviewCallback)
    {
      Log.printErrStackTrace("MicroMsg.FaceScanCamera", paramPreviewCallback, "setPreviewCallback error: %s", new Object[] { paramPreviewCallback.getMessage() });
      AppMethodBeat.o(103780);
    }
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(103777);
    Log.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[] { Integer.valueOf(this.zTH.y) });
    int i = this.zTH.y;
    AppMethodBeat.o(103777);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(103776);
    Log.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[] { Integer.valueOf(this.zTH.x) });
    int i = this.zTH.x;
    AppMethodBeat.o(103776);
    return i;
  }
  
  public final void i(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(103774);
    if (this.zTG)
    {
      Log.w("MicroMsg.FaceScanCamera", "in open(), previewing");
      release();
    }
    this.isFrontCamera = true;
    Object localObject = a.lQF;
    int j = a.aOk();
    int i = 0;
    if (i < j)
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if ((((Camera.CameraInfo)localObject).facing == 1) && (this.isFrontCamera)) {
        Log.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
      }
    }
    for (;;)
    {
      long l = Util.currentTicks();
      localObject = d.G(this.context, i);
      if (localObject == null)
      {
        Log.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
        if ((((Camera.CameraInfo)localObject).facing == 0) && (!this.isFrontCamera))
        {
          Log.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      this.phG = true;
      Log.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.zTK = ((d.a.a)localObject).hYK;
      if (((d.a.a)localObject).hYK % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.zTJ = bool;
        this.lTN = ((d.a.a)localObject).lTN;
        if (this.lTN != null) {
          break;
        }
        Log.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.zTJ) });
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
      }
      this.lTN.f(paramSurfaceTexture);
      Camera.Parameters localParameters = this.lTN.aPy();
      Point localPoint2 = this.vpf;
      Point localPoint1 = this.zTI;
      localObject = localParameters.get("preview-size-values");
      if (localObject == null) {
        localObject = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        paramSurfaceTexture = null;
        if (localObject != null)
        {
          Log.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: ".concat(String.valueOf(localObject)));
          paramSurfaceTexture = a(localParameters, localPoint2);
        }
        localObject = paramSurfaceTexture;
        if (paramSurfaceTexture == null) {
          localObject = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.zTH = ((Point)localObject);
        this.zTM = new Point(this.zTH);
        Log.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.vpf + " camera:" + this.zTH + "bestVideoEncodeSize: " + this.zTM);
        localParameters.setPreviewSize(this.zTH.x, this.zTH.y);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            Log.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            paramSurfaceTexture = localParameters.getSupportedPreviewFormats();
            localObject = paramSurfaceTexture.iterator();
            i = 0;
            if (!((Iterator)localObject).hasNext()) {
              break label769;
            }
            j = ((Integer)((Iterator)localObject).next()).intValue();
            Log.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            label614:
            if (j == 0) {
              break label703;
            }
            localParameters.setPreviewFormat(17);
            label625:
            if (this.zTJ) {
              localParameters.setRotation(this.zTK);
            }
            this.lTN.c(localParameters);
            AppMethodBeat.o(103774);
            return;
            Log.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            Log.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
          if (j == 842094169) {
            i = 1;
          }
          for (;;)
          {
            break;
            label703:
            if (i != 0)
            {
              Log.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
              localParameters.setPreviewFormat(842094169);
              break label625;
            }
            Log.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { paramSurfaceTexture.get(0) });
            localParameters.setPreviewFormat(((Integer)paramSurfaceTexture.get(0)).intValue());
            break label625;
            label769:
            j = 0;
            break label614;
          }
        }
      }
      i = -1;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(103775);
    Log.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.zTG) });
    if (this.lTN != null)
    {
      long l = Util.currentTicks();
      if (this.zTG)
      {
        this.lTN.a(null);
        this.lTN.auq();
        this.zTG = false;
        Log.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      l = Util.currentTicks();
      this.lTN.release();
      this.lTN = null;
      this.phG = false;
      Log.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    this.zTL = false;
    AppMethodBeat.o(103775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.j
 * JD-Core Version:    0.7.0.1
 */