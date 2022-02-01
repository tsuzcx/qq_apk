package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.qbar.QbarNative.QBarPoint;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrandCameraView$c
  implements AppBrandCameraView.a, c.a
{
  private int aXs;
  private int aXt;
  private int duration;
  private float hrT;
  private Point jxT;
  private c kLe;
  AtomicBoolean kLf;
  private int kLg;
  private Rect kLh;
  private int kLi;
  int kLj;
  private int kLk;
  
  protected AppBrandCameraView$c(AppBrandCameraView paramAppBrandCameraView)
  {
    AppMethodBeat.i(46171);
    this.kLf = new AtomicBoolean(false);
    this.kLg = 200;
    this.duration = this.kLg;
    this.hrT = (AppBrandCameraView.z(this.kLa) * 1.0F / AppBrandCameraView.A(this.kLa));
    if (AppBrandCameraView.B(this.kLa)) {
      i = 1;
    }
    this.kLj = i;
    AppMethodBeat.o(46171);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(222425);
    if (this.kLf.compareAndSet(false, true))
    {
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46170);
          AppBrandCameraView.c.this.kLf.set(false);
          AppMethodBeat.o(46170);
        }
      }, this.duration);
      ae.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d, codeVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramQBarPoint != null) && (this.kLk % 4 == 0))
      {
        ae.i("MicroMsg.AppBrandCameraView", "x: %f, y: %f, w: %f, h: %f; x0:%f, x1:%f, x2:%f, x3:%f, y0:%f, y1:%f, y2:%f, y3:%f", new Object[] { Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x1 - paramQBarPoint.x0), Float.valueOf(paramQBarPoint.y3 - paramQBarPoint.y0), Float.valueOf(paramQBarPoint.x0), Float.valueOf(paramQBarPoint.x1), Float.valueOf(paramQBarPoint.x2), Float.valueOf(paramQBarPoint.x3), Float.valueOf(paramQBarPoint.y0), Float.valueOf(paramQBarPoint.y1), Float.valueOf(paramQBarPoint.y2), Float.valueOf(paramQBarPoint.y3) });
        this.kLk += 1;
      }
    }
    switch (paramInt1)
    {
    default: 
      ae.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
      AppMethodBeat.o(222425);
      return;
    case 1: 
      j.a(AppBrandCameraView.c(this.kLa), this.kLa.getCameraId(), "qrcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
      AppMethodBeat.o(222425);
      return;
    }
    j.a(AppBrandCameraView.c(this.kLa), this.kLa.getCameraId(), "barcode", paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
    AppMethodBeat.o(222425);
  }
  
  public final void bko()
  {
    AppMethodBeat.i(46175);
    ae.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
    AppMethodBeat.o(46175);
  }
  
  public final void bkx()
  {
    AppMethodBeat.i(46176);
    ae.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
    AppMethodBeat.o(46176);
  }
  
  public final void bky()
  {
    AppMethodBeat.i(46177);
    ae.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
    AppMethodBeat.o(46177);
  }
  
  public void init()
  {
    AppMethodBeat.i(46172);
    this.kLe = new d();
    this.kLe.init();
    this.kLe.kLZ = this;
    AppBrandCameraView.a(this.kLa, 4);
    if (AppBrandCameraView.C(this.kLa) > 0) {
      this.duration = (1000 / AppBrandCameraView.C(this.kLa));
    }
    this.kLk = 0;
    AppMethodBeat.o(46172);
  }
  
  public final void release()
  {
    AppMethodBeat.i(46178);
    if (this.kLe != null) {
      this.kLe.release();
    }
    this.jxT = null;
    this.kLk = 0;
    AppMethodBeat.o(46178);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(46173);
    int i;
    int k;
    label140:
    float f2;
    if ((this.aXs != AppBrandCameraView.z(this.kLa)) || (this.aXt != AppBrandCameraView.A(this.kLa))) {
      switch (((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        i = 0;
        k = AppBrandCameraView.e(this.kLa).getCameraRotation();
        if ("front".equals(AppBrandCameraView.E(this.kLa)))
        {
          this.kLi = (k % 360);
          this.kLi = ((360 - this.kLi) % 360);
          if (AppBrandCameraView.e(this.kLa) != null)
          {
            this.aXs = AppBrandCameraView.z(this.kLa);
            this.aXt = AppBrandCameraView.A(this.kLa);
          }
          AppBrandCameraView.z(this.kLa);
          AppBrandCameraView.A(this.kLa);
          k = this.kLi;
          f2 = this.hrT;
          if ((paramInt1 > 0) && (paramInt2 > 0)) {
            break label332;
          }
          localObject = null;
          label211:
          this.jxT = ((Point)localObject);
          if (this.jxT != null)
          {
            localObject = AppBrandCameraView.D(this.kLa);
            i = AppBrandCameraView.z(this.kLa);
            j = this.jxT.x;
            if (localObject != null) {
              break label517;
            }
          }
        }
        break;
      }
    }
    label332:
    float f1;
    for (Object localObject = null;; localObject = new Rect(Math.round(((Rect)localObject).left / f1), Math.round(((Rect)localObject).top / f1), Math.round(((Rect)localObject).right / f1), Math.round(((Rect)localObject).bottom / f1)))
    {
      this.kLh = ((Rect)localObject);
      if (!this.kLf.get()) {
        break label588;
      }
      ae.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
      AppMethodBeat.o(46173);
      return;
      i = 90;
      break;
      i = 180;
      break;
      i = 270;
      break;
      this.kLi = ((k - i + 360) % 360);
      break label140;
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
        this.kLj = 1;
        i = Math.max(paramInt2, paramInt1);
        j = (int)(f1 * i);
        if ((k == 90) || (k == 270))
        {
          localObject = new Point(j, i);
          break label211;
        }
        localObject = new Point(i, j);
        break label211;
      }
      i = Math.min(paramInt2, paramInt1);
      j = (int)(i / f1);
      if ((k == 90) || (k == 270))
      {
        localObject = new Point(i, j);
        break label211;
      }
      localObject = new Point(j, i);
      break label211;
      label517:
      f1 = i * 1.0F / j;
    }
    label588:
    if ((this.kLe != null) && (AppBrandCameraView.e(this.kLa) != null)) {
      this.kLe.b(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.z(this.kLa), AppBrandCameraView.A(this.kLa), this.jxT, this.kLh, this.kLi, this.kLj);
    }
    AppMethodBeat.o(46173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.c
 * JD-Core Version:    0.7.0.1
 */