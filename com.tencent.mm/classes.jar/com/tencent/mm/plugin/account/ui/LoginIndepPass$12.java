package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class LoginIndepPass$12
  implements View.OnKeyListener
{
  LoginIndepPass$12(LoginIndepPass paramLoginIndepPass) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128156);
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    a.b("com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      LoginIndepPass.a(this.jly);
      a.a(true, this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(128156);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/LoginIndepPass$5", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(128156);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.12
 * JD-Core Version:    0.7.0.1
 */