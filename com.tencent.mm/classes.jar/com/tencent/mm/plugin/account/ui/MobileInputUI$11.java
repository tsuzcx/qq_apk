package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.m;
import java.util.List;

final class MobileInputUI$11
  implements View.OnClickListener
{
  MobileInputUI$11(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128344);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView.getContext();
    if (com.tencent.mm.az.b.WC(this.nfN.getString(r.j.country_code)).size() > 1)
    {
      paramView = new Intent();
      paramView.putExtra("country_name", this.nfN.lSz);
      paramView.putExtra("couttry_code", this.nfN.countryCode);
      paramView.putExtra("iso_code", this.nfN.ndg);
      com.tencent.mm.plugin.account.sdk.a.mIG.b(paramView, this.nfN);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.11
 * JD-Core Version:    0.7.0.1
 */