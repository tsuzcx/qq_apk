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
  public String ccc;
  public String ccd;
  public AppBrandWeishiParams ccf;
  public String hsc;
  
  static
  {
    AppMethodBeat.i(146921);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(146921);
  }
  
  public LaunchParamsOptional() {}
  
  private LaunchParamsOptional(Parcel paramParcel)
  {
    AppMethodBeat.i(146920);
    this.ccc = paramParcel.readString();
    this.ccd = paramParcel.readString();
    this.ccf = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    AppMethodBeat.o(146920);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146919);
    paramParcel.writeString(this.ccc);
    paramParcel.writeString(this.ccd);
    paramParcel.writeParcelable(this.ccf, paramInt);
    AppMethodBeat.o(146919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LaunchParamsOptional
 * JD-Core Version:    0.7.0.1
 */