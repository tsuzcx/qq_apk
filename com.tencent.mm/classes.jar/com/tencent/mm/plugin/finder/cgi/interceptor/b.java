package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "handle", "", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class b
  implements e
{
  public static final a rKZ;
  
  static
  {
    AppMethodBeat.i(201224);
    rKZ = new a((byte)0);
    AppMethodBeat.o(201224);
  }
  
  public final boolean a(m.f paramf)
  {
    AppMethodBeat.i(201221);
    p.h(paramf, "resp");
    AppMethodBeat.o(201221);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201222);
    p.h(paramb, "loadedInfo");
    int k = paramb.duh;
    int i = paramb.pullType;
    boolean bool1 = paramb.rKw;
    boolean bool2 = paramb.saV;
    long l = paramb.rIt;
    int m = paramb.rIs;
    int j = paramb.rIu;
    ad.i("Finder.HandleHistoryTipsInterceptor", "[handle] tabType=" + k + " pullType=" + i + " isGetHistory=" + bool1 + " isFetchHistory=" + bool2 + " afterFeedIdHistory=" + l + " streamSize=" + m + " historySize=" + j);
    Object localObject1;
    if ((!bool1) && (bool2) && (j > 0) && ((k == 3) || (k == 1)) && ((i == 2) || (((i == 1) || (i == 0)) && (m > 0))))
    {
      Object localObject2 = ((Iterable)paramb.saR).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label429;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((al)localObject1).bYk() != 2011) {
        break label424;
      }
      i = 1;
      label227:
      if (i == 0) {
        break label427;
      }
      label231:
      if (localObject1 != null) {
        break label452;
      }
      localObject1 = new arp();
      ((arp)localObject1).Gpr = 2;
      ((arp)localObject1).Gpl = System.currentTimeMillis();
      localObject2 = aj.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      ((arp)localObject1).dxD = ((Context)localObject2).getResources().getString(2131766854);
      localObject1 = new v((arp)localObject1);
      localObject2 = (List)paramb.saR;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label317:
      if (!((Iterator)localObject2).hasNext()) {
        break label447;
      }
      if (((al)((Iterator)localObject2).next()).lP() != l) {
        break label435;
      }
      j = 1;
      label350:
      if (j == 0) {
        break label440;
      }
      label354:
      paramb.saR.add(i + 1, localObject1);
      ad.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", index=" + i + ", streamSize=" + m + " afterFeedIdHistory=" + l);
    }
    for (;;)
    {
      AppMethodBeat.o(201222);
      return false;
      label424:
      i = 0;
      break label227;
      label427:
      break;
      label429:
      localObject1 = null;
      break label231;
      label435:
      j = 0;
      break label350;
      label440:
      i += 1;
      break label317;
      label447:
      i = -1;
      break label354;
      label452:
      ad.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", has insert history divider from server");
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201223);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201223);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.b
 * JD-Core Version:    0.7.0.1
 */