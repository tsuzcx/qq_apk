package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class i
  extends d.b
  implements com.tencent.mm.plugin.finder.feed.model.internal.i
{
  public ctu ssS;
  
  public i(ctu paramctu)
  {
    AppMethodBeat.i(203429);
    this.ssS = paramctu;
    AppMethodBeat.o(203429);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.i parami)
  {
    AppMethodBeat.i(203427);
    p.h(parami, "obj");
    AppMethodBeat.o(203427);
    return 2147483646;
  }
  
  public final void a(ctu paramctu)
  {
    AppMethodBeat.i(203428);
    p.h(paramctu, "<set-?>");
    this.ssS = paramctu;
    AppMethodBeat.o(203428);
  }
  
  public final int bZz()
  {
    return -6;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(224299);
    long l = hashCode();
    AppMethodBeat.o(224299);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.i
 * JD-Core Version:    0.7.0.1
 */