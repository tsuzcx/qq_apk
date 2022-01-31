package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class ProtocolThreeTwoUI$7
  implements k.a
{
  private int mOC = -999999999;
  
  ProtocolThreeTwoUI$7(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(21179);
    ProtocolThreeTwoUI.a(this.mPc, this.mPc.bBm());
    if (this.mOC != ProtocolThreeTwoUI.a(this.mPc))
    {
      this.mOC = ProtocolThreeTwoUI.a(this.mPc);
      this.mPc.wn(ProtocolThreeTwoUI.a(this.mPc));
    }
    AppMethodBeat.o(21179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.7
 * JD-Core Version:    0.7.0.1
 */