package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class LoginHistoryUI$31
  implements View.OnClickListener
{
  LoginHistoryUI$31(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128112);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginHistoryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.nek.getString(r.j.freeze_account_url, new Object[] { LocaleUtil.getApplicationLanguage() });
    LoginHistoryUI.W(this.nek, paramView);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.31
 * JD-Core Version:    0.7.0.1
 */