package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.h.a.jz;
import com.tencent.mm.h.a.jz.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

final class WalletSelectAddrUI$9$1
  implements Runnable
{
  WalletSelectAddrUI$9$1(WalletSelectAddrUI.9 param9) {}
  
  public final void run()
  {
    if (this.fvM.fvL.bSF.bIe)
    {
      au.Hx();
      String str1 = bk.pm((String)c.Dz().get(46, null));
      au.Hx();
      String str2 = bk.pm((String)c.Dz().get(72, null));
      WalletSelectAddrUI.a(this.fvM.fvI, str1, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9.1
 * JD-Core Version:    0.7.0.1
 */