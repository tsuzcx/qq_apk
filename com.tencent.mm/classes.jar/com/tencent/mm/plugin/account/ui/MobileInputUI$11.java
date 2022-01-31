package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class MobileInputUI$11
  implements View.OnClickListener
{
  MobileInputUI$11(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125171);
    paramView = new Intent();
    paramView.putExtra("country_name", this.gGb.fHT);
    paramView.putExtra("couttry_code", this.gGb.countryCode);
    paramView.putExtra("iso_code", this.gGb.gDF);
    a.gmO.b(paramView, this.gGb);
    AppMethodBeat.o(125171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.11
 * JD-Core Version:    0.7.0.1
 */