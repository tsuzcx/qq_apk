package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.aro;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "rvFeedList", "Ljava/util/LinkedList;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;Ljava/util/LinkedList;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "getRvFeedList", "()Ljava/util/LinkedList;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ab
  implements al
{
  private final f rWv;
  public final aro rXV;
  public final LinkedList<al> rXW;
  
  public ab(aro paramaro, LinkedList<al> paramLinkedList)
  {
    AppMethodBeat.i(202047);
    this.rXV = paramaro;
    this.rXW = paramLinkedList;
    this.rWv = g.O((a)new a(this));
    AppMethodBeat.o(202047);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202046);
    p.h(parami, "obj");
    if (((parami instanceof aro)) && (((aro)parami).Gpl == this.rXV.Gpl) && (p.i(((aro)parami).DCX, this.rXV.DCX)) && (((aro)parami).Gpn == this.rXV.Gpn) && (p.i(((aro)parami).Gpm, this.rXV.Gpm)))
    {
      AppMethodBeat.o(202046);
      return 0;
    }
    AppMethodBeat.o(202046);
    return -1;
  }
  
  public final int bYk()
  {
    return 2010;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(202045);
    long l = ((Number)this.rWv.getValue()).longValue();
    AppMethodBeat.o(202045);
    return l;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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