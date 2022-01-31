package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyNewYearReceiveUI$8
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUI$8(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42793);
    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto detail!");
    paramView = new Intent();
    paramView.putExtra("key_native_url", LuckyMoneyNewYearReceiveUI.j(this.ouD));
    d.b(this.ouD, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", paramView);
    AppMethodBeat.o(42793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.8
 * JD-Core Version:    0.7.0.1
 */