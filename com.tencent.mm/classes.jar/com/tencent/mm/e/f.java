package com.tencent.mm.e;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/artists/FilterArtist;", "Lcom/tencent/mm/artists/BaseArtist;", "Lcom/tencent/mm/cache/FilterCache;", "()V", "TAG", "", "getType", "Lcom/tencent/mm/artists/ArtistType;", "onAlive", "", "onDeadDraw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onUndo", "select", "index", "", "colorWeight", "", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b<e>
{
  private final String TAG = "MicroMsg.FilterArtist";
  
  public final a aEy()
  {
    return a.hoP;
  }
  
  public final void aEz() {}
  
  public final void h(Canvas paramCanvas)
  {
    AppMethodBeat.i(163141);
    s.u(paramCanvas, "canvas");
    e locale = (e)aEA();
    if (locale != null) {
      locale.b(paramCanvas, false);
    }
    Log.i(this.TAG, "lxl artist onDeadDraw");
    AppMethodBeat.o(163141);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(163139);
    super.onAlive();
    e locale = (e)aEA();
    if (locale != null) {
      locale.lvS = this.hoR.iPu();
    }
    AppMethodBeat.o(163139);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(163140);
    s.u(paramCanvas, "canvas");
    e locale = (e)aEA();
    if (locale != null) {
      locale.b(paramCanvas, false);
    }
    Log.i(this.TAG, "lxl artist draw");
    AppMethodBeat.o(163140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.f
 * JD-Core Version:    0.7.0.1
 */