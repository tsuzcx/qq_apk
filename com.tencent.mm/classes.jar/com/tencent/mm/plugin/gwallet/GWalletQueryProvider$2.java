package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.c;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class GWalletQueryProvider$2
  implements b.c
{
  GWalletQueryProvider$2(GWalletQueryProvider paramGWalletQueryProvider) {}
  
  public final void a(c paramc, Intent paramIntent)
  {
    y.d("MicroMsg.GWalletQueryProvider", "query detail done! Result " + paramc);
    GWalletQueryProvider.e(this.liR);
    GWalletQueryProvider.a(this.liR, paramIntent.getStringArrayListExtra("RESPONSE_QUERY_DETAIL_INFO"));
    GWalletQueryProvider.a(this.liR, paramIntent.getIntExtra("RESPONSE_CODE", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletQueryProvider.2
 * JD-Core Version:    0.7.0.1
 */