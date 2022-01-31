package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LaunchAAUI$1
  implements MenuItem.OnMenuItemClickListener
{
  LaunchAAUI$1(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40824);
    this.grm.finish();
    AppMethodBeat.o(40824);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.1
 * JD-Core Version:    0.7.0.1
 */