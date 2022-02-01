package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class d
{
  static c<String, Integer> a(dhw paramdhw)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramdhw.HPf;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dgo localdgo = (dgo)((Iterator)localObject).next();
        if (localdgo != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localdgo.feedId);
          localJSONObject.put("viewLikeCount", localdgo.likeCount);
          localJSONObject.put("viewCommentCount", localdgo.commentCount);
          localJSONObject.put("userName", localdgo.userName);
          localJSONObject.put("nickName", localdgo.bVF);
          localJSONObject.put("isAd", localdgo.isAd);
          localJSONObject.put("feedheight", localdgo.height);
          localdgo.HNN = new BigDecimal(localdgo.HNN).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localdgo.HNN);
          localdgo.HNM = new BigDecimal(localdgo.HNM).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localdgo.HNM);
          localJSONObject.put("realScreenHeight", localdgo.lya - localdgo.zpn - localdgo.sQl - localdgo.HNJ);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramdhw)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramdhw, "_feedList2JsonV2-crash, %s", new Object[] { paramdhw.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramdhw = a.N(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramdhw;
    }
    ae.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramdhw));
    paramdhw = a.N(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramdhw;
  }
  
  private static JSONObject b(dhw paramdhw)
  {
    AppMethodBeat.i(177366);
    ae.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramdhw.HPc), Long.valueOf(paramdhw.HPd), Long.valueOf(paramdhw.HPe) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramdhw.HPc).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramdhw.HPc).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramdhw)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramdhw, "createInvalidateFeed-crash, %s", new Object[] { paramdhw.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.d
 * JD-Core Version:    0.7.0.1
 */