package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.baf;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveLayerShowInfoSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "abnormalClosedPageTitle", "", "getAbnormalClosedPageTitle", "()Ljava/lang/String;", "setAbnormalClosedPageTitle", "(Ljava/lang/String;)V", "abnormalClosedPageWording", "getAbnormalClosedPageWording", "setAbnormalClosedPageWording", "anchorVerificationShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;", "getAnchorVerificationShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;", "setAnchorVerificationShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerAnchorVerificationShowInfo;)V", "cacheErrCode", "", "getCacheErrCode", "()Ljava/lang/Integer;", "setCacheErrCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "cacheErrorPage", "Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "getCacheErrorPage", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;", "setCacheErrorPage", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveErrorPage;)V", "isLiveEndByForceQuit", "", "()Z", "setLiveEndByForceQuit", "(Z)V", "isVerifying", "setVerifying", "verifyMode", "getVerifyMode", "()I", "setVerifyMode", "(I)V", "onCleared", "", "plugin-finder-base_release"})
public final class e
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public boolean ncq;
  public baf zha;
  public int zhb;
  public String zhc;
  public String zhd;
  public boolean zhe;
  public aze zhf;
  public Integer zhg;
  
  public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(258050);
    AppMethodBeat.o(258050);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(258049);
    super.onCleared();
    this.zha = null;
    this.ncq = false;
    this.zhb = 0;
    this.zhc = null;
    this.zhd = null;
    this.zhe = false;
    this.zhf = null;
    this.zhg = null;
    AppMethodBeat.o(258049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.e
 * JD-Core Version:    0.7.0.1
 */