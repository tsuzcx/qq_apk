package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class AppBrandCameraView$2
  implements MMSightRecordView.c
{
  AppBrandCameraView$2(AppBrandCameraView paramAppBrandCameraView) {}
  
  public final void aiO()
  {
    y.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
    Object localObject = new HashMap();
    ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.a(this.goS)));
    localObject = new JSONObject((Map)localObject).toString();
    new e().e(AppBrandCameraView.b(this.goS)).tM((String)localObject).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.2
 * JD-Core Version:    0.7.0.1
 */