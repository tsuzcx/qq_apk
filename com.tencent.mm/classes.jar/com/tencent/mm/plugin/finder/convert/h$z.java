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
final class h$z
  implements View.OnClickListener
{
  h$z(h paramh, e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201769);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.i("Finder.FeedConvert", "onClickFav:" + this.oTF.lN());
    h.a(this.rVd, this.oTF);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.z
 * JD-Core Version:    0.7.0.1
 */