package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageStashRuntimeTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "setRuntimeInfo", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggageStashRuntimeTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator<LuggageStashRuntimeTask> CREATOR;
  private RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220506);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220506);
  }
  
  public LuggageStashRuntimeTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(220502);
    AppMethodBeat.o(220502);
  }
  
  public LuggageStashRuntimeTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(220498);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220498);
  }
  
  public final RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public final void asn()
  {
    AppMethodBeat.i(220518);
    super.asn();
    Object localObject = com.tencent.luggage.sdk.processes.d.eua;
    localObject = d.a.ask();
    String str1 = this.euF.appId;
    int i = this.euF.euz;
    int j = this.euF.epc;
    String str2 = this.euF.eup;
    s.u(str1, "appId");
    s.u(str2, "instanceId");
    Log.i("Luggage.LuggageMiniProgramProcessManager", "stashPersistentApp: appId[%s]versionType[%d]instanceId[%s]processIndex[%d]", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j) });
    e locale = ((com.tencent.luggage.sdk.processes.d)localObject).mt(j).fv(str1);
    if (locale == null)
    {
      ((com.tencent.luggage.sdk.processes.d)localObject).mt(j).a(str1, true, i, str2);
      AppMethodBeat.o(220518);
      return;
    }
    locale.epd = true;
    AppMethodBeat.o(220518);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220527);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220527);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggageStashRuntimeTask>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageStashRuntimeTask
 * JD-Core Version:    0.7.0.1
 */