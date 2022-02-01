package com.tencent.mm.plugin.account.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MobileVerifyUI$11
  implements View.OnKeyListener
{
  MobileVerifyUI$11(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128450);
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    a.b("com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      MobileVerifyUI.e(this.jod);
      a.a(true, this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(128450);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileVerifyUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(128450);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.11
 * JD-Core Version:    0.7.0.1
 */