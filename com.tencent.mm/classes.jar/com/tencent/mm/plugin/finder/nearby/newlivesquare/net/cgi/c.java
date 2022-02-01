package com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.bqr;
import kotlin.Metadata;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/net/cgi/NearLiveStreamFutureTask;", "Lcom/tencent/mm/plugin/datapreloader/cgi/CgiFutureTask;", "", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "initTask", "Lkotlin/Function0;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "parenJob", "Lkotlinx/coroutines/Job;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/Job;Landroidx/lifecycle/LifecycleOwner;)V", "generateDataStore", "Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.datapreloader.b.a<String, bqr>
{
  public c(kotlin.g.a.a<? extends com.tencent.mm.plugin.findersdk.b.c<bqr>> parama, cb paramcb)
  {
    super(parama, paramcb);
    AppMethodBeat.i(370482);
    AppMethodBeat.o(370482);
  }
  
  public final com.tencent.mm.plugin.datapreloader.a.b<String, b.a<bqr>> dtg()
  {
    AppMethodBeat.i(340275);
    com.tencent.mm.plugin.datapreloader.a.b localb = (com.tencent.mm.plugin.datapreloader.a.b)new b((String)getKey());
    AppMethodBeat.o(340275);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.net.cgi.c
 * JD-Core Version:    0.7.0.1
 */