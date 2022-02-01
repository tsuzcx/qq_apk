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
  public String cff;
  public String cfh;
  public AppBrandWeishiParams cfj;
  public String gRC;
  
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
    this.cff = paramParcel.readString();
    this.cfh = paramParcel.readString();
    this.cfj = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    AppMethodBeat.o(146920);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(146919);
    paramParcel.writeString(this.cff);
    paramParcel.writeString(this.cfh);
    paramParcel.writeParcelable(this.cfj, paramInt);
    AppMethodBeat.o(146919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LaunchParamsOptional
 * JD-Core Version:    0.7.0.1
 */