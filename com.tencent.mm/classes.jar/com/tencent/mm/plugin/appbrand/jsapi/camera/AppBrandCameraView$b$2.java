package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandCameraView$b$2
  implements MMSightRecordView.f
{
  AppBrandCameraView$b$2(AppBrandCameraView.b paramb) {}
  
  public final void db(boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (AppBrandCameraView.e(this.goT.goS) == null)
    {
      y.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
      AppBrandCameraView.b.a(this.goT, -1, "camera is null", null, null);
      return;
    }
    this.goT.goS.goN = 1;
    if (paramBoolean) {
      AppBrandCameraView.b.a(this.goT, -1, "stop error", null, null);
    }
    for (;;)
    {
      AppBrandCameraView.t(this.goT.goS);
      AppBrandCameraView.a(this.goT.goS, false);
      return;
      Object localObject = AppBrandCameraView.e(this.goT.goS).getVideoFilePath();
      int i = AppBrandCameraView.q(this.goT.goS);
      int j = AppBrandCameraView.r(this.goT.goS);
      AppBrandCameraView.e(this.goT.goS).getCameraRotation();
      localObject = d.ab((String)localObject, i, j);
      this.goT.a((Bitmap)localObject, AppBrandCameraView.s(this.goT.goS));
      AppBrandCameraView.b.a(this.goT, 0, "", AppBrandCameraView.s(this.goT.goS), AppBrandCameraView.e(this.goT.goS).getVideoFilePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.2
 * JD-Core Version:    0.7.0.1
 */