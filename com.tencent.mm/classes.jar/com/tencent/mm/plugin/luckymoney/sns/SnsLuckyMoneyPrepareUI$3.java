package com.tencent.mm.plugin.luckymoney.sns;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;

final class SnsLuckyMoneyPrepareUI$3
  implements DialogInterface.OnClickListener
{
  SnsLuckyMoneyPrepareUI$3(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(42510);
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.oqN.getContext(), LuckyMoneyMyRecordUI.class);
    paramDialogInterface.putExtra("key_type", 1);
    this.oqN.startActivity(paramDialogInterface);
    AppMethodBeat.o(42510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */