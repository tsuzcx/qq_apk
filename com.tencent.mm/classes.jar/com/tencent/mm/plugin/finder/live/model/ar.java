package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.plugin.performance.watchdogs.d;
import com.tencent.mm.plugin.performance.watchdogs.d.b;
import com.tencent.mm.plugin.performance.watchdogs.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/LiveExceptionMonitor;", "", "()V", "TAG", "", "checkAndReportExceptionQuit", "", "enterLive", "liveId", "", "exitLive", "fillMonitorInfo", "floatWin", "normalWin", "onAppBackground", "onAppForeground", "onScreenStateChanged", "intent", "Landroid/content/Intent;", "reset", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
{
  public static final ar CIh;
  
  static
  {
    AppMethodBeat.i(360187);
    CIh = new ar();
    AppMethodBeat.o(360187);
  }
  
  public static void aw(Intent paramIntent)
  {
    AppMethodBeat.i(360118);
    h.ahAA.g(new ar..ExternalSyntheticLambda1(paramIntent), "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360118);
  }
  
  private static final void ax(Intent paramIntent)
  {
    AppMethodBeat.i(360170);
    if (paramIntent != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
      if (s.p("android.intent.action.SCREEN_ON", paramIntent.getAction()))
      {
        paramIntent = e.e.mKl;
        localMultiProcessMMKV.putBoolean(e.e.bcF(), false);
        localMultiProcessMMKV.commit();
        AppMethodBeat.o(360170);
        return;
      }
      if (s.p("android.intent.action.SCREEN_OFF", paramIntent.getAction()))
      {
        paramIntent = e.e.mKl;
        localMultiProcessMMKV.putBoolean(e.e.bcF(), true);
        localMultiProcessMMKV.commit();
      }
    }
    AppMethodBeat.o(360170);
  }
  
  public static void emg()
  {
    AppMethodBeat.i(360081);
    h.ahAA.g(ar..ExternalSyntheticLambda8.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360081);
  }
  
  public static void emh()
  {
    AppMethodBeat.i(360089);
    h.ahAA.g(ar..ExternalSyntheticLambda3.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360089);
  }
  
  public static void emi()
  {
    AppMethodBeat.i(360095);
    h.ahAA.g(ar..ExternalSyntheticLambda4.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360095);
  }
  
  public static void emj()
  {
    AppMethodBeat.i(360105);
    h.ahAA.g(ar..ExternalSyntheticLambda6.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360105);
  }
  
  public static void emk()
  {
    AppMethodBeat.i(360112);
    h.ahAA.g(ar..ExternalSyntheticLambda5.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360112);
  }
  
  public static void eml()
  {
    AppMethodBeat.i(360122);
    h.ahAA.g(ar..ExternalSyntheticLambda7.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360122);
  }
  
  public static void emm()
  {
    AppMethodBeat.i(360127);
    h.ahAA.g(ar..ExternalSyntheticLambda2.INSTANCE, "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360127);
  }
  
  private static final void emn()
  {
    AppMethodBeat.i(360137);
    Log.i("Finder.LiveExceptionMonitor", "exitLive");
    reset();
    AppMethodBeat.o(360137);
  }
  
  private static final void emo()
  {
    AppMethodBeat.i(360143);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    Object localObject = e.e.mKl;
    localMultiProcessMMKV.putInt(e.e.bcB(), f.gzF());
    localObject = e.e.mKl;
    localMultiProcessMMKV.putInt(e.e.bcC(), f.gzD());
    localObject = e.e.mKl;
    localObject = e.e.bcD();
    String str = d.gzs().af(false, 4).toString();
    s.s(str, "getDog().dumpMemory(fals…CE_CRASH_DUMP).toString()");
    localMultiProcessMMKV.putString((String)localObject, n.m(str, ",", ";", false));
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.euQ();
    if (localObject != null)
    {
      int i = ((Number)localObject).intValue();
      localObject = e.e.mKl;
      localMultiProcessMMKV.putInt(e.e.bcE(), i);
    }
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360143);
  }
  
  private static final void emp()
  {
    AppMethodBeat.i(360147);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    e.e locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcA(), true);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360147);
  }
  
  private static final void emq()
  {
    AppMethodBeat.i(360151);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    e.e locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcA(), false);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360151);
  }
  
  private static final void emr()
  {
    AppMethodBeat.i(360165);
    Object localObject1 = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    Object localObject2 = e.e.mKl;
    long l = ((MultiProcessMMKV)localObject1).getLong(e.e.bcy(), 0L);
    localObject2 = e.e.mKl;
    boolean bool2 = ((MultiProcessMMKV)localObject1).getBoolean(e.e.bcz(), false);
    localObject2 = e.e.mKl;
    boolean bool3 = ((MultiProcessMMKV)localObject1).getBoolean(e.e.bcA(), false);
    localObject2 = e.e.mKl;
    int i = ((MultiProcessMMKV)localObject1).getInt(e.e.bcB(), 0);
    localObject2 = e.e.mKl;
    int j = ((MultiProcessMMKV)localObject1).getInt(e.e.bcC(), 0);
    localObject2 = e.e.mKl;
    boolean bool4 = ((MultiProcessMMKV)localObject1).getBoolean(e.e.bcF(), false);
    localObject2 = e.e.mKl;
    int k = ((MultiProcessMMKV)localObject1).getInt(e.e.bcE(), 0);
    localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject2 = com.tencent.mm.plugin.finder.live.utils.a.euQ();
    Object localObject3 = s.X(MMApplicationContext.getContext().getFilesDir().getAbsolutePath(), "/crashFlag.live");
    boolean bool5 = y.ZC((String)localObject3);
    boolean bool6 = y.deleteFile((String)localObject3);
    localObject3 = e.e.mKl;
    localObject1 = ((MultiProcessMMKV)localObject1).getString(e.e.bcD(), "");
    Log.i("Finder.LiveExceptionMonitor", "checkAndReportExceptionQuit [lastLiveId:" + l + ", isForeground:" + bool2 + ", isFloat:" + bool3 + ", screenOff:" + bool4 + ", battery:" + k + ", curBattery:" + localObject2 + ", threadCntInProcess:" + i + ", threadCntInJava:" + j + ", meminfo:" + localObject1 + " hasStack:" + bool5 + " deleteSuc:" + bool6);
    localObject3 = (e)b.HbT;
    if (l == 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      e.a.a((e)localObject3, "liveKillByUserOrSys", bool1, null, false, (kotlin.g.a.a)new ar.a(l, bool3, bool2, i, j, bool4, k, (Integer)localObject2, (String)localObject1, bool5, bool6), 28);
      reset();
      AppMethodBeat.o(360165);
      return;
    }
  }
  
  private static final void ems()
  {
    AppMethodBeat.i(360174);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    e.e locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcz(), true);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360174);
  }
  
  private static final void emt()
  {
    AppMethodBeat.i(360178);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    e.e locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcz(), false);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360178);
  }
  
  public static void ok(long paramLong)
  {
    AppMethodBeat.i(360070);
    h.ahAA.g(new ar..ExternalSyntheticLambda0(paramLong), "Finder.LiveExceptionMonitor");
    AppMethodBeat.o(360070);
  }
  
  private static final void ol(long paramLong)
  {
    AppMethodBeat.i(360133);
    Log.i("Finder.LiveExceptionMonitor", s.X("enterLive liveId:", Long.valueOf(paramLong)));
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    e.e locale = e.e.mKl;
    localMultiProcessMMKV.putLong(e.e.bcy(), paramLong);
    locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcF(), false);
    locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcA(), false);
    locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcz(), true);
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360133);
  }
  
  private static void reset()
  {
    AppMethodBeat.i(360063);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("live_exception_monitor");
    localMultiProcessMMKV.putString("crashStack", "");
    e.e locale = e.e.mKl;
    localMultiProcessMMKV.putLong(e.e.bcy(), 0L);
    locale = e.e.mKl;
    localMultiProcessMMKV.putString(e.e.bcD(), "");
    locale = e.e.mKl;
    localMultiProcessMMKV.putInt(e.e.bcE(), 0);
    locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcz(), false);
    locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcA(), false);
    locale = e.e.mKl;
    localMultiProcessMMKV.putInt(e.e.bcB(), 0);
    locale = e.e.mKl;
    localMultiProcessMMKV.putInt(e.e.bcC(), 0);
    locale = e.e.mKl;
    localMultiProcessMMKV.putBoolean(e.e.bcF(), false);
    locale = e.e.mKl;
    localMultiProcessMMKV.putString(e.e.bcD(), "");
    localMultiProcessMMKV.commit();
    AppMethodBeat.o(360063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ar
 * JD-Core Version:    0.7.0.1
 */