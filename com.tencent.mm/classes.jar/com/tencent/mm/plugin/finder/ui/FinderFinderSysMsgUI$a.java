package com.tencent.mm.plugin.finder.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class FinderFinderSysMsgUI$a
  implements MenuItem.OnMenuItemClickListener
{
  FinderFinderSysMsgUI$a(FinderFinderSysMsgUI paramFinderFinderSysMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(204571);
    this.sND.finish();
    AppMethodBeat.o(204571);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI.a
 * JD-Core Version:    0.7.0.1
 */