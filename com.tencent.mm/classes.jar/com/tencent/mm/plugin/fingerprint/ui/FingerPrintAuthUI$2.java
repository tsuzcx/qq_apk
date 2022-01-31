package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Dialog;
import com.tencent.mm.wallet_core.ui.g;

final class FingerPrintAuthUI$2
  implements Runnable
{
  FingerPrintAuthUI$2(FingerPrintAuthUI paramFingerPrintAuthUI, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.kmh) {
      FingerPrintAuthUI.a(this.kmg, g.b(this.kmg, false, null));
    }
    while ((FingerPrintAuthUI.d(this.kmg) == null) || (!FingerPrintAuthUI.d(this.kmg).isShowing())) {
      return;
    }
    FingerPrintAuthUI.d(this.kmg).dismiss();
    FingerPrintAuthUI.a(this.kmg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.2
 * JD-Core Version:    0.7.0.1
 */