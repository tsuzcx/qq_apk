package com.tencent.mm.plugin.finder.nearby.trace;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingHelper;", "", "tabType", "", "(I)V", "onCgiBackMs", "", "onFetchDoneMs", "onRefreshEndMs", "onViewUpdateMs", "onVisibleMs", "startCgiMs", "startFetchMs", "onCgiBack", "", "onFetchDone", "onRefreshEnd", "onViewUpdate", "onVisible", "printConsumingSteps", "reset", "startCgi", "startFetch", "Companion", "finder-sdk_release"})
public final class b
{
  private static final HashMap<Integer, b> zJA;
  public static final a zJB;
  public int fEH;
  public long zJt;
  public long zJu;
  public long zJv;
  public long zJw;
  public long zJx;
  public long zJy;
  public long zJz;
  
  static
  {
    AppMethodBeat.i(208924);
    zJB = new a((byte)0);
    zJA = new HashMap();
    AppMethodBeat.o(208924);
  }
  
  public b(int paramInt)
  {
    this.fEH = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingHelper$Companion;", "", "()V", "TAG", "", "timeConsumingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingHelper;", "Lkotlin/collections/HashMap;", "get", "tabType", "finder-sdk_release"})
  public static final class a
  {
    public static b OL(int paramInt)
    {
      AppMethodBeat.i(208581);
      b localb = (b)b.dMC().get(Integer.valueOf(paramInt));
      if (localb == null) {
        localb = new b(paramInt);
      }
      for (;;)
      {
        p.j(localb, "timeConsumingMap[tabType…eConsumingHelper(tabType)");
        ((Map)b.dMC()).put(Integer.valueOf(paramInt), localb);
        AppMethodBeat.o(208581);
        return localb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.trace.b
 * JD-Core Version:    0.7.0.1
 */