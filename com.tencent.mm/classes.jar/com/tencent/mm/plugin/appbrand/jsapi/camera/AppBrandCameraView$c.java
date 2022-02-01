package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.QbarNative.QBarPoint;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrandCameraView$c
  implements AppBrandCameraView.a, c.a
{
  private int duration;
  private float ilP;
  private Point kyC;
  private c lPQ;
  AtomicBoolean lPR;
  private int lPS;
  private Rect lPT;
  private int lPU;
  int lPV;
  private int lPW;
  private int previewHeight;
  private int previewWidth;
  
  protected AppBrandCameraView$c(AppBrandCameraView paramAppBrandCameraView)
  {
    AppMethodBeat.i(46171);
    this.lPR = new AtomicBoolean(false);
    this.lPS = 200;
    this.duration = this.lPS;
    this.ilP = (AppBrandCameraView.G(this.lPL) * 1.0F / AppBrandCameraView.H(this.lPL));
    if (AppBrandCameraView.I(this.lPL)) {
      i = 1;
    }
    this.lPV = i;
    AppMethodBeat.o(46171);
  }
  
  public final void C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(46173);
    int i;
    int k;
    label132:
    float f2;
    if ((this.previewWidth != AppBrandCameraView.G(this.lPL)) || (this.previewHeight != AppBrandCameraView.H(this.lPL))) {
      switch (AppBrandCameraView.L(this.lPL).getDefaultDisplay().getRotation())
      {
      default: 
        i = 0;
        k = AppBrandCameraView.i(this.lPL).getCameraRotation();
        if ("front".equals(AppBrandCameraView.M(this.lPL)))
        {
          this.lPU = (k % 360);
          this.lPU = ((360 - this.lPU) % 360);
          if (AppBrandCameraView.i(this.lPL) != null)
          {
            this.previewWidth = AppBrandCameraView.G(this.lPL);
            this.previewHeight = AppBrandCameraView.H(this.lPL);
          }
          AppBrandCameraView.G(this.lPL);
          AppBrandCameraView.H(this.lPL);
          k = this.lPU;
          f2 = this.ilP;
          if ((paramInt1 > 0) && (paramInt2 > 0)) {
            break label323;
          }
          localObject = null;
          label203:
          this.kyC = ((Point)localObject);
          if (this.kyC != null)
          {
            localObject = AppBrandCameraView.K(this.lPL);
            i = AppBrandCameraView.G(this.lPL);
            j = this.kyC.x;
            if (localObject != null) {
              break label508;
            }
          }
        }
        break;
      }
    }
    label323:
    float f1;
    for (Object localObject = null;; localObject = new Rect(Math.round(((Rect)localObject).left / f1), Math.round(((Rect)localObject).top / f1), Math.round(((Rect)localObject).right / f1), Math.round(((Rect)localObject).bottom / f1)))
    {
      this.lPT = ((Rect)localObject);
      if (!this.lPR.get()) {
        break label579;
      }
      Log.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
      AppMethodBeat.o(46173);
      return;
      i = 90;
      break;
      i = 180;
      break;
      i = 270;
      break;
      this.lPU = ((k - i + 360) % 360);
      break label132;
      if (k != 90)
      {
        f1 = f2;
        if (k != 270) {}
      }
      else
      {
        f1 = 1.0F / f2;
      }
      i = j;
      if (paramInt2 * f1 < paramInt1) {
        i = 1;
      }
      f1 = 1.0F / f1;
      if (i == 0)
      {
        this.lPV = 1;
        i = Math.max(paramInt2, paramInt1);
        j = (int)(f1 * i);
        if ((k == 90) || (k == 270))
        {
          localObject = new Point(j, i);
          break label203;
        }
        localObject = new Point(i, j);
        break label203;
      }
      i = Math.min(paramInt2, paramInt1);
      j = (int)(i / f1);
      if ((k == 90) || (k == 270))
      {
        localObject = new Point(i, j);
        break label203;
      }
      localObject = new Point(j, i);
      break label203;
      label508:
      f1 = i * 1.0F / j;
    }
    label579:
    if ((this.lPQ != null) && (AppBrandCameraView.i(this.lPL) != null)) {
      this.lPQ.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.G(this.lPL), AppBrandCameraView.H(this.lPL), this.kyC, this.lPT, this.lPU, this.lPV);
    }
    AppMethodBeat.o(46173);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(226722);
    if (this.lPR.compareAndSet(false, true))
    {
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46170);
          AppBrandCameraView.c.this.lPR.set(false);
          AppMethodBeat.o(46170);
        }
      }, this.duration);
      Log.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramQBarPoint != null) && (this.lPW % 4 == 0))
      {
        Log.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
        this.lPW += 1;
      }
    }
    switch (paramInt1)
    {
    default: 
      Log.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
      AppMethodBeat.o(226722);
      return;
    case 1: 
      j.a(AppBrandCameraView.g(this.lPL), this.lPL.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(226722);
      return;
    }
    j.a(AppBrandCameraView.g(this.lPL), this.lPL.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
    AppMethodBeat.o(226722);
  }
  
  public final void bFK()
  {
    AppMethodBeat.i(46175);
    Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
    AppMethodBeat.o(46175);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(46176);
    Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
    AppMethodBeat.o(46176);
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(46177);
    Log.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
    AppMethodBeat.o(46177);
  }
  
  public void init()
  {
    AppMethodBeat.i(46172);
    this.lPQ = new d();
    this.lPQ.init();
    this.lPQ.lQL = this;
    AppBrandCameraView.a(this.lPL, 4);
    if (AppBrandCameraView.J(this.lPL) > 0) {
      this.duration = (1000 / AppBrandCameraView.J(this.lPL));
    }
    this.lPW = 0;
    AppMethodBeat.o(46172);
  }
  
  public final void release()
  {
    AppMethodBeat.i(46178);
    if (this.lPQ != null) {
      this.lPQ.release();
    }
    this.kyC = null;
    this.lPW = 0;
    AppMethodBeat.o(46178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.c
 * JD-Core Version:    0.7.0.1
 */