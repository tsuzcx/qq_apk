package com.tencent.map.sdk.utilities.heatmap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class WeightedLatLng
  extends com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng
{
  public static final Parcelable.Creator<WeightedLatLng> CREATOR;
  
  static
  {
    AppMethodBeat.i(84402);
    CREATOR = new Parcelable.Creator()
    {
      private static WeightedLatLng a(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(211063);
        paramAnonymousParcel = new WeightedLatLng(paramAnonymousParcel);
        AppMethodBeat.o(211063);
        return paramAnonymousParcel;
      }
      
      private static WeightedLatLng[] a(int paramAnonymousInt)
      {
        return new WeightedLatLng[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(84402);
  }
  
  protected WeightedLatLng(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public WeightedLatLng(LatLng paramLatLng)
  {
    super(paramLatLng);
  }
  
  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    super(paramLatLng, paramDouble);
    AppMethodBeat.i(172903);
    AppMethodBeat.o(172903);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(211076);
    if (!(paramObject instanceof WeightedLatLng))
    {
      AppMethodBeat.o(211076);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(211076);
      return true;
    }
    LatLng localLatLng = getPoint();
    double d = getIntensity();
    if (localLatLng != null)
    {
      if ((localLatLng.equals(((WeightedLatLng)paramObject).getPoint())) && (d == ((WeightedLatLng)paramObject).getIntensity()))
      {
        AppMethodBeat.o(211076);
        return true;
      }
      AppMethodBeat.o(211076);
      return false;
    }
    if (((WeightedLatLng)paramObject).getPoint() != null)
    {
      AppMethodBeat.o(211076);
      return false;
    }
    if (d == ((WeightedLatLng)paramObject).getIntensity())
    {
      AppMethodBeat.o(211076);
      return true;
    }
    AppMethodBeat.o(211076);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(211070);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(211070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.WeightedLatLng
 * JD-Core Version:    0.7.0.1
 */