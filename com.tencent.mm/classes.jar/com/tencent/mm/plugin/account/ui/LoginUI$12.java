package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LoginUI$12
  implements View.OnKeyListener
{
  LoginUI$12(LoginUI paramLoginUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(305086);
    b localb = new b();
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    a.c("com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      LoginUI.e(this.qbD);
      a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(305086);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginUI$19", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(305086);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.12
 * JD-Core Version:    0.7.0.1
 */