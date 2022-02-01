package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggagePopRuntimeTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "setRuntimeInfo", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggagePopRuntimeTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator<LuggagePopRuntimeTask> CREATOR;
  private RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220474);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220474);
  }
  
  public LuggagePopRuntimeTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(220468);
    AppMethodBeat.o(220468);
  }
  
  public LuggagePopRuntimeTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(220460);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220460);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void asn()
  {
    AppMethodBeat.i(220480);
    super.asn();
    d.a locala = com.tencent.luggage.sdk.processes.d.eua;
    d.a.ask().fy(this.euF.appId);
    AppMethodBeat.o(220480);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220493);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220493);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggagePopRuntimeTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggagePopRuntimeTask
 * JD-Core Version:    0.7.0.1
 */