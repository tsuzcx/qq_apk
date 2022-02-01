package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class j
  extends g.b
  implements i
{
  public dmk uNS;
  
  public j(dmk paramdmk)
  {
    AppMethodBeat.i(248714);
    this.uNS = paramdmk;
    AppMethodBeat.o(248714);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248712);
    p.h(parami, "obj");
    AppMethodBeat.o(248712);
    return 2147483646;
  }
  
  public final void a(dmk paramdmk)
  {
    AppMethodBeat.i(248713);
    p.h(paramdmk, "<set-?>");
    this.uNS = paramdmk;
    AppMethodBeat.o(248713);
  }
  
  public final int cxn()
  {
    return -6;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(258541);
    long l = hashCode();
    AppMethodBeat.o(258541);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.j
 * JD-Core Version:    0.7.0.1
 */