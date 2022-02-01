package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dah;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class d
{
  static c<String, Integer> a(dbp paramdbp)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramdbp.FKU;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dah localdah = (dah)((Iterator)localObject).next();
        if (localdah != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localdah.feedId);
          localJSONObject.put("viewLikeCount", localdah.likeCount);
          localJSONObject.put("viewCommentCount", localdah.commentCount);
          localJSONObject.put("userName", localdah.userName);
          localJSONObject.put("nickName", localdah.bLs);
          localJSONObject.put("isAd", localdah.isAd);
          localJSONObject.put("feedheight", localdah.height);
          localdah.FJC = new BigDecimal(localdah.FJC).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localdah.FJC);
          localdah.FJB = new BigDecimal(localdah.FJB).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localdah.FJB);
          localJSONObject.put("realScreenHeight", localdah.kWC - localdah.xJx - localdah.rKm - localdah.FJy);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramdbp)
    {
      ac.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramdbp, "_feedList2JsonV2-crash, %s", new Object[] { paramdbp.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramdbp = a.L(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramdbp;
    }
    ac.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramdbp));
    paramdbp = a.L(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramdbp;
  }
  
  private static JSONObject b(dbp paramdbp)
  {
    AppMethodBeat.i(177366);
    ac.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramdbp.FKR), Long.valueOf(paramdbp.FKS), Long.valueOf(paramdbp.FKT) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramdbp.FKR).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramdbp.FKR).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramdbp)
    {
      for (;;)
      {
        ac.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramdbp, "createInvalidateFeed-crash, %s", new Object[] { paramdbp.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.d
 * JD-Core Version:    0.7.0.1
 */