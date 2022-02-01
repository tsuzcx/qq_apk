package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class LoginHistoryUI$31
  implements View.OnClickListener
{
  LoginHistoryUI$31(LoginHistoryUI paramLoginHistoryUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128112);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginHistoryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = this.jok.getString(2131759660, new Object[] { ad.fom() });
    LoginHistoryUI.R(this.jok, paramView);
    a.a(this, "com/tencent/mm/plugin/account/ui/LoginHistoryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginHistoryUI.31
 * JD-Core Version:    0.7.0.1
 */