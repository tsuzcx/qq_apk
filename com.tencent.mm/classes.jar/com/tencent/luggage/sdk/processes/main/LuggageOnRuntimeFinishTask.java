package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageOnRuntimeFinishTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "setRuntimeInfo", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
public final class LuggageOnRuntimeFinishTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator CREATOR;
  private RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(242083);
    CREATOR = new a();
    AppMethodBeat.o(242083);
  }
  
  public LuggageOnRuntimeFinishTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(242081);
    AppMethodBeat.o(242081);
  }
  
  public LuggageOnRuntimeFinishTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(242080);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(242080);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(242079);
    super.RW();
    d.a locala = com.tencent.luggage.sdk.processes.d.cBy;
    d.a.RV().eg(this.cCa.appId);
    AppMethodBeat.o(242079);
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
    AppMethodBeat.i(242082);
    p.k(paramParcel, "parcel");
    this.cCa.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(242082);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(234074);
      p.k(paramParcel, "in");
      paramParcel = new LuggageOnRuntimeFinishTask((RuntimeInfo)RuntimeInfo.CREATOR.createFromParcel(paramParcel));
      AppMethodBeat.o(234074);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageOnRuntimeFinishTask[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageOnRuntimeFinishTask
 * JD-Core Version:    0.7.0.1
 */