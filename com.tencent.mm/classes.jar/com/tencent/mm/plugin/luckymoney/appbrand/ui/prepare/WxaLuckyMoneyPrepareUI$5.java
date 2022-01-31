package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLuckyMoneyPrepareUI$5
  implements View.OnFocusChangeListener
{
  WxaLuckyMoneyPrepareUI$5(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(42057);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.ojQ.Z(WxaLuckyMoneyPrepareUI.b(this.ojQ), 2);
    this.ojQ.Z(WxaLuckyMoneyPrepareUI.c(this.ojQ), 0);
    AppMethodBeat.o(42057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.5
 * JD-Core Version:    0.7.0.1
 */