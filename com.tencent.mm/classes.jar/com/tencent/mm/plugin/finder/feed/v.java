package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.storage.t.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.arg;
import d.f;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class v
{
  public static final v rWu;
  
  static
  {
    AppMethodBeat.i(201971);
    rWu = new v();
    AppMethodBeat.o(201971);
  }
  
  public static c a(apw paramapw)
  {
    AppMethodBeat.i(201969);
    p.h(paramapw, "lbsSection");
    Object localObject = new apj();
    t.a locala = t.sza;
    ((apj)localObject).dataType = t.cIB();
    ((apj)localObject).syv = paramapw;
    paramapw = new t((apj)localObject);
    int i = paramapw.syW.dataType;
    localObject = t.sza;
    if (i == t.cIB())
    {
      localObject = paramapw.syW.syv;
      p.g(localObject, "viewItemPb.section");
      localObject = new m((apw)localObject);
      paramapw.syT = ((m)localObject);
      paramapw.syU = null;
      paramapw.sjP = null;
      paramapw.oIb = (((m)localObject).cIu().Gpb + 1000);
      long l = ((Number)((m)localObject).rWv.getValue()).longValue();
      localObject = paramapw.syT;
      if (localObject != null)
      {
        i = localObject.hashCode();
        paramapw.syV = (i + l);
      }
    }
    for (;;)
    {
      paramapw = new c(paramapw);
      AppMethodBeat.o(201969);
      return paramapw;
      i = 0;
      break;
      localObject = t.sza;
      if (i == t.cIC())
      {
        paramapw.syT = null;
        localObject = FinderItem.syk;
        localObject = paramapw.syW.Glx;
        p.g(localObject, "viewItemPb.finderObject");
        localObject = FinderItem.a.a((FinderObject)localObject, 0);
        paramapw.syU = ((FinderItem)localObject);
        paramapw.sjP = null;
        paramapw.oIb = ((FinderItem)localObject).getMediaType();
        paramapw.syV = ((FinderItem)localObject).getId();
      }
      else
      {
        localObject = t.sza;
        if (i == t.cID())
        {
          paramapw.syT = null;
          paramapw.syU = null;
          localObject = paramapw.syW.GnR;
          p.g(localObject, "viewItemPb.localItem");
          localObject = new u((apk)localObject);
          paramapw.sjP = ((u)localObject);
          paramapw.oIb = ((u)localObject).szb.GnS;
          paramapw.syV = ((u)localObject).getId();
        }
        else
        {
          paramapw.syT = null;
          paramapw.syU = null;
          paramapw.sjP = null;
          paramapw.oIb = 10000;
          paramapw.syV = -1L;
        }
      }
    }
  }
  
  public static c i(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(201970);
    p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = new apj();
    Object localObject2 = t.sza;
    ((apj)localObject1).dataType = t.cIC();
    ((apj)localObject1).Glx = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new t((apj)localObject1);
    ((t)localObject1).syT = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((t)localObject1).syU = ((FinderItem)localObject2);
    ((t)localObject1).sjP = null;
    ((t)localObject1).oIb = ((FinderItem)localObject2).getMediaType();
    ((t)localObject1).syV = ((FinderItem)localObject2).getId();
    localObject1 = new c((t)localObject1);
    ((c)localObject1).sjQ = paramBaseFinderFeed;
    AppMethodBeat.o(201970);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v
 * JD-Core Version:    0.7.0.1
 */