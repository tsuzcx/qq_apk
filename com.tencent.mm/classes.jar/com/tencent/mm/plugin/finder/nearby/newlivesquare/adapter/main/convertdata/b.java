package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.base.a;
import com.tencent.mm.protocal.protobuf.bna;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/AdListConvertData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/base/ConvertDataCollector;", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;)V", "getContainer", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "feedDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFeedDataList", "()Ljava/util/ArrayList;", "collectObjectId", "", "", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getContainerId", "getContainerLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getItemId", "getItemType", "setContainerLastBuffer", "", "bf", "setContinueFlag", "value", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements cc, a
{
  public final ArrayList<cc> EML;
  private final bna ENs;
  
  public b(bna parambna)
  {
    AppMethodBeat.i(340387);
    this.ENs = parambna;
    this.EML = new ArrayList();
    AppMethodBeat.o(340387);
  }
  
  public final void QQ(int paramInt)
  {
    this.ENs.BeA = paramInt;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(340398);
    s.u(paramk, "obj");
    if (((paramk instanceof b)) && (((b)paramk).ENs.Zpm == this.ENs.Zpm))
    {
      AppMethodBeat.o(340398);
      return 0;
    }
    AppMethodBeat.o(340398);
    return -1;
  }
  
  public final long bZA()
  {
    return this.ENs.Zpm;
  }
  
  public final int bZB()
  {
    return 5;
  }
  
  public final List<Long> eFR()
  {
    return (List)ab.aivy;
  }
  
  public final int eFS()
  {
    return this.ENs.Zpm;
  }
  
  public final com.tencent.mm.bx.b eFT()
  {
    return this.ENs.Zpn;
  }
  
  public final void f(com.tencent.mm.bx.b paramb)
  {
    this.ENs.Zpn = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.b
 * JD-Core Version:    0.7.0.1
 */