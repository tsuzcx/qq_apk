package com.tencent.mm.plugin.appbrand;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.b.c.b;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListenerEx;", "enterSuspendTimestamp", "", "lastState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "mmCheckEventListener", "com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$mmCheckEventListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$mmCheckEventListener$1;", "systemLowMemoryListener", "com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$systemLowMemoryListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$systemLowMemoryListener$1;", "alive", "", "callback", "", "event", "dead", "onRunningStateChanged", "appId", "", "state", "onRunningStateSuspendTimeout", "shouldReportSuspendedTimeout", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandRuntimeSuspendingWatchDog$watch$1
  extends IListener<oc>
  implements c.b
{
  private long quO;
  private b quP;
  private final b quQ;
  private final mmCheckEventListener.1 quR;
  
  AppBrandRuntimeSuspendingWatchDog$watch$1(w paramw, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(316755);
    this.quS.qsB.a((c.a)this);
    this.quP = b.qKw;
    this.quQ = new b(this.quS, this);
    paramw = f.hfK;
    this.quR = new IListener(this.quS) {};
    AppMethodBeat.o(316755);
  }
  
  private final boolean ccu()
  {
    AppMethodBeat.i(316758);
    long l = this.quS.ccM().qYX;
    if ((this.quO > 0L) && (this.quO < Util.nowMilliSecond()) && (Util.nowMilliSecond() - this.quO > l * 1000L))
    {
      AppMethodBeat.o(316758);
      return true;
    }
    AppMethodBeat.o(316758);
    return false;
  }
  
  /* Error */
  public final void alive()
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 101	com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1:quQ	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$b;
    //   9: astore_2
    //   10: invokestatic 155	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   13: invokevirtual 160	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   16: astore_1
    //   17: aload_1
    //   18: instanceof 162
    //   21: ifeq +49 -> 70
    //   24: aload_1
    //   25: checkcast 162	android/app/Application
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +27 -> 57
    //   33: getstatic 168	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   36: astore_3
    //   37: aload_1
    //   38: aload_2
    //   39: checkcast 170	android/content/ComponentCallbacks
    //   42: invokevirtual 174	android/app/Application:registerComponentCallbacks	(Landroid/content/ComponentCallbacks;)V
    //   45: getstatic 180	kotlin/ah:aiuX	Lkotlin/ah;
    //   48: invokestatic 184	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: astore_1
    //   52: aload_1
    //   53: invokestatic 188	kotlin/Result:box-impl	(Ljava/lang/Object;)Lkotlin/Result;
    //   56: pop
    //   57: aload_0
    //   58: getfield 112	com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1:quR	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$mmCheckEventListener$1;
    //   61: invokevirtual 190	com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$mmCheckEventListener$1:alive	()V
    //   64: ldc 149
    //   66: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: aconst_null
    //   71: astore_1
    //   72: goto -43 -> 29
    //   75: astore_1
    //   76: getstatic 168	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   79: astore_2
    //   80: aload_1
    //   81: invokestatic 196	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   84: invokestatic 184	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: astore_1
    //   88: goto -36 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	1
    //   16	56	1	localObject1	Object
    //   75	6	1	localThrowable	java.lang.Throwable
    //   87	1	1	localObject2	Object
    //   9	71	2	localObject3	Object
    //   36	1	3	localCompanion	kotlin.Result.Companion
    // Exception table:
    //   from	to	target	type
    //   33	52	75	finally
  }
  
  public final void ccv()
  {
    AppMethodBeat.i(316783);
    Log.i("MicroMsg.AppBrandRuntimeSuspendingWatchDog", "onRunningStateSuspendTimeout, runtime(" + this.quS.mAppId + ')');
    h.OAn.kJ(1761, 1);
    AppMethodBeat.o(316783);
  }
  
  /* Error */
  public final void dead()
  {
    // Byte code:
    //   0: ldc_w 278
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 101	com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1:quQ	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$b;
    //   10: astore_2
    //   11: invokestatic 155	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   14: invokevirtual 160	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore_1
    //   18: aload_1
    //   19: instanceof 162
    //   22: ifeq +54 -> 76
    //   25: aload_1
    //   26: checkcast 162	android/app/Application
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +27 -> 58
    //   34: getstatic 168	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   37: astore_3
    //   38: aload_1
    //   39: aload_2
    //   40: checkcast 170	android/content/ComponentCallbacks
    //   43: invokevirtual 281	android/app/Application:unregisterComponentCallbacks	(Landroid/content/ComponentCallbacks;)V
    //   46: getstatic 180	kotlin/ah:aiuX	Lkotlin/ah;
    //   49: invokestatic 184	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic 188	kotlin/Result:box-impl	(Ljava/lang/Object;)Lkotlin/Result;
    //   57: pop
    //   58: aload_0
    //   59: getfield 112	com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1:quR	Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$mmCheckEventListener$1;
    //   62: invokevirtual 283	com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$mmCheckEventListener$1:dead	()V
    //   65: aload_0
    //   66: invokespecial 284	com/tencent/mm/sdk/event/IListener:dead	()V
    //   69: ldc_w 278
    //   72: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -48 -> 30
    //   81: astore_1
    //   82: getstatic 168	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   85: astore_2
    //   86: aload_1
    //   87: invokestatic 196	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   90: invokestatic 184	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: astore_1
    //   94: goto -41 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	1
    //   17	61	1	localObject1	Object
    //   81	6	1	localThrowable	java.lang.Throwable
    //   93	1	1	localObject2	Object
    //   10	76	2	localObject3	Object
    //   37	1	3	localCompanion	kotlin.Result.Companion
    // Exception table:
    //   from	to	target	type
    //   34	53	81	finally
  }
  
  public final void onRunningStateChanged(String paramString, b paramb)
  {
    AppMethodBeat.i(316780);
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramb, "state");
    switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      this.quO = 0L;
    }
    for (;;)
    {
      this.quP = paramb;
      AppMethodBeat.o(316780);
      return;
      dead();
      continue;
      Log.i("MicroMsg.AppBrandRuntimeSuspendingWatchDog", "onRunningStateChanged(SUSPEND) runtime(" + this.quS.mAppId + ')');
      this.quO = Util.nowMilliSecond();
      h.OAn.kJ(1761, 10);
      continue;
      if (b.qKy == this.quP)
      {
        Log.i("MicroMsg.AppBrandRuntimeSuspendingWatchDog", "onRunningStateChanged(FOREGROUND), lastState is SUSPEND, runtime(" + this.quS.mAppId + ')');
        h.OAn.kJ(1761, 11);
        if (ccu())
        {
          Log.i("MicroMsg.AppBrandRuntimeSuspendingWatchDog", "onRunningStateChanged(FOREGROUND), lastState is SUSPEND and exceeded timeout limit, runtime(" + this.quS.mAppId + ')');
          h.OAn.kJ(1761, 12);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$watch$1$systemLowMemoryListener$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$SystemLowMemoryListenerImpl;", "onLowMemory", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends t.a
  {
    b(w paramw, AppBrandRuntimeSuspendingWatchDog.watch.1 param1) {}
    
    public final void onLowMemory()
    {
      AppMethodBeat.i(316735);
      if (this.quS.qsB.qKC.chD() != b.qKy)
      {
        AppMethodBeat.o(316735);
        return;
      }
      if (AppBrandRuntimeSuspendingWatchDog.watch.1.a(jdField_this))
      {
        Log.e("MicroMsg.AppBrandRuntimeSuspendingWatchDog", "onLowMemory(), runtime(" + this.quS.mAppId + ") suspended but still remaining in memory, enterSuspendTimestamp(" + AppBrandRuntimeSuspendingWatchDog.watch.1.b(jdField_this) + ')');
        this.quS.finish();
        h.OAn.kJ(1761, 3);
      }
      AppMethodBeat.o(316735);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeSuspendingWatchDog.watch.1
 * JD-Core Version:    0.7.0.1
 */