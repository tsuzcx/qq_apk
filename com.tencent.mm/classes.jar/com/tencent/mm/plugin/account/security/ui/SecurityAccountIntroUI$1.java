package com.tencent.mm.plugin.account.security.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.ui.base.h;

final class SecurityAccountIntroUI$1
  implements View.OnClickListener
{
  SecurityAccountIntroUI$1(SecurityAccountIntroUI paramSecurityAccountIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(69904);
    if (!SecurityAccountIntroUI.a(this.gBT)) {}
    for (paramView = new a(SecurityAccountIntroUI.b(this.gBT), 10, "", "", SecurityAccountIntroUI.c(this.gBT));; paramView = new x(SecurityAccountIntroUI.b(this.gBT), 10, "", 0, ""))
    {
      g.Rc().a(paramView, 0);
      SecurityAccountIntroUI localSecurityAccountIntroUI1 = this.gBT;
      SecurityAccountIntroUI localSecurityAccountIntroUI2 = this.gBT;
      this.gBT.getString(2131297087);
      SecurityAccountIntroUI.a(localSecurityAccountIntroUI1, h.b(localSecurityAccountIntroUI2, this.gBT.getString(2131302860), true, new SecurityAccountIntroUI.1.1(this, paramView)));
      AppMethodBeat.o(69904);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.1
 * JD-Core Version:    0.7.0.1
 */