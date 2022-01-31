package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.ui.base.n.d;

final class MobileVerifyUI$8$2
  implements n.d
{
  MobileVerifyUI$8$2(MobileVerifyUI.8 param8) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      MobileVerifyUI.g(this.fpX.fpS);
      return;
    }
    this.fpX.fpS.XM();
    if (MobileVerifyUI.f(this.fpX.fpS) == 2) {
      a.qj("R200_500");
    }
    for (;;)
    {
      paramMenuItem = new Intent(this.fpX.fpS, RegByMobileVoiceVerifyUI.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("bindmcontact_mobile", this.fpX.fpS.bSe);
      localBundle.putInt("voice_verify_type", MobileVerifyUI.h(this.fpX.fpS));
      paramMenuItem.putExtras(localBundle);
      this.fpX.fpS.startActivity(paramMenuItem);
      return;
      if (MobileVerifyUI.f(this.fpX.fpS) == 3) {
        a.qj("F200_300");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.8.2
 * JD-Core Version:    0.7.0.1
 */