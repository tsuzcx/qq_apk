package com.tencent.mm.plugin.card.ui.v3;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class VipCardListUI$m
  implements View.OnClickListener
{
  VipCardListUI$m(VipCardListUI paramVipCardListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(244423);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.d(VipCardListUI.a(this.tEf), "click header view");
    VipCardListUI.l(this.tEf);
    a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(244423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI.m
 * JD-Core Version:    0.7.0.1
 */