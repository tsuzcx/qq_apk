package com.tencent.mm.plugin.eggspring.ui;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.eggspring.e;
import com.tencent.mm.t.a.n;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class SpringLuckyEggActivity$m
  implements View.OnClickListener
{
  SpringLuckyEggActivity$m(SpringLuckyEggActivity paramSpringLuckyEggActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249568);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = e.uxF;
    paramView = (n)SpringLuckyEggActivity.b(this.uyj).uyM.getValue();
    if (paramView != null) {}
    for (long l = paramView.jEe;; l = 0L)
    {
      e.R(22, l);
      SpringLuckyEggActivity.a(this.uyj, SpringLuckyEggActivity.b(this.uyj).uyL.getValue());
      a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(249568);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.m
 * JD-Core Version:    0.7.0.1
 */