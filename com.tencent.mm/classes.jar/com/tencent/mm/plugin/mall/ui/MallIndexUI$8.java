package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.wallet_core.ui.i;

final class MallIndexUI$8
  implements View.OnClickListener
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66103);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    i.bC(this.KMe.getContext(), this.KMf.KJa);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */