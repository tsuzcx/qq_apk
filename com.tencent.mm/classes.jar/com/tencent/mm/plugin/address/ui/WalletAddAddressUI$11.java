package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletAddAddressUI$11
  implements MenuItem.OnMenuItemClickListener
{
  WalletAddAddressUI$11(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!WalletAddAddressUI.e(this.fvu)) {
      return true;
    }
    Object localObject;
    String str1;
    String str2;
    String str3;
    if (WalletAddAddressUI.f(this.fvu) != 0)
    {
      WalletAddAddressUI.a(this.fvu, a.YD().kg(WalletAddAddressUI.f(this.fvu)));
      y.d("MicroMsg.WalletAddAddressUI", "get addr " + WalletAddAddressUI.g(this.fvu).toString());
      WalletAddAddressUI.b(WalletAddAddressUI.g(this.fvu), WalletAddAddressUI.h(this.fvu));
      paramMenuItem = WalletAddAddressUI.i(this.fvu).getText();
      localObject = WalletAddAddressUI.j(this.fvu).getText();
      str1 = WalletAddAddressUI.k(this.fvu).getText();
      str2 = WalletAddAddressUI.l(this.fvu).getText();
      str3 = WalletAddAddressUI.m(this.fvu).getText();
      localObject = ((String)localObject).split(" ");
      if (localObject.length > 0) {
        WalletAddAddressUI.h(this.fvu).ftC = localObject[0];
      }
      if (localObject.length >= 2) {
        WalletAddAddressUI.h(this.fvu).ftD = localObject[1];
      }
      if (localObject.length < 3) {
        break label320;
      }
    }
    label320:
    for (WalletAddAddressUI.h(this.fvu).ftE = localObject[2];; WalletAddAddressUI.h(this.fvu).ftE = "")
    {
      WalletAddAddressUI.h(this.fvu).ftG = str1;
      WalletAddAddressUI.h(this.fvu).ftH = paramMenuItem;
      WalletAddAddressUI.h(this.fvu).ftI = str3;
      WalletAddAddressUI.h(this.fvu).ftF = str2;
      if (!bk.bl(WalletAddAddressUI.n(this.fvu))) {
        WalletAddAddressUI.h(this.fvu).ftJ = WalletAddAddressUI.n(this.fvu);
      }
      WalletAddAddressUI.o(this.fvu);
      return true;
      WalletAddAddressUI.a(this.fvu, new b());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.11
 * JD-Core Version:    0.7.0.1
 */