package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class FreeWifiStateUI$3
  implements k.a
{
  private int mOC = -999999999;
  
  FreeWifiStateUI$3(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(21073);
    FreeWifiStateUI.a(this.mOB, this.mOB.bBm());
    if (this.mOC != FreeWifiStateUI.a(this.mOB))
    {
      this.mOC = FreeWifiStateUI.a(this.mOB);
      this.mOB.vc(FreeWifiStateUI.a(this.mOB));
    }
    AppMethodBeat.o(21073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.3
 * JD-Core Version:    0.7.0.1
 */