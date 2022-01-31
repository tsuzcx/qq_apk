package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$17
  implements View.OnFocusChangeListener
{
  LuckyMoneyPrepareUI$17(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142067);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.owL.Z(LuckyMoneyPrepareUI.c(this.owL), 2);
    this.owL.Z(LuckyMoneyPrepareUI.b(this.owL), 0);
    AppMethodBeat.o(142067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.17
 * JD-Core Version:    0.7.0.1
 */