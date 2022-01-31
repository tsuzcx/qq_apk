package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$23$1
  implements Runnable
{
  LuckyMoneyPrepareUI$23$1(LuckyMoneyPrepareUI.23 param23, View paramView) {}
  
  public final void run()
  {
    if ((!this.lXk.lXg.lMr.isShown()) && (this.val$view.isShown())) {
      this.lXk.lXg.lMr.setVisibility(0);
    }
    LuckyMoneyPrepareUI.b(this.lXk.lXg, this.lXk.eYk);
    this.lXk.lXg.mKeyboard.setInputEditText((EditText)this.val$view);
    ((InputMethodManager)this.lXk.lXg.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.23.1
 * JD-Core Version:    0.7.0.1
 */