package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class e$1
  implements View.OnClickListener
{
  public static final 1 uGc;
  
  static
  {
    AppMethodBeat.i(248058);
    uGc = new 1();
    AppMethodBeat.o(248058);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(248057);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveCameraOptFilterWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(248057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.e.1
 * JD-Core Version:    0.7.0.1
 */