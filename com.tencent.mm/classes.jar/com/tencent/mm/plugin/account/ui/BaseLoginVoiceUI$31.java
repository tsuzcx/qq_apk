package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u.i;

final class BaseLoginVoiceUI$31
  implements u.i
{
  BaseLoginVoiceUI$31(BaseLoginVoiceUI paramBaseLoginVoiceUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(304943);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(304943);
      return;
      BaseLoginVoiceUI.c(this.pZB);
      AppMethodBeat.o(304943);
      return;
      BaseLoginVoiceUI.d(this.pZB);
      AppMethodBeat.o(304943);
      return;
      BaseLoginVoiceUI.e(this.pZB);
      AppMethodBeat.o(304943);
      return;
      BaseLoginVoiceUI.U(this.pZB, this.pZB.getString(r.j.wechat_help_center_url) + LocaleUtil.getApplicationLanguage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BaseLoginVoiceUI.31
 * JD-Core Version:    0.7.0.1
 */