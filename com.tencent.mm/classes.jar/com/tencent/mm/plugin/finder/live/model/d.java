package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveComboRewardMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "selfMsgInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "getSelfMsgInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;", "setSelfMsgInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsgComboLiveRewardInfo;)V", "selfSend", "", "getSelfSend", "()Z", "setSelfSend", "(Z)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class d
  extends c
{
  private final String TAG;
  public auy uiq;
  public boolean uir;
  
  public d(aut paramaut)
  {
    super(paramaut);
    AppMethodBeat.i(246075);
    this.TAG = "FinderLiveComboRewardMsg";
    AppMethodBeat.o(246075);
  }
  
  public final Object dft()
  {
    Object localObject1 = null;
    AppMethodBeat.i(246074);
    switch (this.uio.ybm)
    {
    default: 
      AppMethodBeat.o(246074);
      return null;
    }
    if (this.uir)
    {
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("FinderLiveComboRewardMsg is selfSend getPayLoadContent:");
      localauy = this.uiq;
      localObject1 = localauy;
      if (localauy == null) {
        localObject1 = "";
      }
      Log.i((String)localObject2, g.bN(localObject1));
      localObject1 = this.uiq;
      AppMethodBeat.o(246074);
      return localObject1;
    }
    auy localauy = new auy();
    Object localObject2 = this.uio.LFB;
    if (localObject2 != null) {
      localObject1 = ((b)localObject2).toByteArray();
    }
    localauy.parseFrom((byte[])localObject1);
    AppMethodBeat.o(246074);
    return localauy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.d
 * JD-Core Version:    0.7.0.1
 */