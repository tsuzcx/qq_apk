package com.tencent.map.lib.basemap.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GeoPoint$1
  implements Parcelable.Creator<GeoPoint>
{
  public final GeoPoint a(Parcel paramParcel)
  {
    AppMethodBeat.i(97842);
    paramParcel = new GeoPoint(paramParcel, null);
    AppMethodBeat.o(97842);
    return paramParcel;
  }
  
  public final GeoPoint[] a(int paramInt)
  {
    return new GeoPoint[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.GeoPoint.1
 * JD-Core Version:    0.7.0.1
 */