package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class MobileInputUI$14
  implements View.OnClickListener
{
  MobileInputUI$14(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125174);
    d.H(this.gGb, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.gGb.overridePendingTransition(2131034227, 2131034130);
    AppMethodBeat.o(125174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.14
 * JD-Core Version:    0.7.0.1
 */