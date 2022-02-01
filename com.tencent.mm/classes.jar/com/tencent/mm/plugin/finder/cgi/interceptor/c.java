package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "handle", "", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class c
  implements f
{
  public static final a xfD;
  
  static
  {
    AppMethodBeat.i(291414);
    xfD = new a((byte)0);
    AppMethodBeat.o(291414);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(291411);
    p.k(paramf, "resp");
    AppMethodBeat.o(291411);
    return false;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(291412);
    p.k(paramd, "loadedInfo");
    int k = paramd.fEH;
    int i = paramd.pullType;
    boolean bool1 = paramd.xeZ;
    boolean bool2 = paramd.xFJ;
    long l = paramd.xbC;
    int m = paramd.xbB;
    int j = paramd.nqx;
    Log.i("Finder.HandleHistoryTipsInterceptor", "[handle] tabType=" + k + " pullType=" + i + " isGetHistory=" + bool1 + " isFetchHistory=" + bool2 + " afterFeedIdHistory=" + l + " streamSize=" + m + " historySize=" + j);
    Object localObject1;
    if ((!bool1) && (bool2) && (j > 0) && ((k == 3) || (k == 1)) && ((i == 2) || (((i == 1) || (i == 0)) && (m > 0))))
    {
      if (aj.a(aj.AGc, k, 0, 2)) {
        break label466;
      }
      Object localObject2 = ((Iterable)paramd.xFF).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label443;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((bu)localObject1).bAQ() != 2011) {
        break label438;
      }
      i = 1;
      label240:
      if (i == 0) {
        break label441;
      }
      label244:
      if (localObject1 != null) {
        break label466;
      }
      localObject1 = new bjr();
      ((bjr)localObject1).STx = 2;
      ((bjr)localObject1).zAO = System.currentTimeMillis();
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      ((bjr)localObject1).wording = ((Context)localObject2).getResources().getString(b.j.finder_timeline_refresh_nomore_tip);
      localObject1 = new ak((bjr)localObject1);
      localObject2 = (List)paramd.xFF;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label331:
      if (!((Iterator)localObject2).hasNext()) {
        break label461;
      }
      if (((bu)((Iterator)localObject2).next()).mf() != l) {
        break label449;
      }
      j = 1;
      label364:
      if (j == 0) {
        break label454;
      }
      label368:
      paramd.xFF.add(i + 1, localObject1);
      Log.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", index=" + i + ", streamSize=" + m + " afterFeedIdHistory=" + l);
    }
    for (;;)
    {
      AppMethodBeat.o(291412);
      return false;
      label438:
      i = 0;
      break label240;
      label441:
      break;
      label443:
      localObject1 = null;
      break label244;
      label449:
      j = 0;
      break label364;
      label454:
      i += 1;
      break label331;
      label461:
      i = -1;
      break label368;
      label466:
      Log.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", has insert history divider from server");
    }
  }
  
  public final boolean b(d paramd, int paramInt)
  {
    AppMethodBeat.i(291413);
    p.k(paramd, "loadedInfo");
    AppMethodBeat.o(291413);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.c
 * JD-Core Version:    0.7.0.1
 */