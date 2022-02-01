package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "versionType", "(ILcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;I)V", "getCount", "()I", "getOrder", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "getVersionType", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class QueryParams
  implements Parcelable
{
  public static final a CREATOR;
  final int count;
  final int gXn;
  final ah.a iVS;
  
  static
  {
    AppMethodBeat.i(50303);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50303);
  }
  
  public QueryParams(int paramInt1, ah.a parama, int paramInt2)
  {
    this.count = paramInt1;
    this.iVS = parama;
    this.gXn = paramInt2;
  }
  
  public QueryParams(Parcel paramParcel) {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50301);
    if (paramParcel != null) {
      paramParcel.writeInt(this.count);
    }
    ah.a locala;
    if (paramParcel != null)
    {
      locala = this.iVS;
      if (locala == null) {
        break label58;
      }
    }
    label58:
    for (paramInt = locala.ordinal();; paramInt = -1)
    {
      paramParcel.writeInt(paramInt);
      if (paramParcel == null) {
        break;
      }
      paramParcel.writeInt(this.gXn);
      AppMethodBeat.o(50301);
      return;
    }
    AppMethodBeat.o(50301);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<QueryParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.QueryParams
 * JD-Core Version:    0.7.0.1
 */