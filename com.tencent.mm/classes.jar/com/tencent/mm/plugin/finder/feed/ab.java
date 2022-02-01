package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.biv;
import kotlin.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class ab
{
  public static final ab xzy;
  
  static
  {
    AppMethodBeat.i(290093);
    xzy = new ab();
    AppMethodBeat.o(290093);
  }
  
  public static c a(bfl parambfl)
  {
    AppMethodBeat.i(290091);
    kotlin.g.b.p.k(parambfl, "lbsSection");
    Object localObject1 = new bem();
    Object localObject2 = w.Ama;
    ((bem)localObject1).dataType = w.dYN();
    ((bem)localObject1).Alq = parambfl;
    localObject2 = new w((bem)localObject1);
    int i = ((w)localObject2).AlW.dataType;
    parambfl = w.Ama;
    if (i == w.dYN())
    {
      localObject1 = ((w)localObject2).AlW.Alq;
      parambfl = (bfl)localObject1;
      if (localObject1 == null) {
        parambfl = new bfl();
      }
      parambfl = new com.tencent.mm.plugin.finder.storage.p(parambfl);
      ((w)localObject2).AlT = parambfl;
      ((w)localObject2).AlU = null;
      ((w)localObject2).zzV = null;
      ((w)localObject2).viewType = (parambfl.dYG().MqM + 1000);
      long l = ((Number)parambfl.xzz.getValue()).longValue();
      parambfl = ((w)localObject2).AlT;
      if (parambfl != null)
      {
        i = parambfl.hashCode();
        ((w)localObject2).AlV = (i + l);
      }
    }
    for (;;)
    {
      parambfl = new c((w)localObject2);
      AppMethodBeat.o(290091);
      return parambfl;
      i = 0;
      break;
      parambfl = w.Ama;
      if (i == w.dYO())
      {
        ((w)localObject2).AlT = null;
        parambfl = FinderItem.Companion;
        localObject1 = ((w)localObject2).AlW.xcx;
        parambfl = (bfl)localObject1;
        if (localObject1 == null) {
          parambfl = new FinderObject();
        }
        parambfl = FinderItem.a.b(parambfl, 0);
        ((w)localObject2).AlU = parambfl;
        ((w)localObject2).zzV = null;
        ((w)localObject2).viewType = parambfl.getMediaType();
        ((w)localObject2).AlV = parambfl.getId();
      }
      else
      {
        parambfl = w.Ama;
        if (i == w.dYP())
        {
          ((w)localObject2).AlT = null;
          ((w)localObject2).AlU = null;
          localObject1 = ((w)localObject2).AlW.SPD;
          parambfl = (bfl)localObject1;
          if (localObject1 == null) {
            parambfl = new ben();
          }
          parambfl = new x(parambfl);
          ((w)localObject2).zzV = parambfl;
          ((w)localObject2).viewType = parambfl.Amb.SPE;
          ((w)localObject2).AlV = parambfl.getId();
        }
        else
        {
          ((w)localObject2).AlT = null;
          ((w)localObject2).AlU = null;
          ((w)localObject2).zzV = null;
          ((w)localObject2).viewType = 10000;
          ((w)localObject2).AlV = -1L;
        }
      }
    }
  }
  
  public static c n(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(290092);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    Object localObject1 = new bem();
    Object localObject2 = w.Ama;
    ((bem)localObject1).dataType = w.dYO();
    ((bem)localObject1).xcx = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new w((bem)localObject1);
    ((w)localObject1).AlT = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((w)localObject1).AlU = ((FinderItem)localObject2);
    ((w)localObject1).zzV = null;
    ((w)localObject1).viewType = ((FinderItem)localObject2).getMediaType();
    ((w)localObject1).AlV = ((FinderItem)localObject2).getId();
    localObject1 = new c((w)localObject1);
    ((c)localObject1).zzW = paramBaseFinderFeed;
    AppMethodBeat.o(290092);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab
 * JD-Core Version:    0.7.0.1
 */