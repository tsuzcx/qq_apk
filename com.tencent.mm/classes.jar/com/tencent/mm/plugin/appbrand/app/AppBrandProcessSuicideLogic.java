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
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.z.a;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends a
{
  private static final AppBrandProcessSuicideLogic jjL;
  private final AtomicInteger jjM;
  private final AtomicBoolean jjN;
  
  static
  {
    AppMethodBeat.i(44125);
    jjL = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.jjM = new AtomicInteger(0);
    this.jjN = new AtomicBoolean();
    AppMethodBeat.o(44119);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(186297);
    RebootProcessAndTask localRebootProcessAndTask = new RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = ai.getProcessName();
    paramAppBrandUI = AppBrandUI.O(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.jjQ = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.jjR = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.cvQ = paramString;
    AppBrandMainProcessService.b(localRebootProcessAndTask);
    System.exit(0);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(186297);
  }
  
  public static void aVj()
  {
    AppMethodBeat.i(44120);
    jjL.jjN.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void aVk()
  {
    AppMethodBeat.i(44123);
    ProcessRestartTask localProcessRestartTask = new ProcessRestartTask();
    localProcessRestartTask.mProcessName = ai.getProcessName();
    AppBrandMainProcessService.b(localProcessRestartTask);
    System.exit(0);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(44123);
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(jjL);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.jjN.set(false);
    this.jjM.incrementAndGet();
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.jjM.decrementAndGet() == 0) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44112);
          AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, this.bGb);
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
    public String jjP;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(44114);
      com.tencent.mm.modelappbrand.b.za(this.mProcessName);
      f.QU(this.jjP);
      AppMethodBeat.o(44114);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.jjP = paramParcel.readString();
      AppMethodBeat.o(44116);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.jjP);
      AppMethodBeat.o(44115);
    }
  }
  
  public static class RebootProcessAndTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RebootProcessAndTask> CREATOR;
    public String cvQ;
    public AppBrandInitConfigWC jjQ;
    public AppBrandStatObject jjR;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(186296);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(186296);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(186293);
      com.tencent.mm.modelappbrand.b.za(this.mProcessName);
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186291);
          Toast.makeText(ai.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.cvQ, 1).show();
          f.f(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.jjQ, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.jjR);
          AppMethodBeat.o(186291);
        }
      }, 500L);
      AppMethodBeat.o(186293);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(186295);
      this.mProcessName = paramParcel.readString();
      this.jjQ = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.jjR = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
      this.cvQ = paramParcel.readString();
      AppMethodBeat.o(186295);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(186294);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeParcelable(this.jjQ, paramInt);
      paramParcel.writeParcelable(this.jjR, paramInt);
      paramParcel.writeString(this.cvQ);
      AppMethodBeat.o(186294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */