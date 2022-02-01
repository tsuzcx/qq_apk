package com.tencent.mm.plugin.finder.convert;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class h$af
  implements View.OnClickListener
{
  h$af(h paramh, e parame, BaseFinderFeed paramBaseFinderFeed, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201774);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    localObject = new Rect();
    paramView.getGlobalVisibleRect((Rect)localObject);
    paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
    com.tencent.mm.plugin.finder.storage.b.FD(2);
    h.a(this.rVd, this.oTF, this.rVf, true, 0L, null, ((Rect)localObject).top - com.tencent.mm.view.b.e(this.oTF.getContext(), 16.0F), this.jTl, 24);
    a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshCommentEdu$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.af
 * JD-Core Version:    0.7.0.1
 */