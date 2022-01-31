package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;

final class FingerPrintEntranceUI$3
  implements DialogInterface.OnClickListener
{
  FingerPrintEntranceUI$3(FingerPrintEntranceUI paramFingerPrintEntranceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
    d.x(this.kmk, "wallet", ".pwd.ui.WalletPasswordSettingUI");
    this.kmk.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.3
 * JD-Core Version:    0.7.0.1
 */