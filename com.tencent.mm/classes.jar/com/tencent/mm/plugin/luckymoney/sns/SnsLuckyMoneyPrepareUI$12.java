package com.tencent.mm.plugin.luckymoney.sns;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsLuckyMoneyPrepareUI$12
  implements View.OnClickListener
{
  SnsLuckyMoneyPrepareUI$12(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    if ((!this.lTI.lMr.isShown()) && (!this.eYg))
    {
      SnsLuckyMoneyPrepareUI.k(this.lTI);
      SnsLuckyMoneyPrepareUI.b(this.lTI, this.eYk);
    }
    while (!this.eYg) {
      return;
    }
    this.lTI.VH();
    ((InputMethodManager)this.lTI.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.12
 * JD-Core Version:    0.7.0.1
 */