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
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.b.s;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.vfs.u;
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
  private static c mcC;
  private MMHandler handler;
  private MTimerHandler mcD;
  private final int mcE;
  private ArrayList<b> mcF;
  private String mcG;
  private long mcH;
  private ArrayList<c> mcI;
  private boolean mcJ;
  private Map<String, Boolean> mcK;
  private long mcL;
  private long mcM;
  private List<d> mcN;
  
  private c()
  {
    AppMethodBeat.i(151021);
    this.handler = null;
    this.mcD = null;
    this.mcE = 20971520;
    this.mcF = new ArrayList();
    this.mcG = null;
    this.mcH = 0L;
    this.mcI = new ArrayList();
    this.mcJ = false;
    this.mcK = new HashMap();
    this.mcL = 0L;
    this.mcM = 0L;
    this.mcN = new ArrayList();
    if (CrashReportFactory.hasDebuger()) {
      Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", MMApplicationContext.isMMProcess());
    }
    a locala = a.bDn("ClickFlow");
    this.handler = new MMHandler(locala);
    this.handler.setLogging(false);
    this.mcD = new MTimerHandler(locala, new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151008);
        boolean bool2 = GreenManUtil.isScreenOn(MMApplicationContext.getContext());
        String str = c.dd(MMApplicationContext.getContext());
        if (!Util.isNullOrNil(str)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), str });
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
    this.mcD.setLogging(false);
    AppMethodBeat.o(151021);
  }
  
  private static boolean GM(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private static String GN(long paramLong)
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
  
  private static void P(int paramInt, String paramString)
  {
    AppMethodBeat.i(151027);
    f.Iyx.kvStat(13328, paramInt + ",0,0,0,0,0,0,0,0,0,0,0,0," + paramString);
    AppMethodBeat.o(151027);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UseSparseArrays"})
  private static HashMap<Long, ArrayList<b>> Xo(String paramString)
  {
    // Byte code:
    //   0: ldc 230
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 236	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   8: lstore_1
    //   9: new 238	com/tencent/mm/vfs/q
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 241	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual 244	com/tencent/mm/vfs/q:ifE	()Z
    //   22: ifeq +12 -> 34
    //   25: aload_3
    //   26: invokevirtual 247	com/tencent/mm/vfs/q:length	()J
    //   29: lconst_0
    //   30: lcmp
    //   31: ifgt +33 -> 64
    //   34: ldc 249
    //   36: ldc 251
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: aastore
    //   46: invokestatic 257	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: new 86	java/util/HashMap
    //   52: dup
    //   53: invokespecial 87	java/util/HashMap:<init>	()V
    //   56: astore_0
    //   57: ldc 230
    //   59: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: areturn
    //   64: aload_3
    //   65: invokestatic 263	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   68: astore_0
    //   69: new 265	java/io/ObjectInputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 268	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_3
    //   78: aload_3
    //   79: astore 5
    //   81: aload_0
    //   82: astore 4
    //   84: aload_3
    //   85: invokevirtual 272	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   88: checkcast 86	java/util/HashMap
    //   91: astore 6
    //   93: aload_3
    //   94: astore 5
    //   96: aload_0
    //   97: astore 4
    //   99: ldc 249
    //   101: ldc_w 274
    //   104: iconst_2
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload 6
    //   112: invokevirtual 278	java/util/HashMap:size	()I
    //   115: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: lload_1
    //   122: invokestatic 287	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   125: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_3
    //   133: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 295	java/io/InputStream:close	()V
    //   144: ldc 230
    //   146: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 6
    //   151: areturn
    //   152: astore 6
    //   154: aconst_null
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_3
    //   159: astore 5
    //   161: aload_0
    //   162: astore 4
    //   164: ldc 249
    //   166: ldc_w 297
    //   169: iconst_2
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload 6
    //   177: invokevirtual 300	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload 6
    //   185: invokestatic 304	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 295	java/io/InputStream:close	()V
    //   208: new 86	java/util/HashMap
    //   211: dup
    //   212: invokespecial 87	java/util/HashMap:<init>	()V
    //   215: astore_0
    //   216: ldc 230
    //   218: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_0
    //   222: areturn
    //   223: astore_3
    //   224: aconst_null
    //   225: astore 5
    //   227: aconst_null
    //   228: astore_0
    //   229: aload 5
    //   231: ifnull +8 -> 239
    //   234: aload 5
    //   236: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 295	java/io/InputStream:close	()V
    //   247: ldc 230
    //   249: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_3
    //   253: athrow
    //   254: astore_3
    //   255: goto -119 -> 136
    //   258: astore_0
    //   259: goto -115 -> 144
    //   262: astore_3
    //   263: goto -63 -> 200
    //   266: astore_0
    //   267: goto -59 -> 208
    //   270: astore 4
    //   272: goto -33 -> 239
    //   275: astore_0
    //   276: goto -29 -> 247
    //   279: astore_3
    //   280: aconst_null
    //   281: astore 5
    //   283: goto -54 -> 229
    //   286: astore_3
    //   287: aload 4
    //   289: astore_0
    //   290: goto -61 -> 229
    //   293: astore 6
    //   295: aconst_null
    //   296: astore_3
    //   297: goto -139 -> 158
    //   300: astore 6
    //   302: goto -144 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramString	String
    //   8	114	1	l	long
    //   17	180	3	localObject1	Object
    //   223	30	3	localObject2	Object
    //   254	1	3	localException1	Exception
    //   262	1	3	localException2	Exception
    //   279	1	3	localObject3	Object
    //   286	1	3	localObject4	Object
    //   296	1	3	localObject5	Object
    //   82	81	4	str	String
    //   270	18	4	localException3	Exception
    //   79	203	5	localObject6	Object
    //   91	59	6	localHashMap	HashMap
    //   152	32	6	localThrowable1	Throwable
    //   293	1	6	localThrowable2	Throwable
    //   300	1	6	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	34	152	java/lang/Throwable
    //   34	57	152	java/lang/Throwable
    //   64	69	152	java/lang/Throwable
    //   9	34	223	finally
    //   34	57	223	finally
    //   64	69	223	finally
    //   132	136	254	java/lang/Exception
    //   140	144	258	java/lang/Exception
    //   196	200	262	java/lang/Exception
    //   204	208	266	java/lang/Exception
    //   234	239	270	java/lang/Exception
    //   243	247	275	java/lang/Exception
    //   69	78	279	finally
    //   84	93	286	finally
    //   99	132	286	finally
    //   164	192	286	finally
    //   69	78	293	java/lang/Throwable
    //   84	93	300	java/lang/Throwable
    //   99	132	300	java/lang/Throwable
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, ConfigFile paramConfigFile)
  {
    AppMethodBeat.i(151031);
    long l1 = ((b)paramArrayList.get(0)).time;
    long l2 = ((b)paramArrayList.get(paramArrayList.size() - 1)).mcV;
    long l3 = Util.nowSecond();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.mcI.size()) {
          break label291;
        }
        if (!"app".equals(((c)this.mcI.get(i)).mcY)) {
          break label296;
        }
        paramArrayList = (c)this.mcI.get(i);
        if (paramArrayList != null)
        {
          if ((paramArrayList.mcX > l3) && (a(paramLong, paramArrayList.rate, this.mcM)))
          {
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
            a(paramConfigFile, paramArrayList.jTq, paramArrayList.id, l1, l2);
            AppMethodBeat.o(151031);
            return;
          }
          Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
          AppMethodBeat.o(151031);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        P(15004, Util.stackTraceToString(paramArrayList));
        Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
        AppMethodBeat.o(151031);
        return;
      }
      Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
      if (GM(paramLong))
      {
        a(paramConfigFile, 13604, 100001, l1, l2);
        AppMethodBeat.o(151031);
        return;
      }
      Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
      AppMethodBeat.o(151031);
      return;
      label291:
      paramArrayList = null;
      continue;
      label296:
      i += 1;
    }
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, ConfigFile paramConfigFile, int paramInt)
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
        long l = Util.nowMilliSecond();
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramArrayList.size())
        {
          localJSONObject1 = new JSONObject();
          localObject2 = (b)paramArrayList.get(i);
          if ((((b)localObject2).mcV < ((b)localObject2).time) || (((b)localObject2).time < 0L) || (((b)localObject2).mcV < 0L) || (((b)localObject2).mcV > l) || (((b)localObject2).time > l))
          {
            Log.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).mcV), Long.valueOf(l) });
            AppMethodBeat.o(151033);
            return;
          }
          localJSONObject1.put("p", ((b)localObject2).cpm).put("tbe", ((b)localObject2).time / 1000L).put("in", (((b)localObject2).mcV - ((b)localObject2).time) / 1000L);
          if ((((b)localObject2).mcN != null) && (!((b)localObject2).mcN.isEmpty()))
          {
            JSONArray localJSONArray = new JSONArray();
            j = 0;
            if (j < ((b)localObject2).mcN.size())
            {
              d locald = (d)((b)localObject2).mcN.get(j);
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("w", locald.mdb).put("t", locald.type).put("tbp", "{" + locald.left + ";" + locald.top + "}");
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
        if (GM(paramLong))
        {
          paramInt = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_13604"));
          paramConfigFile.saveValue("SEQ_13604", paramInt + 1);
          b(13604, "100002", paramInt, localJSONObject1.toString());
        }
        localObject1 = new SparseArray();
        if (this.mcI.size() != 0) {
          break label747;
        }
        Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        P(15005, Util.stackTraceToString(paramArrayList));
        Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
        AppMethodBeat.o(151033);
        return;
      }
      if (paramInt < this.mcI.size())
      {
        localObject2 = (c)this.mcI.get(paramInt);
        if ((((c)localObject2).mcX > Util.nowSecond()) && (a(paramLong, ((c)localObject2).rate, this.mcM))) {
          a(paramArrayList, (c)localObject2, (SparseArray)localObject1);
        } else {
          Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", new Object[] { localObject2, Long.valueOf(Util.nowSecond()) });
        }
      }
      else
      {
        paramInt = 0;
        while (paramInt < ((SparseArray)localObject1).size())
        {
          i = ((SparseArray)localObject1).keyAt(paramInt);
          paramArrayList = (String)((SparseArray)localObject1).get(i);
          j = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_".concat(String.valueOf(i))));
          paramConfigFile.saveValue("SEQ_".concat(String.valueOf(i)), j + 1);
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
    this.mcL = parama.mcL;
    if ((this.mcL <= 0L) || (this.mcL > 432000L)) {
      this.mcL = 432000L;
    }
    this.mcM = parama.mcM;
    this.mcI.clear();
    this.mcI.addAll(parama.mcU);
    this.mcK.clear();
    this.mcK.putAll(parama.mcK);
    if ((this.mcK.containsKey("*")) && (((Boolean)this.mcK.get("*")).booleanValue())) {
      this.mcJ = true;
    }
    Log.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", new Object[] { Integer.valueOf(this.mcI.size()), Long.valueOf(this.mcL), Long.valueOf(this.mcM) });
    AppMethodBeat.o(151028);
  }
  
  private void a(b paramb, long paramLong)
  {
    AppMethodBeat.i(151025);
    if (paramb.mcW <= 0L)
    {
      AppMethodBeat.o(151025);
      return;
    }
    long l = paramb.mcW;
    if (this.mcN.isEmpty()) {}
    for (int i = 0;; i = this.mcN.size() - 1)
    {
      i = c(l, 0, i);
      if (i == -1) {
        break;
      }
      if (paramb.mcN == null) {
        paramb.mcN = new ArrayList();
      }
      int j = this.mcN.size();
      while (i < j)
      {
        d locald = (d)this.mcN.get(i);
        if ((locald.time > paramb.mcW) && (locald.time <= paramLong)) {
          paramb.mcN.add(locald);
        }
        if (locald.time >= paramLong) {
          break;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(151025);
  }
  
  private static void a(ConfigFile paramConfigFile, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151032);
    long l1 = Util.nowMilliSecond();
    if ((paramLong1 > paramLong2) || (paramLong1 < 0L) || (paramLong2 < 0L) || (paramLong1 > l1) || (paramLong2 > l1))
    {
      Log.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(l1) });
      AppMethodBeat.o(151032);
      return;
    }
    int i = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_".concat(String.valueOf(paramInt1))));
    paramConfigFile.saveValue("SEQ_".concat(String.valueOf(paramInt1)), i + 1);
    long l2 = Util.nullAsNil(paramConfigFile.getLongValue("LastQuit_".concat(String.valueOf(paramInt2))));
    paramConfigFile.saveValue("LastQuit_".concat(String.valueOf(paramInt2)), paramLong2);
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= paramLong1) {}
    }
    else
    {
      l1 = paramLong1;
    }
    paramConfigFile = new JSONObject();
    paramConfigFile.put("t", 1).put("tbe", paramLong1 / 1000L).put("ten", paramLong2 / 1000L).put("in", (paramLong2 - paramLong1) / 1000L).put("lten", l1 / 1000L).put("inbg", (paramLong1 - l1) / 1000L);
    b(paramInt1, String.valueOf(paramInt2), i, paramConfigFile.toString());
    AppMethodBeat.o(151032);
  }
  
  private static void a(List<b> paramList, c paramc, SparseArray<String> paramSparseArray)
  {
    int k = 0;
    AppMethodBeat.i(151030);
    Object localObject = paramc.mcY;
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
    Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", new Object[] { paramc });
    paramSparseArray.put(paramc.jTq, Util.nullAsNil((String)paramSparseArray.get(paramc.jTq)) + paramc.id + ";");
    AppMethodBeat.o(151030);
    return;
    Log.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", new Object[] { paramc });
    i = 0;
    label256:
    int j;
    if (i < paramList.size())
    {
      k = 0;
      j = i;
      i = k;
      label275:
      if (i < paramc.mcZ.size())
      {
        if (!((String)((Pair)paramc.mcZ.get(i)).first).equals(((b)paramList.get(j)).cpm)) {
          break label835;
        }
        paramSparseArray.put(paramc.jTq, Util.nullAsNil((String)paramSparseArray.get(paramc.jTq)) + paramc.id + ";");
        i = paramc.mcZ.size();
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
      Log.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", new Object[] { paramc });
      if (paramList.size() < 2) {
        break;
      }
      if (paramc.mcZ.size() == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + paramc.mcZ.toString());
        AppMethodBeat.o(151030);
        return;
      }
      localObject = (String)((Pair)paramc.mcZ.get(0)).first;
      String str = (String)((Pair)paramc.mcZ.get(1)).first;
      if ((!((b)paramList.get(0)).cpm.equals(localObject)) || (!((b)paramList.get(paramList.size() - 1)).cpm.equals(str))) {
        break;
      }
      paramSparseArray.put(paramc.jTq, Util.nullAsNil((String)paramSparseArray.get(paramc.jTq)) + paramc.id + ";");
      AppMethodBeat.o(151030);
      return;
      Log.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", new Object[] { paramc });
      localObject = paramc.mcZ;
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
          if (!((String)((Pair)((List)localObject).get(j)).first).equals(((b)paramList.get(i)).cpm)) {
            break label819;
          }
          if (j == 0)
          {
            j = 1;
            if (j == 0) {
              break;
            }
            paramSparseArray.put(paramc.jTq, Util.nullAsNil((String)paramSparseArray.get(paramc.jTq)) + paramc.id + ";");
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
    if (CrashReportFactory.hasDebuger())
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
    long l2 = Util.nowSecond();
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
      Log.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Float.valueOf(paramFloat), Long.valueOf(paramLong2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      AppMethodBeat.o(151029);
      return bool;
      l1 = paramLong2;
      break;
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
        Log.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", new Object[] { Integer.valueOf(paramInt1), paramString1, str });
        f.Iyx.idkeyStat(346L, 4L, 1L, false);
        f.Iyx.b(paramInt1, str, true, true);
        i += 1;
      }
      AppMethodBeat.o(151037);
      return;
    }
    catch (Exception paramString1)
    {
      P(15009, Util.stackTraceToString(paramString1));
      Log.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(151037);
    }
  }
  
  private void b(long paramLong, ArrayList<b> paramArrayList, ConfigFile paramConfigFile)
  {
    AppMethodBeat.i(151034);
    long l4 = Util.nowMilliSecond();
    long l5 = ((b)paramArrayList.get(paramArrayList.size() - 1)).mcV;
    if ((l5 <= 0L) || (l5 > l4))
    {
      Log.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", new Object[] { Long.valueOf(l5), Long.valueOf(l4) });
      AppMethodBeat.o(151034);
      return;
    }
    long l6 = Util.nowSecond();
    String str = this.mcG + "stg_20971520_" + paramLong + ".HashMap";
    Object localObject1;
    long l2;
    Object localObject3;
    Object localObject2;
    try
    {
      localObject1 = Xo(str);
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
      Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
      AppMethodBeat.o(151034);
      return;
      b(str, (HashMap)localObject1);
      if (CrashReportFactory.hasDebuger()) {}
      for (l1 = 180000L;; l1 = 3600000L)
      {
        l2 = Util.nullAs(paramConfigFile.getLongValue("LAST_REPORT_STATISITIC_TIME"), 0L);
        if (l2 + l1 <= l5) {
          break;
        }
        Log.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l1) });
        AppMethodBeat.o(151034);
        return;
      }
      paramConfigFile.saveValue("LAST_REPORT_STATISITIC_TIME", l5);
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
      u.deleteFile(str);
      System.gc();
      Log.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramArrayList, "OutOfMemoryError", new Object[0]);
      P(15010, Util.stackTraceToString(paramArrayList));
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
    if (i < this.mcI.size()) {
      if ("pagestat".equals(((c)this.mcI.get(i)).mcY))
      {
        paramArrayList = (c)this.mcI.get(i);
        Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", new Object[] { Integer.valueOf(((HashMap)localObject3).size()) });
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
        Log.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", new Object[] { Long.valueOf(l1), localObject1 });
        localObject5 = (ArrayList)((HashMap)localObject3).get(localObject1);
        l3 = l2 + (((b)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).mcV - ((b)((ArrayList)localObject5).get(0)).time);
        if ((l3 < 0L) || (l3 > 172800000L))
        {
          Log.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", new Object[] { Long.valueOf(l3) });
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
          Log.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", new Object[] { ((b)localObject2).cpm, Long.valueOf(Util.nullAsNil((Long)localHashMap1.get(((b)localObject2).cpm))), Long.valueOf(((b)localObject2).mcV), Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).mcV - ((b)localObject2).time) });
          l2 = ((b)localObject2).mcV - ((b)localObject2).time;
          if ((l2 >= 0L) && (l2 <= 86400000L)) {
            break label2450;
          }
          Log.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).mcV), Long.valueOf(l4), Long.valueOf(l2) });
          l2 = 0L;
          label935:
          localHashMap1.put(((b)localObject2).cpm, Long.valueOf(l2 + Util.nullAsNil((Long)localHashMap1.get(((b)localObject2).cpm))));
          localHashMap2.put(((b)localObject2).cpm, Long.valueOf(Util.nullAsNil((Long)localHashMap2.get(((b)localObject2).cpm)) + 1L));
          if (localObject1 != null)
          {
            localObject1 = ((b)localObject1).cpm + "," + ((b)localObject2).cpm;
            ((HashMap)localObject4).put(localObject1, Long.valueOf(Util.nullAsNil((Long)((HashMap)localObject4).get(localObject1)) + 1L));
          }
          if (((b)localObject2).mcN == null) {
            break label2467;
          }
          if (localHashMap4.containsKey(((b)localObject2).cpm))
          {
            localObject1 = (Map)localHashMap4.get(((b)localObject2).cpm);
            break label2461;
          }
        }
        for (;;)
        {
          if (j >= ((b)localObject2).mcN.size()) {
            break label2467;
          }
          Object localObject6 = (d)((b)localObject2).mcN.get(j);
          ((Map)localObject1).put(((d)localObject6).mdb, Long.valueOf(Util.nullAsNil((Long)((Map)localObject1).get(((d)localObject6).mdb)) + 1L));
          j += 1;
          continue;
          localObject1 = new HashMap();
          localHashMap4.put(((b)localObject2).cpm, localObject1);
          break label2461;
          if (paramArrayList == null) {
            break label2480;
          }
          localObject1 = paramArrayList.mda.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Pair)((Iterator)localObject1).next();
            localObject5 = (String)((Pair)localObject2).first + "," + (String)((Pair)localObject2).second;
            if (((HashMap)localObject4).containsKey(localObject5)) {
              localHashMap3.put(((Pair)localObject2).second, ((HashMap)localObject4).get(localObject5));
            }
          }
          l3 = ((b)((ArrayList)((HashMap)localObject3).get(Long.valueOf(l1))).get(0)).time;
          Log.i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3) });
          if ((l3 > l4) || (l3 < 0L))
          {
            Log.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
            AppMethodBeat.o(151034);
            return;
          }
          i = 0;
          for (;;)
          {
            try
            {
              if (i >= this.mcI.size()) {
                break label2445;
              }
              if (!"appstat".equals(((c)this.mcI.get(i)).mcY)) {
                continue;
              }
              paramArrayList = (c)this.mcI.get(i);
              Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", new Object[] { Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(l2) });
              if ((paramArrayList == null) || (l5 - l3 - l2 < 0L)) {
                continue;
              }
              if ((paramArrayList.mcX <= l6) || (!a(paramLong, paramArrayList.rate, this.mcM))) {
                continue;
              }
              Log.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_" + paramArrayList.jTq));
              paramConfigFile.saveValue("SEQ_" + paramArrayList.jTq, i + 1);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 5).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("in", l2 / 1000L).put("inbg", (l5 - l3 - l2) / 1000L).put("swc", ((HashMap)localObject3).size());
              b(paramArrayList.jTq, paramArrayList.id, i, ((JSONObject)localObject1).toString());
            }
            catch (Exception paramArrayList)
            {
              P(15006, Util.stackTraceToString(paramArrayList));
              Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
              continue;
              Log.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", new Object[] { paramArrayList, Long.valueOf(l5 - l3 - l2) });
              continue;
              i += 1;
              continue;
              ((JSONObject)localObject2).put("wa", localObject3);
              paramConfigFile.put(localObject2);
              continue;
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 6).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("pa", paramConfigFile);
              b(paramArrayList.jTq, paramArrayList.id, i, ((JSONObject)localObject1).toString());
              AppMethodBeat.o(151034);
              return;
            }
            i = 0;
            try
            {
              if (i >= this.mcI.size()) {
                break label2440;
              }
              if (!"pagestat".equals(((c)this.mcI.get(i)).mcY)) {
                continue;
              }
              paramArrayList = (c)this.mcI.get(i);
              if (paramArrayList == null) {
                break label2425;
              }
              if ((paramArrayList.mcX <= l6) || (!a(paramLong, paramArrayList.rate, this.mcM))) {
                break label2394;
              }
              Log.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_" + paramArrayList.jTq));
              paramConfigFile.saveValue("SEQ_" + paramArrayList.jTq, i + 1);
              paramConfigFile = new JSONArray();
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
              P(15007, Util.stackTraceToString(paramArrayList));
              Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
              AppMethodBeat.o(151034);
              return;
            }
            continue;
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            continue;
            label2394:
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            AppMethodBeat.o(151034);
            return;
            label2425:
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
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
    //   2: ldc_w 987
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 236	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   11: lstore_3
    //   12: aload_1
    //   13: invokestatic 991	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   16: astore_1
    //   17: new 993	java/io/ObjectOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 996	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore 8
    //   27: aload 8
    //   29: astore 6
    //   31: aload_1
    //   32: astore 5
    //   34: aload 8
    //   36: aload_2
    //   37: invokevirtual 1000	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   40: aload 8
    //   42: astore 6
    //   44: aload_1
    //   45: astore 5
    //   47: aload_1
    //   48: invokevirtual 1005	java/io/OutputStream:flush	()V
    //   51: aload 8
    //   53: astore 6
    //   55: aload_1
    //   56: astore 5
    //   58: ldc 249
    //   60: ldc_w 1007
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_2
    //   70: invokevirtual 278	java/util/HashMap:size	()I
    //   73: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: lload_3
    //   80: invokestatic 287	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   83: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   86: aastore
    //   87: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload 8
    //   92: invokevirtual 1008	java/io/ObjectOutputStream:close	()V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 1009	java/io/OutputStream:close	()V
    //   103: ldc_w 987
    //   106: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: astore_1
    //   113: ldc_w 987
    //   116: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: goto -10 -> 109
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    //   127: astore 7
    //   129: aconst_null
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_2
    //   134: astore 6
    //   136: aload_1
    //   137: astore 5
    //   139: ldc 249
    //   141: ldc_w 1011
    //   144: iconst_2
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload 7
    //   152: invokevirtual 1012	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload 7
    //   160: invokestatic 304	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 1008	java/io/ObjectOutputStream:close	()V
    //   175: aload_1
    //   176: ifnull +7 -> 183
    //   179: aload_1
    //   180: invokevirtual 1009	java/io/OutputStream:close	()V
    //   183: ldc_w 987
    //   186: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: goto -80 -> 109
    //   192: astore_1
    //   193: ldc_w 987
    //   196: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: goto -90 -> 109
    //   202: astore_2
    //   203: aconst_null
    //   204: astore 6
    //   206: aconst_null
    //   207: astore_1
    //   208: aload 6
    //   210: ifnull +8 -> 218
    //   213: aload 6
    //   215: invokevirtual 1008	java/io/ObjectOutputStream:close	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 1009	java/io/OutputStream:close	()V
    //   226: ldc_w 987
    //   229: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aload_2
    //   233: athrow
    //   234: astore_2
    //   235: goto -140 -> 95
    //   238: astore_2
    //   239: goto -64 -> 175
    //   242: astore 5
    //   244: goto -26 -> 218
    //   247: astore_1
    //   248: goto -22 -> 226
    //   251: astore_2
    //   252: aconst_null
    //   253: astore 6
    //   255: goto -47 -> 208
    //   258: astore_2
    //   259: aload 5
    //   261: astore_1
    //   262: goto -54 -> 208
    //   265: astore 7
    //   267: aconst_null
    //   268: astore_2
    //   269: goto -136 -> 133
    //   272: astore 7
    //   274: aload 8
    //   276: astore_2
    //   277: goto -144 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	c
    //   0	280	1	paramString	String
    //   0	280	2	paramHashMap	HashMap<Long, ArrayList<b>>
    //   11	69	3	l	long
    //   32	106	5	str	String
    //   242	18	5	localException1	Exception
    //   29	225	6	localObject	Object
    //   127	32	7	localException2	Exception
    //   265	1	7	localException3	Exception
    //   272	1	7	localException4	Exception
    //   25	250	8	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   99	103	112	java/lang/Exception
    //   2	8	122	finally
    //   90	95	122	finally
    //   99	103	122	finally
    //   103	109	122	finally
    //   113	119	122	finally
    //   171	175	122	finally
    //   179	183	122	finally
    //   183	189	122	finally
    //   193	199	122	finally
    //   213	218	122	finally
    //   222	226	122	finally
    //   226	234	122	finally
    //   8	17	127	java/lang/Exception
    //   179	183	192	java/lang/Exception
    //   8	17	202	finally
    //   90	95	234	java/lang/Exception
    //   171	175	238	java/lang/Exception
    //   213	218	242	java/lang/Exception
    //   222	226	247	java/lang/Exception
    //   17	27	251	finally
    //   34	40	258	finally
    //   47	51	258	finally
    //   58	90	258	finally
    //   139	167	258	finally
    //   17	27	265	java/lang/Exception
    //   34	40	272	java/lang/Exception
    //   47	51	272	java/lang/Exception
    //   58	90	272	java/lang/Exception
  }
  
  public static c bpr()
  {
    AppMethodBeat.i(151020);
    if (mcC == null) {}
    try
    {
      if (mcC == null) {
        mcC = new c();
      }
      c localc = mcC;
      AppMethodBeat.o(151020);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(151020);
    }
  }
  
  private int c(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151026);
    if ((this.mcN == null) || (this.mcN.isEmpty()))
    {
      AppMethodBeat.o(151026);
      return -1;
    }
    int i = (paramInt1 + paramInt2) / 2;
    if ((paramInt2 - paramInt1 == 0) || (paramInt2 - paramInt1 == 1)) {
      if (paramLong < ((d)this.mcN.get(paramInt2)).time) {}
    }
    for (;;)
    {
      AppMethodBeat.o(151026);
      return paramInt2;
      paramInt2 = paramInt1;
      continue;
      if (paramLong < ((d)this.mcN.get(i)).time) {
        paramInt2 = c(paramLong, paramInt1, i);
      } else if (paramLong > ((d)this.mcN.get(i)).time) {
        paramInt2 = c(paramLong, i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  private static String getTopActivityName(Context paramContext)
  {
    AppMethodBeat.i(151040);
    if (!isAppOnForeground(paramContext))
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
      Log.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", new Object[] { paramContext.getMessage(), Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(151040);
    }
    return "";
  }
  
  private static boolean isAppOnForeground(Context paramContext)
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
          if ((!localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId())) && (!localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":tools")))
          {
            boolean bool = localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":toolsmp");
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
      Log.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramContext, "isAppOnForeground", new Object[0]);
      AppMethodBeat.o(151039);
    }
    return false;
  }
  
  private Pair<Integer, ArrayList<b>> w(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(151024);
    ArrayList localArrayList = new ArrayList();
    long l2 = Util.nowMilliSecond();
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
            Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", new Object[] { Long.valueOf(((b)localObject1).time), Long.valueOf(l2 - ((b)localObject1).time), Integer.valueOf(((b)localObject1).fCN), ((b)localObject1).cpm });
            AppMethodBeat.o(151024);
            return null;
          }
          if (((b)localObject1).fCN == 4)
          {
            if (l1 >= ((b)localObject1).time) {
              break label703;
            }
            l1 = ((b)localObject1).time;
            break label696;
          }
          if (((b)localObject1).fCN != 3)
          {
            Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", new Object[] { Integer.valueOf(((b)localObject1).fCN), ((b)localObject1).cpm });
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
        Collections.sort(this.mcN);
        localObject1 = new b();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (b)localIterator.next();
        if (((b)localObject2).cpm.equals(((b)localObject1).cpm))
        {
          if (((b)localObject2).time - ((b)localObject1).time <= 10800000L) {
            continue;
          }
          Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject1).time) });
          ((b)localObject1).time = ((b)localObject2).time;
          continue;
        }
        a((b)localObject1, ((b)localObject2).mcW);
      }
      catch (Exception paramArrayList)
      {
        P(15008, Util.stackTraceToString(paramArrayList));
        Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", new Object[] { Util.stackTraceToString(paramArrayList) });
        AppMethodBeat.o(151024);
        return null;
      }
      localArrayList.add(localObject2);
      ((b)localObject1).mcV = ((b)localObject2).time;
      localObject1 = localObject2;
    }
    if (!localArrayList.isEmpty()) {
      a((b)localArrayList.get(localArrayList.size() - 1), l1);
    }
    ((b)localObject1).mcV = ((b)paramArrayList.get(paramArrayList.size() - 1)).time;
    if (((b)localArrayList.get(localArrayList.size() - 1)).time > l1) {
      ((b)localArrayList.get(localArrayList.size() - 1)).mcV = l2;
    }
    while (((b)localArrayList.get(localArrayList.size() - 1)).mcV - ((b)localArrayList.get(0)).time > 50400000L)
    {
      Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
      AppMethodBeat.o(151024);
      return null;
      if (l1 > l2) {
        ((b)localArrayList.get(localArrayList.size() - 1)).mcV = l2;
      }
    }
    Log.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", new Object[] { Integer.valueOf(0), Integer.valueOf(localArrayList.size()), Long.valueOf(Util.milliSecondsToNow(l2)) });
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
  
  public final void iq()
  {
    AppMethodBeat.i(151022);
    long l = Util.nowMilliSecond();
    Log.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", new Object[] { (Boolean)new c.2(this, Boolean.FALSE).exec(this.handler), Long.valueOf(Util.milliSecondsToNow(l)) });
    AppMethodBeat.o(151022);
  }
  
  public final void k(Intent paramIntent)
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
    Map<String, Boolean> mcK;
    long mcL;
    long mcM;
    List<c.c> mcU;
    
    private a()
    {
      AppMethodBeat.i(151013);
      this.mcU = new ArrayList();
      this.mcK = new HashMap();
      AppMethodBeat.o(151013);
    }
    
    static a Xp(String paramString)
    {
      AppMethodBeat.i(151015);
      a locala = new a();
      Map localMap;
      try
      {
        localMap = XmlParser.parseXml(paramString, "eventSampleConf", null);
        if (localMap == null)
        {
          Log.e("MicroMsg.ClickFlowStatReceiver", "Config.parseString unable parse XML: %s", new Object[] { paramString });
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
      locala.mcL = Util.getLong((String)localMap.get(".eventSampleConf.nextUpdateInterval"), 0L);
      if ((locala.mcL <= 0L) || (locala.mcL > 432000L)) {
        locala.mcL = 432000L;
      }
      locala.mcM = Util.getLong((String)localMap.get(".eventSampleConf.samplePeriod"), 0L);
      int i = 0;
      c.c localc = new c.c((byte)0);
      Object localObject1 = new StringBuilder(".eventSampleConf.events.event");
      label181:
      ArrayList localArrayList;
      int j;
      Object localObject2;
      if (i > 0)
      {
        paramString = Integer.valueOf(i);
        localObject1 = paramString + ".";
        localc.id = Util.getInt((String)localMap.get((String)localObject1 + "id"), 0);
        if (localc.id > 0)
        {
          localc.mcX = Util.getLong((String)localMap.get((String)localObject1 + "expireTime"), 0L);
          localc.name = ((String)localMap.get((String)localObject1 + "name"));
          localc.rate = Util.getFloat((String)localMap.get((String)localObject1 + "rate"), 0.0F);
          localc.jTq = Util.getInt((String)localMap.get((String)localObject1 + "logId"), 0);
          localc.mcY = ((String)localMap.get((String)localObject1 + "pages.$type"));
          localArrayList = new ArrayList();
          j = 0;
          for (;;)
          {
            localObject2 = new StringBuilder().append((String)localObject1).append("pages.page");
            if (j <= 0) {
              break label820;
            }
            paramString = Integer.valueOf(j);
            label470:
            paramString = paramString + ".";
            localObject2 = (String)localMap.get(paramString + "$id");
            if (localObject2 == null) {
              break;
            }
            boolean bool = ((String)localMap.get(paramString + "$action")).equals("true");
            localArrayList.add(new Pair(localObject2, Boolean.valueOf(bool)));
            locala.mcK.put(localObject2, Boolean.valueOf(bool));
            j += 1;
          }
          localc.mcZ = localArrayList;
          localArrayList = new ArrayList();
          j = 0;
          label617:
          localObject2 = new StringBuilder().append((String)localObject1).append("specialPVPages.pageItem");
          if (j <= 0) {
            break label826;
          }
        }
      }
      label820:
      label826:
      for (paramString = Integer.valueOf(j);; paramString = "")
      {
        paramString = paramString + ".";
        localObject2 = (String)localMap.get(paramString + "$prePage");
        if (localObject2 != null)
        {
          localArrayList.add(new Pair(localObject2, (String)localMap.get(paramString + "$page")));
          j += 1;
          break label617;
        }
        localc.mda = localArrayList;
        locala.mcU.add(localc);
        Log.i("MicroMsg.ClickFlowStatReceiver", "Config.parseString Event: %s", new Object[] { localc });
        i += 1;
        break;
        Log.v("MicroMsg.ClickFlowStatReceiver", "Config.parseString %s", new Object[] { locala });
        AppMethodBeat.o(151015);
        return locala;
        paramString = "";
        break label181;
        paramString = "";
        break label470;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(151014);
      String str = "Config{nextUpdateInterval=" + this.mcL + ", samplePeriod=" + this.mcM + ", eventList=" + this.mcU + '}';
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
    String cpm = null;
    int fCN = 0;
    List<c.d> mcN = null;
    long mcV;
    long mcW = 0L;
    long time = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(151016);
      String str = String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[] { this.cpm, Integer.valueOf(this.fCN), c.GO(this.time) });
      AppMethodBeat.o(151016);
      return str;
    }
  }
  
  static final class c
  {
    int id;
    int jTq;
    long mcX;
    String mcY;
    ArrayList<Pair<String, Boolean>> mcZ;
    ArrayList<Pair<String, String>> mda;
    String name;
    float rate;
    
    private c()
    {
      AppMethodBeat.i(151017);
      this.mcZ = new ArrayList();
      this.mda = new ArrayList();
      AppMethodBeat.o(151017);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(151018);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportConfigEvent{");
      ((StringBuilder)localObject).append("id=" + this.id);
      ((StringBuilder)localObject).append(", name='" + this.name + "'");
      ((StringBuilder)localObject).append(", expireTime=" + this.mcX);
      ((StringBuilder)localObject).append(", rate=" + this.rate);
      ((StringBuilder)localObject).append(", logId=" + this.jTq);
      ((StringBuilder)localObject).append(", pagesType='" + this.mcY + "'");
      ((StringBuilder)localObject).append(", pageList=[");
      Iterator localIterator = this.mcZ.iterator();
      Pair localPair;
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        ((StringBuilder)localObject).append("{" + (String)localPair.first + "," + localPair.second + "}");
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(", specialPVPages=[");
      localIterator = this.mda.iterator();
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
    int left;
    String mdb = null;
    long time = 0L;
    int top;
    int type = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(151019);
      String str = String.format(Locale.getDefault(), "[%s,%s]", new Object[] { this.mdb, c.GO(this.time) });
      AppMethodBeat.o(151019);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.c
 * JD-Core Version:    0.7.0.1
 */