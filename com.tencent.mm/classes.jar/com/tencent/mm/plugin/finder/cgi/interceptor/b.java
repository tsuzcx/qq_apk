package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.m.f;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "handle", "", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class b
  implements f
{
  public static final a rTm;
  
  static
  {
    AppMethodBeat.i(201649);
    rTm = new a((byte)0);
    AppMethodBeat.o(201649);
  }
  
  public final boolean a(m.f paramf)
  {
    AppMethodBeat.i(201646);
    p.h(paramf, "resp");
    AppMethodBeat.o(201646);
    return false;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201647);
    p.h(paramb, "loadedInfo");
    int k = paramb.dvm;
    int i = paramb.pullType;
    boolean bool1 = paramb.rSI;
    boolean bool2 = paramb.sjL;
    long l = paramb.rQE;
    int m = paramb.rQD;
    int j = paramb.rQF;
    ae.i("Finder.HandleHistoryTipsInterceptor", "[handle] tabType=" + k + " pullType=" + i + " isGetHistory=" + bool1 + " isFetchHistory=" + bool2 + " afterFeedIdHistory=" + l + " streamSize=" + m + " historySize=" + j);
    Object localObject1;
    if ((!bool1) && (bool2) && (j > 0) && ((k == 3) || (k == 1)) && ((i == 2) || (((i == 1) || (i == 0)) && (m > 0))))
    {
      Object localObject2 = ((Iterable)paramb.sjH).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label429;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((am)localObject1).bZz() != 2011) {
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
      localObject1 = new ase();
      ((ase)localObject1).GIL = 2;
      ((ase)localObject1).GIB = System.currentTimeMillis();
      localObject2 = ak.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      ((ase)localObject1).dyI = ((Context)localObject2).getResources().getString(2131766854);
      localObject1 = new w((ase)localObject1);
      localObject2 = (List)paramb.sjH;
      i = 0;
      localObject2 = ((List)localObject2).iterator();
      label317:
      if (!((Iterator)localObject2).hasNext()) {
        break label447;
      }
      if (((am)((Iterator)localObject2).next()).lP() != l) {
        break label435;
      }
      j = 1;
      label350:
      if (j == 0) {
        break label440;
      }
      label354:
      paramb.sjH.add(i + 1, localObject1);
      ae.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", index=" + i + ", streamSize=" + m + " afterFeedIdHistory=" + l);
    }
    for (;;)
    {
      AppMethodBeat.o(201647);
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
      ae.i("Finder.HandleHistoryTipsInterceptor", "tabType=" + k + ", has insert history divider from server");
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.finder.feed.model.b paramb)
  {
    AppMethodBeat.i(201648);
    p.h(paramb, "loadedInfo");
    AppMethodBeat.o(201648);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleHistoryTipsInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.b
 * JD-Core Version:    0.7.0.1
 */