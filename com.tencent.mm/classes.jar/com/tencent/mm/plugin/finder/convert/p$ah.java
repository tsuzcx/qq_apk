package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class p$ah
  implements View.OnClickListener
{
  public static final ah xki;
  
  static
  {
    AppMethodBeat.i(289368);
    xki = new ah();
    AppMethodBeat.o(289368);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289367);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.p.ah
 * JD-Core Version:    0.7.0.1
 */