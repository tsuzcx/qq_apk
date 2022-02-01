package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.a;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class c
{
  static com.tencent.mm.vending.j.c<String, Integer> a(cwd paramcwd)
  {
    AppMethodBeat.i(177365);
    Object localObject = paramcwd.EnV;
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cuv localcuv = (cuv)((Iterator)localObject).next();
        if (localcuv != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedId", localcuv.feedId);
          localJSONObject.put("viewLikeCount", localcuv.likeCount);
          localJSONObject.put("viewCommentCount", localcuv.commentCount);
          localJSONObject.put("userName", localcuv.userName);
          localJSONObject.put("nickName", localcuv.bNK);
          localJSONObject.put("isAd", localcuv.isAd);
          localJSONObject.put("feedheight", localcuv.height);
          localcuv.EmD = new BigDecimal(localcuv.EmD).setScale(2, 4).doubleValue();
          localJSONObject.put("realShowTime", localcuv.EmD);
          localcuv.EmC = new BigDecimal(localcuv.EmC).setScale(2, 4).doubleValue();
          localJSONObject.put("stayTimeRelative", localcuv.EmC);
          localJSONObject.put("realScreenHeight", localcuv.kvo - localcuv.wxW - localcuv.qPe - localcuv.Emz);
          localJSONArray.put(localJSONObject);
        }
      }
      i = localJSONArray.length();
    }
    catch (Exception paramcwd)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramcwd, "_feedList2JsonV2-crash, %s", new Object[] { paramcwd.getMessage() });
      AppMethodBeat.o(177365);
      return null;
    }
    int i;
    if (i > 0)
    {
      paramcwd = a.L(localJSONArray.toString(), Integer.valueOf(i));
      AppMethodBeat.o(177365);
      return paramcwd;
    }
    ad.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
    localJSONArray.put(b(paramcwd));
    paramcwd = a.L(localJSONArray.toString(), Integer.valueOf(1));
    AppMethodBeat.o(177365);
    return paramcwd;
  }
  
  private static JSONObject b(cwd paramcwd)
  {
    AppMethodBeat.i(177366);
    ad.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", new Object[] { Long.valueOf(paramcwd.EnS), Long.valueOf(paramcwd.EnT), Long.valueOf(paramcwd.EnU) });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("feedId", "10001");
      localJSONObject.put("viewLikeCount", 0);
      localJSONObject.put("viewCommentCount", 0);
      localJSONObject.put("userName", "");
      localJSONObject.put("feedheight", 0);
      localJSONObject.put("realShowTime", new BigDecimal(paramcwd.EnS).setScale(2, 4).doubleValue());
      localJSONObject.put("stayTimeRelative", new BigDecimal(paramcwd.EnS).setScale(2, 4).doubleValue());
      localJSONObject.put("realScreenHeight", 0);
      AppMethodBeat.o(177366);
      return localJSONObject;
    }
    catch (Exception paramcwd)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", paramcwd, "createInvalidateFeed-crash, %s", new Object[] { paramcwd.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */