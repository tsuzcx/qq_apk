package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GeoPoint$1
  implements Parcelable.Creator<GeoPoint>
{
  public final GeoPoint createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(101176);
    paramParcel = new GeoPoint(paramParcel, null);
    AppMethodBeat.o(101176);
    return paramParcel;
  }
  
  public final GeoPoint[] newArray(int paramInt)
  {
    return new GeoPoint[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.GeoPoint.1
 * JD-Core Version:    0.7.0.1
 */