package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.luggage.sdk.processes.main.LuggageRegisterTask;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.luggage.sdk.processes.main.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandRegisterTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "commLibVersion", "", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;I)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;I)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class AppBrandRegisterTask
  extends LuggageRegisterTask
{
  public static final Parcelable.Creator<AppBrandRegisterTask> CREATOR;
  private static final AppBrandRegisterTask.a tWN;
  private final RuntimeInfo euF;
  private final int tVP;
  
  static
  {
    AppMethodBeat.i(318630);
    tWN = new AppBrandRegisterTask.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(318630);
  }
  
  public AppBrandRegisterTask(com.tencent.luggage.sdk.e.d paramd, int paramInt)
  {
    this(a.d(paramd), paramInt);
    AppMethodBeat.i(318624);
    AppMethodBeat.o(318624);
  }
  
  public AppBrandRegisterTask(RuntimeInfo paramRuntimeInfo, int paramInt)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(318620);
    this.euF = paramRuntimeInfo;
    this.tVP = paramInt;
    AppMethodBeat.o(318620);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void c(c<g> paramc)
  {
    AppMethodBeat.i(318647);
    s.u(paramc, "process");
    super.c(paramc);
    ((com.tencent.mm.plugin.appbrand.task.d)paramc).tVP = this.tVP;
    String str2 = this.euF.appId;
    String str1 = this.euF.eup;
    paramc = paramc.fv(str2);
    if (paramc == null)
    {
      AppMethodBeat.o(318647);
      return;
    }
    if (this.euF.euz != paramc.eul)
    {
      Log.e("MicroMsg.AppBrandRegisterTask", "runInMainProcess appId:" + this.euF.appId + ", instanceId:" + this.euF.eup + ", runtimeInfo.versionType(" + this.euF.euz + ") != record.debugType(" + paramc.eul + ')');
      AppMethodBeat.o(318647);
      return;
    }
    paramc.fB(str1);
    if (h.ckG() != null)
    {
      h.ckG().a(this.euF.userName, (AppBrandInitConfigLU)this.euF.euK);
      AppMethodBeat.o(318647);
      return;
    }
    new AppBrandRegisterTask.runInMainProcess.1((AppBrandInitConfigWC)this.euF.euK, f.hfK).alive();
    AppMethodBeat.o(318647);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(318649);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.euF, paramInt);
    paramParcel.writeInt(this.tVP);
    AppMethodBeat.o(318649);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<AppBrandRegisterTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRegisterTask
 * JD-Core Version:    0.7.0.1
 */