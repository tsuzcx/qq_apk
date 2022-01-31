package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$37$1
  implements Runnable
{
  LuckyMoneyPrepareUI$37$1(LuckyMoneyPrepareUI.37 param37, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(142089);
    if ((!this.owU.owL.mKBLayout.isShown()) && (this.val$view.isShown()))
    {
      this.owU.owL.mKBLayout.setVisibility(0);
      LuckyMoneyPrepareUI.F(this.owU.owL).setVisibility(8);
    }
    LuckyMoneyPrepareUI.c(this.owU.owL, this.owU.val$editMode);
    this.owU.owL.mKeyboard.setInputEditText((EditText)this.val$view);
    ((InputMethodManager)this.owU.owL.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    AppMethodBeat.o(142089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.37.1
 * JD-Core Version:    0.7.0.1
 */