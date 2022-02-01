package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbp;
import com.tencent.mm.protocal.protobuf.oz;
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
  static List<c<String, String>> a(cjr paramcjr, bmz parambmz)
  {
    AppMethodBeat.i(122218);
    if ((parambmz == null) || (parambmz.SXQ.isEmpty()))
    {
      Log.e("HABBYGE-MALI.FuzzyDetailReport", "reportFuzzyMatch，toJson: cache == null");
      AppMethodBeat.o(122218);
      return null;
    }
    Object localObject3 = new HashMap();
    Object localObject2 = parambmz.SXQ.iterator();
    Object localObject4;
    Object localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (bnc)((Iterator)localObject2).next();
      if (((Map)localObject3).containsKey(Long.valueOf(((bnc)localObject4).SYb)))
      {
        localObject1 = (List)((Map)localObject3).get(Long.valueOf(((bnc)localObject4).SYb));
        parambmz = (bmz)localObject1;
        if (localObject1 != null) {}
      }
      for (parambmz = new ArrayList();; parambmz = new ArrayList())
      {
        parambmz.add(localObject4);
        ((Map)localObject3).put(Long.valueOf(((bnc)localObject4).SYb), parambmz);
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
        bnc localbnc1 = (bnc)((List)localObject4).get(0);
        if (localbnc1.Aaj)
        {
          JSONObject localJSONObject1 = i.j(paramcjr);
          if (localJSONObject1 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              if (i >= ((List)localObject4).size()) {
                break label439;
              }
              bnc localbnc2 = (bnc)((List)localObject4).get(i);
              JSONObject localJSONObject2 = new JSONObject();
              try
              {
                localJSONObject2.put("pagePathId", localbnc2.SYb);
                localJSONObject2.put("sessionId", localbnc2.fLj);
                localObject1 = g.a(paramcjr, localbnc2.fLj);
                parambmz = (bmz)localObject1;
                if (localObject1 == null) {
                  parambmz = "";
                }
                localJSONObject2.put("lastSessionId", parambmz);
                localJSONObject2.put("pagePath", a(localbnc2, localJSONObject2));
                localJSONArray.put(localJSONObject2);
              }
              catch (Exception parambmz)
              {
                for (;;)
                {
                  Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", parambmz, "toJson, crash-FuzzyPath-1: %s", new Object[] { parambmz.getMessage() });
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
                ((List)localObject2).add(a.J(localbnc1.SYa, localJSONObject1.toString()));
              }
              catch (JSONException parambmz)
              {
                Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", parambmz, "toJson, crash-FuzzyPath-2: %s", new Object[] { parambmz.getMessage() });
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(122218);
    return localObject2;
  }
  
  private static JSONArray a(bnc parambnc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(169359);
    JSONArray localJSONArray1 = new JSONArray();
    if ((parambnc == null) || (parambnc.SXY.isEmpty()))
    {
      AppMethodBeat.o(169359);
      return localJSONArray1;
    }
    int j = parambnc.SXY.size();
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      bnb localbnb;
      JSONObject localJSONObject;
      JSONArray localJSONArray2;
      if (i < j) {
        for (;;)
        {
          try
          {
            localbnb = (bnb)parambnc.SXY.get(i);
            localJSONObject = new JSONObject();
            localJSONObject.put("pageName", localbnb.name);
            localJSONObject.put("tbe", localbnb.startTime);
            localJSONObject.put("in", localbnb.SXT);
            long l2 = localbnb.SXT;
            l1 += l2;
            if (i == 0) {}
            try
            {
              paramJSONObject.put("tbe", localbnb.startTime);
            }
            catch (Exception localException)
            {
              Log.printInfoStack("HABBYGE-MALI.FuzzyDetailReport", "createFuzzyPathJsonArray, exception: %s", new Object[] { localException.getMessage() });
            }
          }
          catch (JSONException parambnc)
          {
            Log.printErrStackTrace("HABBYGE-MALI.FuzzyDetailReport", parambnc, "createFuzzyPathJsonArray crash: %s", new Object[] { parambnc.getMessage() });
          }
          try
          {
            localJSONArray2 = new JSONArray();
            if (localbnb != null) {
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
              a(localbnb, localJSONArray2, parambnc.SYb);
            }
            Log.e("HABBYGE-MALI.FuzzyDetailReport", "Neither prePage nor curPage !!");
            localJSONObject.put("businessParam", localJSONArray2);
            continue;
          }
          a(localJSONObject, parambnc, localbnb);
          localJSONArray1.put(localJSONObject);
          break label497;
          AppMethodBeat.o(169359);
          return localJSONArray1;
          label240:
          localObject2 = parambnc.SXX;
          if ((parambnc.SXW.isEmpty()) || (parambnc.SXW.size() != 1)) {
            break;
          }
          str1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)parambnc.SXW.get(0)).fFe);
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject2).fFe);
          str2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbnb.name);
          if ((str1 == null) || (!str1.equals(str2))) {
            break label400;
          }
          Log.i("HABBYGE-MALI.FuzzyDetailReport", "sPrePageName: %s, %s", new Object[] { str1, str2 });
          a(localbnb, localJSONArray2, parambnc.SYb);
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
  
  private static void a(bnb parambnb, JSONArray paramJSONArray, long paramLong)
  {
    AppMethodBeat.i(257326);
    if (!parambnb.SXU.isEmpty())
    {
      j.a(paramJSONArray, parambnb, paramLong);
      AppMethodBeat.o(257326);
      return;
    }
    parambnb = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambnb.name);
    if (parambnb != null) {
      j.d(parambnb, false, paramLong);
    }
    AppMethodBeat.o(257326);
  }
  
  private static void a(JSONObject paramJSONObject, bnc parambnc, bnb parambnb)
  {
    AppMethodBeat.i(257323);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = parambnb.SXV.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (fbo)localIterator.next();
      if ((localObject2 != null) && (a((fbo)localObject2, parambnb, parambnc)))
      {
        i = 1;
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", ((fbo)localObject2).UBI);
        localJSONObject1.put("type", ((fbo)localObject2).type);
        localJSONObject1.put("action", ((fbo)localObject2).eventId);
        localJSONObject1.put("timestamp", ((fbo)localObject2).timestamp);
        Object localObject1;
        if (!((fbo)localObject2).RXm.isEmpty())
        {
          localObject1 = new JSONArray();
          localObject2 = ((fbo)localObject2).RXm.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (oz)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((oz)localObject3).RXl == parambnc.SYb))
            {
              localObject3 = ((oz)localObject3).RXm.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                cjq localcjq = (cjq)((Iterator)localObject3).next();
                if ((localcjq != null) && (localcjq.dataPath != null))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localcjq.dataPath);
                  localJSONObject2.put("value", localcjq.value);
                  ((JSONArray)localObject1).put(localJSONObject2);
                }
              }
            }
          }
          if (((JSONArray)localObject1).length() > 0)
          {
            localJSONObject1.put("businessParam", localObject1);
            l.v(parambnc.SYb, 4);
          }
        }
        for (;;)
        {
          localJSONArray.put(localJSONObject1);
          break;
          l.v(parambnc.SYb, 5);
          continue;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambnb.name);
          if (localObject1 != null) {
            j.k(((fbo)localObject2).UBI, (String)localObject1, parambnc.SYb);
          }
        }
      }
    }
    paramJSONObject.put("viewOp", localJSONArray);
    if (i == 0)
    {
      AppMethodBeat.o(257323);
      return;
    }
    if (parambnb.SXV.isEmpty())
    {
      paramJSONObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambnb.name);
      if (paramJSONObject != null) {
        j.as(paramJSONObject, parambnc.SYb);
      }
      AppMethodBeat.o(257323);
      return;
    }
    if (localJSONArray.length() > 0) {}
    for (i = 2;; i = 3)
    {
      l.v(parambnc.SYb, i);
      AppMethodBeat.o(257323);
      return;
    }
  }
  
  private static boolean a(fbo paramfbo, bnb parambnb, bnc parambnc)
  {
    AppMethodBeat.i(257324);
    parambnb = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambnb.name);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(parambnc.SXX.fFe);
    Object localObject2;
    if ((localObject1 != null) && (((String)localObject1).equals(parambnb)))
    {
      localObject1 = parambnc.SXX.UiH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (fbp)((Iterator)localObject1).next();
        if (com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramfbo, (fbp)localObject2))
        {
          Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: entry: viewNode=%s, %s", new Object[] { ((fbp)localObject2).viewId, ((fbp)localObject2).UBI });
          AppMethodBeat.o(257324);
          return true;
        }
      }
    }
    do
    {
      parambnc = parambnc.SXW.iterator();
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          if (!parambnc.hasNext()) {
            break;
          }
          localObject1 = (efi)parambnc.next();
          localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject1).fFe);
        } while ((localObject2 == null) || (!((String)localObject2).equals(parambnb)));
        localObject1 = ((efi)localObject1).UiH.iterator();
      }
      localObject2 = (fbp)((Iterator)localObject1).next();
    } while (!com.tencent.mm.plugin.expt.hellhound.core.b.c.g.a(paramfbo, (fbp)localObject2));
    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: prePage=%s, %s", new Object[] { ((fbp)localObject2).viewId, ((fbp)localObject2).UBI });
    AppMethodBeat.o(257324);
    return true;
    Log.i("HABBYGE-MALI.FuzzyDetailReport", "inConfig: false: %s, %s", new Object[] { paramfbo.id, paramfbo.UBI });
    AppMethodBeat.o(257324);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.b
 * JD-Core Version:    0.7.0.1
 */