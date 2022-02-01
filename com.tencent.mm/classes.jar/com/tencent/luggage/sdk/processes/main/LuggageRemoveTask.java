package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageRemoveTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggageRemoveTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator<LuggageRemoveTask> CREATOR;
  private final RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220515);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220515);
  }
  
  public LuggageRemoveTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(220509);
    AppMethodBeat.o(220509);
  }
  
  public LuggageRemoveTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(220504);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220504);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void c(c<g> paramc)
  {
    AppMethodBeat.i(220524);
    s.u(paramc, "process");
    d.a locala = com.tencent.luggage.sdk.processes.d.eua;
    d.a.ask().a(this.euF.appId, this.euF.euz, (b)new b(paramc));
    AppMethodBeat.o(220524);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220530);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220530);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggageRemoveTask>
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<e, ah>
  {
    b(c<g> paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageRemoveTask
 * JD-Core Version:    0.7.0.1
 */