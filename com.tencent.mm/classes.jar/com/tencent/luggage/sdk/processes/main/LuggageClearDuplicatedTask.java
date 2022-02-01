package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageClearDuplicatedTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "setRuntimeInfo", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggageClearDuplicatedTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator<LuggageClearDuplicatedTask> CREATOR;
  private RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220501);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220501);
  }
  
  public LuggageClearDuplicatedTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(220497);
    AppMethodBeat.o(220497);
  }
  
  public LuggageClearDuplicatedTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(220489);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220489);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void asn()
  {
    AppMethodBeat.i(220512);
    super.asn();
    d.a locala = com.tencent.luggage.sdk.processes.d.eua;
    d.a.ask().l(this.euF.epc, this.euF.appId);
    AppMethodBeat.o(220512);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220520);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220520);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggageClearDuplicatedTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageClearDuplicatedTask
 * JD-Core Version:    0.7.0.1
 */