package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerPrintEntranceUI$3
  implements DialogInterface.OnClickListener
{
  FingerPrintEntranceUI$3(FingerPrintEntranceUI paramFingerPrintEntranceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41657);
    ab.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
    d.H(this.mHa, "wallet", ".pwd.ui.WalletPasswordSettingUI");
    this.mHa.finish();
    AppMethodBeat.o(41657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.3
 * JD-Core Version:    0.7.0.1
 */