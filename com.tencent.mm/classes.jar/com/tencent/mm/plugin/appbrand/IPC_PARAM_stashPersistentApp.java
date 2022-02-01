package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "processName", "taskController", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getProcessName", "setProcessName", "getTaskController", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;", "setTaskController", "(Lcom/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class IPC_PARAM_stashPersistentApp
  implements Parcelable
{
  public static final Parcelable.Creator<IPC_PARAM_stashPersistentApp> CREATOR;
  public static final a jDL;
  String appId;
  AppBrandRemoteTaskController jDK;
  String processName;
  
  static
  {
    AppMethodBeat.i(50155);
    jDL = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50155);
  }
  
  public IPC_PARAM_stashPersistentApp(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(50154);
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
      this.jDK = ((AppBrandRemoteTaskController)paramParcel);
      AppMethodBeat.o(50154);
      return;
    }
    AppMethodBeat.o(50154);
  }
  
  public IPC_PARAM_stashPersistentApp(String paramString1, String paramString2, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    this.appId = paramString1;
    this.processName = paramString2;
    this.jDK = paramAppBrandRemoteTaskController;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50153);
    p.h(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.processName);
    if (this.jDK != null)
    {
      paramParcel.writeBundle(AppBrandMainProcessService.a((MainProcessTask)this.jDK, true));
      AppMethodBeat.o(50153);
      return;
    }
    paramParcel.writeBundle(null);
    AppMethodBeat.o(50153);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<IPC_PARAM_stashPersistentApp>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.IPC_PARAM_stashPersistentApp
 * JD-Core Version:    0.7.0.1
 */