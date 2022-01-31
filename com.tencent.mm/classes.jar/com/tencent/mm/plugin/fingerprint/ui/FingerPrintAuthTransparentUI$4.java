package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FingerPrintAuthTransparentUI$4
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$4(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.FingerPrintAuthTransparentUI", "try fingerprint auth again!");
    FingerPrintAuthTransparentUI.d(this.kma);
    FingerPrintAuthTransparentUI.a(this.kma, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.4
 * JD-Core Version:    0.7.0.1
 */