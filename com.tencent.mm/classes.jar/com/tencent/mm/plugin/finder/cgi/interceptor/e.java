package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.ac;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.bj;
import com.tencent.mm.plugin.finder.model.bl;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"createFinderLiveList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "tabType", "", "print", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "streamCardTitle", "plugin-finder_release"})
public final class e
{
  public static final bu a(bjr parambjr)
  {
    AppMethodBeat.i(279089);
    p.k(parambjr, "$this$toRVFeed");
    switch (parambjr.STx)
    {
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      parambjr = (bu)new ac(parambjr);
      AppMethodBeat.o(279089);
      return parambjr;
    case 1: 
    case 2: 
      parambjr = (bu)new ak(parambjr);
      AppMethodBeat.o(279089);
      return parambjr;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      parambjr = (bu)new bl(parambjr);
      AppMethodBeat.o(279089);
      return parambjr;
    }
    parambjr = (bu)new bj(parambjr);
    AppMethodBeat.o(279089);
    return parambjr;
  }
  
  private static final x a(bjp parambjp, int paramInt)
  {
    AppMethodBeat.i(279087);
    parambjp = new x(parambjp);
    Iterator localIterator = ((Iterable)parambjp.dKy()).iterator();
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      Object localObject = n.zWF;
      long l = localy.zAF.id;
      localObject = aj.AGc;
      n.d(l, aj.QP(paramInt), localy.zAF.sessionBuffer);
    }
    Log.i("Finder.HandleLayoutInfoInterceptor", "[updateLiveList] tabType:" + paramInt + ", live list:" + parambjp);
    if (parambjp.dKy().size() > 0)
    {
      AppMethodBeat.o(279087);
      return parambjp;
    }
    AppMethodBeat.o(279087);
    return null;
  }
  
  public static final String a(bjp parambjp)
  {
    AppMethodBeat.i(279090);
    p.k(parambjp, "$this$print");
    parambjp = d.Fw(parambjp.id) + '_' + parambjp.zAO + '_' + parambjp.xBI + '_' + parambjp.object.size() + '_' + parambjp.STH + '_' + parambjp.PAf + '_' + parambjp.STM;
    AppMethodBeat.o(279090);
    return parambjp;
  }
  
  public static final bu b(bjp parambjp, int paramInt)
  {
    AppMethodBeat.i(279088);
    p.k(parambjp, "$this$toRVFeed");
    Object localObject1 = c.AnK;
    localObject1 = parambjp.object;
    p.j(localObject1, "`object`");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (FinderObject)localObject3;
      aj localaj = aj.AGc;
      p.j(localObject4, "it");
      if (aj.w((FinderObject)localObject4)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = aj.AGc;
    localObject2 = (Iterable)c.a.r((List)localObject1, aj.QY(paramInt));
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderItem)((Iterator)localObject2).next();
      localObject4 = c.AnK;
      ((Collection)localObject1).add(c.a.a((FinderItem)localObject3));
    }
    localObject1 = new LinkedList((Collection)localObject1);
    if (parambjp.xBI == 1)
    {
      parambjp = (bu)a(parambjp, paramInt);
      AppMethodBeat.o(279088);
      return parambjp;
    }
    localObject2 = n.zWF;
    long l = parambjp.id;
    localObject2 = aj.AGc;
    n.d(l, aj.QP(paramInt), parambjp.sessionBuffer);
    parambjp = (bu)new an(parambjp, parambjp.xBI, (LinkedList)localObject1);
    AppMethodBeat.o(279088);
    return parambjp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.e
 * JD-Core Version:    0.7.0.1
 */