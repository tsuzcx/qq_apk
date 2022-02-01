package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LoginUI$11
  implements View.OnClickListener
{
  LoginUI$11(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128212);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.Q(this.joQ, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.joQ.overridePendingTransition(2130772105, 2130771986);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.11
 * JD-Core Version:    0.7.0.1
 */