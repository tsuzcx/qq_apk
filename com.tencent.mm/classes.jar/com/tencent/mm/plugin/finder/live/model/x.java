package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axz;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLuckyMoneyRecvMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class x
  extends g
{
  public x(axe paramaxe)
  {
    super(paramaxe);
    AppMethodBeat.i(288188);
    AppMethodBeat.o(288188);
  }
  
  public final Object dyn()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(288187);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(288187);
      return null;
    }
    axz localaxz = new axz();
    b localb = dyj().SJE;
    if (localb != null) {
      arrayOfByte = localb.toByteArray();
    }
    localaxz.parseFrom(arrayOfByte);
    AppMethodBeat.o(288187);
    return localaxz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.x
 * JD-Core Version:    0.7.0.1
 */