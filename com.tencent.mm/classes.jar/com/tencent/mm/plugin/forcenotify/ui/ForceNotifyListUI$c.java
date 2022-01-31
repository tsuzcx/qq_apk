package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class ForceNotifyListUI$c
  implements MenuItem.OnMenuItemClickListener
{
  ForceNotifyListUI$c(ForceNotifyListUI paramForceNotifyListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(51074);
    this.mHI.onBackPressed();
    AppMethodBeat.o(51074);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI.c
 * JD-Core Version:    0.7.0.1
 */