package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.t;
import java.util.List;

final class LoginHistoryUI$25
  implements View.OnClickListener
{
  LoginHistoryUI$25(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305165);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/LoginHistoryUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    LoginHistoryUI.a(this.qbb, ((t)this.pZG.get(0)).getItemId());
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.25
 * JD-Core Version:    0.7.0.1
 */