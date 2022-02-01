package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic;", "", "()V", "Companion", "FinderAdContactCache", "plugin-finder-base_release"})
public final class a
{
  private static long swE;
  private static int wZJ;
  private static b wZK;
  public static final a wZL;
  
  static
  {
    AppMethodBeat.i(258158);
    wZL = new a((byte)0);
    wZK = new b();
    AppMethodBeat.o(258158);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$Companion;", "", "()V", "TAG", "", "adCacheItems", "Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$FinderAdContactCache;", "lastRequestTime", "", "nextRetryInterval", "", "checkAdContactCacheAvailable", "", "username", "getAdContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "isInterceptRequest", "recordLastRequest", "", "setNextRetryInterval", "interval", "updateAdContact", "contact", "plugin-finder-base_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$FinderAdContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "Companion", "plugin-finder-base_release"})
  public static final class b
  {
    public static final a wZN;
    private final boolean dal;
    public final Map<String, i> wZM;
    
    static
    {
      AppMethodBeat.i(258047);
      wZN = new a((byte)0);
      AppMethodBeat.o(258047);
    }
    
    public b()
    {
      AppMethodBeat.i(258046);
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
      for (boolean bool = true;; bool = false)
      {
        this.dal = bool;
        this.wZM = Collections.synchronizedMap((Map)new HashMap());
        AppMethodBeat.o(258046);
        return;
      }
    }
    
    public final i aAI(String paramString)
    {
      AppMethodBeat.i(258045);
      p.k(paramString, "key");
      paramString = (i)this.wZM.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.dnw();
        AppMethodBeat.o(258045);
        return paramString;
      }
      AppMethodBeat.o(258045);
      return null;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$FinderAdContactCache$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.a
 * JD-Core Version:    0.7.0.1
 */