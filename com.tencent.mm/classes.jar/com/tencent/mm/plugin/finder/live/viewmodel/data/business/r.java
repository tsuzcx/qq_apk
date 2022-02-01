package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveWhiteSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "value", "", "isBussinessVisitor", "()Z", "setBussinessVisitor", "(Z)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "liveChargePost", "getLiveChargePost", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;", "setLiveChargePost", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveChargePost;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;", "partWhiteList", "getPartWhiteList", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;", "setPartWhiteList", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveWhiteList;)V", "visibilityChooseByteArray", "", "", "getVisibilityChooseByteArray", "()Ljava/util/List;", "setVisibilityChooseByteArray", "(Ljava/util/List;)V", "visibilityMode", "", "getVisibilityMode", "()I", "setVisibilityMode", "(I)V", "visibilityRoomChooseList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getVisibilityRoomChooseList", "()Ljava/util/ArrayList;", "setVisibilityRoomChooseList", "(Ljava/util/ArrayList;)V", "visibilityUserChooseList", "getVisibilityUserChooseList", "setVisibilityUserChooseList", "visitorWhiteList", "", "getVisitorWhiteList", "setVisitorWhiteList", "onCleared", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public bfy CJb;
  public List<byte[]> Eiq;
  public List<byte[]> Eir;
  public int Eis;
  public ArrayList<String> Eit;
  public ArrayList<String> Eiu;
  public boolean Eiv;
  public boe Eiw;
  
  public r(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356620);
    this.Eit = new ArrayList();
    this.Eiu = new ArrayList();
    AppMethodBeat.o(356620);
  }
  
  public final void b(bfy parambfy)
  {
    AppMethodBeat.i(356652);
    StringBuilder localStringBuilder = new StringBuilder("liveChargePost:");
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.finder.live.view.convert.a.a(parambfy)).append(",ori value:");
    locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    Log.i("MMFinder.LiveWhiteSlice", com.tencent.mm.plugin.finder.live.view.convert.a.a(this.CJb));
    this.CJb = parambfy;
    AppMethodBeat.o(356652);
  }
  
  public final void b(boe paramboe)
  {
    AppMethodBeat.i(356666);
    StringBuilder localStringBuilder = new StringBuilder("partWhiteList:");
    com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    localStringBuilder = localStringBuilder.append(com.tencent.mm.plugin.finder.live.view.convert.a.a(paramboe)).append(",ori value:");
    locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
    Log.i("MMFinder.LiveWhiteSlice", com.tencent.mm.plugin.finder.live.view.convert.a.a(this.Eiw));
    this.Eiw = paramboe;
    AppMethodBeat.o(356666);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356679);
    this.Eiq = null;
    this.Eis = 0;
    this.Eir = null;
    sq(false);
    this.Eit.clear();
    b(null);
    b(null);
    AppMethodBeat.o(356679);
  }
  
  public final void sq(boolean paramBoolean)
  {
    AppMethodBeat.i(356633);
    Log.i("MMFinder.LiveWhiteSlice", "set isBussinessVisitor:" + paramBoolean + ",ori value:" + this.Eiv);
    this.Eiv = paramBoolean;
    AppMethodBeat.o(356633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.r
 * JD-Core Version:    0.7.0.1
 */