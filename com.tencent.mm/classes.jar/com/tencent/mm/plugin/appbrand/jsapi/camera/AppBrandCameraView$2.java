package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class AppBrandCameraView$2
  implements MMSightRecordView.d
{
  AppBrandCameraView$2(AppBrandCameraView paramAppBrandCameraView) {}
  
  public final void aCL()
  {
    AppMethodBeat.i(130910);
    ab.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
    Object localObject = new HashMap();
    ((Map)localObject).put("cameraId", Integer.valueOf(AppBrandCameraView.a(this.hIQ)));
    localObject = new JSONObject((Map)localObject).toString();
    new g().j(AppBrandCameraView.b(this.hIQ)).BN((String)localObject).aBz();
    AppMethodBeat.o(130910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.2
 * JD-Core Version:    0.7.0.1
 */