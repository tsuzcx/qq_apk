package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.f;

final class LoginHistoryUI$2
  implements View.OnClickListener
{
  LoginHistoryUI$2(LoginHistoryUI paramLoginHistoryUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(304935);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginHistoryUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.qbb.hideVKB();
    this.pZC.dDn();
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(304935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */