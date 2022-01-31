package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.base.h;

final class RegByMobileSetNickUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileSetNickUI$1(RegByMobileSetNickUI paramRegByMobileSetNickUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = RegByMobileSetNickUI.a(this.fqY).getText().toString().trim();
    if ((paramMenuItem == null) || (paramMenuItem.length() <= 0))
    {
      h.h(this.fqY, q.j.verify_account_null_tip, q.j.regbymobile_reg_setpwd_alert_title);
      return true;
    }
    this.fqY.XM();
    Object localObject1 = this.fqY.getIntent().getExtras().getString("regbymobile_pwd");
    Object localObject2 = this.fqY.getIntent().getExtras().getString("regbymobile_ticket");
    paramMenuItem = new s("", (String)localObject1, paramMenuItem, 0, "", RegByMobileSetNickUI.b(this.fqY), (String)localObject2, 4);
    g.Dk().a(paramMenuItem, 0);
    localObject1 = this.fqY;
    localObject2 = this.fqY;
    this.fqY.getString(q.j.app_tip);
    RegByMobileSetNickUI.a((RegByMobileSetNickUI)localObject1, h.b((Context)localObject2, this.fqY.getString(q.j.regbyqq_reg_waiting), true, new RegByMobileSetNickUI.1.1(this, paramMenuItem)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.1
 * JD-Core Version:    0.7.0.1
 */