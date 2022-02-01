package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$at
  implements View.OnClickListener
{
  h$at(h paramh, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(165377);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    h.a(this.rVf, true);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(165377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.at
 * JD-Core Version:    0.7.0.1
 */