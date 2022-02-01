package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.e.d;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.luggage.sdk.processes.main.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandUpdateTask;", "Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "commLibVersion", "", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;I)V", "runtimeinfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;I)V", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandUpdateTask
  extends AppBrandRegisterTask
{
  public static final Parcelable.Creator<AppBrandUpdateTask> CREATOR;
  private final int tVP;
  private final RuntimeInfo tWR;
  
  static
  {
    AppMethodBeat.i(318623);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(318623);
  }
  
  public AppBrandUpdateTask(d paramd, int paramInt)
  {
    this(a.d(paramd), paramInt);
    AppMethodBeat.i(318618);
    AppMethodBeat.o(318618);
  }
  
  public AppBrandUpdateTask(RuntimeInfo paramRuntimeInfo, int paramInt)
  {
    super(paramRuntimeInfo, paramInt);
    AppMethodBeat.i(318610);
    this.tWR = paramRuntimeInfo;
    this.tVP = paramInt;
    AppMethodBeat.o(318610);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318634);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.tWR, paramInt);
    paramParcel.writeInt(this.tVP);
    AppMethodBeat.o(318634);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandUpdateTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandUpdateTask
 * JD-Core Version:    0.7.0.1
 */