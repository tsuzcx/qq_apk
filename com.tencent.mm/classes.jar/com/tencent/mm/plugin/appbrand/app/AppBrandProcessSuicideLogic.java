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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends com.tencent.mm.plugin.appbrand.ac.a
{
  private static final AppBrandProcessSuicideLogic kIu;
  private final AtomicInteger kIv;
  private final AtomicBoolean kIw;
  private final Set<Activity> kIx;
  
  static
  {
    AppMethodBeat.i(44125);
    kIu = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.kIv = new AtomicInteger(0);
    this.kIw = new AtomicBoolean();
    this.kIx = new HashSet();
    AppMethodBeat.o(44119);
  }
  
  public static void C(Activity paramActivity)
  {
    AppMethodBeat.i(226305);
    AppBrandProcessSuicideLogic localAppBrandProcessSuicideLogic = kIu;
    if (localAppBrandProcessSuicideLogic.kIx.add(paramActivity)) {
      localAppBrandProcessSuicideLogic.kIv.incrementAndGet();
    }
    AppMethodBeat.o(226305);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(226307);
    RebootProcessAndTask localRebootProcessAndTask = new RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = MMApplicationContext.getProcessName();
    paramAppBrandUI = AppBrandUI.P(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.kID = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.kEH = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.cXS = paramString;
    AppBrandMainProcessService.b(localRebootProcessAndTask);
    paramAppBrandUI = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramAppBrandUI.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramAppBrandUI.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    paramAppBrandUI = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramAppBrandUI.axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramAppBrandUI.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(226307);
  }
  
  public static void bup()
  {
    AppMethodBeat.i(44120);
    kIu.kIw.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void buq()
  {
    AppMethodBeat.i(44123);
    Object localObject1 = new ProcessRestartTask();
    ((ProcessRestartTask)localObject1).mProcessName = MMApplicationContext.getProcessName();
    ((ProcessRestartTask)localObject1).kIB = e.bVP();
    AppBrandMainProcessService.b((MainProcessTask)localObject1);
    localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(44123);
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(kIu);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.kIw.set(false);
    if (this.kIx.add(paramActivity)) {
      this.kIv.incrementAndGet();
    }
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(final Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.kIx.remove(paramActivity)) {}
    for (int i = this.kIv.decrementAndGet();; i = this.kIv.get())
    {
      if (i == 0)
      {
        paramActivity = paramActivity.getClass();
        com.tencent.f.h.RTc.e(new Runnable()
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
    AppMethodBeat.i(226306);
    super.onActivityStopped(paramActivity);
    if (((paramActivity instanceof AppBrandUI)) && (paramActivity.isFinishing()))
    {
      paramActivity = d.nGE;
      d.aB("onActivityStopped", false);
    }
    AppMethodBeat.o(226306);
  }
  
  public static class ProcessRestartTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ProcessRestartTask> CREATOR;
    public String kIA;
    public g[] kIB;
    public int kIC;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(44114);
      b.Lm(this.mProcessName);
      g[] arrayOfg = this.kIB;
      int j = arrayOfg.length;
      int i = 0;
      while (i < j)
      {
        g localg = arrayOfg[i];
        com.tencent.mm.plugin.appbrand.task.h.bWb().a(this.kIA, localg);
        i += 1;
      }
      AppMethodBeat.o(44114);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.kIA = paramParcel.readString();
      this.kIC = paramParcel.readInt();
      this.kIB = new g[this.kIC];
      try
      {
        int[] arrayOfInt = new int[this.kIC];
        paramParcel.readIntArray(arrayOfInt);
        int i = 0;
        while (i < this.kIB.length)
        {
          this.kIB[i] = g.zm(arrayOfInt[i]);
          i += 1;
        }
        AppMethodBeat.o(44116);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.e("MicroMsg.AppBrandProcessSuicideLogic", "ProcessRestartTask.parseFromParcel, deserialize mPreloadType get exception:%s", new Object[] { paramParcel });
        Arrays.fill(this.kIB, g.nPF);
        AppMethodBeat.o(44116);
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.kIA);
      paramParcel.writeInt(this.kIB.length);
      int[] arrayOfInt = new int[this.kIB.length];
      paramInt = 0;
      while (paramInt < this.kIB.length)
      {
        arrayOfInt[paramInt] = this.kIB[paramInt].code;
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
    public String cXS;
    public AppBrandStatObject kEH;
    public AppBrandInitConfigWC kID;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(226304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(226304);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(226301);
      b.Lm(this.mProcessName);
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226299);
          Toast.makeText(MMApplicationContext.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.cXS, 1).show();
          com.tencent.mm.plugin.appbrand.task.h.bWb().g(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.kID, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.kEH);
          AppMethodBeat.o(226299);
        }
      }, 500L);
      AppMethodBeat.o(226301);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(226303);
      this.mProcessName = paramParcel.readString();
      this.kID = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.kEH = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
      this.cXS = paramParcel.readString();
      AppMethodBeat.o(226303);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(226302);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeParcelable(this.kID, paramInt);
      paramParcel.writeParcelable(this.kEH, paramInt);
      paramParcel.writeString(this.cXS);
      AppMethodBeat.o(226302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */