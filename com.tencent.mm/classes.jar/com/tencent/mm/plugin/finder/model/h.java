package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tags", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "(Lcom/tencent/mm/protocal/protobuf/RelatedTopic;)V", "getTags", "()Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "setTags", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class h
  extends d.b
  implements com.tencent.mm.plugin.finder.feed.model.internal.h
{
  public cnx ruC;
  
  public h(cnx paramcnx)
  {
    AppMethodBeat.i(202555);
    this.ruC = paramcnx;
    AppMethodBeat.o(202555);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.h paramh)
  {
    AppMethodBeat.i(202553);
    k.h(paramh, "obj");
    AppMethodBeat.o(202553);
    return 2147483646;
  }
  
  public final void a(cnx paramcnx)
  {
    AppMethodBeat.i(202554);
    k.h(paramcnx, "<set-?>");
    this.ruC = paramcnx;
    AppMethodBeat.o(202554);
  }
  
  public final int bTF()
  {
    return -6;
  }
  
  public final long lx()
  {
    AppMethodBeat.i(210189);
    long l = hashCode();
    AppMethodBeat.o(210189);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.h
 * JD-Core Version:    0.7.0.1
 */