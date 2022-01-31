package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RegByMobileVoiceVerifySelectUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileVoiceVerifySelectUI$1(RegByMobileVoiceVerifySelectUI paramRegByMobileVoiceVerifySelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125454);
    this.gIS.hideVKB();
    this.gIS.finish();
    AppMethodBeat.o(125454);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI.1
 * JD-Core Version:    0.7.0.1
 */