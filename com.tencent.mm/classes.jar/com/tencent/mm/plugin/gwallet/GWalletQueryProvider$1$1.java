package com.tencent.mm.plugin.gwallet;

import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.sdk.platformtools.ai.a;

final class GWalletQueryProvider$1$1
  implements ai.a
{
  GWalletQueryProvider$1$1(GWalletQueryProvider.1 param1) {}
  
  public final boolean JS()
  {
    GWalletQueryProvider.d(this.liS.liR);
    return true;
  }
  
  public final boolean JT()
  {
    if (GWalletQueryProvider.b(this.liS.liR) != null) {
      GWalletQueryProvider.b(this.liS.liR).dispose();
    }
    GWalletQueryProvider.c(this.liS.liR);
    return true;
  }
  
  public final String toString()
  {
    return super.toString() + "|onIabSetupFinished";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider.1.1
 * JD-Core Version:    0.7.0.1
 */