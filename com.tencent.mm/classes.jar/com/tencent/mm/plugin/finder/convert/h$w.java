package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class h$w
  implements View.OnLongClickListener
{
  h$w(h paramh, e parame) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(201766);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJZ().value()).intValue() == 1)
    {
      ae.i("Finder.FeedConvert", "onLongClick Private Like:" + this.oTF.lN());
      paramView = (WeImageView)this.oTF.GD(2131300888);
      p.g(paramView, "awesomeIv");
      if (((paramView.getTag() instanceof Integer)) && (p.i(paramView.getTag(), Integer.valueOf(0)))) {
        h.a(this.rVd, this.oTF, true);
      }
    }
    a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(201766);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.w
 * JD-Core Version:    0.7.0.1
 */