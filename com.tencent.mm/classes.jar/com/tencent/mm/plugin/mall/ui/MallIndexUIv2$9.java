package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.wallet_core.ui.g;

final class MallIndexUIv2$9
  implements View.OnClickListener
{
  MallIndexUIv2$9(MallIndexUIv2 paramMallIndexUIv2, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195795);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    g.bA(this.ERS.getContext(), this.ERG.EOB);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(195795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.9
 * JD-Core Version:    0.7.0.1
 */