package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CameraPosition$1
  implements Parcelable.Creator<CameraPosition>
{
  public final CameraPosition createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(101161);
    float f1 = paramParcel.readFloat();
    float f2 = paramParcel.readFloat();
    float f3 = paramParcel.readFloat();
    float f4 = paramParcel.readFloat();
    float f5 = paramParcel.readFloat();
    paramParcel = new CameraPosition(new LatLng(f1, f2), f3, f4, f5);
    AppMethodBeat.o(101161);
    return paramParcel;
  }
  
  public final CameraPosition[] newArray(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.CameraPosition.1
 * JD-Core Version:    0.7.0.1
 */