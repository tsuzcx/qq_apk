package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.wallet_core.ui.e;

final class MallIndexUIv2$5
  implements View.OnClickListener
{
  MallIndexUIv2$5(MallIndexUIv2 paramMallIndexUIv2, d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199051);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    new Intent();
    e.ct(this.vGs, this.vGg.vDd);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(199051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.5
 * JD-Core Version:    0.7.0.1
 */