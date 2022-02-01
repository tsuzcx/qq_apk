package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.d;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.of;
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
  public static void a(bob parambob, boe paramboe, boolean paramBoolean)
  {
    int j = 0;
    long l2 = 0L;
    AppMethodBeat.i(122253);
    Collections.sort(parambob.GII, new Comparator() {});
    Object localObject1 = c(parambob);
    Object localObject2 = paramboe.GIM.iterator();
    Object localObject3;
    List localList;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (chk)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((chk)localObject3).sessionId);
      if ((localList != null) && (!localList.isEmpty())) {
        ((boc)localList.get(0)).startTime = ((chk)localObject3).startTime;
      }
    }
    localObject2 = paramboe.GIO.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (chg)((Iterator)localObject2).next();
      localList = (List)((Map)localObject1).get(((chg)localObject3).dtL + "_" + ((chg)localObject3).startTime);
      if ((localList != null) && (!localList.isEmpty())) {
        ((boc)localList.get(0)).startTime = ((chg)localObject3).startTime;
      }
    }
    int k = parambob.GII.size();
    if (k > 0)
    {
      localObject1 = (boc)parambob.GII.getFirst();
      if (localObject1 != null) {
        ((boc)localObject1).startTime = paramboe.GIK;
      }
    }
    int i = 0;
    long l1;
    if (i < k)
    {
      localObject1 = (boc)parambob.GII.get(i);
      if (localObject1 != null)
      {
        if (i + 1 >= k) {
          break label371;
        }
        localObject2 = (boc)parambob.GII.get(i + 1);
        if ((localObject2 != null) && (((boc)localObject1).duration == 0L))
        {
          l1 = ((boc)localObject2).startTime - ((boc)localObject1).startTime;
          if (l1 <= 0L) {
            break label365;
          }
        }
      }
      for (;;)
      {
        ((boc)localObject1).duration = l1;
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
        localObject1 = (boc)parambob.GII.get(i);
        if ((localObject1 == null) || (((boc)localObject1).duration <= 0L)) {
          break label507;
        }
        l1 = ((boc)localObject1).duration + l1;
      }
    }
    label507:
    for (;;)
    {
      i += 1;
      break;
      paramboe.GIL = (paramboe.GIK + l1);
      AppMethodBeat.o(122253);
      return;
      if (k > 0)
      {
        parambob = (boc)parambob.GII.getLast();
        if (parambob != null)
        {
          long l3 = paramboe.GIL - parambob.startTime;
          l1 = l2;
          if (l3 > 0L) {
            l1 = l3;
          }
          parambob.duration = l1;
        }
      }
      AppMethodBeat.o(122253);
      return;
    }
  }
  
  public static void a(boe paramboe, boc paramboc)
  {
    AppMethodBeat.i(122256);
    ad.i("HABBYGE-MALI.HellSessionReportUtil", "adjustSession");
    Object localObject4 = null;
    Object localObject5 = paramboe.GIM.iterator();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = (chk)((Iterator)localObject5).next();
      if (localObject2 != null) {
        if (localObject4 == null)
        {
          localObject1 = localObject2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject4;
          if (((chk)localObject2).startTime < localObject4.startTime) {
            localObject3 = localObject2;
          }
          if (((chk)localObject2).endTime <= localObject1.endTime) {
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
      Iterator localIterator = paramboe.GIO.iterator();
      localObject2 = null;
      Object localObject6;
      while (localIterator.hasNext())
      {
        localObject3 = (chg)localIterator.next();
        if (localObject3 != null) {
          if (localObject5 == null)
          {
            localObject2 = localObject3;
            localObject5 = localObject3;
          }
          else
          {
            localObject6 = localObject5;
            if (((chg)localObject3).startTime < ((chg)localObject5).startTime) {
              localObject6 = localObject3;
            }
            if (((chg)localObject3).endTime <= ((chg)localObject2).endTime) {
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
          if (((chg)localObject5).dtL.equals(paramboc.dtL))
          {
            i = j;
            if (((chg)localObject5).startTime == paramboc.startTime) {
              i = 1;
            }
          }
          ((chg)localObject5).startTime = paramboe.GIK;
          if (i != 0)
          {
            ad.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
            paramboc.startTime = ((chg)localObject5).startTime;
          }
        }
        while (localObject1 == null)
        {
          if (localObject2 == null) {
            break label490;
          }
          ((chg)localObject2).endTime = paramboe.GIL;
          AppMethodBeat.o(122256);
          return;
          ad.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
          continue;
          if ((localObject5 != null) && (((chg)localObject5).startTime < localObject4.startTime))
          {
            j = 0;
            i = j;
            if (((chg)localObject5).dtL.equals(paramboc.dtL))
            {
              i = j;
              if (((chg)localObject5).startTime == paramboc.startTime) {
                i = 1;
              }
            }
            ((chg)localObject5).startTime = paramboe.GIK;
            if (i != 0)
            {
              ad.i("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page TRUE !!!");
              paramboc.startTime = ((chg)localObject5).startTime;
            }
            else
            {
              ad.e("HABBYGE-MALI.HellSessionReportUtil", " adjustSession same page FALSE !!!");
            }
          }
          else
          {
            localObject4.startTime = paramboe.GIK;
          }
        }
        if ((localObject2 != null) && (((chg)localObject2).endTime > localObject1.endTime))
        {
          ((chg)localObject2).endTime = paramboe.GIL;
          AppMethodBeat.o(122256);
          return;
        }
        localObject1.endTime = paramboe.GIL;
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
  
  static void a(JSONArray paramJSONArray, aub paramaub, long paramLong)
  {
    AppMethodBeat.i(210489);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramaub.Gse.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bod)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bod)localObject2).kJY))) {
        localArrayList.add(((bod)localObject2).kJY);
      }
    }
    try
    {
      localObject2 = paramaub.Gse.iterator();
      i = 0;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localbod = (bod)((Iterator)localObject2).next();
      } while (localbod == null);
      localJSONObject = new JSONObject();
      if (localbod.dEZ != null) {
        break label259;
      }
      localObject1 = "";
      label137:
      localJSONObject.put("dataPath", localObject1);
      if (localbod.value != null) {
        break label269;
      }
      localObject1 = "";
      label159:
      localJSONObject.put("value", localObject1);
      if (!TextUtils.isEmpty(localbod.kJY)) {
        break label279;
      }
    }
    catch (JSONException paramaub)
    {
      for (;;)
      {
        bod localbod;
        JSONObject localJSONObject;
        long l;
        ad.printErrStackTrace("HABBYGE-MALI.HellSessionReportUtil", paramaub, "handleFuzzyPathDetailParams: %s", new Object[] { paramaub.getMessage() });
        if (paramJSONArray.length() > 0) {}
        for (int i = 0;; i = 1)
        {
          l.w(paramLong, i);
          AppMethodBeat.o(210489);
          return;
        }
      }
    }
    l = paramaub.startTime;
    i += 1;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.v(l, i);
    if (!localArrayList.contains(localObject1))
    {
      localArrayList.add(localObject1);
      for (;;)
      {
        localJSONObject.put("businessId", localObject1);
        ad.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
        paramJSONArray.put(localJSONObject);
        break;
        label259:
        localObject1 = localbod.dEZ;
        break label137;
        label269:
        localObject1 = localbod.value;
        break label159;
        label279:
        localObject1 = localbod.kJY;
      }
    }
  }
  
  static void a(JSONObject paramJSONObject, boc paramboc, long paramLong)
  {
    AppMethodBeat.i(210490);
    if (paramboc.Gsf.isEmpty())
    {
      as(paramboc.dtL, paramLong);
      AppMethodBeat.o(210490);
      return;
    }
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator1 = paramboc.Gsf.iterator();
    while (localIterator1.hasNext())
    {
      dwc localdwc = (dwc)localIterator1.next();
      if ((localdwc != null) && (!localdwc.HIG))
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("viewId", localdwc.HIB);
        localJSONObject1.put("type", localdwc.type);
        localJSONObject1.put("action", localdwc.dtK);
        localJSONObject1.put("timestamp", localdwc.timestamp);
        if (!localdwc.FJw.isEmpty())
        {
          JSONArray localJSONArray2 = new JSONArray();
          Iterator localIterator2 = localdwc.FJw.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject = (of)localIterator2.next();
            if ((localObject != null) && (((of)localObject).FJv == paramLong))
            {
              localObject = ((of)localObject).FJw.iterator();
              while (((Iterator)localObject).hasNext())
              {
                bod localbod = (bod)((Iterator)localObject).next();
                if ((localbod != null) && (localbod.dEZ != null) && (a(paramLong, localbod.dEZ, localdwc)))
                {
                  JSONObject localJSONObject2 = new JSONObject();
                  localJSONObject2.put("dataPath", localbod.dEZ);
                  localJSONObject2.put("value", localbod.value);
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
          g(localdwc.HIB, paramboc.dtL, paramLong);
        }
      }
    }
    if (localJSONArray1.length() > 0) {}
    for (int i = 2;; i = 3)
    {
      l.w(paramLong, i);
      paramJSONObject.put("viewOp", localJSONArray1);
      AppMethodBeat.o(210490);
      return;
    }
  }
  
  static void a(JSONObject paramJSONObject, boc paramboc, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(210492);
    if (paramBoolean) {}
    JSONArray localJSONArray;
    for (Object localObject1 = paramboc.GIJ;; localObject1 = paramboc.Gse)
    {
      localJSONArray = new JSONArray();
      if (!((List)localObject1).isEmpty()) {
        break;
      }
      paramJSONObject.put("businessParam", localJSONArray);
      d(paramboc.dtL, paramBoolean, paramLong);
      AppMethodBeat.o(210492);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (bod)localIterator.next();
      if ((localObject2 != null) && (!TextUtils.isEmpty(((bod)localObject2).kJY))) {
        localArrayList.add(((bod)localObject2).kJY);
      }
    }
    int i = 0;
    localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      bod localbod = (bod)localIterator.next();
      if (localbod != null)
      {
        localObject2 = new JSONObject();
        if (localbod.dEZ == null)
        {
          localObject1 = "";
          label202:
          ((JSONObject)localObject2).put("dataPath", localObject1);
          if (localbod.value != null) {
            break label343;
          }
          localObject1 = "";
          label224:
          ((JSONObject)localObject2).put("value", localObject1);
          if (!TextUtils.isEmpty(localbod.kJY)) {
            break label353;
          }
          int j;
          do
          {
            long l = paramboc.startTime;
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
          ad.i("HABBYGE-MALI.HellSessionReportUtil", "handleSessionPageDetailParams, bizId, %s", new Object[] { localObject1 });
          localJSONArray.put(localObject2);
          break;
          localObject1 = localbod.dEZ;
          break label202;
          label343:
          localObject1 = localbod.value;
          break label224;
          label353:
          localObject1 = localbod.kJY;
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
      AppMethodBeat.o(210492);
      return;
    }
  }
  
  private static boolean a(long paramLong, String paramString, dwc paramdwc)
  {
    AppMethodBeat.i(210491);
    paramdwc = paramdwc.HIF.iterator();
    boolean bool = false;
    for (;;)
    {
      if (!paramdwc.hasNext()) {
        break label107;
      }
      Object localObject = (bsq)paramdwc.next();
      if ((localObject != null) && (((bsq)localObject).FJv == paramLong))
      {
        localObject = ((bsq)localObject).GNk.iterator();
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
    AppMethodBeat.o(210491);
    return bool;
  }
  
  static void as(String paramString, long paramLong)
  {
    AppMethodBeat.i(210493);
    d.cpU();
    Object localObject = d.uZ(paramLong);
    int i;
    label88:
    int j;
    if (localObject != null)
    {
      localObject = ((dbm)localObject).Hrg.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          dbi localdbi = (dbi)((Iterator)localObject).next();
          if (localdbi != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(localdbi.dtL))) {
              break label123;
            }
            if (!localdbi.Hrb.isEmpty())
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
      AppMethodBeat.o(210493);
      return;
    }
  }
  
  static Map<String, List<boc>> c(bob parambob)
  {
    AppMethodBeat.i(122254);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambob.GII.iterator();
    while (localIterator.hasNext())
    {
      boc localboc = (boc)localIterator.next();
      if (localboc != null)
      {
        if ((localboc.dyV != null) && (!localboc.dyV.isEmpty()))
        {
          if (localHashMap.containsKey(localboc.dyV))
          {
            List localList = (List)localHashMap.get(localboc.dyV);
            parambob = localList;
            if (localList != null) {}
          }
          for (parambob = new ArrayList();; parambob = new ArrayList())
          {
            parambob.add(localboc);
            localHashMap.put(localboc.dyV, parambob);
            break;
          }
        }
        parambob = new ArrayList();
        parambob.add(localboc);
        localHashMap.put(localboc.dtL + "_" + localboc.startTime, parambob);
      }
    }
    AppMethodBeat.o(122254);
    return localHashMap;
  }
  
  static Map<String, List<boc>> d(bob parambob)
  {
    AppMethodBeat.i(122255);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parambob.GII.iterator();
    while (localIterator.hasNext())
    {
      boc localboc = (boc)localIterator.next();
      if (localboc != null)
      {
        if ((localboc.dyV != null) && (!localboc.dyV.isEmpty()))
        {
          if (localHashMap.containsKey(localboc.dyV))
          {
            List localList = (List)localHashMap.get(localboc.dyV);
            parambob = localList;
            if (localList != null) {}
          }
          for (parambob = new ArrayList();; parambob = new ArrayList())
          {
            parambob.add(localboc);
            localHashMap.put(localboc.dyV, parambob);
            break;
          }
        }
        if (!localHashMap.containsKey(localboc.dtL))
        {
          parambob = new ArrayList();
          parambob.add(localboc);
          localHashMap.put(localboc.dtL, parambob);
        }
      }
    }
    AppMethodBeat.o(122255);
    return localHashMap;
  }
  
  public static void d(boe paramboe, bob parambob, chk paramchk)
  {
    AppMethodBeat.i(177407);
    ad.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, realReport");
    k.a(paramboe, parambob);
    k(paramboe);
    e(paramboe, parambob, paramchk);
    a.f(paramboe);
    AppMethodBeat.o(177407);
  }
  
  static void d(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(210495);
    if (paramBoolean)
    {
      AppMethodBeat.o(210495);
      return;
    }
    d.cpU();
    Object localObject = d.uZ(paramLong);
    int i;
    label101:
    int j;
    if (localObject != null)
    {
      localObject = ((dbm)localObject).Hrg.iterator();
      i = 0;
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          dbi localdbi = (dbi)((Iterator)localObject).next();
          if (localdbi != null)
          {
            if (!paramString.equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(localdbi.dtL))) {
              break label140;
            }
            if (!localdbi.Hra.isEmpty())
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
      AppMethodBeat.o(210495);
      return;
    }
  }
  
  private static bob e(bob parambob)
  {
    AppMethodBeat.i(122257);
    bob localbob = new bob();
    parambob = parambob.GII.iterator();
    while (parambob.hasNext())
    {
      boc localboc1 = (boc)parambob.next();
      boc localboc2 = new boc();
      localboc2.dyV = localboc1.dyV;
      localboc2.dtL = localboc1.dtL;
      localboc2.aHQ = localboc1.aHQ;
      localboc2.startTime = localboc1.startTime;
      localboc2.duration = localboc1.duration;
      localboc2.count = localboc1.count;
      localbob.GII.add(localboc2);
    }
    AppMethodBeat.o(122257);
    return localbob;
  }
  
  private static void e(boe paramboe, bob parambob, chk paramchk)
  {
    AppMethodBeat.i(177408);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu;
    localObject = com.tencent.mm.plugin.expt.hellhound.a.d.a.cpr();
    g.a(paramboe, parambob, (atz)localObject, paramchk);
    h.a(paramboe, e(parambob), (atz)localObject, paramchk);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cqs();
    paramboe = com.tencent.mm.plugin.expt.hellhound.a.d.a.qYu;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.cpq();
    AppMethodBeat.o(177408);
  }
  
  static void g(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(210494);
    d.cpU();
    Object localObject1 = d.uZ(paramLong);
    int i;
    label139:
    int j;
    label142:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((dbm)localObject1).Hrg.iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (dbi)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          if (!paramString2.equals(com.tencent.mm.plugin.expt.hellhound.core.b.adx(((dbi)localObject2).dtL))) {
            break label187;
          }
          localObject2 = ((dbi)localObject2).Hrb.iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              dwd localdwd = (dwd)((Iterator)localObject2).next();
              if ((localdwd != null) && (paramString1.equals(localdwd.HIB))) {
                if (!localdwd.Hra.isEmpty())
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
      AppMethodBeat.o(210494);
      return;
      j = 0;
      break label142;
    }
  }
  
  private static void k(boe paramboe)
  {
    AppMethodBeat.i(122251);
    c.cpQ();
    if (c.cpT())
    {
      ad.i("HABBYGE-MALI.HellSessionReportUtil", "HellSessionReportUtil, reportSession Detail true");
      e.f(paramboe);
    }
    f.f(paramboe);
    AppMethodBeat.o(122251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.f.j
 * JD-Core Version:    0.7.0.1
 */