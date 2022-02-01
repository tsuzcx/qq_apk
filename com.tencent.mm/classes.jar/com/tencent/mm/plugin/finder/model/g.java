package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "nearbyLiveSquareTabType", "getNearbyLiveSquareTabType", "()I", "setNearbyLiveSquareTabType", "(I)V", "getTabType", "setTabType", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class g
  extends g.b
  implements i
{
  public int dLS;
  public int type;
  public a<x> uGD;
  public int uNP;
  public CharSequence uNQ;
  
  private g(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(166369);
    this.uNQ = paramCharSequence;
    this.type = 0;
    this.dLS = 0;
    AppMethodBeat.o(166369);
  }
  
  public final void P(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(248709);
    p.h(paramCharSequence, "<set-?>");
    this.uNQ = paramCharSequence;
    AppMethodBeat.o(248709);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166367);
    p.h(parami, "obj");
    AppMethodBeat.o(166367);
    return 0;
  }
  
  public final int cxn()
  {
    return -1;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(258539);
    long l = hashCode();
    AppMethodBeat.o(258539);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.g
 * JD-Core Version:    0.7.0.1
 */