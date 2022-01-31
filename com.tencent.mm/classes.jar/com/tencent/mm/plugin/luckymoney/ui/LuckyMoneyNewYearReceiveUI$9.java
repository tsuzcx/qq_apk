package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyNewYearReceiveUI$9
  implements View.OnClickListener
{
  LuckyMoneyNewYearReceiveUI$9(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42794);
    ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "goto BalanceManagerUI!");
    h.an(this.ouD.getContext(), 1);
    AppMethodBeat.o(42794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.9
 * JD-Core Version:    0.7.0.1
 */