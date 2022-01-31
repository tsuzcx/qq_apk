package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class SnsLuckyMoneyPrepareUI$19
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$19(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lTI.J(this.lTI.lTx, 2);
    this.lTI.J(this.lTI.lMm, 0);
    this.lTI.mKeyboard.setXMode(2);
    this.lTI.mKeyboard.setInputEditText((EditText)paramView);
    SnsLuckyMoneyPrepareUI.k(this.lTI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.19
 * JD-Core Version:    0.7.0.1
 */