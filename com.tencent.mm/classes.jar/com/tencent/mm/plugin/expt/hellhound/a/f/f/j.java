package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  public static void a(bjt parambjt, bjw parambjw, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(parambjt.EZk, new Comparator() {});
    Object localObject1 = c(parambjt);
    Object localObject2 = parambjw.EZo.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ccs)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((ccs)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((bju)localList.get(0)).startTime = ((ccs)localObject3).startTime;
      }
    }
    localObject2 = parambjw.EZq.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cco)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((cco)localObject3).qoi + "_" + ((cco)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((bju)localList.get(0)).startTime = ((cco)localObject3).startTime;
      }
    }
    int k = parambjt.EZk.size();
    if (k > 0)
    {
      localObject1 = (bju)parambjt.EZk.getFirst();
      if (localObject1 != null) {
        ((bju)localObject1).startTime = parambjw.EZm;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (bju)parambjt.EZk.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (bju)parambjt.EZk.get(i + 1);
        if ((localObject2 != null) && (((bju)localObject1).duration == 0L))
        {
          l1 = ((bju)localObject2).startTime - ((bju)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((bju)localObject1).duration = l1;
        i += 1;
        break;
        label365:
        l1 = 0L;
      }
    }
    label371:
    if (paramBoolean)
    {
      l1 = 0L;
      i = j;
      if (i < k)
      {
        localObject1 = (bju)parambjt.EZk.get(i);
        if ((localObject1 == null) || (((bju)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((bju)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      parambjw.EZn = (parambjw.EZm + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        parambjt = (bju)parambjt.EZk.getLast();
        if (parambjt != null)
        {
          long l3 = parambjw.EZn - parambjt.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          parambjt.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(bjw parambjw, bju parambju)
  {
    AppMethodBeat.i(122256);
    ac.i("HellSessionReportUtil", "HABBYGE-MALI, adjustSession");
    Object localObject4 = null;
    Object localObject5 = parambjw.EZo.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (ccs)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((ccs)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((ccs)localObject2).endTime <= localObject1.endTime) {
            break label503;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      localObject4 = localObject3;
      break;
      localObject5 = null;
      Iterator localIterator = parambjw.EZq.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (cco)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((cco)localObject3).startTime < ((cco)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((cco)localObject3).endTime <= ((cco)localObject2).endTime) {
              break label496;
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject3;
        localObject5 = localObject6;
        break;
        int j;
        int i;
        if (localObject4 == null)
        {
          if (localObject5 == null)
          {
            AppMethodBeat.o(122256);
            return;
          }
          j = 0;
          i = j;
          if (((cco)localObject5).qoi.equals(parambju.qoi))
          {
            i = j;
            if (((cco)localObject5).startTime == parambju.startTime) {
              i = 1;
            }
          }
          ((cco)localObject5).startTime = parambjw.EZm;
          if (i != 0)
          {
            ac.i("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page TRUE !!!");
            parambju.startTime = ((cco)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((cco)localObject2).endTime = parambjw.EZn;
          AppMethodBeat.o(122256);
          return;
          ac.e("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((cco)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((cco)localObject5).qoi.equals(parambju.qoi))
            {
              i = j;
              if (((cco)localObject5).startTime == parambju.startTime) {
                i = 1;
              }
            }
            ((cco)localObject5).startTime = parambjw.EZm;
            if (i != 0)
            {
              ac.i("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page TRUE !!!");
              parambju.startTime = ((cco)localObject5).startTime;
            }
            else
            {
              ac.e("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = parambjw.EZm;
          }
        }
        if ((localObject2 != null) && (((cco)localObject2).endTime > localObject1.endTime))
        {
          ((cco)localObject2).endTime = parambjw.EZn;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = parambjw.EZn;
        label490:
        AppMethodBeat.o(122256);
        return;
        label496:
        localObject3 = localObject2;
      }
      label503:
      localObject2 = localObject1;
    }
  }
  
  static void a(JSONArray paramJSONArray, aqf paramaqf)
  {
    AppMethodBeat.i(122258);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramaqf.EJd.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bjv)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bjv)localObject2).koY))) {
        localArrayList.add(((bjv)localObject2).koY);
      }
    }
    label315:
    for (;;)
    {
      try
      {
        localObject2 = paramaqf.EJd.iterator();
        int i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          bjv localbjv = (bjv)((Iterator)localObject2).next();
          if (localbjv != null)
          {
            JSONObject localJSONObject = new JSONObject();
            if (localbjv.dsY == null)
            {
              localObject1 = "";
              localJSONObject.put("dataPath", localObject1);
              if (localbjv.value == null)
              {
                localObject1 = "";
                localJSONObject.put("value", localObject1);
                if (!TextUtils.isEmpty(localbjv.koY)) {
                  continue;
                }
                long l = paramaqf.startTime;
                i += 1;
                localObject1 = b.v(l, i);
                if (localArrayList.contains(localObject1)) {
                  break label315;
                }
                localArrayList.add(localObject1);
                localJSONObject.put("businessId", localObject1);
                ac.i("HellSessionReportUtil", "HABBYGE-MALI, handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
                paramJSONArray.put(localJSONObject);
              }
            }
            else
            {
              localObject1 = localbjv.dsY;
              continue;
            }
            localObject1 = localbjv.value;
            continue;
            localObject1 = localbjv.koY;
          }
        }
        else
        {
          AppMethodBeat.o(122258);
          return;
        }
      }
      catch (JSONException paramJSONArray)
      {
        ac.printErrStackTrace("HellSessionReportUtil", paramJSONArray, "HABBYGE-MALI, handleFuzzyPathDetailParams: %s", new Object[] { paramJSONArray.getMessage() });
        AppMethodBeat.o(122258);
        return;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, bju parambju, boolean paramBoolean)
  {
    AppMethodBeat.i(122259);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = parambju.EZl;; localObject1 = parambju.EJd)
    {
      localJSONArray = new JSONArray();
      if (!((List)localObject1).isEmpty()) {
        break;
      }
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(122259);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (bjv)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bjv)localObject2).koY))) {
        localArrayList.add(((bjv)localObject2).koY);
      }
    }
    localIterator = ((List)localObject1).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bjv localbjv = (bjv)localIterator.next();
      if (localbjv != null)
      {
        localObject2 = new JSONObject();
        if (localbjv.dsY == null)
        {
          localObject1 = "";
          label189:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localbjv.value != null) {
            break label327;
          }
          localObject1 = "";
          label211:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localbjv.koY)) {
            break label337;
          }
          int j;
          do
          {
            long l = parambju.startTime;
            j = i + 1;
            localObject1 = b.v(l, j);
            i = j;
          } while (localArrayList.contains(localObject1));
          localArrayList.add(localObject1);
          i = j;
        }
        for (;;)
        {
          ((JSONObject)localObject2).put("businessId", localObject1);
          ac.i("HellSessionReportUtil", "HABBYGE-MALI, handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
          localJSONArray.put(localObject2);
          break;
          localObject1 = localbjv.dsY;
          break label189;
          label327:
          localObject1 = localbjv.value;
          break label211;
          label337:
          localObject1 = localbjv.koY;
        }
      }
    }
    paramJSONObject.put("businessParam", localJSONArray);
    AppMethodBeat.o(122259);
  }
  
  static Map<String, List<bju>> c(bjt parambjt)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambjt.EZk.iterator();
    while (localIterator.hasNext())
    {
      bju localbju = (bju)localIterator.next();
      if (localbju != null) {
        if ((localbju.dnh != null) && (!localbju.dnh.isEmpty()))
        {
          if (localHashMap.containsKey(localbju.dnh))
          {
            List localList = (List)localHashMap.get(localbju.dnh);
            parambjt = localList;
            if (localList == null) {
              parambjt = new ArrayList();
            }
            parambjt.add(localbju);
            localHashMap.put(localbju.dnh, parambjt);
          }
          else
          {
            parambjt = new ArrayList();
            parambjt.add(localbju);
            localHashMap.put(localbju.dnh, parambjt);
          }
        }
        else
        {
          parambjt = new ArrayList();
          parambjt.add(localbju);
          localHashMap.put(localbju.qoi + "_" + localbju.startTime, parambjt);
        }
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<bju>> d(bjt parambjt)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambjt.EZk.iterator();
    while (localIterator.hasNext())
    {
      bju localbju = (bju)localIterator.next();
      if (localbju != null) {
        if ((localbju.dnh != null) && (!localbju.dnh.isEmpty()))
        {
          if (localHashMap.containsKey(localbju.dnh))
          {
            List localList = (List)localHashMap.get(localbju.dnh);
            parambjt = localList;
            if (localList == null) {
              parambjt = new ArrayList();
            }
            parambjt.add(localbju);
          }
          else
          {
            parambjt = new ArrayList();
            parambjt.add(localbju);
            localHashMap.put(localbju.dnh, parambjt);
          }
        }
        else if (!localHashMap.containsKey(localbju.qoi))
        {
          parambjt = new ArrayList();
          parambjt.add(localbju);
          localHashMap.put(localbju.qoi, parambjt);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(bjw parambjw, bjt parambjt, ccs paramccs)
  {
    AppMethodBeat.i(177407);
    ac.i("HellSessionReportUtil", "HABBYGE-MALI, HellSessionReportUtil, realReport");
    k.a(parambjw, parambjt);
    k(parambjw);
    e(parambjw, parambjt, paramccs);
    a.f(parambjw);
    AppMethodBeat.o(177407);
  }
  
  private static bjt e(bjt parambjt)
  {
    AppMethodBeat.i(122257);
    bjt localbjt = new bjt();
    parambjt = parambjt.EZk.iterator();
    while (parambjt.hasNext())
    {
      bju localbju1 = (bju)parambjt.next();
      bju localbju2 = new bju();
      localbju2.dnh = localbju1.dnh;
      localbju2.qoi = localbju1.qoi;
      localbju2.startTime = localbju1.startTime;
      localbju2.duration = localbju1.duration;
      localbju2.count = localbju1.count;
      localbjt.EZk.add(localbju2);
    }
    AppMethodBeat.o(122257);
    return localbjt;
  }
  
  private static void e(bjw parambjw, bjt parambjt, ccs paramccs)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv;
    localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.ckd();
    g.a(parambjw, parambjt, (aqd)localObject, paramccs);
    h.a(parambjw, e(parambjt), (aqd)localObject, paramccs);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cle();
    parambjw = com.tencent.mm.plugin.expt.hellhound.a.d.a.qpv;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.ckc();
    AppMethodBeat.o(177408);
  }
  
  private static void k(bjw parambjw)
  {
    AppMethodBeat.i(122251);
    c.ckB();
    if (c.ckE())
    {
      ac.i("HellSessionReportUtil", "HABBYGE-MALI, HellSessionReportUtil, reportSession Detail true");
      e.f(parambjw);
    }
    f.f(parambjw);
    AppMethodBeat.o(122251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.j
 * JD-Core Version:    0.7.0.1
 */