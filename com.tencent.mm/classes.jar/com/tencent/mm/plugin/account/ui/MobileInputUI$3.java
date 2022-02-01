package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.a.e;

final class MobileInputUI$3
  implements View.OnClickListener
{
  MobileInputUI$3(MobileInputUI paramMobileInputUI, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128335);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.jol.cPF();
    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.3
 * JD-Core Version:    0.7.0.1
 */