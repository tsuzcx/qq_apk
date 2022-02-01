package com.tencent.mm.plugin.finder.nearby.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyTimeConsumingHelper;", "", "tabType", "", "(I)V", "onCgiBackMs", "", "onFetchDoneMs", "onRefreshEndMs", "onViewUpdateMs", "onVisibleMs", "startCgiMs", "startFetchMs", "onCgiBack", "", "onFetchDone", "onRefreshEnd", "onViewUpdate", "onVisible", "printConsumingSteps", "reset", "startCgi", "startFetch", "Companion", "plugin-finder_release"})
public final class d
{
  private static final HashMap<Integer, d> uQt;
  public static final a uQu;
  public int dLS;
  public long uQm;
  public long uQn;
  public long uQo;
  public long uQp;
  public long uQq;
  public long uQr;
  public long uQs;
  
  static
  {
    AppMethodBeat.i(249015);
    uQu = new a((byte)0);
    uQt = new HashMap();
    AppMethodBeat.o(249015);
  }
  
  public d(int paramInt)
  {
    this.dLS = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/base/NearbyTimeConsumingHelper$Companion;", "", "()V", "TAG", "", "timeConsumingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/nearby/base/NearbyTimeConsumingHelper;", "Lkotlin/collections/HashMap;", "get", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static d JA(int paramInt)
    {
      AppMethodBeat.i(249014);
      d locald = (d)d.dln().get(Integer.valueOf(paramInt));
      if (locald == null) {
        locald = new d(paramInt);
      }
      for (;;)
      {
        p.g(locald, "timeConsumingMap[tabType…eConsumingHelper(tabType)");
        ((Map)d.dln()).put(Integer.valueOf(paramInt), locald);
        AppMethodBeat.o(249014);
        return locald;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.base.d
 * JD-Core Version:    0.7.0.1
 */