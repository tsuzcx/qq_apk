package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class PaylistAAUI$4
  implements View.OnClickListener
{
  PaylistAAUI$4(PaylistAAUI paramPaylistAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213103);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.Aa.PaylistAAUI", "click mInstantPayBtn");
    PaylistAAUI.a(this.jYI, PaylistAAUI.i(this.jYI));
    a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.4
 * JD-Core Version:    0.7.0.1
 */