package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a;
import com.tencent.mm.plugin.appbrand.page.bp;

final class a$5
  implements AppBrandVideoView.a
{
  a$5(a parama, e parame, boolean paramBoolean, int paramInt, bp parambp) {}
  
  public final void bkF()
  {
    AppMethodBeat.i(206222);
    this.kCd.fG(this.kCg).sH(this.kCh);
    AppMethodBeat.o(206222);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(206223);
    boolean bool = this.kCd.fG(this.kCg).sI(this.kCh);
    AppMethodBeat.o(206223);
    return bool;
  }
  
  public final void te(int paramInt)
  {
    AppMethodBeat.i(206221);
    this.kCd.fG(this.kCg).a(this.kCh, this.kPc, paramInt);
    AppMethodBeat.o(206221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.5
 * JD-Core Version:    0.7.0.1
 */