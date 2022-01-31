package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class FingerPrintAuthTransparentUI$13
  implements DialogInterface.OnCancelListener
{
  FingerPrintAuthTransparentUI$13(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface.dismiss();
    FingerPrintAuthTransparentUI.aTj();
    this.kma.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.13
 * JD-Core Version:    0.7.0.1
 */