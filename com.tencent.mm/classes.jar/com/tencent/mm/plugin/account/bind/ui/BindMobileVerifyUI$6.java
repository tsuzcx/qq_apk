package com.tencent.mm.plugin.account.bind.ui;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mm.plugin.account.bind.a.g;

final class BindMobileVerifyUI$6
  implements Runnable
{
  BindMobileVerifyUI$6(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final void run()
  {
    BindMobileVerifyUI.e(this.fcM);
    BindMobileVerifyUI.a(this.fcM, Integer.valueOf(BindMobileVerifyUI.e(this.fcM).intValue() - 1));
    if (BindMobileVerifyUI.e(this.fcM).intValue() > 0)
    {
      BindMobileVerifyUI.c(this.fcM).setText(this.fcM.getResources().getQuantityString(a.g.mobileverify_send_code_tip, BindMobileVerifyUI.e(this.fcM).intValue(), new Object[] { BindMobileVerifyUI.e(this.fcM) }));
      return;
    }
    BindMobileVerifyUI.c(this.fcM).setText(this.fcM.getResources().getQuantityString(a.g.mobileverify_send_code_tip, 0, new Object[] { Integer.valueOf(0) }));
    BindMobileVerifyUI.f(this.fcM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */