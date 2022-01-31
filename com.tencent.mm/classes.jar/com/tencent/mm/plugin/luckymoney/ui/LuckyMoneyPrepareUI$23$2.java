package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyPrepareUI$23$2
  implements Runnable
{
  LuckyMoneyPrepareUI$23$2(LuckyMoneyPrepareUI.23 param23) {}
  
  public final void run()
  {
    this.lXk.lXg.VH();
    ((InputMethodManager)this.lXk.lXg.mController.uMN.getSystemService("input_method")).showSoftInput(this.lXk.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.23.2
 * JD-Core Version:    0.7.0.1
 */