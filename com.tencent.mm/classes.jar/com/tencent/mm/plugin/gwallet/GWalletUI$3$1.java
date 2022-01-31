package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class GWalletUI$3$1
  implements b.b
{
  GWalletUI$3$1(GWalletUI.3 param3, boolean paramBoolean) {}
  
  public final void b(c paramc, Intent paramIntent)
  {
    y.d("MicroMsg.GWalletUI", "Purchase finished: " + paramc + ", purchase: " + paramIntent);
    paramc = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
    if (this.liU) {
      paramc.putExtra("RESPONSE_CODE", 100000001);
    }
    for (;;)
    {
      GWalletUI.a(this.liV.liT, -1, paramc);
      return;
      paramc.putExtra("RESPONSE_CODE", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI.3.1
 * JD-Core Version:    0.7.0.1
 */