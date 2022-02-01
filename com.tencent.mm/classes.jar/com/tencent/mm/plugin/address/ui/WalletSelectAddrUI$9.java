package com.tencent.mm.plugin.address.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.a.nb.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

final class WalletSelectAddrUI$9
  implements Runnable
{
  WalletSelectAddrUI$9(WalletSelectAddrUI paramWalletSelectAddrUI, nb paramnb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21030);
    WalletSelectAddrUI.l(this.kvq).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21029);
        if (WalletSelectAddrUI.9.this.kvt.dSM.dFE)
        {
          bg.aVF();
          String str1 = Util.nullAsNil((String)c.azQ().get(46, null));
          bg.aVF();
          String str2 = Util.nullAsNil((String)c.azQ().get(72, null));
          WalletSelectAddrUI.a(WalletSelectAddrUI.9.this.kvq, str1, str2);
        }
        AppMethodBeat.o(21029);
      }
    });
    AppMethodBeat.o(21030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9
 * JD-Core Version:    0.7.0.1
 */