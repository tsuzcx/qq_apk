package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCInteger
  implements Parcelable
{
  public static final Parcelable.Creator<IPCInteger> CREATOR = new Parcelable.Creator() {};
  public int value;
  
  public IPCInteger() {}
  
  public IPCInteger(int paramInt)
  {
    this.value = paramInt;
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
      if (!(paramObject instanceof IPCInteger)) {
        break;
      }
      paramObject = (IPCInteger)paramObject;
    } while (this.value == paramObject.value);
    return false;
    if ((paramObject instanceof Integer)) {
      return paramObject.equals(Integer.valueOf(this.value));
    }
    return false;
  }
  
  public String toString()
  {
    return Integer.toString(this.value);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCInteger
 * JD-Core Version:    0.7.0.1
 */