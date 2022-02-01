package com.tencent.mm.e;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/artists/FilterArtist;", "Lcom/tencent/mm/artists/BaseArtist;", "Lcom/tencent/mm/cache/FilterCache;", "()V", "TAG", "", "getType", "Lcom/tencent/mm/artists/ArtistType;", "onAlive", "", "onDeadDraw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onUndo", "select", "index", "", "colorWeight", "", "plugin-photoedit-sdk_release"})
public final class f
  extends b<e>
{
  private final String TAG = "MicroMsg.FilterArtist";
  
  public final a LZ()
  {
    return a.cOS;
  }
  
  public final void Ma() {}
  
  public final void d(Canvas paramCanvas)
  {
    AppMethodBeat.i(163141);
    k.h(paramCanvas, "canvas");
    e locale = (e)Mb();
    if (locale != null) {
      locale.a(paramCanvas, false);
    }
    ac.i(this.TAG, "lxl artist onDeadDraw");
    AppMethodBeat.o(163141);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(163139);
    super.onAlive();
    e locale = (e)Mb();
    if (locale != null)
    {
      com.tencent.mm.bt.b localb = getPresenter();
      k.g(localb, "presenter");
      locale.fqf = localb.eQQ();
      AppMethodBeat.o(163139);
      return;
    }
    AppMethodBeat.o(163139);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(163140);
    k.h(paramCanvas, "canvas");
    e locale = (e)Mb();
    if (locale != null) {
      locale.a(paramCanvas, false);
    }
    ac.i(this.TAG, "lxl artist draw");
    AppMethodBeat.o(163140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.f
 * JD-Core Version:    0.7.0.1
 */