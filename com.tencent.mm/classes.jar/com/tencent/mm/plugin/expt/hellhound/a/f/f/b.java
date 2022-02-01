package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.pd;
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
  static List<c<String, String>> a(cbo paramcbo, bfy parambfy)
  {
    AppMethodBeat.i(122218);
    if ((parambfy == null) || (parambfy.LPC.isEmpty()))
    {
      Log.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    Object localObject3 = new HashMap();
    Object localObject2 = parambfy.LPC.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (bgb)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((bgb)localObject4).LPN)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((bgb)localObject4).LPN));
        parambfy = (bfy)localObject1;
        if (localObject1 != null) {}
      }
      for (parambfy = new ArrayList();; parambfy = new ArrayList())
      {
        parambfy.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((bgb)localObject4).LPN), parambfy);
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
        bgb localbgb1 = (bgb)((List)localObject4).get(0);
        if (localbgb1.vtY)
        {
          JSONObject localJSONObject1 = i.j(paramcbo);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label439;
              }
              bgb localbgb2 = (bgb)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localbgb2.LPN);
                localJSONObject2.put("sessionId", localbgb2.dRM);
                localObject1 = g.a(paramcbo, localbgb2.dRM);
                parambfy = (bfy)localObject1;
                if (localObject1 == null) {
                  parambfy = "";
                }
                localJSONObject2.put("lastSessionId", parambfy);
                localJSONObject2.put("pagePath", a(localbgb2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception parambfy)
              {
                for (;;)
                {
                  Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", parambfy, "toJson, crash-FuzzyPath-1: %s", new Object[] { parambfy.getMessage() });
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
                ((List)localObject2).add(a.Q(localbgb1.LPM, localJSONObject1.toString()));
              }
              catch (JSONException parambfy)
              {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", parambfy, "toJson, crash-FuzzyPath-2: %s", new Object[] { parambfy.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(bgb parambgb, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((parambgb == null) || (parambgb.LPK.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = parambgb.LPK.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      bga localbga;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localbga = (bga)parambgb.LPK.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localbga.name);
            localJSONObject.put("tbe", localbga.startTime);
            localJSONObject.put("in", localbga.LPF);
            long l2 = localbga.LPF;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localbga.startTime);
            }
            catch (Exception localException)
            {
              Log.printInfoStack("HABBYGE-MALI.FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException parambgb)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", parambgb, "createFuzzyPathJsonArray crash: %s", new Object[] { parambgb.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localbga != null) {
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
              a(localbga, localJSONArray2, parambgb.LPN);
            }
            Log.e("HABBYGE-MALI.FuzzyDetailReport", "Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          a(localJSONObject, parambgb, localbga);
          localJSONArray1.put(localJSONObject);
          break label497;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label240:
          localObject2 = parambgb.LPJ;
          if ((parambgb.LPI.isEmpty()) || (parambgb.LPI.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)parambgb.LPI.get(0)).dMl);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject2).dMl);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbga.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label400;
          }
          Log.i("HABBYGE-MALI.FuzzyDetailReport", "sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localbga, localJSONArray2, parambgb.LPN);
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
  
  private static void a(bga parambga, JSONArray paramJSONArray, long paramLong)
  {
    AppMethodBeat.i(220581);
    if (!parambga.LPG.isEmpty())
    {
      j.a(paramJSONArray, parambga, paramLong);
      AppMethodBeat.o(220581);
      return;
    }
    parambga = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambga.name);
    if (parambga != null) {
      j.d(parambga, false, paramLong);
    }
    AppMethodBeat.o(220581);
  }
  
  private static void a(JSONObject paramJSONObject, bgb parambgb, bga parambga)
  {
    AppMethodBeat.i(220579);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = parambga.LPH.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (erd)localIterator.next();
      if ((localObject2 != null) && (a((erd)localObject2, parambga, parambgb)))
      {
        i = 1;
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", ((erd)localObject2).NoL);
        localJSONObject1.put("type", ((erd)localObject2).type);
        localJSONObject1.put("action", ((erd)localObject2).eventId);
        localJSONObject1.put("timestamp", ((erd)localObject2).timestamp);
        Object localObject1;
        if (!((erd)localObject2).KVY.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((erd)localObject2).KVY.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (pd)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((pd)localObject3).KVX == parambgb.LPN))
            {
              localObject3 = ((pd)localObject3).KVY.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                cbn localcbn = (cbn)((Iterator)localObject3).next();
                if ((localcbn != null) && (localcbn.dataPath != null))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localcbn.dataPath);
                  localJSONObject2.put("value", localcbn.value);
                  ((JSONArray)localObject1).put(localJSONObject2);
                }
              }
            }
          }
          if (((JSONArray)localObject1).length() > 0)
          {
            localJSONObject1.put("businessParam", localObject1);
            l.t(parambgb.LPN, 4);
          }
        }
        for (;;)
        {
          localJSONArray.put(localJSONObject1);
          break;
          l.t(parambgb.LPN, 5);
          continue;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambga.name);
          if (localObject1 != null) {
            j.i(((erd)localObject2).NoL, (String)localObject1, parambgb.LPN);
          }
        }
      }
    }
    paramJSONObject.put("viewOp", localJSONArray);
    if (i == 0)
    {
      AppMethodBeat.o(220579);
      return;
    }
    if (parambga.LPH.isEmpty())
    {
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambga.name);
      if (paramJSONObject != null) {
        j.ar(paramJSONObject, parambgb.LPN);
      }
      AppMethodBeat.o(220579);
      return;
    }
    if (localJSONArray.length() > 0) {}
    for (i = 2;; i = 3)
    {
      l.t(parambgb.LPN, i);
      AppMethodBeat.o(220579);
      return;
    }
  }
  
  private static boolean a(erd paramerd, bga parambga, bgb parambgb)
  {
    AppMethodBeat.i(220580);
    parambga = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambga.name);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(parambgb.LPJ.dMl);
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(parambga)))
    {
      localObject1 = parambgb.LPJ.MWm.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ere)((Iterator)localObject1).next();
        if (com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramerd, (ere)localObject2))
        {
          Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: entry: viewNode=%s, %s", new Object[] { ((ere)localObject2).viewId, ((ere)localObject2).NoL });
          AppMethodBeat.o(220580);
          return true;
        }
      }
    }
    do
    {
      parambgb = parambgb.LPI.iterator();
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          if (!parambgb.hasNext()) {
            break;
          }
          localObject1 = (dvg)parambgb.next();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject1).dMl);
        } while ((localObject2 == null) || (!((String)localObject2).equals(parambga)));
        localObject1 = ((dvg)localObject1).MWm.iterator();
      }
      localObject2 = (ere)((Iterator)localObject1).next();
    } while (!com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramerd, (ere)localObject2));
    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: prePage=%s, %s", new Object[] { ((ere)localObject2).viewId, ((ere)localObject2).NoL });
    AppMethodBeat.o(220580);
    return true;
    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: false: %s, %s", new Object[] { paramerd.id, paramerd.NoL });
    AppMethodBeat.o(220580);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.b
 * JD-Core Version:    0.7.0.1
 */