package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Pair;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends com.tencent.mm.plugin.appbrand.af.a
{
  private static final AppBrandProcessSuicideLogic qBy;
  private final AtomicBoolean qBA;
  private final Set<Activity> qBB;
  private final AtomicInteger qBz;
  
  static
  {
    AppMethodBeat.i(44125);
    qBy = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.qBz = new AtomicInteger(0);
    this.qBA = new AtomicBoolean();
    this.qBB = new HashSet();
    AppMethodBeat.o(44119);
  }
  
  public static void H(Activity paramActivity)
  {
    AppMethodBeat.i(317749);
    AppBrandProcessSuicideLogic localAppBrandProcessSuicideLogic = qBy;
    if (localAppBrandProcessSuicideLogic.qBB.add(paramActivity)) {
      localAppBrandProcessSuicideLogic.qBz.incrementAndGet();
    }
    AppMethodBeat.o(317749);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(317764);
    com.tencent.threadpool.h.ahAA.j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44112);
        AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.ceG(), null, AppBrandProcessSuicideLogic.this);
        AppMethodBeat.o(44112);
      }
    }, "MicroMsg.AppBrandProcessSuicideLogic");
    AppMethodBeat.o(317764);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(317776);
    AppBrandProcessSuicideLogic.RebootProcessAndTask localRebootProcessAndTask = new AppBrandProcessSuicideLogic.RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = MMApplicationContext.getProcessName();
    paramAppBrandUI = AppBrandUI.P(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.qBH = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.qxv = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.fas = paramString;
    localRebootProcessAndTask.cpB();
    paramAppBrandUI = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramAppBrandUI.aYi(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramAppBrandUI.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    paramAppBrandUI = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramAppBrandUI.aYi(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramAppBrandUI.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(317776);
  }
  
  public static void ceD()
  {
    AppMethodBeat.i(44120);
    qBy.qBA.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void ceE()
  {
    AppMethodBeat.i(317765);
    try
    {
      KVCommCrossProcessReceiver.gNR();
      com.tencent.mm.plugin.appbrand.report.a.kL(true);
      d locald = d.tNo;
      d.aP("cleanupAndSuicideInWorker", false);
      AppMethodBeat.o(317765);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandProcessSuicideLogic", localException, "sendKV", new Object[0]);
      AppMethodBeat.o(317765);
    }
  }
  
  public static void ceF()
  {
    AppMethodBeat.i(44123);
    Object localObject1 = new ProcessRestartTask();
    ((ProcessRestartTask)localObject1).mProcessName = MMApplicationContext.getProcessName();
    Object localObject2 = com.tencent.mm.plugin.appbrand.task.h.cJS();
    ((ProcessRestartTask)localObject1).qBF = new LuggageServiceType[localObject2.length];
    ((ProcessRestartTask)localObject1).epc = com.tencent.mm.plugin.appbrand.task.h.epc;
    int i = 0;
    while (i < localObject2.length)
    {
      ((ProcessRestartTask)localObject1).qBF[i] = l.r(localObject2[i]);
      i += 1;
    }
    ((ProcessRestartTask)localObject1).cpB();
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(44123);
  }
  
  public static void f(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(qBy);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.qBA.set(false);
    if (this.qBB.add(paramActivity)) {
      this.qBz.incrementAndGet();
    }
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(final Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.qBB.remove(paramActivity)) {}
    for (int i = this.qBz.decrementAndGet();; i = this.qBz.get())
    {
      if (i == 0)
      {
        paramActivity = paramActivity.getClass();
        com.tencent.threadpool.h.ahAA.j(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(317705);
            AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, paramActivity, AppBrandProcessSuicideLogic.a.qBJ);
            AppMethodBeat.o(317705);
          }
        }, "MicroMsg.AppBrandProcessSuicideLogic");
      }
      AppMethodBeat.o(44122);
      return;
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(317810);
    super.onActivityStopped(paramActivity);
    if (((paramActivity instanceof AppBrandUI)) && (paramActivity.isFinishing()))
    {
      paramActivity = d.tNo;
      d.aP("onActivityStopped", false);
    }
    AppMethodBeat.o(317810);
  }
  
  public static class ProcessRestartTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ProcessRestartTask> CREATOR;
    public int epc;
    public String mProcessName;
    public String qBE;
    public LuggageServiceType[] qBF;
    public int qBG;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(44114);
      com.tencent.mm.modelappbrand.c.bEE();
      LuggageServiceType[] arrayOfLuggageServiceType = this.qBF;
      int j = arrayOfLuggageServiceType.length;
      int i = 0;
      while (i < j)
      {
        LuggageServiceType localLuggageServiceType = arrayOfLuggageServiceType[i];
        com.tencent.mm.plugin.appbrand.task.i.cJV().a(this.epc, localLuggageServiceType);
        i += 1;
      }
      AppMethodBeat.o(44114);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.qBE = paramParcel.readString();
      this.qBG = paramParcel.readInt();
      this.qBF = new LuggageServiceType[this.qBG];
      try
      {
        int[] arrayOfInt = new int[this.qBG];
        paramParcel.readIntArray(arrayOfInt);
        int i = 0;
        while (i < this.qBF.length)
        {
          this.qBF[i] = LuggageServiceType.values()[arrayOfInt[i]];
          i += 1;
        }
        AppMethodBeat.o(44116);
        return;
      }
      catch (Exception paramParcel)
      {
        Log.e("MicroMsg.AppBrandProcessSuicideLogic", "ProcessRestartTask.parseFromParcel, deserialize mPreloadType get exception:%s", new Object[] { paramParcel });
        Arrays.fill(this.qBF, l.tWy);
        AppMethodBeat.o(44116);
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.qBE);
      paramParcel.writeInt(this.qBF.length);
      int[] arrayOfInt = new int[this.qBF.length];
      paramInt = 0;
      while (paramInt < this.qBF.length)
      {
        arrayOfInt[paramInt] = this.qBF[paramInt].ordinal();
        paramInt += 1;
      }
      paramParcel.writeIntArray(arrayOfInt);
      AppMethodBeat.o(44115);
    }
  }
  
  public static enum a
  {
    public final int qBN;
    
    static
    {
      AppMethodBeat.i(317678);
      qBJ = new a("NO_ACTIVITIES_LEFT", 0, 21);
      qBK = new a("NO_RUNTIMES_LEFT", 1, 22);
      qBL = new a("LOW_MEMORY", 2, 23);
      qBM = new a("BACKGROUND_MODERATE_AND_SPARE", 3, 24);
      qBO = new a[] { qBJ, qBK, qBL, qBM };
      AppMethodBeat.o(317678);
    }
    
    private a(int paramInt)
    {
      this.qBN = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */