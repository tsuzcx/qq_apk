package com.tencent.mm.plugin.account.bind.ui;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindMobileVerifyUI$6
  implements Runnable
{
  BindMobileVerifyUI$6(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(13534);
    BindMobileVerifyUI.e(this.guw);
    BindMobileVerifyUI.a(this.guw, Integer.valueOf(BindMobileVerifyUI.e(this.guw).intValue() - 1));
    if (BindMobileVerifyUI.e(this.guw).intValue() > 0)
    {
      BindMobileVerifyUI.c(this.guw).setText(this.guw.getResources().getQuantityString(2131361811, BindMobileVerifyUI.e(this.guw).intValue(), new Object[] { BindMobileVerifyUI.e(this.guw) }));
      AppMethodBeat.o(13534);
      return;
    }
    BindMobileVerifyUI.c(this.guw).setText(this.guw.getResources().getQuantityString(2131361811, 0, new Object[] { Integer.valueOf(0) }));
    BindMobileVerifyUI.f(this.guw);
    AppMethodBeat.o(13534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */