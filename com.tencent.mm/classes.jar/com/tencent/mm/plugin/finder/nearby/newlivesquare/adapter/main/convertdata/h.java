package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnn;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/LivingTitleConvertData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "content", "", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;)V", "getContainer", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "getContent", "()Ljava/lang/String;", "tabs", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabs", "()Ljava/util/List;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements cc
{
  public final bna ENs;
  public final String content;
  public final List<bnn> tabs;
  
  public h(String paramString, bna parambna)
  {
    AppMethodBeat.i(370495);
    this.content = paramString;
    this.ENs = parambna;
    this.tabs = ((List)new ArrayList());
    AppMethodBeat.o(370495);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(340390);
    s.u(paramk, "obj");
    if (((paramk instanceof h)) && (s.p(((h)paramk).content, this.content)))
    {
      AppMethodBeat.o(340390);
      return 0;
    }
    AppMethodBeat.o(340390);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(340380);
    long l = hashCode();
    AppMethodBeat.o(340380);
    return l;
  }
  
  public final int bZB()
  {
    return -5000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.h
 * JD-Core Version:    0.7.0.1
 */