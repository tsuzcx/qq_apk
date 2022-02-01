package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;

final class MobileInputUI$15
  implements View.OnClickListener
{
  MobileInputUI$15(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128347);
    d.N(this.iTH, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.iTH.overridePendingTransition(2130772105, 2130771986);
    AppMethodBeat.o(128347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.15
 * JD-Core Version:    0.7.0.1
 */