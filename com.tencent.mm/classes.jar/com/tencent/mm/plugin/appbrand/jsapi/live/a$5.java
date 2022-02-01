package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.page.bu;

final class a$5
  implements AppBrandLivePlayerView.a
{
  a$5(a parama, h paramh, boolean paramBoolean, int paramInt, bu parambu) {}
  
  public final void bGL()
  {
    AppMethodBeat.i(145849);
    this.lJT.gA(this.lJW).wG(this.lJX);
    AppMethodBeat.o(145849);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(145850);
    boolean bool = this.lJT.gA(this.lJW).wH(this.lJX);
    AppMethodBeat.o(145850);
    return bool;
  }
  
  public final void xd(int paramInt)
  {
    AppMethodBeat.i(145848);
    this.lJT.gA(this.lJW).a(this.lJX, this.lXP, paramInt);
    AppMethodBeat.o(145848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a.5
 * JD-Core Version:    0.7.0.1
 */