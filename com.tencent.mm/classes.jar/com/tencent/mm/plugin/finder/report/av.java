package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dx;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/LiveEnterCostReporter;", "", "()V", "TAG", "", "data", "Lcom/tencent/mm/plugin/finder/report/LiveEnterCostReporter$Data;", "getData", "()Lcom/tencent/mm/plugin/finder/report/LiveEnterCostReporter$Data;", "setData", "(Lcom/tencent/mm/plugin/finder/report/LiveEnterCostReporter$Data;)V", "buildJson", "Lorg/json/JSONObject;", "notifyClickEnter", "", "preloadCore", "", "notifyFirstFrame", "notifyItemSelect", "notifyPreloadSuccess", "notifyResume", "notifyStartPlay", "report21680", "Data", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
{
  public static final av Fui;
  private static a Fuj;
  
  static
  {
    AppMethodBeat.i(331165);
    Fui = new av();
    AppMethodBeat.o(331165);
  }
  
  public static void eNR()
  {
    a locala = Fuj;
    if (locala != null) {
      locala.Fuo = true;
    }
  }
  
  public static void eNS()
  {
    AppMethodBeat.i(331140);
    a locala = Fuj;
    if ((locala != null) && (locala.Fuk == 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala = Fuj;
        if (locala != null) {
          locala.Fuk = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(331140);
      return;
    }
  }
  
  public static void eNT()
  {
    AppMethodBeat.i(331147);
    a locala = Fuj;
    if ((locala != null) && (locala.Fum == 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala = Fuj;
        if (locala != null) {
          locala.Fum = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(331147);
      return;
    }
  }
  
  public static void eNU()
  {
    AppMethodBeat.i(331157);
    Object localObject = Fuj;
    if ((localObject != null) && (((a)localObject).Ful == 0L)) {}
    a locala;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = Fuj;
        if (localObject != null) {
          ((a)localObject).Ful = System.currentTimeMillis();
        }
        locala = Fuj;
        if (locala != null)
        {
          if ((locala.EQt != 0L) && (locala.Fpp != 0L) && (locala.Fuk != 0L) && (locala.Fum != 0L) && (locala.Ful != 0L)) {
            break;
          }
          Log.i("LiveEnterCostReporter", "report invalid data, enter=" + locala.EQt + ", reusme=" + locala.Fpp + ", select=" + locala.Fuk + ", startPlay=" + locala.Fum + ", firstFrame=" + locala.Ful);
        }
      }
      Fuj = null;
      AppMethodBeat.o(331157);
      return;
    }
    dx localdx = new dx();
    localdx.aIM();
    localdx.ixD = 5L;
    localObject = new JSONObject();
    ((JSONObject)localObject).put("isPreloadSuccess", locala.Fuo);
    ((JSONObject)localObject).put("totalCost", locala.Ful - locala.EQt);
    ((JSONObject)localObject).put("clickToResumeCost", locala.Fpp - locala.EQt);
    ((JSONObject)localObject).put("resumeToSelectCost", locala.Fuk - locala.Fpp);
    ((JSONObject)localObject).put("selectToStartPlayCost", locala.Fum - locala.Fuk);
    ((JSONObject)localObject).put("startPlayToFirstFrame", locala.Ful - locala.Fum);
    ((JSONObject)localObject).put("selectToFirstFrameCost", locala.Ful - locala.Fuk);
    localObject = ((JSONObject)localObject).toString();
    s.s(localObject, "buildJson(data).toString()");
    localdx.nZ(n.bV((String)localObject, ",", ";"));
    if (locala.Fun) {}
    for (localObject = "PreloadCoreMode";; localObject = "NormalMode")
    {
      localdx.oa((String)localObject);
      localdx.ob(String.valueOf(locala.Ful - locala.EQt));
      localdx.bMH();
      Log.i("LiveEnterCostReporter", s.X("report21680 info:", localdx.aIF()));
      break;
    }
  }
  
  public static void notifyResume()
  {
    AppMethodBeat.i(331133);
    a locala = Fuj;
    if ((locala != null) && (locala.Fpp == 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        locala = Fuj;
        if (locala != null) {
          locala.Fpp = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(331133);
      return;
    }
  }
  
  public static void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(331119);
    a locala = new a();
    locala.EQt = System.currentTimeMillis();
    locala.Fun = paramBoolean;
    Fuj = locala;
    AppMethodBeat.o(331119);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/LiveEnterCostReporter$Data;", "", "()V", "clickEnterTime", "", "getClickEnterTime", "()J", "setClickEnterTime", "(J)V", "isPreloadCore", "", "()Z", "setPreloadCore", "(Z)V", "isPreloadSuccess", "setPreloadSuccess", "onFirstFrameTime", "getOnFirstFrameTime", "setOnFirstFrameTime", "onItemSelectTime", "getOnItemSelectTime", "setOnItemSelectTime", "onResumeTime", "getOnResumeTime", "setOnResumeTime", "onStartPlay", "getOnStartPlay", "setOnStartPlay", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    long EQt;
    long Fpp;
    long Fuk;
    long Ful;
    long Fum;
    boolean Fun;
    boolean Fuo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.av
 * JD-Core Version:    0.7.0.1
 */