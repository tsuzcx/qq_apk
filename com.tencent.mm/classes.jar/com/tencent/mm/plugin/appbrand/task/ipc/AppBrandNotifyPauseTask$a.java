package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class AppBrandNotifyPauseTask$a
  implements Parcelable.Creator
{
  public final Object createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(283472);
    p.k(paramParcel, "in");
    paramParcel = new AppBrandNotifyPauseTask((RuntimeInfo)paramParcel.readParcelable(AppBrandNotifyPauseTask.class.getClassLoader()));
    AppMethodBeat.o(283472);
    return paramParcel;
  }
  
  public final Object[] newArray(int paramInt)
  {
    return new AppBrandNotifyPauseTask[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNotifyPauseTask.a
 * JD-Core Version:    0.7.0.1
 */