package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageRemoveTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
public final class LuggageRemoveTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator CREATOR;
  private final RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(246752);
    CREATOR = new a();
    AppMethodBeat.o(246752);
  }
  
  public LuggageRemoveTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(246746);
    AppMethodBeat.o(246746);
  }
  
  public LuggageRemoveTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(246745);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(246745);
  }
  
  public final RuntimeInfo RX()
  {
    return this.cCa;
  }
  
  public final void c(c<g> paramc)
  {
    AppMethodBeat.i(246742);
    p.k(paramc, "process");
    d.a locala = com.tencent.luggage.sdk.processes.d.cBy;
    d.a.RV().a(this.cCa.appId, this.cCa.cBU, (b)new b(paramc));
    AppMethodBeat.o(246742);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(246749);
    p.k(paramParcel, "parcel");
    this.cCa.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(246749);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(234917);
      p.k(paramParcel, "in");
      paramParcel = new LuggageRemoveTask((RuntimeInfo)RuntimeInfo.CREATOR.createFromParcel(paramParcel));
      AppMethodBeat.o(234917);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageRemoveTask[paramInt];
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "invoke"})
  static final class b
    extends q
    implements b<e, x>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageRemoveTask
 * JD-Core Version:    0.7.0.1
 */