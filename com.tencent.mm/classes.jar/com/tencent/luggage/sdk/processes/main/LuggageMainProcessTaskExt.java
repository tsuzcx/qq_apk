package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageMainProcessTaskExt;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "runtimeInfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;)V", "getRuntimeInfo", "()Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "runInMainProcess", "", "process", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "Companion", "luggage-wechat-full-sdk_release"})
public class LuggageMainProcessTaskExt
  extends MainProcessTask
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final LuggageMainProcessTaskExt.a cCc;
  private final RuntimeInfo cCa;
  
  static
  {
    AppMethodBeat.i(233985);
    cCc = new LuggageMainProcessTaskExt.a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(233985);
  }
  
  public LuggageMainProcessTaskExt(RuntimeInfo paramRuntimeInfo)
  {
    AppMethodBeat.i(233984);
    this.cCa = paramRuntimeInfo;
    AppMethodBeat.o(233984);
  }
  
  public void RW()
  {
    AppMethodBeat.i(233981);
    Object localObject1 = d.cBy;
    localObject1 = d.a.RV().iS(RX().cxa);
    Log.i("Luggage.LuggageMainProcessTaskExt", "runInMainProcess: [%s] run [%s] by process [%d]", new Object[] { RX().appId, getClass().getSimpleName(), Integer.valueOf(RX().cxa) });
    try
    {
      c((c)localObject1);
      AppMethodBeat.o(233981);
      return;
    }
    catch (Throwable localThrowable)
    {
      String str1 = getClass().getCanonicalName();
      String str2 = localThrowable.getMessage();
      StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
      localObject1 = d.cBy;
      Object localObject2 = (Iterable)d.a.RV().RS();
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((c)((Iterator)localObject2).next()).toString());
      }
      localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext())
      {
        localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
        AppMethodBeat.o(233981);
        throw ((Throwable)localObject1);
      }
      String str3;
      for (localObject1 = ((Iterator)localObject2).next(); ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "\n" + str3)
      {
        str3 = (String)((Iterator)localObject2).next();
        localObject1 = (String)localObject1;
      }
      Log.e("Luggage.LuggageMainProcessTaskExt", "invoke[%s]: fatal error[%s][%s]\ndump processes[%s]\ndump origin invoke info[%s]", new Object[] { str1, str2, arrayOfStackTraceElement, (String)localObject1, RX() });
      AppMethodBeat.o(233981);
      throw localThrowable;
    }
  }
  
  public RuntimeInfo RX()
  {
    return this.cCa;
  }
  
  public void c(c<g> paramc)
  {
    AppMethodBeat.i(233982);
    p.k(paramc, "process");
    AppMethodBeat.o(233982);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(233986);
    p.k(paramParcel, "parcel");
    this.cCa.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(233986);
  }
  
  @l(iBK={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(243573);
      p.k(paramParcel, "in");
      paramParcel = new LuggageMainProcessTaskExt((RuntimeInfo)RuntimeInfo.CREATOR.createFromParcel(paramParcel));
      AppMethodBeat.o(243573);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new LuggageMainProcessTaskExt[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageMainProcessTaskExt
 * JD-Core Version:    0.7.0.1
 */