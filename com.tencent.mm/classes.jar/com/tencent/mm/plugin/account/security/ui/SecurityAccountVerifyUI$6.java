package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class SecurityAccountVerifyUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SecurityAccountVerifyUI$6(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = SecurityAccountVerifyUI.g(this.fkK).getText().toString().trim();
    if (bk.bl(paramMenuItem))
    {
      h.h(this.fkK, a.d.bind_mcontact_verifynull, a.d.app_tip);
      return true;
    }
    this.fkK.XM();
    SecurityAccountVerifyUI.a(this.fkK, f.bZ(this.fkK));
    SecurityAccountVerifyUI.b(this.fkK, f.Xz());
    if (!SecurityAccountVerifyUI.h(this.fkK)) {}
    for (paramMenuItem = new a(SecurityAccountVerifyUI.d(this.fkK), paramMenuItem, "", SecurityAccountVerifyUI.e(this.fkK), SecurityAccountVerifyUI.i(this.fkK), SecurityAccountVerifyUI.j(this.fkK));; paramMenuItem = new x(SecurityAccountVerifyUI.d(this.fkK), 11, paramMenuItem, "", SecurityAccountVerifyUI.i(this.fkK), SecurityAccountVerifyUI.j(this.fkK)))
    {
      g.Dk().a(paramMenuItem, 0);
      SecurityAccountVerifyUI localSecurityAccountVerifyUI1 = this.fkK;
      SecurityAccountVerifyUI localSecurityAccountVerifyUI2 = this.fkK;
      this.fkK.getString(a.d.app_tip);
      SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI1, h.b(localSecurityAccountVerifyUI2, this.fkK.getString(a.d.bind_mcontact_verifing), true, new SecurityAccountVerifyUI.6.1(this, paramMenuItem)));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */