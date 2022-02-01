package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.luggage.sdk.processes.main.LuggageRegisterTask;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.luggage.sdk.processes.main.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cs;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.sdk.event.IListener;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandRegisterTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "commLibVersion", "", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;I)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;I)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandRegisterTask
  extends LuggageRegisterTask
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final AppBrandRegisterTask.a qSj;
  private final RuntimeInfo cCa;
  private final int qRa;
  
  static
  {
    AppMethodBeat.i(266085);
    qSj = new AppBrandRegisterTask.a((byte)0);
    CREATOR = new AppBrandRegisterTask.b();
    AppMethodBeat.o(266085);
  }
  
  public AppBrandRegisterTask(com.tencent.luggage.sdk.e.d paramd, int paramInt)
  {
    this(a.d(paramd), paramInt);
    AppMethodBeat.i(266084);
    AppMethodBeat.o(266084);
  }
  
  public AppBrandRegisterTask(RuntimeInfo paramRuntimeInfo, int paramInt)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(266083);
    this.cCa = paramRuntimeInfo;
    this.qRa = paramInt;
    AppMethodBeat.o(266083);
  }
  
  public final RuntimeInfo RX()
  {
    return this.cCa;
  }
  
  public final void c(c<g> paramc)
  {
    AppMethodBeat.i(266082);
    p.k(paramc, "process");
    super.c(paramc);
    ((com.tencent.mm.plugin.appbrand.task.d)paramc).qRa = this.qRa;
    String str2 = this.cCa.appId;
    String str1 = this.cCa.cBH;
    paramc = paramc.ec(str2);
    if (paramc == null)
    {
      AppMethodBeat.o(266082);
      return;
    }
    paramc.ei(str1);
    if (h.bLi() != null)
    {
      h.bLi().a(this.cCa.userName, (AppBrandInitConfigLU)this.cCa.cCf);
      AppMethodBeat.o(266082);
      return;
    }
    paramc = this.cCa.cCf;
    if (paramc == null)
    {
      paramc = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC");
      AppMethodBeat.o(266082);
      throw paramc;
    }
    new c((AppBrandInitConfigWC)paramc).alive();
    AppMethodBeat.o(266082);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(266086);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable(this.cCa, paramInt);
    paramParcel.writeInt(this.qRa);
    AppMethodBeat.o(266086);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/task/ipc/AppBrandRegisterTask$runInMainProcess$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class c
    extends IListener<cs>
  {
    c(AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRegisterTask
 * JD-Core Version:    0.7.0.1
 */