package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class SnsLuckyMoneyPrepareUI$20
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$20(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42530);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.oqN.Z(this.oqN.oqE, 2);
    this.oqN.Z(this.oqN.ojG, 0);
    this.oqN.mKeyboard.setXMode(2);
    SnsLuckyMoneyPrepareUI.k(this.oqN);
    AppMethodBeat.o(42530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.20
 * JD-Core Version:    0.7.0.1
 */