package com.tencent.mm.plugin.finder.nearby.live.square.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.b.a.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/report/EnterFinderLiveFromRedDotReport;", "", "()V", "TAG", "", "report", "", "contextId", "errorReason", "", "feedId", "liveId", "plugin-finder-nearby_release"})
public final class a
{
  public static final a zGH;
  
  static
  {
    AppMethodBeat.i(201690);
    zGH = new a();
    AppMethodBeat.o(201690);
  }
  
  public static void j(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(201687);
    p.k(paramString1, "contextId");
    p.k(paramString2, "feedId");
    p.k(paramString3, "liveId");
    Object localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)localObject).getRedDotManager().aBf("FinderLiveEntrance");
    localObject = new bb();
    ((bb)localObject).agR();
    ((bb)localObject).jF(paramString1);
    ((bb)localObject).dC(paramInt);
    ((bb)localObject).jB(paramString2);
    ((bb)localObject).jC(paramString3);
    if (locall != null) {}
    for (paramString1 = locall.field_tipsId;; paramString1 = null)
    {
      ((bb)localObject).jD(paramString1);
      if (locall != null)
      {
        paramString1 = g.bN(locall.drG());
        paramString1.put("object_id", d.Fw(locall.drG().object_id));
        paramString1 = paramString1.toString();
        p.j(paramString1, "extInfo.toString()");
        ((bb)localObject).jG(n.l(paramString1, ",", ";", false));
      }
      paramString2 = ((c)h.ae(c.class)).dbr();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((bb)localObject).jE(paramString1);
      Log.i("EnterFinderLiveFromRedDotReport", "report " + ((bb)localObject).agI());
      ((bb)localObject).bpa();
      AppMethodBeat.o(201687);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.report.a
 * JD-Core Version:    0.7.0.1
 */