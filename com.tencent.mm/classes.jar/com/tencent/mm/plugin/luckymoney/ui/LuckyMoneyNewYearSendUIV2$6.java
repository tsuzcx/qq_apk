package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class LuckyMoneyNewYearSendUIV2$6
  implements DialogInterface.OnClickListener
{
  LuckyMoneyNewYearSendUIV2$6(LuckyMoneyNewYearSendUIV2 paramLuckyMoneyNewYearSendUIV2, MMActivity paramMMActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(284134);
    paramDialogInterface.dismiss();
    this.ytV.finish();
    AppMethodBeat.o(284134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUIV2.6
 * JD-Core Version:    0.7.0.1
 */