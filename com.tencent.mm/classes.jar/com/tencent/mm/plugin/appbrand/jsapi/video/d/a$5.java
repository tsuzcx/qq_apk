package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.a;
import com.tencent.mm.plugin.appbrand.page.by;

final class a$5
  implements AppBrandVideoView.a
{
  a$5(a parama, h paramh, boolean paramBoolean, int paramInt, by paramby) {}
  
  public final void AM(int paramInt)
  {
    AppMethodBeat.i(328196);
    this.rJh.ic(this.rJl).a(this.rJm, this.saZ, paramInt);
    AppMethodBeat.o(328196);
  }
  
  public final void csz()
  {
    AppMethodBeat.i(328199);
    this.rJh.ic(this.rJl).An(this.rJm);
    AppMethodBeat.o(328199);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(328203);
    boolean bool = this.rJh.ic(this.rJl).Ao(this.rJm);
    AppMethodBeat.o(328203);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.5
 * JD-Core Version:    0.7.0.1
 */