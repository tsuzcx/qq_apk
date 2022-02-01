package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbp;
import com.tencent.mm.protocal.protobuf.oz;
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
  public static void a(cjo paramcjo, cjr paramcjr, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(paramcjo.Trb, new Comparator() {});
    Object localObject1 = c(paramcjo);
    Object localObject2 = paramcjr.Trf.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dhx)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((dhx)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((cjp)localList.get(0)).startTime = ((dhx)localObject3).startTime;
      }
    }
    localObject2 = paramcjr.Trg.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (dht)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((dht)localObject3).fFe + "_" + ((dht)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((cjp)localList.get(0)).startTime = ((dht)localObject3).startTime;
      }
    }
    int k = paramcjo.Trb.size();
    if (k > 0)
    {
      localObject1 = (cjp)paramcjo.Trb.getFirst();
      if (localObject1 != null) {
        ((cjp)localObject1).startTime = paramcjr.Trd;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (cjp)paramcjo.Trb.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (cjp)paramcjo.Trb.get(i + 1);
        if ((localObject2 != null) && (((cjp)localObject1).duration == 0L))
        {
          l1 = ((cjp)localObject2).startTime - ((cjp)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((cjp)localObject1).duration = l1;
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
        localObject1 = (cjp)paramcjo.Trb.get(i);
        if ((localObject1 == null) || (((cjp)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((cjp)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      paramcjr.Tre = (paramcjr.Trd + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        paramcjo = (cjp)paramcjo.Trb.getLast();
        if (paramcjo != null)
        {
          long l3 = paramcjr.Tre - paramcjo.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          paramcjo.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(cjr paramcjr, cjp paramcjp)
  {
    AppMethodBeat.i(122256);
    Log.i("HABBYGE-MALI.HellSessionReportUtil", "adjustSession");
    Object localObject4 = null;
    Object localObject5 = paramcjr.Trf.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (dhx)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((dhx)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((dhx)localObject2).endTime <= localObject1.endTime) {
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
      Iterator localIterator = paramcjr.Trg.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (dht)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((dht)localObject3).startTime < ((dht)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((dht)localObject3).endTime <= ((dht)localObject2).endTime) {
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
          if (((dht)localObject5).fFe.equals(paramcjp.fFe))
          {
            i = j;
            if (((dht)localObject5).startTime == paramcjp.startTime) {
              i = 1;
            }
          }
          ((dht)localObject5).startTime = paramcjr.Trd;
          if (i != 0)
          {
            Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
            paramcjp.startTime = ((dht)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((dht)localObject2).endTime = paramcjr.Tre;
          AppMethodBeat.o(122256);
          return;
          Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((dht)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((dht)localObject5).fFe.equals(paramcjp.fFe))
            {
              i = j;
              if (((dht)localObject5).startTime == paramcjp.startTime) {
                i = 1;
              }
            }
            ((dht)localObject5).startTime = paramcjr.Trd;
            if (i != 0)
            {
              Log.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
              paramcjp.startTime = ((dht)localObject5).startTime;
            }
            else
            {
              Log.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = paramcjr.Trd;
          }
        }
        if ((localObject2 != null) && (((dht)localObject2).endTime > localObject1.endTime))
        {
          ((dht)localObject2).endTime = paramcjr.Tre;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = paramcjr.Tre;
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
  
  static void a(JSONArray paramJSONArray, bnb parambnb, long paramLong)
  {
    AppMethodBeat.i(252833);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = parambnb.SXU.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cjq)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((cjq)localObject2).businessId))) {
        localArrayList.add(((cjq)localObject2).businessId);
      }
    }
    try
    {
      localObject2 = parambnb.SXU.iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localcjq = (cjq)((Iterator)localObject2).next();
      } while (localcjq == null);
      localJSONObject = new JSONObject();
      if (localcjq.dataPath != null) {
        break label259;
      }
      localObject1 = "";
      label137:
      localJSONObject.put("dataPath", localObject1);
      if (localcjq.value != null) {
        break label269;
      }
      localObject1 = "";
      label159:
      localJSONObject.put("value", localObject1);
      if (!TextUtils.isEmpty(localcjq.businessId)) {
        break label279;
      }
    }
    catch (JSONException parambnb)
    {
      for (;;)
      {
        cjq localcjq;
        JSONObject localJSONObject;
        long l;
        Log.printErrStackTrace("HABBYGE-MALI.HellSessionReportUtil", parambnb, "handleFuzzyPathDetailParams: %s", new Object[] { parambnb.getMessage() });
        if (paramJSONArray.length() > 0) {}
        for (int i = 0;; i = 1)
        {
          l.v(paramLong, i);
          AppMethodBeat.o(252833);
          return;
        }
      }
    }
    l = parambnb.startTime;
    i += 1;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.u(l, i);
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
        localObject1 = localcjq.dataPath;
        break label137;
        label269:
        localObject1 = localcjq.value;
        break label159;
        label279:
        localObject1 = localcjq.businessId;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, cjp paramcjp, long paramLong)
  {
    AppMethodBeat.i(252835);
    if (paramcjp.SXV.isEmpty())
    {
      as(paramcjp.fFe, paramLong);
      AppMethodBeat.o(252835);
      return;
    }
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = paramcjp.SXV.iterator();
    while (localIterator1.hasNext())
    {
      fbo localfbo = (fbo)localIterator1.next();
      if ((localfbo != null) && (!localfbo.UBM))
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", localfbo.UBI);
        localJSONObject1.put("type", localfbo.type);
        localJSONObject1.put("action", localfbo.eventId);
        localJSONObject1.put("timestamp", localfbo.timestamp);
        if (!localfbo.RXm.isEmpty())
        {
          JSONArray localJSONArray2 = new JSONArray();
          Iterator localIterator2 = localfbo.RXm.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = (oz)localIterator2.next();
            if ((localObject != null) && (((oz)localObject).RXl == paramLong))
            {
              localObject = ((oz)localObject).RXm.iterator();
              while (((Iterator)localObject).hasNext())
              {
                cjq localcjq = (cjq)((Iterator)localObject).next();
                if ((localcjq != null) && (localcjq.dataPath != null) && (a(paramLong, localcjq.dataPath, localfbo)))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localcjq.dataPath);
                  localJSONObject2.put("value", localcjq.value);
                  localJSONArray2.put(localJSONObject2);
                }
              }
            }
          }
          if (localJSONArray2.length() > 0)
          {
            localJSONObject1.put("businessParam", localJSONArray2);
            l.v(paramLong, 4);
          }
        }
        for (;;)
        {
          localJSONArray1.put(localJSONObject1);
          break;
          l.v(paramLong, 5);
          continue;
          k(localfbo.UBI, paramcjp.fFe, paramLong);
        }
      }
    }
    if (localJSONArray1.length() > 0) {}
    for (int i = 2;; i = 3)
    {
      l.v(paramLong, i);
      paramJSONObject.put("viewOp", localJSONArray1);
      AppMethodBeat.o(252835);
      return;
    }
  }
  
  static void a(JSONObject paramJSONObject, cjp paramcjp, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(252837);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = paramcjp.Trc;; localObject1 = paramcjp.SXU)
    {
      localJSONArray = new JSONArray();
      if (!((List)localObject1).isEmpty()) {
        break;
      }
      paramJSONObject.put("businessParam", localJSONArray);
      d(paramcjp.fFe, paramBoolean, paramLong);
      AppMethodBeat.o(252837);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (cjq)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((cjq)localObject2).businessId))) {
        localArrayList.add(((cjq)localObject2).businessId);
      }
    }
    int i = 0;
    localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      cjq localcjq = (cjq)localIterator.next();
      if (localcjq != null)
      {
        localObject2 = new JSONObject();
        if (localcjq.dataPath == null)
        {
          localObject1 = "";
          label202:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localcjq.value != null) {
            break label343;
          }
          localObject1 = "";
          label224:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localcjq.businessId)) {
            break label353;
          }
          int j;
          do
          {
            long l = paramcjp.startTime;
            j = i + 1;
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.u(l, j);
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
          localObject1 = localcjq.dataPath;
          break label202;
          label343:
          localObject1 = localcjq.value;
          break label224;
          label353:
          localObject1 = localcjq.businessId;
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
      l.v(paramLong, i);
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(252837);
      return;
    }
  }
  
  private static boolean a(long paramLong, String paramString, fbo paramfbo)
  {
    AppMethodBeat.i(252836);
    paramfbo = paramfbo.UBL.iterator();
    boolean bool = false;
    for (;;)
    {
      if (!paramfbo.hasNext()) {
        break label107;
      }
      Object localObject = (coz)paramfbo.next();
      if ((localObject != null) && (((coz)localObject).RXl == paramLong))
      {
        localObject = ((coz)localObject).TwJ.iterator();
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
    AppMethodBeat.o(252836);
    return bool;
  }
  
  static void as(String paramString, long paramLong)
  {
    AppMethodBeat.i(252838);
    d.deY();
    Object localObject = d.JI(paramLong);
    int i;
    label88:
    int j;
    if (localObject != null)
    {
      localObject = ((efm)localObject).UiM.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          efi localefi = (efi)((Iterator)localObject).next();
          if (localefi != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(localefi.fFe))) {
              break label123;
            }
            if (!localefi.UiH.isEmpty())
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
        l.v(paramLong, 3);
      }
      AppMethodBeat.o(252838);
      return;
    }
  }
  
  static Map<String, List<cjp>> c(cjo paramcjo)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramcjo.Trb.iterator();
    while (localIterator.hasNext())
    {
      cjp localcjp = (cjp)localIterator.next();
      if (localcjp != null)
      {
        if ((localcjp.fLj != null) && (!localcjp.fLj.isEmpty()))
        {
          if (localHashMap.containsKey(localcjp.fLj))
          {
            List localList = (List)localHashMap.get(localcjp.fLj);
            paramcjo = localList;
            if (localList != null) {}
          }
          for (paramcjo = new ArrayList();; paramcjo = new ArrayList())
          {
            paramcjo.add(localcjp);
            localHashMap.put(localcjp.fLj, paramcjo);
            break;
          }
        }
        paramcjo = new ArrayList();
        paramcjo.add(localcjp);
        localHashMap.put(localcjp.fFe + "_" + localcjp.startTime, paramcjo);
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<cjp>> d(cjo paramcjo)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramcjo.Trb.iterator();
    while (localIterator.hasNext())
    {
      cjp localcjp = (cjp)localIterator.next();
      if (localcjp != null)
      {
        if ((localcjp.fLj != null) && (!localcjp.fLj.isEmpty()))
        {
          if (localHashMap.containsKey(localcjp.fLj))
          {
            List localList = (List)localHashMap.get(localcjp.fLj);
            paramcjo = localList;
            if (localList != null) {}
          }
          for (paramcjo = new ArrayList();; paramcjo = new ArrayList())
          {
            paramcjo.add(localcjp);
            localHashMap.put(localcjp.fLj, paramcjo);
            break;
          }
        }
        if (!localHashMap.containsKey(localcjp.fFe))
        {
          paramcjo = new ArrayList();
          paramcjo.add(localcjp);
          localHashMap.put(localcjp.fFe, paramcjo);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(cjr paramcjr, cjo paramcjo, dhx paramdhx)
  {
    AppMethodBeat.i(177407);
    Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, realReport");
    k.a(paramcjr, paramcjo);
    k(paramcjr);
    e(paramcjr, paramcjo, paramdhx);
    a.f(paramcjr);
    AppMethodBeat.o(177407);
  }
  
  static void d(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(252840);
    if (paramBoolean)
    {
      AppMethodBeat.o(252840);
      return;
    }
    d.deY();
    Object localObject = d.JI(paramLong);
    int i;
    label101:
    int j;
    if (localObject != null)
    {
      localObject = ((efm)localObject).UiM.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          efi localefi = (efi)((Iterator)localObject).next();
          if (localefi != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(localefi.fFe))) {
              break label140;
            }
            if (!localefi.UiG.isEmpty())
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
        l.v(paramLong, 1);
      }
      AppMethodBeat.o(252840);
      return;
    }
  }
  
  private static cjo e(cjo paramcjo)
  {
    AppMethodBeat.i(122257);
    cjo localcjo = new cjo();
    paramcjo = paramcjo.Trb.iterator();
    while (paramcjo.hasNext())
    {
      cjp localcjp1 = (cjp)paramcjo.next();
      cjp localcjp2 = new cjp();
      localcjp2.fLj = localcjp1.fLj;
      localcjp2.fFe = localcjp1.fFe;
      localcjp2.aNf = localcjp1.aNf;
      localcjp2.startTime = localcjp1.startTime;
      localcjp2.duration = localcjp1.duration;
      localcjp2.count = localcjp1.count;
      localcjo.Trb.add(localcjp2);
    }
    AppMethodBeat.o(122257);
    return localcjo;
  }
  
  private static void e(cjr paramcjr, cjo paramcjo, dhx paramdhx)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR;
    localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.dev();
    g.a(paramcjr, paramcjo, (bmz)localObject, paramdhx);
    h.a(paramcjr, e(paramcjo), (bmz)localObject, paramdhx);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.k.dfw();
    paramcjr = com.tencent.mm.plugin.expt.hellhound.a.d.a.wnR;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.deu();
    AppMethodBeat.o(177408);
  }
  
  private static void k(cjr paramcjr)
  {
    AppMethodBeat.i(122251);
    c.deU();
    if (c.deX())
    {
      Log.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, reportSession Detail true");
      e.f(paramcjr);
    }
    f.f(paramcjr);
    AppMethodBeat.o(122251);
  }
  
  static void k(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(252839);
    d.deY();
    Object localObject1 = d.JI(paramLong);
    int i;
    label139:
    int j;
    label142:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((efm)localObject1).UiM.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (efi)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (!paramString2.equals(com.tencent.mm.plugin.expt.hellhound.core.b.awD(((efi)localObject2).fFe))) {
            break label187;
          }
          localObject2 = ((efi)localObject2).UiH.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              fbp localfbp = (fbp)((Iterator)localObject2).next();
              if ((localfbp != null) && (paramString1.equals(localfbp.UBI))) {
                if (!localfbp.UiG.isEmpty())
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
        l.v(paramLong, 5);
      }
      AppMethodBeat.o(252839);
      return;
      j = 0;
      break label142;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.j
 * JD-Core Version:    0.7.0.1
 */