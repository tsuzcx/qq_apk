package com.tencent.mm.plugin.appbrand;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "processName", "taskController", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getProcessName", "setProcessName", "getTaskController", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "setTaskController", "(Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class IPC_PARAM_stashPersistentApp
  implements Parcelable
{
  public static final Parcelable.Creator<IPC_PARAM_stashPersistentApp> CREATOR;
  public static final IPC_PARAM_stashPersistentApp.a gSd;
  String appId;
  AppBrandRemoteTaskController gSc;
  String processName;
  
  static
  {
    AppMethodBeat.i(143728);
    gSd = new IPC_PARAM_stashPersistentApp.a((byte)0);
    CREATOR = (Parcelable.Creator)new IPC_PARAM_stashPersistentApp.b();
    AppMethodBeat.o(143728);
  }
  
  public IPC_PARAM_stashPersistentApp(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(143727);
    this.appId = paramParcel.readString();
    this.processName = paramParcel.readString();
    paramParcel = paramParcel.readBundle(AppBrandRemoteTaskController.class.getClassLoader());
    if (paramParcel != null)
    {
      MainProcessTask localMainProcessTask = AppBrandMainProcessService.b(paramParcel, true);
      paramParcel = localMainProcessTask;
      if (!(localMainProcessTask instanceof AppBrandRemoteTaskController)) {
        paramParcel = null;
      }
      this.gSc = ((AppBrandRemoteTaskController)paramParcel);
      AppMethodBeat.o(143727);
      return;
    }
    AppMethodBeat.o(143727);
  }
  
  public IPC_PARAM_stashPersistentApp(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    this.appId = paramString1;
    this.processName = paramString2;
    this.gSc = paramAppBrandRemoteTaskController;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143726);
    j.q(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.processName);
    if (this.gSc != null)
    {
      paramParcel.writeBundle(AppBrandMainProcessService.a((MainProcessTask)this.gSc, true));
      AppMethodBeat.o(143726);
      return;
    }
    paramParcel.writeBundle(null);
    AppMethodBeat.o(143726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.IPC_PARAM_stashPersistentApp
 * JD-Core Version:    0.7.0.1
 */