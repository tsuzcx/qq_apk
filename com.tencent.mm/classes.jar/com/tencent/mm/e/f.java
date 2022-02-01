package com.tencent.mm.e;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/artists/FilterArtist;", "Lcom/tencent/mm/artists/BaseArtist;", "Lcom/tencent/mm/cache/FilterCache;", "()V", "TAG", "", "getType", "Lcom/tencent/mm/artists/ArtistType;", "onAlive", "", "onDeadDraw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onUndo", "select", "index", "", "colorWeight", "", "plugin-photoedit-sdk_release"})
public final class f
  extends b<e>
{
  private final String TAG = "MicroMsg.FilterArtist";
  
  public final a NG()
  {
    return a.dbk;
  }
  
  public final void NH() {}
  
  public final void d(Canvas paramCanvas)
  {
    AppMethodBeat.i(163141);
    p.h(paramCanvas, "canvas");
    e locale = (e)NI();
    if (locale != null) {
      locale.a(paramCanvas, false);
    }
    ae.i(this.TAG, "lxl artist onDeadDraw");
    AppMethodBeat.o(163141);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(163139);
    super.onAlive();
    e locale = (e)NI();
    if (locale != null)
    {
      com.tencent.mm.bt.b localb = getPresenter();
      p.g(localb, "presenter");
      locale.fKq = localb.fjK();
      AppMethodBeat.o(163139);
      return;
    }
    AppMethodBeat.o(163139);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(163140);
    p.h(paramCanvas, "canvas");
    e locale = (e)NI();
    if (locale != null) {
      locale.a(paramCanvas, false);
    }
    ae.i(this.TAG, "lxl artist draw");
    AppMethodBeat.o(163140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.f
 * JD-Core Version:    0.7.0.1
 */