package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MobileInputUI$8
  implements View.OnKeyListener
{
  MobileInputUI$8(MobileInputUI paramMobileInputUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128341);
    b localb = new b();
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      boolean bool = this.nfN.bzC();
      a.a(bool, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(128341);
      return bool;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(128341);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.8
 * JD-Core Version:    0.7.0.1
 */