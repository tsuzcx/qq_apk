package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.ui.base.h;

final class RegByMobileSetNickUI$1
  implements MenuItem.OnMenuItemClickListener
{
  RegByMobileSetNickUI$1(RegByMobileSetNickUI paramRegByMobileSetNickUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(125429);
    paramMenuItem = RegByMobileSetNickUI.a(this.gIB).getText().toString().trim();
    if ((paramMenuItem == null) || (paramMenuItem.length() <= 0))
    {
      h.h(this.gIB, 2131304491, 2131302443);
      AppMethodBeat.o(125429);
      return true;
    }
    this.gIB.hideVKB();
    Object localObject1 = this.gIB.getIntent().getExtras().getString("regbymobile_pwd");
    Object localObject2 = this.gIB.getIntent().getExtras().getString("regbymobile_ticket");
    paramMenuItem = new u("", (String)localObject1, paramMenuItem, 0, "", RegByMobileSetNickUI.b(this.gIB), (String)localObject2, 4);
    g.Rc().a(paramMenuItem, 0);
    localObject1 = this.gIB;
    localObject2 = this.gIB;
    this.gIB.getString(2131297087);
    RegByMobileSetNickUI.a((RegByMobileSetNickUI)localObject1, h.b((Context)localObject2, this.gIB.getString(2131302482), true, new RegByMobileSetNickUI.1.1(this, paramMenuItem)));
    AppMethodBeat.o(125429);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.1
 * JD-Core Version:    0.7.0.1
 */