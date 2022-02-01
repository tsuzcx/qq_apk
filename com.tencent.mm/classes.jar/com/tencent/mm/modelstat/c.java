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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.b.s;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.cjl;
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
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.j.a;
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
  private static c oVx;
  private MMHandler handler;
  private ArrayList<b> oVA;
  private String oVB;
  private long oVC;
  private ArrayList<c> oVD;
  private boolean oVE;
  private Map<String, Boolean> oVF;
  private long oVG;
  private long oVH;
  private List<d> oVI;
  private MTimerHandler oVy;
  private final int oVz;
  
  private c()
  {
    AppMethodBeat.i(151021);
    this.handler = null;
    this.oVy = null;
    this.oVz = 20971520;
    this.oVA = new ArrayList();
    this.oVB = null;
    this.oVC = 0L;
    this.oVD = new ArrayList();
    this.oVE = false;
    this.oVF = new HashMap();
    this.oVG = 0L;
    this.oVH = 0L;
    this.oVI = new ArrayList();
    if (CrashReportFactory.hasDebuger()) {
      Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", MMApplicationContext.isMMProcess());
    }
    a locala = a.bFV("ClickFlow");
    this.handler = new MMHandler(locala);
    this.handler.setLogging(false);
    this.oVy = new MTimerHandler(locala, new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151008);
        boolean bool2 = GreenManUtil.isScreenOn(MMApplicationContext.getContext());
        String str = c.dW(MMApplicationContext.getContext());
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
    this.oVy.setLogging(false);
    AppMethodBeat.o(151021);
  }
  
  /* Error */
  private static HashMap<Long, ArrayList<b>> Pq(String paramString)
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   8: lstore_1
    //   9: new 157	com/tencent/mm/vfs/u
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 160	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual 163	com/tencent/mm/vfs/u:jKS	()Z
    //   22: ifeq +12 -> 34
    //   25: aload_3
    //   26: invokevirtual 166	com/tencent/mm/vfs/u:length	()J
    //   29: lconst_0
    //   30: lcmp
    //   31: ifgt +33 -> 64
    //   34: ldc 168
    //   36: ldc 170
    //   38: iconst_1
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_0
    //   45: aastore
    //   46: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: new 86	java/util/HashMap
    //   52: dup
    //   53: invokespecial 87	java/util/HashMap:<init>	()V
    //   56: astore_0
    //   57: ldc 149
    //   59: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: areturn
    //   64: aload_3
    //   65: invokestatic 182	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   68: astore 4
    //   70: new 184	java/io/ObjectInputStream
    //   73: dup
    //   74: aload 4
    //   76: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore_3
    //   80: aload_3
    //   81: invokevirtual 191	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: checkcast 86	java/util/HashMap
    //   87: astore_0
    //   88: ldc 168
    //   90: ldc 193
    //   92: iconst_2
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: invokevirtual 197	java/util/HashMap:size	()I
    //   102: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: lload_1
    //   109: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   112: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: aastore
    //   116: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_3
    //   120: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   123: aload 4
    //   125: ifnull +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 220	java/io/InputStream:close	()V
    //   133: ldc 149
    //   135: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_3
    //   143: aconst_null
    //   144: astore 4
    //   146: ldc 168
    //   148: ldc 222
    //   150: iconst_2
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_0
    //   157: invokevirtual 228	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload_0
    //   164: invokestatic 232	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 220	java/io/InputStream:close	()V
    //   189: new 86	java/util/HashMap
    //   192: dup
    //   193: invokespecial 87	java/util/HashMap:<init>	()V
    //   196: astore_0
    //   197: ldc 149
    //   199: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_0
    //   203: areturn
    //   204: astore_0
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 217	java/io/ObjectInputStream:close	()V
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 220	java/io/InputStream:close	()V
    //   223: ldc 149
    //   225: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_0
    //   229: athrow
    //   230: astore_3
    //   231: goto -108 -> 123
    //   234: astore_3
    //   235: goto -102 -> 133
    //   238: astore_0
    //   239: goto -60 -> 179
    //   242: astore_0
    //   243: goto -54 -> 189
    //   246: astore_3
    //   247: goto -34 -> 213
    //   250: astore_3
    //   251: goto -28 -> 223
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_3
    //   257: goto -111 -> 146
    //   260: astore_0
    //   261: goto -115 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramString	String
    //   8	101	1	l	long
    //   17	193	3	localObject1	Object
    //   230	1	3	localException1	Exception
    //   234	1	3	localException2	Exception
    //   246	1	3	localException3	Exception
    //   250	1	3	localException4	Exception
    //   256	1	3	localObject2	Object
    //   68	151	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   9	34	140	finally
    //   34	57	140	finally
    //   64	70	140	finally
    //   146	171	204	finally
    //   119	123	230	java/lang/Exception
    //   128	133	234	java/lang/Exception
    //   175	179	238	java/lang/Exception
    //   184	189	242	java/lang/Exception
    //   209	213	246	java/lang/Exception
    //   218	223	250	java/lang/Exception
    //   70	80	254	finally
    //   80	119	260	finally
  }
  
  private static void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(151027);
    f.Ozc.kvStat(13328, paramInt + ",0,0,0,0,0,0,0,0,0,0,0,0," + paramString);
    AppMethodBeat.o(151027);
  }
  
  private void a(long paramLong, ArrayList<b> paramArrayList, ConfigFile paramConfigFile)
  {
    AppMethodBeat.i(151031);
    long l1 = ((b)paramArrayList.get(0)).time;
    long l2 = ((b)paramArrayList.get(paramArrayList.size() - 1)).oVP;
    long l3 = Util.nowSecond();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.oVD.size()) {
          break label291;
        }
        if (!"app".equals(((c)this.oVD.get(i)).oVR)) {
          break label296;
        }
        paramArrayList = (c)this.oVD.get(i);
        if (paramArrayList != null)
        {
          if ((paramArrayList.ofU > l3) && (a(paramLong, paramArrayList.rate, this.oVH)))
          {
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l3) });
            a(paramConfigFile, paramArrayList.mtI, paramArrayList.id, l1, l2);
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
        U(15004, Util.stackTraceToString(paramArrayList));
        Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
        AppMethodBeat.o(151031);
        return;
      }
      Log.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
      if (iX(paramLong))
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
          if ((((b)localObject2).oVP < ((b)localObject2).time) || (((b)localObject2).time < 0L) || (((b)localObject2).oVP < 0L) || (((b)localObject2).oVP > l) || (((b)localObject2).time > l))
          {
            Log.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).oVP), Long.valueOf(l) });
            AppMethodBeat.o(151033);
            return;
          }
          localJSONObject1.put("p", ((b)localObject2).egj).put("tbe", ((b)localObject2).time / 1000L).put("in", (((b)localObject2).oVP - ((b)localObject2).time) / 1000L);
          if ((((b)localObject2).oVI != null) && (!((b)localObject2).oVI.isEmpty()))
          {
            JSONArray localJSONArray = new JSONArray();
            j = 0;
            if (j < ((b)localObject2).oVI.size())
            {
              d locald = (d)((b)localObject2).oVI.get(j);
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("w", locald.oVU).put("t", locald.type).put("tbp", "{" + locald.left + ";" + locald.top + "}");
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
        if (iX(paramLong))
        {
          paramInt = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_13604"));
          paramConfigFile.saveValue("SEQ_13604", paramInt + 1);
          b(13604, "100002", paramInt, localJSONObject1.toString());
        }
        localObject1 = new SparseArray();
        if (this.oVD.size() != 0) {
          break label747;
        }
        Log.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
      }
      catch (Exception paramArrayList)
      {
        Object localObject2;
        U(15005, Util.stackTraceToString(paramArrayList));
        Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
        AppMethodBeat.o(151033);
        return;
      }
      if (paramInt < this.oVD.size())
      {
        localObject2 = (c)this.oVD.get(paramInt);
        if ((((c)localObject2).ofU > Util.nowSecond()) && (a(paramLong, ((c)localObject2).rate, this.oVH))) {
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
    this.oVG = parama.oVG;
    if ((this.oVG <= 0L) || (this.oVG > 432000L)) {
      this.oVG = 432000L;
    }
    this.oVH = parama.oVH;
    this.oVD.clear();
    this.oVD.addAll(parama.eventList);
    this.oVF.clear();
    this.oVF.putAll(parama.oVF);
    if ((this.oVF.containsKey("*")) && (((Boolean)this.oVF.get("*")).booleanValue())) {
      this.oVE = true;
    }
    Log.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", new Object[] { Integer.valueOf(this.oVD.size()), Long.valueOf(this.oVG), Long.valueOf(this.oVH) });
    AppMethodBeat.o(151028);
  }
  
  private void a(b paramb, long paramLong)
  {
    AppMethodBeat.i(151025);
    if (paramb.oVQ <= 0L)
    {
      AppMethodBeat.o(151025);
      return;
    }
    long l = paramb.oVQ;
    if (this.oVI.isEmpty()) {}
    for (int i = 0;; i = this.oVI.size() - 1)
    {
      i = e(l, 0, i);
      if (i == -1) {
        break;
      }
      if (paramb.oVI == null) {
        paramb.oVI = new ArrayList();
      }
      int j = this.oVI.size();
      while (i < j)
      {
        d locald = (d)this.oVI.get(i);
        if ((locald.time > paramb.oVQ) && (locald.time <= paramLong)) {
          paramb.oVI.add(locald);
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
    Object localObject = paramc.oVR;
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
    paramSparseArray.put(paramc.mtI, Util.nullAsNil((String)paramSparseArray.get(paramc.mtI)) + paramc.id + ";");
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
      if (i < paramc.oVS.size())
      {
        if (!((String)((Pair)paramc.oVS.get(i)).first).equals(((b)paramList.get(j)).egj)) {
          break label835;
        }
        paramSparseArray.put(paramc.mtI, Util.nullAsNil((String)paramSparseArray.get(paramc.mtI)) + paramc.id + ";");
        i = paramc.oVS.size();
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
      if (paramc.oVS.size() == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + paramc.oVS.toString());
        AppMethodBeat.o(151030);
        return;
      }
      localObject = (String)((Pair)paramc.oVS.get(0)).first;
      String str = (String)((Pair)paramc.oVS.get(1)).first;
      if ((!((b)paramList.get(0)).egj.equals(localObject)) || (!((b)paramList.get(paramList.size() - 1)).egj.equals(str))) {
        break;
      }
      paramSparseArray.put(paramc.mtI, Util.nullAsNil((String)paramSparseArray.get(paramc.mtI)) + paramc.id + ";");
      AppMethodBeat.o(151030);
      return;
      Log.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", new Object[] { paramc });
      localObject = paramc.oVS;
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
          if (!((String)((Pair)((List)localObject).get(j)).first).equals(((b)paramList.get(i)).egj)) {
            break label819;
          }
          if (j == 0)
          {
            j = 1;
            if (j == 0) {
              break;
            }
            paramSparseArray.put(paramc.mtI, Util.nullAsNil((String)paramSparseArray.get(paramc.mtI)) + paramc.id + ";");
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
        f.Ozc.idkeyStat(346L, 4L, 1L, false);
        f.Ozc.b(paramInt1, str, true, true);
        i += 1;
      }
      AppMethodBeat.o(151037);
      return;
    }
    catch (Exception paramString1)
    {
      U(15009, Util.stackTraceToString(paramString1));
      Log.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(151037);
    }
  }
  
  private void b(long paramLong, ArrayList<b> paramArrayList, ConfigFile paramConfigFile)
  {
    AppMethodBeat.i(151034);
    long l4 = Util.nowMilliSecond();
    long l5 = ((b)paramArrayList.get(paramArrayList.size() - 1)).oVP;
    if ((l5 <= 0L) || (l5 > l4))
    {
      Log.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", new Object[] { Long.valueOf(l5), Long.valueOf(l4) });
      AppMethodBeat.o(151034);
      return;
    }
    long l6 = Util.nowSecond();
    String str = this.oVB + "stg_20971520_" + paramLong + ".HashMap";
    Object localObject1;
    long l2;
    Object localObject3;
    Object localObject2;
    try
    {
      localObject1 = Pq(str);
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
          ((HashMap)localObject3).put(localObject2, (ArrayList)((HashMap)localObject1).get(localObject2));
        }
      }
    }
    catch (OutOfMemoryError paramArrayList)
    {
      y.deleteFile(str);
      System.gc();
      Log.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", paramArrayList, "OutOfMemoryError", new Object[0]);
      U(15010, Util.stackTraceToString(paramArrayList));
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
    if (i < this.oVD.size()) {
      if ("pagestat".equals(((c)this.oVD.get(i)).oVR))
      {
        paramArrayList = (c)this.oVD.get(i);
        Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", new Object[] { Integer.valueOf(((HashMap)localObject3).size()) });
        localIterator = ((HashMap)localObject3).keySet().iterator();
      }
    }
    for (;;)
    {
      label622:
      Object localObject5;
      long l3;
      if (localIterator.hasNext())
      {
        localObject1 = (Long)localIterator.next();
        if (l1 <= ((Long)localObject1).longValue()) {
          break label2462;
        }
        l1 = ((Long)localObject1).longValue();
        Log.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", new Object[] { Long.valueOf(l1), localObject1 });
        localObject5 = (ArrayList)((HashMap)localObject3).get(localObject1);
        l3 = l2 + (((b)((ArrayList)localObject5).get(((ArrayList)localObject5).size() - 1)).oVP - ((b)((ArrayList)localObject5).get(0)).time);
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
          Log.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", new Object[] { ((b)localObject2).egj, Long.valueOf(Util.nullAsNil((Long)localHashMap1.get(((b)localObject2).egj))), Long.valueOf(((b)localObject2).oVP), Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).oVP - ((b)localObject2).time) });
          l2 = ((b)localObject2).oVP - ((b)localObject2).time;
          if ((l2 >= 0L) && (l2 <= 86400000L)) {
            break label2459;
          }
          Log.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject2).oVP), Long.valueOf(l4), Long.valueOf(l2) });
          l2 = 0L;
          label938:
          localHashMap1.put(((b)localObject2).egj, Long.valueOf(l2 + Util.nullAsNil((Long)localHashMap1.get(((b)localObject2).egj))));
          localHashMap2.put(((b)localObject2).egj, Long.valueOf(Util.nullAsNil((Long)localHashMap2.get(((b)localObject2).egj)) + 1L));
          if (localObject1 != null)
          {
            localObject1 = ((b)localObject1).egj + "," + ((b)localObject2).egj;
            ((HashMap)localObject4).put(localObject1, Long.valueOf(Util.nullAsNil((Long)((HashMap)localObject4).get(localObject1)) + 1L));
          }
          if (((b)localObject2).oVI == null) {
            break label2476;
          }
          if (localHashMap4.containsKey(((b)localObject2).egj))
          {
            localObject1 = (Map)localHashMap4.get(((b)localObject2).egj);
            break label2470;
          }
        }
        for (;;)
        {
          if (j >= ((b)localObject2).oVI.size()) {
            break label2476;
          }
          Object localObject6 = (d)((b)localObject2).oVI.get(j);
          ((Map)localObject1).put(((d)localObject6).oVU, Long.valueOf(Util.nullAsNil((Long)((Map)localObject1).get(((d)localObject6).oVU)) + 1L));
          j += 1;
          continue;
          localObject1 = new HashMap();
          localHashMap4.put(((b)localObject2).egj, localObject1);
          break label2470;
          if (paramArrayList == null) {
            break label2489;
          }
          localObject1 = paramArrayList.oVT.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Pair)((Iterator)localObject1).next();
            localObject5 = (String)((Pair)localObject2).first + "," + (String)((Pair)localObject2).second;
            if (((HashMap)localObject4).containsKey(localObject5)) {
              localHashMap3.put((String)((Pair)localObject2).second, (Long)((HashMap)localObject4).get(localObject5));
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
              if (i >= this.oVD.size()) {
                break label2454;
              }
              if (!"appstat".equals(((c)this.oVD.get(i)).oVR)) {
                continue;
              }
              paramArrayList = (c)this.oVD.get(i);
              Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", new Object[] { Long.valueOf(l5), Long.valueOf(l3), Long.valueOf(l2) });
              if ((paramArrayList == null) || (l5 - l3 - l2 < 0L)) {
                continue;
              }
              if ((paramArrayList.ofU <= l6) || (!a(paramLong, paramArrayList.rate, this.oVH))) {
                continue;
              }
              Log.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_" + paramArrayList.mtI));
              paramConfigFile.saveValue("SEQ_" + paramArrayList.mtI, i + 1);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("t", 5).put("tbe", l3 / 1000L).put("ten", l5 / 1000L).put("in", l2 / 1000L).put("inbg", (l5 - l3 - l2) / 1000L).put("swc", ((HashMap)localObject3).size());
              b(paramArrayList.mtI, paramArrayList.id, i, ((JSONObject)localObject1).toString());
            }
            catch (Exception paramArrayList)
            {
              U(15006, Util.stackTraceToString(paramArrayList));
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
              b(paramArrayList.mtI, paramArrayList.id, i, ((JSONObject)localObject1).toString());
              AppMethodBeat.o(151034);
              return;
            }
            i = 0;
            try
            {
              if (i >= this.oVD.size()) {
                break label2449;
              }
              if (!"pagestat".equals(((c)this.oVD.get(i)).oVR)) {
                continue;
              }
              paramArrayList = (c)this.oVD.get(i);
              if (paramArrayList == null) {
                break label2434;
              }
              if ((paramArrayList.ofU <= l6) || (!a(paramLong, paramArrayList.rate, this.oVH))) {
                break label2403;
              }
              Log.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
              i = Util.nullAsNil(paramConfigFile.getIntegerValue("SEQ_" + paramArrayList.mtI));
              paramConfigFile.saveValue("SEQ_" + paramArrayList.mtI, i + 1);
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
              U(15007, Util.stackTraceToString(paramArrayList));
              Log.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[] { Util.stackTraceToString(paramArrayList) });
              AppMethodBeat.o(151034);
              return;
            }
            continue;
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            continue;
            label2403:
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[] { paramArrayList, Long.valueOf(l6) });
            AppMethodBeat.o(151034);
            return;
            label2434:
            Log.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
            AppMethodBeat.o(151034);
            return;
            label2449:
            paramArrayList = null;
            continue;
            label2454:
            paramArrayList = null;
          }
          label2459:
          break label938;
          label2462:
          break label622;
          paramArrayList = null;
          break;
          label2470:
          int j = 0;
        }
        label2476:
        i += 1;
      }
      label2489:
      l2 = l3;
    }
  }
  
  /* Error */
  private void b(String paramString, HashMap<Long, ArrayList<b>> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 953
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   11: lstore_3
    //   12: aload_1
    //   13: iconst_0
    //   14: invokestatic 957	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   17: astore_1
    //   18: new 959	java/io/ObjectOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 962	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore 8
    //   28: aload 8
    //   30: astore 6
    //   32: aload_1
    //   33: astore 5
    //   35: aload 8
    //   37: aload_2
    //   38: invokevirtual 966	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload 8
    //   43: astore 6
    //   45: aload_1
    //   46: astore 5
    //   48: aload_1
    //   49: invokevirtual 971	java/io/OutputStream:flush	()V
    //   52: aload 8
    //   54: astore 6
    //   56: aload_1
    //   57: astore 5
    //   59: ldc 168
    //   61: ldc_w 973
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_2
    //   71: invokevirtual 197	java/util/HashMap:size	()I
    //   74: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: lload_3
    //   81: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   84: invokestatic 212	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: aastore
    //   88: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload 8
    //   93: invokevirtual 974	java/io/ObjectOutputStream:close	()V
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 975	java/io/OutputStream:close	()V
    //   104: ldc_w 953
    //   107: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_1
    //   114: ldc_w 953
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
    //   140: ldc 168
    //   142: ldc_w 977
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload 7
    //   153: invokevirtual 978	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload 7
    //   161: invokestatic 232	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 974	java/io/ObjectOutputStream:close	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 975	java/io/OutputStream:close	()V
    //   184: ldc_w 953
    //   187: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: goto -80 -> 110
    //   193: astore_1
    //   194: ldc_w 953
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
    //   216: invokevirtual 974	java/io/ObjectOutputStream:close	()V
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 975	java/io/OutputStream:close	()V
    //   227: ldc_w 953
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
  
  public static c bMY()
  {
    AppMethodBeat.i(151020);
    if (oVx == null) {}
    try
    {
      if (oVx == null) {
        oVx = new c();
      }
      c localc = oVx;
      AppMethodBeat.o(151020);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(151020);
    }
  }
  
  private int e(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151026);
    if ((this.oVI == null) || (this.oVI.isEmpty()))
    {
      AppMethodBeat.o(151026);
      return -1;
    }
    int i = (paramInt1 + paramInt2) / 2;
    if ((paramInt2 - paramInt1 == 0) || (paramInt2 - paramInt1 == 1)) {
      if (paramLong < ((d)this.oVI.get(paramInt2)).time) {}
    }
    for (;;)
    {
      AppMethodBeat.o(151026);
      return paramInt2;
      paramInt2 = paramInt1;
      continue;
      if (paramLong < ((d)this.oVI.get(i)).time) {
        paramInt2 = e(paramLong, paramInt1, i);
      } else if (paramLong > ((d)this.oVI.get(i)).time) {
        paramInt2 = e(paramLong, i, paramInt2);
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
  
  private static boolean iX(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private static String iY(long paramLong)
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
  
  private Pair<Integer, ArrayList<b>> z(ArrayList<b> paramArrayList)
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
            Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", new Object[] { Long.valueOf(((b)localObject1).time), Long.valueOf(l2 - ((b)localObject1).time), Integer.valueOf(((b)localObject1).hHC), ((b)localObject1).egj });
            AppMethodBeat.o(151024);
            return null;
          }
          if (((b)localObject1).hHC == 4)
          {
            if (l1 >= ((b)localObject1).time) {
              break label703;
            }
            l1 = ((b)localObject1).time;
            break label696;
          }
          if (((b)localObject1).hHC != 3)
          {
            Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", new Object[] { Integer.valueOf(((b)localObject1).hHC), ((b)localObject1).egj });
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
        Collections.sort(this.oVI);
        localObject1 = new b();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (b)localIterator.next();
        if (((b)localObject2).egj.equals(((b)localObject1).egj))
        {
          if (((b)localObject2).time - ((b)localObject1).time <= 10800000L) {
            continue;
          }
          Log.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", new Object[] { Long.valueOf(((b)localObject2).time), Long.valueOf(((b)localObject1).time) });
          ((b)localObject1).time = ((b)localObject2).time;
          continue;
        }
        a((b)localObject1, ((b)localObject2).oVQ);
      }
      catch (Exception paramArrayList)
      {
        U(15008, Util.stackTraceToString(paramArrayList));
        Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", new Object[] { Util.stackTraceToString(paramArrayList) });
        AppMethodBeat.o(151024);
        return null;
      }
      localArrayList.add(localObject2);
      ((b)localObject1).oVP = ((b)localObject2).time;
      localObject1 = localObject2;
    }
    if (!localArrayList.isEmpty()) {
      a((b)localArrayList.get(localArrayList.size() - 1), l1);
    }
    ((b)localObject1).oVP = ((b)paramArrayList.get(paramArrayList.size() - 1)).time;
    if (((b)localArrayList.get(localArrayList.size() - 1)).time > l1) {
      ((b)localArrayList.get(localArrayList.size() - 1)).oVP = l2;
    }
    while (((b)localArrayList.get(localArrayList.size() - 1)).oVP - ((b)localArrayList.get(0)).time > 50400000L)
    {
      Log.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
      AppMethodBeat.o(151024);
      return null;
      if (l1 > l2) {
        ((b)localArrayList.get(localArrayList.size() - 1)).oVP = l2;
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
  
  public final void FY()
  {
    AppMethodBeat.i(151022);
    long l = Util.nowMilliSecond();
    Log.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", new Object[] { (Boolean)new c.2(this, Boolean.FALSE).exec(this.handler), Long.valueOf(Util.milliSecondsToNow(l)) });
    AppMethodBeat.o(151022);
  }
  
  public final void l(Intent paramIntent)
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
    List<c.c> eventList;
    Map<String, Boolean> oVF;
    long oVG;
    long oVH;
    
    private a()
    {
      AppMethodBeat.i(151013);
      this.eventList = new ArrayList();
      this.oVF = new HashMap();
      AppMethodBeat.o(151013);
    }
    
    static a Pr(String paramString)
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
      locala.oVG = Util.getLong((String)localMap.get(".eventSampleConf.nextUpdateInterval"), 0L);
      if ((locala.oVG <= 0L) || (locala.oVG > 432000L)) {
        locala.oVG = 432000L;
      }
      locala.oVH = Util.getLong((String)localMap.get(".eventSampleConf.samplePeriod"), 0L);
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
          localc.ofU = Util.getLong((String)localMap.get((String)localObject1 + "expireTime"), 0L);
          localc.name = ((String)localMap.get((String)localObject1 + "name"));
          localc.rate = Util.getFloat((String)localMap.get((String)localObject1 + "rate"), 0.0F);
          localc.mtI = Util.getInt((String)localMap.get((String)localObject1 + "logId"), 0);
          localc.oVR = ((String)localMap.get((String)localObject1 + "pages.$type"));
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
            locala.oVF.put(localObject2, Boolean.valueOf(bool));
            j += 1;
          }
          localc.oVS = localArrayList;
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
        localc.oVT = localArrayList;
        locala.eventList.add(localc);
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
      String str = "Config{nextUpdateInterval=" + this.oVG + ", samplePeriod=" + this.oVH + ", eventList=" + this.eventList + '}';
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
    String egj = null;
    int hHC = 0;
    List<c.d> oVI = null;
    long oVP;
    long oVQ = 0L;
    long time = 0L;
    
    public final String toString()
    {
      AppMethodBeat.i(151016);
      String str = String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[] { this.egj, Integer.valueOf(this.hHC), c.iZ(this.time) });
      AppMethodBeat.o(151016);
      return str;
    }
  }
  
  static final class c
  {
    int id;
    int mtI;
    String name;
    String oVR;
    ArrayList<Pair<String, Boolean>> oVS;
    ArrayList<Pair<String, String>> oVT;
    long ofU;
    float rate;
    
    private c()
    {
      AppMethodBeat.i(151017);
      this.oVS = new ArrayList();
      this.oVT = new ArrayList();
      AppMethodBeat.o(151017);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(151018);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportConfigEvent{");
      ((StringBuilder)localObject).append("id=" + this.id);
      ((StringBuilder)localObject).append(", name='" + this.name + "'");
      ((StringBuilder)localObject).append(", expireTime=" + this.ofU);
      ((StringBuilder)localObject).append(", rate=" + this.rate);
      ((StringBuilder)localObject).append(", logId=" + this.mtI);
      ((StringBuilder)localObject).append(", pagesType='" + this.oVR + "'");
      ((StringBuilder)localObject).append(", pageList=[");
      Iterator localIterator = this.oVS.iterator();
      Pair localPair;
      while (localIterator.hasNext())
      {
        localPair = (Pair)localIterator.next();
        ((StringBuilder)localObject).append("{" + (String)localPair.first + "," + localPair.second + "}");
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("]");
      ((StringBuilder)localObject).append(", specialPVPages=[");
      localIterator = this.oVT.iterator();
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
    String oVU = null;
    long time = 0L;
    int top;
    int type = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(151019);
      String str = String.format(Locale.getDefault(), "[%s,%s]", new Object[] { this.oVU, c.iZ(this.time) });
      AppMethodBeat.o(151019);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.c
 * JD-Core Version:    0.7.0.1
 */