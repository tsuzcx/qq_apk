package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.a.o;
import com.tencent.mm.ui.base.h;

final class WalletSelectAddrUI$3
  implements View.OnClickListener
{
  WalletSelectAddrUI$3(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.fvI, true, this.fvI.getString(R.l.addressui_mall_address_import_confirm, new Object[] { WalletSelectAddrUI.a(this.fvI).toString() }), "", this.fvI.getString(R.l.addressui_mall_address_import_confirm_ok), this.fvI.getString(R.l.app_cancel), new WalletSelectAddrUI.3.1(this), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.3
 * JD-Core Version:    0.7.0.1
 */