package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.biw;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLayerShowInfoSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "abnormalClosedPageTitle", "", "getAbnormalClosedPageTitle", "()Ljava/lang/String;", "setAbnormalClosedPageTitle", "(Ljava/lang/String;)V", "abnormalClosedPageWording", "getAbnormalClosedPageWording", "setAbnormalClosedPageWording", "anchorVerificationShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;", "getAnchorVerificationShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;", "setAnchorVerificationShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;)V", "cacheErrCode", "", "getCacheErrCode", "()Ljava/lang/Integer;", "setCacheErrCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cacheErrorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "getCacheErrorPage", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "setCacheErrorPage", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;)V", "isLiveEndByForceQuit", "", "()Z", "setLiveEndByForceQuit", "(Z)V", "isVerifying", "setVerifying", "verifyMode", "getVerifyMode", "()I", "setVerifyMode", "(I)V", "onCleared", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c<a>
{
  public biw Efj;
  public int Efk;
  public String Efl;
  public String Efm;
  public boolean Efn;
  public bgq Efo;
  public Integer Efp;
  public boolean qag;
  
  public i(a parama)
  {
    super(parama);
    AppMethodBeat.i(356696);
    AppMethodBeat.o(356696);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356702);
    super.onCleared();
    this.Efj = null;
    this.qag = false;
    this.Efk = 0;
    this.Efl = null;
    this.Efm = null;
    this.Efn = false;
    this.Efo = null;
    this.Efp = null;
    AppMethodBeat.o(356702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.i
 * JD-Core Version:    0.7.0.1
 */