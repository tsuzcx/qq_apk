package com.tencent.mm.plugin.finder.record.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.mj_template.report.MaasPageFinderReporter;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/report/FinderTemplateRecordReporter;", "", "()V", "TAG", "", "reporter", "Lcom/tencent/mm/mj_template/report/MaasPageFinderReporter;", "sessionId", "getSessionId", "()Ljava/lang/String;", "sessionId$delegate", "Lkotlin/Lazy;", "udfContent", "initReportInfo", "", "intent", "Landroid/content/Intent;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "onDestroy", "onPause", "scene", "", "onResume", "reportRecordClick", "eid", "templateId", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Fjw;
  private static final String Fjx;
  private static final j nWN;
  public static MaasPageFinderReporter ogn;
  
  static
  {
    AppMethodBeat.i(336981);
    Fjw = new a();
    nWN = k.cm((kotlin.g.a.a)a.a.Fjy);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("shooting_template_entrance", 1);
    localObject = ((JSONObject)localObject).toString();
    s.s(localObject, "JSONObject().also {\n    …nce\", 1)\n    }.toString()");
    Fjx = n.bV((String)localObject, ",", ";");
    AppMethodBeat.o(336981);
  }
  
  public static void eLn()
  {
    AppMethodBeat.i(336960);
    MaasPageFinderReporter localMaasPageFinderReporter = ogn;
    if (localMaasPageFinderReporter != null) {
      localMaasPageFinderReporter.x(false, Fjx);
    }
    AppMethodBeat.o(336960);
  }
  
  public static void eLo()
  {
    AppMethodBeat.i(336966);
    MaasPageFinderReporter localMaasPageFinderReporter = ogn;
    if (localMaasPageFinderReporter != null) {
      localMaasPageFinderReporter.x(true, Fjx);
    }
    AppMethodBeat.o(336966);
  }
  
  public static String getSessionId()
  {
    AppMethodBeat.i(336941);
    String str = (String)nWN.getValue();
    AppMethodBeat.o(336941);
    return str;
  }
  
  public static void hZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(336953);
    s.u(paramString1, "eid");
    s.u(paramString2, "templateId");
    MaasPageFinderReporter localMaasPageFinderReporter = ogn;
    if (localMaasPageFinderReporter != null)
    {
      s.u(paramString1, "eid");
      s.u(paramString2, "templateId");
      Log.i("MaasPageFinderReporter", "reportRecordClick 21875 eid:" + paramString1 + " session: " + localMaasPageFinderReporter.sessionId + " contextId: " + localMaasPageFinderReporter.bys() + " jumpId: " + localMaasPageFinderReporter.byt() + " clickTabContext: " + localMaasPageFinderReporter.byu() + " currentCommentScene: " + localMaasPageFinderReporter.odF);
    }
    switch (paramString1.hashCode())
    {
    default: 
    case 1982517987: 
      label159:
      do
      {
        paramString2 = "";
        gk localgk = new gk();
        localgk.qU(localMaasPageFinderReporter.sessionId);
        localgk.qV(localMaasPageFinderReporter.bys());
        localgk.qW(String.valueOf(localMaasPageFinderReporter.odF));
        localgk.rb(String.valueOf(localMaasPageFinderReporter.byv()));
        localgk.iGK = 1;
        localgk.qX(String.valueOf(cn.bDw()));
        localgk.qY(paramString1);
        localgk.qZ(paramString2);
        localgk.ra(localMaasPageFinderReporter.byu());
        localgk.rc(n.bV(localMaasPageFinderReporter.byt(), ",", ";"));
        localgk.bMH();
        AppMethodBeat.o(336953);
        return;
      } while (!paramString1.equals("btn_start_shooting"));
    }
    for (;;)
    {
      paramString2 = new JSONObject().put("shooting_templateid", paramString2).toString();
      s.s(paramString2, "JSONObject().put(\"shooti…\", templateId).toString()");
      paramString2 = n.bV(paramString2, ",", ";");
      break label159;
      if (!paramString1.equals("shoot_same_video")) {
        if ((goto 156) || (!paramString1.equals("shooting_template"))) {
          break;
        }
      }
    }
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(336975);
    com.tencent.mm.mj_template.maas.b.a locala = com.tencent.mm.mj_template.maas.b.a.obp;
    com.tencent.mm.mj_template.maas.b.a.uK(0);
    ogn = null;
    AppMethodBeat.o(336975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.report.a
 * JD-Core Version:    0.7.0.1
 */