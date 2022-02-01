package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class j
  extends h.b
  implements k
{
  public dwb zAf;
  
  public j(dwb paramdwb)
  {
    AppMethodBeat.i(282496);
    this.zAf = paramdwb;
    AppMethodBeat.o(282496);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(282494);
    p.k(paramk, "obj");
    AppMethodBeat.o(282494);
    return 2147483646;
  }
  
  public final void a(dwb paramdwb)
  {
    AppMethodBeat.i(282495);
    p.k(paramdwb, "<set-?>");
    this.zAf = paramdwb;
    AppMethodBeat.o(282495);
  }
  
  public final int bAQ()
  {
    return -6;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(293346);
    long l = hashCode();
    AppMethodBeat.o(293346);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.j
 * JD-Core Version:    0.7.0.1
 */