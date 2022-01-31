package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b.c;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class GWalletQueryProvider$2
  implements b.c
{
  GWalletQueryProvider$2(GWalletQueryProvider paramGWalletQueryProvider) {}
  
  public final void a(c paramc, Intent paramIntent)
  {
    AppMethodBeat.i(41670);
    ab.d("MicroMsg.GWalletQueryProvider", "query detail done! Result ".concat(String.valueOf(paramc)));
    GWalletQueryProvider.e(this.nGg);
    GWalletQueryProvider.a(this.nGg, paramIntent.getStringArrayListExtra("RESPONSE_QUERY_DETAIL_INFO"));
    GWalletQueryProvider.a(this.nGg, paramIntent.getIntExtra("RESPONSE_CODE", 0));
    AppMethodBeat.o(41670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider.2
 * JD-Core Version:    0.7.0.1
 */