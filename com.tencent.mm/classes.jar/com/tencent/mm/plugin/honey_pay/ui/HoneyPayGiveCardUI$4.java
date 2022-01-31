package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class HoneyPayGiveCardUI$4
  implements View.OnClickListener
{
  HoneyPayGiveCardUI$4(HoneyPayGiveCardUI paramHoneyPayGiveCardUI) {}
  
  public final void onClick(View paramView)
  {
    y.d(this.llB.TAG, "click give btn");
    if (HoneyPayGiveCardUI.a(this.llB))
    {
      this.llB.VH();
      HoneyPayGiveCardUI.d(this.llB);
      return;
    }
    y.w(this.llB.TAG, "over limit when click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.4
 * JD-Core Version:    0.7.0.1
 */