package com.tencent.mm.plugin.finder.activity.uic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderActivityDescUIC$c
  implements View.OnClickListener
{
  public static final c tqZ;
  
  static
  {
    AppMethodBeat.i(242055);
    tqZ = new c();
    AppMethodBeat.o(242055);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(242054);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC.c
 * JD-Core Version:    0.7.0.1
 */