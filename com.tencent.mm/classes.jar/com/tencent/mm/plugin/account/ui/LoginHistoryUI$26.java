package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class LoginHistoryUI$26
  implements View.OnClickListener
{
  LoginHistoryUI$26(LoginHistoryUI paramLoginHistoryUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128107);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginHistoryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.nek.hideVKB();
    this.nel.eik();
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.26
 * JD-Core Version:    0.7.0.1
 */