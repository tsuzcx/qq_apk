package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$16
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$16(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142066);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.owL.Z(LuckyMoneyPrepareUI.c(this.owL), 2);
    this.owL.Z(LuckyMoneyPrepareUI.b(this.owL), 0);
    this.owL.mKeyboard.setXMode(0);
    this.owL.mKeyboard.setInputEditText((EditText)paramView);
    this.owL.mKBLayout.setVisibility(0);
    AppMethodBeat.o(142066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.16
 * JD-Core Version:    0.7.0.1
 */