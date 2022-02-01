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
import com.tencent.mm.plugin.appbrand.aa.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class AppBrandProcessSuicideLogic
  extends a
{
  private static final AppBrandProcessSuicideLogic iJF;
  private final AtomicInteger iJG;
  private final AtomicBoolean iJH;
  
  static
  {
    AppMethodBeat.i(44125);
    iJF = new AppBrandProcessSuicideLogic();
    AppMethodBeat.o(44125);
  }
  
  private AppBrandProcessSuicideLogic()
  {
    AppMethodBeat.i(44119);
    this.iJG = new AtomicInteger(0);
    this.iJH = new AtomicBoolean();
    AppMethodBeat.o(44119);
  }
  
  public static void a(AppBrandUI paramAppBrandUI, String paramString)
  {
    AppMethodBeat.i(195596);
    RebootProcessAndTask localRebootProcessAndTask = new RebootProcessAndTask();
    localRebootProcessAndTask.mProcessName = aj.getProcessName();
    paramAppBrandUI = AppBrandUI.O(paramAppBrandUI.getIntent());
    localRebootProcessAndTask.iJK = ((AppBrandInitConfigWC)paramAppBrandUI.first);
    localRebootProcessAndTask.iJL = ((AppBrandStatObject)paramAppBrandUI.second);
    localRebootProcessAndTask.cyH = paramString;
    AppBrandMainProcessService.b(localRebootProcessAndTask);
    System.exit(0);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(195596);
  }
  
  public static void aOr()
  {
    AppMethodBeat.i(44120);
    iJF.iJH.set(true);
    AppMethodBeat.o(44120);
  }
  
  public static void aOs()
  {
    AppMethodBeat.i(44123);
    ProcessRestartTask localProcessRestartTask = new ProcessRestartTask();
    localProcessRestartTask.mProcessName = aj.getProcessName();
    AppBrandMainProcessService.b(localProcessRestartTask);
    System.exit(0);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(44123);
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(44118);
    paramApplication.registerActivityLifecycleCallbacks(iJF);
    AppMethodBeat.o(44118);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44121);
    this.iJH.set(false);
    this.iJG.incrementAndGet();
    AppMethodBeat.o(44121);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(44122);
    if (this.iJG.decrementAndGet() == 0) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44112);
          AppBrandProcessSuicideLogic.a(AppBrandProcessSuicideLogic.this, this.bIt);
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
    public String iJJ;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(44117);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(44117);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(44114);
      com.tencent.mm.modelappbrand.b.uU(this.mProcessName);
      f.ML(this.iJJ);
      AppMethodBeat.o(44114);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(44116);
      this.mProcessName = paramParcel.readString();
      this.iJJ = paramParcel.readString();
      AppMethodBeat.o(44116);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(44115);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeString(this.iJJ);
      AppMethodBeat.o(44115);
    }
  }
  
  public static class RebootProcessAndTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<RebootProcessAndTask> CREATOR;
    public String cyH;
    public AppBrandInitConfigWC iJK;
    public AppBrandStatObject iJL;
    public String mProcessName;
    
    static
    {
      AppMethodBeat.i(195595);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195595);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(195592);
      com.tencent.mm.modelappbrand.b.uU(this.mProcessName);
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195590);
          Toast.makeText(aj.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.cyH, 1).show();
          f.f(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.iJK, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.iJL);
          AppMethodBeat.o(195590);
        }
      }, 500L);
      AppMethodBeat.o(195592);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(195594);
      this.mProcessName = paramParcel.readString();
      this.iJK = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.iJL = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
      this.cyH = paramParcel.readString();
      AppMethodBeat.o(195594);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195593);
      paramParcel.writeString(this.mProcessName);
      paramParcel.writeParcelable(this.iJK, paramInt);
      paramParcel.writeParcelable(this.iJL, paramInt);
      paramParcel.writeString(this.cyH);
      AppMethodBeat.o(195593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic
 * JD-Core Version:    0.7.0.1
 */