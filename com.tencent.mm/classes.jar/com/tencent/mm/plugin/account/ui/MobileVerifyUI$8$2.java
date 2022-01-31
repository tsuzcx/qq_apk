package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.ui.base.n.d;

final class MobileVerifyUI$8$2
  implements n.d
{
  MobileVerifyUI$8$2(MobileVerifyUI.8 param8) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(125274);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(125274);
      return;
    case 0: 
      MobileVerifyUI.g(this.gHu.gHp);
      AppMethodBeat.o(125274);
      return;
    }
    this.gHu.gHp.hideVKB();
    if (MobileVerifyUI.f(this.gHu.gHp) == 2) {
      a.xD("R200_500");
    }
    for (;;)
    {
      paramMenuItem = new Intent(this.gHu.gHp, RegByMobileVoiceVerifyUI.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("bindmcontact_mobile", this.gHu.gHp.czF);
      localBundle.putInt("voice_verify_type", MobileVerifyUI.h(this.gHu.gHp));
      paramMenuItem.putExtras(localBundle);
      this.gHu.gHp.startActivity(paramMenuItem);
      break;
      if (MobileVerifyUI.f(this.gHu.gHp) == 3) {
        a.xD("F200_300");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8.2
 * JD-Core Version:    0.7.0.1
 */