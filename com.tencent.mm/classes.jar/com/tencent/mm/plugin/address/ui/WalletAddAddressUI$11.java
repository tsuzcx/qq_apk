package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletAddAddressUI$11
  implements MenuItem.OnMenuItemClickListener
{
  WalletAddAddressUI$11(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(16940);
    if (!WalletAddAddressUI.e(this.gMZ))
    {
      AppMethodBeat.o(16940);
      return true;
    }
    Object localObject;
    String str1;
    String str2;
    String str3;
    if (WalletAddAddressUI.f(this.gMZ) != 0)
    {
      WalletAddAddressUI.a(this.gMZ, a.asn().na(WalletAddAddressUI.f(this.gMZ)));
      ab.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(this.gMZ).toString());
      WalletAddAddressUI.b(WalletAddAddressUI.g(this.gMZ), WalletAddAddressUI.h(this.gMZ));
      paramMenuItem = WalletAddAddressUI.i(this.gMZ).getText();
      localObject = WalletAddAddressUI.j(this.gMZ).getText();
      str1 = WalletAddAddressUI.k(this.gMZ).getText();
      str2 = WalletAddAddressUI.l(this.gMZ).getText();
      str3 = WalletAddAddressUI.m(this.gMZ).getText();
      localObject = ((String)localObject).split(" ");
      if (localObject.length > 0) {
        WalletAddAddressUI.h(this.gMZ).gLe = localObject[0];
      }
      if (localObject.length >= 2) {
        WalletAddAddressUI.h(this.gMZ).gLf = localObject[1];
      }
      if (localObject.length < 3) {
        break label338;
      }
    }
    label338:
    for (WalletAddAddressUI.h(this.gMZ).gLg = localObject[2];; WalletAddAddressUI.h(this.gMZ).gLg = "")
    {
      WalletAddAddressUI.h(this.gMZ).gLi = str1;
      WalletAddAddressUI.h(this.gMZ).gLj = paramMenuItem;
      WalletAddAddressUI.h(this.gMZ).gLk = str3;
      WalletAddAddressUI.h(this.gMZ).gLh = str2;
      if (!bo.isNullOrNil(WalletAddAddressUI.n(this.gMZ))) {
        WalletAddAddressUI.h(this.gMZ).gLl = WalletAddAddressUI.n(this.gMZ);
      }
      WalletAddAddressUI.o(this.gMZ);
      AppMethodBeat.o(16940);
      return true;
      WalletAddAddressUI.a(this.gMZ, new b());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.11
 * JD-Core Version:    0.7.0.1
 */