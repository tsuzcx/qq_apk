package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class AppBrandRegisterTask$b
  implements Parcelable.Creator
{
  public final Object createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(264030);
    p.k(paramParcel, "in");
    paramParcel = new AppBrandRegisterTask((RuntimeInfo)paramParcel.readParcelable(AppBrandRegisterTask.class.getClassLoader()), paramParcel.readInt());
    AppMethodBeat.o(264030);
    return paramParcel;
  }
  
  public final Object[] newArray(int paramInt)
  {
    return new AppBrandRegisterTask[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRegisterTask.b
 * JD-Core Version:    0.7.0.1
 */