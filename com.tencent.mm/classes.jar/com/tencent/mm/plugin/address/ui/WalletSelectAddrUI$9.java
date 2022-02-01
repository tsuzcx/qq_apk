package com.tencent.mm.plugin.address.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.lr.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

final class WalletSelectAddrUI$9
  implements Runnable
{
  WalletSelectAddrUI$9(WalletSelectAddrUI paramWalletSelectAddrUI, lr paramlr) {}
  
  public final void run()
  {
    AppMethodBeat.i(21030);
    WalletSelectAddrUI.k(this.iAW).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21029);
        if (WalletSelectAddrUI.9.this.iAZ.dqt.dew)
        {
          az.arV();
          String str1 = bt.nullAsNil((String)c.afk().get(46, null));
          az.arV();
          String str2 = bt.nullAsNil((String)c.afk().get(72, null));
          WalletSelectAddrUI.a(WalletSelectAddrUI.9.this.iAW, str1, str2);
        }
        AppMethodBeat.o(21029);
      }
    });
    AppMethodBeat.o(21030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9
 * JD-Core Version:    0.7.0.1
 */