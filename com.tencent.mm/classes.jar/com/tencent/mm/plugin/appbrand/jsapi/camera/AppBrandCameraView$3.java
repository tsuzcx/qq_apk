package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class AppBrandCameraView$3
  implements MMSightRecordView.c
{
  AppBrandCameraView$3(AppBrandCameraView paramAppBrandCameraView) {}
  
  public final void aCM()
  {
    AppMethodBeat.i(130911);
    AppBrandCameraView.c(this.hIQ);
    ab.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
    f localf = new f();
    HashMap localHashMap = new HashMap();
    localHashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.a(this.hIQ)));
    localf.BN(new JSONObject(localHashMap).toString());
    AppBrandCameraView.b(this.hIQ).b(localf);
    AppMethodBeat.o(130911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.3
 * JD-Core Version:    0.7.0.1
 */