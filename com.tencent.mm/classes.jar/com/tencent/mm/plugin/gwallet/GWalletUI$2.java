package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.jg.JgMethodChecked;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.y;

final class GWalletUI$2
  implements b.b
{
  GWalletUI$2(GWalletUI paramGWalletUI) {}
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public final void b(c paramc, Intent paramIntent)
  {
    int j = 1;
    y.d("MicroMsg.GWalletUI", "Purchase finished: " + paramc + ", purchase: " + paramIntent);
    if (paramIntent == null)
    {
      paramIntent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
      paramIntent.putExtra("RESPONSE_CODE", paramc.baN());
      this.liT.sendBroadcast(paramIntent);
      if (paramc.isSuccess()) {
        break label120;
      }
      if (paramc.ljp != 7) {
        break label115;
      }
      i = 1;
      label84:
      if (i != 0) {
        break label120;
      }
    }
    label115:
    label120:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        GWalletUI.a(this.liT, 0, null);
      }
      return;
      paramIntent.setAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
      break;
      i = 0;
      break label84;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI.2
 * JD-Core Version:    0.7.0.1
 */