package com.tencent.mm.plugin.finder.activity.uic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderActivityHeaderUIC$c
  implements View.OnClickListener
{
  public static final c trs;
  
  static
  {
    AppMethodBeat.i(242070);
    trs = new c();
    AppMethodBeat.o(242070);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(242069);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityHeaderUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityHeaderUIC.c
 * JD-Core Version:    0.7.0.1
 */