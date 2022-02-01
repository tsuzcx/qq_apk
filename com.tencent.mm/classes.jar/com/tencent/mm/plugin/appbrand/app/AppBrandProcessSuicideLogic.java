package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i.b;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends com.tencent.mm.plugin.appbrand.ac.a
{
  private static final AppBrandProcessSuicideLogic nCk;
  private final AtomicInteger nCl;
  private final AtomicBoolean nCm;
  private final Set<Activity> nCn;
  
  static
  {
    AppMethodBeat.i(44125);
    nCk = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.nCl = new AtomicInteger(0);
    this.nCm = new AtomicBoolean();
    this.nCn = new HashSet();
    AppMethodBeat.o(44119);
  }
  
  public static void B(Activity paramActivity)
  {
    AppMethodBeat.i(279376);
    AppBrandProcessSuicideLogic localAppBrandProcessSuicideLogic = nCk;
    if (localAppBrandProcessSuicideLogic.nCn.add(paramActivity)) {
      localAppBrandProcessSuicideLogic.nCl.incrementAndGet();
    }
    AppMethodBeat.o(279376);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(279384);
    RebootProcessAndTask localRebootProcessAndTask = new RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = MMApplicationContext.getProcessName();
    paramAppBrandUI = AppBrandUI.M(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.nCs = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.nyh = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.dbT = paramString;
    localRebootProcessAndTask.bPu();
    paramAppBrandUI = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramAppBrandUI.aFh(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramAppBrandUI.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    paramAppBrandUI = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramAppBrandUI.aFh(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramAppBrandUI.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(279384);
  }
  
  public static void bFp()
  {
    AppMethodBeat.i(44120);
    nCk.nCm.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void bFq()
  {
    AppMethodBeat.i(279379);
    try
    {
      KVCommCrossProcessReceiver.fBy();
      com.tencent.mm.plugin.appbrand.report.a.jy(true);
      com.tencent.mm.plugin.appbrand.report.d locald = com.tencent.mm.plugin.appbrand.report.d.qIP;
      com.tencent.mm.plugin.appbrand.report.d.aD("cleanupAndSuicideInWorker", false);
      AppMethodBeat.o(279379);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandProcessSuicideLogic", localException, "sendKV", new Object[0]);
      AppMethodBeat.o(279379);
    }
  }
  
  public static void bFr()
  {
    AppMethodBeat.i(44123);
    Object localObject1 = new ProcessRestartTask();
    ((ProcessRestartTask)localObject1).mProcessName = MMApplicationContext.getProcessName();
    Object localObject2 = com.tencent.mm.plugin.appbrand.task.h.ciX();
    ((ProcessRestartTask)localObject1).nCq = new LuggageServiceType[localObject2.length];
    ((ProcessRestartTask)localObject1).cxa = com.tencent.mm.plugin.appbrand.task.h.cxa;
    int i = 0;
    while (i < localObject2.length)
    {
      ((ProcessRestartTask)localObject1).nCq[i] = n.r(localObject2[i]);
      i += 1;
    }
    ((ProcessRestartTask)localObject1).bPu();
    localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(44123);
  }
  
  public static void e(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(nCk);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.nCm.set(false);
    if (this.nCn.add(paramActivity)) {
      this.nCl.incrementAndGet();
    }
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(final Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.nCn.remove(paramActivity)) {}
    for (int i = this.nCl.decrementAndGet();; i = this.nCl.get())
    {
      if (i == 0)
      {
        paramActivity = paramActivity.getClass();
        com.tencent.e.h.ZvG.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(44112);
            AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, paramActivity);
            AppMethodBeat.o(44112);
          }
        }, "CleanupWhenNoActivitiesAliveInAppBrandProcess");
      }
      AppMethodBeat.o(44122);
      return;
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(279381);
    super.onActivityStopped(paramActivity);
    if (((paramActivity instanceof AppBrandUI)) && (paramActivity.isFinishing()))
    {
      paramActivity = com.tencent.mm.plugin.appbrand.report.d.qIP;
      com.tencent.mm.plugin.appbrand.report.d.aD("onActivityStopped", false);
    }
    AppMethodBeat.o(279381);
  }
  
  public static class ProcessRestartTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ProcessRestartTask> CREATOR;
    public int cxa;
    public String mProcessName;
    public String nCp;
    public LuggageServiceType[] nCq;
    public int nCr;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(44114);
      b.bgM();
      LuggageServiceType[] arrayOfLuggageServiceType = this.nCq;
      int j = arrayOfLuggageServiceType.length;
      int i = 0;
      while (i < j)
      {
        LuggageServiceType localLuggageServiceType = arrayOfLuggageServiceType[i];
        com.tencent.mm.plugin.appbrand.task.i locali = com.tencent.mm.plugin.appbrand.task.i.cjb();
        int k = this.cxa;
        kotlin.g.b.p.k(localLuggageServiceType, "preloadType");
        com.tencent.mm.plugin.appbrand.task.d locald = (com.tencent.mm.plugin.appbrand.task.d)locali.RS().get(k);
        com.tencent.e.h.ZvG.n((Runnable)new i.b(locali, locald, localLuggageServiceType, k), 500L);
        i += 1;
      }
      AppMethodBeat.o(44114);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.nCp = paramParcel.readString();
      this.nCr = paramParcel.readInt();
      this.nCq = new LuggageServiceType[this.nCr];
      try
      {
        int[] arrayOfInt = new int[this.nCr];
        paramParcel.readIntArray(arrayOfInt);
        int i = 0;
        while (i < this.nCq.length)
        {
          this.nCq[i] = LuggageServiceType.values()[arrayOfInt[i]];
          i += 1;
        }
        AppMethodBeat.o(44116);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.e("MicroMsg.AppBrandProcessSuicideLogic", "ProcessRestartTask.parseFromParcel, deserialize mPreloadType get exception:%s", new Object[] { paramParcel });
        Arrays.fill(this.nCq, n.qRU);
        AppMethodBeat.o(44116);
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.nCp);
      paramParcel.writeInt(this.nCq.length);
      int[] arrayOfInt = new int[this.nCq.length];
      paramInt = 0;
      while (paramInt < this.nCq.length)
      {
        arrayOfInt[paramInt] = this.nCq[paramInt].ordinal();
        paramInt += 1;
      }
      paramParcel.writeIntArray(arrayOfInt);
      AppMethodBeat.o(44115);
    }
  }
  
  public static class RebootProcessAndTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RebootProcessAndTask> CREATOR;
    public String dbT;
    public String mProcessName;
    public AppBrandInitConfigWC nCs;
    public AppBrandStatObject nyh;
    
    static
    {
      AppMethodBeat.i(274336);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(274336);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(274333);
      b.bgM();
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(265613);
          Toast.makeText(MMApplicationContext.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.dbT, 1).show();
          com.tencent.mm.plugin.appbrand.task.p localp = new com.tencent.mm.plugin.appbrand.task.p(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.nCs, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.nyh);
          com.tencent.mm.plugin.appbrand.task.i.cjb().a(MMApplicationContext.getContext(), localp);
          AppMethodBeat.o(265613);
        }
      }, 500L);
      AppMethodBeat.o(274333);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(274335);
      this.mProcessName = paramParcel.readString();
      this.nCs = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.nyh = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
      this.dbT = paramParcel.readString();
      AppMethodBeat.o(274335);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(274334);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeParcelable(this.nCs, paramInt);
      paramParcel.writeParcelable(this.nyh, paramInt);
      paramParcel.writeString(this.dbT);
      AppMethodBeat.o(274334);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */