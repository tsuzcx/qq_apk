package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ha;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderReport23462;", "", "()V", "TAG", "", "bizId", "flowId", "report", "", "eventId", "finderUin", "udf_kv", "Lorg/json/JSONObject;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final y FrY;
  private static String flowId;
  private static final String hOH;
  
  static
  {
    AppMethodBeat.i(331521);
    FrY = new y();
    hOH = "4";
    flowId = "1";
    AppMethodBeat.o(331521);
  }
  
  public static void c(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(331513);
    s.u(paramString1, "eventId");
    s.u(paramString2, "finderUin");
    ha localha = new ha();
    if (s.p(paramString1, "1")) {
      flowId = s.X("1-", Long.valueOf(cn.bDw()));
    }
    localha.iLQ = localha.F("biz_id", hOH, true);
    localha.iLR = localha.F("flow_id", flowId, true);
    localha.iLS = localha.F("event_id", paramString1, true);
    localha.iGL = localha.F("event_time", String.valueOf(cn.bDw()), true);
    localha.iLT = localha.F("finderuin", paramString2, true);
    if (paramJSONObject != null)
    {
      paramString1 = paramJSONObject.toString();
      s.s(paramString1, "udf_kv.toString()");
      localha.iAN = localha.F("udf_kv", n.m(paramString1, ",", ";", false), true);
    }
    localha.bMH();
    paramString1 = z.FrZ;
    z.a((a)localha);
    AppMethodBeat.o(331513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.y
 * JD-Core Version:    0.7.0.1
 */