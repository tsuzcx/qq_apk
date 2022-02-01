package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class i
  extends d.b
  implements com.tencent.mm.plugin.finder.feed.model.internal.i
{
  public cta sjV;
  
  public i(cta paramcta)
  {
    AppMethodBeat.i(202949);
    this.sjV = paramcta;
    AppMethodBeat.o(202949);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.i parami)
  {
    AppMethodBeat.i(202947);
    p.h(parami, "obj");
    AppMethodBeat.o(202947);
    return 2147483646;
  }
  
  public final void a(cta paramcta)
  {
    AppMethodBeat.i(202948);
    p.h(paramcta, "<set-?>");
    this.sjV = paramcta;
    AppMethodBeat.o(202948);
  }
  
  public final int bYk()
  {
    return -6;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(221473);
    long l = hashCode();
    AppMethodBeat.o(221473);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.i
 * JD-Core Version:    0.7.0.1
 */