package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyF2FReceiveUI$8
  implements DialogInterface.OnClickListener
{
  LuckyMoneyF2FReceiveUI$8(LuckyMoneyF2FReceiveUI paramLuckyMoneyF2FReceiveUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(42218);
    this.omq.finish();
    AppMethodBeat.o(42218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.8
 * JD-Core Version:    0.7.0.1
 */