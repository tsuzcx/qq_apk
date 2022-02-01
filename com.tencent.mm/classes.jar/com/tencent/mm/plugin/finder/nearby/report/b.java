package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.g;
import com.tencent.mm.plugin.finder.report.g.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyExtStatsReport;", "", "()V", "TAG", "", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedActionValue", "", "plugin-finder-nearby_release"})
public final class b
{
  public static final b zJa;
  
  static
  {
    AppMethodBeat.i(201563);
    zJa = new b();
    AppMethodBeat.o(201563);
  }
  
  public static void a(bid parambid, bu parambu)
  {
    AppMethodBeat.i(201559);
    p.k(parambid, "contextObj");
    p.k(parambu, "feed");
    if (!(parambu instanceof BaseFinderFeed))
    {
      AppMethodBeat.o(201559);
      return;
    }
    parambu = (BaseFinderFeed)parambu;
    amd localamd = new amd();
    localamd.xbk = parambu.mf();
    localamd.finderUsername = parambu.feedObject.getUserName();
    Object localObject = n.zWF;
    localamd.sessionBuffer = n.N(parambu.mf(), parambid.xkX);
    localObject = g.zUU;
    localamd.Swz = g.a.aa(ae.d(s.M("feedActionType", Integer.valueOf(18))));
    localObject = parambu.feedObject;
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject != null)
      {
        localObject = (csg)j.lp((List)localObject);
        if (localObject == null) {}
      }
    }
    for (int i = ((csg)localObject).videoDuration;; i = 0)
    {
      localamd.videoDuration = i;
      localamd.mediaType = parambu.feedObject.getMediaType();
      Log.i("NearbyExtStatsReport", "sendExtStatsReport " + d.Fw(localamd.xbk));
      h.aGY().b((q)new az(parambid, localamd));
      AppMethodBeat.o(201559);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.b
 * JD-Core Version:    0.7.0.1
 */