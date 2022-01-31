package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class GWalletUI$1
  implements b.a
{
  GWalletUI$1(GWalletUI paramGWalletUI) {}
  
  public final void a(c paramc)
  {
    y.d("MicroMsg.GWalletUI", "Setup finished.");
    if (!paramc.isSuccess())
    {
      y.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: " + paramc);
      Intent localIntent = new Intent();
      localIntent.putExtra("RESPONSE_CODE", paramc.baN());
      GWalletUI.a(this.liT, -1, localIntent);
      return;
    }
    if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(this.liT.getIntent().getAction()))
    {
      GWalletUI.a(this.liT);
      return;
    }
    this.liT.gE(this.liT.getIntent().getBooleanExtra("is_direct", true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI.1
 * JD-Core Version:    0.7.0.1
 */