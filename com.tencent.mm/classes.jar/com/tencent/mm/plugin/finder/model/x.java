package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class x
  extends d.b
  implements i
{
  public ebq KTn;
  
  public x(ebq paramebq)
  {
    AppMethodBeat.i(198628);
    this.KTn = paramebq;
    AppMethodBeat.o(198628);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(198626);
    k.h(parami, "obj");
    AppMethodBeat.o(198626);
    return 2147483646;
  }
  
  public final void a(ebq paramebq)
  {
    AppMethodBeat.i(198627);
    k.h(paramebq, "<set-?>");
    this.KTn = paramebq;
    AppMethodBeat.o(198627);
  }
  
  public final long bMs()
  {
    AppMethodBeat.i(198625);
    long l = hashCode();
    AppMethodBeat.o(198625);
    return l;
  }
  
  public final int bMt()
  {
    return -6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.x
 * JD-Core Version:    0.7.0.1
 */