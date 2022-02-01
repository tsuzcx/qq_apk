package com.tencent.map.sdk.utilities.heatmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class WeightedLatLng
  implements Parcelable
{
  public static final Parcelable.Creator<WeightedLatLng> CREATOR;
  private static final double DEFAULT_INTENSITY = 1.0D;
  private double mIntensity;
  private LatLng mPoint;
  
  static
  {
    AppMethodBeat.i(84402);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(84402);
  }
  
  protected WeightedLatLng(Parcel paramParcel)
  {
    AppMethodBeat.i(193510);
    this.mPoint = ((LatLng)paramParcel.readParcelable(LatLng.class.getClassLoader()));
    this.mIntensity = paramParcel.readDouble();
    AppMethodBeat.o(193510);
  }
  
  public WeightedLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }
  
  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    AppMethodBeat.i(172903);
    setPoint(paramLatLng);
    setIntensity(paramDouble);
    AppMethodBeat.o(172903);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193511);
    if (!(paramObject instanceof WeightedLatLng))
    {
      AppMethodBeat.o(193511);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(193511);
      return true;
    }
    if (this.mPoint != null)
    {
      if ((this.mPoint.equals(((WeightedLatLng)paramObject).mPoint)) && (this.mIntensity == ((WeightedLatLng)paramObject).mIntensity))
      {
        AppMethodBeat.o(193511);
        return true;
      }
      AppMethodBeat.o(193511);
      return false;
    }
    if (((WeightedLatLng)paramObject).mPoint != null)
    {
      AppMethodBeat.o(193511);
      return false;
    }
    if (this.mIntensity == ((WeightedLatLng)paramObject).mIntensity)
    {
      AppMethodBeat.o(193511);
      return true;
    }
    AppMethodBeat.o(193511);
    return false;
  }
  
  public double getIntensity()
  {
    return this.mIntensity;
  }
  
  public LatLng getPoint()
  {
    return this.mPoint;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(193512);
    if (this.mPoint != null)
    {
      i = this.mPoint.hashCode();
      int j = (int)(this.mIntensity * 1000000.0D);
      AppMethodBeat.o(193512);
      return i + j;
    }
    int i = (int)(this.mIntensity * 1000000.0D);
    AppMethodBeat.o(193512);
    return i;
  }
  
  public void setIntensity(double paramDouble)
  {
    if (paramDouble >= 0.0D)
    {
      this.mIntensity = paramDouble;
      return;
    }
    this.mIntensity = 1.0D;
  }
  
  public void setPoint(LatLng paramLatLng)
  {
    this.mPoint = paramLatLng;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(193509);
    paramParcel.writeParcelable(this.mPoint, paramInt);
    paramParcel.writeDouble(this.mIntensity);
    AppMethodBeat.o(193509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.WeightedLatLng
 * JD-Core Version:    0.7.0.1
 */