package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LogInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LogInfo> CREATOR = new Parcelable.Creator() {};
  public int level;
  public String message;
  public long ts;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.ts);
    paramParcel.writeInt(this.level);
    paramParcel.writeString(this.message);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.LogInfo
 * JD-Core Version:    0.7.0.1
 */