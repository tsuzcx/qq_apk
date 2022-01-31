package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.ui.base.n.d;

final class WelcomeActivity$6
  implements n.d
{
  WelcomeActivity$6(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(125643);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125643);
      return;
      paramMenuItem = new Intent(this.gKy, RegByMobileRegAIOUI.class);
      this.gKy.startActivity(paramMenuItem);
      AppMethodBeat.o(125643);
      return;
      WelcomeActivity.a(this.gKy).cXw = 1L;
      WelcomeActivity.a(this.gKy).cRH = 2L;
      WelcomeActivity.a(this.gKy).ake();
      WelcomeActivity.b(this.gKy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.6
 * JD-Core Version:    0.7.0.1
 */