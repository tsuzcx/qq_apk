package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.am;
import com.tencent.mm.sdk.platformtools.bo;

final class LuckyMoneyBusiDetailUI$10
  implements LuckyMoneyWishFooter.b
{
  LuckyMoneyBusiDetailUI$10(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void Sw(String paramString)
  {
    AppMethodBeat.i(42592);
    if ((!bo.isNullOrNil(paramString)) && (!bo.isNullOrNil(LuckyMoneyBusiDetailUI.g(this.orQ))))
    {
      paramString = new am(LuckyMoneyBusiDetailUI.h(this.orQ), paramString, LuckyMoneyBusiDetailUI.g(this.orQ), "v1.0");
      this.orQ.doSceneProgress(paramString);
      LuckyMoneyBusiDetailUI.e(this.orQ);
    }
    AppMethodBeat.o(42592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.10
 * JD-Core Version:    0.7.0.1
 */