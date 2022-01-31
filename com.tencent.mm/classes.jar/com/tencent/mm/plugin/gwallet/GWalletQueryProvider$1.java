package com.tencent.mm.plugin.gwallet;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class GWalletQueryProvider$1
  implements b.a
{
  GWalletQueryProvider$1(GWalletQueryProvider paramGWalletQueryProvider) {}
  
  public final void a(c paramc)
  {
    y.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
    if (!paramc.isSuccess())
    {
      y.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: " + paramc);
      GWalletQueryProvider.a(this.liR);
      if (GWalletQueryProvider.b(this.liR) != null) {
        GWalletQueryProvider.b(this.liR).dispose();
      }
      GWalletQueryProvider.c(this.liR);
      return;
    }
    g.DS().a(new GWalletQueryProvider.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider.1
 * JD-Core Version:    0.7.0.1
 */