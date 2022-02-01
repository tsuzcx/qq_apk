package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class LuckyMoneyNewYearSendUI$3
  implements DialogInterface.OnClickListener
{
  LuckyMoneyNewYearSendUI$3(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI, MMActivity paramMMActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(65690);
    paramDialogInterface.dismiss();
    this.ytV.finish();
    AppMethodBeat.o(65690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.3
 * JD-Core Version:    0.7.0.1
 */