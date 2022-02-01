package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.e.d;
import com.tencent.luggage.sdk.processes.main.RuntimeInfo;
import com.tencent.luggage.sdk.processes.main.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandUpdateTask;", "Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandRegisterTask;", "rt", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "commLibVersion", "", "(Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;I)V", "runtimeinfo", "Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;", "(Lcom/tencent/luggage/sdk/processes/main/RuntimeInfo;I)V", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandUpdateTask
  extends AppBrandRegisterTask
{
  public static final Parcelable.Creator CREATOR;
  private final int qRa;
  private final RuntimeInfo qSm;
  
  static
  {
    AppMethodBeat.i(272092);
    CREATOR = new a();
    AppMethodBeat.o(272092);
  }
  
  public AppBrandUpdateTask(d paramd, int paramInt)
  {
    this(a.d(paramd), paramInt);
    AppMethodBeat.i(272090);
    AppMethodBeat.o(272090);
  }
  
  public AppBrandUpdateTask(RuntimeInfo paramRuntimeInfo, int paramInt)
  {
    super(paramRuntimeInfo, paramInt);
    AppMethodBeat.i(272089);
    this.qSm = paramRuntimeInfo;
    this.qRa = paramInt;
    AppMethodBeat.o(272089);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(272091);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable(this.qSm, paramInt);
    paramParcel.writeInt(this.qRa);
    AppMethodBeat.o(272091);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(266231);
      p.k(paramParcel, "in");
      paramParcel = new AppBrandUpdateTask((RuntimeInfo)paramParcel.readParcelable(AppBrandUpdateTask.class.getClassLoader()), paramParcel.readInt());
      AppMethodBeat.o(266231);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandUpdateTask[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandUpdateTask
 * JD-Core Version:    0.7.0.1
 */