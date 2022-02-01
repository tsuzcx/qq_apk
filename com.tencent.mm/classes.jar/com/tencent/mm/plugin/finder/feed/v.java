package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.arv;
import d.f;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class v
{
  public static final v sff;
  
  static
  {
    AppMethodBeat.i(202435);
    sff = new v();
    AppMethodBeat.o(202435);
  }
  
  public static c a(aqj paramaqj)
  {
    AppMethodBeat.i(202433);
    p.h(paramaqj, "lbsSection");
    Object localObject1 = new apw();
    Object localObject2 = t.sJR;
    ((apw)localObject1).dataType = t.cLg();
    ((apw)localObject1).sJm = paramaqj;
    localObject2 = new t((apw)localObject1);
    int i = ((t)localObject2).sJN.dataType;
    paramaqj = t.sJR;
    if (i == t.cLg())
    {
      localObject1 = ((t)localObject2).sJN.sJm;
      paramaqj = (aqj)localObject1;
      if (localObject1 == null) {
        paramaqj = new aqj();
      }
      paramaqj = new m(paramaqj);
      ((t)localObject2).sJK = paramaqj;
      ((t)localObject2).sJL = null;
      ((t)localObject2).ssM = null;
      ((t)localObject2).oOD = (paramaqj.cKZ().GIr + 1000);
      long l = ((Number)paramaqj.sfg.getValue()).longValue();
      paramaqj = ((t)localObject2).sJK;
      if (paramaqj != null)
      {
        i = paramaqj.hashCode();
        ((t)localObject2).sJM = (i + l);
      }
    }
    for (;;)
    {
      paramaqj = new c((t)localObject2);
      AppMethodBeat.o(202433);
      return paramaqj;
      i = 0;
      break;
      paramaqj = t.sJR;
      if (i == t.cLh())
      {
        ((t)localObject2).sJK = null;
        paramaqj = FinderItem.sJb;
        localObject1 = ((t)localObject2).sJN.GEz;
        paramaqj = (aqj)localObject1;
        if (localObject1 == null) {
          paramaqj = new FinderObject();
        }
        paramaqj = FinderItem.a.a(paramaqj, 0);
        ((t)localObject2).sJL = paramaqj;
        ((t)localObject2).ssM = null;
        ((t)localObject2).oOD = paramaqj.getMediaType();
        ((t)localObject2).sJM = paramaqj.getId();
      }
      else
      {
        paramaqj = t.sJR;
        if (i == t.cLi())
        {
          ((t)localObject2).sJK = null;
          ((t)localObject2).sJL = null;
          localObject1 = ((t)localObject2).sJN.GGX;
          paramaqj = (aqj)localObject1;
          if (localObject1 == null) {
            paramaqj = new apx();
          }
          paramaqj = new u(paramaqj);
          ((t)localObject2).ssM = paramaqj;
          ((t)localObject2).oOD = paramaqj.sJS.GGY;
          ((t)localObject2).sJM = paramaqj.getId();
        }
        else
        {
          ((t)localObject2).sJK = null;
          ((t)localObject2).sJL = null;
          ((t)localObject2).ssM = null;
          ((t)localObject2).oOD = 10000;
          ((t)localObject2).sJM = -1L;
        }
      }
    }
  }
  
  public static c i(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(202434);
    p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = new apw();
    Object localObject2 = t.sJR;
    ((apw)localObject1).dataType = t.cLh();
    ((apw)localObject1).GEz = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new t((apw)localObject1);
    ((t)localObject1).sJK = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((t)localObject1).sJL = ((FinderItem)localObject2);
    ((t)localObject1).ssM = null;
    ((t)localObject1).oOD = ((FinderItem)localObject2).getMediaType();
    ((t)localObject1).sJM = ((FinderItem)localObject2).getId();
    localObject1 = new c((t)localObject1);
    ((c)localObject1).ssN = paramBaseFinderFeed;
    AppMethodBeat.o(202434);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v
 * JD-Core Version:    0.7.0.1
 */