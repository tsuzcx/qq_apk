package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.bc;

final class f$5
  implements AppBrandVideoView.a
{
  f$5(f paramf, e parame, int paramInt, bc parambc) {}
  
  public final void aDh()
  {
    AppMethodBeat.i(126554);
    this.hEL.vC().pl(this.hEO);
    AppMethodBeat.o(126554);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(126555);
    boolean bool = this.hEL.vC().pk(this.hEO);
    AppMethodBeat.o(126555);
    return bool;
  }
  
  public final void oc(int paramInt)
  {
    AppMethodBeat.i(126553);
    this.hEL.vC().a(this.hEO, this.hNE, paramInt);
    AppMethodBeat.o(126553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f.5
 * JD-Core Version:    0.7.0.1
 */