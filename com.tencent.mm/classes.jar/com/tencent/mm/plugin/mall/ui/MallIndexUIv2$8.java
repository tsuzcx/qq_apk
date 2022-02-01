package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.wallet_core.ui.g;

final class MallIndexUIv2$8
  implements View.OnClickListener
{
  MallIndexUIv2$8(MallIndexUIv2 paramMallIndexUIv2, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(275255);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    new Intent();
    g.cY(this.ERS, this.ERG.EOB);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(275255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.8
 * JD-Core Version:    0.7.0.1
 */