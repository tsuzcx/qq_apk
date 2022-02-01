package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bgh;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOnlineMemberSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "offlineMemberCount", "", "getOfflineMemberCount", "()I", "setOfflineMemberCount", "(I)V", "offlineMemberList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/collections/ArrayList;", "getOfflineMemberList", "()Ljava/util/ArrayList;", "setOfflineMemberList", "(Ljava/util/ArrayList;)V", "onlineMemberCount", "getOnlineMemberCount", "setOnlineMemberCount", "onlineMemberList", "getOnlineMemberList", "setOnlineMemberList", "onlineSelfContact", "getOnlineSelfContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setOnlineSelfContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "init", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "onCleared", "updateOnlineMemberCommentState", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends c<a>
{
  public static final a EhP;
  public ArrayList<bgh> EhQ;
  public bgh EhR;
  public ArrayList<bgh> EhS;
  public int EhT;
  public int EhU;
  
  static
  {
    AppMethodBeat.i(356598);
    EhP = new a((byte)0);
    AppMethodBeat.o(356598);
  }
  
  public o(a parama)
  {
    super(parama);
    AppMethodBeat.i(356593);
    this.EhQ = new ArrayList();
    this.EhS = new ArrayList();
    AppMethodBeat.o(356593);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356605);
    this.EhQ.clear();
    this.EhR = null;
    this.EhS.clear();
    this.EhT = 0;
    this.EhU = 0;
    AppMethodBeat.o(356605);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOnlineMemberSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.o
 * JD-Core Version:    0.7.0.1
 */