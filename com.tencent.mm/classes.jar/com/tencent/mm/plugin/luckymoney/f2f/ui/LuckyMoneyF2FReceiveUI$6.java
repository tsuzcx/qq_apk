package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyF2FReceiveUI$6
  implements DialogInterface.OnClickListener
{
  LuckyMoneyF2FReceiveUI$6(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(42216);
    this.omq.finish();
    AppMethodBeat.o(42216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.6
 * JD-Core Version:    0.7.0.1
 */