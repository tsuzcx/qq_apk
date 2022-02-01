package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LoginHistoryUI$7
  implements View.OnClickListener
{
  LoginHistoryUI$7(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128093);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.Q(this.jok, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.jok.overridePendingTransition(2130772105, 2130771986);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */