package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$38
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$38(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142092);
    if ((!this.owL.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      this.owL.mKBLayout.setVisibility(0);
      this.owL.mKeyboard.setInputEditText((EditText)paramView);
      LuckyMoneyPrepareUI.c(this.owL, this.val$editMode);
      AppMethodBeat.o(142092);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.owL.mKBLayout.setVisibility(8);
      LuckyMoneyPrepareUI.F(this.owL).setVisibility(0);
      ((InputMethodManager)this.owL.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(142092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.38
 * JD-Core Version:    0.7.0.1
 */