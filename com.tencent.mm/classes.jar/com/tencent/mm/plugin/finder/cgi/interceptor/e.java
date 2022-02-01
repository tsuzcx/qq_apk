package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"createFinderLiveList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "tabType", "", "print", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "streamCardTitle", "plugin-finder_release"})
public final class e
{
  public static final bo a(bcu parambcu, int paramInt)
  {
    AppMethodBeat.i(242632);
    p.h(parambcu, "$this$toRVFeed");
    Object localObject1 = c.vGN;
    localObject1 = parambcu.object;
    p.g(localObject1, "`object`");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (FinderObject)localObject3;
      y localy = y.vXH;
      p.g(localObject4, "it");
      if (y.r((FinderObject)localObject4)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = y.vXH;
    localObject2 = (Iterable)c.a.s((List)localObject1, y.LL(paramInt));
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderItem)((Iterator)localObject2).next();
      localObject4 = c.vGN;
      ((Collection)localObject1).add(c.a.s((FinderItem)localObject3));
    }
    localObject1 = new LinkedList((Collection)localObject1);
    if (parambcu.tQR == 1)
    {
      parambcu = new x(parambcu);
      Log.i("Finder.HandleLayoutInfoInterceptor", "[updateLiveList] tabType:" + paramInt + ", live list:" + parambcu);
      parambcu = (bo)parambcu;
      AppMethodBeat.o(242632);
      return parambcu;
    }
    localObject2 = k.vfA;
    long l = parambcu.id;
    localObject2 = y.vXH;
    k.e(l, y.LB(paramInt), parambcu.sessionBuffer);
    parambcu = (bo)new ag(parambcu, parambcu.tQR, (LinkedList)localObject1);
    AppMethodBeat.o(242632);
    return parambcu;
  }
  
  public static final String a(bcu parambcu)
  {
    AppMethodBeat.i(242633);
    p.h(parambcu, "$this$print");
    parambcu = d.zs(parambcu.id) + '_' + parambcu.uOx + '_' + parambcu.tQR + '_' + parambcu.object.size() + '_' + parambcu.LLO + '_' + parambcu.IFO + '_' + parambcu.LLT;
    AppMethodBeat.o(242633);
    return parambcu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.e
 * JD-Core Version:    0.7.0.1
 */