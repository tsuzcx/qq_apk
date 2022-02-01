package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.plugin.finder.profile.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.storage.y.a;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.bve;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderMixFeedLogic;", "", "()V", "finderFeedToMixFeed", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObjectToMixFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "lbsToMixFeed", "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "localToMixFeed", "localPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixLocalItemPb;", "pack", "mixItemPb", "Lcom/tencent/mm/protocal/protobuf/FinderMixItemPb;", "poiToMixFeed", "poiInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPoiInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
{
  public static final af AWY;
  
  static
  {
    AppMethodBeat.i(363155);
    AWY = new af();
    AppMethodBeat.o(363155);
  }
  
  public static c a(bpm parambpm)
  {
    AppMethodBeat.i(363142);
    y localy = new y(parambpm);
    int i = localy.FLK.dataType;
    parambpm = y.FLJ;
    Object localObject;
    if (i == y.eZv())
    {
      localObject = localy.FLK.FKR;
      parambpm = (bpm)localObject;
      if (localObject == null) {
        parambpm = new bqs();
      }
      parambpm = new q(parambpm);
      localy.FLL = parambpm;
      localy.FLM = null;
      localy.ECc = null;
      localy.viewType = (parambpm.eZn().STX + 1000);
      long l = parambpm.getId();
      parambpm = localy.FLL;
      if (parambpm != null)
      {
        i = parambpm.hashCode();
        localy.FLO = (i + l);
      }
    }
    for (;;)
    {
      parambpm = new c(localy);
      AppMethodBeat.o(363142);
      return parambpm;
      i = 0;
      break;
      parambpm = y.FLJ;
      if (i == y.eZw())
      {
        localy.FLL = null;
        parambpm = FinderItem.Companion;
        localObject = localy.FLK.ABJ;
        parambpm = (bpm)localObject;
        if (localObject == null) {
          parambpm = new FinderObject();
        }
        parambpm = FinderItem.a.e(parambpm, 0);
        localy.FLM = parambpm;
        localy.ECc = null;
        localy.viewType = parambpm.getMediaType();
        localy.FLO = parambpm.getId();
      }
      else
      {
        parambpm = y.FLJ;
        if (i == y.eZx())
        {
          localy.FLL = null;
          localy.FLM = null;
          localObject = localy.FLK.ZXV;
          parambpm = (bpm)localObject;
          if (localObject == null) {
            parambpm = new bpn();
          }
          parambpm = new z(parambpm);
          localy.ECc = parambpm;
          localy.viewType = parambpm.FLT.ZXW;
          localy.FLO = parambpm.getId();
        }
        else
        {
          parambpm = y.FLJ;
          if (i == y.eZy())
          {
            localy.FLL = null;
            localy.FLM = null;
            localy.ECc = null;
            localObject = localy.FLK.ZIs;
            parambpm = (bpm)localObject;
            if (localObject == null) {
              parambpm = new bsg();
            }
            localy.FLN = new g(parambpm);
            localy.viewType = 3000;
          }
          else
          {
            localy.FLL = null;
            localy.FLM = null;
            localy.ECc = null;
            localy.viewType = 10000;
            localy.FLO = -1L;
          }
        }
      }
    }
  }
  
  public static c a(bqs parambqs)
  {
    AppMethodBeat.i(363126);
    s.u(parambqs, "lbsSection");
    bpm localbpm = new bpm();
    y.a locala = y.FLJ;
    localbpm.dataType = y.eZv();
    localbpm.FKR = parambqs;
    parambqs = a(localbpm);
    AppMethodBeat.o(363126);
    return parambqs;
  }
  
  public static c i(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(363150);
    s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = new bpm();
    Object localObject2 = y.FLJ;
    ((bpm)localObject1).dataType = y.eZw();
    ((bpm)localObject1).ABJ = paramBaseFinderFeed.feedObject.getFeedObject();
    localObject1 = new y((bpm)localObject1);
    ((y)localObject1).FLL = null;
    localObject2 = paramBaseFinderFeed.feedObject;
    ((y)localObject1).FLM = ((FinderItem)localObject2);
    ((y)localObject1).ECc = null;
    ((y)localObject1).viewType = ((FinderItem)localObject2).getMediaType();
    ((y)localObject1).FLO = ((FinderItem)localObject2).getId();
    localObject1 = new c((y)localObject1);
    ((c)localObject1).ECe = paramBaseFinderFeed;
    AppMethodBeat.o(363150);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.af
 * JD-Core Version:    0.7.0.1
 */