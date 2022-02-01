package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "nearbyLiveSquareTabType", "getNearbyLiveSquareTabType", "()I", "setNearbyLiveSquareTabType", "(I)V", "getTabType", "setTabType", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class g
  extends h.b
  implements k
{
  public int fEH;
  public int type;
  public int zAd;
  public CharSequence zAe;
  public a<x> zoa;
  
  private g(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(166369);
    this.zAe = paramCharSequence;
    this.type = 0;
    this.fEH = 0;
    AppMethodBeat.o(166369);
  }
  
  public final void Y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(286696);
    p.k(paramCharSequence, "<set-?>");
    this.zAe = paramCharSequence;
    AppMethodBeat.o(286696);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(166367);
    p.k(paramk, "obj");
    AppMethodBeat.o(166367);
    return 0;
  }
  
  public final int bAQ()
  {
    return -1;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(293357);
    long l = hashCode();
    AppMethodBeat.o(293357);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.g
 * JD-Core Version:    0.7.0.1
 */