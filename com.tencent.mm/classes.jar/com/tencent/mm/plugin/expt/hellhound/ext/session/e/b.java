package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b
{
  static List<c<String, String>> a(czw paramczw, cat paramcat)
  {
    AppMethodBeat.i(122218);
    if ((paramcat == null) || (paramcat.aajM.isEmpty()))
    {
      Log.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    Object localObject3 = new HashMap();
    Object localObject2 = paramcat.aajM.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (caw)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((caw)localObject4).aajX)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((caw)localObject4).aajX));
        paramcat = (cat)localObject1;
        if (localObject1 != null) {}
      }
      for (paramcat = new ArrayList();; paramcat = new ArrayList())
      {
        paramcat.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((caw)localObject4).aajX), paramcat);
        break;
      }
    }
    if (((Map)localObject3).isEmpty())
    {
      Log.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: ppidPathsMap == null");
      AppMethodBeat.o(122218);
      return null;
    }
    localObject2 = new ArrayList();
    localObject3 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (List)((Map.Entry)((Iterator)localObject3).next()).getValue();
      if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
      {
        caw localcaw1 = (caw)((List)localObject4).get(0);
        if (localcaw1.lAr)
        {
          JSONObject localJSONObject1 = i.j(paramczw);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label439;
              }
              caw localcaw2 = (caw)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localcaw2.aajX);
                localJSONObject2.put("sessionId", localcaw2.hQR);
                localObject1 = g.a(paramczw, localcaw2.hQR);
                paramcat = (cat)localObject1;
                if (localObject1 == null) {
                  paramcat = "";
                }
                localJSONObject2.put("lastSessionId", paramcat);
                localJSONObject2.put("pagePath", a(localcaw2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception paramcat)
              {
                for (;;)
                {
                  Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramcat, "toJson, crash-FuzzyPath-1: %s", new Object[] { paramcat.getMessage() });
                }
              }
              i += 1;
            }
            label439:
            if (localJSONArray.length() <= 0) {
              Log.e("HABBYGE-MALI.FuzzyDetailReport", "content is NULL !!");
            } else {
              try
              {
                localJSONObject1.put("content", localJSONArray);
                ((List)localObject2).add(a.U(localcaw1.aajW, localJSONObject1.toString()));
              }
              catch (JSONException paramcat)
              {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramcat, "toJson, crash-FuzzyPath-2: %s", new Object[] { paramcat.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(caw paramcaw, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((paramcaw == null) || (paramcaw.aajU.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = paramcaw.aajU.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      cav localcav;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localcav = (cav)paramcaw.aajU.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localcav.name);
            localJSONObject.put("tbe", localcav.startTime);
            localJSONObject.put("in", localcav.aajP);
            long l2 = localcav.aajP;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localcav.startTime);
            }
            catch (Exception localException)
            {
              Log.printInfoStack("HABBYGE-MALI.FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException paramcaw)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", paramcaw, "createFuzzyPathJsonArray crash: %s", new Object[] { paramcaw.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localcav != null) {
              break label240;
            }
            localJSONObject.put("businessParam", localJSONArray2);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Object localObject2;
              String str1;
              String str2;
              Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", localJSONException, "_getBizParams crash: %s", new Object[] { localJSONException.getMessage() });
              break;
              Object localObject1 = null;
              continue;
              if ((localObject2 == null) || (!((String)localObject2).equals(str2))) {
                break label451;
              }
              Log.i("HABBYGE-MALI.FuzzyDetailReport", "sCurPageName: %s, %s", new Object[] { localObject2, str2 });
              a(localcav, localJSONArray2, paramcaw.aajX);
            }
            Log.e("HABBYGE-MALI.FuzzyDetailReport", "Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          a(localJSONObject, paramcaw, localcav);
          localJSONArray1.put(localJSONObject);
          break label497;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label240:
          localObject2 = paramcaw.aajT;
          if ((paramcaw.aajS.isEmpty()) || (paramcaw.aajS.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)paramcaw.aajS.get(0)).hJW);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject2).hJW);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localcav.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label400;
          }
          Log.i("HABBYGE-MALI.FuzzyDetailReport", "sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localcav, localJSONArray2, paramcaw.aajX);
          localJSONObject.put("businessParam", localJSONArray2);
        }
      }
      label400:
      label451:
      if (l1 > 0L) {}
      for (;;)
      {
        paramJSONObject.put("in", l1);
        break;
        l1 = 0L;
      }
      label497:
      i += 1;
    }
  }
  
  private static void a(cav paramcav, JSONArray paramJSONArray, long paramLong)
  {
    AppMethodBeat.i(300217);
    if (!paramcav.aajQ.isEmpty())
    {
      j.a(paramJSONArray, paramcav, paramLong);
      AppMethodBeat.o(300217);
      return;
    }
    paramcav = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramcav.name);
    if (paramcav != null) {
      j.d(paramcav, false, paramLong);
    }
    AppMethodBeat.o(300217);
  }
  
  private static void a(JSONObject paramJSONObject, caw paramcaw, cav paramcav)
  {
    AppMethodBeat.i(300213);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramcav.aajR.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (fxz)localIterator.next();
      if ((localObject2 != null) && (a((fxz)localObject2, paramcav, paramcaw)))
      {
        i = 1;
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", ((fxz)localObject2).abVR);
        localJSONObject1.put("type", ((fxz)localObject2).type);
        localJSONObject1.put("action", ((fxz)localObject2).eventId);
        localJSONObject1.put("timestamp", ((fxz)localObject2).timestamp);
        Object localObject1;
        if (!((fxz)localObject2).YVe.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((fxz)localObject2).YVe.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (qi)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((qi)localObject3).YVd == paramcaw.aajX))
            {
              localObject3 = ((qi)localObject3).YVe.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                czv localczv = (czv)((Iterator)localObject3).next();
                if ((localczv != null) && (localczv.dataPath != null))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localczv.dataPath);
                  localJSONObject2.put("value", localczv.value);
                  ((JSONArray)localObject1).put(localJSONObject2);
                }
              }
            }
          }
          if (((JSONArray)localObject1).length() > 0)
          {
            localJSONObject1.put("businessParam", localObject1);
            l.F(paramcaw.aajX, 4);
          }
        }
        for (;;)
        {
          localJSONArray.put(localJSONObject1);
          break;
          l.F(paramcaw.aajX, 5);
          continue;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramcav.name);
          if (localObject1 != null) {
            j.k(((fxz)localObject2).abVR, (String)localObject1, paramcaw.aajX);
          }
        }
      }
    }
    paramJSONObject.put("viewOp", localJSONArray);
    if (i == 0)
    {
      AppMethodBeat.o(300213);
      return;
    }
    if (paramcav.aajR.isEmpty())
    {
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramcav.name);
      if (paramJSONObject != null) {
        j.aA(paramJSONObject, paramcaw.aajX);
      }
      AppMethodBeat.o(300213);
      return;
    }
    if (localJSONArray.length() > 0) {}
    for (i = 2;; i = 3)
    {
      l.F(paramcaw.aajX, i);
      AppMethodBeat.o(300213);
      return;
    }
  }
  
  private static boolean a(fxz paramfxz, cav paramcav, caw paramcaw)
  {
    AppMethodBeat.i(300215);
    paramcav = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramcav.name);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramcaw.aajT.hJW);
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(paramcav)))
    {
      localObject1 = paramcaw.aajT.abAg.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (fya)((Iterator)localObject1).next();
        if (com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramfxz, (fya)localObject2))
        {
          Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: entry: viewNode=%s, %s", new Object[] { ((fya)localObject2).viewId, ((fya)localObject2).abVR });
          AppMethodBeat.o(300215);
          return true;
        }
      }
    }
    do
    {
      paramcaw = paramcaw.aajS.iterator();
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          if (!paramcaw.hasNext()) {
            break;
          }
          localObject1 = (ezb)paramcaw.next();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject1).hJW);
        } while ((localObject2 == null) || (!((String)localObject2).equals(paramcav)));
        localObject1 = ((ezb)localObject1).abAg.iterator();
      }
      localObject2 = (fya)((Iterator)localObject1).next();
    } while (!com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramfxz, (fya)localObject2));
    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: prePage=%s, %s", new Object[] { ((fya)localObject2).viewId, ((fya)localObject2).abVR });
    AppMethodBeat.o(300215);
    return true;
    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: false: %s, %s", new Object[] { paramfxz.id, paramfxz.abVR });
    AppMethodBeat.o(300215);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.b
 * JD-Core Version:    0.7.0.1
 */