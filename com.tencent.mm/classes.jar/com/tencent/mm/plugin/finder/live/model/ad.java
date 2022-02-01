package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayb;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRewardRankingMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class ad
  extends g
{
  public ad(axe paramaxe)
  {
    super(paramaxe);
    AppMethodBeat.i(287225);
    AppMethodBeat.o(287225);
  }
  
  public final Object dyn()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(287224);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(287224);
      return null;
    }
    ayb localayb = new ayb();
    b localb = dyj().SJE;
    if (localb != null) {
      arrayOfByte = localb.toByteArray();
    }
    localayb.parseFrom(arrayOfByte);
    AppMethodBeat.o(287224);
    return localayb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ad
 * JD-Core Version:    0.7.0.1
 */