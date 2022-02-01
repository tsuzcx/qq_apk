package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.f;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageRegisterTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "describeContents", "", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LuggageRegisterTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator<LuggageRegisterTask> CREATOR;
  private static final LuggageRegisterTask.a euI;
  private final RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220500);
    euI = new LuggageRegisterTask.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(220500);
  }
  
  public LuggageRegisterTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(220494);
    AppMethodBeat.o(220494);
  }
  
  public LuggageRegisterTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(220485);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220485);
  }
  
  public RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public void c(c<g> paramc)
  {
    AppMethodBeat.i(220513);
    s.u(paramc, "process");
    String str = asm().appId;
    int i = asm().euz;
    if (paramc.fv(str) == null) {
      paramc.a(asm().appId, asm().euz, asm().eup, asm().epd);
    }
    paramc = paramc.fv(str);
    if (paramc != null)
    {
      f localf = f.eus;
      s.u(localf, "status");
      paramc.eum = localf;
    }
    if (paramc != null) {
      paramc.eul = i;
    }
    paramc = com.tencent.luggage.sdk.processes.d.eua;
    d.a.ask().fy(str);
    AppMethodBeat.o(220513);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220522);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220522);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<LuggageRegisterTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageRegisterTask
 * JD-Core Version:    0.7.0.1
 */