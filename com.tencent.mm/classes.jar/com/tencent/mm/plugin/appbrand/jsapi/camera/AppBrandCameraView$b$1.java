package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;

final class AppBrandCameraView$b$1
  implements MMSightRecordView.e
{
  AppBrandCameraView$b$1(AppBrandCameraView.b paramb) {}
  
  public final void aiP()
  {
    AppBrandCameraView.a(this.goT.goS, -1, null, "take picture error");
  }
  
  public final void u(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (this.goT.a(paramBitmap, AppBrandCameraView.j(this.goT.goS)))
      {
        AppBrandCameraView.a(this.goT.goS, 0, AppBrandCameraView.b.g(AppBrandCameraView.b(this.goT.goS), AppBrandCameraView.j(this.goT.goS)), "");
        return;
      }
      AppBrandCameraView.a(this.goT.goS, -1, null, "save fail");
      return;
    }
    AppBrandCameraView.a(this.goT.goS, -1, null, "bitmap is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.1
 * JD-Core Version:    0.7.0.1
 */