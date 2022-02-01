package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class d
{
  static c<String, Integer> a(dhc paramdhc)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramdhc.HvC;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dfu localdfu = (dfu)((Iterator)localObject).next();
        if (localdfu != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localdfu.feedId);
          localJSONObject.put("viewLikeCount", localdfu.likeCount);
          localJSONObject.put("viewCommentCount", localdfu.commentCount);
          localJSONObject.put("userName", localdfu.userName);
          localJSONObject.put("nickName", localdfu.bVF);
          localJSONObject.put("isAd", localdfu.isAd);
          localJSONObject.put("feedheight", localdfu.height);
          localdfu.Huk = new BigDecimal(localdfu.Huk).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localdfu.Huk);
          localdfu.Huj = new BigDecimal(localdfu.Huj).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localdfu.Huj);
          localJSONObject.put("realScreenHeight", localdfu.ltB - localdfu.yYM - localdfu.sFm - localdfu.Hug);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramdhc)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramdhc, "_feedList2JsonV2-crash, %s", new Object[] { paramdhc.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramdhc = a.N(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramdhc;
    }
    ad.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramdhc));
    paramdhc = a.N(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramdhc;
  }
  
  private static JSONObject b(dhc paramdhc)
  {
    AppMethodBeat.i(177366);
    ad.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramdhc.Hvz), Long.valueOf(paramdhc.HvA), Long.valueOf(paramdhc.HvB) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramdhc.Hvz).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramdhc.Hvz).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramdhc)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramdhc, "createInvalidateFeed-crash, %s", new Object[] { paramdhc.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.d
 * JD-Core Version:    0.7.0.1
 */