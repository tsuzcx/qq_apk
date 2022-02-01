package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.protocal.protobuf.asd;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "layoutType", "", "rvFeedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;ILjava/util/LinkedList;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getLayoutType", "()I", "getRvFeedList", "()Ljava/util/LinkedList;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ab
  implements am
{
  private final f sfg;
  public final asd sgG;
  public final int sgH;
  public final LinkedList<BaseFinderFeed> sgI;
  
  public ab(asd paramasd, int paramInt, LinkedList<BaseFinderFeed> paramLinkedList)
  {
    AppMethodBeat.i(202511);
    this.sgG = paramasd;
    this.sgH = paramInt;
    this.sgI = paramLinkedList;
    this.sfg = g.O((a)new a(this));
    AppMethodBeat.o(202511);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202510);
    p.h(parami, "obj");
    if (((parami instanceof asd)) && (((asd)parami).GIB == this.sgG.GIB) && (((asd)parami).sgH == this.sgG.sgH))
    {
      AppMethodBeat.o(202510);
      return 0;
    }
    AppMethodBeat.o(202510);
    return -1;
  }
  
  public final int bZz()
  {
    if (this.sgH == 0) {
      return 2010;
    }
    if (this.sgH == 2) {
      return 2013;
    }
    return 0;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(202509);
    long l = ((Number)this.sfg.getValue()).longValue();
    AppMethodBeat.o(202509);
    return l;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab
 * JD-Core Version:    0.7.0.1
 */