package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class MallIndexUIv2$15
  implements View.OnClickListener
{
  MallIndexUIv2$15(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(253395);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/mall/ui/MallIndexUIv2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i("MicorMsg.MallIndexUIv2", "click settings btn");
    c.ad(this.ERS.getContext(), "mall", ".ui.MallFunctionSettingsUI");
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexUIv2$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(253395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.15
 * JD-Core Version:    0.7.0.1
 */