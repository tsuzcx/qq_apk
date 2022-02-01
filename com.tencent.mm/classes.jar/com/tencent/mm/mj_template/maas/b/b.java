package com.tencent.mm.mj_template.maas.b;

import com.google.d.bk;
import com.tencent.maas.analytics.MJAnalyticsEvent;
import com.tencent.maas.analytics.MJAnalyticsEventType;
import com.tencent.maas.analytics.MJAnalyticsS12.MJAnalyticsEvent;
import com.tencent.maas.instamovie.base.MJError;
import com.tencent.maas.instamovie.base.MJError.MaasEC;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/report/MaasReport24945;", "", "()V", "EVENT_TYPE_ILINK", "", "EVENT_TYPE_MAAS_CALL", "FUNC_CALL_CANCEL", "", "FUNC_CALL_SUCCESS", "REPORT_FUNC_NAME_ILINK_AUTHCODE", "ReportFuncName_CameraSession_FirstFrame", "ReportFuncName_CameraSession_Start", "ReportFuncName_CameraSession_StartRecord", "ReportFuncName_CameraSession_StartWithTemplate", "ReportFuncName_CameraSession_StopRecord", "ReportFuncName_CameraSession_SwitchToEmpty", "ReportFuncName_CameraSession_SwitchToTemplate", "ReportFuncName_CameraSession_SwitchToTemplateWithRet", "ReportFuncName_CameraSession_TearDown", "ReportFuncName_MaasCore_startup", "ReportFuncName_MaasCore_teardown", "ReportFuncName_MovieSession_cancelExporting", "ReportFuncName_MovieSession_cancelMovieCreation", "ReportFuncName_MovieSession_recreateUsingBlankTemplate", "ReportFuncName_MovieSession_recreateWithMusicID", "ReportFuncName_MovieSession_recreateWithTemplate", "ReportFuncName_MovieSession_release", "ReportFuncName_MovieSession_startExporting", "ReportFuncName_MovieSession_startExportingRetry", "ReportFuncName_MovieSession_startMovieCreationAutoRecommendTemplate", "ReportFuncName_MovieSession_startMovieCreationUsingBlankTemplate", "ReportFuncName_MovieSession_startMovieCreationUsingBlankTemplateOnRecommendReady", "ReportFuncName_MovieSession_startMovieCreationUsingTemplate", "ReportFuncName_MovieSession_startPlaying", "ReportFuncName_MovieSession_stopPlaying", "ReportFuncName_MovieSession_updateMovieOptions", "TAG", "reportSerialId", "", "reportFunctionCallCancel", "", "funName", "callSpend", "reportFunctionCallError", "error", "Lcom/tencent/maas/instamovie/base/MJError;", "reportFunctionCallSuccess", "reportILinkCallError", "Lcom/tencent/mm/ktx/CgiException;", "reportILinkCallSuccess", "reportMMEvent", "eType", "result", "reportMaasEvent", "event", "Lcom/tencent/maas/analytics/MJAnalyticsEvent;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final int Ue;
  public static final b obs;
  private static long obt;
  
  static
  {
    AppMethodBeat.i(240024);
    obs = new b();
    Ue = 8;
    AppMethodBeat.o(240024);
  }
  
  public static void a(MJAnalyticsEvent paramMJAnalyticsEvent)
  {
    AppMethodBeat.i(240004);
    s.u(paramMJAnalyticsEvent, "event");
    Object localObject1 = paramMJAnalyticsEvent.getPBData();
    if (localObject1 != null) {
      try
      {
        localObject1 = MJAnalyticsS12.MJAnalyticsEvent.parseFrom((ByteBuffer)localObject1);
        if (localObject1 != null)
        {
          localjn = new jn();
          localObject3 = a.obp;
          localjn.sj(a.bxG());
          localObject3 = a.obp;
          localjn.iTD = a.bxH();
          localjn.iTR = (paramMJAnalyticsEvent.getEventType().getValue() + 1);
          localjn.sk("1001000");
          paramMJAnalyticsEvent = ((MJAnalyticsS12.MJAnalyticsEvent)localObject1).getName();
          s.s(paramMJAnalyticsEvent, "it.name");
          localjn.iTT = localjn.F("maasEventName", n.m(paramMJAnalyticsEvent, ",", ";", false), true);
          paramMJAnalyticsEvent = ((MJAnalyticsS12.MJAnalyticsEvent)localObject1).getErrorCode();
          s.s(paramMJAnalyticsEvent, "it.errorCode");
          localjn.iTU = localjn.F("maasEventCode", n.m(paramMJAnalyticsEvent, ",", ";", false), true);
          paramMJAnalyticsEvent = ((MJAnalyticsS12.MJAnalyticsEvent)localObject1).getErrorMessage();
          s.s(paramMJAnalyticsEvent, "it.errorMessage");
          localjn.iTV = localjn.F("maasEventMessage", n.m(paramMJAnalyticsEvent, ",", ";", false), true);
          paramMJAnalyticsEvent = ((MJAnalyticsS12.MJAnalyticsEvent)localObject1).getExpandsList();
          s.s(paramMJAnalyticsEvent, "it.expandsList");
          localObject3 = (Iterable)paramMJAnalyticsEvent;
          paramMJAnalyticsEvent = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            s.s(localObject4, "it");
            paramMJAnalyticsEvent.add(n.bV((String)localObject4, ",", ";"));
          }
        }
      }
      catch (bk localbk)
      {
        jn localjn;
        for (;;)
        {
          Log.printErrStackTrace("MaasReport24945", (Throwable)localbk, "pb error", new Object[0]);
          localObject2 = null;
        }
        Object localObject4 = (List)paramMJAnalyticsEvent;
        Object localObject3 = (String)p.ae((List)localObject4, 0);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iTW = localjn.F("maasExpand1", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 1);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iTX = localjn.F("maasExpand2", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 2);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iTY = localjn.F("maasExpand3", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 3);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iTZ = localjn.F("maasExpand4", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 4);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iUa = localjn.F("maasExpand5", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 5);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iUb = localjn.F("maasExpand6", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 6);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iUc = localjn.F("maasExpand7", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 7);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iUd = localjn.F("maasExpand8", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 8);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iUe = localjn.F("maasExpand9", paramMJAnalyticsEvent, true);
        localObject3 = (String)p.ae((List)localObject4, 9);
        paramMJAnalyticsEvent = (MJAnalyticsEvent)localObject3;
        if (localObject3 == null) {
          paramMJAnalyticsEvent = "";
        }
        localjn.iUf = localjn.F("maasExpand10", paramMJAnalyticsEvent, true);
        paramMJAnalyticsEvent = new JSONObject();
        localObject3 = ((MJAnalyticsS12.MJAnalyticsEvent)localObject2).getKeysList();
        s.s(localObject3, "it.keysList");
        localObject3 = (Iterable)localObject3;
        Object localObject2 = ((MJAnalyticsS12.MJAnalyticsEvent)localObject2).getValuesList();
        s.s(localObject2, "it.valuesList");
        localObject2 = ((Iterable)p.d((Iterable)localObject3, (Iterable)localObject2)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (r)((Iterator)localObject2).next();
          paramMJAnalyticsEvent.put((String)((r)localObject3).bsC, ((r)localObject3).bsD);
        }
        localObject2 = ah.aiuX;
        paramMJAnalyticsEvent = paramMJAnalyticsEvent.toString();
        s.s(paramMJAnalyticsEvent, "JSONObject().apply {\n   …             }.toString()");
        localjn.iUg = localjn.F("maasNamed", n.bV(paramMJAnalyticsEvent, ",", ";"), true);
        long l = obt;
        obt = 1L + l;
        localjn.iUk = l;
        localjn.bMH();
      }
    }
    AppMethodBeat.o(240004);
  }
  
  public static void a(String paramString, MJError paramMJError, long paramLong)
  {
    AppMethodBeat.i(239978);
    s.u(paramString, "funName");
    s.u(paramMJError, "error");
    JSONObject localJSONObject = new JSONObject();
    Object localObject = paramMJError.ec;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((MJError.MaasEC)localObject).getErrorCode()))
    {
      localJSONObject.put("ec", localObject);
      localJSONObject.put("message", paramMJError.message);
      paramMJError = ah.aiuX;
      paramMJError = localJSONObject.toString();
      s.s(paramMJError, "JSONObject().apply {\n   …age)\n        }.toString()");
      b(100, paramString, n.bV(paramMJError, ",", ";"), paramLong);
      AppMethodBeat.o(239978);
      return;
    }
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(240017);
    Log.i("MaasReport24945", "reportMMEvent() called with: eType = " + paramInt + ", funName = " + paramString1 + ", result = " + paramString2 + ", callSpend = " + paramLong);
    jn localjn = new jn();
    a locala = a.obp;
    localjn.sj(a.bxG());
    locala = a.obp;
    localjn.iTD = a.bxH();
    localjn.iTR = paramInt;
    localjn.sk("1001000");
    localjn.sl(paramString1);
    localjn.sm(paramString2);
    localjn.iUj = paramLong;
    paramLong = obt;
    obt = 1L + paramLong;
    localjn.iUk = paramLong;
    localjn.bMH();
    AppMethodBeat.o(240017);
  }
  
  public static void x(String paramString, long paramLong)
  {
    AppMethodBeat.i(239967);
    s.u(paramString, "funName");
    b(100, paramString, "success", paramLong);
    AppMethodBeat.o(239967);
  }
  
  public static void y(String paramString, long paramLong)
  {
    AppMethodBeat.i(239983);
    s.u(paramString, "funName");
    b(100, paramString, "cancel", paramLong);
    AppMethodBeat.o(239983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.b.b
 * JD-Core Version:    0.7.0.1
 */