package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.b.a.dp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderGameLiveReportUtil;", "", "()V", "TAG", "", "lastActionType", "", "getLastActionType", "()J", "setLastActionType", "(J)V", "initCommField", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLiveStreamStruct;", "report21017", "actionJson", "", "report21017ForMiniGame", "type", "result", "plugin-finder_release"})
public final class o
{
  public static final o ADA;
  private static long ADz = 0L;
  private static final String TAG = "Finder.FinderGameLiveReportUtil";
  
  static
  {
    AppMethodBeat.i(277847);
    ADA = new o();
    TAG = "Finder.FinderGameLiveReportUtil";
    ADz = 18L;
    AppMethodBeat.o(277847);
  }
  
  public static void Nc(long paramLong)
  {
    ADz = paramLong;
  }
  
  public static void QJ(int paramInt)
  {
    AppMethodBeat.i(277843);
    dp localdp = new dp();
    a(localdp);
    localdp.jv(ADz);
    localdp.qJ(ADz + '-' + paramInt);
    localdp.bpa();
    Log.i(TAG, "report21017, " + localdp.agI() + ' ');
    AppMethodBeat.o(277843);
  }
  
  private static void a(dp paramdp)
  {
    AppMethodBeat.i(277846);
    paramdp.qG(z.bdh());
    Object localObject = aj.AGc;
    if (aj.dOO()) {}
    for (int i = 1;; i = 0)
    {
      paramdp.lK(i);
      String str = c.deO().dbr();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramdp.qI((String)localObject);
      paramdp.ju(System.currentTimeMillis());
      AppMethodBeat.o(277846);
      return;
    }
  }
  
  public static void bd(int paramInt, String paramString)
  {
    AppMethodBeat.i(277844);
    dp localdp = new dp();
    a(localdp);
    localdp.jv(s.a.yEd.jWO);
    i locali = new i();
    locali.al("type", paramInt);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    locali.g("result", str);
    paramString = locali.toString();
    p.j(paramString, "JSONObject().apply {\n   … \"\")\n        }.toString()");
    localdp.qJ(n.l(paramString, ",", ";", false));
    localdp.bpa();
    Log.i(TAG, "report21017, " + localdp.agI() + ' ');
    AppMethodBeat.o(277844);
  }
  
  public static long ecW()
  {
    return ADz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.o
 * JD-Core Version:    0.7.0.1
 */