package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class zzsl
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<zzsl> CREATOR = new zzsl.1();
  private String mValue;
  private String zzGV;
  private String zzaeU;
  
  @Deprecated
  public zzsl() {}
  
  @Deprecated
  zzsl(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.zzGV = paramParcel.readString();
    this.zzaeU = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzGV;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzGV);
    paramParcel.writeString(this.zzaeU);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzsl
 * JD-Core Version:    0.7.0.1
 */