package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.wallet_core.ui.g;

final class PaylistAAUI$2$1
  implements DialogInterface.OnClickListener
{
  PaylistAAUI$2$1(PaylistAAUI.2 param2, o paramo) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(40865);
    PaylistAAUI.a(this.grH.grF, this.grG);
    PaylistAAUI.a(this.grH.grF, g.b(this.grH.grF, false, null));
    AppMethodBeat.o(40865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.2.1
 * JD-Core Version:    0.7.0.1
 */