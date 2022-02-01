package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller;", "", "()V", "CHECK_INTERVAL_MILLIS", "", "CHECK_USE_API21_PREDICATE", "", "CHECK_USE_API23_PREDICATE", "CHECK_USE_API29_PREDICATE", "CHECK_USE_PROCESS_ALIVE_PREDICATE", "TAG", "", "isBinderDiedCallbackRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isExptConfigsInitialized", "lastCheckTick", "onAppBrandProcessDied", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "checkAndKillZombieTasks", "", "scene", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$CheckScene;", "initExptConfigs", "postCheckTask", "reportIDKey", "ID", "", "key", "count", "dump", "Landroid/app/ActivityManager$RecentTaskInfo;", "AppBrandTaskPredicate", "CheckScene", "ZombieTaskPredicate", "ZombieTaskPredicateApi23", "ZombieTaskPredicateApi29", "ZombieTaskPredicateBase", "ZombieTaskPredicateDisabled", "ZombieTaskPredicateForDeadProcess", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static long mgb;
  public static final h qBQ;
  private static boolean qBR;
  private static boolean qBS;
  private static boolean qBT;
  private static boolean qBU;
  private static final AtomicBoolean qBV;
  private static final AtomicBoolean qBW;
  private static final o qBX;
  private static long quL;
  
  static
  {
    AppMethodBeat.i(317856);
    qBQ = new h();
    quL = TimeUnit.MINUTES.toMillis(1L);
    qBR = true;
    qBS = true;
    qBT = true;
    qBU = true;
    qBV = new AtomicBoolean(false);
    qBW = new AtomicBoolean(false);
    qBX = h..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(317856);
  }
  
  private static String a(ActivityManager.RecentTaskInfo paramRecentTaskInfo)
  {
    AppMethodBeat.i(317815);
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramRecentTaskInfo = paramRecentTaskInfo.toString();
      s.s(paramRecentTaskInfo, "{\n            this.toString()\n        }");
      AppMethodBeat.o(317815);
      return paramRecentTaskInfo;
    }
    try
    {
      String str = "RecentTaskInfo{id=" + paramRecentTaskInfo.id + " persistentId=" + paramRecentTaskInfo.persistentId + " baseIntent=" + paramRecentTaskInfo.baseIntent + " baseActivity=" + paramRecentTaskInfo.baseActivity + " topActivity=" + paramRecentTaskInfo.topActivity + " origActivity=" + paramRecentTaskInfo.origActivity + " numActivities=" + paramRecentTaskInfo.numActivities + '}';
      paramRecentTaskInfo = str;
    }
    finally
    {
      for (;;)
      {
        paramRecentTaskInfo = paramRecentTaskInfo.toString();
        s.s(paramRecentTaskInfo, "{\n                this.toString()\n            }");
      }
    }
    AppMethodBeat.o(317815);
    return paramRecentTaskInfo;
  }
  
  public static final void a(h.b paramb)
  {
    AppMethodBeat.i(317808);
    s.u(paramb, "scene");
    if (!qBV.getAndSet(true))
    {
      ceH();
      new AppBrandZombieTaskKiller.postCheckTask.1(f.hfK).alive();
    }
    if ((qBU) && (!qBW.getAndSet(true)))
    {
      Object localObject = com.tencent.mm.kernel.h.mDj;
      s.s(localObject, "PROCESS_APPBRAND_SUFFIX_ARRAY");
      localObject = (Object[])localObject;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = (String)localObject[i];
        j.b(s.X(MMApplicationContext.getApplicationId(), str), qBX);
        i += 1;
      }
    }
    if (Util.ticksToNow(mgb) < quL)
    {
      AppMethodBeat.o(317808);
      return;
    }
    mgb = Util.currentTicks();
    com.tencent.threadpool.h.ahAA.g(new h..ExternalSyntheticLambda1(paramb), "MicroMsg.AppBrandZombieTaskKiller");
    AppMethodBeat.o(317808);
  }
  
  /* Error */
  private static final void b(h.b paramb)
  {
    // Byte code:
    //   0: ldc_w 309
    //   3: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 311
    //   10: invokestatic 234	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: ldc_w 302
    //   16: ldc_w 313
    //   19: aload_0
    //   20: invokestatic 274	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: istore_3
    //   28: iconst_0
    //   29: istore_1
    //   30: invokestatic 322	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   33: ldc_w 324
    //   36: invokestatic 329	androidx/core/content/a:a	(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: checkcast 324	android/app/ActivityManager
    //   42: astore 5
    //   44: iload_3
    //   45: istore_2
    //   46: aload 5
    //   48: ifnull +218 -> 266
    //   51: aload 5
    //   53: invokevirtual 333	android/app/ActivityManager:getAppTasks	()Ljava/util/List;
    //   56: astore 5
    //   58: iload_3
    //   59: istore_2
    //   60: aload 5
    //   62: ifnull +204 -> 266
    //   65: aload 5
    //   67: checkcast 335	java/lang/Iterable
    //   70: invokeinterface 339 1 0
    //   75: astore 7
    //   77: iload_1
    //   78: istore_2
    //   79: aload 7
    //   81: invokeinterface 345 1 0
    //   86: ifeq +180 -> 266
    //   89: aload 7
    //   91: invokeinterface 349 1 0
    //   96: checkcast 351	android/app/ActivityManager$AppTask
    //   99: astore 6
    //   101: aload 6
    //   103: invokevirtual 355	android/app/ActivityManager$AppTask:getTaskInfo	()Landroid/app/ActivityManager$RecentTaskInfo;
    //   106: astore 5
    //   108: aload 5
    //   110: ifnonnull +126 -> 236
    //   113: aconst_null
    //   114: astore 5
    //   116: ldc_w 302
    //   119: ldc_w 357
    //   122: aload 5
    //   124: invokestatic 274	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   127: invokestatic 360	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: getstatic 364	com/tencent/mm/plugin/appbrand/app/h$a:qBY	Lcom/tencent/mm/plugin/appbrand/app/h$a;
    //   133: astore 8
    //   135: aload 6
    //   137: ldc_w 366
    //   140: invokestatic 171	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   143: aload 6
    //   145: invokestatic 369	com/tencent/mm/plugin/appbrand/app/h$a:a	(Landroid/app/ActivityManager$AppTask;)Z
    //   148: ifeq +201 -> 349
    //   151: getstatic 373	com/tencent/mm/plugin/appbrand/app/h$c:qCg	Lcom/tencent/mm/plugin/appbrand/app/h$c$a;
    //   154: astore 8
    //   156: invokestatic 379	com/tencent/mm/plugin/appbrand/app/h$c$a:ceO	()Lcom/tencent/mm/plugin/appbrand/app/h$c;
    //   159: aload 6
    //   161: invokeinterface 381 2 0
    //   166: istore 4
    //   168: iload 4
    //   170: ifeq +179 -> 349
    //   173: getstatic 387	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   176: astore 8
    //   178: aload 6
    //   180: invokevirtual 390	android/app/ActivityManager$AppTask:finishAndRemoveTask	()V
    //   183: getstatic 396	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   186: invokestatic 400	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: astore 6
    //   191: ldc_w 302
    //   194: new 173	java/lang/StringBuilder
    //   197: dup
    //   198: ldc_w 402
    //   201: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload 5
    //   206: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: ldc_w 404
    //   212: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 6
    //   217: invokestatic 408	kotlin/Result:toString-impl	(Ljava/lang/Object;)Ljava/lang/String;
    //   220: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: goto +116 -> 349
    //   236: aload 5
    //   238: invokestatic 410	com/tencent/mm/plugin/appbrand/app/h:a	(Landroid/app/ActivityManager$RecentTaskInfo;)Ljava/lang/String;
    //   241: astore 5
    //   243: goto -127 -> 116
    //   246: astore 6
    //   248: getstatic 387	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   251: astore 8
    //   253: aload 6
    //   255: invokestatic 416	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   258: invokestatic 400	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   261: astore 6
    //   263: goto -72 -> 191
    //   266: iload_2
    //   267: ifle +54 -> 321
    //   270: aload_0
    //   271: getfield 419	com/tencent/mm/plugin/appbrand/app/h$b:qBZ	I
    //   274: istore_1
    //   275: ldc_w 302
    //   278: new 173	java/lang/StringBuilder
    //   281: dup
    //   282: ldc_w 421
    //   285: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: iload_1
    //   289: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc_w 423
    //   295: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload_2
    //   299: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: getstatic 429	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   311: ldc2_w 430
    //   314: iload_1
    //   315: i2l
    //   316: iload_2
    //   317: i2l
    //   318: invokevirtual 435	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   321: ldc_w 309
    //   324: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: return
    //   328: astore_0
    //   329: ldc_w 302
    //   332: ldc_w 437
    //   335: aload_0
    //   336: invokestatic 274	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   339: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: ldc_w 309
    //   345: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: return
    //   349: goto -272 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramb	h.b
    //   29	286	1	i	int
    //   45	272	2	j	int
    //   27	32	3	k	int
    //   166	3	4	bool	boolean
    //   42	200	5	localObject1	Object
    //   99	117	6	localObject2	Object
    //   246	8	6	localThrowable	java.lang.Throwable
    //   261	1	6	localObject3	Object
    //   75	15	7	localIterator	Iterator
    //   133	119	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   173	191	246	finally
    //   13	26	328	finally
    //   30	44	328	finally
    //   51	58	328	finally
    //   65	77	328	finally
    //   79	108	328	finally
    //   116	168	328	finally
    //   191	229	328	finally
    //   236	243	328	finally
    //   248	263	328	finally
    //   270	321	328	finally
  }
  
  private static void ceH()
  {
    AppMethodBeat.i(317800);
    quL = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUa, quL);
    qBR = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUb, qBR);
    qBS = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUc, qBS);
    qBT = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUd, qBT);
    qBU = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yUe, qBU);
    AppMethodBeat.o(317800);
  }
  
  private static final void ceI()
  {
    AppMethodBeat.i(317818);
    if (qBU) {
      a(h.b.qCe);
    }
    AppMethodBeat.o(317818);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicateForDeadProcess;", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "()V", "isZombieTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class h
    implements h.c
  {
    public static final h qCo;
    
    static
    {
      AppMethodBeat.i(317769);
      qCo = new h();
      AppMethodBeat.o(317769);
    }
    
    public final boolean b(ActivityManager.AppTask paramAppTask)
    {
      AppMethodBeat.i(317775);
      s.u(paramAppTask, "appTask");
      if (!h.ceM())
      {
        AppMethodBeat.o(317775);
        return false;
      }
      try
      {
        paramAppTask = paramAppTask.getTaskInfo();
        if (paramAppTask == null) {
          paramAppTask = null;
        }
        while (paramAppTask == null)
        {
          AppMethodBeat.o(317775);
          return false;
          paramAppTask = paramAppTask.baseIntent;
          if (paramAppTask == null) {
            paramAppTask = null;
          } else {
            paramAppTask = paramAppTask.getComponent();
          }
        }
        PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
        if (localPackageManager == null)
        {
          AppMethodBeat.o(317775);
          return false;
        }
        Object localObject = (ActivityManager)a.a(MMApplicationContext.getContext(), ActivityManager.class);
        if (localObject == null)
        {
          AppMethodBeat.o(317775);
          return false;
        }
        paramAppTask = localPackageManager.getActivityInfo(paramAppTask, 128);
        s.s(paramAppTask, "pm.getActivityInfo(compo…ageManager.GET_META_DATA)");
        localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        s.s(localObject, "am.runningAppProcesses");
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (s.p(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName, paramAppTask.processName))
          {
            AppMethodBeat.o(317775);
            return false;
          }
        }
        AppMethodBeat.o(317775);
        return true;
      }
      finally
      {
        Log.e("MicroMsg.AppBrandZombieTaskKiller", s.X("ZombieTaskPredicateForDeadProcess.isZombieTask get exception ", paramAppTask));
        AppMethodBeat.o(317775);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h
 * JD-Core Version:    0.7.0.1
 */