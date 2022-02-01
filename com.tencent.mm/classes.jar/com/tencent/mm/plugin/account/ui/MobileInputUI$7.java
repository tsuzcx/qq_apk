package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MobileInputUI$7
  implements View.OnKeyListener
{
  MobileInputUI$7(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(305184);
    b localb = new b();
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$15", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      boolean bool = this.qcW.bYo();
      a.a(bool, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$15", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(305184);
      return bool;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$15", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(305184);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.7
 * JD-Core Version:    0.7.0.1
 */