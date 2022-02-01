package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderExtStatsReport;", "", "()V", "TAG", "", "sendExtStatsReport", "", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedActionValue", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k Fpu;
  
  static
  {
    AppMethodBeat.i(331405);
    Fpu = new k();
    AppMethodBeat.o(331405);
  }
  
  public static void a(bui parambui, cc paramcc)
  {
    AppMethodBeat.i(331399);
    kotlin.g.b.s.u(parambui, "contextObj");
    kotlin.g.b.s.u(paramcc, "feed");
    if (!(paramcc instanceof BaseFinderFeed))
    {
      AppMethodBeat.o(331399);
      return;
    }
    paramcc = (BaseFinderFeed)paramcc;
    aps localaps = new aps();
    localaps.hKN = paramcc.bZA();
    localaps.finderUsername = paramcc.feedObject.getUserName();
    Object localObject = z.FrZ;
    localaps.sessionBuffer = z.p(paramcc.bZA(), parambui.AJo);
    localObject = m.Fpx;
    localaps.ZwW = m.a.aj(ak.l(v.Y("feedActionType", Integer.valueOf(18))));
    localObject = paramcc.feedObject;
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      localaps.videoDuration = i;
      localaps.mediaType = paramcc.feedObject.getMediaType();
      Log.i("FinderExtStatsReport", kotlin.g.b.s.X("sendExtStatsReport ", d.hF(localaps.hKN)));
      h.aZW().a((com.tencent.mm.am.p)new bu(parambui, 18054, localaps), 0);
      AppMethodBeat.o(331399);
      return;
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        localObject = (dji)kotlin.a.p.oL((List)localObject);
        if (localObject == null) {
          i = 0;
        } else {
          i = ((dji)localObject).videoDuration;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.k
 * JD-Core Version:    0.7.0.1
 */