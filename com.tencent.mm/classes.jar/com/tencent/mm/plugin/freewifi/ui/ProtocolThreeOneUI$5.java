package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class ProtocolThreeOneUI$5
  implements k.a
{
  private int mOC = -999999999;
  
  ProtocolThreeOneUI$5(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(21125);
    ProtocolThreeOneUI.a(this.mOW, this.mOW.bBm());
    if (this.mOC != ProtocolThreeOneUI.a(this.mOW))
    {
      this.mOC = ProtocolThreeOneUI.a(this.mOW);
      this.mOW.wn(ProtocolThreeOneUI.a(this.mOW));
    }
    AppMethodBeat.o(21125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.5
 * JD-Core Version:    0.7.0.1
 */