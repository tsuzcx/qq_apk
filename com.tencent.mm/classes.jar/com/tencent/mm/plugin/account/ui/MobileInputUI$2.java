package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.f;

final class MobileInputUI$2
  implements View.OnClickListener
{
  MobileInputUI$2(MobileInputUI paramMobileInputUI, f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128334);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.pZC.dDn();
    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.2
 * JD-Core Version:    0.7.0.1
 */