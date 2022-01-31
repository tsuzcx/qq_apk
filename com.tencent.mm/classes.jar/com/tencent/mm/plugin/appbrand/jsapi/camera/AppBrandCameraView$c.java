package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicBoolean;

final class AppBrandCameraView$c
  implements AppBrandCameraView.a, c.a
{
  private int duration = this.goW;
  private c goU;
  AtomicBoolean goV = new AtomicBoolean(false);
  private int goW = 200;
  
  private AppBrandCameraView$c(AppBrandCameraView paramAppBrandCameraView) {}
  
  public final void aiF()
  {
    y.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
  }
  
  public final void aiN()
  {
    y.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
  }
  
  public final void b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.goV.compareAndSet(false, true))
    {
      ai.l(new AppBrandCameraView.c.1(this), this.duration);
      y.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    default: 
      y.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
      return;
    case 1: 
      f.a(AppBrandCameraView.b(this.goS), this.goS.getCameraId(), "qrcode", paramString, paramArrayOfByte);
      return;
    }
    f.a(AppBrandCameraView.b(this.goS), this.goS.getCameraId(), "barcode", paramString, paramArrayOfByte);
  }
  
  public final void init()
  {
    this.goU = new d();
    this.goU.init();
    this.goU.gpx = this;
    AppBrandCameraView.a(this.goS, 4);
    if (AppBrandCameraView.v(this.goS) > 0) {
      this.duration = (1000 / AppBrandCameraView.v(this.goS));
    }
  }
  
  public final void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.goV.get()) {
      y.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
    }
    while ((this.goU == null) || (AppBrandCameraView.e(this.goS) == null)) {
      return;
    }
    this.goU.a(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.w(this.goS), AppBrandCameraView.e(this.goS).getCameraRotation());
  }
  
  public final void release()
  {
    if (this.goU != null) {
      this.goU.release();
    }
  }
  
  public final void startRecord()
  {
    y.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.c
 * JD-Core Version:    0.7.0.1
 */