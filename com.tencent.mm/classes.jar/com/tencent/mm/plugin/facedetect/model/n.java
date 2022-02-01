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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class n
{
  private Context context;
  public v fBM;
  private boolean gwO = true;
  public boolean hGj = false;
  public Point mII = null;
  public boolean pPF = false;
  public Point pPG = null;
  private Point pPH = null;
  private boolean pPI;
  public int pPJ;
  private boolean pPK = false;
  public Point pPL = null;
  
  public n(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(103778);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    ad.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bt.iJ(aj.getContext());
    ad.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
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
      ad.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
          ad.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!i(k, m, l))) {
            break label359;
          }
          paramParameters = new Point(i, j);
          ad.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
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
      ad.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label518;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ad.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        ad.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(103778);
        return paramPoint;
        ad.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  private static boolean i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(103779);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    ad.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
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
    ad.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[] { Integer.valueOf(this.pPG.y) });
    int i = this.pPG.y;
    AppMethodBeat.o(103777);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(103776);
    ad.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[] { Integer.valueOf(this.pPG.x) });
    int i = this.pPG.x;
    AppMethodBeat.o(103776);
    return i;
  }
  
  public final void i(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(103774);
    if (this.pPF)
    {
      ad.w("MicroMsg.FaceScanCamera", "in open(), previewing");
      release();
    }
    this.gwO = true;
    int j = Camera.getNumberOfCameras();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if ((((Camera.CameraInfo)localObject).facing == 1) && (this.gwO)) {
        ad.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
      }
    }
    for (;;)
    {
      long l = bt.GC();
      localObject = d.a(this.context, i, null);
      if (localObject == null)
      {
        ad.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
        if ((((Camera.CameraInfo)localObject).facing == 0) && (!this.gwO))
        {
          ad.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
          continue;
        }
        i += 1;
        break;
      }
      this.hGj = true;
      ad.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bt.aS(l)) });
      this.pPJ = ((d.a.a)localObject).dwp;
      if (((d.a.a)localObject).dwp % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.pPI = bool;
        this.fBM = ((d.a.a)localObject).fBM;
        if (this.fBM != null) {
          break;
        }
        ad.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.pPI) });
        paramSurfaceTexture = new IOException();
        AppMethodBeat.o(103774);
        throw paramSurfaceTexture;
      }
      this.fBM.setPreviewTexture(paramSurfaceTexture);
      Camera.Parameters localParameters = this.fBM.getParameters();
      Point localPoint2 = this.mII;
      Point localPoint1 = this.pPH;
      localObject = localParameters.get("preview-size-values");
      if (localObject == null) {
        localObject = localParameters.get("preview-size-value");
      }
      for (;;)
      {
        paramSurfaceTexture = null;
        if (localObject != null)
        {
          ad.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: ".concat(String.valueOf(localObject)));
          paramSurfaceTexture = a(localParameters, localPoint2);
        }
        localObject = paramSurfaceTexture;
        if (paramSurfaceTexture == null) {
          localObject = new Point(localPoint1.x >> 3 << 3, localPoint1.y >> 3 << 3);
        }
        this.pPG = ((Point)localObject);
        this.pPL = new Point(this.pPG);
        ad.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.mII + " camera:" + this.pPG + "bestVideoEncodeSize: " + this.pPL);
        localParameters.setPreviewSize(this.pPG.x, this.pPG.y);
        localParameters.setZoom(0);
        localParameters.setSceneMode("auto");
        try
        {
          if ((localParameters.getSupportedFocusModes() != null) && (localParameters.getSupportedFocusModes().contains("auto")))
          {
            ad.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
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
            ad.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(j)));
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
            if (this.pPI) {
              localParameters.setRotation(this.pPJ);
            }
            this.fBM.setParameters(localParameters);
            AppMethodBeat.o(103774);
            return;
            ad.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            ad.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[] { paramSurfaceTexture.getMessage() });
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
              ad.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
              localParameters.setPreviewFormat(842094169);
              break label617;
            }
            ad.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[] { paramSurfaceTexture.get(0) });
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
    ad.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.pPF) });
    if (this.fBM != null)
    {
      long l = bt.GC();
      if (this.pPF)
      {
        this.fBM.setPreviewCallback(null);
        this.fBM.stopPreview();
        this.pPF = false;
        ad.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(bt.aS(l)) });
      }
      l = bt.GC();
      this.fBM.release();
      this.fBM = null;
      this.hGj = false;
      ad.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(bt.aS(l)) });
    }
    this.pPK = false;
    AppMethodBeat.o(103775);
  }
  
  public final void setPreviewCallback(final Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(103780);
    if (this.fBM == null)
    {
      ad.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
      AppMethodBeat.o(103780);
      return;
    }
    try
    {
      int i = getPreviewWidth() * getPreviewHeight() * ImageFormat.getBitsPerPixel(this.fBM.getParameters().getPreviewFormat()) / 8;
      byte[] arrayOfByte = c.pOB.g(Integer.valueOf(i));
      this.fBM.addCallbackBuffer(arrayOfByte);
      this.fBM.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
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
      ad.printErrStackTrace("MicroMsg.FaceScanCamera", paramPreviewCallback, "setPreviewCallback error: %s", new Object[] { paramPreviewCallback.getMessage() });
      AppMethodBeat.o(103780);
    }
  }
  
  static final class a
    implements Comparator<Camera.Size>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.n
 * JD-Core Version:    0.7.0.1
 */