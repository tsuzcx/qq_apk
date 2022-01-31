package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.a.a;

final class LuckyMoneyPrepareUI$27
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$27(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString, h paramh1, h paramh2) {}
  
  public final void onClick(View paramView)
  {
    if (!a.a.cAj().cAi()) {
      return;
    }
    if (LuckyMoneyPrepareUI.e(this.lXg).getText().toString().equals(this.lMD.toString()))
    {
      this.lXm.onClick(paramView);
      return;
    }
    this.lXn.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.27
 * JD-Core Version:    0.7.0.1
 */