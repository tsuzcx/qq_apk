package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/Reporter21875;", "", "()V", "report21875", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "", "expose", "", "feedId", "", "isClick", "udfKv", "Lorg/json/JSONObject;", "eid", "eventCode", "", "plugin-finder_release"})
public final class am
{
  public static final am zZN;
  
  static
  {
    AppMethodBeat.i(275920);
    zZN = new am();
    AppMethodBeat.o(275920);
  }
  
  public static void a(bid parambid, String paramString, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(275918);
    p.k(paramString, "eid");
    if (parambid != null)
    {
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.toString();
        if (paramJSONObject != null)
        {
          String str = n.l(paramJSONObject, ",", ";", false);
          paramJSONObject = str;
          if (str != null) {
            break label50;
          }
        }
      }
      paramJSONObject = "";
      label50:
      Log.i("report21875", "report 21875 sessionId:" + parambid.sessionId + ", contextId:" + parambid.wmL + ", commentScene:" + parambid.xkX + ", eventCode:" + paramInt + ", eid:" + paramString + ", udf_kv:" + paramJSONObject + ", clickTabContextId:" + parambid.wmz);
      h.IzE.a(21875, new Object[] { parambid.sessionId, parambid.wmL, Integer.valueOf(parambid.xkX), Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()), paramString, paramJSONObject, parambid.wmz });
      AppMethodBeat.o(275918);
      return;
    }
    AppMethodBeat.o(275918);
  }
  
  public static void a(bid parambid, String paramString, boolean paramBoolean, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(275916);
    p.k(paramString, "action");
    if (parambid != null)
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("feedid", b.Fw(paramLong));
      localObject = ((JSONObject)localObject).toString();
      p.j(localObject, "JSONObject().apply {\n   …\n            }.toString()");
      localObject = n.l((String)localObject, ",", ";", false);
      Log.i("report21875", "report 21875 sessionId:" + parambid.sessionId + ", contextId:" + parambid.wmL + ", commentScene:" + parambid.xkX + ", expose:" + paramBoolean + ", eid:" + paramString + ", udf_kv:" + (String)localObject + ", clickTabContextId:" + parambid.wmz);
      h localh = h.IzE;
      String str1 = parambid.sessionId;
      String str2 = parambid.wmL;
      int j = parambid.xkX;
      if (paramBoolean) {}
      for (;;)
      {
        localh.a(21875, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(i), String.valueOf(System.currentTimeMillis()), paramString, localObject, parambid.wmz });
        AppMethodBeat.o(275916);
        return;
        i = 1;
      }
    }
    AppMethodBeat.o(275916);
  }
  
  public static void a(bid parambid, String paramString, boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i = 1;
    AppMethodBeat.i(275917);
    p.k(paramString, "action");
    p.k(paramJSONObject, "udfKv");
    if (parambid != null)
    {
      paramJSONObject = paramJSONObject.toString();
      p.j(paramJSONObject, "udfKv.toString()");
      paramJSONObject = n.l(paramJSONObject, ",", ";", false);
      Log.i("report21875", "report 21875 sessionId:" + parambid.sessionId + ", contextId:" + parambid.wmL + ", commentScene:" + parambid.xkX + ", isClick:" + paramBoolean + ", eid:" + paramString + ", udf_kv:" + paramJSONObject + ", clickTabContextId:" + parambid.wmz);
      h localh = h.IzE;
      String str1 = parambid.sessionId;
      String str2 = parambid.wmL;
      int j = parambid.xkX;
      if (paramBoolean) {}
      for (;;)
      {
        localh.a(21875, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(i), String.valueOf(System.currentTimeMillis()), paramString, paramJSONObject, parambid.wmz });
        AppMethodBeat.o(275917);
        return;
        i = 0;
      }
    }
    AppMethodBeat.o(275917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.am
 * JD-Core Version:    0.7.0.1
 */