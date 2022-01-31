package com.tencent.mm.plugin.account.security.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SecurityAccountVerifyUI$3
  implements View.OnClickListener
{
  SecurityAccountVerifyUI$3(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    y.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
    SecurityAccountVerifyUI.b(this.fkK).setVisibility(8);
    SecurityAccountVerifyUI.a(this.fkK).setTag(Integer.valueOf(60));
    SecurityAccountVerifyUI.c(this.fkK).stopTimer();
    SecurityAccountVerifyUI.c(this.fkK).S(1000L, 1000L);
    paramView = new a(SecurityAccountVerifyUI.d(this.fkK), 10, "", "", SecurityAccountVerifyUI.e(this.fkK));
    g.Dk().a(paramView, 0);
    SecurityAccountVerifyUI localSecurityAccountVerifyUI = this.fkK;
    AppCompatActivity localAppCompatActivity = this.fkK.mController.uMN;
    this.fkK.getString(a.d.app_tip);
    SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI, h.b(localAppCompatActivity, this.fkK.getString(a.d.safe_device_sending_verify_code), true, new SecurityAccountVerifyUI.3.1(this, paramView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */