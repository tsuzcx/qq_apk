package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.aue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderPoiData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderBindPoiInfo;", "type", "", "pullType", "(Lcom/tencent/mm/protocal/protobuf/FinderBindPoiInfo;II)V", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderBindPoiInfo;", "getPullType", "()I", "titleType", "getTitleType", "setTitleType", "(I)V", "getType", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
  implements cc
{
  public static final a EDv;
  public final aue EDw;
  public int EDx;
  private final int pullType;
  public final int type;
  
  static
  {
    AppMethodBeat.i(331952);
    EDv = new a((byte)0);
    AppMethodBeat.o(331952);
  }
  
  public bq(aue paramaue, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(331943);
    this.EDw = paramaue;
    this.type = paramInt1;
    this.pullType = paramInt2;
    AppMethodBeat.o(331943);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331966);
    s.u(paramk, "obj");
    if ((paramk instanceof bq)) {}
    for (paramk = (bq)paramk; (paramk != null) && (s.p(paramk.EDw.id, this.EDw.id)); paramk = null)
    {
      AppMethodBeat.o(331966);
      return 0;
    }
    AppMethodBeat.o(331966);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331957);
    long l = hashCode();
    AppMethodBeat.o(331957);
    return l;
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderPoiData$Companion;", "", "()V", "AUDIT_TYPE_APPROVE", "", "AUDIT_TYPE_AUDITING", "AUDIT_TYPE_REJECT", "ITEM_TYPE_NORMAL", "ITEM_TYPE_TITLE", "TITLE_TYPE_AUDIT", "TITLE_TYPE_BIND", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bq
 * JD-Core Version:    0.7.0.1
 */