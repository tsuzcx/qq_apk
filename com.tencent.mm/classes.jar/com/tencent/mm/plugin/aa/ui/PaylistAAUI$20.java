package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class PaylistAAUI$20
  implements DialogInterface.OnClickListener
{
  PaylistAAUI$20(PaylistAAUI paramPaylistAAUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(189722);
    Log.i("MicroMsg.Aa.PaylistAAUI", "click AlertDialog");
    AppMethodBeat.o(189722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.20
 * JD-Core Version:    0.7.0.1
 */