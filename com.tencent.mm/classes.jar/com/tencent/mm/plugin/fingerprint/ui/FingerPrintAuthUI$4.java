package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

final class FingerPrintAuthUI$4
  implements Runnable
{
  FingerPrintAuthUI$4(FingerPrintAuthUI paramFingerPrintAuthUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    h.a(this.kmg, this.dAG, "", this.kmg.getString(a.i.wallet_i_know_it), false, new FingerPrintAuthUI.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthUI.4
 * JD-Core Version:    0.7.0.1
 */