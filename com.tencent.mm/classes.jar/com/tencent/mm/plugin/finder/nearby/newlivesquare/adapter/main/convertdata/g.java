package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/JumperConvertData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "jumper", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamJumper;", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamJumper;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;)V", "getContainer", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "getJumper", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamJumper;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements cc
{
  public final bna ENs;
  public final bnb ENu;
  
  public g(bnb parambnb, bna parambna)
  {
    AppMethodBeat.i(370497);
    this.ENu = parambnb;
    this.ENs = parambna;
    AppMethodBeat.o(370497);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(340388);
    s.u(paramk, "obj");
    AppMethodBeat.o(340388);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(340378);
    long l = hashCode();
    AppMethodBeat.o(340378);
    return l;
  }
  
  public final int bZB()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.g
 * JD-Core Version:    0.7.0.1
 */