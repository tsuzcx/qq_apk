package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandRuntimePreloadNextInvoke;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "serviceType", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimePreloadNextInvoke
  extends MainProcessTask
{
  public static final Parcelable.Creator CREATOR;
  private final LuggageServiceType qSl;
  
  static
  {
    AppMethodBeat.i(276915);
    CREATOR = new AppBrandRuntimePreloadNextInvoke.a();
    AppMethodBeat.o(276915);
  }
  
  public AppBrandRuntimePreloadNextInvoke(LuggageServiceType paramLuggageServiceType)
  {
    AppMethodBeat.i(276913);
    this.qSl = paramLuggageServiceType;
    AppMethodBeat.o(276913);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(276912);
    i.a locala = i.qRL;
    i.a.cjb().a(this.qSl, z.qOS);
    AppMethodBeat.o(276912);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(276914);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.qSl.name());
    AppMethodBeat.o(276914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRuntimePreloadNextInvoke
 * JD-Core Version:    0.7.0.1
 */