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
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class m
{
  private Context context;
  public Camera dwJ;
  private boolean isFrontCamera = true;
  public boolean jOC = false;
  public Point jOD = null;
  public Point jOE = null;
  private Point jOF = null;
  private boolean jOG;
  public int jOH;
  private boolean jOI = false;
  public boolean jOJ = false;
  public Point jOK = null;
  
  public m(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    y.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bk.fQ(ae.getContext());
    y.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
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
      y.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          y.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!f(k, m, l))) {
            break label356;
          }
          paramParameters = new Point(i, j);
          y.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: " + paramParameters);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label235;
        }
        label356:
        f2 = Math.abs(k / m - f3);
        if ((f2 >= f1) || (!f(i, j, l))) {
          break label537;
        }
        localPoint = new Point(i, j);
        f1 = f2;
      }
    }
    label524:
    label537:
    for (;;)
    {
      y.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label524;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        y.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: " + paramPoint);
      }
      for (;;)
      {
        y.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: " + paramPoint);
        return paramPoint;
        y.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static boolean f(int paramInt1, int paramInt2, long paramLong)
  {
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    y.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    return paramLong / d >= 5.0D;
  }
  
  public final int getPreviewHeight()
  {
    y.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[] { Integer.valueOf(this.jOD.y) });
    return this.jOD.y;
  }
  
  public final int getPreviewWidth()
  {
    y.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[] { Integer.valueOf(this.jOD.x) });
    return this.jOD.x;
  }
  
  public final void h(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jOC)
    {
      y.w("MicroMsg.FaceScanCamera", "in open(), previewing");
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
        y.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
      }
    }
    for (;;)
    {
      long l = bk.UZ();
      localObject = d.u(this.context, i);
      if (localObject == null)
      {
        y.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
        throw new IOException();
        if ((((Camera.CameraInfo)localObject).facing == 0) && (!this.isFrontCamera))
        {
          y.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      this.jOJ = true;
      y.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
      this.jOH = ((d.a.a)localObject).rotate;
      if (((d.a.a)localObject).rotate % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jOG = bool;
        this.dwJ = ((d.a.a)localObject).dwJ;
        if (this.dwJ != null) {
          break;
        }
        y.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.jOG) });
        throw new IOException();
      }
      this.dwJ.setPreviewTexture(paramSurfaceTexture);
      Camera.Parameters localParameters = this.dwJ.getParameters();
      Point localPoint2 = this.jOE;
      Point localPoint1 = this.jOF;
      localObject = localParameters.get("preview-size-values");
      if (localObject == null) {
        localObject = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        paramSurfaceTexture = null;
        if (localObject != null)
        {
          y.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: " + (String)localObject);
          paramSurfaceTexture = a(localParameters, localPoint2);
        }
        localObject = paramSurfaceTexture;
        if (paramSurfaceTexture == null) {
          localObject = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.jOD = ((Point)localObject);
        this.jOK = new Point(this.jOD);
        y.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.jOE + " camera:" + this.jOD + "bestVideoEncodeSize: " + this.jOK);
        localParameters.setPreviewSize(this.jOD.x, this.jOD.y);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            y.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            paramSurfaceTexture = localParameters.getSupportedPreviewFormats();
            localObject = paramSurfaceTexture.iterator();
            i = 0;
            if (!((Iterator)localObject).hasNext()) {
              break label747;
            }
            j = ((Integer)((Iterator)localObject).next()).intValue();
            y.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + j);
            if (j != 17) {
              break;
            }
            j = 1;
            label598:
            if (j == 0) {
              break label681;
            }
            localParameters.setPreviewFormat(17);
            label609:
            if (this.jOG) {
              localParameters.setRotation(this.jOH);
            }
            this.dwJ.setParameters(localParameters);
            return;
            y.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            y.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
          if (j == 842094169) {
            i = 1;
          }
          for (;;)
          {
            break;
            label681:
            if (i != 0)
            {
              y.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
              localParameters.setPreviewFormat(842094169);
              break label609;
            }
            y.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { paramSurfaceTexture.get(0) });
            localParameters.setPreviewFormat(((Integer)paramSurfaceTexture.get(0)).intValue());
            break label609;
            label747:
            j = 0;
            break label598;
          }
        }
      }
      i = -1;
    }
  }
  
  public final void release()
  {
    y.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.jOC) });
    if (this.dwJ != null)
    {
      long l = bk.UZ();
      if (this.jOC)
      {
        this.dwJ.setPreviewCallback(null);
        this.dwJ.stopPreview();
        this.jOC = false;
        y.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(bk.cp(l)) });
      }
      l = bk.UZ();
      this.dwJ.release();
      this.dwJ = null;
      this.jOJ = false;
      y.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(bk.cp(l)) });
    }
    this.jOI = false;
  }
  
  public final void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    if (this.dwJ == null)
    {
      y.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
      return;
    }
    int i = getPreviewWidth() * getPreviewHeight() * ImageFormat.getBitsPerPixel(this.dwJ.getParameters().getPreviewFormat()) / 8;
    byte[] arrayOfByte = c.jNB.f(Integer.valueOf(i));
    this.dwJ.addCallbackBuffer(arrayOfByte);
    this.dwJ.setPreviewCallbackWithBuffer(new m.1(this, paramPreviewCallback));
  }
  
  private static final class a
    implements Comparator<Camera.Size>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.m
 * JD-Core Version:    0.7.0.1
 */