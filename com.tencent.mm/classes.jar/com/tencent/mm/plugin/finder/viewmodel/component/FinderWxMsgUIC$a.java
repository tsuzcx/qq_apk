package com.tencent.mm.plugin.finder.viewmodel.component;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderWxMsgUIC$a
  implements MenuItem.OnMenuItemClickListener
{
  FinderWxMsgUIC$a(FinderWxMsgUIC paramFinderWxMsgUIC) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(206409);
    this.toX.getActivity().finish();
    AppMethodBeat.o(206409);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderWxMsgUIC.a
 * JD-Core Version:    0.7.0.1
 */