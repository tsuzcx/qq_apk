package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.params.AppBrandWeishiParams;

public final class LaunchParamsOptional
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParamsOptional> CREATOR;
  public String bCY;
  public String bCZ;
  public AppBrandWeishiParams bDa;
  public String fpV;
  
  static
  {
    AppMethodBeat.i(101708);
    CREATOR = new LaunchParamsOptional.1();
    AppMethodBeat.o(101708);
  }
  
  public LaunchParamsOptional() {}
  
  private LaunchParamsOptional(Parcel paramParcel)
  {
    AppMethodBeat.i(101707);
    this.bCY = paramParcel.readString();
    this.bCZ = paramParcel.readString();
    this.bDa = ((AppBrandWeishiParams)paramParcel.readParcelable(AppBrandWeishiParams.class.getClassLoader()));
    AppMethodBeat.o(101707);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101706);
    paramParcel.writeString(this.bCY);
    paramParcel.writeString(this.bCZ);
    paramParcel.writeParcelable(this.bDa, paramInt);
    AppMethodBeat.o(101706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LaunchParamsOptional
 * JD-Core Version:    0.7.0.1
 */