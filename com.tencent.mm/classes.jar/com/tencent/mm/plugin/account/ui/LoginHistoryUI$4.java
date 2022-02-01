package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class LoginHistoryUI$4
  implements View.OnClickListener
{
  LoginHistoryUI$4(LoginHistoryUI paramLoginHistoryUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128090);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.jlq.hideVKB();
    this.jlr.cMW();
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */