package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayc;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLuckyMoneySendMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class y
  extends g
{
  public y(axe paramaxe)
  {
    super(paramaxe);
    AppMethodBeat.i(276560);
    AppMethodBeat.o(276560);
  }
  
  public final Object dyn()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(276559);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(276559);
      return null;
    }
    ayc localayc = new ayc();
    b localb = dyj().SJE;
    if (localb != null) {
      arrayOfByte = localb.toByteArray();
    }
    localayc.parseFrom(arrayOfByte);
    AppMethodBeat.o(276559);
    return localayc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.y
 * JD-Core Version:    0.7.0.1
 */