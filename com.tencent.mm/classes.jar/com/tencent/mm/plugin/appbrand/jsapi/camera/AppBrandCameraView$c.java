package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.d;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.concurrent.atomic.AtomicBoolean;

final class AppBrandCameraView$c
  implements AppBrandCameraView.a, c.a
{
  private int duration;
  private c hIU;
  AtomicBoolean hIV;
  private int hIW;
  
  private AppBrandCameraView$c(AppBrandCameraView paramAppBrandCameraView)
  {
    AppMethodBeat.i(130928);
    this.hIV = new AtomicBoolean(false);
    this.hIW = 200;
    this.duration = this.hIW;
    AppMethodBeat.o(130928);
  }
  
  public final void aCA()
  {
    AppMethodBeat.i(130932);
    ab.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
    AppMethodBeat.o(130932);
  }
  
  public final void aCJ()
  {
    AppMethodBeat.i(130933);
    ab.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
    AppMethodBeat.o(130933);
  }
  
  public final void aCK()
  {
    AppMethodBeat.i(130934);
    ab.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
    AppMethodBeat.o(130934);
  }
  
  public final void b(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130931);
    if (this.hIV.compareAndSet(false, true))
    {
      al.p(new AppBrandCameraView.c.1(this), this.duration);
      ab.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    default: 
      ab.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
      AppMethodBeat.o(130931);
      return;
    case 1: 
      h.a(AppBrandCameraView.b(this.hIQ), this.hIQ.getCameraId(), "qrcode", paramString, paramArrayOfByte);
      AppMethodBeat.o(130931);
      return;
    }
    h.a(AppBrandCameraView.b(this.hIQ), this.hIQ.getCameraId(), "barcode", paramString, paramArrayOfByte);
    AppMethodBeat.o(130931);
  }
  
  public final void init()
  {
    AppMethodBeat.i(130929);
    this.hIU = new d();
    this.hIU.init();
    this.hIU.hJB = this;
    AppBrandCameraView.a(this.hIQ, 4);
    if (AppBrandCameraView.y(this.hIQ) > 0) {
      this.duration = (1000 / AppBrandCameraView.y(this.hIQ));
    }
    AppMethodBeat.o(130929);
  }
  
  public final void q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130930);
    if (this.hIV.get())
    {
      ab.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
      AppMethodBeat.o(130930);
      return;
    }
    if ((this.hIU != null) && (AppBrandCameraView.f(this.hIQ) != null)) {
      this.hIU.a(paramArrayOfByte, paramInt1, paramInt2, AppBrandCameraView.z(this.hIQ), AppBrandCameraView.f(this.hIQ).getCameraRotation());
    }
    AppMethodBeat.o(130930);
  }
  
  public final void release()
  {
    AppMethodBeat.i(130935);
    if (this.hIU != null) {
      this.hIU.release();
    }
    AppMethodBeat.o(130935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.c
 * JD-Core Version:    0.7.0.1
 */