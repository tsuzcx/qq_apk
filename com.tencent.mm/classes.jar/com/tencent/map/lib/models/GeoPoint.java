package com.tencent.map.lib.models;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

@Keep
public class GeoPoint
  implements Parcelable
{
  public static final Parcelable.Creator<GeoPoint> CREATOR;
  private int mLatitudeE6;
  private int mLongitudeE6;
  
  static
  {
    AppMethodBeat.i(180746);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(180746);
  }
  
  public GeoPoint()
  {
    this.mLatitudeE6 = -85000001;
    this.mLongitudeE6 = -180000001;
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.mLatitudeE6 = paramInt1;
    this.mLongitudeE6 = paramInt2;
  }
  
  private GeoPoint(Parcel paramParcel)
  {
    AppMethodBeat.i(180744);
    this.mLatitudeE6 = paramParcel.readInt();
    this.mLongitudeE6 = paramParcel.readInt();
    AppMethodBeat.o(180744);
  }
  
  public GeoPoint(GeoPoint paramGeoPoint)
  {
    this();
    this.mLatitudeE6 = paramGeoPoint.mLatitudeE6;
    this.mLongitudeE6 = paramGeoPoint.mLongitudeE6;
  }
  
  public GeoPoint(LatLng paramLatLng)
  {
    AppMethodBeat.i(193494);
    this.mLatitudeE6 = ((int)(paramLatLng.latitude * 1000000.0D));
    this.mLongitudeE6 = ((int)(paramLatLng.longitude * 1000000.0D));
    AppMethodBeat.o(193494);
  }
  
  public static GeoPoint formString(String paramString)
  {
    AppMethodBeat.i(180742);
    GeoPoint localGeoPoint = new GeoPoint();
    if (paramString != null) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length == 2))
      {
        localGeoPoint.mLatitudeE6 = Integer.parseInt(paramString[0]);
        localGeoPoint.mLongitudeE6 = Integer.parseInt(paramString[1]);
      }
    }
    catch (Exception paramString)
    {
      label54:
      break label54;
    }
    AppMethodBeat.o(180742);
    return localGeoPoint;
  }
  
  public static GeoPoint from(LatLng paramLatLng)
  {
    AppMethodBeat.i(193495);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(193495);
      return null;
    }
    paramLatLng = new GeoPoint(paramLatLng);
    AppMethodBeat.o(193495);
    return paramLatLng;
  }
  
  public static List<GeoPoint> from(List<LatLng> paramList)
  {
    int i = 0;
    AppMethodBeat.i(193496);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = new ArrayList(0);
      AppMethodBeat.o(193496);
      return paramList;
    }
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      LatLng localLatLng = (LatLng)paramList.get(i);
      if (localLatLng != null) {
        localArrayList.add(from(localLatLng));
      }
      i += 1;
    }
    AppMethodBeat.o(193496);
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof GeoPoint))
    {
      paramObject = (GeoPoint)paramObject;
      bool1 = bool2;
      if (this.mLatitudeE6 == paramObject.mLatitudeE6)
      {
        bool1 = bool2;
        if (this.mLongitudeE6 == paramObject.mLongitudeE6) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int getLatitudeE6()
  {
    return this.mLatitudeE6;
  }
  
  public int getLongitudeE6()
  {
    return this.mLongitudeE6;
  }
  
  public void setGeoPoint(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(180740);
    this.mLatitudeE6 = paramGeoPoint.getLatitudeE6();
    this.mLongitudeE6 = paramGeoPoint.getLongitudeE6();
    AppMethodBeat.o(180740);
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.mLatitudeE6 = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.mLongitudeE6 = paramInt;
  }
  
  public LatLng toLatLng()
  {
    AppMethodBeat.i(180745);
    LatLng localLatLng = new LatLng(this.mLatitudeE6 / 1000000.0D, this.mLongitudeE6 / 1000000.0D);
    AppMethodBeat.o(180745);
    return localLatLng;
  }
  
  public Point toPoint()
  {
    AppMethodBeat.i(193497);
    Point localPoint = new Point(getLongitudeE6(), getLatitudeE6());
    AppMethodBeat.o(193497);
    return localPoint;
  }
  
  public String toString()
  {
    AppMethodBeat.i(180741);
    String str = this.mLatitudeE6 + "," + this.mLongitudeE6;
    AppMethodBeat.o(180741);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(180743);
    paramParcel.writeInt(this.mLatitudeE6);
    paramParcel.writeInt(this.mLongitudeE6);
    AppMethodBeat.o(180743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.models.GeoPoint
 * JD-Core Version:    0.7.0.1
 */