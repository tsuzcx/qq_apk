package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.storage.r.a;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.dzq;
import d.f;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class z
{
  public static final z KNQ;
  
  static
  {
    AppMethodBeat.i(197856);
    KNQ = new z();
    AppMethodBeat.o(197856);
  }
  
  public static v a(dzm paramdzm)
  {
    AppMethodBeat.i(197854);
    k.h(paramdzm, "lbsSection");
    Object localObject = new dzj();
    r.a locala = r.KXi;
    ((dzj)localObject).dataType = r.fUW();
    ((dzj)localObject).KWK = paramdzm;
    paramdzm = new r((dzj)localObject);
    int i = paramdzm.KXe.dataType;
    localObject = r.KXi;
    if (i == r.fUW())
    {
      localObject = paramdzm.KXe.KWK;
      k.g(localObject, "viewItemPb.section");
      localObject = new p((dzm)localObject);
      paramdzm.KXb = ((p)localObject);
      paramdzm.KXc = null;
      paramdzm.KXd = null;
      paramdzm.nBH = (((p)localObject).fUQ().Lyf + 1000);
      long l = ((Number)((p)localObject).KWJ.getValue()).longValue();
      localObject = paramdzm.KXb;
      if (localObject != null)
      {
        i = localObject.hashCode();
        paramdzm.trO = (i + l);
      }
    }
    for (;;)
    {
      paramdzm = new v(paramdzm);
      AppMethodBeat.o(197854);
      return paramdzm;
      i = 0;
      break;
      localObject = r.KXi;
      if (i == r.fUX())
      {
        paramdzm.KXb = null;
        localObject = FinderItem.qJU;
        localObject = paramdzm.KXe.Dky;
        k.g(localObject, "viewItemPb.finderObject");
        localObject = FinderItem.a.a((FinderObject)localObject, 0);
        paramdzm.KXc = ((FinderItem)localObject);
        paramdzm.KXd = null;
        paramdzm.nBH = ((FinderItem)localObject).getMediaType();
        paramdzm.trO = ((FinderItem)localObject).getId();
      }
      else
      {
        localObject = r.KXi;
        if (i == r.fUY())
        {
          paramdzm.KXb = null;
          paramdzm.KXc = null;
          localObject = paramdzm.KXe.LxQ;
          k.g(localObject, "viewItemPb.localItem");
          localObject = new s((dzk)localObject);
          paramdzm.KXd = ((s)localObject);
          paramdzm.nBH = (((s)localObject).KXj.LxR + 2000);
          paramdzm.trO = ((Number)((s)localObject).KWJ.getValue()).longValue();
        }
        else
        {
          paramdzm.KXb = null;
          paramdzm.KXc = null;
          paramdzm.KXd = null;
          paramdzm.nBH = 10000;
          paramdzm.trO = -1L;
        }
      }
    }
  }
  
  public static v m(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(197855);
    k.h(paramBaseFinderFeed, "feed");
    Object localObject1 = new dzj();
    Object localObject2 = r.KXi;
    ((dzj)localObject1).dataType = r.fUX();
    ((dzj)localObject1).Dky = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new r((dzj)localObject1);
    ((r)localObject1).KXb = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((r)localObject1).KXc = ((FinderItem)localObject2);
    ((r)localObject1).KXd = null;
    ((r)localObject1).nBH = ((FinderItem)localObject2).getMediaType();
    ((r)localObject1).trO = ((FinderItem)localObject2).getId();
    localObject1 = new v((r)localObject1);
    ((v)localObject1).KTl = paramBaseFinderFeed;
    AppMethodBeat.o(197855);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z
 * JD-Core Version:    0.7.0.1
 */