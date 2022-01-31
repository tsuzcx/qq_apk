package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.mm.accessibility.AccessibilityCapture.Event;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  implements AccessibilityCapture.APIProvider
{
  private static c eCa;
  private am eCb = null;
  private final int eCc = 20971520;
  private ArrayList<b> eCd = new ArrayList();
  private String eCe = null;
  private long eCf = 0L;
  private ArrayList<c.c> eCg = new ArrayList();
  private boolean eCh = false;
  private Map<String, Boolean> eCi = new HashMap();
  private long eCj = 0L;
  private long eCk = 0L;
  private List<c.d> eCl = new ArrayList();
  private ah handler = null;
  
  private c()
  {
    if (b.cqk()) {
      Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", ae.cqV());
    }
    HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.aap("ClickFlow");
    localHandlerThread.start();
    this.handler = new ah(localHandlerThread.getLooper());
    this.eCb = new am(localHandlerThread.getLooper(), new c.1(this), true);
  }
  
  public static c Rn()
  {
    if (eCa == null) {}
    try
    {
      if (eCa == null) {
        eCa = new c();
      }
      return eCa;
    }
    finally {}
  }
  
  private static void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    try
    {
      paramString2 = paramString2.replace(",", ";");
      int j = (int)Math.ceil(paramString2.length() / 6000.0D);
      int i = 0;
      while (i < j)
      {
        String str = paramString1 + "," + paramInt2 + "," + i + "," + j + ",0,0,," + paramString2.substring(i * 6000, Math.min((i + 1) * 6000, paramString2.length()));
        y.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, str });
        f.nEG.a(346L, 4L, 1L, false);
        f.nEG.a(paramInt1, str, true, true);
        i += 1;
      }
      return;
    }
    catch (Exception paramString1)
    {
      r(15009, bk.j(paramString1));
      y.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", new Object[] { bk.j(paramString1) });
    }
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, a parama)
  {
    long l1 = ((b)paramArrayList.get(0)).time;
    long l2 = ((b)paramArrayList.get(paramArrayList.size() - 1)).eCu;
    long l3 = bk.UX();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.eCg.size()) {
          break label254;
        }
        if (!"app".equals(((c.c)this.eCg.get(i)).eCx)) {
          break label259;
        }
        paramArrayList = (c.c)this.eCg.get(i);
        if (paramArrayList != null)
        {
          if ((paramArrayList.eCv > l3) && (a(paramLong, paramArrayList.eCw, this.eCk)))
          {
            y.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
            a(parama, paramArrayList.dCy, paramArrayList.id, l1, l2);
            return;
          }
          y.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        r(15004, bk.j(paramArrayList));
        y.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", new Object[] { bk.j(paramArrayList) });
        return;
      }
      y.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
      if (cd(paramLong))
      {
        a(parama, 13604, 100001, l1, l2);
        return;
      }
      y.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
      return;
      label254:
      paramArrayList = null;
      continue;
      label259:
      i += 1;
    }
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, a parama, int paramInt)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      JSONObject localJSONObject1;
      int j;
      try
      {
        long l = bk.UY();
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramArrayList.size())
        {
          localJSONObject1 = new JSONObject();
          localObject2 = (b)paramArrayList.get(i);
          if ((((b)localObject2).eCu < ((b)localObject2).time) || (((b)localObject2).time < 0L) || (((b)localObject2).eCu < 0L) || (((b)localObject2).eCu > l) || (((b)localObject2).time > l))
          {
            y.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).eCu), Long.valueOf(l) });
            return;
          }
          localJSONObject1.put("p", ((b)localObject2).eCt).put("tbe", ((b)localObject2).time / 1000L).put("in", (((b)localObject2).eCu - ((b)localObject2).time) / 1000L);
          if ((((b)localObject2).eCl != null) && (!((b)localObject2).eCl.isEmpty()))
          {
            JSONArray localJSONArray = new JSONArray();
            j = 0;
            if (j < ((b)localObject2).eCl.size())
            {
              c.d locald = (c.d)((b)localObject2).eCl.get(j);
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("w", locald.eCA).put("t", locald.type).put("tbp", "{" + locald.left + ";" + locald.top + "}");
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
        if (cd(paramLong))
        {
          paramInt = bk.g(parama.aal("SEQ_13604"));
          parama.dq("SEQ_13604", paramInt + 1);
          a(13604, "100002", paramInt, localJSONObject1.toString());
        }
        localObject1 = new SparseArray();
        if (this.eCg.size() != 0) {
          break label736;
        }
        y.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        r(15005, bk.j(paramArrayList));
        y.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", new Object[] { bk.j(paramArrayList) });
        return;
      }
      if (paramInt < this.eCg.size())
      {
        localObject2 = (c.c)this.eCg.get(paramInt);
        if ((((c.c)localObject2).eCv > bk.UX()) && (a(paramLong, ((c.c)localObject2).eCw, this.eCk))) {
          a(paramArrayList, (c.c)localObject2, (SparseArray)localObject1);
        } else {
          y.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", new Object[] { localObject2, Long.valueOf(bk.UX()) });
        }
      }
      else
      {
        paramInt = 0;
        while (paramInt < ((SparseArray)localObject1).size())
        {
          i = ((SparseArray)localObject1).keyAt(paramInt);
          paramArrayList = (String)((SparseArray)localObject1).get(i);
          j = bk.g(parama.aal("SEQ_" + i));
          parama.dq("SEQ_" + i, j + 1);
          a(i, paramArrayList, j, localJSONObject1.toString());
          paramInt += 1;
        }
        return;
        label736:
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }
  
  private void a(c.a parama)
  {
    this.eCj = parama.eCj;
    if ((this.eCj <= 0L) || (this.eCj > 432000L)) {
      this.eCj = 432000L;
    }
    this.eCk = parama.eCk;
    this.eCg.clear();
    this.eCg.addAll(parama.eCs);
    this.eCi.clear();
    this.eCi.putAll(parama.eCi);
    if ((this.eCi.containsKey("*")) && (((Boolean)this.eCi.get("*")).booleanValue())) {
      this.eCh = true;
    }
    y.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", new Object[] { Integer.valueOf(this.eCg.size()), Long.valueOf(this.eCj), Long.valueOf(this.eCk) });
  }
  
  private void a(b paramb, long paramLong)
  {
    if (paramb.elapsedTime <= 0L) {
      return;
    }
    long l = paramb.elapsedTime;
    if (this.eCl.isEmpty()) {}
    for (int i = 0;; i = this.eCl.size() - 1)
    {
      i = c(l, 0, i);
      if (i == -1) {
        break;
      }
      if (paramb.eCl == null) {
        paramb.eCl = new ArrayList();
      }
      int j = this.eCl.size();
      for (;;)
      {
        if (i >= j) {
          break label152;
        }
        c.d locald = (c.d)this.eCl.get(i);
        if ((locald.time > paramb.elapsedTime) && (locald.time <= paramLong)) {
          paramb.eCl.add(locald);
        }
        if (locald.time >= paramLong) {
          break;
        }
        i += 1;
      }
      label152:
      break;
    }
  }
  
  private static void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    long l1 = bk.UY();
    if ((paramLong1 > paramLong2) || (paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong1 > l1) || (paramLong2 > l1))
    {
      y.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1) });
      return;
    }
    int i = bk.g(parama.aal("SEQ_" + paramInt1));
    parama.dq("SEQ_" + paramInt1, i + 1);
    long l2 = bk.c(parama.aak("LastQuit_" + paramInt2));
    parama.ar("LastQuit_" + paramInt2, paramLong2);
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
    a(paramInt1, String.valueOf(paramInt2), i, parama.toString());
  }
  
  /* Error */
  private void a(String paramString, HashMap<Long, ArrayList<b>> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 306	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   5: lstore_3
    //   6: new 761	java/io/FileOutputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 762	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: new 764	java/io/ObjectOutputStream
    //   19: dup
    //   20: aload 5
    //   22: invokespecial 767	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore 7
    //   29: aload 5
    //   31: astore 6
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 771	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_1
    //   39: astore 7
    //   41: aload 5
    //   43: astore 6
    //   45: aload 5
    //   47: invokevirtual 774	java/io/FileOutputStream:flush	()V
    //   50: aload_1
    //   51: astore 7
    //   53: aload 5
    //   55: astore 6
    //   57: ldc 186
    //   59: ldc_w 776
    //   62: iconst_2
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_2
    //   69: invokevirtual 777	java/util/HashMap:size	()I
    //   72: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: lload_3
    //   79: invokestatic 719	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   82: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 200	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_1
    //   90: invokevirtual 780	java/io/ObjectOutputStream:close	()V
    //   93: aload 5
    //   95: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aconst_null
    //   105: astore 5
    //   107: aload_1
    //   108: astore 7
    //   110: aload 5
    //   112: astore 6
    //   114: ldc 186
    //   116: ldc_w 783
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_2
    //   126: invokevirtual 784	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_2
    //   133: invokestatic 222	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 231	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 780	java/io/ObjectOutputStream:close	()V
    //   148: aload 5
    //   150: ifnull -52 -> 98
    //   153: aload 5
    //   155: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   158: goto -60 -> 98
    //   161: astore_1
    //   162: goto -64 -> 98
    //   165: astore_1
    //   166: aconst_null
    //   167: astore 7
    //   169: aconst_null
    //   170: astore 5
    //   172: aload 7
    //   174: ifnull +8 -> 182
    //   177: aload 7
    //   179: invokevirtual 780	java/io/ObjectOutputStream:close	()V
    //   182: aload 5
    //   184: ifnull +8 -> 192
    //   187: aload 5
    //   189: invokevirtual 781	java/io/FileOutputStream:close	()V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: goto -107 -> 93
    //   203: astore_1
    //   204: goto -106 -> 98
    //   207: astore_1
    //   208: goto -60 -> 148
    //   211: astore_2
    //   212: goto -30 -> 182
    //   215: astore_2
    //   216: goto -24 -> 192
    //   219: astore_1
    //   220: aconst_null
    //   221: astore 7
    //   223: goto -51 -> 172
    //   226: astore_1
    //   227: aload 6
    //   229: astore 5
    //   231: goto -59 -> 172
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_1
    //   237: goto -130 -> 107
    //   240: astore_2
    //   241: goto -134 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	c
    //   0	244	1	paramString	String
    //   0	244	2	paramHashMap	HashMap<Long, ArrayList<b>>
    //   5	74	3	l	long
    //   14	216	5	localObject1	Object
    //   31	197	6	localObject2	Object
    //   27	195	7	str	String
    // Exception table:
    //   from	to	target	type
    //   2	16	101	java/lang/Exception
    //   153	158	161	java/lang/Exception
    //   2	16	165	finally
    //   89	93	194	finally
    //   93	98	194	finally
    //   144	148	194	finally
    //   153	158	194	finally
    //   177	182	194	finally
    //   187	192	194	finally
    //   192	194	194	finally
    //   89	93	199	java/lang/Exception
    //   93	98	203	java/lang/Exception
    //   144	148	207	java/lang/Exception
    //   177	182	211	java/lang/Exception
    //   187	192	215	java/lang/Exception
    //   16	26	219	finally
    //   33	38	226	finally
    //   45	50	226	finally
    //   57	89	226	finally
    //   114	140	226	finally
    //   16	26	234	java/lang/Exception
    //   33	38	240	java/lang/Exception
    //   45	50	240	java/lang/Exception
    //   57	89	240	java/lang/Exception
  }
  
  private static void a(List<b> paramList, c.c paramc, SparseArray<String> paramSparseArray)
  {
    int k = 0;
    Object localObject = paramc.eCx;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    label239:
    do
    {
      return;
      if (!((String)localObject).equals("page")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("respective")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("ends")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("continuous")) {
        break;
      }
      i = 3;
      break;
      y.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", new Object[] { paramc });
      paramSparseArray.put(paramc.dCy, bk.pm((String)paramSparseArray.get(paramc.dCy)) + paramc.id + ";");
      return;
      y.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", new Object[] { paramc });
      i = 0;
    } while (i >= paramList.size());
    k = 0;
    int j = i;
    i = k;
    label258:
    if (i < paramc.eCy.size())
    {
      if (!((String)((Pair)paramc.eCy.get(i)).first).equals(((b)paramList.get(j)).eCt)) {
        break label794;
      }
      paramSparseArray.put(paramc.dCy, bk.pm((String)paramSparseArray.get(paramc.dCy)) + paramc.id + ";");
      i = paramc.eCy.size();
      j = paramList.size();
    }
    label778:
    label794:
    for (;;)
    {
      i += 1;
      break label258;
      i = j + 1;
      break label239;
      y.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", new Object[] { paramc });
      if (paramList.size() < 2) {
        break;
      }
      if (paramc.eCy.size() == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        y.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + paramc.eCy.toString());
        return;
      }
      localObject = (String)((Pair)paramc.eCy.get(0)).first;
      String str = (String)((Pair)paramc.eCy.get(1)).first;
      if ((!((b)paramList.get(0)).eCt.equals(localObject)) || (!((b)paramList.get(paramList.size() - 1)).eCt.equals(str))) {
        break;
      }
      paramSparseArray.put(paramc.dCy, bk.pm((String)paramSparseArray.get(paramc.dCy)) + paramc.id + ";");
      return;
      y.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", new Object[] { paramc });
      localObject = paramc.eCy;
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
          if (!((String)((Pair)((List)localObject).get(j)).first).equals(((b)paramList.get(i)).eCt)) {
            break label778;
          }
          if (j == 0)
          {
            j = 1;
            if (j == 0) {
              break;
            }
            paramSparseArray.put(paramc.dCy, bk.pm((String)paramSparseArray.get(paramc.dCy)) + paramc.id + ";");
            return;
          }
          j -= 1;
          i -= 1;
        }
      }
    }
  }
  
  private static boolean a(long paramLong1, float paramFloat, long paramLong2)
  {
    if (b.cqk()) {
      return true;
    }
    if (paramFloat <= 0.0F) {
      return false;
    }
    int i = 10000 / (int)(10000.0F * paramFloat);
    int j = (int)paramLong1;
    j = (j ^ j >> 16) * 73244475;
    j = (j ^ j >> 16) * 73244475;
    j = j >> 16 ^ j;
    int k = j % i;
    long l2 = bk.UX();
    long l1;
    int m;
    if (paramLong2 == 0L)
    {
      l1 = 259200L;
      m = (int)(l2 / l1 % i);
      if (k != m) {
        break label200;
      }
    }
    label200:
    for (boolean bool = true;; bool = false)
    {
      y.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Float.valueOf(paramFloat), Long.valueOf(paramLong2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      return bool;
      l1 = paramLong2;
      break;
    }
  }
  
  private void b(long paramLong, ArrayList<b> paramArrayList, a parama)
  {
    long l4 = bk.UY();
    long l5 = ((b)paramArrayList.get(paramArrayList.size() - 1)).eCu;
    if ((l5 <= 0L) || (l5 > l4))
    {
      y.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", new Object[] { Long.valueOf(l5), Long.valueOf(l4) });
      return;
    }
    long l6 = bk.UX();
    String str = this.eCe + "stg_20971520_" + paramLong + ".HashMap";
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = nq(str);
        ((HashMap)localObject1).put(Long.valueOf(l5), paramArrayList);
        paramArrayList = ((HashMap)localObject1).entrySet().iterator();
        if (paramArrayList.hasNext())
        {
          if (((Long)((Map.Entry)paramArrayList.next()).getKey()).longValue() + 259200000L < l5) {
            paramArrayList.remove();
          }
        }
        else {
          l1 = 3600000L;
        }
      }
      catch (Exception paramArrayList)
      {
        y.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { bk.j(paramArrayList) });
        return;
        a(str, (HashMap)localObject1);
        if (b.cqk())
        {
          l1 = 180000L;
          l2 = bk.a(parama.aak("LAST_REPORT_STATISITIC_TIME"), 0L);
          if (l2 + l1 <= l5) {
            break;
          }
          y.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l1) });
          return;
        }
      }
      catch (OutOfMemoryError paramArrayList)
      {
        com.tencent.mm.a.e.deleteFile(str);
        System.gc();
        y.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramArrayList, "OutOfMemoryError", new Object[0]);
        r(15010, bk.j(paramArrayList));
        return;
      }
    }
    parama.ar("LAST_REPORT_STATISITIC_TIME", l5);
    Object localObject3 = new HashMap();
    paramArrayList = ((HashMap)localObject1).keySet().iterator();
    Object localObject2;
    while (paramArrayList.hasNext())
    {
      localObject2 = (Long)paramArrayList.next();
      if (((Long)localObject2).longValue() > l2) {
        ((HashMap)localObject3).put(localObject2, ((HashMap)localObject1).get(localObject2));
      }
    }
    long l2 = 0L;
    long l1 = 9223372036854775807L;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    Object localObject4 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    int i = 0;
    label514:
    Iterator localIterator;
    if (i < this.eCg.size())
    {
      if (!"pagestat".equals(((c.c)this.eCg.get(i)).eCx)) {
        break label2378;
      }
      paramArrayList = (c.c)this.eCg.get(i);
      y.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", new Object[] { Integer.valueOf(((HashMap)localObject3).size()) });
      localIterator = ((HashMap)localObject3).keySet().iterator();
    }
    for (;;)
    {
      label589:
      Object localObject5;
      long l3;
      if (localIterator.hasNext())
      {
        localObject1 = (Long)localIterator.next();
        if (l1 <= ((Long)localObject1).longValue()) {
          break label2370;
        }
        l1 = ((Long)localObject1).longValue();
        y.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", new Object[] { Long.valueOf(l1), localObject1 });
        localObject5 = (ArrayList)((HashMap)localObject3).get(localObject1);
        l3 = l2 + (((b)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).eCu - ((b)((ArrayList)localObject5).get(0)).time);
        if ((l3 >= 0L) && (l3 <= 172800000L)) {
          break label2387;
        }
        y.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", new Object[] { Long.valueOf(l3) });
      }
      for (;;)
      {
        label699:
        if (i < ((ArrayList)localObject5).size())
        {
          localObject2 = (b)((ArrayList)localObject5).get(i);
          y.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", new Object[] { ((b)localObject2).eCt, Long.valueOf(bk.c((Long)localHashMap1.get(((b)localObject2).eCt))), Long.valueOf(((b)localObject2).eCu), Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).eCu - ((b)localObject2).time) });
          l2 = ((b)localObject2).eCu - ((b)localObject2).time;
          if ((l2 >= 0L) && (l2 <= 86400000L)) {
            break label2367;
          }
          y.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).eCu), Long.valueOf(l4), Long.valueOf(l2) });
          l2 = 0L;
          label884:
          localHashMap1.put(((b)localObject2).eCt, Long.valueOf(l2 + bk.c((Long)localHashMap1.get(((b)localObject2).eCt))));
          localHashMap2.put(((b)localObject2).eCt, Long.valueOf(bk.c((Long)localHashMap2.get(((b)localObject2).eCt)) + 1L));
          if (localObject1 != null)
          {
            localObject1 = ((b)localObject1).eCt + "," + ((b)localObject2).eCt;
            ((HashMap)localObject4).put(localObject1, Long.valueOf(bk.c((Long)((HashMap)localObject4).get(localObject1)) + 1L));
          }
          if (((b)localObject2).eCl == null) {
            break label2402;
          }
          if (localHashMap4.containsKey(((b)localObject2).eCt))
          {
            localObject1 = (Map)localHashMap4.get(((b)localObject2).eCt);
            break label2396;
          }
        }
        for (;;)
        {
          if (j >= ((b)localObject2).eCl.size()) {
            break label2402;
          }
          Object localObject6 = (c.d)((b)localObject2).eCl.get(j);
          ((Map)localObject1).put(((c.d)localObject6).eCA, Long.valueOf(bk.c((Long)((Map)localObject1).get(((c.d)localObject6).eCA)) + 1L));
          j += 1;
          continue;
          localObject1 = new HashMap();
          localHashMap4.put(((b)localObject2).eCt, localObject1);
          break label2396;
          if (paramArrayList == null) {
            break label2415;
          }
          localObject1 = paramArrayList.eCz.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Pair)((Iterator)localObject1).next();
            localObject5 = (String)((Pair)localObject2).first + "," + (String)((Pair)localObject2).second;
            if (((HashMap)localObject4).containsKey(localObject5)) {
              localHashMap3.put(((Pair)localObject2).second, ((HashMap)localObject4).get(localObject5));
            }
          }
          l3 = ((b)((ArrayList)((HashMap)localObject3).get(Long.valueOf(l1))).get(0)).time;
          y.i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
          if ((l3 > l4) || (l3 < 0L))
          {
            y.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
            return;
          }
          i = 0;
          for (;;)
          {
            try
            {
              if (i >= this.eCg.size()) {
                break label2362;
              }
              if (!"appstat".equals(((c.c)this.eCg.get(i)).eCx)) {
                continue;
              }
              paramArrayList = (c.c)this.eCg.get(i);
              y.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", new Object[] { Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(l2) });
              if ((paramArrayList == null) || (l5 - l3 - l2 < 0L)) {
                continue;
              }
              if ((paramArrayList.eCv <= l6) || (!a(paramLong, paramArrayList.eCw, this.eCk))) {
                continue;
              }
              y.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = bk.g(parama.aal("SEQ_" + paramArrayList.dCy));
              parama.dq("SEQ_" + paramArrayList.dCy, i + 1);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 5).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("in", l2 / 1000L).put("inbg", (l5 - l3 - l2) / 1000L).put("swc", ((HashMap)localObject3).size());
              a(paramArrayList.dCy, paramArrayList.id, i, ((JSONObject)localObject1).toString());
            }
            catch (Exception paramArrayList)
            {
              r(15006, bk.j(paramArrayList));
              y.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", new Object[] { bk.j(paramArrayList) });
              continue;
              y.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", new Object[] { paramArrayList, Long.valueOf(l5 - l3 - l2) });
              continue;
              i += 1;
              continue;
              ((JSONObject)localObject2).put("wa", localObject3);
              parama.put(localObject2);
              continue;
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 6).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("pa", parama);
              a(paramArrayList.dCy, paramArrayList.id, i, ((JSONObject)localObject1).toString());
              return;
            }
            i = 0;
            try
            {
              if (i >= this.eCg.size()) {
                break label2357;
              }
              if (!"pagestat".equals(((c.c)this.eCg.get(i)).eCx)) {
                continue;
              }
              paramArrayList = (c.c)this.eCg.get(i);
              if (paramArrayList == null) {
                break label2348;
              }
              if ((paramArrayList.eCv <= l6) || (!a(paramLong, paramArrayList.eCw, this.eCk))) {
                break label2323;
              }
              y.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = bk.g(parama.aal("SEQ_" + paramArrayList.dCy));
              parama.dq("SEQ_" + paramArrayList.dCy, i + 1);
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
              r(15007, bk.j(paramArrayList));
              y.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { bk.j(paramArrayList) });
              return;
            }
            continue;
            y.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            continue;
            label2323:
            y.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            return;
            label2348:
            y.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
            return;
            label2357:
            paramArrayList = null;
            continue;
            label2362:
            paramArrayList = null;
          }
          label2367:
          break label884;
          label2370:
          break label589;
          paramArrayList = null;
          break label514;
          label2378:
          i += 1;
          break;
          label2387:
          i = 0;
          localObject1 = null;
          break label699;
          label2396:
          int j = 0;
        }
        label2402:
        i += 1;
        localObject1 = localObject2;
      }
      label2415:
      l2 = l3;
    }
  }
  
  private static String bC(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.importance == 100) && ((localRunningAppProcessInfo.processName.equals("com.tencent.mm")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:tools")) || (localRunningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))))
        {
          i = 1;
          if (i != 0) {
            break label109;
          }
          paramContext = "";
        }
      }
    }
    for (;;)
    {
      return paramContext;
      i = 0;
      break;
      try
      {
        label109:
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramContext = paramContext.getAppTasks();
          if ((paramContext == null) || (paramContext.size() <= 0)) {
            break label298;
          }
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
            if (paramContext == null) {
              return null;
            }
            localObject = paramContext.getClassName();
            paramContext = (Context)localObject;
            if (!((String)localObject).contains(".")) {
              continue;
            }
            return ((String)localObject).substring(((String)localObject).lastIndexOf(".") + 1);
          }
        }
        else
        {
          localObject = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
          paramContext = (Context)localObject;
          if (!((String)localObject).contains(".")) {
            continue;
          }
          paramContext = ((String)localObject).substring(((String)localObject).lastIndexOf(".") + 1);
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bk.j(paramContext) });
      }
    }
    return "";
    label298:
    return "";
  }
  
  private int c(long paramLong, int paramInt1, int paramInt2)
  {
    int i;
    if ((this.eCl == null) || (this.eCl.isEmpty())) {
      i = -1;
    }
    do
    {
      return i;
      i = (paramInt1 + paramInt2) / 2;
      if ((paramInt2 - paramInt1 != 0) && (paramInt2 - paramInt1 != 1)) {
        break;
      }
      i = paramInt2;
    } while (paramLong >= ((c.d)this.eCl.get(paramInt2)).time);
    return paramInt1;
    if (paramLong < ((c.d)this.eCl.get(i)).time) {
      return c(paramLong, paramInt1, i);
    }
    if (paramLong > ((c.d)this.eCl.get(i)).time) {
      return c(paramLong, i, paramInt2);
    }
    return i;
  }
  
  private static boolean cd(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private static String ce(long paramLong)
  {
    if (paramLong < 100000000000L) {
      return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(paramLong * 1000L));
    }
    return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(paramLong)) + String.format(Locale.getDefault(), ".%03d", new Object[] { Long.valueOf(paramLong % 1000L) });
  }
  
  private Pair<Integer, ArrayList<b>> g(ArrayList<b> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    long l2 = bk.UY();
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
            y.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", new Object[] { Long.valueOf(((b)localObject1).time), Long.valueOf(l2 - ((b)localObject1).time), Integer.valueOf(((b)localObject1).bMC), ((b)localObject1).eCt });
            return null;
          }
          if (((b)localObject1).bMC == 4)
          {
            if (l1 >= ((b)localObject1).time) {
              break label659;
            }
            l1 = ((b)localObject1).time;
            break label652;
          }
          if (((b)localObject1).bMC != 3)
          {
            y.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", new Object[] { Integer.valueOf(((b)localObject1).bMC), ((b)localObject1).eCt });
            return null;
          }
          ((ArrayList)localObject2).add(localObject1);
          break label659;
        }
        if (((ArrayList)localObject2).size() == 0) {
          return null;
        }
        Collections.sort((List)localObject2);
        Collections.sort(this.eCl);
        localObject1 = new b();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (b)localIterator.next();
        if (((b)localObject2).eCt.equals(((b)localObject1).eCt))
        {
          if (((b)localObject2).time - ((b)localObject1).time <= 10800000L) {
            continue;
          }
          y.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject1).time) });
          ((b)localObject1).time = ((b)localObject2).time;
          continue;
        }
        a((b)localObject1, ((b)localObject2).elapsedTime);
      }
      catch (Exception paramArrayList)
      {
        r(15008, bk.j(paramArrayList));
        y.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", new Object[] { bk.j(paramArrayList) });
        return null;
      }
      localArrayList.add(localObject2);
      ((b)localObject1).eCu = ((b)localObject2).time;
      localObject1 = localObject2;
    }
    if (!localArrayList.isEmpty()) {
      a((b)localArrayList.get(localArrayList.size() - 1), l1);
    }
    ((b)localObject1).eCu = ((b)paramArrayList.get(paramArrayList.size() - 1)).time;
    if (((b)localArrayList.get(localArrayList.size() - 1)).time > l1) {
      ((b)localArrayList.get(localArrayList.size() - 1)).eCu = l2;
    }
    while (((b)localArrayList.get(localArrayList.size() - 1)).eCu - ((b)localArrayList.get(0)).time > 50400000L)
    {
      y.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
      return null;
      if (l1 > l2) {
        ((b)localArrayList.get(localArrayList.size() - 1)).eCu = l2;
      }
    }
    y.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(localArrayList.size()), Long.valueOf(bk.co(l2)) });
    paramArrayList = Pair.create(Integer.valueOf(0), localArrayList);
    return paramArrayList;
    label652:
    label659:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UseSparseArrays"})
  private static HashMap<Long, ArrayList<b>> nq(String paramString)
  {
    // Byte code:
    //   0: invokestatic 306	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   3: lstore_1
    //   4: new 542	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 543	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 546	java/io/File:exists	()Z
    //   17: ifeq +12 -> 29
    //   20: aload_3
    //   21: invokevirtual 1092	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifgt +27 -> 53
    //   29: ldc 186
    //   31: ldc_w 1094
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: aastore
    //   42: invokestatic 1096	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: new 68	java/util/HashMap
    //   48: dup
    //   49: invokespecial 69	java/util/HashMap:<init>	()V
    //   52: areturn
    //   53: new 1098	java/io/FileInputStream
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 1101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_3
    //   62: new 1103	java/io/ObjectInputStream
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 1106	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: aload_0
    //   72: astore 5
    //   74: aload_3
    //   75: astore 4
    //   77: aload_0
    //   78: invokevirtual 1109	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 68	java/util/HashMap
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: aload_3
    //   90: astore 4
    //   92: ldc 186
    //   94: ldc_w 1111
    //   97: iconst_2
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload 6
    //   105: invokevirtual 777	java/util/HashMap:size	()I
    //   108: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: lload_1
    //   115: invokestatic 719	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   118: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: aastore
    //   122: invokestatic 200	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: aload_0
    //   126: invokevirtual 1112	java/io/ObjectInputStream:close	()V
    //   129: aload_3
    //   130: invokevirtual 1113	java/io/FileInputStream:close	()V
    //   133: aload 6
    //   135: areturn
    //   136: astore_0
    //   137: aload 6
    //   139: areturn
    //   140: astore 6
    //   142: aconst_null
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_0
    //   147: astore 5
    //   149: aload_3
    //   150: astore 4
    //   152: ldc 186
    //   154: ldc_w 1115
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload 6
    //   165: invokevirtual 1116	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload 6
    //   173: invokestatic 222	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   176: aastore
    //   177: invokestatic 231	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 1112	java/io/ObjectInputStream:close	()V
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 1113	java/io/FileInputStream:close	()V
    //   196: new 68	java/util/HashMap
    //   199: dup
    //   200: invokespecial 69	java/util/HashMap:<init>	()V
    //   203: areturn
    //   204: astore_0
    //   205: aconst_null
    //   206: astore 5
    //   208: aconst_null
    //   209: astore_3
    //   210: aload 5
    //   212: ifnull +8 -> 220
    //   215: aload 5
    //   217: invokevirtual 1112	java/io/ObjectInputStream:close	()V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 1113	java/io/FileInputStream:close	()V
    //   228: aload_0
    //   229: athrow
    //   230: astore_0
    //   231: goto -102 -> 129
    //   234: astore_0
    //   235: goto -47 -> 188
    //   238: astore_0
    //   239: goto -43 -> 196
    //   242: astore 4
    //   244: goto -24 -> 220
    //   247: astore_3
    //   248: goto -20 -> 228
    //   251: astore_0
    //   252: aconst_null
    //   253: astore 5
    //   255: goto -45 -> 210
    //   258: astore_0
    //   259: aload 4
    //   261: astore_3
    //   262: goto -52 -> 210
    //   265: astore 6
    //   267: aconst_null
    //   268: astore_0
    //   269: goto -123 -> 146
    //   272: astore 6
    //   274: goto -128 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramString	String
    //   3	112	1	l	long
    //   12	213	3	localObject1	Object
    //   247	1	3	localException1	Exception
    //   261	1	3	localObject2	Object
    //   75	76	4	localObject3	Object
    //   242	18	4	localException2	Exception
    //   72	182	5	str	String
    //   84	54	6	localHashMap	HashMap
    //   140	32	6	localThrowable1	Throwable
    //   265	1	6	localThrowable2	Throwable
    //   272	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   129	133	136	java/lang/Exception
    //   4	29	140	java/lang/Throwable
    //   29	53	140	java/lang/Throwable
    //   53	62	140	java/lang/Throwable
    //   4	29	204	finally
    //   29	53	204	finally
    //   53	62	204	finally
    //   125	129	230	java/lang/Exception
    //   184	188	234	java/lang/Exception
    //   192	196	238	java/lang/Exception
    //   215	220	242	java/lang/Exception
    //   224	228	247	java/lang/Exception
    //   62	71	251	finally
    //   77	86	258	finally
    //   92	125	258	finally
    //   152	180	258	finally
    //   62	71	265	java/lang/Throwable
    //   77	86	272	java/lang/Throwable
    //   92	125	272	java/lang/Throwable
  }
  
  private static void r(int paramInt, String paramString)
  {
    f.nEG.aC(13328, paramInt + ",0,0,0,0,0,0,0,0,0,0,0,0," + paramString);
  }
  
  public final void commitNow()
  {
    long l = bk.UY();
    y.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", new Object[] { (Boolean)new c.2(this, Boolean.valueOf(false)).b(this.handler), Long.valueOf(bk.co(l)) });
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.d("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.e("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.i("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
  }
  
  public final void j(Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT"))) {
      return;
    }
    this.handler.post(new c.3(this, paramIntent));
  }
  
  public void onEvent(AccessibilityCapture.Event paramEvent)
  {
    if ((paramEvent == null) || (paramEvent.view == null) || (paramEvent.activity == null)) {}
    do
    {
      do
      {
        return;
      } while (paramEvent.activity.getComponentName() == null);
      localObject2 = paramEvent.activity.getComponentName().getShortClassName();
      localObject1 = localObject2;
      if (((String)localObject2).contains(".")) {
        localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1);
      }
    } while ((!this.eCh) && (!this.eCi.containsKey(localObject1)));
    Object localObject1 = new c.d();
    long l = System.currentTimeMillis();
    ((c.d)localObject1).eCA = Integer.toHexString(paramEvent.view.getId());
    ((c.d)localObject1).type = paramEvent.event.getEventType();
    ((c.d)localObject1).time = paramEvent.elapsedTime;
    this.eCl.add(localObject1);
    Object localObject2 = new int[2];
    paramEvent.view.getLocationOnScreen((int[])localObject2);
    ((c.d)localObject1).left = localObject2[0];
    ((c.d)localObject1).top = localObject2[1];
    y.d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + ((c.d)localObject1).eCA + ",ui:" + paramEvent.activity.getComponentName().getShortClassName() + ",left:" + ((c.d)localObject1).left + ",top:" + ((c.d)localObject1).top + ",time:" + ((c.d)localObject1).time + ",cost:" + (System.currentTimeMillis() - l));
  }
  
  public void post(Runnable paramRunnable, String paramString)
  {
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
  }
  
  public void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    y.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramThrowable, paramString2, paramVarArgs);
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    y.v("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
  }
  
  static final class b
    implements Serializable, Comparable<b>
  {
    int bMC = 0;
    List<c.d> eCl = null;
    String eCt = null;
    long eCu;
    long elapsedTime = 0L;
    long time = 0L;
    
    public final String toString()
    {
      return String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[] { this.eCt, Integer.valueOf(this.bMC), c.cf(this.time) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.c
 * JD-Core Version:    0.7.0.1
 */