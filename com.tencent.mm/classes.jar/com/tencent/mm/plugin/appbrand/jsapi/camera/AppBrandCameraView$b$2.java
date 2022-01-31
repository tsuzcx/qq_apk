package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandCameraView$b$2
  implements MMSightRecordView.h
{
  AppBrandCameraView$b$2(AppBrandCameraView.b paramb) {}
  
  public final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(130915);
    ab.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (AppBrandCameraView.f(this.hIR.hIQ) == null)
    {
      ab.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
      AppBrandCameraView.b.a(this.hIR, "camera is null");
      AppMethodBeat.o(130915);
      return;
    }
    this.hIR.hIQ.hIJ = 1;
    if (paramBoolean)
    {
      AppBrandCameraView.b.a(this.hIR, "stop error");
      this.hIR.aCN();
      AppMethodBeat.o(130915);
      return;
    }
    if (AppBrandCameraView.s(this.hIR.hIQ))
    {
      AppBrandCameraView.b localb = this.hIR;
      d.ysm.execute(new AppBrandCameraView.b.3(localb));
      AppMethodBeat.o(130915);
      return;
    }
    AppBrandCameraView.b.b(this.hIR, AppBrandCameraView.f(this.hIR.hIQ).getVideoFilePath());
    AppMethodBeat.o(130915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.b.2
 * JD-Core Version:    0.7.0.1
 */