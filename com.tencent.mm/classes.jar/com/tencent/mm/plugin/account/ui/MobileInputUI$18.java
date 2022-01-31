package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

final class MobileInputUI$18
  implements View.OnClickListener
{
  MobileInputUI$18(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.foH.getString(q.j.freeze_account_url, new Object[] { x.cqJ() });
    MobileInputUI.O(this.foH, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.18
 * JD-Core Version:    0.7.0.1
 */