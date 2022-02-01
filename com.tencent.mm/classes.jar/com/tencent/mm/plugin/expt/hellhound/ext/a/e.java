package com.tencent.mm.plugin.expt.hellhound.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.protocal.protobuf.ffn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class e
{
  static c<String, Integer> a(ffn paramffn)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramffn.abFw;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        fed localfed = (fed)((Iterator)localObject).next();
        if (localfed != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localfed.feedId);
          localJSONObject.put("viewLikeCount", localfed.likeCount);
          localJSONObject.put("viewCommentCount", localfed.commentCount);
          localJSONObject.put("userName", localfed.userName);
          localJSONObject.put("nickName", localfed.nickName);
          localJSONObject.put("isAd", localfed.isAd);
          localJSONObject.put("feedheight", localfed.height);
          localfed.abDP = new BigDecimal(localfed.abDP).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localfed.abDP);
          localfed.abDO = new BigDecimal(localfed.abDO).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localfed.abDO);
          localJSONObject.put("realScreenHeight", localfed.pvg - localfed.vpn - localfed.BqU - localfed.virtualKeyHeight);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramffn)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramffn, "_feedList2JsonV2-crash, %s", new Object[] { paramffn.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramffn = a.U(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramffn;
    }
    Log.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramffn));
    paramffn = a.U(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramffn;
  }
  
  private static JSONObject b(ffn paramffn)
  {
    AppMethodBeat.i(177366);
    Log.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramffn.abFt), Long.valueOf(paramffn.abFu), Long.valueOf(paramffn.abFv) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramffn.abFt).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramffn.abFt).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramffn)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramffn, "createInvalidateFeed-crash, %s", new Object[] { paramffn.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.e
 * JD-Core Version:    0.7.0.1
 */