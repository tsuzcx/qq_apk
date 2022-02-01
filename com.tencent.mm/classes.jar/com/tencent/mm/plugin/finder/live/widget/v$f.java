package com.tencent.mm.plugin.finder.live.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class v$f
  implements View.OnClickListener
{
  public static final f zoO;
  
  static
  {
    AppMethodBeat.i(283962);
    zoO = new f();
    AppMethodBeat.o(283962);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(283961);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget$showVerificationLayerInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget$showVerificationLayerInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(283961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.v.f
 * JD-Core Version:    0.7.0.1
 */