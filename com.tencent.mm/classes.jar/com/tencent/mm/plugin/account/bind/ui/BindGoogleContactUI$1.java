package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindGoogleContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BindGoogleContactUI$1(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13347);
    this.gsF.finish();
    AppMethodBeat.o(13347);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.1
 * JD-Core Version:    0.7.0.1
 */