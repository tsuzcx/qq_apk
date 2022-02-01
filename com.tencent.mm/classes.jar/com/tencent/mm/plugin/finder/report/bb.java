package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/Reporter21875;", "", "()V", "report21875", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "", "expose", "", "feedId", "", "taskid", "udfJson", "Lorg/json/JSONObject;", "isClick", "udfKv", "eid", "eventCode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
{
  public static final bb FuK;
  
  static
  {
    AppMethodBeat.i(331108);
    FuK = new bb();
    AppMethodBeat.o(331108);
  }
  
  public static void a(bui parambui, String paramString, int paramInt, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(331096);
    s.u(paramString, "eid");
    String str1;
    label25:
    label54:
    String str2;
    label62:
    int i;
    label69:
    String str3;
    label77:
    int j;
    if (paramJSONObject == null)
    {
      paramJSONObject = "";
      if (parambui != null) {
        break label300;
      }
      str1 = null;
      if (str1 != null) {
        break label312;
      }
      str1 = ((d)com.tencent.mm.kernel.h.ax(d.class)).dHN();
      if (str1 != null) {
        break label309;
      }
      str1 = "";
      if (parambui != null) {
        break label315;
      }
      str2 = "";
      if (parambui != null) {
        break label336;
      }
      i = 0;
      if (parambui != null) {
        break label345;
      }
      str3 = "";
      if (parambui != null) {
        break label366;
      }
      j = 0;
      label84:
      if (parambui != null) {
        break label375;
      }
      parambui = "";
    }
    for (;;)
    {
      Log.i("report21875", "report 21875 sessionId:" + str1 + ", contextId:" + str2 + ", commentScene:" + i + ", eventCode:" + paramInt + ", eid:" + paramString + ", udf_kv:" + paramJSONObject + ", clickTabContextId:" + str3 + " jumpId=" + parambui);
      com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { str1, str2, Integer.valueOf(i), Integer.valueOf(paramInt), String.valueOf(System.currentTimeMillis()), paramString, paramJSONObject, str3, Integer.valueOf(j), parambui });
      AppMethodBeat.o(331096);
      return;
      paramJSONObject = paramJSONObject.toString();
      if (paramJSONObject == null)
      {
        paramJSONObject = "";
        break;
      }
      paramJSONObject = n.m(paramJSONObject, ",", ";", false);
      if (paramJSONObject == null)
      {
        paramJSONObject = "";
        break;
      }
      break;
      label300:
      str1 = parambui.sessionId;
      break label25;
      label309:
      break label54;
      label312:
      break label54;
      label315:
      str2 = parambui.zIO;
      if (str2 == null)
      {
        str2 = "";
        break label62;
      }
      break label62;
      label336:
      i = parambui.AJo;
      break label69;
      label345:
      str3 = parambui.zIB;
      if (str3 == null)
      {
        str3 = "";
        break label77;
      }
      break label77;
      label366:
      j = parambui.hLK;
      break label84;
      label375:
      String str4 = parambui.DUN;
      parambui = str4;
      if (str4 == null) {
        parambui = "";
      }
    }
  }
  
  public static void a(bui parambui, String paramString1, boolean paramBoolean, long paramLong, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(331077);
    s.u(paramString1, "action");
    s.u(paramString2, "taskid");
    Object localObject;
    String str1;
    String str2;
    int j;
    if (parambui != null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("feedid", b.hF(paramLong));
      ((JSONObject)localObject).put("taskid", paramString2);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "JSONObject().apply {\n   …\n            }.toString()");
      localObject = n.bV((String)localObject, ",", ";");
      Log.i("report21875", "report 21875 taskid:" + paramString2 + " sessionId:" + parambui.sessionId + ", contextId:" + parambui.zIO + ", commentScene:" + parambui.AJo + ", expose:" + paramBoolean + ", eid:" + paramString1 + ", udf_kv:" + (String)localObject + ", clickTabContextId:" + parambui.zIB);
      paramString2 = com.tencent.mm.plugin.report.service.h.OAn;
      str1 = parambui.sessionId;
      str2 = parambui.zIO;
      j = parambui.AJo;
      if (!paramBoolean) {
        break label297;
      }
    }
    for (;;)
    {
      paramString2.b(21875, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(i), String.valueOf(System.currentTimeMillis()), paramString1, localObject, parambui.zIB, Integer.valueOf(parambui.hLK), parambui.DUN });
      AppMethodBeat.o(331077);
      return;
      label297:
      i = 1;
    }
  }
  
  public static void a(bui parambui, String paramString, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
  {
    int i = 0;
    AppMethodBeat.i(331065);
    s.u(paramString, "action");
    com.tencent.mm.plugin.report.service.h localh;
    String str1;
    String str2;
    int j;
    if (parambui != null)
    {
      if (paramJSONObject == null) {
        break label266;
      }
      paramJSONObject.put("feedid", b.hF(paramLong));
      paramJSONObject = paramJSONObject.toString();
      s.s(paramJSONObject, "jsonObj.apply {\n        …\n            }.toString()");
      paramJSONObject = n.bV(paramJSONObject, ",", ";");
      Log.i("report21875", "report 21875 sessionId:" + parambui.sessionId + ", contextId:" + parambui.zIO + ", commentScene:" + parambui.AJo + ", expose:" + paramBoolean + ", eid:" + paramString + ", udf_kv:" + paramJSONObject + ", clickTabContextId:" + parambui.zIB);
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      str1 = parambui.sessionId;
      str2 = parambui.zIO;
      j = parambui.AJo;
      if (!paramBoolean) {
        break label278;
      }
    }
    for (;;)
    {
      localh.b(21875, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(i), String.valueOf(System.currentTimeMillis()), paramString, paramJSONObject, parambui.zIB, Integer.valueOf(parambui.hLK), parambui.DUN });
      AppMethodBeat.o(331065);
      return;
      label266:
      paramJSONObject = new JSONObject();
      break;
      label278:
      i = 1;
    }
  }
  
  public static void a(bui parambui, String paramString, boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i = 1;
    AppMethodBeat.i(331087);
    s.u(paramString, "action");
    s.u(paramJSONObject, "udfKv");
    com.tencent.mm.plugin.report.service.h localh;
    String str1;
    String str2;
    int j;
    if (parambui != null)
    {
      paramJSONObject = paramJSONObject.toString();
      s.s(paramJSONObject, "udfKv.toString()");
      paramJSONObject = n.m(paramJSONObject, ",", ";", false);
      Log.i("report21875", "report 21875 sessionId:" + parambui.sessionId + ", contextId:" + parambui.zIO + ", commentScene:" + parambui.AJo + ", isClick:" + paramBoolean + ", eid:" + paramString + ", udf_kv:" + paramJSONObject + ", clickTabContextId:" + parambui.zIB);
      localh = com.tencent.mm.plugin.report.service.h.OAn;
      str1 = parambui.sessionId;
      str2 = parambui.zIO;
      j = parambui.AJo;
      if (!paramBoolean) {
        break label249;
      }
    }
    for (;;)
    {
      localh.b(21875, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(i), String.valueOf(System.currentTimeMillis()), paramString, paramJSONObject, parambui.zIB, Integer.valueOf(parambui.hLK), parambui.DUN });
      AppMethodBeat.o(331087);
      return;
      label249:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.bb
 * JD-Core Version:    0.7.0.1
 */