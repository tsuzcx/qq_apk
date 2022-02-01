package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class PaylistAAUI$14
  implements View.OnClickListener
{
  PaylistAAUI$14(PaylistAAUI paramPaylistAAUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63731);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/aa/ui/PaylistAAUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    PaylistAAUI.a(this.jaM, PaylistAAUI.g(this.jaM));
    a.a(this, "com/tencent/mm/plugin/aa/ui/PaylistAAUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.14
 * JD-Core Version:    0.7.0.1
 */