package com.tencent.mm.plugin.finder.replay.model;

import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.azr;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetCallback;", "", "onLiveMsgProcess", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "onLiveMsgUpdate", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgWithOffsetResponse;", "forceReq", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void a(azp paramazp);
  
  public abstract void a(azr paramazr, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.model.d
 * JD-Core Version:    0.7.0.1
 */