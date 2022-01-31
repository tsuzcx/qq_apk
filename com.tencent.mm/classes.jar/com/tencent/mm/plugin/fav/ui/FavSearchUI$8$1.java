package com.tencent.mm.plugin.fav.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class FavSearchUI$8$1
  implements Runnable
{
  FavSearchUI$8$1(FavSearchUI.8 param8, List paramList1, List paramList2, List paramList3) {}
  
  public final void run()
  {
    AppMethodBeat.i(74072);
    if ((this.mxy.isEmpty()) && (this.mxz.isEmpty()) && (FavSearchUI.e(this.mxB.mxx)))
    {
      FavSearchUI.a(this.mxB.mxx, false);
      FavSearchUI.a(this.mxB.mxx, this.mxy, this.mxz);
      AppMethodBeat.o(74072);
      return;
    }
    FavSearchUI.a(this.mxB.mxx, this.mxy, this.mxz);
    ab.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", new Object[] { this.mxA, this.mxy, this.mxz });
    FavSearchUI.b(this.mxB.mxx, this.mxy);
    FavSearchUI.c(this.mxB.mxx, this.mxz);
    FavSearchUI.d(this.mxB.mxx, this.mxA);
    FavSearchUI.f(this.mxB.mxx).bN(this.mxz);
    FavSearchUI.g(this.mxB.mxx).c(this.mxA, this.mxy, this.mxz);
    FavSearchUI.b(this.mxB.mxx, false);
    AppMethodBeat.o(74072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.8.1
 * JD-Core Version:    0.7.0.1
 */