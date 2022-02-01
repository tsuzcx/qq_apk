package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class LoginUI$3
  implements View.OnClickListener
{
  LoginUI$3(LoginUI paramLoginUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128204);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.jlr.cMW();
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.3
 * JD-Core Version:    0.7.0.1
 */