package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiIntroductionUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FreeWifiIntroductionUI$1(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(20998);
    this.mNV.finish();
    AppMethodBeat.o(20998);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.1
 * JD-Core Version:    0.7.0.1
 */