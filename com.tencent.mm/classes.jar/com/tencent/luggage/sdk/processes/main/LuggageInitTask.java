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
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/main/LuggageInitTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "processName", "", "(Ljava/lang/String;)V", "runInMainProcess", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LuggageInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<LuggageInitTask> CREATOR;
  private final String processName;
  
  static
  {
    AppMethodBeat.i(220478);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(220478);
  }
  
  public LuggageInitTask(String paramString)
  {
    AppMethodBeat.i(220461);
    this.processName = paramString;
    AppMethodBeat.o(220461);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(220483);
    Object localObject1 = d.eua;
    Object localObject2 = d.a.ask();
    localObject1 = (b)new b(this);
    s.u(localObject1, "predicate");
    Object localObject3 = (Iterable)((d)localObject2).asg();
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
      j.b(((c)localObject2).getProcessName(), ((c)localObject2).etZ);
      ((c)localObject2).etW.set(true);
    }
    AppMethodBeat.o(220483);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(220491);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.processName);
    AppMethodBeat.o(220491);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LuggageInitTask>
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<c<g>, Boolean>
  {
    b(LuggageInitTask paramLuggageInitTask)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.main.LuggageInitTask
 * JD-Core Version:    0.7.0.1
 */