package com.tencent.mm.plugin.account.security.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.ui.base.h;

final class SecurityAccountIntroUI$1
  implements View.OnClickListener
{
  SecurityAccountIntroUI$1(SecurityAccountIntroUI paramSecurityAccountIntroUI) {}
  
  public final void onClick(View paramView)
  {
    if (!SecurityAccountIntroUI.a(this.fkC)) {}
    for (paramView = new a(SecurityAccountIntroUI.b(this.fkC), 10, "", "", SecurityAccountIntroUI.c(this.fkC));; paramView = new x(SecurityAccountIntroUI.b(this.fkC), 10, "", 0, ""))
    {
      g.Dk().a(paramView, 0);
      SecurityAccountIntroUI localSecurityAccountIntroUI1 = this.fkC;
      SecurityAccountIntroUI localSecurityAccountIntroUI2 = this.fkC;
      this.fkC.getString(a.d.app_tip);
      SecurityAccountIntroUI.a(localSecurityAccountIntroUI1, h.b(localSecurityAccountIntroUI2, this.fkC.getString(a.d.safe_device_sending_verify_code), true, new SecurityAccountIntroUI.1.1(this, paramView)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.1
 * JD-Core Version:    0.7.0.1
 */