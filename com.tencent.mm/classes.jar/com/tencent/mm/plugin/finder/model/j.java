package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.view.recyclerview.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends i.b
  implements k
{
  public epc ECn;
  
  public j(epc paramepc)
  {
    AppMethodBeat.i(332186);
    this.ECn = paramepc;
    AppMethodBeat.o(332186);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332212);
    s.u(paramk, "obj");
    AppMethodBeat.o(332212);
    return 2147483646;
  }
  
  public final void a(epc paramepc)
  {
    AppMethodBeat.i(332193);
    s.u(paramepc, "<set-?>");
    this.ECn = paramepc;
    AppMethodBeat.o(332193);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(370185);
    long l = hashCode();
    AppMethodBeat.o(370185);
    return l;
  }
  
  public final int bZB()
  {
    return -6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.j
 * JD-Core Version:    0.7.0.1
 */