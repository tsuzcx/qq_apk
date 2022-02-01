package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ac;

final class MobileInputUI$17
  implements View.OnClickListener
{
  MobileInputUI$17(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128349);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.jmP.getString(2131760769) + ac.fks();
    MobileInputUI.R(this.jmP, paramView);
    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.17
 * JD-Core Version:    0.7.0.1
 */