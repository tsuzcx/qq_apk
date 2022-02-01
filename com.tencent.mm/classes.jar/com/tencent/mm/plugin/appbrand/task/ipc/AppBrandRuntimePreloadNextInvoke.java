package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandRuntimePreloadNextInvoke;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "serviceType", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandRuntimePreloadNextInvoke
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRuntimePreloadNextInvoke> CREATOR;
  private static final AppBrandRuntimePreloadNextInvoke.a tWP;
  private final LuggageServiceType tWQ;
  
  static
  {
    AppMethodBeat.i(318621);
    tWP = new AppBrandRuntimePreloadNextInvoke.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(318621);
  }
  
  public AppBrandRuntimePreloadNextInvoke(LuggageServiceType paramLuggageServiceType)
  {
    AppMethodBeat.i(318612);
    this.tWQ = paramLuggageServiceType;
    AppMethodBeat.o(318612);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(318626);
    Log.i("MicroMsg.AppBrandRuntimePreloadNextInvoke", "runInMainProcess, serviceType:" + this.tWQ + ", isAppForeground:" + AppForegroundDelegate.heY.eLx);
    if (AppForegroundDelegate.heY.eLx)
    {
      i.a locala = i.tWq;
      i.a.cJV().a(this.tWQ, ab.tTJ);
    }
    AppMethodBeat.o(318626);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318632);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.tWQ, paramInt);
    AppMethodBeat.o(318632);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<AppBrandRuntimePreloadNextInvoke>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRuntimePreloadNextInvoke
 * JD-Core Version:    0.7.0.1
 */