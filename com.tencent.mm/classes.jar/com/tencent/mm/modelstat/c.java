package com.tencent.mm.modelstat;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.b.s;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.vfs.i;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  private static c huz;
  private ap handler;
  private av huA;
  private final int huB;
  private ArrayList<b> huC;
  private String huD;
  private long huE;
  private ArrayList<c> huF;
  private boolean huG;
  private Map<String, Boolean> huH;
  private long huI;
  private long huJ;
  private List<d> huK;
  
  private c()
  {
    AppMethodBeat.i(151021);
    this.handler = null;
    this.huA = null;
    this.huB = 20971520;
    this.huC = new ArrayList();
    this.huD = null;
    this.huE = 0L;
    this.huF = new ArrayList();
    this.huG = false;
    this.huH = new HashMap();
    this.huI = 0L;
    this.huJ = 0L;
    this.huK = new ArrayList();
    if (com.tencent.mm.sdk.a.b.eEQ()) {
      Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", aj.cbv());
    }
    com.tencent.e.j.a locala = com.tencent.e.j.a.aOc("ClickFlow");
    this.handler = new ap(locala);
    this.handler.setLogging(false);
    this.huA = new av(locala, new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151008);
        boolean bool2 = q.ig(aj.getContext());
        String str = c.cD(aj.getContext());
        if (!bt.isNullOrNil(str)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ad.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), str });
          if ((bool2) && (bool1)) {
            break;
          }
          c.b(c.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(151007);
              c.a(c.this);
              AppMethodBeat.o(151007);
            }
          });
          AppMethodBeat.o(151008);
          return false;
        }
        AppMethodBeat.o(151008);
        return true;
      }
    }, true);
    this.huA.setLogging(false);
    AppMethodBeat.o(151021);
  }
  
  private static void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(151027);
    e.vIY.kvStat(13328, paramInt + ",0,0,0,0,0,0,0,0,0,0,0,0," + paramString);
    AppMethodBeat.o(151027);
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, com.tencent.mm.sdk.e.a parama)
  {
    AppMethodBeat.i(151031);
    long l1 = ((b)paramArrayList.get(0)).time;
    long l2 = ((b)paramArrayList.get(paramArrayList.size() - 1)).huT;
    long l3 = bt.aGK();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.huF.size()) {
          break label280;
        }
        if (!"app".equals(((c)this.huF.get(i)).huX)) {
          break label285;
        }
        paramArrayList = (c)this.huF.get(i);
        if (paramArrayList != null)
        {
          if ((paramArrayList.huV > l3) && (a(paramLong, paramArrayList.rate, this.huJ)))
          {
            ad.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
            a(parama, paramArrayList.fUL, paramArrayList.id, l1, l2);
            AppMethodBeat.o(151031);
            return;
          }
          ad.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
          AppMethodBeat.o(151031);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        I(15004, bt.m(paramArrayList));
        ad.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", new Object[] { bt.m(paramArrayList) });
        AppMethodBeat.o(151031);
        return;
      }
      ad.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
      if (my(paramLong))
      {
        a(parama, 13604, 100001, l1, l2);
        AppMethodBeat.o(151031);
        return;
      }
      ad.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
      AppMethodBeat.o(151031);
      return;
      label280:
      paramArrayList = null;
      continue;
      label285:
      i += 1;
    }
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, com.tencent.mm.sdk.e.a parama, int paramInt)
  {
    AppMethodBeat.i(151033);
    for (;;)
    {
      Object localObject1;
      int i;
      JSONObject localJSONObject1;
      int j;
      try
      {
        long l = bt.eGO();
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramArrayList.size())
        {
          localJSONObject1 = new JSONObject();
          localObject2 = (b)paramArrayList.get(i);
          if ((((b)localObject2).huT < ((b)localObject2).time) || (((b)localObject2).time < 0L) || (((b)localObject2).huT < 0L) || (((b)localObject2).huT > l) || (((b)localObject2).time > l))
          {
            ad.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).huT), Long.valueOf(l) });
            AppMethodBeat.o(151033);
            return;
          }
          localJSONObject1.put("p", ((b)localObject2).huS).put("tbe", ((b)localObject2).time / 1000L).put("in", (((b)localObject2).huT - ((b)localObject2).time) / 1000L);
          if ((((b)localObject2).huK != null) && (!((b)localObject2).huK.isEmpty()))
          {
            JSONArray localJSONArray = new JSONArray();
            j = 0;
            if (j < ((b)localObject2).huK.size())
            {
              d locald = (d)((b)localObject2).huK.get(j);
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("w", locald.hva).put("t", locald.type).put("tbp", "{" + locald.left + ";" + locald.top + "}");
              localJSONArray.put(localJSONObject2);
              j += 1;
              continue;
            }
            localJSONObject1.put("wf", localJSONArray);
          }
          ((JSONArray)localObject1).put(localJSONObject1);
          i += 1;
          continue;
        }
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("t", 2).put("errt", paramInt).put("pf", localObject1);
        if (my(paramLong))
        {
          paramInt = bt.l(parama.aGC("SEQ_13604"));
          parama.fI("SEQ_13604", paramInt + 1);
          b(13604, "100002", paramInt, localJSONObject1.toString());
        }
        localObject1 = new SparseArray();
        if (this.huF.size() != 0) {
          break label747;
        }
        ad.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        I(15005, bt.m(paramArrayList));
        ad.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", new Object[] { bt.m(paramArrayList) });
        AppMethodBeat.o(151033);
        return;
      }
      if (paramInt < this.huF.size())
      {
        localObject2 = (c)this.huF.get(paramInt);
        if ((((c)localObject2).huV > bt.aGK()) && (a(paramLong, ((c)localObject2).rate, this.huJ))) {
          a(paramArrayList, (c)localObject2, (SparseArray)localObject1);
        } else {
          ad.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", new Object[] { localObject2, Long.valueOf(bt.aGK()) });
        }
      }
      else
      {
        paramInt = 0;
        while (paramInt < ((SparseArray)localObject1).size())
        {
          i = ((SparseArray)localObject1).keyAt(paramInt);
          paramArrayList = (String)((SparseArray)localObject1).get(i);
          j = bt.l(parama.aGC("SEQ_".concat(String.valueOf(i))));
          parama.fI("SEQ_".concat(String.valueOf(i)), j + 1);
          b(i, paramArrayList, j, localJSONObject1.toString());
          paramInt += 1;
        }
        AppMethodBeat.o(151033);
        return;
        label747:
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(151028);
    this.huI = parama.huI;
    if ((this.huI <= 0L) || (this.huI > 432000L)) {
      this.huI = 432000L;
    }
    this.huJ = parama.huJ;
    this.huF.clear();
    this.huF.addAll(parama.huR);
    this.huH.clear();
    this.huH.putAll(parama.huH);
    if ((this.huH.containsKey("*")) && (((Boolean)this.huH.get("*")).booleanValue())) {
      this.huG = true;
    }
    ad.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", new Object[] { Integer.valueOf(this.huF.size()), Long.valueOf(this.huI), Long.valueOf(this.huJ) });
    AppMethodBeat.o(151028);
  }
  
  private void a(b paramb, long paramLong)
  {
    AppMethodBeat.i(151025);
    if (paramb.huU <= 0L)
    {
      AppMethodBeat.o(151025);
      return;
    }
    long l = paramb.huU;
    if (this.huK.isEmpty()) {}
    for (int i = 0;; i = this.huK.size() - 1)
    {
      i = c(l, 0, i);
      if (i == -1) {
        break;
      }
      if (paramb.huK == null) {
        paramb.huK = new ArrayList();
      }
      int j = this.huK.size();
      while (i < j)
      {
        d locald = (d)this.huK.get(i);
        if ((locald.time > paramb.huU) && (locald.time <= paramLong)) {
          paramb.huK.add(locald);
        }
        if (locald.time >= paramLong) {
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(151025);
  }
  
  private static void a(com.tencent.mm.sdk.e.a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151032);
    long l1 = bt.eGO();
    if ((paramLong1 > paramLong2) || (paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong1 > l1) || (paramLong2 > l1))
    {
      ad.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1) });
      AppMethodBeat.o(151032);
      return;
    }
    int i = bt.l(parama.aGC("SEQ_".concat(String.valueOf(paramInt1))));
    parama.fI("SEQ_".concat(String.valueOf(paramInt1)), i + 1);
    long l2 = bt.f(parama.aGB("LastQuit_".concat(String.valueOf(paramInt2))));
    parama.bS("LastQuit_".concat(String.valueOf(paramInt2)), paramLong2);
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= paramLong1) {}
    }
    else
    {
      l1 = paramLong1;
    }
    parama = new JSONObject();
    parama.put("t", 1).put("tbe", paramLong1 / 1000L).put("ten", paramLong2 / 1000L).put("in", (paramLong2 - paramLong1) / 1000L).put("lten", l1 / 1000L).put("inbg", (paramLong1 - l1) / 1000L);
    b(paramInt1, String.valueOf(paramInt2), i, parama.toString());
    AppMethodBeat.o(151032);
  }
  
  private static void a(List<b> paramList, c paramc, SparseArray<String> paramSparseArray)
  {
    int k = 0;
    AppMethodBeat.i(151030);
    Object localObject = paramc.huX;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(151030);
        return;
        if (((String)localObject).equals("page"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("respective"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("ends"))
            {
              i = 2;
              continue;
              if (((String)localObject).equals("continuous")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    ad.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", new Object[] { paramc });
    paramSparseArray.put(paramc.fUL, bt.nullAsNil((String)paramSparseArray.get(paramc.fUL)) + paramc.id + ";");
    AppMethodBeat.o(151030);
    return;
    ad.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", new Object[] { paramc });
    i = 0;
    label256:
    int j;
    if (i < paramList.size())
    {
      k = 0;
      j = i;
      i = k;
      label275:
      if (i < paramc.huY.size())
      {
        if (!((String)((Pair)paramc.huY.get(i)).first).equals(((b)paramList.get(j)).huS)) {
          break label835;
        }
        paramSparseArray.put(paramc.fUL, bt.nullAsNil((String)paramSparseArray.get(paramc.fUL)) + paramc.id + ";");
        i = paramc.huY.size();
        j = paramList.size();
      }
    }
    label819:
    label835:
    for (;;)
    {
      i += 1;
      break label275;
      i = j + 1;
      break label256;
      AppMethodBeat.o(151030);
      return;
      ad.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", new Object[] { paramc });
      if (paramList.size() < 2) {
        break;
      }
      if (paramc.huY.size() == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        ad.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + paramc.huY.toString());
        AppMethodBeat.o(151030);
        return;
      }
      localObject = (String)((Pair)paramc.huY.get(0)).first;
      String str = (String)((Pair)paramc.huY.get(1)).first;
      if ((!((b)paramList.get(0)).huS.equals(localObject)) || (!((b)paramList.get(paramList.size() - 1)).huS.equals(str))) {
        break;
      }
      paramSparseArray.put(paramc.fUL, bt.nullAsNil((String)paramSparseArray.get(paramc.fUL)) + paramc.id + ";");
      AppMethodBeat.o(151030);
      return;
      ad.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", new Object[] { paramc });
      localObject = paramc.huY;
      j = k;
      if (((List)localObject).size() > 0) {}
      for (i = ((List)localObject).size() - 1;; i = ((List)localObject).size() - j + i)
      {
        j = k;
        if (i < paramList.size()) {
          j = ((List)localObject).size() - 1;
        }
        for (;;)
        {
          if (!((String)((Pair)((List)localObject).get(j)).first).equals(((b)paramList.get(i)).huS)) {
            break label819;
          }
          if (j == 0)
          {
            j = 1;
            if (j == 0) {
              break;
            }
            paramSparseArray.put(paramc.fUL, bt.nullAsNil((String)paramSparseArray.get(paramc.fUL)) + paramc.id + ";");
            break;
          }
          j -= 1;
          i -= 1;
        }
      }
    }
  }
  
  private static boolean a(long paramLong1, float paramFloat, long paramLong2)
  {
    AppMethodBeat.i(151029);
    if (com.tencent.mm.sdk.a.b.eEQ())
    {
      AppMethodBeat.o(151029);
      return true;
    }
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(151029);
      return false;
    }
    int i = 10000 / (int)(10000.0F * paramFloat);
    int j = (int)paramLong1;
    j = (j ^ j >> 16) * 73244475;
    j = (j ^ j >> 16) * 73244475;
    j = j >> 16 ^ j;
    int k = j % i;
    long l2 = bt.aGK();
    long l1;
    int m;
    if (paramLong2 == 0L)
    {
      l1 = 259200L;
      m = (int)(l2 / l1 % i);
      if (k != m) {
        break label224;
      }
    }
    label224:
    for (boolean bool = true;; bool = false)
    {
      ad.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Float.valueOf(paramFloat), Long.valueOf(paramLong2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      AppMethodBeat.o(151029);
      return bool;
      l1 = paramLong2;
      break;
    }
  }
  
  public static c aBB()
  {
    AppMethodBeat.i(151020);
    if (huz == null) {}
    try
    {
      if (huz == null) {
        huz = new c();
      }
      c localc = huz;
      AppMethodBeat.o(151020);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(151020);
    }
  }
  
  private static void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(151037);
    try
    {
      paramString2 = paramString2.replace(",", ";");
      int j = (int)Math.ceil(paramString2.length() / 6000.0D);
      int i = 0;
      while (i < j)
      {
        String str = paramString1 + "," + paramInt2 + "," + i + "," + j + ",0,0,," + paramString2.substring(i * 6000, Math.min((i + 1) * 6000, paramString2.length()));
        ad.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, str });
        e.vIY.idkeyStat(346L, 4L, 1L, false);
        e.vIY.a(paramInt1, str, true, true);
        i += 1;
      }
      AppMethodBeat.o(151037);
      return;
    }
    catch (Exception paramString1)
    {
      I(15009, bt.m(paramString1));
      ad.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", new Object[] { bt.m(paramString1) });
      AppMethodBeat.o(151037);
    }
  }
  
  private void b(long paramLong, ArrayList<b> paramArrayList, com.tencent.mm.sdk.e.a parama)
  {
    AppMethodBeat.i(151034);
    long l4 = bt.eGO();
    long l5 = ((b)paramArrayList.get(paramArrayList.size() - 1)).huT;
    if ((l5 <= 0L) || (l5 > l4))
    {
      ad.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", new Object[] { Long.valueOf(l5), Long.valueOf(l4) });
      AppMethodBeat.o(151034);
      return;
    }
    long l6 = bt.aGK();
    String str = this.huD + "stg_20971520_" + paramLong + ".HashMap";
    Object localObject1;
    long l2;
    Object localObject3;
    Object localObject2;
    try
    {
      localObject1 = zr(str);
      ((HashMap)localObject1).put(Long.valueOf(l5), paramArrayList);
      paramArrayList = ((HashMap)localObject1).entrySet().iterator();
      while (paramArrayList.hasNext()) {
        if (((Long)((Map.Entry)paramArrayList.next()).getKey()).longValue() + 259200000L < l5) {
          paramArrayList.remove();
        }
      }
      l2 = 0L;
    }
    catch (Exception paramArrayList)
    {
      ad.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { bt.m(paramArrayList) });
      AppMethodBeat.o(151034);
      return;
      b(str, (HashMap)localObject1);
      if (com.tencent.mm.sdk.a.b.eEQ()) {}
      for (l1 = 180000L;; l1 = 3600000L)
      {
        l2 = bt.a(parama.aGB("LAST_REPORT_STATISITIC_TIME"), 0L);
        if (l2 + l1 <= l5) {
          break;
        }
        ad.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l1) });
        AppMethodBeat.o(151034);
        return;
      }
      parama.bS("LAST_REPORT_STATISITIC_TIME", l5);
      localObject3 = new HashMap();
      paramArrayList = ((HashMap)localObject1).keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Long)paramArrayList.next();
        if (((Long)localObject2).longValue() > l2) {
          ((HashMap)localObject3).put(localObject2, ((HashMap)localObject1).get(localObject2));
        }
      }
    }
    catch (OutOfMemoryError paramArrayList)
    {
      i.deleteFile(str);
      System.gc();
      ad.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramArrayList, "OutOfMemoryError", new Object[0]);
      I(15010, bt.m(paramArrayList));
      AppMethodBeat.o(151034);
      return;
    }
    long l1 = 9223372036854775807L;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    Object localObject4 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    int i = 0;
    Iterator localIterator;
    if (i < this.huF.size()) {
      if ("pagestat".equals(((c)this.huF.get(i)).huX))
      {
        paramArrayList = (c)this.huF.get(i);
        ad.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", new Object[] { Integer.valueOf(((HashMap)localObject3).size()) });
        localIterator = ((HashMap)localObject3).keySet().iterator();
      }
    }
    for (;;)
    {
      label619:
      Object localObject5;
      long l3;
      if (localIterator.hasNext())
      {
        localObject1 = (Long)localIterator.next();
        if (l1 <= ((Long)localObject1).longValue()) {
          break label2453;
        }
        l1 = ((Long)localObject1).longValue();
        ad.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", new Object[] { Long.valueOf(l1), localObject1 });
        localObject5 = (ArrayList)((HashMap)localObject3).get(localObject1);
        l3 = l2 + (((b)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).huT - ((b)((ArrayList)localObject5).get(0)).time);
        if ((l3 < 0L) || (l3 > 172800000L))
        {
          ad.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", new Object[] { Long.valueOf(l3) });
          AppMethodBeat.o(151034);
          return;
          i += 1;
          break;
        }
        i = 0;
      }
      for (localObject1 = null;; localObject1 = localObject2)
      {
        if (i < ((ArrayList)localObject5).size())
        {
          localObject2 = (b)((ArrayList)localObject5).get(i);
          ad.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", new Object[] { ((b)localObject2).huS, Long.valueOf(bt.f((Long)localHashMap1.get(((b)localObject2).huS))), Long.valueOf(((b)localObject2).huT), Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).huT - ((b)localObject2).time) });
          l2 = ((b)localObject2).huT - ((b)localObject2).time;
          if ((l2 >= 0L) && (l2 <= 86400000L)) {
            break label2450;
          }
          ad.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).huT), Long.valueOf(l4), Long.valueOf(l2) });
          l2 = 0L;
          label935:
          localHashMap1.put(((b)localObject2).huS, Long.valueOf(l2 + bt.f((Long)localHashMap1.get(((b)localObject2).huS))));
          localHashMap2.put(((b)localObject2).huS, Long.valueOf(bt.f((Long)localHashMap2.get(((b)localObject2).huS)) + 1L));
          if (localObject1 != null)
          {
            localObject1 = ((b)localObject1).huS + "," + ((b)localObject2).huS;
            ((HashMap)localObject4).put(localObject1, Long.valueOf(bt.f((Long)((HashMap)localObject4).get(localObject1)) + 1L));
          }
          if (((b)localObject2).huK == null) {
            break label2467;
          }
          if (localHashMap4.containsKey(((b)localObject2).huS))
          {
            localObject1 = (Map)localHashMap4.get(((b)localObject2).huS);
            break label2461;
          }
        }
        for (;;)
        {
          if (j >= ((b)localObject2).huK.size()) {
            break label2467;
          }
          Object localObject6 = (d)((b)localObject2).huK.get(j);
          ((Map)localObject1).put(((d)localObject6).hva, Long.valueOf(bt.f((Long)((Map)localObject1).get(((d)localObject6).hva)) + 1L));
          j += 1;
          continue;
          localObject1 = new HashMap();
          localHashMap4.put(((b)localObject2).huS, localObject1);
          break label2461;
          if (paramArrayList == null) {
            break label2480;
          }
          localObject1 = paramArrayList.huZ.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Pair)((Iterator)localObject1).next();
            localObject5 = (String)((Pair)localObject2).first + "," + (String)((Pair)localObject2).second;
            if (((HashMap)localObject4).containsKey(localObject5)) {
              localHashMap3.put(((Pair)localObject2).second, ((HashMap)localObject4).get(localObject5));
            }
          }
          l3 = ((b)((ArrayList)((HashMap)localObject3).get(Long.valueOf(l1))).get(0)).time;
          ad.i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
          if ((l3 > l4) || (l3 < 0L))
          {
            ad.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
            AppMethodBeat.o(151034);
            return;
          }
          i = 0;
          for (;;)
          {
            try
            {
              if (i >= this.huF.size()) {
                break label2445;
              }
              if (!"appstat".equals(((c)this.huF.get(i)).huX)) {
                continue;
              }
              paramArrayList = (c)this.huF.get(i);
              ad.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", new Object[] { Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(l2) });
              if ((paramArrayList == null) || (l5 - l3 - l2 < 0L)) {
                continue;
              }
              if ((paramArrayList.huV <= l6) || (!a(paramLong, paramArrayList.rate, this.huJ))) {
                continue;
              }
              ad.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = bt.l(parama.aGC("SEQ_" + paramArrayList.fUL));
              parama.fI("SEQ_" + paramArrayList.fUL, i + 1);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 5).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("in", l2 / 1000L).put("inbg", (l5 - l3 - l2) / 1000L).put("swc", ((HashMap)localObject3).size());
              b(paramArrayList.fUL, paramArrayList.id, i, ((JSONObject)localObject1).toString());
            }
            catch (Exception paramArrayList)
            {
              I(15006, bt.m(paramArrayList));
              ad.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", new Object[] { bt.m(paramArrayList) });
              continue;
              ad.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", new Object[] { paramArrayList, Long.valueOf(l5 - l3 - l2) });
              continue;
              i += 1;
              continue;
              ((JSONObject)localObject2).put("wa", localObject3);
              parama.put(localObject2);
              continue;
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 6).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("pa", parama);
              b(paramArrayList.fUL, paramArrayList.id, i, ((JSONObject)localObject1).toString());
              AppMethodBeat.o(151034);
              return;
            }
            i = 0;
            try
            {
              if (i >= this.huF.size()) {
                break label2440;
              }
              if (!"pagestat".equals(((c)this.huF.get(i)).huX)) {
                continue;
              }
              paramArrayList = (c)this.huF.get(i);
              if (paramArrayList == null) {
                break label2425;
              }
              if ((paramArrayList.huV <= l6) || (!a(paramLong, paramArrayList.rate, this.huJ))) {
                break label2394;
              }
              ad.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = bt.l(parama.aGC("SEQ_" + paramArrayList.fUL));
              parama.fI("SEQ_" + paramArrayList.fUL, i + 1);
              parama = new JSONArray();
              localObject1 = localHashMap1.keySet().iterator();
              if (!((Iterator)localObject1).hasNext()) {
                continue;
              }
              localObject4 = (String)((Iterator)localObject1).next();
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("p", localObject4).put("in", ((Long)localHashMap1.get(localObject4)).longValue() / 1000L).put("c", localHashMap2.get(localObject4)).put("c2", localHashMap3.get(localObject4));
              if (!localHashMap4.containsKey(localObject4)) {
                continue;
              }
              localObject3 = new JSONArray();
              localObject4 = (Map)localHashMap4.get(localObject4);
              localIterator = ((Map)localObject4).keySet().iterator();
              if (!localIterator.hasNext()) {
                continue;
              }
              localObject5 = (String)localIterator.next();
              localObject6 = new JSONObject();
              ((JSONObject)localObject6).put("w", localObject5).put("c", ((Map)localObject4).get(localObject5));
              ((JSONArray)localObject3).put(localObject6);
              continue;
              i += 1;
            }
            catch (Exception paramArrayList)
            {
              I(15007, bt.m(paramArrayList));
              ad.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { bt.m(paramArrayList) });
              AppMethodBeat.o(151034);
              return;
            }
            continue;
            ad.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            continue;
            label2394:
            ad.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            AppMethodBeat.o(151034);
            return;
            label2425:
            ad.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
            AppMethodBeat.o(151034);
            return;
            label2440:
            paramArrayList = null;
            continue;
            label2445:
            paramArrayList = null;
          }
          label2450:
          break label935;
          label2453:
          break label619;
          paramArrayList = null;
          break;
          label2461:
          int j = 0;
        }
        label2467:
        i += 1;
      }
      label2480:
      l2 = l3;
    }
  }
  
  /* Error */
  private void b(String paramString, HashMap<Long, ArrayList<b>> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 926
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 272	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   11: lstore_3
    //   12: aload_1
    //   13: iconst_0
    //   14: invokestatic 930	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   17: astore_1
    //   18: new 932	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 935	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore 8
    //   28: aload 8
    //   30: astore 6
    //   32: aload_1
    //   33: astore 5
    //   35: aload 8
    //   37: aload_2
    //   38: invokevirtual 939	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload 8
    //   43: astore 6
    //   45: aload_1
    //   46: astore 5
    //   48: aload_1
    //   49: invokevirtual 944	java/io/OutputStream:flush	()V
    //   52: aload 8
    //   54: astore 6
    //   56: aload_1
    //   57: astore 5
    //   59: ldc 218
    //   61: ldc_w 946
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_2
    //   71: invokevirtual 875	java/util/HashMap:size	()I
    //   74: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: lload_3
    //   81: invokestatic 668	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   84: invokestatic 226	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: aastore
    //   88: invokestatic 231	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload 8
    //   93: invokevirtual 949	java/io/ObjectOutputStream:close	()V
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 950	java/io/OutputStream:close	()V
    //   104: ldc_w 926
    //   107: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_1
    //   114: ldc_w 926
    //   117: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -10 -> 110
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore 7
    //   130: aconst_null
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_2
    //   135: astore 6
    //   137: aload_1
    //   138: astore 5
    //   140: ldc 218
    //   142: ldc_w 952
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 953	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload 7
    //   161: invokestatic 246	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 253	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 949	java/io/ObjectOutputStream:close	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 950	java/io/OutputStream:close	()V
    //   184: ldc_w 926
    //   187: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: goto -80 -> 110
    //   193: astore_1
    //   194: ldc_w 926
    //   197: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: goto -90 -> 110
    //   203: astore_2
    //   204: aconst_null
    //   205: astore 6
    //   207: aconst_null
    //   208: astore_1
    //   209: aload 6
    //   211: ifnull +8 -> 219
    //   214: aload 6
    //   216: invokevirtual 949	java/io/ObjectOutputStream:close	()V
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 950	java/io/OutputStream:close	()V
    //   227: ldc_w 926
    //   230: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_2
    //   234: athrow
    //   235: astore_2
    //   236: goto -140 -> 96
    //   239: astore_2
    //   240: goto -64 -> 176
    //   243: astore 5
    //   245: goto -26 -> 219
    //   248: astore_1
    //   249: goto -22 -> 227
    //   252: astore_2
    //   253: aconst_null
    //   254: astore 6
    //   256: goto -47 -> 209
    //   259: astore_2
    //   260: aload 5
    //   262: astore_1
    //   263: goto -54 -> 209
    //   266: astore 7
    //   268: aconst_null
    //   269: astore_2
    //   270: goto -136 -> 134
    //   273: astore 7
    //   275: aload 8
    //   277: astore_2
    //   278: goto -144 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	c
    //   0	281	1	paramString	String
    //   0	281	2	paramHashMap	HashMap<Long, ArrayList<b>>
    //   11	70	3	l	long
    //   33	106	5	str	String
    //   243	18	5	localException1	Exception
    //   30	225	6	localObject	Object
    //   128	32	7	localException2	Exception
    //   266	1	7	localException3	Exception
    //   273	1	7	localException4	Exception
    //   26	250	8	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   100	104	113	java/lang/Exception
    //   2	8	123	finally
    //   91	96	123	finally
    //   100	104	123	finally
    //   104	110	123	finally
    //   114	120	123	finally
    //   172	176	123	finally
    //   180	184	123	finally
    //   184	190	123	finally
    //   194	200	123	finally
    //   214	219	123	finally
    //   223	227	123	finally
    //   227	235	123	finally
    //   8	18	128	java/lang/Exception
    //   180	184	193	java/lang/Exception
    //   8	18	203	finally
    //   91	96	235	java/lang/Exception
    //   172	176	239	java/lang/Exception
    //   214	219	243	java/lang/Exception
    //   223	227	248	java/lang/Exception
    //   18	28	252	finally
    //   35	41	259	finally
    //   48	52	259	finally
    //   59	91	259	finally
    //   140	168	259	finally
    //   18	28	266	java/lang/Exception
    //   35	41	273	java/lang/Exception
    //   48	52	273	java/lang/Exception
    //   59	91	273	java/lang/Exception
  }
  
  private int c(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151026);
    if ((this.huK == null) || (this.huK.isEmpty()))
    {
      AppMethodBeat.o(151026);
      return -1;
    }
    int i = (paramInt1 + paramInt2) / 2;
    if ((paramInt2 - paramInt1 == 0) || (paramInt2 - paramInt1 == 1)) {
      if (paramLong < ((d)this.huK.get(paramInt2)).time) {}
    }
    for (;;)
    {
      AppMethodBeat.o(151026);
      return paramInt2;
      paramInt2 = paramInt1;
      continue;
      if (paramLong < ((d)this.huK.get(i)).time) {
        paramInt2 = c(paramLong, paramInt1, i);
      } else if (paramLong > ((d)this.huK.get(i)).time) {
        paramInt2 = c(paramLong, i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  private static boolean cB(Context paramContext)
  {
    AppMethodBeat.i(151039);
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null)
      {
        AppMethodBeat.o(151039);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.importance == 100) {
          if ((!localRunningAppProcessInfo.processName.equals("com.tencent.mm")) && (!localRunningAppProcessInfo.processName.equals("com.tencent.mm:tools")))
          {
            boolean bool = localRunningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp");
            if (!bool) {
              break;
            }
          }
          else
          {
            AppMethodBeat.o(151039);
            return true;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramContext, "isAppOnForeground", new Object[0]);
      AppMethodBeat.o(151039);
    }
    return false;
  }
  
  private static String cC(Context paramContext)
  {
    AppMethodBeat.i(151040);
    if (!cB(paramContext))
    {
      AppMethodBeat.o(151040);
      return "";
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str;
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0))
        {
          AppMethodBeat.o(151040);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(151040);
            return null;
          }
          str = paramContext.getClassName();
          paramContext = str;
          if (str.contains(".")) {
            paramContext = str.substring(str.lastIndexOf(".") + 1);
          }
          AppMethodBeat.o(151040);
          return paramContext;
        }
      }
      else
      {
        str = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        paramContext = str;
        if (str.contains(".")) {
          paramContext = str.substring(str.lastIndexOf(".") + 1);
        }
        AppMethodBeat.o(151040);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bt.m(paramContext) });
      AppMethodBeat.o(151040);
    }
    return "";
  }
  
  private Pair<Integer, ArrayList<b>> m(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(151024);
    ArrayList localArrayList = new ArrayList();
    long l2 = bt.eGO();
    long l1;
    int i;
    Object localObject1;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new ArrayList();
        l1 = 0L;
        i = 0;
        if (i < paramArrayList.size())
        {
          localObject1 = (b)paramArrayList.get(i);
          if ((((b)localObject1).time < 0L) || (((b)localObject1).time > l2) || (l2 - ((b)localObject1).time > 50400000L))
          {
            ad.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", new Object[] { Long.valueOf(((b)localObject1).time), Long.valueOf(l2 - ((b)localObject1).time), Integer.valueOf(((b)localObject1).diR), ((b)localObject1).huS });
            AppMethodBeat.o(151024);
            return null;
          }
          if (((b)localObject1).diR == 4)
          {
            if (l1 >= ((b)localObject1).time) {
              break label703;
            }
            l1 = ((b)localObject1).time;
            break label696;
          }
          if (((b)localObject1).diR != 3)
          {
            ad.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", new Object[] { Integer.valueOf(((b)localObject1).diR), ((b)localObject1).huS });
            AppMethodBeat.o(151024);
            return null;
          }
          ((ArrayList)localObject2).add(localObject1);
          break label703;
        }
        i = ((ArrayList)localObject2).size();
        if (i == 0)
        {
          AppMethodBeat.o(151024);
          return null;
        }
        Collections.sort((List)localObject2);
        Collections.sort(this.huK);
        localObject1 = new b();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (b)localIterator.next();
        if (((b)localObject2).huS.equals(((b)localObject1).huS))
        {
          if (((b)localObject2).time - ((b)localObject1).time <= 10800000L) {
            continue;
          }
          ad.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject1).time) });
          ((b)localObject1).time = ((b)localObject2).time;
          continue;
        }
        a((b)localObject1, ((b)localObject2).huU);
      }
      catch (Exception paramArrayList)
      {
        I(15008, bt.m(paramArrayList));
        ad.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", new Object[] { bt.m(paramArrayList) });
        AppMethodBeat.o(151024);
        return null;
      }
      localArrayList.add(localObject2);
      ((b)localObject1).huT = ((b)localObject2).time;
      localObject1 = localObject2;
    }
    if (!localArrayList.isEmpty()) {
      a((b)localArrayList.get(localArrayList.size() - 1), l1);
    }
    ((b)localObject1).huT = ((b)paramArrayList.get(paramArrayList.size() - 1)).time;
    if (((b)localArrayList.get(localArrayList.size() - 1)).time > l1) {
      ((b)localArrayList.get(localArrayList.size() - 1)).huT = l2;
    }
    while (((b)localArrayList.get(localArrayList.size() - 1)).huT - ((b)localArrayList.get(0)).time > 50400000L)
    {
      ad.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
      AppMethodBeat.o(151024);
      return null;
      if (l1 > l2) {
        ((b)localArrayList.get(localArrayList.size() - 1)).huT = l2;
      }
    }
    ad.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(localArrayList.size()), Long.valueOf(bt.vM(l2)) });
    paramArrayList = Pair.create(Integer.valueOf(0), localArrayList);
    AppMethodBeat.o(151024);
    return paramArrayList;
    label696:
    label703:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  private static boolean my(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private static String mz(long paramLong)
  {
    AppMethodBeat.i(151038);
    if (paramLong < 100000000000L)
    {
      str = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(paramLong * 1000L));
      AppMethodBeat.o(151038);
      return str;
    }
    String str = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(paramLong)) + String.format(Locale.getDefault(), ".%03d", new Object[] { Long.valueOf(paramLong % 1000L) });
    AppMethodBeat.o(151038);
    return str;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UseSparseArrays"})
  private static HashMap<Long, ArrayList<b>> zr(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1101
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 272	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   9: lstore_1
    //   10: new 509	com/tencent/mm/vfs/e
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 510	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 513	com/tencent/mm/vfs/e:exists	()Z
    //   23: ifeq +12 -> 35
    //   26: aload_3
    //   27: invokevirtual 1103	com/tencent/mm/vfs/e:length	()J
    //   30: lconst_0
    //   31: lcmp
    //   32: ifgt +35 -> 67
    //   35: ldc 218
    //   37: ldc_w 1105
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: invokestatic 1107	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: new 86	java/util/HashMap
    //   54: dup
    //   55: invokespecial 87	java/util/HashMap:<init>	()V
    //   58: astore_0
    //   59: ldc_w 1101
    //   62: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: aload_3
    //   68: invokestatic 1111	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   71: astore_0
    //   72: new 1113	java/io/ObjectInputStream
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 1116	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore_3
    //   81: aload_3
    //   82: astore 5
    //   84: aload_0
    //   85: astore 4
    //   87: aload_3
    //   88: invokevirtual 1119	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   91: checkcast 86	java/util/HashMap
    //   94: astore 6
    //   96: aload_3
    //   97: astore 5
    //   99: aload_0
    //   100: astore 4
    //   102: ldc 218
    //   104: ldc_w 1121
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload 6
    //   115: invokevirtual 875	java/util/HashMap:size	()I
    //   118: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: lload_1
    //   125: invokestatic 668	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   128: invokestatic 226	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   131: aastore
    //   132: invokestatic 231	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload_3
    //   136: invokevirtual 1122	java/io/ObjectInputStream:close	()V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 1125	java/io/InputStream:close	()V
    //   147: ldc_w 1101
    //   150: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload 6
    //   155: areturn
    //   156: astore 6
    //   158: aconst_null
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_3
    //   163: astore 5
    //   165: aload_0
    //   166: astore 4
    //   168: ldc 218
    //   170: ldc_w 1127
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 6
    //   181: invokevirtual 1128	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 6
    //   189: invokestatic 246	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 253	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 1122	java/io/ObjectInputStream:close	()V
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokevirtual 1125	java/io/InputStream:close	()V
    //   212: new 86	java/util/HashMap
    //   215: dup
    //   216: invokespecial 87	java/util/HashMap:<init>	()V
    //   219: astore_0
    //   220: ldc_w 1101
    //   223: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_0
    //   227: areturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore 5
    //   232: aconst_null
    //   233: astore_0
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 1122	java/io/ObjectInputStream:close	()V
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 1125	java/io/InputStream:close	()V
    //   252: ldc_w 1101
    //   255: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_3
    //   259: athrow
    //   260: astore_3
    //   261: goto -122 -> 139
    //   264: astore_0
    //   265: goto -118 -> 147
    //   268: astore_3
    //   269: goto -65 -> 204
    //   272: astore_0
    //   273: goto -61 -> 212
    //   276: astore 4
    //   278: goto -34 -> 244
    //   281: astore_0
    //   282: goto -30 -> 252
    //   285: astore_3
    //   286: aconst_null
    //   287: astore 5
    //   289: goto -55 -> 234
    //   292: astore_3
    //   293: aload 4
    //   295: astore_0
    //   296: goto -62 -> 234
    //   299: astore 6
    //   301: aconst_null
    //   302: astore_3
    //   303: goto -141 -> 162
    //   306: astore 6
    //   308: goto -146 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramString	String
    //   9	116	1	l	long
    //   18	183	3	localObject1	Object
    //   228	31	3	localObject2	Object
    //   260	1	3	localException1	Exception
    //   268	1	3	localException2	Exception
    //   285	1	3	localObject3	Object
    //   292	1	3	localObject4	Object
    //   302	1	3	localObject5	Object
    //   85	82	4	str	String
    //   276	18	4	localException3	Exception
    //   82	206	5	localObject6	Object
    //   94	60	6	localHashMap	HashMap
    //   156	32	6	localThrowable1	Throwable
    //   299	1	6	localThrowable2	Throwable
    //   306	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	35	156	java/lang/Throwable
    //   35	59	156	java/lang/Throwable
    //   67	72	156	java/lang/Throwable
    //   10	35	228	finally
    //   35	59	228	finally
    //   67	72	228	finally
    //   135	139	260	java/lang/Exception
    //   143	147	264	java/lang/Exception
    //   200	204	268	java/lang/Exception
    //   208	212	272	java/lang/Exception
    //   239	244	276	java/lang/Exception
    //   248	252	281	java/lang/Exception
    //   72	81	285	finally
    //   87	96	292	finally
    //   102	135	292	finally
    //   168	196	292	finally
    //   72	81	299	java/lang/Throwable
    //   87	96	306	java/lang/Throwable
    //   102	135	306	java/lang/Throwable
  }
  
  public final void commitNow()
  {
    AppMethodBeat.i(151022);
    long l = bt.eGO();
    ad.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", new Object[] { (Boolean)new c.2(this, Boolean.FALSE).b(this.handler), Long.valueOf(bt.vM(l)) });
    AppMethodBeat.o(151022);
  }
  
  public final void j(Intent paramIntent)
  {
    AppMethodBeat.i(151023);
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")))
    {
      AppMethodBeat.o(151023);
      return;
    }
    this.handler.post(new c.3(this, paramIntent));
    AppMethodBeat.o(151023);
  }
  
  static final class a
  {
    Map<String, Boolean> huH;
    long huI;
    long huJ;
    List<c.c> huR;
    
    private a()
    {
      AppMethodBeat.i(151013);
      this.huR = new ArrayList();
      this.huH = new HashMap();
      AppMethodBeat.o(151013);
    }
    
    static a zs(String paramString)
    {
      AppMethodBeat.i(151015);
      a locala = new a();
      Map localMap;
      try
      {
        localMap = bw.K(paramString, "eventSampleConf");
        if (localMap == null)
        {
          ad.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", new Object[] { paramString });
          paramString = new a("reportConfigMap is null");
          AppMethodBeat.o(151015);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString = new a(paramString);
        AppMethodBeat.o(151015);
        throw paramString;
      }
      locala.huI = bt.getLong((String)localMap.get(".eventSampleConf.nextUpdateInterval"), 0L);
      if ((locala.huI <= 0L) || (locala.huI > 432000L)) {
        locala.huI = 432000L;
      }
      locala.huJ = bt.getLong((String)localMap.get(".eventSampleConf.samplePeriod"), 0L);
      int i = 0;
      c.c localc = new c.c((byte)0);
      Object localObject1 = new StringBuilder(".eventSampleConf.events.event");
      label180:
      ArrayList localArrayList;
      int j;
      Object localObject2;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject1 = paramString + ".";
        localc.id = bt.getInt((String)localMap.get((String)localObject1 + "id"), 0);
        if (localc.id > 0)
        {
          localc.huV = bt.getLong((String)localMap.get((String)localObject1 + "expireTime"), 0L);
          localc.name = ((String)localMap.get((String)localObject1 + "name"));
          localc.rate = bt.getFloat((String)localMap.get((String)localObject1 + "rate"), 0.0F);
          localc.fUL = bt.getInt((String)localMap.get((String)localObject1 + "logId"), 0);
          localc.huX = ((String)localMap.get((String)localObject1 + "pages.$type"));
          localArrayList = new ArrayList();
          j = 0;
          for (;;)
          {
            localObject2 = new StringBuilder().append((String)localObject1).append("pages.page");
            if (j <= 0) {
              break label819;
            }
            paramString = Integer.valueOf(j);
            label469:
            paramString = paramString + ".";
            localObject2 = (String)localMap.get(paramString + "$id");
            if (localObject2 == null) {
              break;
            }
            boolean bool = ((String)localMap.get(paramString + "$action")).equals("true");
            localArrayList.add(new Pair(localObject2, Boolean.valueOf(bool)));
            locala.huH.put(localObject2, Boolean.valueOf(bool));
            j += 1;
          }
          localc.huY = localArrayList;
          localArrayList = new ArrayList();
          j = 0;
          label616:
          localObject2 = new StringBuilder().append((String)localObject1).append("specialPVPages.pageItem");
          if (j <= 0) {
            break label825;
          }
        }
      }
      label819:
      label825:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        paramString = paramString + ".";
        localObject2 = (String)localMap.get(paramString + "$prePage");
        if (localObject2 != null)
        {
          localArrayList.add(new Pair(localObject2, (String)localMap.get(paramString + "$page")));
          j += 1;
          break label616;
        }
        localc.huZ = localArrayList;
        locala.huR.add(localc);
        ad.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", new Object[] { localc });
        i += 1;
        break;
        ad.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", new Object[] { locala });
        AppMethodBeat.o(151015);
        return locala;
        paramString = "";
        break label180;
        paramString = "";
        break label469;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(151014);
      String str = "Config{nextUpdateInterval=" + this.huI + ", samplePeriod=" + this.huJ + ", eventList=" + this.huR + '}';
      AppMethodBeat.o(151014);
      return str;
    }
    
    static final class a
      extends Exception
    {
      a(String paramString)
      {
        super();
      }
      
      a(Throwable paramThrowable)
      {
        super();
      }
    }
  }
  
  static final class b
    implements Serializable, Comparable<b>
  {
    int diR = 0;
    List<c.d> huK = null;
    String huS = null;
    long huT;
    long huU = 0L;
    long time = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(151016);
      String str = String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[] { this.huS, Integer.valueOf(this.diR), c.mA(this.time) });
      AppMethodBeat.o(151016);
      return str;
    }
  }
  
  static final class c
  {
    int fUL;
    long huV;
    String huX;
    ArrayList<Pair<String, Boolean>> huY;
    ArrayList<Pair<String, String>> huZ;
    int id;
    String name;
    float rate;
    
    private c()
    {
      AppMethodBeat.i(151017);
      this.huY = new ArrayList();
      this.huZ = new ArrayList();
      AppMethodBeat.o(151017);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(151018);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportConfigEvent{");
      ((StringBuilder)localObject).append("id=" + this.id);
      ((StringBuilder)localObject).append(", name='" + this.name + "'");
      ((StringBuilder)localObject).append(", expireTime=" + this.huV);
      ((StringBuilder)localObject).append(", rate=" + this.rate);
      ((StringBuilder)localObject).append(", logId=" + this.fUL);
      ((StringBuilder)localObject).append(", pagesType='" + this.huX + "'");
      ((StringBuilder)localObject).append(", pageList=[");
      Iterator localIterator = this.huY.iterator();
      Pair localPair;
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        ((StringBuilder)localObject).append("{" + (String)localPair.first + "," + localPair.second + "}");
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(", specialPVPages=[");
      localIterator = this.huZ.iterator();
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        ((StringBuilder)localObject).append("{" + (String)localPair.first + "," + (String)localPair.second + "}");
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("]}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(151018);
      return localObject;
    }
  }
  
  static final class d
    implements Serializable, Comparable<d>
  {
    String hva = null;
    int left;
    long time = 0L;
    int top;
    int type = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(151019);
      String str = String.format(Locale.getDefault(), "[%s,%s]", new Object[] { this.hva, c.mA(this.time) });
      AppMethodBeat.o(151019);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.c
 * JD-Core Version:    0.7.0.1
 */