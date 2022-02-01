package com.tencent.mm.live.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class LiveUIC$a
  implements MenuItem.OnMenuItemClickListener
{
  LiveUIC$a(LiveUIC paramLiveUIC) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(203264);
    this.Kyn.finish();
    AppMethodBeat.o(203264);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIC.a
 * JD-Core Version:    0.7.0.1
 */