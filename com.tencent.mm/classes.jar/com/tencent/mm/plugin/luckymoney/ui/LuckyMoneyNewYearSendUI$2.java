package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.ao;

final class LuckyMoneyNewYearSendUI$2
  implements DialogInterface.OnClickListener
{
  LuckyMoneyNewYearSendUI$2(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(42809);
    if (ao.k(this.ckS))
    {
      this.ovl.finish();
      AppMethodBeat.o(42809);
      return;
    }
    AppMethodBeat.o(42809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.2
 * JD-Core Version:    0.7.0.1
 */