package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageUpdateTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggageUpdateTask
  extends LuggageRegisterTask
{
  public static final Parcelable.Creator<LuggageUpdateTask> CREATOR;
  private final RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220475);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220475);
  }
  
  public LuggageUpdateTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(220470);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220470);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220482);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220482);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggageUpdateTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageUpdateTask
 * JD-Core Version:    0.7.0.1
 */