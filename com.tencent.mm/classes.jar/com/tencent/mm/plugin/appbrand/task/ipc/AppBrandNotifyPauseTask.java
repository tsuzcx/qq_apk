package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.main.LuggageMainProcessTaskExt;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.g;
import com.tencent.mm.plugin.appbrand.report.model.g.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandNotifyPauseTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandNotifyPauseTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator<AppBrandNotifyPauseTask> CREATOR;
  private final RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(318681);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(318681);
  }
  
  public AppBrandNotifyPauseTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(318676);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(318676);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void asn()
  {
    AppMethodBeat.i(318690);
    super.asn();
    Object localObject = g.tPs;
    String str = this.euF.appId;
    localObject = (g.a)((g)localObject).tPt.get(str);
    if (localObject != null) {
      ((g.a)localObject).tPv = Util.nowMilliSecond();
    }
    AppMethodBeat.o(318690);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318695);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.euF, paramInt);
    AppMethodBeat.o(318695);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandNotifyPauseTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNotifyPauseTask
 * JD-Core Version:    0.7.0.1
 */