package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.main.LuggageMainProcessTaskExt;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandNotifyPauseTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandNotifyPauseTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator CREATOR;
  private final RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(283646);
    CREATOR = new AppBrandNotifyPauseTask.a();
    AppMethodBeat.o(283646);
  }
  
  public AppBrandNotifyPauseTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(283644);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(283644);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(283643);
    super.RW();
    e.qKN.amI(this.cCa.appId);
    AppMethodBeat.o(283643);
  }
  
  public final RuntimeInfo RX()
  {
    return this.cCa;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(283645);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable(this.cCa, paramInt);
    AppMethodBeat.o(283645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNotifyPauseTask
 * JD-Core Version:    0.7.0.1
 */