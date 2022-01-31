package com.tencent.mm.plugin.honey_pay.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ui.widget.MMEditText;

final class HoneyPayGiveCardUI$5
  implements TextView.OnEditorActionListener
{
  HoneyPayGiveCardUI$5(HoneyPayGiveCardUI paramHoneyPayGiveCardUI) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 5))
    {
      HoneyPayGiveCardUI.a(this.llB, HoneyPayGiveCardUI.e(this.llB).getText().toString());
      this.llB.XM();
      HoneyPayGiveCardUI.f(this.llB);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.5
 * JD-Core Version:    0.7.0.1
 */