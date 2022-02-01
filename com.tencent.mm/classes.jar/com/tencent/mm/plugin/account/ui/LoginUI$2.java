package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LoginUI$2
  implements View.OnClickListener
{
  LoginUI$2(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128203);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    LoginUI.c(this.joQ);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.2
 * JD-Core Version:    0.7.0.1
 */