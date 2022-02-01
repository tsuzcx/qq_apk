package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveComboRewardMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "selfMsgInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "getSelfMsgInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "setSelfMsgInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;)V", "selfSend", "", "getSelfSend", "()Z", "setSelfSend", "(Z)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class j
  extends g
{
  private final String TAG;
  public axq yeP;
  public boolean yeQ;
  
  public j(axe paramaxe)
  {
    super(paramaxe);
    AppMethodBeat.i(279809);
    this.TAG = "FinderLiveComboRewardMsg";
    AppMethodBeat.o(279809);
  }
  
  public final Object dyn()
  {
    Object localObject1 = null;
    AppMethodBeat.i(279808);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(279808);
      return null;
    }
    if (this.yeQ)
    {
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("FinderLiveComboRewardMsg is selfSend getPayLoadContent:");
      localaxq = this.yeP;
      localObject1 = localaxq;
      if (localaxq == null) {
        localObject1 = "";
      }
      Log.i((String)localObject2, com.tencent.mm.ae.g.bN(localObject1));
      localObject1 = this.yeP;
      AppMethodBeat.o(279808);
      return localObject1;
    }
    axq localaxq = new axq();
    Object localObject2 = dyj().SJE;
    if (localObject2 != null) {
      localObject1 = ((b)localObject2).toByteArray();
    }
    localaxq.parseFrom((byte[])localObject1);
    AppMethodBeat.o(279808);
    return localaxq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.j
 * JD-Core Version:    0.7.0.1
 */