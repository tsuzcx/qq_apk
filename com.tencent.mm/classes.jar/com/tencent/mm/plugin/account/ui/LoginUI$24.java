package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class LoginUI$24
  implements View.OnClickListener
{
  LoginUI$24(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128225);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.neS.getString(r.j.login_forget_password_help) + LocaleUtil.getApplicationLanguage();
    LoginUI.X(this.neS, paramView);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.24
 * JD-Core Version:    0.7.0.1
 */