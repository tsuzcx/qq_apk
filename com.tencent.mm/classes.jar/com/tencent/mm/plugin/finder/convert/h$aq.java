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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$3", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$3"})
final class h$aq
  implements View.OnLongClickListener
{
  h$aq(h paramh, e parame) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(201782);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    paramView = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJZ().value()).intValue() == 1)
    {
      ae.i("Finder.FeedConvert", "onLongClickLikeLocal:" + this.rUu.lN());
      localObject = (WeImageView)this.rUu.GD(2131308184);
      if (localObject == null) {
        break label156;
      }
    }
    label156:
    for (paramView = ((WeImageView)localObject).getTag();; paramView = null)
    {
      if (((paramView instanceof Integer)) && (p.i(((WeImageView)localObject).getTag(), Integer.valueOf(0)))) {
        h.b(this.rVR, this.rUu, true);
      }
      a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(201782);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.aq
 * JD-Core Version:    0.7.0.1
 */