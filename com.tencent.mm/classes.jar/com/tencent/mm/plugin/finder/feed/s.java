package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.storage.n.a;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anu;
import d.f;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class s
{
  public static final s rio;
  
  static
  {
    AppMethodBeat.i(201753);
    rio = new s();
    AppMethodBeat.o(201753);
  }
  
  public static b a(aml paramaml)
  {
    AppMethodBeat.i(201751);
    k.h(paramaml, "lbsSection");
    Object localObject = new amd();
    n.a locala = n.rEn;
    ((amd)localObject).dataType = n.cAF();
    ((amd)localObject).rDK = paramaml;
    paramaml = new n((amd)localObject);
    int i = paramaml.rEj.dataType;
    localObject = n.rEn;
    if (i == n.cAF())
    {
      localObject = paramaml.rEj.rDK;
      k.g(localObject, "viewItemPb.section");
      localObject = new j((aml)localObject);
      paramaml.rEf = ((j)localObject);
      paramaml.rEg = null;
      paramaml.rEh = null;
      paramaml.oeH = (((j)localObject).cAz().EGD + 1000);
      long l = ((Number)((j)localObject).rDJ.getValue()).longValue();
      localObject = paramaml.rEf;
      if (localObject != null)
      {
        i = localObject.hashCode();
        paramaml.rEi = (i + l);
      }
    }
    for (;;)
    {
      paramaml = new b(paramaml);
      AppMethodBeat.o(201751);
      return paramaml;
      i = 0;
      break;
      localObject = n.rEn;
      if (i == n.cAG())
      {
        paramaml.rEf = null;
        localObject = FinderItem.rDA;
        localObject = paramaml.rEj.EDN;
        k.g(localObject, "viewItemPb.finderObject");
        localObject = FinderItem.a.a((FinderObject)localObject, 0);
        paramaml.rEg = ((FinderItem)localObject);
        paramaml.rEh = null;
        paramaml.oeH = ((FinderItem)localObject).getMediaType();
        paramaml.rEi = ((FinderItem)localObject).getId();
      }
      else
      {
        localObject = n.rEn;
        if (i == n.cAH())
        {
          paramaml.rEf = null;
          paramaml.rEg = null;
          localObject = paramaml.rEj.EFC;
          k.g(localObject, "viewItemPb.localItem");
          localObject = new o((ame)localObject);
          paramaml.rEh = ((o)localObject);
          paramaml.oeH = (((o)localObject).rEo.EFD + 2000);
          paramaml.rEi = ((Number)((o)localObject).rDJ.getValue()).longValue();
        }
        else
        {
          paramaml.rEf = null;
          paramaml.rEg = null;
          paramaml.rEh = null;
          paramaml.oeH = 10000;
          paramaml.rEi = -1L;
        }
      }
    }
  }
  
  public static b g(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(201752);
    k.h(paramBaseFinderFeed, "feed");
    Object localObject1 = new amd();
    Object localObject2 = n.rEn;
    ((amd)localObject1).dataType = n.cAG();
    ((amd)localObject1).EDN = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new n((amd)localObject1);
    ((n)localObject1).rEf = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((n)localObject1).rEg = ((FinderItem)localObject2);
    ((n)localObject1).rEh = null;
    ((n)localObject1).oeH = ((FinderItem)localObject2).getMediaType();
    ((n)localObject1).rEi = ((FinderItem)localObject2).getId();
    localObject1 = new b((n)localObject1);
    ((b)localObject1).rux = paramBaseFinderFeed;
    AppMethodBeat.o(201752);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.s
 * JD-Core Version:    0.7.0.1
 */