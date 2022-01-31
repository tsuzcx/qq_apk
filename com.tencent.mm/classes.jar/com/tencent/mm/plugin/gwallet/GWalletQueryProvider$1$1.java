package com.tencent.mm.plugin.gwallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.sdk.platformtools.al.a;

final class GWalletQueryProvider$1$1
  implements al.a
{
  GWalletQueryProvider$1$1(GWalletQueryProvider.1 param1) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(41666);
    GWalletQueryProvider.d(this.nGh.nGg);
    AppMethodBeat.o(41666);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(41667);
    if (GWalletQueryProvider.b(this.nGh.nGg) != null) {
      GWalletQueryProvider.b(this.nGh.nGg).dispose();
    }
    GWalletQueryProvider.c(this.nGh.nGg);
    AppMethodBeat.o(41667);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(41668);
    String str = super.toString() + "|onIabSetupFinished";
    AppMethodBeat.o(41668);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider.1.1
 * JD-Core Version:    0.7.0.1
 */