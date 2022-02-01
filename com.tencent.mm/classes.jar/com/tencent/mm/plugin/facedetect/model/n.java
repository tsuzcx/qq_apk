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
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class n
{
  private Context context;
  public v fFt;
  private boolean gXl = true;
  public boolean igL = false;
  public Point nkL = null;
  public boolean qyn = false;
  public Point qyo = null;
  private Point qyp = null;
  private boolean qyq;
  public int qyr;
  private boolean qys = false;
  public Point qyt = null;
  
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
    ac.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bs.iU(ai.getContext());
    ac.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
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
      ac.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          ac.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!i(k, m, l))) {
            break label359;
          }
          paramParameters = new Point(i, j);
          ac.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(103778);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label240;
        }
        label359:
        f2 = Math.abs(k / m - f3);
        if ((f2 >= f1) || (!i(i, j, l))) {
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
      ac.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label518;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ac.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        ac.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(103778);
        return paramPoint;
        ac.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static boolean i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(103779);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    ac.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
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
    ac.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[] { Integer.valueOf(this.qyo.y) });
    int i = this.qyo.y;
    AppMethodBeat.o(103777);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(103776);
    ac.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[] { Integer.valueOf(this.qyo.x) });
    int i = this.qyo.x;
    AppMethodBeat.o(103776);
    return i;
  }
  
  public final void i(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(103774);
    if (this.qyn)
    {
      ac.w("MicroMsg.FaceScanCamera", "in open(), previewing");
      release();
    }
    this.gXl = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if ((((Camera.CameraInfo)localObject).facing == 1) && (this.gXl)) {
        ac.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
      }
    }
    for (;;)
    {
      long l = bs.Gn();
      localObject = d.a(this.context, i, null);
      if (localObject == null)
      {
        ac.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
        if ((((Camera.CameraInfo)localObject).facing == 0) && (!this.gXl))
        {
          ac.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      this.igL = true;
      ac.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bs.aO(l)) });
      this.qyr = ((d.a.a)localObject).duc;
      if (((d.a.a)localObject).duc % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.qyq = bool;
        this.fFt = ((d.a.a)localObject).fFt;
        if (this.fFt != null) {
          break;
        }
        ac.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.qyq) });
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
      }
      this.fFt.setPreviewTexture(paramSurfaceTexture);
      Camera.Parameters localParameters = this.fFt.getParameters();
      Point localPoint2 = this.nkL;
      Point localPoint1 = this.qyp;
      localObject = localParameters.get("preview-size-values");
      if (localObject == null) {
        localObject = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        paramSurfaceTexture = null;
        if (localObject != null)
        {
          ac.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: ".concat(String.valueOf(localObject)));
          paramSurfaceTexture = a(localParameters, localPoint2);
        }
        localObject = paramSurfaceTexture;
        if (paramSurfaceTexture == null) {
          localObject = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.qyo = ((Point)localObject);
        this.qyt = new Point(this.qyo);
        ac.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.nkL + " camera:" + this.qyo + "bestVideoEncodeSize: " + this.qyt);
        localParameters.setPreviewSize(this.qyo.x, this.qyo.y);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            ac.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            paramSurfaceTexture = localParameters.getSupportedPreviewFormats();
            localObject = paramSurfaceTexture.iterator();
            i = 0;
            if (!((Iterator)localObject).hasNext()) {
              break label760;
            }
            j = ((Integer)((Iterator)localObject).next()).intValue();
            ac.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
            if (j != 17) {
              break;
            }
            j = 1;
            label606:
            if (j == 0) {
              break label694;
            }
            localParameters.setPreviewFormat(17);
            label617:
            if (this.qyq) {
              localParameters.setRotation(this.qyr);
            }
            this.fFt.setParameters(localParameters);
            AppMethodBeat.o(103774);
            return;
            ac.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            ac.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
          if (j == 842094169) {
            i = 1;
          }
          for (;;)
          {
            break;
            label694:
            if (i != 0)
            {
              ac.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
              localParameters.setPreviewFormat(842094169);
              break label617;
            }
            ac.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { paramSurfaceTexture.get(0) });
            localParameters.setPreviewFormat(((Integer)paramSurfaceTexture.get(0)).intValue());
            break label617;
            label760:
            j = 0;
            break label606;
          }
        }
      }
      i = -1;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(103775);
    ac.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.qyn) });
    if (this.fFt != null)
    {
      long l = bs.Gn();
      if (this.qyn)
      {
        this.fFt.setPreviewCallback(null);
        this.fFt.stopPreview();
        this.qyn = false;
        ac.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(bs.aO(l)) });
      }
      l = bs.Gn();
      this.fFt.release();
      this.fFt = null;
      this.igL = false;
      ac.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(bs.aO(l)) });
    }
    this.qys = false;
    AppMethodBeat.o(103775);
  }
  
  public final void setPreviewCallback(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(103780);
    if (this.fFt == null)
    {
      ac.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(103780);
      return;
    }
    try
    {
      int i = getPreviewWidth() * getPreviewHeight() * ImageFormat.getBitsPerPixel(this.fFt.getParameters().getPreviewFormat()) / 8;
      byte[] arrayOfByte = c.qxj.g(Integer.valueOf(i));
      this.fFt.addCallbackBuffer(arrayOfByte);
      this.fFt.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
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
      ac.printErrStackTrace("MicroMsg.FaceScanCamera", paramPreviewCallback, "setPreviewCallback error: %s", new Object[] { paramPreviewCallback.getMessage() });
      AppMethodBeat.o(103780);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.n
 * JD-Core Version:    0.7.0.1
 */