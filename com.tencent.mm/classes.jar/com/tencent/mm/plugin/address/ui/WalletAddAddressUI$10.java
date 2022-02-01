package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletAddAddressUI$10
  implements View.OnClickListener
{
  WalletAddAddressUI$10(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20982);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    WalletAddAddressUI.c(this.qks);
    a.a(this, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(20982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.10
 * JD-Core Version:    0.7.0.1
 */