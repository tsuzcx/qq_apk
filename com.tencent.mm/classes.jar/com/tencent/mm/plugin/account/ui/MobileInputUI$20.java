package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

final class MobileInputUI$20
  implements n.d
{
  MobileInputUI$20(MobileInputUI paramMobileInputUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 5001: 
      MobileInputUI.d(this.foH);
      return;
    }
    MobileInputUI.O(this.foH, this.foH.getString(q.j.wechat_help_center_url) + x.cqJ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.20
 * JD-Core Version:    0.7.0.1
 */