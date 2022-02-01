package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/FinderAdContactLogic$FinderAdContactCache;", "", "()V", "cacheItems", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "", "isDebug", "", "()Z", "get", "key", "remove", "", "set", "contact", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  public static final a.b.a AwW;
  public final Map<String, m> AwX;
  private final boolean eYL;
  
  static
  {
    AppMethodBeat.i(329940);
    AwW = new a.b.a((byte)0);
    AppMethodBeat.o(329940);
  }
  
  public a$b()
  {
    AppMethodBeat.i(329936);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      this.eYL = bool;
      this.AwX = Collections.synchronizedMap((Map)new HashMap());
      AppMethodBeat.o(329936);
      return;
    }
  }
  
  public final m auR(String paramString)
  {
    AppMethodBeat.i(329945);
    s.u(paramString, "key");
    paramString = (m)this.AwX.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(329945);
      return null;
    }
    paramString = paramString.dUE();
    AppMethodBeat.o(329945);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.a.b
 * JD-Core Version:    0.7.0.1
 */