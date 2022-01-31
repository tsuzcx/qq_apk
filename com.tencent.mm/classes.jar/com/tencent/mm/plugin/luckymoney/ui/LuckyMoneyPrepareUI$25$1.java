package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$25$1
  implements Runnable
{
  LuckyMoneyPrepareUI$25$1(LuckyMoneyPrepareUI.25 param25) {}
  
  public final void run()
  {
    this.lXl.lXg.lMr.setVisibility(0);
    this.lXl.eYj.requestFocus();
    if (this.lXl.lXg.mKeyboard != null) {
      this.lXl.lXg.mKeyboard.setInputEditText(this.lXl.eYi);
    }
    LuckyMoneyPrepareUI.b(this.lXl.lXg, this.lXl.eYk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.25.1
 * JD-Core Version:    0.7.0.1
 */