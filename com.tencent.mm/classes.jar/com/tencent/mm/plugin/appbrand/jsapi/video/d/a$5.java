package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a;
import com.tencent.mm.plugin.appbrand.page.bo;

final class a$5
  implements AppBrandVideoView.a
{
  a$5(a parama, e parame, boolean paramBoolean, int paramInt, bo parambo) {}
  
  public final void blp()
  {
    AppMethodBeat.i(211250);
    this.kFs.fF(this.kFv).sK(this.kFw);
    AppMethodBeat.o(211250);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(211251);
    boolean bool = this.kFs.fF(this.kFv).sL(this.kFw);
    AppMethodBeat.o(211251);
    return bool;
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(211249);
    this.kFs.fF(this.kFv).a(this.kFw, this.kSK, paramInt);
    AppMethodBeat.o(211249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.5
 * JD-Core Version:    0.7.0.1
 */