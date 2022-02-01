package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class o$w
  implements View.OnClickListener
{
  public static final w tCh;
  
  static
  {
    AppMethodBeat.i(242912);
    tCh = new w();
    AppMethodBeat.o(242912);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(242911);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$5$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$onCreateViewHolder$5$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o.w
 * JD-Core Version:    0.7.0.1
 */