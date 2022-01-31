package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class SecurityAccountVerifyUI$6
  implements MenuItem.OnMenuItemClickListener
{
  SecurityAccountVerifyUI$6(SecurityAccountVerifyUI paramSecurityAccountVerifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(69922);
    paramMenuItem = SecurityAccountVerifyUI.g(this.gCb).getText().toString().trim();
    if (bo.isNullOrNil(paramMenuItem))
    {
      h.h(this.gCb, 2131297622, 2131297087);
      AppMethodBeat.o(69922);
      return true;
    }
    this.gCb.hideVKB();
    SecurityAccountVerifyUI.a(this.gCb, f.cF(this.gCb));
    SecurityAccountVerifyUI.b(this.gCb, f.arb());
    if (!SecurityAccountVerifyUI.h(this.gCb)) {}
    for (paramMenuItem = new a(SecurityAccountVerifyUI.d(this.gCb), paramMenuItem, "", SecurityAccountVerifyUI.e(this.gCb), SecurityAccountVerifyUI.i(this.gCb), SecurityAccountVerifyUI.j(this.gCb));; paramMenuItem = new x(SecurityAccountVerifyUI.d(this.gCb), 11, paramMenuItem, "", SecurityAccountVerifyUI.i(this.gCb), SecurityAccountVerifyUI.j(this.gCb)))
    {
      g.Rc().a(paramMenuItem, 0);
      SecurityAccountVerifyUI localSecurityAccountVerifyUI1 = this.gCb;
      SecurityAccountVerifyUI localSecurityAccountVerifyUI2 = this.gCb;
      this.gCb.getString(2131297087);
      SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI1, h.b(localSecurityAccountVerifyUI2, this.gCb.getString(2131297610), true, new SecurityAccountVerifyUI.6.1(this, paramMenuItem)));
      AppMethodBeat.o(69922);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.6
 * JD-Core Version:    0.7.0.1
 */