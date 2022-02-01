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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends com.tencent.mm.plugin.appbrand.y.a
{
  private static final AppBrandProcessSuicideLogic jGy;
  private final AtomicBoolean jGA;
  private final AtomicInteger jGz;
  
  static
  {
    AppMethodBeat.i(44125);
    jGy = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.jGz = new AtomicInteger(0);
    this.jGA = new AtomicBoolean();
    AppMethodBeat.o(44119);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(222098);
    RebootProcessAndTask localRebootProcessAndTask = new RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = ak.getProcessName();
    paramAppBrandUI = AppBrandUI.Q(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.jGE = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.jGF = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.cHu = paramString;
    AppBrandMainProcessService.b(localRebootProcessAndTask);
    paramAppBrandUI = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramAppBrandUI.ahE(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)paramAppBrandUI.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "java/lang/System_EXEC_", "exit", "(I)V");
    paramAppBrandUI = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    paramString = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramAppBrandUI.ahE(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramAppBrandUI.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessAndTask", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;Ljava/lang/String;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(222098);
  }
  
  public static void aZa()
  {
    AppMethodBeat.i(44120);
    jGy.jGA.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void aZb()
  {
    AppMethodBeat.i(44123);
    Object localObject1 = new ProcessRestartTask();
    ((ProcessRestartTask)localObject1).mProcessName = ak.getProcessName();
    ((ProcessRestartTask)localObject1).jGD = com.tencent.mm.plugin.appbrand.task.c.bzk();
    AppBrandMainProcessService.b((MainProcessTask)localObject1);
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
    localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic", "rebootProcessImmediately", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(44123);
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(jGy);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.jGA.set(false);
    this.jGz.incrementAndGet();
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.jGz.decrementAndGet() == 0) {
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
    public String jGC;
    public e jGD;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(44114);
      com.tencent.mm.modelappbrand.b.CB(this.mProcessName);
      f.a(this.jGC, this.jGD);
      AppMethodBeat.o(44114);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.jGC = paramParcel.readString();
      try
      {
        this.jGD = e.vy(paramParcel.readInt());
        AppMethodBeat.o(44116);
        return;
      }
      catch (Exception paramParcel)
      {
        ae.e("MicroMsg.AppBrandProcessSuicideLogic", "ProcessRestartTask.parseFromParcel, deserialize mPreloadType get exception:%s", new Object[] { paramParcel });
        this.jGD = e.mDg;
        AppMethodBeat.o(44116);
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.jGC);
      paramParcel.writeInt(this.jGD.code);
      AppMethodBeat.o(44115);
    }
  }
  
  public static class RebootProcessAndTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RebootProcessAndTask> CREATOR;
    public String cHu;
    public AppBrandInitConfigWC jGE;
    public AppBrandStatObject jGF;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(222097);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(222097);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(222094);
      com.tencent.mm.modelappbrand.b.CB(this.mProcessName);
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222092);
          Toast.makeText(ak.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.cHu, 1).show();
          f.g(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.jGE, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.jGF);
          AppMethodBeat.o(222092);
        }
      }, 500L);
      AppMethodBeat.o(222094);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(222096);
      this.mProcessName = paramParcel.readString();
      this.jGE = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.jGF = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
      this.cHu = paramParcel.readString();
      AppMethodBeat.o(222096);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(222095);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeParcelable(this.jGE, paramInt);
      paramParcel.writeParcelable(this.jGF, paramInt);
      paramParcel.writeString(this.cHu);
      AppMethodBeat.o(222095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */