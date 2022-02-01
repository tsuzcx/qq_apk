package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class MobileInputUI$18
  implements View.OnClickListener
{
  MobileInputUI$18(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128350);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = this.jpJ.getString(2131759660, new Object[] { ad.fom() });
    MobileInputUI.S(this.jpJ, paramView);
    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.18
 * JD-Core Version:    0.7.0.1
 */