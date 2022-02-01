package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$2", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$2"})
final class h$ap
  implements View.OnClickListener
{
  h$ap(h paramh, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201781);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("Finder.FeedConvert", "onClickLikeLocal:" + this.rUu.lN());
    h.b(this.rVR, this.rUu, false);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.ap
 * JD-Core Version:    0.7.0.1
 */