package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileVoiceVerifyUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileVoiceVerifyUI$1(RegByMobileVoiceVerifyUI paramRegByMobileVoiceVerifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(128624);
    this.jpP.hideVKB();
    this.jpP.finish();
    AppMethodBeat.o(128624);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */