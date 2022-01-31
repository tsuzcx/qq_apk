package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FingerPrintAuthTransparentUI$2
  implements DialogInterface.OnClickListener
{
  FingerPrintAuthTransparentUI$2(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    y.i("MicroMsg.FingerPrintAuthTransparentUI", "showSuccessAlert, finish ui!");
    this.kma.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.2
 * JD-Core Version:    0.7.0.1
 */