package com.tencent.map.lib.basemap.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GeoPoint$1
  implements Parcelable.Creator<GeoPoint>
{
  public final GeoPoint a(Parcel paramParcel)
  {
    return new GeoPoint(paramParcel, null);
  }
  
  public final GeoPoint[] a(int paramInt)
  {
    return new GeoPoint[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.GeoPoint.1
 * JD-Core Version:    0.7.0.1
 */