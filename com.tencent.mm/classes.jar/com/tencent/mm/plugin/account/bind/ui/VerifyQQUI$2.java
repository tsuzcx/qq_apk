package com.tencent.mm.plugin.account.bind.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class VerifyQQUI$2
  implements MenuItem.OnMenuItemClickListener
{
  VerifyQQUI$2(VerifyQQUI paramVerifyQQUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.feR.getText().toString().trim();
    VerifyQQUI.a(this.feQ, this.feS.getText().toString().trim());
    try
    {
      VerifyQQUI.a(this.feQ, bk.getLong(paramMenuItem, 0L));
      if (VerifyQQUI.b(this.feQ) < 10000L)
      {
        h.h(this.feQ.mController.uMN, a.i.bind_qq_verify_alert_qq, a.i.bind_qq_verify_alert_failed_title);
        return true;
      }
    }
    catch (Exception paramMenuItem)
    {
      h.h(this.feQ.mController.uMN, a.i.bind_qq_verify_alert_qq, a.i.bind_qq_verify_alert_failed_title);
      return true;
    }
    if (VerifyQQUI.c(this.feQ).equals(""))
    {
      h.h(this.feQ.mController.uMN, a.i.bind_qq_verify_alert_pwd, a.i.bind_qq_verify_alert_failed_title);
      return true;
    }
    this.feQ.XM();
    paramMenuItem = new b(VerifyQQUI.b(this.feQ), VerifyQQUI.c(this.feQ), "", "", "", VerifyQQUI.d(this.feQ), VerifyQQUI.e(this.feQ), false);
    g.Dk().a(paramMenuItem, 0);
    VerifyQQUI localVerifyQQUI = this.feQ;
    AppCompatActivity localAppCompatActivity = this.feQ.mController.uMN;
    this.feQ.getString(a.i.bind_qq_verify_alert_title);
    VerifyQQUI.a(localVerifyQQUI, h.b(localAppCompatActivity, this.feQ.getString(a.i.bind_qq_verify_alert_binding), true, new VerifyQQUI.2.1(this, paramMenuItem)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.2
 * JD-Core Version:    0.7.0.1
 */