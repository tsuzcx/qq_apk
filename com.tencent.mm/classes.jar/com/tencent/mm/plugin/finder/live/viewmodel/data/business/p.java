package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bzc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveProductRecordSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "value", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "recodingProduct", "getRecodingProduct", "()Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "setRecodingProduct", "(Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;)V", "onCleared", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends c<a>
{
  public bzc EhV;
  private final String TAG;
  
  public p(a parama)
  {
    super(parama);
    AppMethodBeat.i(356597);
    this.TAG = "LiveProductRecordSlice";
    AppMethodBeat.o(356597);
  }
  
  public final void c(bzc parambzc)
  {
    AppMethodBeat.i(356604);
    s.X("set recodingProduct: ", this.EhV);
    h.jXD();
    this.EhV = parambzc;
    AppMethodBeat.o(356604);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356610);
    c(null);
    super.onCleared();
    AppMethodBeat.o(356610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.p
 * JD-Core Version:    0.7.0.1
 */