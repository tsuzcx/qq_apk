package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.n;
import java.util.List;

final class LoginHistoryUI$27
  implements View.OnClickListener
{
  LoginHistoryUI$27(LoginHistoryUI paramLoginHistoryUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128108);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LoginHistoryUI.a(this.kmt, ((n)this.kmw.get(0)).getItemId());
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.27
 * JD-Core Version:    0.7.0.1
 */