package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuckyMoneyPrepareUI$23
  implements View.OnFocusChangeListener
{
  LuckyMoneyPrepareUI$23(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView.isFocused()) && (!this.eYg))
    {
      ((InputMethodManager)this.lXg.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ah().postDelayed(new LuckyMoneyPrepareUI.23.1(this, paramView), 300L);
      return;
    }
    new ah().postDelayed(new LuckyMoneyPrepareUI.23.2(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.23
 * JD-Core Version:    0.7.0.1
 */