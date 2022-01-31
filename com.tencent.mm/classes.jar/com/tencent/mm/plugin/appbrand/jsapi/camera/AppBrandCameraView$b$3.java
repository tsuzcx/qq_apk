package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.media.n;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandCameraView$b$3
  implements Runnable
{
  AppBrandCameraView$b$3(AppBrandCameraView.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(130916);
    Object localObject = null;
    try
    {
      String str = n.Cu(AppBrandCameraView.f(this.hIR.hIQ).getVideoFilePath());
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandCameraView", "stopRecord, remux failed, callback with origin videoexp = %s", new Object[] { bo.l(localException) });
      }
    }
    m.runOnUiThread(new AppBrandCameraView.b.3.1(this, localObject));
    AppMethodBeat.o(130916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.3
 * JD-Core Version:    0.7.0.1
 */