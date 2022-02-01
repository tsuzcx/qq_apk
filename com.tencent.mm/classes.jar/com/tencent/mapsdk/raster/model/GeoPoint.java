package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GeoPoint
  implements Parcelable
{
  public static final Parcelable.Creator<GeoPoint> CREATOR;
  private int e6Lat;
  private int e6Lon;
  
  static
  {
    AppMethodBeat.i(87540);
    CREATOR = new Parcelable.Creator()
    {
      public GeoPoint createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(87597);
        paramAnonymousParcel = new GeoPoint(paramAnonymousParcel, null);
        AppMethodBeat.o(87597);
        return paramAnonymousParcel;
      }
      
      public GeoPoint[] newArray(int paramAnonymousInt)
      {
        return new GeoPoint[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(87540);
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.e6Lat = 0;
    this.e6Lon = 0;
    this.e6Lat = paramInt1;
    this.e6Lon = paramInt2;
  }
  
  private GeoPoint(Parcel paramParcel)
  {
    AppMethodBeat.i(87537);
    this.e6Lat = 0;
    this.e6Lon = 0;
    this.e6Lat = paramParcel.readInt();
    this.e6Lon = paramParcel.readInt();
    AppMethodBeat.o(87537);
  }
  
  public static LatLng g2l(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(87539);
    paramGeoPoint = new LatLng(paramGeoPoint.getLatitudeE6() * 1.0D / 1000000.0D, paramGeoPoint.getLongitudeE6() * 1.0D / 1000000.0D);
    AppMethodBeat.o(87539);
    return paramGeoPoint;
  }
  
  public GeoPoint Copy()
  {
    AppMethodBeat.i(87536);
    GeoPoint localGeoPoint = new GeoPoint(this.e6Lat, this.e6Lon);
    AppMethodBeat.o(87536);
    return localGeoPoint;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(87534);
    if (paramObject == null)
    {
      AppMethodBeat.o(87534);
      return false;
    }
    if (paramObject.getClass() != getClass())
    {
      AppMethodBeat.o(87534);
      return false;
    }
    paramObject = (GeoPoint)paramObject;
    if ((this.e6Lat == paramObject.e6Lat) && (this.e6Lon == paramObject.e6Lon))
    {
      AppMethodBeat.o(87534);
      return true;
    }
    AppMethodBeat.o(87534);
    return false;
  }
  
  public int getLatitudeE6()
  {
    return this.e6Lat;
  }
  
  public int getLongitudeE6()
  {
    return this.e6Lon;
  }
  
  public int hashCode()
  {
    return this.e6Lon * 7 + this.e6Lat * 11;
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.e6Lat = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.e6Lon = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(87535);
    String str = this.e6Lat + "," + this.e6Lon;
    AppMethodBeat.o(87535);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(87538);
    paramParcel.writeInt(this.e6Lat);
    paramParcel.writeInt(this.e6Lon);
    AppMethodBeat.o(87538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.GeoPoint
 * JD-Core Version:    0.7.0.1
 */