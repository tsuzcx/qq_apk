package com.tencent.mm.plugin.forcenotify.ui;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class ForceNotifyAcceptUI$a
  implements MenuItem.OnMenuItemClickListener
{
  ForceNotifyAcceptUI$a(ForceNotifyAcceptUI paramForceNotifyAcceptUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(140600);
    this.mHy.onBackPressed();
    AppMethodBeat.o(140600);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.ForceNotifyAcceptUI.a
 * JD-Core Version:    0.7.0.1
 */