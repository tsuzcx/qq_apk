package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$24
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$24(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    if ((!this.lXg.lMr.isShown()) && (!this.eYg))
    {
      this.lXg.lMr.setVisibility(0);
      this.lXg.mKeyboard.setInputEditText((EditText)paramView);
      LuckyMoneyPrepareUI.b(this.lXg, this.eYk);
    }
    while (!this.eYg) {
      return;
    }
    this.lXg.lMr.setVisibility(8);
    ((InputMethodManager)this.lXg.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.24
 * JD-Core Version:    0.7.0.1
 */