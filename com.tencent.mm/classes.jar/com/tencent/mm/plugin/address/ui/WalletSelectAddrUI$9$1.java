package com.tencent.mm.plugin.address.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.km.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class WalletSelectAddrUI$9$1
  implements Runnable
{
  WalletSelectAddrUI$9$1(WalletSelectAddrUI.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(16986);
    if (this.gNs.gNr.cAk.cpz)
    {
      aw.aaz();
      String str1 = bo.nullAsNil((String)c.Ru().get(46, null));
      aw.aaz();
      String str2 = bo.nullAsNil((String)c.Ru().get(72, null));
      WalletSelectAddrUI.a(this.gNs.gNo, str1, str2);
    }
    AppMethodBeat.o(16986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9.1
 * JD-Core Version:    0.7.0.1
 */