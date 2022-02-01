package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.u.i;

final class BaseLoginVoiceUI$21
  implements u.i
{
  BaseLoginVoiceUI$21(BaseLoginVoiceUI paramBaseLoginVoiceUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(304972);
    BaseLoginVoiceUI.a(this.pZB, paramMenuItem.getItemId());
    AppMethodBeat.o(304972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.21
 * JD-Core Version:    0.7.0.1
 */