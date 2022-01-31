package com.tencent.mm.plugin.luckymoney.sns;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLuckyMoneyPrepareUI$12
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$12(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42521);
    if ((!this.oqN.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      SnsLuckyMoneyPrepareUI.k(this.oqN);
      SnsLuckyMoneyPrepareUI.b(this.oqN, this.val$editMode);
      AppMethodBeat.o(42521);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.oqN.hideTenpayKB();
      ((InputMethodManager)this.oqN.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(42521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.12
 * JD-Core Version:    0.7.0.1
 */