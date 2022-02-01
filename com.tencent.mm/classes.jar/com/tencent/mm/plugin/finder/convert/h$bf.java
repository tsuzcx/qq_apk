package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$bf
  implements View.OnClickListener
{
  h$bf(h paramh, e parame, BaseFinderFeed paramBaseFinderFeed) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(221453);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    localObject = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject);
    paramView = com.tencent.mm.plugin.finder.storage.b.sxa;
    com.tencent.mm.plugin.finder.storage.b.Fh(2);
    h.a(this.rMP, this.oNd, this.rMR, true, 0L, null, ((Rect)localObject).top - com.tencent.mm.view.b.e(this.oNd.getContext(), 16.0F), 1, 24);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(221453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.bf
 * JD-Core Version:    0.7.0.1
 */