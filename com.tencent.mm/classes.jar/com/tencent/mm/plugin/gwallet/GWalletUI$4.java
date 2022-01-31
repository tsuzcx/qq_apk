package com.tencent.mm.plugin.gwallet;

import android.content.Intent;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class GWalletUI$4
  implements b.b
{
  GWalletUI$4(GWalletUI paramGWalletUI, boolean paramBoolean) {}
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public final void b(c paramc, Intent paramIntent)
  {
    AppMethodBeat.i(41678);
    ab.d("MicroMsg.GWalletUI", "Query inventory finished. data : ".concat(String.valueOf(paramIntent)));
    if (paramIntent == null)
    {
      paramIntent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
      paramIntent.putExtra("RESPONSE_CODE", paramc.bHN());
    }
    for (;;)
    {
      if (!this.nGl) {
        paramIntent.putExtra("is_direct", false);
      }
      this.nGi.sendBroadcast(paramIntent);
      AppMethodBeat.o(41678);
      return;
      paramIntent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.GWalletUI.4
 * JD-Core Version:    0.7.0.1
 */