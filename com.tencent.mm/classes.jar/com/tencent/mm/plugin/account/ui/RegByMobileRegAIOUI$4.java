package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class RegByMobileRegAIOUI$4
  implements View.OnClickListener
{
  RegByMobileRegAIOUI$4(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125341);
    paramView = new Intent();
    paramView.putExtra("country_name", RegByMobileRegAIOUI.n(this.gIh));
    paramView.putExtra("couttry_code", RegByMobileRegAIOUI.f(this.gIh));
    a.gmO.b(paramView, this.gIh);
    AppMethodBeat.o(125341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.4
 * JD-Core Version:    0.7.0.1
 */