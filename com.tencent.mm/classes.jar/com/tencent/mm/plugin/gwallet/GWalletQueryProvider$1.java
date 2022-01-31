package com.tencent.mm.plugin.gwallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class GWalletQueryProvider$1
  implements b.a
{
  GWalletQueryProvider$1(GWalletQueryProvider paramGWalletQueryProvider) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(41669);
    ab.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
    if (!paramc.isSuccess())
    {
      ab.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: ".concat(String.valueOf(paramc)));
      GWalletQueryProvider.a(this.nGg);
      if (GWalletQueryProvider.b(this.nGg) != null) {
        GWalletQueryProvider.b(this.nGg).dispose();
      }
      GWalletQueryProvider.c(this.nGg);
      AppMethodBeat.o(41669);
      return;
    }
    g.RO().a(new GWalletQueryProvider.1.1(this));
    AppMethodBeat.o(41669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider.1
 * JD-Core Version:    0.7.0.1
 */