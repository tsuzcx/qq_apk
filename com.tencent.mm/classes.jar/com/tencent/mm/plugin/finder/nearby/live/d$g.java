package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveItemConvertFactory$createBigCardLiveConvert$outsideOperator$1", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/InnerAdapterLinkOutsideOperator;", "getOutsideFinderGetLiveTabsResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "getOutsideLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "loadData", "", "containerId", "", "containerLastBuffer", "gciListener", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$g
  implements com.tencent.mm.plugin.finder.nearby.newlivesquare.b
{
  public final void d(int paramInt, kotlin.g.a.b<? super b.a<bqr>, ah> paramb)
  {
    AppMethodBeat.i(370432);
    s.u(paramb, "gciListener");
    Log.i("NearbyLiveItemConvertFactory", "createBigCardLiveConvert loadData not suppport");
    AppMethodBeat.o(370432);
  }
  
  public final com.tencent.mm.bx.b eFK()
  {
    AppMethodBeat.i(370435);
    Log.i("NearbyLiveItemConvertFactory", "createBigCardLiveConvert getOutsideLastBuffer not suppport");
    AppMethodBeat.o(370435);
    return null;
  }
  
  public final bad eFL()
  {
    AppMethodBeat.i(370437);
    Log.i("NearbyLiveItemConvertFactory", "createBigCardLiveConvert getOutsideFinderGetLiveTabsResponse not suppport");
    AppMethodBeat.o(370437);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.d.g
 * JD-Core Version:    0.7.0.1
 */