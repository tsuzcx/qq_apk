package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class AppBrandRuntimePreloadNextInvoke$a
  implements Parcelable.Creator
{
  public final Object createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(270292);
    p.k(paramParcel, "in");
    paramParcel = new AppBrandRuntimePreloadNextInvoke((LuggageServiceType)Enum.valueOf(LuggageServiceType.class, paramParcel.readString()));
    AppMethodBeat.o(270292);
    return paramParcel;
  }
  
  public final Object[] newArray(int paramInt)
  {
    return new AppBrandRuntimePreloadNextInvoke[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRuntimePreloadNextInvoke.a
 * JD-Core Version:    0.7.0.1
 */