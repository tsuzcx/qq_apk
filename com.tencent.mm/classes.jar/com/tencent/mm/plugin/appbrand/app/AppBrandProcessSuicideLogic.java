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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends com.tencent.mm.plugin.appbrand.z.a
{
  private static final AppBrandProcessSuicideLogic jDA;
  private final AtomicInteger jDB;
  private final AtomicBoolean jDC;
  
  static
  {
    AppMethodBeat.i(44125);
    jDA = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.jDB = new AtomicInteger(0);
    this.jDC = new AtomicBoolean();
    AppMethodBeat.o(44119);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(187984);
    RebootProcessAndTask localRebootProcessAndTask = new RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = aj.getProcessName();
    paramAppBrandUI = AppBrandUI.Q(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.jDG = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.jDH = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.cGL = paramString;
    AppBrandMainProcessService.b(localRebootProcessAndTask);
    paramAppBrandUI = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramAppBrandUI.ahp(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramAppBrandUI.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    paramAppBrandUI = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramAppBrandUI.ahp(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramAppBrandUI.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(187984);
  }
  
  public static void aYE()
  {
    AppMethodBeat.i(44120);
    jDA.jDC.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void aYF()
  {
    AppMethodBeat.i(44123);
    Object localObject1 = new ProcessRestartTask();
    ((ProcessRestartTask)localObject1).mProcessName = aj.getProcessName();
    ((ProcessRestartTask)localObject1).jDF = com.tencent.mm.plugin.appbrand.task.c.byr();
    AppBrandMainProcessService.b((MainProcessTask)localObject1);
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(44123);
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(jDA);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.jDC.set(false);
    this.jDB.incrementAndGet();
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.jDB.decrementAndGet() == 0) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44112);
          AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, this.bQp);
          AppMethodBeat.o(44112);
        }
      }, "CleanupWhenNoActivitiesAliveInAppBrandProcess");
    }
    AppMethodBeat.o(44122);
  }
  
  public static class ProcessRestartTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ProcessRestartTask> CREATOR;
    public String jDE;
    public e jDF;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(44114);
      com.tencent.mm.modelappbrand.b.BZ(this.mProcessName);
      f.a(this.jDE, this.jDF);
      AppMethodBeat.o(44114);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.jDE = paramParcel.readString();
      try
      {
        this.jDF = e.vt(paramParcel.readInt());
        AppMethodBeat.o(44116);
        return;
      }
      catch (Exception paramParcel)
      {
        ad.e("MicroMsg.AppBrandProcessSuicideLogic", "ProcessRestartTask.parseFromParcel, deserialize mPreloadType get exception:%s", new Object[] { paramParcel });
        this.jDF = e.myi;
        AppMethodBeat.o(44116);
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.jDE);
      paramParcel.writeInt(this.jDF.code);
      AppMethodBeat.o(44115);
    }
  }
  
  public static class RebootProcessAndTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RebootProcessAndTask> CREATOR;
    public String cGL;
    public AppBrandInitConfigWC jDG;
    public AppBrandStatObject jDH;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(187983);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(187983);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(187980);
      com.tencent.mm.modelappbrand.b.BZ(this.mProcessName);
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187978);
          Toast.makeText(aj.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.cGL, 1).show();
          f.g(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.jDG, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.jDH);
          AppMethodBeat.o(187978);
        }
      }, 500L);
      AppMethodBeat.o(187980);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(187982);
      this.mProcessName = paramParcel.readString();
      this.jDG = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.jDH = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
      this.cGL = paramParcel.readString();
      AppMethodBeat.o(187982);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(187981);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeParcelable(this.jDG, paramInt);
      paramParcel.writeParcelable(this.jDH, paramInt);
      paramParcel.writeString(this.cGL);
      AppMethodBeat.o(187981);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */