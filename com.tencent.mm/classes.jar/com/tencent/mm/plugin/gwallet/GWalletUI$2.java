package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class GWalletUI$2
  implements b.b
{
  GWalletUI$2(GWalletUI paramGWalletUI) {}
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public final void b(c paramc, Intent paramIntent)
  {
    int j = 1;
    AppMethodBeat.i(41675);
    ab.d("MicroMsg.GWalletUI", "Purchase finished: " + paramc + ", purchase: " + paramIntent);
    if (paramIntent == null)
    {
      paramIntent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
      paramIntent.putExtra("RESPONSE_CODE", paramc.bHN());
      this.nGi.sendBroadcast(paramIntent);
      if (paramc.isSuccess()) {
        break label130;
      }
      if (paramc.nGE != 7) {
        break label125;
      }
      i = 1;
      label89:
      if (i != 0) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        GWalletUI.a(this.nGi, 0, null);
      }
      AppMethodBeat.o(41675);
      return;
      paramIntent.setAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
      break;
      label125:
      i = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI.2
 * JD-Core Version:    0.7.0.1
 */