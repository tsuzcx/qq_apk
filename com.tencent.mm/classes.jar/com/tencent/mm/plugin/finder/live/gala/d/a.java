package com.tencent.mm.plugin.finder.live.gala.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/util/FinderLiveBoxReportUtils;", "", "()V", "TAG", "", "boxId", "boxBtnReport", "", "isSwitch", "", "boxClickReport", "elementId", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementClickId;", "boxExposeReport", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ElementExposeId;", "getCommonMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "initBoxInfo", "resetBoxInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a adlZ;
  private static String adma;
  
  static
  {
    AppMethodBeat.i(371164);
    adlZ = new a();
    AppMethodBeat.o(371164);
  }
  
  public static void a(q.s params)
  {
    AppMethodBeat.i(371143);
    s.u(params, "elementId");
    Log.i("FinderLiveBoxReportUtils", s.X("boxClickReport elementId: ", params.id));
    com.tencent.mm.kernel.c.a locala = h.ax(ce.class);
    s.s(locala, "service(IHellLiveReport::class.java)");
    ce.a.a((ce)locala, params);
    AppMethodBeat.o(371143);
  }
  
  public static void a(q.t paramt)
  {
    AppMethodBeat.i(371149);
    s.u(paramt, "elementId");
    Log.i("FinderLiveBoxReportUtils", s.X("boxExposeReport elementId: ", paramt.id));
    com.tencent.mm.kernel.c.a locala = h.ax(ce.class);
    s.s(locala, "service(IHellLiveReport::class.java)");
    ce.a.a((ce)locala, paramt);
    AppMethodBeat.o(371149);
  }
  
  public static void aLK(String paramString)
  {
    AppMethodBeat.i(371132);
    s.u(paramString, "boxId");
    adma = paramString;
    AppMethodBeat.o(371132);
  }
  
  public static void jdl()
  {
    adma = "";
  }
  
  public static void rw(boolean paramBoolean)
  {
    AppMethodBeat.i(371157);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    String str2 = adma;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localMap.put("group_box_number", str1);
    Log.i("FinderLiveBoxReportUtils", "boxBtnReport reportMap: " + localHashMap + " isSwitch: " + paramBoolean);
    if (paramBoolean)
    {
      ((ce)h.ax(ce.class)).a(q.s.akfl, (Map)localHashMap);
      AppMethodBeat.o(371157);
      return;
    }
    ((ce)h.ax(ce.class)).a(q.t.akfp, (Map)localHashMap);
    AppMethodBeat.o(371157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.d.a
 * JD-Core Version:    0.7.0.1
 */