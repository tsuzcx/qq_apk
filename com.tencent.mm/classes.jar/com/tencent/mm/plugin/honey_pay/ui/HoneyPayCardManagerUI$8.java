package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayCardManagerUI$8
  implements View.OnClickListener
{
  HoneyPayCardManagerUI$8(HoneyPayCardManagerUI paramHoneyPayCardManagerUI, cbj paramcbj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64691);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    e.o(this.uGB.getContext(), this.uGE.url, false);
    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardManagerUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.8
 * JD-Core Version:    0.7.0.1
 */