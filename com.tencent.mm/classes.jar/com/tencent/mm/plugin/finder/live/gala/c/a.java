package com.tencent.mm.plugin.finder.live.gala.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.report.k;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/gala/report/BoxReportUtil;", "", "()V", "reportEnterBox", "", "boxId", "", "reportExitBox", "enterTime", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a adlY;
  
  static
  {
    AppMethodBeat.i(371196);
    adlY = new a();
    AppMethodBeat.o(371196);
  }
  
  public static void aCS(String paramString)
  {
    AppMethodBeat.i(371182);
    s.u(paramString, "boxId");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("event_type", 1);
      localJSONObject.put("group_box_number", paramString);
      k.Doi.cH(localJSONObject);
      return;
    }
    finally
    {
      AppMethodBeat.o(371182);
    }
  }
  
  public static void cK(String paramString, long paramLong)
  {
    long l = 0L;
    AppMethodBeat.i(371189);
    s.u(paramString, "boxId");
    if (paramLong == 0L) {}
    for (paramLong = l;; paramLong = l - paramLong)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("event_type", 2);
        localJSONObject.put("group_box_number", paramString);
        localJSONObject.put("box_stay_time", paramLong);
        k.Doi.cH(localJSONObject);
        return;
      }
      finally
      {
        AppMethodBeat.o(371189);
      }
      l = cn.bDw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.gala.c.a
 * JD-Core Version:    0.7.0.1
 */