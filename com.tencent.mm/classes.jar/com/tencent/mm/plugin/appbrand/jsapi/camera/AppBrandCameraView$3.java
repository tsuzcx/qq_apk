package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class AppBrandCameraView$3
  implements MMSightRecordView.d
{
  AppBrandCameraView$3(AppBrandCameraView paramAppBrandCameraView) {}
  
  public final void bjR()
  {
    AppMethodBeat.i(46148);
    ad.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
    Object localObject = new HashMap();
    ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.b(this.kHL)));
    localObject = new JSONObject((Map)localObject).toString();
    new i().h(AppBrandCameraView.c(this.kHL)).Pi((String)localObject).bir();
    AppMethodBeat.o(46148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.3
 * JD-Core Version:    0.7.0.1
 */