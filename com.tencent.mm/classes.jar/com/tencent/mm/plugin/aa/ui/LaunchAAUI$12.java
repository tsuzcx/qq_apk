package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LaunchAAUI$12
  implements MenuItem.OnMenuItemClickListener
{
  LaunchAAUI$12(LaunchAAUI paramLaunchAAUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(63642);
    this.jab.finish();
    AppMethodBeat.o(63642);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.12
 * JD-Core Version:    0.7.0.1
 */