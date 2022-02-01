package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class IPCallShareCouponCardUI$11
  implements View.OnClickListener
{
  IPCallShareCouponCardUI$11(IPCallShareCouponCardUI paramIPCallShareCouponCardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25913);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    IPCallShareCouponCardUI.a(this.uTO);
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.11
 * JD-Core Version:    0.7.0.1
 */