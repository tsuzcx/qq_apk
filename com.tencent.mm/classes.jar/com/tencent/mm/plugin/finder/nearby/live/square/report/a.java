package com.tencent.mm.plugin.finder.nearby.live.square.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.mmdata.rpt.bx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/report/EnterFinderLiveFromRedDotReport;", "", "()V", "TAG", "", "report", "", "contextId", "errorReason", "", "feedId", "liveId", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EMb;
  
  static
  {
    AppMethodBeat.i(341122);
    EMb = new a();
    AppMethodBeat.o(341122);
  }
  
  public static void g(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(341118);
    s.u(paramString1, "contextId");
    s.u(paramString2, "feedId");
    s.u(paramString3, "liveId");
    p localp = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderLiveEntrance");
    bx localbx = new bx();
    localbx.ioV = 1L;
    localbx.ln(paramString1);
    localbx.iuH = paramInt;
    localbx.lj(paramString2);
    localbx.lk(paramString3);
    if (localp == null) {}
    for (paramString1 = null;; paramString1 = localp.field_tipsId)
    {
      localbx.ll(paramString1);
      if (localp != null)
      {
        paramString1 = f.dg(localp.eav());
        paramString1.put("object_id", com.tencent.mm.ae.d.hF(localp.eav().object_id));
        paramString1 = paramString1.toString();
        s.s(paramString1, "extInfo.toString()");
        localbx.lo(n.m(paramString1, ",", ";", false));
      }
      paramString2 = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localbx.lm(paramString1);
      Log.i("EnterFinderLiveFromRedDotReport", s.X("report ", localbx.aIF()));
      localbx.bMH();
      AppMethodBeat.o(341118);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.report.a
 * JD-Core Version:    0.7.0.1
 */