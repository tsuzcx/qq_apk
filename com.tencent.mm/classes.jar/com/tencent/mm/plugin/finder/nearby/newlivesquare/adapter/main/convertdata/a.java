package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.bna;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/AdConvertData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "adInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAdExtInfo;", "url", "", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "position", "", "count", "(Lcom/tencent/mm/protocal/protobuf/FinderAdExtInfo;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;II)V", "getAdInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderAdExtInfo;", "getContainer", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "getCount", "()I", "getPosition", "getUrl", "()Ljava/lang/String;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements cc
{
  public final ath ENr;
  private final bna ENs;
  public final int count;
  public final int position;
  public final String url;
  
  public a(ath paramath, String paramString, bna parambna, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(370496);
    this.ENr = paramath;
    this.url = paramString;
    this.ENs = parambna;
    this.position = paramInt1;
    this.count = paramInt2;
    AppMethodBeat.o(370496);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(340423);
    s.u(paramk, "obj");
    AppMethodBeat.o(340423);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(340408);
    long l = hashCode();
    AppMethodBeat.o(340408);
    return l;
  }
  
  public final int bZB()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.a
 * JD-Core Version:    0.7.0.1
 */