package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandWeishiParams;

public final class LaunchParamsOptional
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParamsOptional> CREATOR;
  public String eoT;
  public String eoU;
  public AppBrandWeishiParams eoW;
  public String eoY;
  public String opW;
  public int opX;
  
  static
  {
    AppMethodBeat.i(146921);
    CREATOR = new LaunchParamsOptional.1();
    AppMethodBeat.o(146921);
  }
  
  public LaunchParamsOptional() {}
  
  private LaunchParamsOptional(Parcel paramParcel)
  {
    AppMethodBeat.i(146920);
    this.eoT = paramParcel.readString();
    this.eoU = paramParcel.readString();
    this.eoW = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    this.opX = paramParcel.readInt();
    this.eoY = paramParcel.readString();
    this.opW = paramParcel.readString();
    AppMethodBeat.o(146920);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146919);
    paramParcel.writeString(this.eoT);
    paramParcel.writeString(this.eoU);
    paramParcel.writeParcelable(this.eoW, paramInt);
    paramParcel.writeInt(this.opX);
    paramParcel.writeString(this.eoY);
    paramParcel.writeString(this.opW);
    AppMethodBeat.o(146919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LaunchParamsOptional
 * JD-Core Version:    0.7.0.1
 */