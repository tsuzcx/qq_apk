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
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class n
{
  private Context context;
  public u eoH;
  private boolean isFrontCamera = true;
  public boolean miS = false;
  public Point miT = null;
  public Point miU = null;
  private Point miV = null;
  private boolean miW;
  public int miX;
  private boolean miY = false;
  public boolean miZ = false;
  public Point mja = null;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(257);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new n.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    ab.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bo.hg(ah.getContext());
    ab.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
    int i = paramPoint.x;
    i = paramPoint.y;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int j;
    label241:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      ab.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 983040))
      {
        if (i > j)
        {
          m = 1;
          if (m == 0) {
            break label347;
          }
          k = j;
          if (m == 0) {
            break label354;
          }
        }
        label347:
        label354:
        for (int m = i;; m = j)
        {
          ab.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!g(k, m, l))) {
            break label361;
          }
          paramParameters = new Point(i, j);
          ab.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(257);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label241;
        }
        label361:
        f2 = Math.abs(k / m - f3);
        if ((f2 >= f1) || (!g(i, j, l))) {
          break label534;
        }
        localPoint = new Point(i, j);
        f1 = f2;
      }
    }
    label521:
    label534:
    for (;;)
    {
      ab.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label521;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ab.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        ab.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(257);
        return paramPoint;
        ab.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static boolean g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(258);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    ab.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(258);
      return true;
    }
    AppMethodBeat.o(258);
    return false;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(256);
    ab.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[] { Integer.valueOf(this.miT.y) });
    int i = this.miT.y;
    AppMethodBeat.o(256);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(255);
    ab.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[] { Integer.valueOf(this.miT.x) });
    int i = this.miT.x;
    AppMethodBeat.o(255);
    return i;
  }
  
  public final void h(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(253);
    if (this.miS)
    {
      ab.w("MicroMsg.FaceScanCamera", "in open(), previewing");
      release();
    }
    this.isFrontCamera = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if ((((Camera.CameraInfo)localObject).facing == 1) && (this.isFrontCamera)) {
        ab.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
      }
    }
    for (;;)
    {
      long l = bo.yB();
      localObject = d.a(this.context, i, null);
      if (localObject == null)
      {
        ab.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(253);
        throw paramSurfaceTexture;
        if ((((Camera.CameraInfo)localObject).facing == 0) && (!this.isFrontCamera))
        {
          ab.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      this.miZ = true;
      ab.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bo.av(l)) });
      this.miX = ((d.a.a)localObject).rotate;
      if (((d.a.a)localObject).rotate % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.miW = bool;
        this.eoH = ((d.a.a)localObject).eoH;
        if (this.eoH != null) {
          break;
        }
        ab.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.miW) });
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(253);
        throw paramSurfaceTexture;
      }
      this.eoH.setPreviewTexture(paramSurfaceTexture);
      Camera.Parameters localParameters = this.eoH.getParameters();
      Point localPoint2 = this.miU;
      Point localPoint1 = this.miV;
      localObject = localParameters.get("preview-size-values");
      if (localObject == null) {
        localObject = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        paramSurfaceTexture = null;
        if (localObject != null)
        {
          ab.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: ".concat(String.valueOf(localObject)));
          paramSurfaceTexture = a(localParameters, localPoint2);
        }
        localObject = paramSurfaceTexture;
        if (paramSurfaceTexture == null) {
          localObject = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.miT = ((Point)localObject);
        this.mja = new Point(this.miT);
        ab.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.miU + " camera:" + this.miT + "bestVideoEncodeSize: " + this.mja);
        localParameters.setPreviewSize(this.miT.x, this.miT.y);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            ab.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            paramSurfaceTexture = localParameters.getSupportedPreviewFormats();
            localObject = paramSurfaceTexture.iterator();
            i = 0;
            if (!((Iterator)localObject).hasNext()) {
              break label762;
            }
            j = ((Integer)((Iterator)localObject).next()).intValue();
            ab.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            label607:
            if (j == 0) {
              break label696;
            }
            localParameters.setPreviewFormat(17);
            label618:
            if (this.miW) {
              localParameters.setRotation(this.miX);
            }
            this.eoH.setParameters(localParameters);
            AppMethodBeat.o(253);
            return;
            ab.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            ab.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
          if (j == 842094169) {
            i = 1;
          }
          for (;;)
          {
            break;
            label696:
            if (i != 0)
            {
              ab.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
              localParameters.setPreviewFormat(842094169);
              break label618;
            }
            ab.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { paramSurfaceTexture.get(0) });
            localParameters.setPreviewFormat(((Integer)paramSurfaceTexture.get(0)).intValue());
            break label618;
            label762:
            j = 0;
            break label607;
          }
        }
      }
      i = -1;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(254);
    ab.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.miS) });
    if (this.eoH != null)
    {
      long l = bo.yB();
      if (this.miS)
      {
        this.eoH.setPreviewCallback(null);
        this.eoH.stopPreview();
        this.miS = false;
        ab.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(bo.av(l)) });
      }
      l = bo.yB();
      this.eoH.release();
      this.eoH = null;
      this.miZ = false;
      ab.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(bo.av(l)) });
    }
    this.miY = false;
    AppMethodBeat.o(254);
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(259);
    if (this.eoH == null)
    {
      ab.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(259);
      return;
    }
    try
    {
      int i = getPreviewWidth() * getPreviewHeight() * ImageFormat.getBitsPerPixel(this.eoH.getParameters().getPreviewFormat()) / 8;
      byte[] arrayOfByte = c.mhN.f(Integer.valueOf(i));
      this.eoH.addCallbackBuffer(arrayOfByte);
      this.eoH.setPreviewCallbackWithBuffer(new n.1(this, paramPreviewCallback));
      AppMethodBeat.o(259);
      return;
    }
    catch (Exception paramPreviewCallback)
    {
      ab.printErrStackTrace("MicroMsg.FaceScanCamera", paramPreviewCallback, "setPreviewCallback error: %s", new Object[] { paramPreviewCallback.getMessage() });
      AppMethodBeat.o(259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.n
 * JD-Core Version:    0.7.0.1
 */