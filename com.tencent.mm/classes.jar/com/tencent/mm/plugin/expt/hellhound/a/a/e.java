package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ejv;
import com.tencent.mm.protocal.protobuf.elf;
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
  static c<String, Integer> a(elf paramelf)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramelf.Unp;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ejv localejv = (ejv)((Iterator)localObject).next();
        if (localejv != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localejv.feedId);
          localJSONObject.put("viewLikeCount", localejv.likeCount);
          localJSONObject.put("viewCommentCount", localejv.commentCount);
          localJSONObject.put("userName", localejv.userName);
          localJSONObject.put("nickName", localejv.nickName);
          localJSONObject.put("isAd", localejv.isAd);
          localJSONObject.put("feedheight", localejv.height);
          localejv.UlO = new BigDecimal(localejv.UlO).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localejv.UlO);
          localejv.UlN = new BigDecimal(localejv.UlN).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localejv.UlN);
          localJSONObject.put("realScreenHeight", localejv.pEk - localejv.INC - localejv.xRu - localejv.virtualKeyHeight);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramelf)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramelf, "_feedList2JsonV2-crash, %s", new Object[] { paramelf.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramelf = a.J(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramelf;
    }
    Log.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramelf));
    paramelf = a.J(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramelf;
  }
  
  private static JSONObject b(elf paramelf)
  {
    AppMethodBeat.i(177366);
    Log.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramelf.Unm), Long.valueOf(paramelf.Unn), Long.valueOf(paramelf.Uno) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramelf.Unm).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramelf.Unm).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramelf)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramelf, "createInvalidateFeed-crash, %s", new Object[] { paramelf.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.e
 * JD-Core Version:    0.7.0.1
 */