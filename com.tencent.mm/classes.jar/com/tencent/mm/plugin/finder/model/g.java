package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "nearbyLiveSquareTabType", "getNearbyLiveSquareTabType", "()I", "setNearbyLiveSquareTabType", "(I)V", "getTabType", "setTabType", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends i.b
  implements k
{
  public CharSequence ECk;
  public int ECl;
  public a<ah> callback;
  public int hJx;
  public int type;
  
  private g(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(166369);
    this.ECk = paramCharSequence;
    this.type = 0;
    this.hJx = 0;
    AppMethodBeat.o(166369);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(166367);
    s.u(paramk, "obj");
    AppMethodBeat.o(166367);
    return 0;
  }
  
  public final void af(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(332202);
    s.u(paramCharSequence, "<set-?>");
    this.ECk = paramCharSequence;
    AppMethodBeat.o(332202);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(370184);
    long l = hashCode();
    AppMethodBeat.o(370184);
    return l;
  }
  
  public final int bZB()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.g
 * JD-Core Version:    0.7.0.1
 */