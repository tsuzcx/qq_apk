package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FingerPrintEntranceUI$1
  implements DialogInterface.OnClickListener
{
  FingerPrintEntranceUI$1(FingerPrintEntranceUI paramFingerPrintEntranceUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.FingerPrintEntranceUI", "user click the button to set system fingerprint");
    FingerPrintEntranceUI.a(this.kmk);
    this.kmk.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintEntranceUI.1
 * JD-Core Version:    0.7.0.1
 */