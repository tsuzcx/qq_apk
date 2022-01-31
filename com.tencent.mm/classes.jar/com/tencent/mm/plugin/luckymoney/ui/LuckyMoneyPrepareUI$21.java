package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.ao;

final class LuckyMoneyPrepareUI$21
  implements DialogInterface.OnClickListener
{
  LuckyMoneyPrepareUI$21(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, m paramm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142075);
    if (ao.k(this.ckS))
    {
      this.owL.finish();
      AppMethodBeat.o(142075);
      return;
    }
    AppMethodBeat.o(142075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.21
 * JD-Core Version:    0.7.0.1
 */