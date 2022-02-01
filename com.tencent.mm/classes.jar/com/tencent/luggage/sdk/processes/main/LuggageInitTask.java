package com.tencent.luggage.sdk.processes.main;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.a;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.d;
import com.tencent.luggage.sdk.processes.d.a;
import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/main/LuggageInitTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "processName", "", "(Ljava/lang/String;)V", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "luggage-wechat-full-sdk_release"})
public final class LuggageInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator CREATOR;
  private final String processName;
  
  static
  {
    AppMethodBeat.i(242002);
    CREATOR = new LuggageInitTask.a();
    AppMethodBeat.o(242002);
  }
  
  public LuggageInitTask(String paramString)
  {
    AppMethodBeat.i(241994);
    this.processName = paramString;
    AppMethodBeat.o(241994);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(241992);
    Object localObject1 = d.cBy;
    Object localObject2 = d.a.RV();
    localObject1 = (b)new b(this);
    p.k(localObject1, "predicate");
    Object localObject3 = (Iterable)((d)localObject2).RS();
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (((Boolean)((b)localObject1).invoke((c)localObject4)).booleanValue()) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject1 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c)((Iterator)localObject1).next();
      j.a(((c)localObject2).getProcessName(), (Parcelable)new IPCString(((c)localObject2).getProcessName()), a.class);
      j.b(((c)localObject2).getProcessName(), ((c)localObject2).cBs);
      ((c)localObject2).cBp.set(true);
    }
    AppMethodBeat.o(241992);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(242000);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.processName);
    AppMethodBeat.o(242000);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "invoke"})
  static final class b
    extends q
    implements b<c<g>, Boolean>
  {
    b(LuggageInitTask paramLuggageInitTask)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageInitTask
 * JD-Core Version:    0.7.0.1
 */