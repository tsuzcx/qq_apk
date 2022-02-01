package com.tencent.mm.plugin.expt.hellhound.ext.session.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.c;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.d;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.protocal.protobuf.fxz;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.protocal.protobuf.qi;
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
  public static void a(czt paramczt, czw paramczw, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(paramczt.aaFj, new Comparator() {});
    Object localObject1 = c(paramczt);
    Object localObject2 = paramczw.aaFn.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (eah)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((eah)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((czu)localList.get(0)).startTime = ((eah)localObject3).startTime;
      }
    }
    localObject2 = paramczw.aaFo.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ead)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((ead)localObject3).hJW + "_" + ((ead)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((czu)localList.get(0)).startTime = ((ead)localObject3).startTime;
      }
    }
    int k = paramczt.aaFj.size();
    if (k > 0)
    {
      localObject1 = (czu)paramczt.aaFj.getFirst();
      if (localObject1 != null) {
        ((czu)localObject1).startTime = paramczw.aaFl;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (czu)paramczt.aaFj.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (czu)paramczt.aaFj.get(i + 1);
        if ((localObject2 != null) && (((czu)localObject1).duration == 0L))
        {
          l1 = ((czu)localObject2).startTime - ((czu)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((czu)localObject1).duration = l1;
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
        localObject1 = (czu)paramczt.aaFj.get(i);
        if ((localObject1 == null) || (((czu)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((czu)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      paramczw.aaFm = (paramczw.aaFl + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        paramczt = (czu)paramczt.aaFj.getLast();
        if (paramczt != null)
        {
          long l3 = paramczw.aaFm - paramczt.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          paramczt.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(czw paramczw, czu paramczu)
  {
    AppMethodBeat.i(122256);
    Log.i("HABBYGE-MALI.HellSessionReportUtil", "adjustSession");
    Object localObject4 = null;
    Object localObject5 = paramczw.aaFn.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (eah)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((eah)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((eah)localObject2).endTime <= localObject1.endTime) {
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
      Iterator localIterator = paramczw.aaFo.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (ead)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((ead)localObject3).startTime < ((ead)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((ead)localObject3).endTime <= ((ead)localObject2).endTime) {
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
          if (((ead)localObject5).hJW.equals(paramczu.hJW))
          {
            i = j;
            if (((ead)localObject5).startTime == paramczu.startTime) {
              i = 1;
            }
          }
          ((ead)localObject5).startTime = paramczw.aaFl;
          if (i != 0)
          {
            Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
            paramczu.startTime = ((ead)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((ead)localObject2).endTime = paramczw.aaFm;
          AppMethodBeat.o(122256);
          return;
          Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((ead)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((ead)localObject5).hJW.equals(paramczu.hJW))
            {
              i = j;
              if (((ead)localObject5).startTime == paramczu.startTime) {
                i = 1;
              }
            }
            ((ead)localObject5).startTime = paramczw.aaFl;
            if (i != 0)
            {
              Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
              paramczu.startTime = ((ead)localObject5).startTime;
            }
            else
            {
              Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = paramczw.aaFl;
          }
        }
        if ((localObject2 != null) && (((ead)localObject2).endTime > localObject1.endTime))
        {
          ((ead)localObject2).endTime = paramczw.aaFm;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = paramczw.aaFm;
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
  
  static void a(JSONArray paramJSONArray, cav paramcav, long paramLong)
  {
    AppMethodBeat.i(300243);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramcav.aajQ.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (czv)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((czv)localObject2).businessId))) {
        localArrayList.add(((czv)localObject2).businessId);
      }
    }
    try
    {
      localObject2 = paramcav.aajQ.iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localczv = (czv)((Iterator)localObject2).next();
      } while (localczv == null);
      localJSONObject = new JSONObject();
      if (localczv.dataPath != null) {
        break label259;
      }
      localObject1 = "";
      label137:
      localJSONObject.put("dataPath", localObject1);
      if (localczv.value != null) {
        break label269;
      }
      localObject1 = "";
      label159:
      localJSONObject.put("value", localObject1);
      if (!TextUtils.isEmpty(localczv.businessId)) {
        break label279;
      }
    }
    catch (JSONException paramcav)
    {
      for (;;)
      {
        czv localczv;
        JSONObject localJSONObject;
        long l;
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportUtil", paramcav, "handleFuzzyPathDetailParams: %s", new Object[] { paramcav.getMessage() });
        if (paramJSONArray.length() > 0) {}
        for (int i = 0;; i = 1)
        {
          l.F(paramLong, i);
          AppMethodBeat.o(300243);
          return;
        }
      }
    }
    l = paramcav.startTime;
    i += 1;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.E(l, i);
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
        localObject1 = localczv.dataPath;
        break label137;
        label269:
        localObject1 = localczv.value;
        break label159;
        label279:
        localObject1 = localczv.businessId;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, czu paramczu, long paramLong)
  {
    AppMethodBeat.i(300249);
    if (paramczu.aajR.isEmpty())
    {
      aA(paramczu.hJW, paramLong);
      AppMethodBeat.o(300249);
      return;
    }
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = paramczu.aajR.iterator();
    while (localIterator1.hasNext())
    {
      fxz localfxz = (fxz)localIterator1.next();
      if ((localfxz != null) && (!localfxz.abVV))
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", localfxz.abVR);
        localJSONObject1.put("type", localfxz.type);
        localJSONObject1.put("action", localfxz.eventId);
        localJSONObject1.put("timestamp", localfxz.timestamp);
        if (!localfxz.YVe.isEmpty())
        {
          JSONArray localJSONArray2 = new JSONArray();
          Iterator localIterator2 = localfxz.YVe.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = (qi)localIterator2.next();
            if ((localObject != null) && (((qi)localObject).YVd == paramLong))
            {
              localObject = ((qi)localObject).YVe.iterator();
              while (((Iterator)localObject).hasNext())
              {
                czv localczv = (czv)((Iterator)localObject).next();
                if ((localczv != null) && (localczv.dataPath != null) && (a(paramLong, localczv.dataPath, localfxz)))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localczv.dataPath);
                  localJSONObject2.put("value", localczv.value);
                  localJSONArray2.put(localJSONObject2);
                }
              }
            }
          }
          if (localJSONArray2.length() > 0)
          {
            localJSONObject1.put("businessParam", localJSONArray2);
            l.F(paramLong, 4);
          }
        }
        for (;;)
        {
          localJSONArray1.put(localJSONObject1);
          break;
          l.F(paramLong, 5);
          continue;
          k(localfxz.abVR, paramczu.hJW, paramLong);
        }
      }
    }
    if (localJSONArray1.length() > 0) {}
    for (int i = 2;; i = 3)
    {
      l.F(paramLong, i);
      paramJSONObject.put("viewOp", localJSONArray1);
      AppMethodBeat.o(300249);
      return;
    }
  }
  
  static void a(JSONObject paramJSONObject, czu paramczu, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(300267);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = paramczu.aaFk;; localObject1 = paramczu.aajQ)
    {
      localJSONArray = new JSONArray();
      if (!((List)localObject1).isEmpty()) {
        break;
      }
      paramJSONObject.put("businessParam", localJSONArray);
      d(paramczu.hJW, paramBoolean, paramLong);
      AppMethodBeat.o(300267);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (czv)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((czv)localObject2).businessId))) {
        localArrayList.add(((czv)localObject2).businessId);
      }
    }
    int i = 0;
    localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      czv localczv = (czv)localIterator.next();
      if (localczv != null)
      {
        localObject2 = new JSONObject();
        if (localczv.dataPath == null)
        {
          localObject1 = "";
          label202:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localczv.value != null) {
            break label343;
          }
          localObject1 = "";
          label224:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localczv.businessId)) {
            break label353;
          }
          int j;
          do
          {
            long l = paramczu.startTime;
            j = i + 1;
            localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.E(l, j);
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
          localObject1 = localczv.dataPath;
          break label202;
          label343:
          localObject1 = localczv.value;
          break label224;
          label353:
          localObject1 = localczv.businessId;
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
      l.F(paramLong, i);
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(300267);
      return;
    }
  }
  
  private static boolean a(long paramLong, String paramString, fxz paramfxz)
  {
    AppMethodBeat.i(300258);
    paramfxz = paramfxz.abVU.iterator();
    boolean bool = false;
    for (;;)
    {
      if (!paramfxz.hasNext()) {
        break label107;
      }
      Object localObject = (dft)paramfxz.next();
      if ((localObject != null) && (((dft)localObject).YVd == paramLong))
      {
        localObject = ((dft)localObject).aaLq.iterator();
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
    AppMethodBeat.o(300258);
    return bool;
  }
  
  static void aA(String paramString, long paramLong)
  {
    AppMethodBeat.i(300275);
    d.dLN();
    Object localObject = d.mg(paramLong);
    int i;
    label88:
    int j;
    if (localObject != null)
    {
      localObject = ((ezf)localObject).abAl.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ezb localezb = (ezb)((Iterator)localObject).next();
          if (localezb != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localezb.hJW))) {
              break label123;
            }
            if (!localezb.abAg.isEmpty())
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
        l.F(paramLong, 3);
      }
      AppMethodBeat.o(300275);
      return;
    }
  }
  
  static Map<String, List<czu>> c(czt paramczt)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramczt.aaFj.iterator();
    while (localIterator.hasNext())
    {
      czu localczu = (czu)localIterator.next();
      if (localczu != null)
      {
        if ((localczu.hQR != null) && (!localczu.hQR.isEmpty()))
        {
          if (localHashMap.containsKey(localczu.hQR))
          {
            List localList = (List)localHashMap.get(localczu.hQR);
            paramczt = localList;
            if (localList != null) {}
          }
          for (paramczt = new ArrayList();; paramczt = new ArrayList())
          {
            paramczt.add(localczu);
            localHashMap.put(localczu.hQR, paramczt);
            break;
          }
        }
        paramczt = new ArrayList();
        paramczt.add(localczu);
        localHashMap.put(localczu.hJW + "_" + localczu.startTime, paramczt);
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<czu>> d(czt paramczt)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramczt.aaFj.iterator();
    while (localIterator.hasNext())
    {
      czu localczu = (czu)localIterator.next();
      if (localczu != null)
      {
        if ((localczu.hQR != null) && (!localczu.hQR.isEmpty()))
        {
          if (localHashMap.containsKey(localczu.hQR))
          {
            List localList = (List)localHashMap.get(localczu.hQR);
            paramczt = localList;
            if (localList != null) {}
          }
          for (paramczt = new ArrayList();; paramczt = new ArrayList())
          {
            paramczt.add(localczu);
            localHashMap.put(localczu.hQR, paramczt);
            break;
          }
        }
        if (!localHashMap.containsKey(localczu.hJW))
        {
          paramczt = new ArrayList();
          paramczt.add(localczu);
          localHashMap.put(localczu.hJW, paramczt);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(czw paramczw, czt paramczt, eah parameah)
  {
    AppMethodBeat.i(177407);
    Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, realReport");
    k.a(paramczw, paramczt);
    k(paramczw);
    e(paramczw, paramczt, parameah);
    a.f(paramczw);
    AppMethodBeat.o(177407);
  }
  
  static void d(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(300290);
    if (paramBoolean)
    {
      AppMethodBeat.o(300290);
      return;
    }
    d.dLN();
    Object localObject = d.mg(paramLong);
    int i;
    label101:
    int j;
    if (localObject != null)
    {
      localObject = ((ezf)localObject).abAl.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ezb localezb = (ezb)((Iterator)localObject).next();
          if (localezb != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localezb.hJW))) {
              break label140;
            }
            if (!localezb.abAf.isEmpty())
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
        l.F(paramLong, 1);
      }
      AppMethodBeat.o(300290);
      return;
    }
  }
  
  private static czt e(czt paramczt)
  {
    AppMethodBeat.i(122257);
    czt localczt = new czt();
    paramczt = paramczt.aaFj.iterator();
    while (paramczt.hasNext())
    {
      czu localczu1 = (czu)paramczt.next();
      czu localczu2 = new czu();
      localczu2.hQR = localczu1.hQR;
      localczu2.hJW = localczu1.hJW;
      localczu2.cHb = localczu1.cHb;
      localczu2.startTime = localczu1.startTime;
      localczu2.duration = localczu1.duration;
      localczu2.count = localczu1.count;
      localczt.aaFj.add(localczu2);
    }
    AppMethodBeat.o(122257);
    return localczt;
  }
  
  private static void e(czw paramczw, czt paramczt, eah parameah)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT;
    localObject = com.tencent.mm.plugin.expt.hellhound.ext.d.a.dLk();
    g.a(paramczw, paramczt, (cat)localObject, parameah);
    h.a(paramczw, e(paramczt), (cat)localObject, parameah);
    com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.dMk();
    paramczw = com.tencent.mm.plugin.expt.hellhound.ext.d.a.zJT;
    com.tencent.mm.plugin.expt.hellhound.ext.d.a.dLj();
    AppMethodBeat.o(177408);
  }
  
  private static void k(czw paramczw)
  {
    AppMethodBeat.i(122251);
    c.dLJ();
    if (c.dLM())
    {
      Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, reportSession Detail true");
      e.f(paramczw);
    }
    f.f(paramczw);
    AppMethodBeat.o(122251);
  }
  
  static void k(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(300284);
    d.dLN();
    Object localObject1 = d.mg(paramLong);
    int i;
    label139:
    int j;
    label142:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((ezf)localObject1).abAl.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ezb)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (!paramString2.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((ezb)localObject2).hJW))) {
            break label187;
          }
          localObject2 = ((ezb)localObject2).abAg.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              fya localfya = (fya)((Iterator)localObject2).next();
              if ((localfya != null) && (paramString1.equals(localfya.abVR))) {
                if (!localfya.abAf.isEmpty())
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
        l.F(paramLong, 5);
      }
      AppMethodBeat.o(300284);
      return;
      j = 0;
      break label142;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.e.j
 * JD-Core Version:    0.7.0.1
 */