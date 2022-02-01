package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletAddAddressUI$9
  implements View.OnClickListener
{
  WalletAddAddressUI$9(WalletAddAddressUI paramWalletAddAddressUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20982);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    WalletAddAddressUI.c(this.kva);
    a.a(this, "com/tencent/mm/plugin/address/ui/WalletAddAddressUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(20982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletAddAddressUI.9
 * JD-Core Version:    0.7.0.1
 */