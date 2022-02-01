package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyExtStatsReport;", "", "()V", "TAG", "", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedActionValue", "", "plugin-finder_release"})
public final class a
{
  public static final a uSY;
  
  static
  {
    AppMethodBeat.i(249332);
    uSY = new a();
    AppMethodBeat.o(249332);
  }
  
  public static void a(bbn parambbn, bo parambo)
  {
    AppMethodBeat.i(249331);
    p.h(parambbn, "contextObj");
    p.h(parambo, "feed");
    if (!(parambo instanceof BaseFinderFeed))
    {
      AppMethodBeat.o(249331);
      return;
    }
    parambo = (BaseFinderFeed)parambo;
    alc localalc = new alc();
    localalc.hFK = parambo.lT();
    localalc.finderUsername = parambo.feedObject.getUserName();
    Object localObject = k.vfA;
    localalc.sessionBuffer = k.G(parambo.lT(), parambbn.tCE);
    localObject = e.vdS;
    localalc.Lub = e.a.ah(ae.b(s.U("feedActionType", Integer.valueOf(18))));
    localObject = parambo.feedObject;
    if (localObject != null)
    {
      localObject = ((FinderItem)localObject).getMediaList();
      if (localObject != null)
      {
        localObject = (cjl)j.kt((List)localObject);
        if (localObject == null) {}
      }
    }
    for (int i = ((cjl)localObject).videoDuration;; i = 0)
    {
      localalc.videoDuration = i;
      localalc.mediaType = parambo.feedObject.getMediaType();
      Log.i("NearbyExtStatsReport", "sendExtStatsReport " + d.zs(localalc.hFK));
      g.azz().b((q)new aw(parambbn, localalc));
      AppMethodBeat.o(249331);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.a
 * JD-Core Version:    0.7.0.1
 */