package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;

final class LuckyMoneyF2FQRCodeUI$15
  implements View.OnClickListener
{
  LuckyMoneyF2FQRCodeUI$15(LuckyMoneyF2FQRCodeUI paramLuckyMoneyF2FQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42189);
    paramView = new Intent(this.olY, LuckyMoneyPrepareUI.class);
    paramView.putExtra("key_from", 2);
    this.olY.startActivity(paramView);
    AppMethodBeat.o(42189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.15
 * JD-Core Version:    0.7.0.1
 */