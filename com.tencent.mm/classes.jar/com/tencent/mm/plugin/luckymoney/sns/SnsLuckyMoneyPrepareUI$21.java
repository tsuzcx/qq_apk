package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class SnsLuckyMoneyPrepareUI$21
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$21(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42531);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.oqN.Z(this.oqN.oqE, 2);
    this.oqN.Z(this.oqN.ojG, 0);
    this.oqN.mKeyboard.setXMode(0);
    this.oqN.mKeyboard.setInputEditText((EditText)paramView);
    SnsLuckyMoneyPrepareUI.k(this.oqN);
    AppMethodBeat.o(42531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.21
 * JD-Core Version:    0.7.0.1
 */