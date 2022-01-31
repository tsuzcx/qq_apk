package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$25
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$25(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText, View paramView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if ((this.lXg.lMr.isShown()) && (!this.eYg)) {
      if (this.lXg.mKeyboard != null) {
        this.lXg.mKeyboard.setInputEditText(this.eYi);
      }
    }
    do
    {
      return;
      if ((!this.lXg.lMr.isShown()) && (!this.eYg))
      {
        ((InputMethodManager)this.lXg.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        new ah().postDelayed(new LuckyMoneyPrepareUI.25.1(this), 200L);
        return;
      }
    } while (!this.eYg);
    this.lXg.lMr.setVisibility(8);
    ((InputMethodManager)this.lXg.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.25
 * JD-Core Version:    0.7.0.1
 */