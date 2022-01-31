package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCLong
  implements Parcelable
{
  public static final Parcelable.Creator<IPCLong> CREATOR = new IPCLong.1();
  public long value;
  
  public IPCLong() {}
  
  public IPCLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof IPCLong)) {
        break;
      }
      paramObject = (IPCLong)paramObject;
    } while (this.value == paramObject.value);
    return false;
    if ((paramObject instanceof Long)) {
      return paramObject.equals(Long.valueOf(this.value));
    }
    return false;
  }
  
  public String toString()
  {
    return Long.toString(this.value);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCLong
 * JD-Core Version:    0.7.0.1
 */