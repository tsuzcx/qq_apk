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
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class n
{
  private Context context;
  public v gGr;
  private boolean imf = true;
  public boolean jyo = false;
  public Point pbD = null;
  public boolean sRE = false;
  public Point sRF = null;
  private Point sRG = null;
  private boolean sRH;
  public int sRI;
  private boolean sRJ = false;
  public Point sRK = null;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(103778);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new n.a((byte)0));
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
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!k(k, m, l))) {
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
        if ((f2 >= f1) || (!k(i, j, l))) {
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
  
  private static boolean k(int paramInt1, int paramInt2, long paramLong)
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
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(103777);
    Log.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[] { Integer.valueOf(this.sRF.y) });
    int i = this.sRF.y;
    AppMethodBeat.o(103777);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(103776);
    Log.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[] { Integer.valueOf(this.sRF.x) });
    int i = this.sRF.x;
    AppMethodBeat.o(103776);
    return i;
  }
  
  public final void i(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(103774);
    if (this.sRE)
    {
      Log.w("MicroMsg.FaceScanCamera", "in open(), previewing");
      release();
    }
    this.imf = true;
    Object localObject = a.gDs;
    int j = a.anJ();
    int i = 0;
    if (i < j)
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if ((((Camera.CameraInfo)localObject).facing == 1) && (this.imf)) {
        Log.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
      }
    }
    for (;;)
    {
      long l = Util.currentTicks();
      localObject = d.a(this.context, i, null);
      if (localObject == null)
      {
        Log.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
        if ((((Camera.CameraInfo)localObject).facing == 0) && (!this.imf))
        {
          Log.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      this.jyo = true;
      Log.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
      this.sRI = ((d.a.a)localObject).dYT;
      if (((d.a.a)localObject).dYT % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.sRH = bool;
        this.gGr = ((d.a.a)localObject).gGr;
        if (this.gGr != null) {
          break;
        }
        Log.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.sRH) });
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
      }
      this.gGr.setPreviewTexture(paramSurfaceTexture);
      Camera.Parameters localParameters = this.gGr.getParameters();
      Point localPoint2 = this.pbD;
      Point localPoint1 = this.sRG;
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
        this.sRF = ((Point)localObject);
        this.sRK = new Point(this.sRF);
        Log.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.pbD + " camera:" + this.sRF + "bestVideoEncodeSize: " + this.sRK);
        localParameters.setPreviewSize(this.sRF.x, this.sRF.y);
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
              break label765;
            }
            j = ((Integer)((Iterator)localObject).next()).intValue();
            Log.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            label611:
            if (j == 0) {
              break label699;
            }
            localParameters.setPreviewFormat(17);
            label622:
            if (this.sRH) {
              localParameters.setRotation(this.sRI);
            }
            this.gGr.setParameters(localParameters);
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
            label699:
            if (i != 0)
            {
              Log.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
              localParameters.setPreviewFormat(842094169);
              break label622;
            }
            Log.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { paramSurfaceTexture.get(0) });
            localParameters.setPreviewFormat(((Integer)paramSurfaceTexture.get(0)).intValue());
            break label622;
            label765:
            j = 0;
            break label611;
          }
        }
      }
      i = -1;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(103775);
    Log.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.sRE) });
    if (this.gGr != null)
    {
      long l = Util.currentTicks();
      if (this.sRE)
      {
        this.gGr.setPreviewCallback(null);
        this.gGr.stopPreview();
        this.sRE = false;
        Log.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      l = Util.currentTicks();
      this.gGr.release();
      this.gGr = null;
      this.jyo = false;
      Log.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    this.sRJ = false;
    AppMethodBeat.o(103775);
  }
  
  public final void setPreviewCallback(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(103780);
    if (this.gGr == null)
    {
      Log.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(103780);
      return;
    }
    try
    {
      int i = getPreviewWidth() * getPreviewHeight() * ImageFormat.getBitsPerPixel(this.gGr.getParameters().getPreviewFormat()) / 8;
      byte[] arrayOfByte = c.sQB.h(Integer.valueOf(i));
      this.gGr.addCallbackBuffer(arrayOfByte);
      this.gGr.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.n
 * JD-Core Version:    0.7.0.1
 */