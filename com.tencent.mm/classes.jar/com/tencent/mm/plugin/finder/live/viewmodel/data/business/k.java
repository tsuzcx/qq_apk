package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveWhiteSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "value", "", "isBussinessVisitor", "()Z", "setBussinessVisitor", "(Z)V", "visibilityChooseByteArray", "", "", "getVisibilityChooseByteArray", "()Ljava/util/List;", "setVisibilityChooseByteArray", "(Ljava/util/List;)V", "visibilityMode", "", "getVisibilityMode", "()I", "setVisibilityMode", "(I)V", "visibilityRoomChooseList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getVisibilityRoomChooseList", "()Ljava/util/ArrayList;", "setVisibilityRoomChooseList", "(Ljava/util/ArrayList;)V", "visibilityUserChooseList", "getVisibilityUserChooseList", "setVisibilityUserChooseList", "visitorWhiteList", "", "getVisitorWhiteList", "setVisitorWhiteList", "onCleared", "", "plugin-finder-base_release"})
public final class k
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public List<byte[]> ziQ;
  public List<byte[]> ziR;
  public int ziS;
  public ArrayList<String> ziT;
  public ArrayList<String> ziU;
  public boolean ziV;
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(258481);
    this.ziT = new ArrayList();
    this.ziU = new ArrayList();
    AppMethodBeat.o(258481);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(258480);
    this.ziQ = null;
    this.ziS = 0;
    this.ziR = null;
    pC(false);
    this.ziT.clear();
    AppMethodBeat.o(258480);
  }
  
  public final void pC(boolean paramBoolean)
  {
    AppMethodBeat.i(258479);
    Log.i("MMFinder.LiveWhiteSlice", "set isBussinessVisitor:" + paramBoolean + ",ori value:" + this.ziV);
    this.ziV = paramBoolean;
    AppMethodBeat.o(258479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.k
 * JD-Core Version:    0.7.0.1
 */