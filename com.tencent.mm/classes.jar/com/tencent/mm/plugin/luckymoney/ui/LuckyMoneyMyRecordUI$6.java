package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyMyRecordUI$6
  implements View.OnClickListener
{
  LuckyMoneyMyRecordUI$6(LuckyMoneyMyRecordUI paramLuckyMoneyMyRecordUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42763);
    if (!bo.isNullOrNil(this.oua.opu))
    {
      e.m(this.oua, this.oua.opu, true);
      AppMethodBeat.o(42763);
      return;
    }
    ab.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
    AppMethodBeat.o(42763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.6
 * JD-Core Version:    0.7.0.1
 */