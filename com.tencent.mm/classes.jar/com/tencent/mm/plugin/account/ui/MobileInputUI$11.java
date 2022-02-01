package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;

final class MobileInputUI$11
  implements View.OnClickListener
{
  MobileInputUI$11(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128344);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("country_name", this.jmP.iem);
    paramView.putExtra("couttry_code", this.jmP.countryCode);
    paramView.putExtra("iso_code", this.jmP.jko);
    com.tencent.mm.plugin.account.a.a.iRG.b(paramView, this.jmP);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.11
 * JD-Core Version:    0.7.0.1
 */