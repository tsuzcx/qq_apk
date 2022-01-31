package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.pluginsdk.wallet.a;

final class FingerPrintAuthUI$1
  implements a
{
  FingerPrintAuthUI$1(FingerPrintAuthUI paramFingerPrintAuthUI) {}
  
  public final void ai(int paramInt, String paramString)
  {
    this.kmg.ew(false);
    if (paramInt == 0)
    {
      FingerPrintAuthUI.b(this.kmg);
      if (FingerPrintAuthUI.c(this.kmg)) {
        FingerPrintAuthUI.a(this.kmg, false);
      }
      return;
    }
    FingerPrintAuthUI.a(this.kmg, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.1
 * JD-Core Version:    0.7.0.1
 */