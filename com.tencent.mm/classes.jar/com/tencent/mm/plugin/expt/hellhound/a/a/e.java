package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.ebf;
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
  static c<String, Integer> a(ebf paramebf)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramebf.NaV;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dzv localdzv = (dzv)((Iterator)localObject).next();
        if (localdzv != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localdzv.feedId);
          localJSONObject.put("viewLikeCount", localdzv.likeCount);
          localJSONObject.put("viewCommentCount", localdzv.commentCount);
          localJSONObject.put("userName", localdzv.userName);
          localJSONObject.put("nickName", localdzv.nickName);
          localJSONObject.put("isAd", localdzv.isAd);
          localJSONObject.put("feedheight", localdzv.height);
          localdzv.MZu = new BigDecimal(localdzv.MZu).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localdzv.MZu);
          localdzv.MZt = new BigDecimal(localdzv.MZt).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localdzv.MZt);
          localJSONObject.put("realScreenHeight", localdzv.mEY - localdzv.CHZ - localdzv.udM - localdzv.virtualKeyHeight);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramebf)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramebf, "_feedList2JsonV2-crash, %s", new Object[] { paramebf.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramebf = a.Q(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramebf;
    }
    Log.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramebf));
    paramebf = a.Q(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramebf;
  }
  
  private static JSONObject b(ebf paramebf)
  {
    AppMethodBeat.i(177366);
    Log.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramebf.NaS), Long.valueOf(paramebf.NaT), Long.valueOf(paramebf.NaU) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramebf.NaS).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramebf.NaS).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramebf)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramebf, "createInvalidateFeed-crash, %s", new Object[] { paramebf.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.e
 * JD-Core Version:    0.7.0.1
 */