package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class LuckyMoneyPrepareUI$37
  implements View.OnFocusChangeListener
{
  boolean owT = true;
  
  LuckyMoneyPrepareUI$37(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142091);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.owL.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new LuckyMoneyPrepareUI.37.1(this, paramView), 300L);
      AppMethodBeat.o(142091);
      return;
    }
    new ak().postDelayed(new LuckyMoneyPrepareUI.37.2(this), 200L);
    AppMethodBeat.o(142091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.37
 * JD-Core Version:    0.7.0.1
 */