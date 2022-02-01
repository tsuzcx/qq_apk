package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$p
  implements View.OnClickListener
{
  h$p(h paramh, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201758);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("Finder.FeedConvert", "onClickShare:" + this.oTF.lN());
    h.b(this.rVd, this.oTF);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.p
 * JD-Core Version:    0.7.0.1
 */