package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.ui.base.h;

final class RegByQQAuthUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RegByQQAuthUI$1(RegByQQAuthUI paramRegByQQAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    RegByQQAuthUI.a(this.frL, RegByQQAuthUI.a(this.frL).getText().toString().trim());
    if (RegByQQAuthUI.b(this.frL).equals(""))
    {
      h.h(this.frL, q.j.verify_account_null_tip, q.j.app_err_reg_title);
      return true;
    }
    paramMenuItem = new s("", RegByQQAuthUI.c(this.frL), RegByQQAuthUI.b(this.frL), RegByQQAuthUI.d(this.frL), "", "", RegByQQAuthUI.e(this.frL), 2);
    g.Dk().a(paramMenuItem, 0);
    RegByQQAuthUI localRegByQQAuthUI1 = this.frL;
    RegByQQAuthUI localRegByQQAuthUI2 = this.frL;
    this.frL.getString(q.j.app_tip);
    RegByQQAuthUI.a(localRegByQQAuthUI1, h.b(localRegByQQAuthUI2, this.frL.getString(q.j.regbyqq_reg_waiting), true, new RegByQQAuthUI.1.1(this, paramMenuItem)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI.1
 * JD-Core Version:    0.7.0.1
 */