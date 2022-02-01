package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"createFinderLiveList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "tabType", "", "print", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "streamCardTitle", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final cc a(bwc parambwc)
  {
    AppMethodBeat.i(336737);
    s.u(parambwc, "<this>");
    switch (parambwc.aadB)
    {
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      parambwc = (cc)new ag(parambwc);
      AppMethodBeat.o(336737);
      return parambwc;
    case 1: 
    case 2: 
      parambwc = (cc)new am(parambwc);
      AppMethodBeat.o(336737);
      return parambwc;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      parambwc = (cc)new bp(parambwc);
      AppMethodBeat.o(336737);
      return parambwc;
    }
    parambwc = (cc)new bn(parambwc);
    AppMethodBeat.o(336737);
    return parambwc;
  }
  
  private static final y a(bwa parambwa, int paramInt)
  {
    AppMethodBeat.i(336715);
    parambwa = new y(parambwa);
    Iterator localIterator = ((Iterable)parambwa.eDm()).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.model.z localz = (com.tencent.mm.plugin.finder.model.z)localIterator.next();
      Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      long l = localz.ECN.id;
      localObject = av.GiL;
      com.tencent.mm.plugin.finder.report.z.d(l, av.Uc(paramInt), localz.ECN.sessionBuffer);
    }
    Log.i("Finder.HandleLayoutInfoInterceptor", "[updateLiveList] tabType:" + paramInt + ", live list:" + parambwa);
    if (parambwa.eDm().size() > 0)
    {
      AppMethodBeat.o(336715);
      return parambwa;
    }
    AppMethodBeat.o(336715);
    return null;
  }
  
  public static final String a(bwa parambwa)
  {
    AppMethodBeat.i(336745);
    s.u(parambwa, "<this>");
    parambwa = com.tencent.mm.ae.d.hF(parambwa.id) + '_' + parambwa.ECY + '_' + parambwa.AYX + '_' + parambwa.object.size() + '_' + parambwa.aadM + '_' + parambwa.Wqu + '_' + parambwa.aadS;
    AppMethodBeat.o(336745);
    return parambwa;
  }
  
  public static final cc b(bwa parambwa, int paramInt)
  {
    AppMethodBeat.i(336728);
    s.u(parambwa, "<this>");
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject1 = parambwa.object;
    s.s(localObject1, "`object`");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (FinderObject)localObject3;
      av localav = av.GiL;
      s.s(localObject4, "it");
      if (av.y((FinderObject)localObject4)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = av.GiL;
    localObject2 = (Iterable)d.a.K((List)localObject1, av.Ui(paramInt));
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderItem)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      ((Collection)localObject1).add(d.a.a((FinderItem)localObject3));
    }
    localObject1 = new LinkedList((Collection)localObject1);
    if (parambwa.AYX == 1)
    {
      parambwa = (cc)a(parambwa, paramInt);
      AppMethodBeat.o(336728);
      return parambwa;
    }
    localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
    long l = parambwa.id;
    localObject2 = av.GiL;
    com.tencent.mm.plugin.finder.report.z.d(l, av.Uc(paramInt), parambwa.sessionBuffer);
    parambwa = (cc)new au(parambwa, parambwa.AYX, (LinkedList)localObject1);
    AppMethodBeat.o(336728);
    return parambwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.f
 * JD-Core Version:    0.7.0.1
 */