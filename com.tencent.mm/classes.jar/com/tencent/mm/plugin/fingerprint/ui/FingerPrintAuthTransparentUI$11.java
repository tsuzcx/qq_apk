package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.platformtools.y;

final class FingerPrintAuthTransparentUI$11
  implements a
{
  FingerPrintAuthTransparentUI$11(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void ai(int paramInt, String paramString)
  {
    this.kma.ew(false);
    if (paramInt == 0)
    {
      y.i("MicroMsg.FingerPrintAuthTransparentUI", "cert ready and do openFP");
      FingerPrintAuthTransparentUI.d(this.kma);
      FingerPrintAuthTransparentUI.a(this.kma, false);
      return;
    }
    FingerPrintAuthTransparentUI.a(this.kma, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.11
 * JD-Core Version:    0.7.0.1
 */