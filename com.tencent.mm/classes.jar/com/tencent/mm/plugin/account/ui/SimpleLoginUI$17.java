package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SimpleLoginUI$17
  implements View.OnKeyListener
{
  SimpleLoginUI$17(SimpleLoginUI paramSimpleLoginUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128774);
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    a.b("com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      SimpleLoginUI.b(this.jrl);
      a.a(true, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(128774);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/SimpleLoginUI$7", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(128774);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.SimpleLoginUI.17
 * JD-Core Version:    0.7.0.1
 */