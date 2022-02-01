package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.q.g;

final class MobileInputUI$20
  implements q.g
{
  MobileInputUI$20(MobileInputUI paramMobileInputUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(128352);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128352);
      return;
      MobileInputUI.d(this.nfN);
      AppMethodBeat.o(128352);
      return;
      MobileInputUI.X(this.nfN, this.nfN.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.20
 * JD-Core Version:    0.7.0.1
 */