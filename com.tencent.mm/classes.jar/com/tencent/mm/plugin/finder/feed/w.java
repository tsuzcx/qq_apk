package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.ays;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bcc;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "plugin-finder_release"})
public final class w
{
  public static final w tOM;
  
  static
  {
    AppMethodBeat.i(243994);
    tOM = new w();
    AppMethodBeat.o(243994);
  }
  
  public static c a(azm paramazm)
  {
    AppMethodBeat.i(243992);
    p.h(paramazm, "lbsSection");
    Object localObject1 = new ayr();
    Object localObject2 = z.vEM;
    ((ayr)localObject1).dataType = z.dxS();
    ((ayr)localObject1).vEa = paramazm;
    localObject2 = new z((ayr)localObject1);
    int i = ((z)localObject2).vEI.dataType;
    paramazm = z.vEM;
    if (i == z.dxS())
    {
      localObject1 = ((z)localObject2).vEI.vEa;
      paramazm = (azm)localObject1;
      if (localObject1 == null) {
        paramazm = new azm();
      }
      paramazm = new o(paramazm);
      ((z)localObject2).vEF = paramazm;
      ((z)localObject2).vEG = null;
      ((z)localObject2).uNH = null;
      ((z)localObject2).qcr = (paramazm.dxE().FVr + 1000);
      long l = ((Number)paramazm.tON.getValue()).longValue();
      paramazm = ((z)localObject2).vEF;
      if (paramazm != null)
      {
        i = paramazm.hashCode();
        ((z)localObject2).vEH = (i + l);
      }
    }
    for (;;)
    {
      paramazm = new c((z)localObject2);
      AppMethodBeat.o(243992);
      return paramazm;
      i = 0;
      break;
      paramazm = z.vEM;
      if (i == z.dxT())
      {
        ((z)localObject2).vEF = null;
        paramazm = FinderItem.Companion;
        localObject1 = ((z)localObject2).vEI.tuO;
        paramazm = (azm)localObject1;
        if (localObject1 == null) {
          paramazm = new FinderObject();
        }
        paramazm = FinderItem.a.a(paramazm, 0);
        ((z)localObject2).vEG = paramazm;
        ((z)localObject2).uNH = null;
        ((z)localObject2).qcr = paramazm.getMediaType();
        ((z)localObject2).vEH = paramazm.getId();
      }
      else
      {
        paramazm = z.vEM;
        if (i == z.dxU())
        {
          ((z)localObject2).vEF = null;
          ((z)localObject2).vEG = null;
          localObject1 = ((z)localObject2).vEI.LIR;
          paramazm = (azm)localObject1;
          if (localObject1 == null) {
            paramazm = new ays();
          }
          paramazm = new aa(paramazm);
          ((z)localObject2).uNH = paramazm;
          ((z)localObject2).qcr = paramazm.vEN.LIS;
          ((z)localObject2).vEH = paramazm.getId();
        }
        else
        {
          ((z)localObject2).vEF = null;
          ((z)localObject2).vEG = null;
          ((z)localObject2).uNH = null;
          ((z)localObject2).qcr = 10000;
          ((z)localObject2).vEH = -1L;
        }
      }
    }
  }
  
  public static c m(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(243993);
    p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = new ayr();
    Object localObject2 = z.vEM;
    ((ayr)localObject1).dataType = z.dxT();
    ((ayr)localObject1).tuO = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new z((ayr)localObject1);
    ((z)localObject1).vEF = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((z)localObject1).vEG = ((FinderItem)localObject2);
    ((z)localObject1).uNH = null;
    ((z)localObject1).qcr = ((FinderItem)localObject2).getMediaType();
    ((z)localObject1).vEH = ((FinderItem)localObject2).getId();
    localObject1 = new c((z)localObject1);
    ((c)localObject1).uNI = paramBaseFinderFeed;
    AppMethodBeat.o(243993);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w
 * JD-Core Version:    0.7.0.1
 */