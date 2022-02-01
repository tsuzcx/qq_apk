package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u.i;

final class MobileInputUI$18
  implements u.i
{
  MobileInputUI$18(MobileInputUI paramMobileInputUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(305079);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(305079);
      return;
      MobileInputUI.c(this.qcW);
      AppMethodBeat.o(305079);
      return;
      MobileInputUI.X(this.qcW, this.qcW.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.18
 * JD-Core Version:    0.7.0.1
 */