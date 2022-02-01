package com.tencent.matrix.report;

import android.os.Process;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.j.b;
import com.tencent.matrix.a.a.a.j.b.b;
import com.tencent.matrix.a.a.a.l;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.a.a.m.a.a<Lcom.tencent.matrix.a.a.a.j.b;>;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.a.a.m.a.c.c;
import com.tencent.matrix.a.b.o.a;
import com.tencent.matrix.a.b.o.c;
import com.tencent.matrix.a.b.o.c.a;
import com.tencent.matrix.c.f;
import com.tencent.matrix.c.i;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.Class<+Lcom.tencent.matrix.a.a.a.b;>;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c$a
{
  static void a(com.tencent.matrix.a.a.a parama, m.a.a<j.b> parama1)
  {
    if ((com.tencent.matrix.c.a.ayo()) && (parama.eOg <= 50))
    {
      Log.i("Matrix.battery.BatteryReporter", "#dumpDevStatForDebug for reportJiffies, name = " + ((j.b.b)((j.b)parama1.eSh).eRJ.list.get(0)).name);
      new c.a..ExternalSyntheticLambda1(parama1, parama);
      com.tencent.matrix.c.a.ayr();
    }
  }
  
  public static int awy()
  {
    return dD(AppForegroundDelegate.heY.eLx);
  }
  
  public static String ayX()
  {
    String str = MMApplicationContext.getProcessName();
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    if (str.contains(":"))
    {
      int i = str.lastIndexOf(":");
      return str.substring(":".length() + i);
    }
    return "main";
  }
  
  static androidx.core.f.d<String, Integer> b(Class<? extends com.tencent.matrix.a.a.a.b> paramClass, m.a.a<b.a> parama)
  {
    final com.tencent.matrix.a.a.a.b localb = (com.tencent.matrix.a.a.a.b)com.tencent.matrix.a.a.aj(paramClass);
    final o.c localc;
    Object localObject;
    int i;
    int j;
    label162:
    int k;
    if (localb != null)
    {
      long l1 = ((Long)((b.a)parama.eSh).eQc.eSn).longValue();
      long l2 = ((Long)((b.a)parama.eSg).eQc.eSn).longValue();
      final int m = ((b.a)parama.eSh).tid;
      if (l2 > 0L) {
        if (localb.mT(m) != null)
        {
          localc = localb.h(m, l1, l2);
          if ((localc != null) && (localc.eSe))
          {
            localObject = localc.axE();
            if (localObject != null) {
              if ((!TextUtils.isEmpty(((o.c.a)localObject).key)) && (!((o.c.a)localObject).key.equals("thread_pool@idle")))
              {
                paramClass = ((o.c.a)localObject).key;
                i = ((o.c.a)localObject).ratio;
                j = 1;
                k = i;
                localObject = paramClass;
                if (j != 0)
                {
                  Log.i("Matrix.battery.BatteryReporter", " #overHeat reportJiffies found task: name = " + paramClass + ", ratio = " + i);
                  localObject = paramClass;
                  k = i;
                }
                label210:
                i = k;
                paramClass = (Class<? extends com.tencent.matrix.a.a.a.b>)localObject;
                if (com.tencent.matrix.c.a.ayo())
                {
                  Log.i("Matrix.battery.BatteryReporter", "#dumpForDebug collectTaskInfoForReport, tid = ".concat(String.valueOf(m)));
                  new Runnable()
                  {
                    public final void run()
                    {
                      try
                      {
                        long l1 = ((Long)((b.a)c.a.this.eSh).eQc.eSn).longValue();
                        long l2 = ((Long)((b.a)c.a.this.eSg).eQc.eSn).longValue();
                        Log.i("Matrix.battery.BatteryReporter", "#dumpForDebug taskStat, currStat = " + "thread_pool@idle" + ", window = " + l1 + ", currMillis = " + l2);
                        Object localObject2 = localb.mT(m);
                        Object localObject1 = localObject2;
                        if (localObject2 == null) {
                          localObject1 = Collections.emptyList();
                        }
                        localObject2 = new JSONArray();
                        localObject1 = ((List)localObject1).iterator();
                        while (((Iterator)localObject1).hasNext())
                        {
                          o.a locala = (o.a)((Iterator)localObject1).next();
                          JSONObject localJSONObject = new JSONObject();
                          localJSONObject.put("key", locala.key);
                          localJSONObject.put("upTime", locala.eRP);
                          localJSONObject.put("statMillis", DateFormat.format("HH:mm:ss", locala.eUs));
                          ((JSONArray)localObject2).put(localJSONObject);
                        }
                        Log.i("Matrix.battery.BatteryReporter", "#dumpForDebug, stampList = \n\t".concat(String.valueOf(((JSONArray)localObject2).toString(2))));
                      }
                      catch (JSONException localJSONException)
                      {
                        Log.printErrStackTrace("Matrix.battery.BatteryReporter", localJSONException, "dump looper stamps error", new Object[0]);
                        return;
                      }
                      if (localc == null)
                      {
                        Log.i("Matrix.battery.BatteryReporter", "#dumpForDebug result = null");
                        return;
                      }
                      Log.i("Matrix.battery.BatteryReporter", "#dumpForDebug result, valid = " + localc.eSe + ", result = " + localc.eUw);
                    }
                  };
                  com.tencent.matrix.c.a.ayr();
                  paramClass = (Class<? extends com.tencent.matrix.a.a.a.b>)localObject;
                  i = k;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return new androidx.core.f.d(paramClass, Integer.valueOf(i));
      localObject = localc.axF();
      if ((localObject != null) && (!TextUtils.isEmpty(((o.c.a)localObject).key)) && (!((o.c.a)localObject).key.equals("thread_pool@idle")))
      {
        paramClass = ((o.c.a)localObject).key;
        i = ((o.c.a)localObject).ratio;
        j = 1;
        break label162;
      }
      j = 0;
      i = 0;
      paramClass = null;
      break label162;
      k = 0;
      localObject = null;
      break label210;
      localc = null;
      break;
      i = 0;
      paramClass = null;
    }
  }
  
  static String capitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    return Character.toTitleCase(paramString.charAt(0)) + paramString.substring(1);
  }
  
  static androidx.core.f.d<String, Integer> d(m.a.a<j.b> parama)
  {
    Object localObject1 = null;
    String str1 = null;
    String str2 = ((j.b.b)((j.b)parama.eSh).eRJ.list.get(0)).name;
    int j = ((j.b.b)((j.b)parama.eSh).eRJ.list.get(0)).tid;
    long l3 = ((Long)((j.b.b)((j.b)parama.eSh).eRJ.list.get(0)).eSn).longValue();
    if ((l3 > 0L) && (!((j.b)parama.eSg).eRJ.list.isEmpty())) {
      return new androidx.core.f.d(null, Integer.valueOf(0));
    }
    long l2 = 0L;
    parama = ((j.b)parama.eSg).eRJ.list.iterator();
    Object localObject2;
    do
    {
      l1 = l2;
      if (!parama.hasNext()) {
        break;
      }
      localObject2 = (j.b.b)parama.next();
    } while ((!((j.b.b)localObject2).name.equals(str2)) || (((j.b.b)localObject2).tid != j));
    long l1 = ((Long)((m.a.c.b)localObject2).eSn).longValue();
    Object localObject4;
    Object localObject3;
    l locall;
    com.tencent.matrix.c.d locald;
    int i;
    label476:
    int k;
    if (l1 > 0L)
    {
      localObject2 = null;
      localObject4 = null;
      localObject3 = null;
      localObject1 = null;
      parama = null;
      locall = null;
      locald = null;
      if (("[D]#worker".equalsIgnoreCase(str2)) || (str2.startsWith("[D]#worker")))
      {
        i = 1;
        if (i == 0) {
          break label598;
        }
        parama = (f)com.tencent.matrix.a.a.aj(f.class);
        if (parama == null) {
          break label580;
        }
        localObject1 = parama.mT(j);
        if (localObject1 == null) {
          break label566;
        }
        localObject2 = "mmhandler";
        parama = parama.h(j, l3, l1);
      }
      for (;;)
      {
        if ((com.tencent.matrix.c.a.ayo()) && (parama != null) && (parama.eSe) && (parama.axE() != null) && (parama.axE().ratio == 100))
        {
          Log.i("Matrix.battery.BatteryReporter", "#dumpForDebug for reportJiffies, name = ".concat(String.valueOf(str2)));
          new c.a..ExternalSyntheticLambda0(l3, l1, new LinkedList((Collection)localObject1), new LinkedList(parama.eUw));
          com.tencent.matrix.c.a.ayr();
        }
        localObject1 = str1;
        if (parama == null) {
          break label1110;
        }
        localObject1 = str1;
        if (!parama.eSe) {
          break label1110;
        }
        j = 0;
        localObject1 = parama.axE();
        if (localObject1 == null) {
          break label1102;
        }
        if ((TextUtils.isEmpty(((o.c.a)localObject1).key)) || (((o.c.a)localObject1).key.equals("thread_pool@idle"))) {
          break label1048;
        }
        str1 = ((o.c.a)localObject1).key;
        i = ((o.c.a)localObject1).ratio;
        l1 = ((o.c.a)localObject1).eUx;
        j = 1;
        k = i;
        localObject1 = str1;
        if (j != 0)
        {
          Log.i("Matrix.battery.BatteryReporter", " #overHeat reportJiffies found task: name = " + str1 + ", ratio = " + i + ", statMillis = " + l1 + ", from = " + (String)localObject2);
          localObject1 = str1;
          k = i;
        }
        label547:
        return new androidx.core.f.d(localObject1, Integer.valueOf(k));
        i = 0;
        break;
        label566:
        parama = null;
        str1 = "mmhandler-stamps-empty";
        localObject2 = localObject3;
        continue;
        label580:
        parama = null;
        str1 = "mmhandler-disabled";
        localObject1 = locall;
        localObject2 = localObject3;
      }
      label598:
      if (!TextUtils.isEmpty(str2)) {
        if ((str2.contains("[GT]ColdPool#")) || (str2.contains("[GT]HotPool#")))
        {
          i = 1;
          label630:
          if (i == 0) {
            break label697;
          }
          localObject1 = (i)com.tencent.matrix.a.a.aj(i.class);
          if (localObject1 == null) {
            break label1136;
          }
          parama = ((i)localObject1).mT(j);
          if (parama == null) {
            break label1124;
          }
          localObject3 = ((i)localObject1).h(j, l3, l1);
          localObject2 = "threadPool";
          localObject1 = parama;
          parama = (m.a.a<j.b>)localObject3;
        }
      }
    }
    for (;;)
    {
      break;
      i = 0;
      break label630;
      i = 0;
      break label630;
      label697:
      if (!TextUtils.isEmpty(str2))
      {
        localObject2 = com.tencent.matrix.c.a.axV();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.matrix.a.c)localObject2).eOc.ePD.ePy;
          if (j == Process.myPid()) {
            if ((((List)localObject2).contains("all")) || (((List)localObject2).contains("main"))) {
              i = 1;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label953;
        }
        locall = (l)com.tencent.matrix.a.a.aj(l.class);
        parama = locald;
        localObject2 = localObject4;
        if (locall != null)
        {
          localObject3 = locall.mT(j);
          parama = locald;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (localObject3 != null)
          {
            localObject2 = "looperTask";
            parama = locall.h(j, l3, l1);
            localObject1 = localObject3;
          }
        }
        break;
        i = 0;
        continue;
        if (((List)localObject2).contains("all"))
        {
          localObject2 = Thread.getAllStackTraces().keySet().iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (!((Thread)((Iterator)localObject2).next()).getName().contains(str2));
          i = 1;
        }
        else
        {
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext()) {
              if (((String)((Iterator)localObject2).next()).contains(str2))
              {
                i = 1;
                break;
              }
            }
          }
          i = 0;
        }
      }
      label953:
      if (!TextUtils.isEmpty(str2)) {}
      for (boolean bool = str2.contains("IPCThreadPool#");; bool = false)
      {
        localObject1 = parama;
        if (!bool) {
          break label1115;
        }
        locald = (com.tencent.matrix.c.d)com.tencent.matrix.a.a.aj(com.tencent.matrix.c.d.class);
        localObject1 = parama;
        if (locald == null) {
          break label1115;
        }
        localObject2 = locald.mT(j);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label1115;
        }
        localObject3 = "ipcTask";
        parama = locald.h(j, l3, l1);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
      }
      label1048:
      parama = parama.axF();
      if ((parama != null) && (!TextUtils.isEmpty(parama.key)) && (!parama.key.equals("thread_pool@idle")))
      {
        str1 = parama.key;
        i = parama.ratio;
        l1 = parama.eUx;
        j = 1;
        break label476;
      }
      label1102:
      l1 = 0L;
      i = 0;
      break label476;
      label1110:
      k = 0;
      break label547;
      label1115:
      parama = null;
      localObject2 = localObject3;
      break;
      label1124:
      localObject3 = null;
      localObject1 = parama;
      parama = (m.a.a<j.b>)localObject3;
      continue;
      label1136:
      parama = null;
      localObject1 = null;
    }
  }
  
  public static int dD(boolean paramBoolean)
  {
    int j = com.tencent.matrix.a.b.b.k(MMApplicationContext.getContext(), paramBoolean);
    int i = j;
    if (j == 2)
    {
      i = j;
      if (ac.aCN().aCO()) {
        i = 4;
      }
    }
    return i;
  }
  
  static String gS(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains("[GT]ColdPool#")) {
        break label25;
      }
      str = "[GT]ColdPool";
    }
    label25:
    do
    {
      return str;
      if (paramString.contains("[GT]HotPool#")) {
        return "[GT]HotPool";
      }
      str = paramString;
    } while (!paramString.contains("mars::"));
    return "mars::xxx";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.c.a
 * JD-Core Version:    0.7.0.1
 */