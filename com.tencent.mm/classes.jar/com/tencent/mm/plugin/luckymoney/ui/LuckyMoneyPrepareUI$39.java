package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$39
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$39(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText, View paramView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142094);
    if ((this.owL.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      if (this.owL.mKeyboard != null)
      {
        this.owL.mKeyboard.setInputEditText(this.val$hintTv);
        AppMethodBeat.o(142094);
      }
    }
    else
    {
      if ((!this.owL.mKBLayout.isShown()) && (!this.val$isShowSysKB))
      {
        ((InputMethodManager)this.owL.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        new ak().postDelayed(new LuckyMoneyPrepareUI.39.1(this), 200L);
        AppMethodBeat.o(142094);
        return;
      }
      if (this.val$isShowSysKB)
      {
        this.owL.mKBLayout.setVisibility(8);
        ((InputMethodManager)this.owL.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
      }
    }
    AppMethodBeat.o(142094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.39
 * JD-Core Version:    0.7.0.1
 */