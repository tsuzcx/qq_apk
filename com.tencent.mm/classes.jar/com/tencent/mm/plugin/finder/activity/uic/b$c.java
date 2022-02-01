package com.tencent.mm.plugin.finder.activity.uic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class b$c
  implements View.OnClickListener
{
  public static final c wXN;
  
  static
  {
    AppMethodBeat.i(278660);
    wXN = new c();
    AppMethodBeat.o(278660);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(278659);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.b.c
 * JD-Core Version:    0.7.0.1
 */