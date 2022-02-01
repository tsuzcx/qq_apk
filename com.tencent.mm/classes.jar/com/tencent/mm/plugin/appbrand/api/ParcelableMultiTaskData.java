package com.tencent.mm.plugin.appbrand.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aco;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "commData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "api-protocol_release"})
public final class ParcelableMultiTaskData
  implements Parcelable
{
  public static final a CREATOR;
  public aco nBo;
  
  static
  {
    AppMethodBeat.i(191293);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(191293);
  }
  
  public ParcelableMultiTaskData() {}
  
  public ParcelableMultiTaskData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(191292);
    paramParcel = com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), paramParcel);
    if (paramParcel == null)
    {
      paramParcel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CommonMultiTaskData");
      AppMethodBeat.o(191292);
      throw paramParcel;
    }
    this.nBo = ((aco)paramParcel);
    AppMethodBeat.o(191292);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(191290);
    p.k(paramParcel, "dest");
    com.tencent.mm.ipcinvoker.extension.c.a(this.nBo, paramParcel);
    AppMethodBeat.o(191290);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "api-protocol_release"})
  public static final class a
    implements Parcelable.Creator<ParcelableMultiTaskData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData
 * JD-Core Version:    0.7.0.1
 */