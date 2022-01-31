package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;

final class LuckyMoneyF2FQRCodeUI$15
  implements View.OnClickListener
{
  LuckyMoneyF2FQRCodeUI$15(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.lOE, LuckyMoneyPrepareUI.class);
    paramView.putExtra("key_from", 2);
    this.lOE.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.15
 * JD-Core Version:    0.7.0.1
 */