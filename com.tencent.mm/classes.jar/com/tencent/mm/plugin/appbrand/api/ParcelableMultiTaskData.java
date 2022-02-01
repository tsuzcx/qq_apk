package com.tencent.mm.plugin.appbrand.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "commData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ParcelableMultiTaskData
  implements Parcelable
{
  public static final a CREATOR;
  public aet qAD;
  
  static
  {
    AppMethodBeat.i(319298);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(319298);
  }
  
  public ParcelableMultiTaskData() {}
  
  public ParcelableMultiTaskData(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(319292);
    paramParcel = com.tencent.mm.ipcinvoker.extension.c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), paramParcel);
    if (paramParcel == null)
    {
      paramParcel = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.CommonMultiTaskData");
      AppMethodBeat.o(319292);
      throw paramParcel;
    }
    this.qAD = ((aet)paramParcel);
    AppMethodBeat.o(319292);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(319303);
    s.u(paramParcel, "dest");
    com.tencent.mm.ipcinvoker.extension.c.a(this.qAD, paramParcel);
    AppMethodBeat.o(319303);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/api/ParcelableMultiTaskData;", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ParcelableMultiTaskData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData
 * JD-Core Version:    0.7.0.1
 */