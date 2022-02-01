package com.tencent.mm.plugin.eggspring.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class SpringCardActivity$d
  implements MenuItem.OnMenuItemClickListener
{
  SpringCardActivity$d(SpringCardActivity paramSpringCardActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(162211);
    this.osQ.finish();
    AppMethodBeat.o(162211);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity.d
 * JD-Core Version:    0.7.0.1
 */