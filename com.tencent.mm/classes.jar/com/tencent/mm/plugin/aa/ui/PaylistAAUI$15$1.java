package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.wallet_core.ui.e;

final class PaylistAAUI$15$1
  implements DialogInterface.OnClickListener
{
  PaylistAAUI$15$1(PaylistAAUI.15 param15, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40883);
    e.m(this.grN.grF.getContext(), this.grM.kNB, false);
    AppMethodBeat.o(40883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.15.1
 * JD-Core Version:    0.7.0.1
 */