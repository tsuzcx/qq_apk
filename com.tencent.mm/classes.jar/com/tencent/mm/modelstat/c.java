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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.mm.accessibility.AccessibilityCapture.Event;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static c fRR;
  private ap fRS;
  private final int fRT;
  private ArrayList<b> fRU;
  private String fRV;
  private long fRW;
  private ArrayList<c.c> fRX;
  private boolean fRY;
  private Map<String, Boolean> fRZ;
  private long fSa;
  private long fSb;
  private List<c.d> fSc;
  private ak handler;
  
  private c()
  {
    AppMethodBeat.i(78678);
    this.handler = null;
    this.fRS = null;
    this.fRT = 20971520;
    this.fRU = new ArrayList();
    this.fRV = null;
    this.fRW = 0L;
    this.fRX = new ArrayList();
    this.fRY = false;
    this.fRZ = new HashMap();
    this.fSa = 0L;
    this.fSb = 0L;
    this.fSc = new ArrayList();
    if (b.dsf()) {
      Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", ah.brt());
    }
    HandlerThread localHandlerThread = d.aqu("ClickFlow");
    localHandlerThread.start();
    this.handler = new ak(localHandlerThread.getLooper());
    this.fRS = new ap(localHandlerThread.getLooper(), new c.1(this), true);
    AppMethodBeat.o(78678);
  }
  
  private static void A(int paramInt, String paramString)
  {
    AppMethodBeat.i(78684);
    com.tencent.mm.plugin.report.e.qrI.kvStat(13328, paramInt + ",0,0,0,0,0,0,0,0,0,0,0,0," + paramString);
    AppMethodBeat.o(78684);
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, a parama)
  {
    AppMethodBeat.i(78688);
    long l1 = ((b)paramArrayList.get(0)).time;
    long l2 = ((b)paramArrayList.get(paramArrayList.size() - 1)).fSl;
    long l3 = bo.aox();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.fRX.size()) {
          break label280;
        }
        if (!"app".equals(((c.c)this.fRX.get(i)).fSo)) {
          break label285;
        }
        paramArrayList = (c.c)this.fRX.get(i);
        if (paramArrayList != null)
        {
          if ((paramArrayList.fSm > l3) && (a(paramLong, paramArrayList.fSn, this.fSb)))
          {
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
            a(parama, paramArrayList.ezN, paramArrayList.id, l1, l2);
            AppMethodBeat.o(78688);
            return;
          }
          ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
          AppMethodBeat.o(78688);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        A(15004, bo.l(paramArrayList));
        ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", new Object[] { bo.l(paramArrayList) });
        AppMethodBeat.o(78688);
        return;
      }
      ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
      if (gZ(paramLong))
      {
        a(parama, 13604, 100001, l1, l2);
        AppMethodBeat.o(78688);
        return;
      }
      ab.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
      AppMethodBeat.o(78688);
      return;
      label280:
      paramArrayList = null;
      continue;
      label285:
      i += 1;
    }
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, a parama, int paramInt)
  {
    AppMethodBeat.i(78690);
    for (;;)
    {
      Object localObject1;
      int i;
      JSONObject localJSONObject1;
      int j;
      try
      {
        long l = bo.aoy();
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramArrayList.size())
        {
          localJSONObject1 = new JSONObject();
          localObject2 = (b)paramArrayList.get(i);
          if ((((b)localObject2).fSl < ((b)localObject2).time) || (((b)localObject2).time < 0L) || (((b)localObject2).fSl < 0L) || (((b)localObject2).fSl > l) || (((b)localObject2).time > l))
          {
            ab.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).fSl), Long.valueOf(l) });
            AppMethodBeat.o(78690);
            return;
          }
          localJSONObject1.put("p", ((b)localObject2).fSk).put("tbe", ((b)localObject2).time / 1000L).put("in", (((b)localObject2).fSl - ((b)localObject2).time) / 1000L);
          if ((((b)localObject2).fSc != null) && (!((b)localObject2).fSc.isEmpty()))
          {
            JSONArray localJSONArray = new JSONArray();
            j = 0;
            if (j < ((b)localObject2).fSc.size())
            {
              c.d locald = (c.d)((b)localObject2).fSc.get(j);
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("w", locald.fSr).put("t", locald.type).put("tbp", "{" + locald.left + ";" + locald.top + "}");
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
        if (gZ(paramLong))
        {
          paramInt = bo.g(parama.aqp("SEQ_13604"));
          parama.ex("SEQ_13604", paramInt + 1);
          b(13604, "100002", paramInt, localJSONObject1.toString());
        }
        localObject1 = new SparseArray();
        if (this.fRX.size() != 0) {
          break label747;
        }
        ab.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        A(15005, bo.l(paramArrayList));
        ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", new Object[] { bo.l(paramArrayList) });
        AppMethodBeat.o(78690);
        return;
      }
      if (paramInt < this.fRX.size())
      {
        localObject2 = (c.c)this.fRX.get(paramInt);
        if ((((c.c)localObject2).fSm > bo.aox()) && (a(paramLong, ((c.c)localObject2).fSn, this.fSb))) {
          a(paramArrayList, (c.c)localObject2, (SparseArray)localObject1);
        } else {
          ab.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", new Object[] { localObject2, Long.valueOf(bo.aox()) });
        }
      }
      else
      {
        paramInt = 0;
        while (paramInt < ((SparseArray)localObject1).size())
        {
          i = ((SparseArray)localObject1).keyAt(paramInt);
          paramArrayList = (String)((SparseArray)localObject1).get(i);
          j = bo.g(parama.aqp("SEQ_".concat(String.valueOf(i))));
          parama.ex("SEQ_".concat(String.valueOf(i)), j + 1);
          b(i, paramArrayList, j, localJSONObject1.toString());
          paramInt += 1;
        }
        AppMethodBeat.o(78690);
        return;
        label747:
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(78685);
    this.fSa = parama.fSa;
    if ((this.fSa <= 0L) || (this.fSa > 432000L)) {
      this.fSa = 432000L;
    }
    this.fSb = parama.fSb;
    this.fRX.clear();
    this.fRX.addAll(parama.fSj);
    this.fRZ.clear();
    this.fRZ.putAll(parama.fRZ);
    if ((this.fRZ.containsKey("*")) && (((Boolean)this.fRZ.get("*")).booleanValue())) {
      this.fRY = true;
    }
    ab.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", new Object[] { Integer.valueOf(this.fRX.size()), Long.valueOf(this.fSa), Long.valueOf(this.fSb) });
    AppMethodBeat.o(78685);
  }
  
  private void a(b paramb, long paramLong)
  {
    AppMethodBeat.i(78682);
    if (paramb.elapsedTime <= 0L)
    {
      AppMethodBeat.o(78682);
      return;
    }
    long l = paramb.elapsedTime;
    if (this.fSc.isEmpty()) {}
    for (int i = 0;; i = this.fSc.size() - 1)
    {
      i = c(l, 0, i);
      if (i == -1) {
        break;
      }
      if (paramb.fSc == null) {
        paramb.fSc = new ArrayList();
      }
      int j = this.fSc.size();
      while (i < j)
      {
        c.d locald = (c.d)this.fSc.get(i);
        if ((locald.time > paramb.elapsedTime) && (locald.time <= paramLong)) {
          paramb.fSc.add(locald);
        }
        if (locald.time >= paramLong) {
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(78682);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(78689);
    long l1 = bo.aoy();
    if ((paramLong1 > paramLong2) || (paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong1 > l1) || (paramLong2 > l1))
    {
      ab.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1) });
      AppMethodBeat.o(78689);
      return;
    }
    int i = bo.g(parama.aqp("SEQ_".concat(String.valueOf(paramInt1))));
    parama.ex("SEQ_".concat(String.valueOf(paramInt1)), i + 1);
    long l2 = bo.c(parama.aqo("LastQuit_".concat(String.valueOf(paramInt2))));
    parama.aZ("LastQuit_".concat(String.valueOf(paramInt2)), paramLong2);
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
    AppMethodBeat.o(78689);
  }
  
  /* Error */
  private void a(String paramString, HashMap<Long, ArrayList<b>> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 730
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 269	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   11: lstore_3
    //   12: new 732	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 733	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore 5
    //   22: new 735	java/io/ObjectOutputStream
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 738	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore 7
    //   35: aload 5
    //   37: astore 6
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 742	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   44: aload_1
    //   45: astore 7
    //   47: aload 5
    //   49: astore 6
    //   51: aload 5
    //   53: invokevirtual 745	java/io/FileOutputStream:flush	()V
    //   56: aload_1
    //   57: astore 7
    //   59: aload 5
    //   61: astore 6
    //   63: ldc 215
    //   65: ldc_w 747
    //   68: iconst_2
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_2
    //   75: invokevirtual 748	java/util/HashMap:size	()I
    //   78: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: lload_3
    //   85: invokestatic 697	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   88: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: aastore
    //   92: invokestatic 228	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokevirtual 751	java/io/ObjectOutputStream:close	()V
    //   99: aload 5
    //   101: invokevirtual 752	java/io/FileOutputStream:close	()V
    //   104: ldc_w 730
    //   107: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_1
    //   114: ldc_w 730
    //   117: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -10 -> 110
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aconst_null
    //   132: astore 5
    //   134: aload_1
    //   135: astore 7
    //   137: aload 5
    //   139: astore 6
    //   141: ldc 215
    //   143: ldc_w 754
    //   146: iconst_2
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_2
    //   153: invokevirtual 755	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload_2
    //   160: invokestatic 243	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 250	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 751	java/io/ObjectOutputStream:close	()V
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 752	java/io/FileOutputStream:close	()V
    //   185: ldc_w 730
    //   188: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: goto -81 -> 110
    //   194: astore_1
    //   195: ldc_w 730
    //   198: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: goto -91 -> 110
    //   204: astore_1
    //   205: aconst_null
    //   206: astore 7
    //   208: aconst_null
    //   209: astore 5
    //   211: aload 7
    //   213: ifnull +8 -> 221
    //   216: aload 7
    //   218: invokevirtual 751	java/io/ObjectOutputStream:close	()V
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 752	java/io/FileOutputStream:close	()V
    //   231: ldc_w 730
    //   234: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: goto -141 -> 99
    //   243: astore_1
    //   244: goto -69 -> 175
    //   247: astore_2
    //   248: goto -27 -> 221
    //   251: astore_2
    //   252: goto -21 -> 231
    //   255: astore_1
    //   256: aconst_null
    //   257: astore 7
    //   259: goto -48 -> 211
    //   262: astore_1
    //   263: aload 6
    //   265: astore 5
    //   267: goto -56 -> 211
    //   270: astore_2
    //   271: aconst_null
    //   272: astore_1
    //   273: goto -139 -> 134
    //   276: astore_2
    //   277: goto -143 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	c
    //   0	280	1	paramString	String
    //   0	280	2	paramHashMap	HashMap<Long, ArrayList<b>>
    //   11	74	3	l	long
    //   20	246	5	localObject1	Object
    //   37	227	6	localObject2	Object
    //   33	225	7	str	String
    // Exception table:
    //   from	to	target	type
    //   99	104	113	java/lang/Exception
    //   2	8	123	finally
    //   95	99	123	finally
    //   99	104	123	finally
    //   104	110	123	finally
    //   114	120	123	finally
    //   171	175	123	finally
    //   180	185	123	finally
    //   185	191	123	finally
    //   195	201	123	finally
    //   216	221	123	finally
    //   226	231	123	finally
    //   231	239	123	finally
    //   8	22	128	java/lang/Exception
    //   180	185	194	java/lang/Exception
    //   8	22	204	finally
    //   95	99	239	java/lang/Exception
    //   171	175	243	java/lang/Exception
    //   216	221	247	java/lang/Exception
    //   226	231	251	java/lang/Exception
    //   22	32	255	finally
    //   39	44	262	finally
    //   51	56	262	finally
    //   63	95	262	finally
    //   141	167	262	finally
    //   22	32	270	java/lang/Exception
    //   39	44	276	java/lang/Exception
    //   51	56	276	java/lang/Exception
    //   63	95	276	java/lang/Exception
  }
  
  private static void a(List<b> paramList, c.c paramc, SparseArray<String> paramSparseArray)
  {
    int k = 0;
    AppMethodBeat.i(78687);
    Object localObject = paramc.fSo;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(78687);
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
    ab.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", new Object[] { paramc });
    paramSparseArray.put(paramc.ezN, bo.nullAsNil((String)paramSparseArray.get(paramc.ezN)) + paramc.id + ";");
    AppMethodBeat.o(78687);
    return;
    ab.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", new Object[] { paramc });
    i = 0;
    label256:
    int j;
    if (i < paramList.size())
    {
      k = 0;
      j = i;
      i = k;
      label275:
      if (i < paramc.fSp.size())
      {
        if (!((String)((Pair)paramc.fSp.get(i)).first).equals(((b)paramList.get(j)).fSk)) {
          break label835;
        }
        paramSparseArray.put(paramc.ezN, bo.nullAsNil((String)paramSparseArray.get(paramc.ezN)) + paramc.id + ";");
        i = paramc.fSp.size();
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
      AppMethodBeat.o(78687);
      return;
      ab.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", new Object[] { paramc });
      if (paramList.size() < 2) {
        break;
      }
      if (paramc.fSp.size() == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        ab.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + paramc.fSp.toString());
        AppMethodBeat.o(78687);
        return;
      }
      localObject = (String)((Pair)paramc.fSp.get(0)).first;
      String str = (String)((Pair)paramc.fSp.get(1)).first;
      if ((!((b)paramList.get(0)).fSk.equals(localObject)) || (!((b)paramList.get(paramList.size() - 1)).fSk.equals(str))) {
        break;
      }
      paramSparseArray.put(paramc.ezN, bo.nullAsNil((String)paramSparseArray.get(paramc.ezN)) + paramc.id + ";");
      AppMethodBeat.o(78687);
      return;
      ab.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", new Object[] { paramc });
      localObject = paramc.fSp;
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
          if (!((String)((Pair)((List)localObject).get(j)).first).equals(((b)paramList.get(i)).fSk)) {
            break label819;
          }
          if (j == 0)
          {
            j = 1;
            if (j == 0) {
              break;
            }
            paramSparseArray.put(paramc.ezN, bo.nullAsNil((String)paramSparseArray.get(paramc.ezN)) + paramc.id + ";");
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
    AppMethodBeat.i(78686);
    if (b.dsf())
    {
      AppMethodBeat.o(78686);
      return true;
    }
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(78686);
      return false;
    }
    int i = 10000 / (int)(10000.0F * paramFloat);
    int j = (int)paramLong1;
    j = (j ^ j >> 16) * 73244475;
    j = (j ^ j >> 16) * 73244475;
    j = j >> 16 ^ j;
    int k = j % i;
    long l2 = bo.aox();
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
      ab.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Float.valueOf(paramFloat), Long.valueOf(paramLong2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      AppMethodBeat.o(78686);
      return bool;
      l1 = paramLong2;
      break;
    }
  }
  
  public static c akw()
  {
    AppMethodBeat.i(78670);
    if (fRR == null) {}
    try
    {
      if (fRR == null) {
        fRR = new c();
      }
      c localc = fRR;
      AppMethodBeat.o(78670);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(78670);
    }
  }
  
  private static void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(78694);
    try
    {
      paramString2 = paramString2.replace(",", ";");
      int j = (int)Math.ceil(paramString2.length() / 6000.0D);
      int i = 0;
      while (i < j)
      {
        String str = paramString1 + "," + paramInt2 + "," + i + "," + j + ",0,0,," + paramString2.substring(i * 6000, Math.min((i + 1) * 6000, paramString2.length()));
        ab.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, str });
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(346L, 4L, 1L, false);
        com.tencent.mm.plugin.report.e.qrI.a(paramInt1, str, true, true);
        i += 1;
      }
      AppMethodBeat.o(78694);
      return;
    }
    catch (Exception paramString1)
    {
      A(15009, bo.l(paramString1));
      ab.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", new Object[] { bo.l(paramString1) });
      AppMethodBeat.o(78694);
    }
  }
  
  private void b(long paramLong, ArrayList<b> paramArrayList, a parama)
  {
    AppMethodBeat.i(78691);
    long l4 = bo.aoy();
    long l5 = ((b)paramArrayList.get(paramArrayList.size() - 1)).fSl;
    if ((l5 <= 0L) || (l5 > l4))
    {
      ab.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", new Object[] { Long.valueOf(l5), Long.valueOf(l4) });
      AppMethodBeat.o(78691);
      return;
    }
    long l6 = bo.aox();
    String str = this.fRV + "stg_20971520_" + paramLong + ".HashMap";
    Object localObject1;
    long l2;
    Object localObject3;
    Object localObject2;
    try
    {
      localObject1 = uE(str);
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
      ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { bo.l(paramArrayList) });
      AppMethodBeat.o(78691);
      return;
      a(str, (HashMap)localObject1);
      if (b.dsf()) {}
      for (l1 = 180000L;; l1 = 3600000L)
      {
        l2 = bo.a(parama.aqo("LAST_REPORT_STATISITIC_TIME"), 0L);
        if (l2 + l1 <= l5) {
          break;
        }
        ab.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l1) });
        AppMethodBeat.o(78691);
        return;
      }
      parama.aZ("LAST_REPORT_STATISITIC_TIME", l5);
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
      com.tencent.mm.a.e.deleteFile(str);
      System.gc();
      ab.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramArrayList, "OutOfMemoryError", new Object[0]);
      A(15010, bo.l(paramArrayList));
      AppMethodBeat.o(78691);
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
    if (i < this.fRX.size()) {
      if ("pagestat".equals(((c.c)this.fRX.get(i)).fSo))
      {
        paramArrayList = (c.c)this.fRX.get(i);
        ab.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", new Object[] { Integer.valueOf(((HashMap)localObject3).size()) });
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
        ab.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", new Object[] { Long.valueOf(l1), localObject1 });
        localObject5 = (ArrayList)((HashMap)localObject3).get(localObject1);
        l3 = l2 + (((b)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).fSl - ((b)((ArrayList)localObject5).get(0)).time);
        if ((l3 < 0L) || (l3 > 172800000L))
        {
          ab.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", new Object[] { Long.valueOf(l3) });
          AppMethodBeat.o(78691);
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
          ab.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", new Object[] { ((b)localObject2).fSk, Long.valueOf(bo.c((Long)localHashMap1.get(((b)localObject2).fSk))), Long.valueOf(((b)localObject2).fSl), Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).fSl - ((b)localObject2).time) });
          l2 = ((b)localObject2).fSl - ((b)localObject2).time;
          if ((l2 >= 0L) && (l2 <= 86400000L)) {
            break label2450;
          }
          ab.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).fSl), Long.valueOf(l4), Long.valueOf(l2) });
          l2 = 0L;
          label935:
          localHashMap1.put(((b)localObject2).fSk, Long.valueOf(l2 + bo.c((Long)localHashMap1.get(((b)localObject2).fSk))));
          localHashMap2.put(((b)localObject2).fSk, Long.valueOf(bo.c((Long)localHashMap2.get(((b)localObject2).fSk)) + 1L));
          if (localObject1 != null)
          {
            localObject1 = ((b)localObject1).fSk + "," + ((b)localObject2).fSk;
            ((HashMap)localObject4).put(localObject1, Long.valueOf(bo.c((Long)((HashMap)localObject4).get(localObject1)) + 1L));
          }
          if (((b)localObject2).fSc == null) {
            break label2467;
          }
          if (localHashMap4.containsKey(((b)localObject2).fSk))
          {
            localObject1 = (Map)localHashMap4.get(((b)localObject2).fSk);
            break label2461;
          }
        }
        for (;;)
        {
          if (j >= ((b)localObject2).fSc.size()) {
            break label2467;
          }
          Object localObject6 = (c.d)((b)localObject2).fSc.get(j);
          ((Map)localObject1).put(((c.d)localObject6).fSr, Long.valueOf(bo.c((Long)((Map)localObject1).get(((c.d)localObject6).fSr)) + 1L));
          j += 1;
          continue;
          localObject1 = new HashMap();
          localHashMap4.put(((b)localObject2).fSk, localObject1);
          break label2461;
          if (paramArrayList == null) {
            break label2480;
          }
          localObject1 = paramArrayList.fSq.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Pair)((Iterator)localObject1).next();
            localObject5 = (String)((Pair)localObject2).first + "," + (String)((Pair)localObject2).second;
            if (((HashMap)localObject4).containsKey(localObject5)) {
              localHashMap3.put(((Pair)localObject2).second, ((HashMap)localObject4).get(localObject5));
            }
          }
          l3 = ((b)((ArrayList)((HashMap)localObject3).get(Long.valueOf(l1))).get(0)).time;
          ab.i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
          if ((l3 > l4) || (l3 < 0L))
          {
            ab.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
            AppMethodBeat.o(78691);
            return;
          }
          i = 0;
          for (;;)
          {
            try
            {
              if (i >= this.fRX.size()) {
                break label2445;
              }
              if (!"appstat".equals(((c.c)this.fRX.get(i)).fSo)) {
                continue;
              }
              paramArrayList = (c.c)this.fRX.get(i);
              ab.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", new Object[] { Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(l2) });
              if ((paramArrayList == null) || (l5 - l3 - l2 < 0L)) {
                continue;
              }
              if ((paramArrayList.fSm <= l6) || (!a(paramLong, paramArrayList.fSn, this.fSb))) {
                continue;
              }
              ab.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = bo.g(parama.aqp("SEQ_" + paramArrayList.ezN));
              parama.ex("SEQ_" + paramArrayList.ezN, i + 1);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 5).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("in", l2 / 1000L).put("inbg", (l5 - l3 - l2) / 1000L).put("swc", ((HashMap)localObject3).size());
              b(paramArrayList.ezN, paramArrayList.id, i, ((JSONObject)localObject1).toString());
            }
            catch (Exception paramArrayList)
            {
              A(15006, bo.l(paramArrayList));
              ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", new Object[] { bo.l(paramArrayList) });
              continue;
              ab.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", new Object[] { paramArrayList, Long.valueOf(l5 - l3 - l2) });
              continue;
              i += 1;
              continue;
              ((JSONObject)localObject2).put("wa", localObject3);
              parama.put(localObject2);
              continue;
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 6).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("pa", parama);
              b(paramArrayList.ezN, paramArrayList.id, i, ((JSONObject)localObject1).toString());
              AppMethodBeat.o(78691);
              return;
            }
            i = 0;
            try
            {
              if (i >= this.fRX.size()) {
                break label2440;
              }
              if (!"pagestat".equals(((c.c)this.fRX.get(i)).fSo)) {
                continue;
              }
              paramArrayList = (c.c)this.fRX.get(i);
              if (paramArrayList == null) {
                break label2425;
              }
              if ((paramArrayList.fSm <= l6) || (!a(paramLong, paramArrayList.fSn, this.fSb))) {
                break label2394;
              }
              ab.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = bo.g(parama.aqp("SEQ_" + paramArrayList.ezN));
              parama.ex("SEQ_" + paramArrayList.ezN, i + 1);
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
              A(15007, bo.l(paramArrayList));
              ab.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { bo.l(paramArrayList) });
              AppMethodBeat.o(78691);
              return;
            }
            continue;
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            continue;
            label2394:
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            AppMethodBeat.o(78691);
            return;
            label2425:
            ab.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
            AppMethodBeat.o(78691);
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
  
  private int c(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78683);
    if ((this.fSc == null) || (this.fSc.isEmpty()))
    {
      AppMethodBeat.o(78683);
      return -1;
    }
    int i = (paramInt1 + paramInt2) / 2;
    if ((paramInt2 - paramInt1 == 0) || (paramInt2 - paramInt1 == 1)) {
      if (paramLong < ((c.d)this.fSc.get(paramInt2)).time) {}
    }
    for (;;)
    {
      AppMethodBeat.o(78683);
      return paramInt2;
      paramInt2 = paramInt1;
      continue;
      if (paramLong < ((c.d)this.fSc.get(i)).time) {
        paramInt2 = c(paramLong, paramInt1, i);
      } else if (paramLong > ((c.d)this.fSc.get(i)).time) {
        paramInt2 = c(paramLong, i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  private static String ch(Context paramContext)
  {
    AppMethodBeat.i(78696);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while ((localRunningAppProcessInfo.importance != 100) || ((!localRunningAppProcessInfo.processName.equals("com.tencent.mm")) && (!localRunningAppProcessInfo.processName.equals("com.tencent.mm:tools")) && (!localRunningAppProcessInfo.processName.equals("com.tencent.mm:toolsmp"))));
    }
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(78696);
      return "";
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramContext = paramContext.getAppTasks();
        if ((paramContext == null) || (paramContext.size() <= 0))
        {
          AppMethodBeat.o(78696);
          return "";
        }
        paramContext = paramContext.iterator();
        if (paramContext.hasNext())
        {
          paramContext = ((ActivityManager.AppTask)paramContext.next()).getTaskInfo().topActivity;
          if (paramContext == null)
          {
            AppMethodBeat.o(78696);
            return null;
          }
          localObject = paramContext.getClassName();
          paramContext = (Context)localObject;
          if (((String)localObject).contains(".")) {
            paramContext = ((String)localObject).substring(((String)localObject).lastIndexOf(".") + 1);
          }
          AppMethodBeat.o(78696);
          return paramContext;
        }
      }
      else
      {
        localObject = ((ActivityManager.RunningTaskInfo)paramContext.getRunningTasks(1).get(0)).topActivity.getClassName();
        paramContext = (Context)localObject;
        if (((String)localObject).contains(".")) {
          paramContext = ((String)localObject).substring(((String)localObject).lastIndexOf(".") + 1);
        }
        AppMethodBeat.o(78696);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), bo.l(paramContext) });
      AppMethodBeat.o(78696);
    }
    return "";
  }
  
  private Pair<Integer, ArrayList<b>> g(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(78681);
    ArrayList localArrayList = new ArrayList();
    long l2 = bo.aoy();
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
            ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", new Object[] { Long.valueOf(((b)localObject1).time), Long.valueOf(l2 - ((b)localObject1).time), Integer.valueOf(((b)localObject1).ctW), ((b)localObject1).fSk });
            AppMethodBeat.o(78681);
            return null;
          }
          if (((b)localObject1).ctW == 4)
          {
            if (l1 >= ((b)localObject1).time) {
              break label703;
            }
            l1 = ((b)localObject1).time;
            break label696;
          }
          if (((b)localObject1).ctW != 3)
          {
            ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", new Object[] { Integer.valueOf(((b)localObject1).ctW), ((b)localObject1).fSk });
            AppMethodBeat.o(78681);
            return null;
          }
          ((ArrayList)localObject2).add(localObject1);
          break label703;
        }
        i = ((ArrayList)localObject2).size();
        if (i == 0)
        {
          AppMethodBeat.o(78681);
          return null;
        }
        Collections.sort((List)localObject2);
        Collections.sort(this.fSc);
        localObject1 = new b();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (b)localIterator.next();
        if (((b)localObject2).fSk.equals(((b)localObject1).fSk))
        {
          if (((b)localObject2).time - ((b)localObject1).time <= 10800000L) {
            continue;
          }
          ab.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject1).time) });
          ((b)localObject1).time = ((b)localObject2).time;
          continue;
        }
        a((b)localObject1, ((b)localObject2).elapsedTime);
      }
      catch (Exception paramArrayList)
      {
        A(15008, bo.l(paramArrayList));
        ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", new Object[] { bo.l(paramArrayList) });
        AppMethodBeat.o(78681);
        return null;
      }
      localArrayList.add(localObject2);
      ((b)localObject1).fSl = ((b)localObject2).time;
      localObject1 = localObject2;
    }
    if (!localArrayList.isEmpty()) {
      a((b)localArrayList.get(localArrayList.size() - 1), l1);
    }
    ((b)localObject1).fSl = ((b)paramArrayList.get(paramArrayList.size() - 1)).time;
    if (((b)localArrayList.get(localArrayList.size() - 1)).time > l1) {
      ((b)localArrayList.get(localArrayList.size() - 1)).fSl = l2;
    }
    while (((b)localArrayList.get(localArrayList.size() - 1)).fSl - ((b)localArrayList.get(0)).time > 50400000L)
    {
      ab.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
      AppMethodBeat.o(78681);
      return null;
      if (l1 > l2) {
        ((b)localArrayList.get(localArrayList.size() - 1)).fSl = l2;
      }
    }
    ab.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(localArrayList.size()), Long.valueOf(bo.hl(l2)) });
    paramArrayList = Pair.create(Integer.valueOf(0), localArrayList);
    AppMethodBeat.o(78681);
    return paramArrayList;
    label696:
    label703:
    for (;;)
    {
      i += 1;
      break;
    }
  }
  
  private static boolean gZ(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private static String ha(long paramLong)
  {
    AppMethodBeat.i(78695);
    if (paramLong < 100000000000L)
    {
      str = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(paramLong * 1000L));
      AppMethodBeat.o(78695);
      return str;
    }
    String str = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(paramLong)) + String.format(Locale.getDefault(), ".%03d", new Object[] { Long.valueOf(paramLong % 1000L) });
    AppMethodBeat.o(78695);
    return str;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UseSparseArrays"})
  private static HashMap<Long, ArrayList<b>> uE(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1119
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 269	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   9: lstore_1
    //   10: new 514	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 515	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 518	java/io/File:exists	()Z
    //   23: ifeq +12 -> 35
    //   26: aload_3
    //   27: invokevirtual 1121	java/io/File:length	()J
    //   30: lconst_0
    //   31: lcmp
    //   32: ifgt +35 -> 67
    //   35: ldc 215
    //   37: ldc_w 1123
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: invokestatic 1125	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: new 75	java/util/HashMap
    //   54: dup
    //   55: invokespecial 76	java/util/HashMap:<init>	()V
    //   58: astore_0
    //   59: ldc_w 1119
    //   62: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: new 1127	java/io/FileInputStream
    //   70: dup
    //   71: aload_3
    //   72: invokespecial 1130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: astore_3
    //   76: new 1132	java/io/ObjectInputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 1135	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_0
    //   85: aload_0
    //   86: astore 5
    //   88: aload_3
    //   89: astore 4
    //   91: aload_0
    //   92: invokevirtual 1138	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   95: checkcast 75	java/util/HashMap
    //   98: astore 6
    //   100: aload_0
    //   101: astore 5
    //   103: aload_3
    //   104: astore 4
    //   106: ldc 215
    //   108: ldc_w 1140
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload 6
    //   119: invokevirtual 748	java/util/HashMap:size	()I
    //   122: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: lload_1
    //   129: invokestatic 697	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   132: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: aastore
    //   136: invokestatic 228	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_0
    //   140: invokevirtual 1141	java/io/ObjectInputStream:close	()V
    //   143: aload_3
    //   144: invokevirtual 1142	java/io/FileInputStream:close	()V
    //   147: ldc_w 1119
    //   150: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload 6
    //   155: areturn
    //   156: astore 6
    //   158: aconst_null
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_0
    //   163: astore 5
    //   165: aload_3
    //   166: astore 4
    //   168: ldc 215
    //   170: ldc_w 1144
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 6
    //   181: invokevirtual 1145	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 6
    //   189: invokestatic 243	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 250	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 1141	java/io/ObjectInputStream:close	()V
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 1142	java/io/FileInputStream:close	()V
    //   212: new 75	java/util/HashMap
    //   215: dup
    //   216: invokespecial 76	java/util/HashMap:<init>	()V
    //   219: astore_0
    //   220: ldc_w 1119
    //   223: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_0
    //   227: areturn
    //   228: astore_0
    //   229: aconst_null
    //   230: astore 5
    //   232: aconst_null
    //   233: astore_3
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 1141	java/io/ObjectInputStream:close	()V
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 1142	java/io/FileInputStream:close	()V
    //   252: ldc_w 1119
    //   255: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_0
    //   259: athrow
    //   260: astore_0
    //   261: goto -118 -> 143
    //   264: astore_0
    //   265: goto -118 -> 147
    //   268: astore_0
    //   269: goto -65 -> 204
    //   272: astore_0
    //   273: goto -61 -> 212
    //   276: astore 4
    //   278: goto -34 -> 244
    //   281: astore_3
    //   282: goto -30 -> 252
    //   285: astore_0
    //   286: aconst_null
    //   287: astore 5
    //   289: goto -55 -> 234
    //   292: astore_0
    //   293: aload 4
    //   295: astore_3
    //   296: goto -62 -> 234
    //   299: astore 6
    //   301: aconst_null
    //   302: astore_0
    //   303: goto -141 -> 162
    //   306: astore 6
    //   308: goto -146 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramString	String
    //   9	120	1	l	long
    //   18	231	3	localObject1	Object
    //   281	1	3	localException1	Exception
    //   295	1	3	localObject2	Object
    //   89	78	4	localObject3	Object
    //   276	18	4	localException2	Exception
    //   86	202	5	str	String
    //   98	56	6	localHashMap	HashMap
    //   156	32	6	localThrowable1	Throwable
    //   299	1	6	localThrowable2	Throwable
    //   306	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	35	156	java/lang/Throwable
    //   35	59	156	java/lang/Throwable
    //   67	76	156	java/lang/Throwable
    //   10	35	228	finally
    //   35	59	228	finally
    //   67	76	228	finally
    //   139	143	260	java/lang/Exception
    //   143	147	264	java/lang/Exception
    //   200	204	268	java/lang/Exception
    //   208	212	272	java/lang/Exception
    //   239	244	276	java/lang/Exception
    //   248	252	281	java/lang/Exception
    //   76	85	285	finally
    //   91	100	292	finally
    //   106	139	292	finally
    //   168	196	292	finally
    //   76	85	299	java/lang/Throwable
    //   91	100	306	java/lang/Throwable
    //   106	139	306	java/lang/Throwable
  }
  
  public final void commitNow()
  {
    AppMethodBeat.i(78679);
    long l = bo.aoy();
    ab.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", new Object[] { (Boolean)new c.2(this, Boolean.FALSE).b(this.handler), Long.valueOf(bo.hl(l)) });
    AppMethodBeat.o(78679);
  }
  
  public void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(78673);
    ab.d("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
    AppMethodBeat.o(78673);
  }
  
  public void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(78675);
    ab.e("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
    AppMethodBeat.o(78675);
  }
  
  public void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(78674);
    ab.i("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
    AppMethodBeat.o(78674);
  }
  
  public void onEvent(AccessibilityCapture.Event paramEvent)
  {
    AppMethodBeat.i(78671);
    if ((paramEvent == null) || (paramEvent.view == null) || (paramEvent.activity == null))
    {
      AppMethodBeat.o(78671);
      return;
    }
    if (paramEvent.activity.getComponentName() == null)
    {
      AppMethodBeat.o(78671);
      return;
    }
    Object localObject2 = paramEvent.activity.getComponentName().getShortClassName();
    Object localObject1 = localObject2;
    if (((String)localObject2).contains(".")) {
      localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1);
    }
    if ((!this.fRY) && (!this.fRZ.containsKey(localObject1)))
    {
      AppMethodBeat.o(78671);
      return;
    }
    localObject1 = new c.d();
    long l = System.currentTimeMillis();
    ((c.d)localObject1).fSr = Integer.toHexString(paramEvent.view.getId());
    ((c.d)localObject1).type = paramEvent.event.getEventType();
    ((c.d)localObject1).time = paramEvent.elapsedTime;
    this.fSc.add(localObject1);
    localObject2 = new int[2];
    paramEvent.view.getLocationOnScreen((int[])localObject2);
    ((c.d)localObject1).left = localObject2[0];
    ((c.d)localObject1).top = localObject2[1];
    ab.d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + ((c.d)localObject1).fSr + ",ui:" + paramEvent.activity.getComponentName().getShortClassName() + ",left:" + ((c.d)localObject1).left + ",top:" + ((c.d)localObject1).top + ",time:" + ((c.d)localObject1).time + ",cost:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(78671);
  }
  
  public void post(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(78676);
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
    AppMethodBeat.o(78676);
  }
  
  public void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(78677);
    ab.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramThrowable, paramString2, paramVarArgs);
    AppMethodBeat.o(78677);
  }
  
  public void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(78672);
    ab.v("MicroMsg.ClickFlowStatReceiver", paramString2, paramVarArgs);
    AppMethodBeat.o(78672);
  }
  
  public final void x(Intent paramIntent)
  {
    AppMethodBeat.i(78680);
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")))
    {
      AppMethodBeat.o(78680);
      return;
    }
    this.handler.post(new c.3(this, paramIntent));
    AppMethodBeat.o(78680);
  }
  
  static final class b
    implements Serializable, Comparable<b>
  {
    int ctW = 0;
    long elapsedTime = 0L;
    List<c.d> fSc = null;
    String fSk = null;
    long fSl;
    long time = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(78666);
      String str = String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[] { this.fSk, Integer.valueOf(this.ctW), c.hb(this.time) });
      AppMethodBeat.o(78666);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.c
 * JD-Core Version:    0.7.0.1
 */