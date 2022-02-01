package com.tencent.mm.plugin.finder.nearby.trace;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingHelper;", "", "tabType", "", "(I)V", "onCgiBackMs", "", "onFetchDoneMs", "onRefreshEndMs", "onViewUpdateMs", "onVisibleMs", "startCgiMs", "startFetchMs", "onCgiBack", "", "onFetchDone", "onRefreshEnd", "onViewUpdate", "onVisible", "printConsumingSteps", "reset", "startCgi", "startFetch", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final HashMap<Integer, b> ERC;
  public static final a ERu;
  public long ERA;
  public long ERB;
  public long ERv;
  public long ERw;
  public long ERx;
  public long ERy;
  public long ERz;
  public int hJx;
  
  static
  {
    AppMethodBeat.i(339643);
    ERu = new a((byte)0);
    ERC = new HashMap();
    AppMethodBeat.o(339643);
  }
  
  public b(int paramInt)
  {
    this.hJx = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingHelper$Companion;", "", "()V", "TAG", "", "timeConsumingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingHelper;", "Lkotlin/collections/HashMap;", "get", "tabType", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b Rm(int paramInt)
    {
      AppMethodBeat.i(339628);
      b localb = (b)b.eGQ().get(Integer.valueOf(paramInt));
      if (localb == null) {
        localb = new b(paramInt);
      }
      for (;;)
      {
        ((Map)b.eGQ()).put(Integer.valueOf(paramInt), localb);
        AppMethodBeat.o(339628);
        return localb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.trace.b
 * JD-Core Version:    0.7.0.1
 */