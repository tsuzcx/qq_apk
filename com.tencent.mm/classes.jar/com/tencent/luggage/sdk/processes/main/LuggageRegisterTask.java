package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.f;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"})
public class LuggageRegisterTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final LuggageRegisterTask.a cCd;
  private final RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(243131);
    cCd = new LuggageRegisterTask.a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(243131);
  }
  
  public LuggageRegisterTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(243130);
    AppMethodBeat.o(243130);
  }
  
  public LuggageRegisterTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(243129);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(243129);
  }
  
  public RuntimeInfo RX()
  {
    return this.cCa;
  }
  
  public void c(c<g> paramc)
  {
    AppMethodBeat.i(243128);
    p.k(paramc, "process");
    String str = RX().appId;
    int i = RX().cBU;
    if (paramc.ec(str) == null) {
      paramc.a(RX().appId, RX().cBU, RX().cBH, RX().cxb);
    }
    paramc = paramc.ec(str);
    if (paramc != null)
    {
      f localf = f.cBN;
      p.k(localf, "status");
      paramc.cBJ = localf;
    }
    if (paramc != null) {
      paramc.cBI = i;
    }
    paramc = com.tencent.luggage.sdk.processes.d.cBy;
    d.a.RV().ef(str);
    AppMethodBeat.o(243128);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(243132);
    p.k(paramParcel, "parcel");
    this.cCa.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(243132);
  }
  
  @l(iBK={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(243359);
      p.k(paramParcel, "in");
      paramParcel = new LuggageRegisterTask((RuntimeInfo)RuntimeInfo.CREATOR.createFromParcel(paramParcel));
      AppMethodBeat.o(243359);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageRegisterTask[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageRegisterTask
 * JD-Core Version:    0.7.0.1
 */