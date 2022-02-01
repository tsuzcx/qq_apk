package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageUpdateTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "luggage-wechat-full-sdk_release"})
public final class LuggageUpdateTask
  extends LuggageRegisterTask
{
  public static final Parcelable.Creator CREATOR;
  private final RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(246665);
    CREATOR = new a();
    AppMethodBeat.o(246665);
  }
  
  public LuggageUpdateTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(246663);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(246663);
  }
  
  public final RuntimeInfo RX()
  {
    return this.cCa;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(246664);
    p.k(paramParcel, "parcel");
    this.cCa.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(246664);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(248872);
      p.k(paramParcel, "in");
      paramParcel = new LuggageUpdateTask((RuntimeInfo)RuntimeInfo.CREATOR.createFromParcel(paramParcel));
      AppMethodBeat.o(248872);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageUpdateTask[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageUpdateTask
 * JD-Core Version:    0.7.0.1
 */