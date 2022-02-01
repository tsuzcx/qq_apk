package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aa.f;
import com.tencent.mm.plugin.finder.feed.model.b;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "handle", "", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class c
  implements f
{
  public static final a txB;
  
  static
  {
    AppMethodBeat.i(242621);
    txB = new a((byte)0);
    AppMethodBeat.o(242621);
  }
  
  public final boolean a(aa.f paramf)
  {
    AppMethodBeat.i(242618);
    p.h(paramf, "resp");
    AppMethodBeat.o(242618);
    return false;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(242619);
    p.h(paramb, "loadedInfo");
    int k = paramb.dLS;
    int i = paramb.pullType;
    boolean bool1 = paramb.twZ;
    boolean bool2 = paramb.tUD;
    long l = paramb.ttW;
    int m = paramb.ttV;
    int j = paramb.kxF;
    Log.i("Finder.HandleHistoryTipsInterceptor", "[handle] tabType=" + k + " pullType=" + i + " isGetHistory=" + bool1 + " isFetchHistory=" + bool2 + " afterFeedIdHistory=" + l + " streamSize=" + m + " historySize=" + j);
    Object localObject1;
    if ((!bool1) && (bool2) && (j > 0) && ((k == 3) || (k == 1)) && ((i == 2) || (((i == 1) || (i == 0)) && (m > 0))))
    {
      if (y.a(y.vXH, k, 0, 2)) {
        break label465;
      }
      Object localObject2 = ((Iterable)paramb.tUz).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label442;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((bo)localObject1).cxn() != 2011) {
        break label437;
      }
      i = 1;
      label240:
      if (i == 0) {
        break label440;
      }
      label244:
      if (localObject1 != null) {
        break label465;
      }
      localObject1 = new bcw();
      ((bcw)localObject1).LLE = 2;
      ((bcw)localObject1).uOx = System.currentTimeMillis();
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      ((bcw)localObject1).dQx = ((Context)localObject2).getResources().getString(2131760627);
      localObject1 = new ai((bcw)localObject1);
      localObject2 = (List)paramb.tUz;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label330:
      if (!((Iterator)localObject2).hasNext()) {
        break label460;
      }
      if (((bo)((Iterator)localObject2).next()).lT() != l) {
        break label448;
      }
      j = 1;
      label363:
      if (j == 0) {
        break label453;
      }
      label367:
      paramb.tUz.add(i + 1, localObject1);
      Log.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", index=" + i + ", streamSize=" + m + " afterFeedIdHistory=" + l);
    }
    for (;;)
    {
      AppMethodBeat.o(242619);
      return false;
      label437:
      i = 0;
      break label240;
      label440:
      break;
      label442:
      localObject1 = null;
      break label244;
      label448:
      j = 0;
      break label363;
      label453:
      i += 1;
      break label330;
      label460:
      i = -1;
      break label367;
      label465:
      Log.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", has insert history divider from server");
    }
  }
  
  public final boolean b(b paramb, int paramInt)
  {
    AppMethodBeat.i(242620);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(242620);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.c
 * JD-Core Version:    0.7.0.1
 */