package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LuggageMainProcessTaskExt
  extends MainProcessTask
{
  public static final Parcelable.Creator<LuggageMainProcessTaskExt> CREATOR;
  private static final LuggageMainProcessTaskExt.a euH;
  private final RuntimeInfo euF;
  
  static
  {
    AppMethodBeat.i(220514);
    euH = new LuggageMainProcessTaskExt.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(220514);
  }
  
  public LuggageMainProcessTaskExt(RuntimeInfo paramRuntimeInfo)
  {
    AppMethodBeat.i(220508);
    this.euF = paramRuntimeInfo;
    AppMethodBeat.o(220508);
  }
  
  public RuntimeInfo asm()
  {
    return this.euF;
  }
  
  public void asn()
  {
    AppMethodBeat.i(220528);
    Object localObject1 = d.eua;
    localObject1 = d.a.ask().mt(asm().epc);
    Log.i("Luggage.LuggageMainProcessTaskExt", "runInMainProcess: [%s] run [%s] by process [%d]", new Object[] { asm().appId, getClass().getSimpleName(), Integer.valueOf(asm().epc) });
    try
    {
      c((c)localObject1);
      AppMethodBeat.o(220528);
      return;
    }
    finally
    {
      String str1 = getClass().getCanonicalName();
      String str2 = localObject2.getMessage();
      StackTraceElement[] arrayOfStackTraceElement = localObject2.getStackTrace();
      localObject1 = d.eua;
      Object localObject3 = (Iterable)d.a.ask().asg();
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((c)((Iterator)localObject3).next()).toString());
      }
      localObject3 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject3).hasNext())
      {
        localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
        AppMethodBeat.o(220528);
        throw ((Throwable)localObject1);
      }
      String str3;
      for (localObject1 = ((Iterator)localObject3).next(); ((Iterator)localObject3).hasNext(); localObject1 = (String)localObject1 + '\n' + str3)
      {
        str3 = (String)((Iterator)localObject3).next();
        localObject1 = (String)localObject1;
      }
      Log.e("Luggage.LuggageMainProcessTaskExt", "invoke[%s]: fatal error[%s][%s]\ndump processes[%s]\ndump origin invoke info[%s]", new Object[] { str1, str2, arrayOfStackTraceElement, (String)localObject1, asm() });
      AppMethodBeat.o(220528);
    }
  }
  
  public void c(c<g> paramc)
  {
    AppMethodBeat.i(220532);
    s.u(paramc, "process");
    AppMethodBeat.o(220532);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220535);
    s.u(paramParcel, "out");
    this.euF.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(220535);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<LuggageMainProcessTaskExt>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageMainProcessTaskExt
 * JD-Core Version:    0.7.0.1
 */