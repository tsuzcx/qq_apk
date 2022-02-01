package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.wallet_core.ui.e;

final class MallIndexUIv2$6
  implements View.OnClickListener
{
  MallIndexUIv2$6(MallIndexUIv2 paramMallIndexUIv2, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199052);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    e.aW(this.vGs.getContext(), this.vGg.vDd);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(199052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.6
 * JD-Core Version:    0.7.0.1
 */