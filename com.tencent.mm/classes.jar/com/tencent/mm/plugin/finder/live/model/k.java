package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveComboRewardMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "selfMsgInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "getSelfMsgInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "setSelfMsgInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;)V", "selfSend", "", "getSelfSend", "()Z", "setSelfSend", "(Z)V", "getPayLoadContent", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends h
{
  public beb CFr;
  public boolean CFs;
  private final String TAG;
  
  public k(bdm parambdm)
  {
    super(parambdm);
    AppMethodBeat.i(359347);
    this.TAG = "FinderLiveComboRewardMsg";
    AppMethodBeat.o(359347);
  }
  
  public final Object ekF()
  {
    Object localObject1 = null;
    AppMethodBeat.i(359354);
    if (this.CER.msg_type == 20013)
    {
      if (this.CFs)
      {
        localObject2 = this.TAG;
        localbeb = this.CFr;
        localObject1 = localbeb;
        if (localbeb == null) {
          localObject1 = "";
        }
        Log.i((String)localObject2, s.X("FinderLiveComboRewardMsg is selfSend getPayLoadContent:", f.dg(localObject1)));
        localObject1 = this.CFr;
        AppMethodBeat.o(359354);
        return localObject1;
      }
      beb localbeb = new beb();
      Object localObject2 = this.CER.ZNY;
      if (localObject2 == null) {}
      for (;;)
      {
        localbeb.parseFrom((byte[])localObject1);
        AppMethodBeat.o(359354);
        return localbeb;
        localObject1 = ((b)localObject2).toByteArray();
      }
    }
    AppMethodBeat.o(359354);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.k
 * JD-Core Version:    0.7.0.1
 */