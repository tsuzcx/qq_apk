package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class MobileInputUI$15
  implements View.OnClickListener
{
  MobileInputUI$15(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    d.x(this.foH, "login_exdevice", ".ui.LoginAsExDeviceUI");
    this.foH.overridePendingTransition(q.a.push_down_in, q.a.anim_not_change);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.15
 * JD-Core Version:    0.7.0.1
 */