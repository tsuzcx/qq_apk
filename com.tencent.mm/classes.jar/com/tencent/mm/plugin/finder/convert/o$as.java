package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshMoreBtn$1$1"})
final class o$as
  implements View.OnClickListener
{
  o$as(o paramo, BaseFinderFeed paramBaseFinderFeed, h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(258535);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshMoreBtn$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = this.tzq.Mn(2131307809);
    if (paramView != null) {
      paramView.callOnClick();
    }
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullConvert$refreshMoreBtn$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(258535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.o.as
 * JD-Core Version:    0.7.0.1
 */