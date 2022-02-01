package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
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
  public static void a(bgb parambgb, bge parambge, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(parambgb.DDO, new Comparator() {});
    Object localObject1 = c(parambgb);
    Object localObject2 = parambge.DDT.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bxx)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((bxx)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((bgc)localList.get(0)).startTime = ((bxx)localObject3).startTime;
      }
    }
    localObject2 = parambge.DDV.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (bxt)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((bxt)localObject3).DDP + "_" + ((bxt)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((bgc)localList.get(0)).startTime = ((bxt)localObject3).startTime;
      }
    }
    int k = parambgb.DDO.size();
    if (k > 0)
    {
      localObject1 = (bgc)parambgb.DDO.getFirst();
      if (localObject1 != null) {
        ((bgc)localObject1).startTime = parambge.DDR;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (bgc)parambgb.DDO.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (bgc)parambgb.DDO.get(i + 1);
        if ((localObject2 != null) && (((bgc)localObject1).duration == 0L))
        {
          l1 = ((bgc)localObject2).startTime - ((bgc)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((bgc)localObject1).duration = l1;
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
        localObject1 = (bgc)parambgb.DDO.get(i);
        if ((localObject1 == null) || (((bgc)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((bgc)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      parambge.DDS = (parambge.DDR + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        parambgb = (bgc)parambgb.DDO.getLast();
        if (parambgb != null)
        {
          long l3 = parambge.DDS - parambgb.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          parambgb.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(bge parambge, bgc parambgc)
  {
    AppMethodBeat.i(122256);
    ad.i("HellSessionReportUtil", "HABBYGE-MALI, adjustSession");
    Object localObject4 = null;
    Object localObject5 = parambge.DDT.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (bxx)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((bxx)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((bxx)localObject2).endTime <= localObject1.endTime) {
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
      Iterator localIterator = parambge.DDV.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (bxt)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((bxt)localObject3).startTime < ((bxt)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((bxt)localObject3).endTime <= ((bxt)localObject2).endTime) {
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
          if (((bxt)localObject5).DDP.equals(parambgc.DDP))
          {
            i = j;
            if (((bxt)localObject5).startTime == parambgc.startTime) {
              i = 1;
            }
          }
          ((bxt)localObject5).startTime = parambge.DDR;
          if (i != 0)
          {
            ad.i("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page TRUE !!!");
            parambgc.startTime = ((bxt)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((bxt)localObject2).endTime = parambge.DDS;
          AppMethodBeat.o(122256);
          return;
          ad.e("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((bxt)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((bxt)localObject5).DDP.equals(parambgc.DDP))
            {
              i = j;
              if (((bxt)localObject5).startTime == parambgc.startTime) {
                i = 1;
              }
            }
            ((bxt)localObject5).startTime = parambge.DDR;
            if (i != 0)
            {
              ad.i("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page TRUE !!!");
              parambgc.startTime = ((bxt)localObject5).startTime;
            }
            else
            {
              ad.e("HellSessionReportUtil", "HABBYGE-MALI,  adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = parambge.DDR;
          }
        }
        if ((localObject2 != null) && (((bxt)localObject2).endTime > localObject1.endTime))
        {
          ((bxt)localObject2).endTime = parambge.DDS;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = parambge.DDS;
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
  
  static void a(JSONArray paramJSONArray, anb paramanb)
  {
    AppMethodBeat.i(122258);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramanb.Dod.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bgd)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bgd)localObject2).jOx))) {
        localArrayList.add(((bgd)localObject2).jOx);
      }
    }
    label315:
    for (;;)
    {
      try
      {
        localObject2 = paramanb.Dod.iterator();
        int i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          bgd localbgd = (bgd)((Iterator)localObject2).next();
          if (localbgd != null)
          {
            JSONObject localJSONObject = new JSONObject();
            if (localbgd.dvm == null)
            {
              localObject1 = "";
              localJSONObject.put("dataPath", localObject1);
              if (localbgd.value == null)
              {
                localObject1 = "";
                localJSONObject.put("value", localObject1);
                if (!TextUtils.isEmpty(localbgd.jOx)) {
                  continue;
                }
                long l = paramanb.startTime;
                i += 1;
                localObject1 = b.u(l, i);
                if (localArrayList.contains(localObject1)) {
                  break label315;
                }
                localArrayList.add(localObject1);
                localJSONObject.put("businessId", localObject1);
                ad.i("HellSessionReportUtil", "HABBYGE-MALI, handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
                paramJSONArray.put(localJSONObject);
              }
            }
            else
            {
              localObject1 = localbgd.dvm;
              continue;
            }
            localObject1 = localbgd.value;
            continue;
            localObject1 = localbgd.jOx;
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
        ad.printErrStackTrace("HellSessionReportUtil", paramJSONArray, "HABBYGE-MALI, handleFuzzyPathDetailParams: %s", new Object[] { paramJSONArray.getMessage() });
        AppMethodBeat.o(122258);
        return;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, bgc parambgc, boolean paramBoolean)
  {
    AppMethodBeat.i(122259);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = parambgc.DDQ;; localObject1 = parambgc.Dod)
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
      localObject2 = (bgd)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bgd)localObject2).jOx))) {
        localArrayList.add(((bgd)localObject2).jOx);
      }
    }
    localIterator = ((List)localObject1).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      bgd localbgd = (bgd)localIterator.next();
      if (localbgd != null)
      {
        localObject2 = new JSONObject();
        if (localbgd.dvm == null)
        {
          localObject1 = "";
          label189:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localbgd.value != null) {
            break label327;
          }
          localObject1 = "";
          label211:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localbgd.jOx)) {
            break label337;
          }
          int j;
          do
          {
            long l = parambgc.startTime;
            j = i + 1;
            localObject1 = b.u(l, j);
            i = j;
          } while (localArrayList.contains(localObject1));
          localArrayList.add(localObject1);
          i = j;
        }
        for (;;)
        {
          ((JSONObject)localObject2).put("businessId", localObject1);
          ad.i("HellSessionReportUtil", "HABBYGE-MALI, handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
          localJSONArray.put(localObject2);
          break;
          localObject1 = localbgd.dvm;
          break label189;
          label327:
          localObject1 = localbgd.value;
          break label211;
          label337:
          localObject1 = localbgd.jOx;
        }
      }
    }
    paramJSONObject.put("businessParam", localJSONArray);
    AppMethodBeat.o(122259);
  }
  
  static Map<String, List<bgc>> c(bgb parambgb)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambgb.DDO.iterator();
    while (localIterator.hasNext())
    {
      bgc localbgc = (bgc)localIterator.next();
      if (localbgc != null) {
        if ((localbgc.dpw != null) && (!localbgc.dpw.isEmpty()))
        {
          if (localHashMap.containsKey(localbgc.dpw))
          {
            List localList = (List)localHashMap.get(localbgc.dpw);
            parambgb = localList;
            if (localList == null) {
              parambgb = new ArrayList();
            }
            parambgb.add(localbgc);
            localHashMap.put(localbgc.dpw, parambgb);
          }
          else
          {
            parambgb = new ArrayList();
            parambgb.add(localbgc);
            localHashMap.put(localbgc.dpw, parambgb);
          }
        }
        else
        {
          parambgb = new ArrayList();
          parambgb.add(localbgc);
          localHashMap.put(localbgc.DDP + "_" + localbgc.startTime, parambgb);
        }
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<bgc>> d(bgb parambgb)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambgb.DDO.iterator();
    while (localIterator.hasNext())
    {
      bgc localbgc = (bgc)localIterator.next();
      if (localbgc != null) {
        if ((localbgc.dpw != null) && (!localbgc.dpw.isEmpty()))
        {
          if (localHashMap.containsKey(localbgc.dpw))
          {
            List localList = (List)localHashMap.get(localbgc.dpw);
            parambgb = localList;
            if (localList == null) {
              parambgb = new ArrayList();
            }
            parambgb.add(localbgc);
          }
          else
          {
            parambgb = new ArrayList();
            parambgb.add(localbgc);
            localHashMap.put(localbgc.dpw, parambgb);
          }
        }
        else if (!localHashMap.containsKey(localbgc.DDP))
        {
          parambgb = new ArrayList();
          parambgb.add(localbgc);
          localHashMap.put(localbgc.DDP, parambgb);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(bge parambge, bgb parambgb, bxx parambxx)
  {
    AppMethodBeat.i(177407);
    ad.i("HellSessionReportUtil", "HABBYGE-MALI, HellSessionReportUtil, realReport");
    k.a(parambge, parambgb);
    k(parambge);
    e(parambge, parambgb, parambxx);
    a.f(parambge);
    AppMethodBeat.o(177407);
  }
  
  private static bgb e(bgb parambgb)
  {
    AppMethodBeat.i(122257);
    bgb localbgb = new bgb();
    parambgb = parambgb.DDO.iterator();
    while (parambgb.hasNext())
    {
      bgc localbgc1 = (bgc)parambgb.next();
      bgc localbgc2 = new bgc();
      localbgc2.dpw = localbgc1.dpw;
      localbgc2.DDP = localbgc1.DDP;
      localbgc2.startTime = localbgc1.startTime;
      localbgc2.duration = localbgc1.duration;
      localbgc2.count = localbgc1.count;
      localbgb.DDO.add(localbgc2);
    }
    AppMethodBeat.o(122257);
    return localbgb;
  }
  
  private static void e(bge parambge, bgb parambgb, bxx parambxx)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO;
    localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.ccu();
    g.a(parambge, parambgb, (amz)localObject, parambxx);
    h.a(parambge, e(parambgb), (amz)localObject, parambxx);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cdw();
    parambge = com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.cct();
    AppMethodBeat.o(177408);
  }
  
  private static void k(bge parambge)
  {
    AppMethodBeat.i(122251);
    c.ccT();
    if (c.ccW())
    {
      ad.i("HellSessionReportUtil", "HABBYGE-MALI, HellSessionReportUtil, reportSession Detail true");
      e.f(parambge);
    }
    f.f(parambge);
    AppMethodBeat.o(122251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.j
 * JD-Core Version:    0.7.0.1
 */