package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageStashRuntimeTask;", "Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;)V", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "setRuntimeInfo", "describeContents", "", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-wechat-full-sdk_release"})
public final class LuggageStashRuntimeTask
  extends LuggageMainProcessTaskExt
{
  public static final Parcelable.Creator CREATOR;
  private RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(246205);
    CREATOR = new a();
    AppMethodBeat.o(246205);
  }
  
  public LuggageStashRuntimeTask(com.tencent.luggage.sdk.e.d paramd)
  {
    this(a.d(paramd));
    AppMethodBeat.i(246203);
    AppMethodBeat.o(246203);
  }
  
  public LuggageStashRuntimeTask(RuntimeInfo paramRuntimeInfo)
  {
    super(paramRuntimeInfo);
    AppMethodBeat.i(246202);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(246202);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(246200);
    super.RW();
    Object localObject = com.tencent.luggage.sdk.processes.d.cBy;
    localObject = d.a.RV();
    String str1 = this.cCa.appId;
    int i = this.cCa.cBU;
    int j = this.cCa.cxa;
    String str2 = this.cCa.cBH;
    p.k(str1, "appId");
    p.k(str2, "instanceId");
    Log.i("Luggage.LuggageMiniProgramProcessManager", "stashPersistentApp: appId[%s]versionType[%d]instanceId[%s]processIndex[%d]", new Object[] { str1, Integer.valueOf(i), str2, Integer.valueOf(j) });
    e locale = ((com.tencent.luggage.sdk.processes.d)localObject).iS(j).ec(str1);
    if (locale == null)
    {
      ((com.tencent.luggage.sdk.processes.d)localObject).iS(j).a(str1, true, i, str2);
      AppMethodBeat.o(246200);
      return;
    }
    locale.cxb = true;
    AppMethodBeat.o(246200);
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
    AppMethodBeat.i(246204);
    p.k(paramParcel, "parcel");
    this.cCa.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(246204);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(246480);
      p.k(paramParcel, "in");
      paramParcel = new LuggageStashRuntimeTask((RuntimeInfo)RuntimeInfo.CREATOR.createFromParcel(paramParcel));
      AppMethodBeat.o(246480);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageStashRuntimeTask[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageStashRuntimeTask
 * JD-Core Version:    0.7.0.1
 */