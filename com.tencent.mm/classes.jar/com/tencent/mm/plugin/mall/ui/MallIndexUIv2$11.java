package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class MallIndexUIv2$11
  implements View.OnClickListener
{
  MallIndexUIv2$11(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199059);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicorMsg.MallIndexNewUI", "click settings btn");
    d.Q(this.vGs.getContext(), "mall", ".ui.MallFunctionSettingsUI");
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(199059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.11
 * JD-Core Version:    0.7.0.1
 */