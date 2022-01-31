package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;

final class AppBrandCameraView$4
  implements MMSightRecordView.a
{
  AppBrandCameraView$4(AppBrandCameraView paramAppBrandCameraView) {}
  
  public final void q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130912);
    if (AppBrandCameraView.d(this.hIQ) != null) {
      AppBrandCameraView.d(this.hIQ).q(paramArrayOfByte, paramInt1, paramInt2);
    }
    AppMethodBeat.o(130912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.4
 * JD-Core Version:    0.7.0.1
 */