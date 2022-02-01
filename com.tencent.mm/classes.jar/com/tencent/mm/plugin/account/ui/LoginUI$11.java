package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;

final class LoginUI$11
  implements View.OnClickListener
{
  LoginUI$11(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128212);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    c.ad(this.neS, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.neS.overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
    h.IzE.PJ(2L);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.11
 * JD-Core Version:    0.7.0.1
 */