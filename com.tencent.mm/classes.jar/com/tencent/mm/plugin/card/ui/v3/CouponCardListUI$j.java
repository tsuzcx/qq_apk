package com.tencent.mm.plugin.card.ui.v3;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CouponCardListUI$j
  implements MenuItem.OnMenuItemClickListener
{
  CouponCardListUI$j(CouponCardListUI paramCouponCardListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(215550);
    this.oND.finish();
    AppMethodBeat.o(215550);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI.j
 * JD-Core Version:    0.7.0.1
 */