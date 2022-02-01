package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axt;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGlobalLevelUpgradeMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "toString", "", "plugin-finder_release"})
public final class n
  extends g
{
  public n(axe paramaxe)
  {
    super(paramaxe);
    AppMethodBeat.i(228218);
    AppMethodBeat.o(228218);
  }
  
  public final Object dyn()
  {
    AppMethodBeat.i(228212);
    switch (getType())
    {
    default: 
      AppMethodBeat.o(228212);
      return null;
    }
    axt localaxt = new axt();
    Object localObject = dyj().SJE;
    if (localObject != null) {}
    for (localObject = ((b)localObject).toByteArray();; localObject = null)
    {
      localaxt.parseFrom((byte[])localObject);
      localObject = a.yRm;
      a.ha("FinderLiveGlobalLevelUpgradeMsg", "userlevelTest," + localaxt.toString());
      if (localaxt.type != 1) {
        break;
      }
      AppMethodBeat.o(228212);
      return localaxt;
    }
    AppMethodBeat.o(228212);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(228216);
    Object localObject = dyn();
    if ((localObject instanceof axt))
    {
      localObject = "nickNake:" + dyd() + '-' + dyh() + ",type:" + ((axt)localObject).type + ",level:" + ((axt)localObject).SKm + '-' + ((axt)localObject).SKn;
      AppMethodBeat.o(228216);
      return localObject;
    }
    localObject = super.toString();
    AppMethodBeat.o(228216);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.n
 * JD-Core Version:    0.7.0.1
 */