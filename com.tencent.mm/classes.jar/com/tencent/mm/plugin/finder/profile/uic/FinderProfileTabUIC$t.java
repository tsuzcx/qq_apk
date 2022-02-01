package com.tencent.mm.plugin.finder.profile.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
final class FinderProfileTabUIC$t
  implements g.a
{
  FinderProfileTabUIC$t(g paramg) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(269845);
    Log.i("Finder.FinderProfileTabUIC", "showShopOpGuideDialog left btn click!");
    this.kvu.bYF();
    AppMethodBeat.o(269845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC.t
 * JD-Core Version:    0.7.0.1
 */