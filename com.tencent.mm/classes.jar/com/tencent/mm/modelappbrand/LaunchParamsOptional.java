package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LaunchParamsOptional
  implements Parcelable
{
  public static final Parcelable.Creator<LaunchParamsOptional> CREATOR = new LaunchParamsOptional.1();
  public String dTX;
  public String dZN;
  public String dZO;
  
  public LaunchParamsOptional() {}
  
  private LaunchParamsOptional(Parcel paramParcel)
  {
    this.dZN = paramParcel.readString();
    this.dTX = paramParcel.readString();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dZN);
    paramParcel.writeString(this.dTX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LaunchParamsOptional
 * JD-Core Version:    0.7.0.1
 */