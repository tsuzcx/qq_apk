package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletSelectAddrUI$6
  implements View.OnClickListener
{
  WalletSelectAddrUI$6(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21026);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    WalletSelectAddrUI.j(this.kvq);
    a.a(this, "com/tencent/mm/plugin/address/ui/WalletSelectAddrUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(21026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.6
 * JD-Core Version:    0.7.0.1
 */