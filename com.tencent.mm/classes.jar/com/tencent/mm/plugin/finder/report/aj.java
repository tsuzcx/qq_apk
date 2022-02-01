package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/Reporter21875;", "", "()V", "report21875", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "", "expose", "", "feedId", "", "plugin-finder_release"})
public final class aj
{
  public static final aj viU;
  
  static
  {
    AppMethodBeat.i(250882);
    viU = new aj();
    AppMethodBeat.o(250882);
  }
  
  public static void a(bbn parambbn, String paramString, boolean paramBoolean, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(250881);
    p.h(paramString, "action");
    if (parambbn != null)
    {
      Object localObject = new i();
      ((i)localObject).h("feedid", b.zs(paramLong));
      localObject = ((i)localObject).toString();
      p.g(localObject, "JSONObject().apply {\n   …\n            }.toString()");
      localObject = n.j((String)localObject, ",", ";", false);
      Log.i("report21875", "report 21875 sessionId:" + parambbn.sessionId + ", contextId:" + parambbn.sGQ + ", commentScene:" + parambbn.tCE + ", expose:" + paramBoolean + ", eid:" + paramString + ", udf_kv:" + (String)localObject + ", clickTabContextId:" + parambbn.sGE);
      h localh = h.CyF;
      String str1 = parambbn.sessionId;
      String str2 = parambbn.sGQ;
      int j = parambbn.tCE;
      if (paramBoolean) {}
      for (;;)
      {
        localh.a(21875, new Object[] { str1, str2, Integer.valueOf(j), Integer.valueOf(i), String.valueOf(System.currentTimeMillis()), paramString, localObject, parambbn.sGE });
        AppMethodBeat.o(250881);
        return;
        i = 1;
      }
    }
    AppMethodBeat.o(250881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.aj
 * JD-Core Version:    0.7.0.1
 */