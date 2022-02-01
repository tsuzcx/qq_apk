package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
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
  public static void a(cbl paramcbl, cbo paramcbo, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(paramcbl.Mhn, new Comparator() {});
    Object localObject1 = c(paramcbl);
    Object localObject2 = paramcbo.Mhr.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cyl)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((cyl)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((cbm)localList.get(0)).startTime = ((cyl)localObject3).startTime;
      }
    }
    localObject2 = paramcbo.Mht.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cyh)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((cyh)localObject3).dMl + "_" + ((cyh)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((cbm)localList.get(0)).startTime = ((cyh)localObject3).startTime;
      }
    }
    int k = paramcbl.Mhn.size();
    if (k > 0)
    {
      localObject1 = (cbm)paramcbl.Mhn.getFirst();
      if (localObject1 != null) {
        ((cbm)localObject1).startTime = paramcbo.Mhp;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (cbm)paramcbl.Mhn.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (cbm)paramcbl.Mhn.get(i + 1);
        if ((localObject2 != null) && (((cbm)localObject1).duration == 0L))
        {
          l1 = ((cbm)localObject2).startTime - ((cbm)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((cbm)localObject1).duration = l1;
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
        localObject1 = (cbm)paramcbl.Mhn.get(i);
        if ((localObject1 == null) || (((cbm)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((cbm)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      paramcbo.Mhq = (paramcbo.Mhp + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        paramcbl = (cbm)paramcbl.Mhn.getLast();
        if (paramcbl != null)
        {
          long l3 = paramcbo.Mhq - paramcbl.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          paramcbl.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(cbo paramcbo, cbm paramcbm)
  {
    AppMethodBeat.i(122256);
    Log.i("HABBYGE-MALI.HellSessionReportUtil", "adjustSession");
    Object localObject4 = null;
    Object localObject5 = paramcbo.Mhr.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (cyl)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((cyl)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((cyl)localObject2).endTime <= localObject1.endTime) {
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
      Iterator localIterator = paramcbo.Mht.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (cyh)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((cyh)localObject3).startTime < ((cyh)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((cyh)localObject3).endTime <= ((cyh)localObject2).endTime) {
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
          if (((cyh)localObject5).dMl.equals(paramcbm.dMl))
          {
            i = j;
            if (((cyh)localObject5).startTime == paramcbm.startTime) {
              i = 1;
            }
          }
          ((cyh)localObject5).startTime = paramcbo.Mhp;
          if (i != 0)
          {
            Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
            paramcbm.startTime = ((cyh)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((cyh)localObject2).endTime = paramcbo.Mhq;
          AppMethodBeat.o(122256);
          return;
          Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((cyh)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((cyh)localObject5).dMl.equals(paramcbm.dMl))
            {
              i = j;
              if (((cyh)localObject5).startTime == paramcbm.startTime) {
                i = 1;
              }
            }
            ((cyh)localObject5).startTime = paramcbo.Mhp;
            if (i != 0)
            {
              Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
              paramcbm.startTime = ((cyh)localObject5).startTime;
            }
            else
            {
              Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = paramcbo.Mhp;
          }
        }
        if ((localObject2 != null) && (((cyh)localObject2).endTime > localObject1.endTime))
        {
          ((cyh)localObject2).endTime = paramcbo.Mhq;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = paramcbo.Mhq;
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
  
  static void a(JSONArray paramJSONArray, bga parambga, long paramLong)
  {
    AppMethodBeat.i(220587);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = parambga.LPG.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cbn)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((cbn)localObject2).businessId))) {
        localArrayList.add(((cbn)localObject2).businessId);
      }
    }
    try
    {
      localObject2 = parambga.LPG.iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localcbn = (cbn)((Iterator)localObject2).next();
      } while (localcbn == null);
      localJSONObject = new JSONObject();
      if (localcbn.dataPath != null) {
        break label259;
      }
      localObject1 = "";
      label137:
      localJSONObject.put("dataPath", localObject1);
      if (localcbn.value != null) {
        break label269;
      }
      localObject1 = "";
      label159:
      localJSONObject.put("value", localObject1);
      if (!TextUtils.isEmpty(localcbn.businessId)) {
        break label279;
      }
    }
    catch (JSONException parambga)
    {
      for (;;)
      {
        cbn localcbn;
        JSONObject localJSONObject;
        long l;
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportUtil", parambga, "handleFuzzyPathDetailParams: %s", new Object[] { parambga.getMessage() });
        if (paramJSONArray.length() > 0) {}
        for (int i = 0;; i = 1)
        {
          l.t(paramLong, i);
          AppMethodBeat.o(220587);
          return;
        }
      }
    }
    l = parambga.startTime;
    i += 1;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.s(l, i);
    if (!localArrayList.contains(localObject1))
    {
      localArrayList.add(localObject1);
      for (;;)
      {
        localJSONObject.put("businessId", localObject1);
        Log.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
        paramJSONArray.put(localJSONObject);
        break;
        label259:
        localObject1 = localcbn.dataPath;
        break label137;
        label269:
        localObject1 = localcbn.value;
        break label159;
        label279:
        localObject1 = localcbn.businessId;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, cbm paramcbm, long paramLong)
  {
    AppMethodBeat.i(220588);
    if (paramcbm.LPH.isEmpty())
    {
      ar(paramcbm.dMl, paramLong);
      AppMethodBeat.o(220588);
      return;
    }
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = paramcbm.LPH.iterator();
    while (localIterator1.hasNext())
    {
      erd localerd = (erd)localIterator1.next();
      if ((localerd != null) && (!localerd.NoQ))
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", localerd.NoL);
        localJSONObject1.put("type", localerd.type);
        localJSONObject1.put("action", localerd.eventId);
        localJSONObject1.put("timestamp", localerd.timestamp);
        if (!localerd.KVY.isEmpty())
        {
          JSONArray localJSONArray2 = new JSONArray();
          Iterator localIterator2 = localerd.KVY.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = (pd)localIterator2.next();
            if ((localObject != null) && (((pd)localObject).KVX == paramLong))
            {
              localObject = ((pd)localObject).KVY.iterator();
              while (((Iterator)localObject).hasNext())
              {
                cbn localcbn = (cbn)((Iterator)localObject).next();
                if ((localcbn != null) && (localcbn.dataPath != null) && (a(paramLong, localcbn.dataPath, localerd)))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localcbn.dataPath);
                  localJSONObject2.put("value", localcbn.value);
                  localJSONArray2.put(localJSONObject2);
                }
              }
            }
          }
          if (localJSONArray2.length() > 0)
          {
            localJSONObject1.put("businessParam", localJSONArray2);
            l.t(paramLong, 4);
          }
        }
        for (;;)
        {
          localJSONArray1.put(localJSONObject1);
          break;
          l.t(paramLong, 5);
          continue;
          i(localerd.NoL, paramcbm.dMl, paramLong);
        }
      }
    }
    if (localJSONArray1.length() > 0) {}
    for (int i = 2;; i = 3)
    {
      l.t(paramLong, i);
      paramJSONObject.put("viewOp", localJSONArray1);
      AppMethodBeat.o(220588);
      return;
    }
  }
  
  static void a(JSONObject paramJSONObject, cbm paramcbm, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(220590);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = paramcbm.Mho;; localObject1 = paramcbm.LPG)
    {
      localJSONArray = new JSONArray();
      if (!((List)localObject1).isEmpty()) {
        break;
      }
      paramJSONObject.put("businessParam", localJSONArray);
      d(paramcbm.dMl, paramBoolean, paramLong);
      AppMethodBeat.o(220590);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (cbn)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((cbn)localObject2).businessId))) {
        localArrayList.add(((cbn)localObject2).businessId);
      }
    }
    int i = 0;
    localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      cbn localcbn = (cbn)localIterator.next();
      if (localcbn != null)
      {
        localObject2 = new JSONObject();
        if (localcbn.dataPath == null)
        {
          localObject1 = "";
          label202:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localcbn.value != null) {
            break label343;
          }
          localObject1 = "";
          label224:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localcbn.businessId)) {
            break label353;
          }
          int j;
          do
          {
            long l = paramcbm.startTime;
            j = i + 1;
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.s(l, j);
            i = j;
          } while (localArrayList.contains(localObject1));
          localArrayList.add(localObject1);
          i = j;
        }
        for (;;)
        {
          ((JSONObject)localObject2).put("businessId", localObject1);
          Log.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
          localJSONArray.put(localObject2);
          break;
          localObject1 = localcbn.dataPath;
          break label202;
          label343:
          localObject1 = localcbn.value;
          break label224;
          label353:
          localObject1 = localcbn.businessId;
        }
      }
    }
    if (!paramBoolean) {
      if (localJSONArray.length() <= 0) {
        break label401;
      }
    }
    label401:
    for (i = 0;; i = 1)
    {
      l.t(paramLong, i);
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(220590);
      return;
    }
  }
  
  private static boolean a(long paramLong, String paramString, erd paramerd)
  {
    AppMethodBeat.i(220589);
    paramerd = paramerd.NoP.iterator();
    boolean bool = false;
    for (;;)
    {
      if (!paramerd.hasNext()) {
        break label107;
      }
      Object localObject = (cgd)paramerd.next();
      if ((localObject != null) && (((cgd)localObject).KVX == paramLong))
      {
        localObject = ((cgd)localObject).MlP.iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((TextUtils.isEmpty(str)) || (!str.equals(paramString))) {
            break;
          }
          bool = true;
        }
      }
    }
    label107:
    AppMethodBeat.o(220589);
    return bool;
  }
  
  static void ar(String paramString, long paramLong)
  {
    AppMethodBeat.i(220591);
    d.cQe();
    Object localObject = d.Du(paramLong);
    int i;
    label88:
    int j;
    if (localObject != null)
    {
      localObject = ((dvk)localObject).MWr.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          dvg localdvg = (dvg)((Iterator)localObject).next();
          if (localdvg != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localdvg.dMl))) {
              break label123;
            }
            if (!localdvg.MWm.isEmpty())
            {
              i = 1;
              j = i;
              if (i == 0) {
                break label106;
              }
            }
          }
        }
      }
    }
    label106:
    label123:
    for (;;)
    {
      break;
      i = 0;
      break label88;
      j = i;
      if (j != 0) {
        l.t(paramLong, 3);
      }
      AppMethodBeat.o(220591);
      return;
    }
  }
  
  static Map<String, List<cbm>> c(cbl paramcbl)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramcbl.Mhn.iterator();
    while (localIterator.hasNext())
    {
      cbm localcbm = (cbm)localIterator.next();
      if (localcbm != null)
      {
        if ((localcbm.dRM != null) && (!localcbm.dRM.isEmpty()))
        {
          if (localHashMap.containsKey(localcbm.dRM))
          {
            List localList = (List)localHashMap.get(localcbm.dRM);
            paramcbl = localList;
            if (localList != null) {}
          }
          for (paramcbl = new ArrayList();; paramcbl = new ArrayList())
          {
            paramcbl.add(localcbm);
            localHashMap.put(localcbm.dRM, paramcbl);
            break;
          }
        }
        paramcbl = new ArrayList();
        paramcbl.add(localcbm);
        localHashMap.put(localcbm.dMl + "_" + localcbm.startTime, paramcbl);
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<cbm>> d(cbl paramcbl)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramcbl.Mhn.iterator();
    while (localIterator.hasNext())
    {
      cbm localcbm = (cbm)localIterator.next();
      if (localcbm != null)
      {
        if ((localcbm.dRM != null) && (!localcbm.dRM.isEmpty()))
        {
          if (localHashMap.containsKey(localcbm.dRM))
          {
            List localList = (List)localHashMap.get(localcbm.dRM);
            paramcbl = localList;
            if (localList != null) {}
          }
          for (paramcbl = new ArrayList();; paramcbl = new ArrayList())
          {
            paramcbl.add(localcbm);
            localHashMap.put(localcbm.dRM, paramcbl);
            break;
          }
        }
        if (!localHashMap.containsKey(localcbm.dMl))
        {
          paramcbl = new ArrayList();
          paramcbl.add(localcbm);
          localHashMap.put(localcbm.dMl, paramcbl);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(cbo paramcbo, cbl paramcbl, cyl paramcyl)
  {
    AppMethodBeat.i(177407);
    Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, realReport");
    k.a(paramcbo, paramcbl);
    k(paramcbo);
    e(paramcbo, paramcbl, paramcyl);
    a.f(paramcbo);
    AppMethodBeat.o(177407);
  }
  
  static void d(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(220593);
    if (paramBoolean)
    {
      AppMethodBeat.o(220593);
      return;
    }
    d.cQe();
    Object localObject = d.Du(paramLong);
    int i;
    label101:
    int j;
    if (localObject != null)
    {
      localObject = ((dvk)localObject).MWr.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          dvg localdvg = (dvg)((Iterator)localObject).next();
          if (localdvg != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localdvg.dMl))) {
              break label140;
            }
            if (!localdvg.MWl.isEmpty())
            {
              i = 1;
              j = i;
              if (i == 0) {
                break label123;
              }
            }
          }
        }
      }
    }
    label140:
    for (;;)
    {
      break;
      i = 0;
      break label101;
      j = i;
      label123:
      if (j != 0) {
        l.t(paramLong, 1);
      }
      AppMethodBeat.o(220593);
      return;
    }
  }
  
  private static cbl e(cbl paramcbl)
  {
    AppMethodBeat.i(122257);
    cbl localcbl = new cbl();
    paramcbl = paramcbl.Mhn.iterator();
    while (paramcbl.hasNext())
    {
      cbm localcbm1 = (cbm)paramcbl.next();
      cbm localcbm2 = new cbm();
      localcbm2.dRM = localcbm1.dRM;
      localcbm2.dMl = localcbm1.dMl;
      localcbm2.aHK = localcbm1.aHK;
      localcbm2.startTime = localcbm1.startTime;
      localcbm2.duration = localcbm1.duration;
      localcbm2.count = localcbm1.count;
      localcbl.Mhn.add(localcbm2);
    }
    AppMethodBeat.o(122257);
    return localcbl;
  }
  
  private static void e(cbo paramcbo, cbl paramcbl, cyl paramcyl)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
    localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.cPB();
    g.a(paramcbo, paramcbl, (bfy)localObject, paramcyl);
    h.a(paramcbo, e(paramcbl), (bfy)localObject, paramcyl);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cQC();
    paramcbo = com.tencent.mm.plugin.expt.hellhound.a.d.a.sHW;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.cPA();
    AppMethodBeat.o(177408);
  }
  
  static void i(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(220592);
    d.cQe();
    Object localObject1 = d.Du(paramLong);
    int i;
    label139:
    int j;
    label142:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((dvk)localObject1).MWr.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (dvg)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (!paramString2.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((dvg)localObject2).dMl))) {
            break label187;
          }
          localObject2 = ((dvg)localObject2).MWm.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              ere localere = (ere)((Iterator)localObject2).next();
              if ((localere != null) && (paramString1.equals(localere.NoL))) {
                if (!localere.MWl.isEmpty())
                {
                  i = 1;
                  j = 1;
                  k = i;
                  if (j != 0) {
                    break label164;
                  }
                }
              }
            }
          }
        }
      }
    }
    label164:
    label187:
    for (;;)
    {
      break;
      i = 0;
      break label139;
      k = i;
      if (k != 0) {
        l.t(paramLong, 5);
      }
      AppMethodBeat.o(220592);
      return;
      j = 0;
      break label142;
    }
  }
  
  private static void k(cbo paramcbo)
  {
    AppMethodBeat.i(122251);
    c.cQa();
    if (c.cQd())
    {
      Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, reportSession Detail true");
      e.f(paramcbo);
    }
    f.f(paramcbo);
    AppMethodBeat.o(122251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.j
 * JD-Core Version:    0.7.0.1
 */