package com.tencent.mm.plugin.appbrand.appusage;

import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/QueryParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "(ILcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;)V", "getCount", "()I", "getOrder", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class QueryParams
  implements Parcelable
{
  public static final QueryParams.a CREATOR;
  final int count;
  final af.a hcQ;
  
  static
  {
    AppMethodBeat.i(134566);
    CREATOR = new QueryParams.a((byte)0);
    AppMethodBeat.o(134566);
  }
  
  public QueryParams(int paramInt, af.a parama)
  {
    this.count = paramInt;
    this.hcQ = parama;
  }
  
  public QueryParams(Parcel paramParcel) {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134564);
    if (paramParcel != null) {
      paramParcel.writeInt(this.count);
    }
    if (paramParcel != null)
    {
      af.a locala = this.hcQ;
      if (locala != null) {}
      for (paramInt = locala.ordinal();; paramInt = -1)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(134564);
        return;
      }
    }
    AppMethodBeat.o(134564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.QueryParams
 * JD-Core Version:    0.7.0.1
 */