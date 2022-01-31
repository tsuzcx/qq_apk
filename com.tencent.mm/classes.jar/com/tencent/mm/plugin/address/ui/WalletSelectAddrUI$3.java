package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ui.base.h;

final class WalletSelectAddrUI$3
  implements View.OnClickListener
{
  WalletSelectAddrUI$3(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(16979);
    h.a(this.gNo, true, this.gNo.getString(2131296505, new Object[] { WalletSelectAddrUI.a(this.gNo).toString() }), "", this.gNo.getString(2131296506), this.gNo.getString(2131296888), new WalletSelectAddrUI.3.1(this), null);
    AppMethodBeat.o(16979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.3
 * JD-Core Version:    0.7.0.1
 */