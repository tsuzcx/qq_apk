package com.tencent.mm.plugin.finder.nearby.live.base;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.f.b;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/base/FinderLiveUtils;", "", "()V", "canLoadNearbyCityFeeds", "", "invokeSource", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "commentScene", "", "getGridDividerWidth", "parseEnterTypeFromContextId", "contextId", "plugin-finder-nearby_release"})
public final class a
{
  public static final a zEO;
  
  static
  {
    AppMethodBeat.i(200092);
    zEO = new a();
    AppMethodBeat.o(200092);
  }
  
  public static boolean a(String paramString, bcz parambcz, int paramInt)
  {
    AppMethodBeat.i(200087);
    p.k(paramString, "invokeSource");
    Object localObject = q.ADH;
    if (q.edb())
    {
      AppMethodBeat.o(200087);
      return true;
    }
    if (paramInt != -1)
    {
      localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
      if (com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ov(paramInt))
      {
        AppMethodBeat.o(200087);
        return true;
      }
    }
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      Log.w(paramString, "canLoadNearbyCityFeeds isEnableFindLive");
      AppMethodBeat.o(200087);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if ((com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) && (parambcz != null) && (parambcz.SOa == 88889))
    {
      Log.w(paramString, "canLoadNearbyCityFeeds FINDER_LIVE_SQUARE_TAB_NEARBY_CITY");
      AppMethodBeat.o(200087);
      return false;
    }
    AppMethodBeat.o(200087);
    return true;
  }
  
  public static String aDA(String paramString)
  {
    AppMethodBeat.i(200091);
    p.k(paramString, "contextId");
    paramString = (String)n.a((CharSequence)paramString, new String[] { "-" }).get(0);
    AppMethodBeat.o(200091);
    return paramString;
  }
  
  public static int dLH()
  {
    AppMethodBeat.i(200090);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    int i = (int)localContext.getResources().getDimension(f.b.Edge_1_5_A);
    AppMethodBeat.o(200090);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.base.a
 * JD-Core Version:    0.7.0.1
 */