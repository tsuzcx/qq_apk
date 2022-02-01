package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aza;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOnlineMemberSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "offlineMemberCount", "", "getOfflineMemberCount", "()I", "setOfflineMemberCount", "(I)V", "offlineMemberList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/ArrayList;", "getOfflineMemberList", "()Ljava/util/ArrayList;", "setOfflineMemberList", "(Ljava/util/ArrayList;)V", "onlineMemberCount", "getOnlineMemberCount", "setOnlineMemberCount", "onlineMemberList", "getOnlineMemberList", "setOnlineMemberList", "onlineSelfContact", "getOnlineSelfContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setOnlineSelfContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "init", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "onCleared", "updateOnlineMemberCommentState", "Companion", "plugin-finder-base_release"})
public final class i
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a ziE;
  public aza ziA;
  public ArrayList<aza> ziB;
  public int ziC;
  public int ziD;
  public ArrayList<aza> ziz;
  
  static
  {
    AppMethodBeat.i(258427);
    ziE = new a((byte)0);
    AppMethodBeat.o(258427);
  }
  
  public i(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(258426);
    this.ziz = new ArrayList();
    this.ziB = new ArrayList();
    AppMethodBeat.o(258426);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(258423);
    this.ziz.clear();
    this.ziA = null;
    this.ziB.clear();
    this.ziC = 0;
    this.ziD = 0;
    AppMethodBeat.o(258423);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOnlineMemberSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.i
 * JD-Core Version:    0.7.0.1
 */