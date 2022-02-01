package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ae;
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
  public static void a(bot parambot, bow parambow, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(parambot.Hck, new Comparator() {});
    Object localObject1 = c(parambot);
    Object localObject2 = parambow.Hco.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cie)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((cie)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((bou)localList.get(0)).startTime = ((cie)localObject3).startTime;
      }
    }
    localObject2 = parambow.Hcq.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (cia)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((cia)localObject3).duQ + "_" + ((cia)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((bou)localList.get(0)).startTime = ((cia)localObject3).startTime;
      }
    }
    int k = parambot.Hck.size();
    if (k > 0)
    {
      localObject1 = (bou)parambot.Hck.getFirst();
      if (localObject1 != null) {
        ((bou)localObject1).startTime = parambow.Hcm;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (bou)parambot.Hck.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (bou)parambot.Hck.get(i + 1);
        if ((localObject2 != null) && (((bou)localObject1).duration == 0L))
        {
          l1 = ((bou)localObject2).startTime - ((bou)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((bou)localObject1).duration = l1;
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
        localObject1 = (bou)parambot.Hck.get(i);
        if ((localObject1 == null) || (((bou)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((bou)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      parambow.Hcn = (parambow.Hcm + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        parambot = (bou)parambot.Hck.getLast();
        if (parambot != null)
        {
          long l3 = parambow.Hcn - parambot.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          parambot.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(bow parambow, bou parambou)
  {
    AppMethodBeat.i(122256);
    ae.i("HABBYGE-MALI.HellSessionReportUtil", "adjustSession");
    Object localObject4 = null;
    Object localObject5 = parambow.Hco.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (cie)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((cie)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((cie)localObject2).endTime <= localObject1.endTime) {
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
      Iterator localIterator = parambow.Hcq.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (cia)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((cia)localObject3).startTime < ((cia)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((cia)localObject3).endTime <= ((cia)localObject2).endTime) {
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
          if (((cia)localObject5).duQ.equals(parambou.duQ))
          {
            i = j;
            if (((cia)localObject5).startTime == parambou.startTime) {
              i = 1;
            }
          }
          ((cia)localObject5).startTime = parambow.Hcm;
          if (i != 0)
          {
            ae.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
            parambou.startTime = ((cia)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((cia)localObject2).endTime = parambow.Hcn;
          AppMethodBeat.o(122256);
          return;
          ae.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((cia)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((cia)localObject5).duQ.equals(parambou.duQ))
            {
              i = j;
              if (((cia)localObject5).startTime == parambou.startTime) {
                i = 1;
              }
            }
            ((cia)localObject5).startTime = parambow.Hcm;
            if (i != 0)
            {
              ae.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
              parambou.startTime = ((cia)localObject5).startTime;
            }
            else
            {
              ae.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = parambow.Hcm;
          }
        }
        if ((localObject2 != null) && (((cia)localObject2).endTime > localObject1.endTime))
        {
          ((cia)localObject2).endTime = parambow.Hcn;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = parambow.Hcn;
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
  
  static void a(JSONArray paramJSONArray, aur paramaur, long paramLong)
  {
    AppMethodBeat.i(196156);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramaur.GLC.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bov)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bov)localObject2).kNn))) {
        localArrayList.add(((bov)localObject2).kNn);
      }
    }
    try
    {
      localObject2 = paramaur.GLC.iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbov = (bov)((Iterator)localObject2).next();
      } while (localbov == null);
      localJSONObject = new JSONObject();
      if (localbov.dGe != null) {
        break label259;
      }
      localObject1 = "";
      label137:
      localJSONObject.put("dataPath", localObject1);
      if (localbov.value != null) {
        break label269;
      }
      localObject1 = "";
      label159:
      localJSONObject.put("value", localObject1);
      if (!TextUtils.isEmpty(localbov.kNn)) {
        break label279;
      }
    }
    catch (JSONException paramaur)
    {
      for (;;)
      {
        bov localbov;
        JSONObject localJSONObject;
        long l;
        ae.printErrStackTrace("HABBYGE-MALI.HellSessionReportUtil", paramaur, "handleFuzzyPathDetailParams: %s", new Object[] { paramaur.getMessage() });
        if (paramJSONArray.length() > 0) {}
        for (int i = 0;; i = 1)
        {
          l.w(paramLong, i);
          AppMethodBeat.o(196156);
          return;
        }
      }
    }
    l = paramaur.startTime;
    i += 1;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.v(l, i);
    if (!localArrayList.contains(localObject1))
    {
      localArrayList.add(localObject1);
      for (;;)
      {
        localJSONObject.put("businessId", localObject1);
        ae.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
        paramJSONArray.put(localJSONObject);
        break;
        label259:
        localObject1 = localbov.dGe;
        break label137;
        label269:
        localObject1 = localbov.value;
        break label159;
        label279:
        localObject1 = localbov.kNn;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, bou parambou, long paramLong)
  {
    AppMethodBeat.i(196157);
    if (parambou.GLD.isEmpty())
    {
      as(parambou.duQ, paramLong);
      AppMethodBeat.o(196157);
      return;
    }
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = parambou.GLD.iterator();
    while (localIterator1.hasNext())
    {
      dwx localdwx = (dwx)localIterator1.next();
      if ((localdwx != null) && (!localdwx.Ics))
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", localdwx.Icn);
        localJSONObject1.put("type", localdwx.type);
        localJSONObject1.put("action", localdwx.duP);
        localJSONObject1.put("timestamp", localdwx.timestamp);
        if (!localdwx.GbV.isEmpty())
        {
          JSONArray localJSONArray2 = new JSONArray();
          Iterator localIterator2 = localdwx.GbV.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = (oh)localIterator2.next();
            if ((localObject != null) && (((oh)localObject).GbU == paramLong))
            {
              localObject = ((oh)localObject).GbV.iterator();
              while (((Iterator)localObject).hasNext())
              {
                bov localbov = (bov)((Iterator)localObject).next();
                if ((localbov != null) && (localbov.dGe != null) && (a(paramLong, localbov.dGe, localdwx)))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localbov.dGe);
                  localJSONObject2.put("value", localbov.value);
                  localJSONArray2.put(localJSONObject2);
                }
              }
            }
          }
          if (localJSONArray2.length() > 0)
          {
            localJSONObject1.put("businessParam", localJSONArray2);
            l.w(paramLong, 4);
          }
        }
        for (;;)
        {
          localJSONArray1.put(localJSONObject1);
          break;
          l.w(paramLong, 5);
          continue;
          g(localdwx.Icn, parambou.duQ, paramLong);
        }
      }
    }
    if (localJSONArray1.length() > 0) {}
    for (int i = 2;; i = 3)
    {
      l.w(paramLong, i);
      paramJSONObject.put("viewOp", localJSONArray1);
      AppMethodBeat.o(196157);
      return;
    }
  }
  
  static void a(JSONObject paramJSONObject, bou parambou, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(196159);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = parambou.Hcl;; localObject1 = parambou.GLC)
    {
      localJSONArray = new JSONArray();
      if (!((List)localObject1).isEmpty()) {
        break;
      }
      paramJSONObject.put("businessParam", localJSONArray);
      d(parambou.duQ, paramBoolean, paramLong);
      AppMethodBeat.o(196159);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (bov)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bov)localObject2).kNn))) {
        localArrayList.add(((bov)localObject2).kNn);
      }
    }
    int i = 0;
    localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      bov localbov = (bov)localIterator.next();
      if (localbov != null)
      {
        localObject2 = new JSONObject();
        if (localbov.dGe == null)
        {
          localObject1 = "";
          label202:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localbov.value != null) {
            break label343;
          }
          localObject1 = "";
          label224:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localbov.kNn)) {
            break label353;
          }
          int j;
          do
          {
            long l = parambou.startTime;
            j = i + 1;
            localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.v(l, j);
            i = j;
          } while (localArrayList.contains(localObject1));
          localArrayList.add(localObject1);
          i = j;
        }
        for (;;)
        {
          ((JSONObject)localObject2).put("businessId", localObject1);
          ae.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
          localJSONArray.put(localObject2);
          break;
          localObject1 = localbov.dGe;
          break label202;
          label343:
          localObject1 = localbov.value;
          break label224;
          label353:
          localObject1 = localbov.kNn;
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
      l.w(paramLong, i);
      paramJSONObject.put("businessParam", localJSONArray);
      AppMethodBeat.o(196159);
      return;
    }
  }
  
  private static boolean a(long paramLong, String paramString, dwx paramdwx)
  {
    AppMethodBeat.i(196158);
    paramdwx = paramdwx.Icr.iterator();
    boolean bool = false;
    for (;;)
    {
      if (!paramdwx.hasNext()) {
        break label107;
      }
      Object localObject = (btk)paramdwx.next();
      if ((localObject != null) && (((btk)localObject).GbU == paramLong))
      {
        localObject = ((btk)localObject).HgK.iterator();
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
    AppMethodBeat.o(196158);
    return bool;
  }
  
  static void as(String paramString, long paramLong)
  {
    AppMethodBeat.i(196160);
    d.crw();
    Object localObject = d.vq(paramLong);
    int i;
    label88:
    int j;
    if (localObject != null)
    {
      localObject = ((dcg)localObject).HKI.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          dcc localdcc = (dcc)((Iterator)localObject).next();
          if (localdcc != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(localdcc.duQ))) {
              break label123;
            }
            if (!localdcc.HKD.isEmpty())
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
        l.w(paramLong, 3);
      }
      AppMethodBeat.o(196160);
      return;
    }
  }
  
  static Map<String, List<bou>> c(bot parambot)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambot.Hck.iterator();
    while (localIterator.hasNext())
    {
      bou localbou = (bou)localIterator.next();
      if (localbou != null)
      {
        if ((localbou.dAa != null) && (!localbou.dAa.isEmpty()))
        {
          if (localHashMap.containsKey(localbou.dAa))
          {
            List localList = (List)localHashMap.get(localbou.dAa);
            parambot = localList;
            if (localList != null) {}
          }
          for (parambot = new ArrayList();; parambot = new ArrayList())
          {
            parambot.add(localbou);
            localHashMap.put(localbou.dAa, parambot);
            break;
          }
        }
        parambot = new ArrayList();
        parambot.add(localbou);
        localHashMap.put(localbou.duQ + "_" + localbou.startTime, parambot);
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<bou>> d(bot parambot)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambot.Hck.iterator();
    while (localIterator.hasNext())
    {
      bou localbou = (bou)localIterator.next();
      if (localbou != null)
      {
        if ((localbou.dAa != null) && (!localbou.dAa.isEmpty()))
        {
          if (localHashMap.containsKey(localbou.dAa))
          {
            List localList = (List)localHashMap.get(localbou.dAa);
            parambot = localList;
            if (localList != null) {}
          }
          for (parambot = new ArrayList();; parambot = new ArrayList())
          {
            parambot.add(localbou);
            localHashMap.put(localbou.dAa, parambot);
            break;
          }
        }
        if (!localHashMap.containsKey(localbou.duQ))
        {
          parambot = new ArrayList();
          parambot.add(localbou);
          localHashMap.put(localbou.duQ, parambot);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(bow parambow, bot parambot, cie paramcie)
  {
    AppMethodBeat.i(177407);
    ae.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, realReport");
    k.a(parambow, parambot);
    k(parambow);
    e(parambow, parambot, paramcie);
    a.f(parambow);
    AppMethodBeat.o(177407);
  }
  
  static void d(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(196162);
    if (paramBoolean)
    {
      AppMethodBeat.o(196162);
      return;
    }
    d.crw();
    Object localObject = d.vq(paramLong);
    int i;
    label101:
    int j;
    if (localObject != null)
    {
      localObject = ((dcg)localObject).HKI.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          dcc localdcc = (dcc)((Iterator)localObject).next();
          if (localdcc != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(localdcc.duQ))) {
              break label140;
            }
            if (!localdcc.HKC.isEmpty())
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
        l.w(paramLong, 1);
      }
      AppMethodBeat.o(196162);
      return;
    }
  }
  
  private static bot e(bot parambot)
  {
    AppMethodBeat.i(122257);
    bot localbot = new bot();
    parambot = parambot.Hck.iterator();
    while (parambot.hasNext())
    {
      bou localbou1 = (bou)parambot.next();
      bou localbou2 = new bou();
      localbou2.dAa = localbou1.dAa;
      localbou2.duQ = localbou1.duQ;
      localbou2.aHQ = localbou1.aHQ;
      localbou2.startTime = localbou1.startTime;
      localbou2.duration = localbou1.duration;
      localbou2.count = localbou1.count;
      localbot.Hck.add(localbou2);
    }
    AppMethodBeat.o(122257);
    return localbot;
  }
  
  private static void e(bow parambow, bot parambot, cie paramcie)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA;
    localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.cqT();
    g.a(parambow, parambot, (aup)localObject, paramcie);
    h.a(parambow, e(parambot), (aup)localObject, paramcie);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.k.crU();
    parambow = com.tencent.mm.plugin.expt.hellhound.a.d.a.rgA;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.cqS();
    AppMethodBeat.o(177408);
  }
  
  static void g(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(196161);
    d.crw();
    Object localObject1 = d.vq(paramLong);
    int i;
    label139:
    int j;
    label142:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((dcg)localObject1).HKI.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (dcc)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (!paramString2.equals(com.tencent.mm.plugin.expt.hellhound.core.b.aer(((dcc)localObject2).duQ))) {
            break label187;
          }
          localObject2 = ((dcc)localObject2).HKD.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              dwy localdwy = (dwy)((Iterator)localObject2).next();
              if ((localdwy != null) && (paramString1.equals(localdwy.Icn))) {
                if (!localdwy.HKC.isEmpty())
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
        l.w(paramLong, 5);
      }
      AppMethodBeat.o(196161);
      return;
      j = 0;
      break label142;
    }
  }
  
  private static void k(bow parambow)
  {
    AppMethodBeat.i(122251);
    c.crs();
    if (c.crv())
    {
      ae.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, reportSession Detail true");
      e.f(parambow);
    }
    f.f(parambow);
    AppMethodBeat.o(122251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.j
 * JD-Core Version:    0.7.0.1
 */