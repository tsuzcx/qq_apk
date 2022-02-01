package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RegSetInfoUI$2
  implements View.OnKeyListener
{
  RegSetInfoUI$2(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128669);
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      RegSetInfoUI.p(this.jqJ);
      a.a(true, this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(128669);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(128669);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.2
 * JD-Core Version:    0.7.0.1
 */