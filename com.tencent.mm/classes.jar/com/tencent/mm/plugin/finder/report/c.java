package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderActionReporter;", "", "()V", "TAG", "", "report23788", "", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "changeVersion", "", "reportType", "timeStamp", "", "actionData", "Lorg/json/JSONObject;", "ReportType", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c FnB;
  
  static
  {
    AppMethodBeat.i(331374);
    FnB = new c();
    AppMethodBeat.o(331374);
  }
  
  public static void a(bui parambui, long paramLong, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(331367);
    s.u(parambui, "obj");
    s.u(paramJSONObject, "actionData");
    Log.i("Finder.ActionReporter", "[report23788] sessionId:" + parambui.sessionId + ", contextId:" + parambui.zIO + ", clickTabContextId:" + parambui.zIB + ", commentScene:" + parambui.AJo + ", changeVersion:2 reportType:1, timeStamp:" + paramLong + ", actionData:" + paramJSONObject);
    paramJSONObject = paramJSONObject.toString();
    if (paramJSONObject == null) {
      paramJSONObject = "";
    }
    for (;;)
    {
      int i = (int)(paramLong / 1000L);
      h.OAn.b(23788, new Object[] { parambui.sessionId, parambui.zIO, parambui.zIB, Integer.valueOf(parambui.AJo), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i), paramJSONObject });
      AppMethodBeat.o(331367);
      return;
      String str = n.bV(paramJSONObject, ",", ";");
      paramJSONObject = str;
      if (str == null) {
        paramJSONObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c
 * JD-Core Version:    0.7.0.1
 */