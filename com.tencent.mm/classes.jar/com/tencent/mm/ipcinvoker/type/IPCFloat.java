package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCFloat
  implements Parcelable
{
  public static final Parcelable.Creator<IPCFloat> CREATOR = new IPCFloat.1();
  public float value;
  
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
      if (!(paramObject instanceof IPCFloat)) {
        break;
      }
      paramObject = (IPCFloat)paramObject;
    } while (this.value == paramObject.value);
    return false;
    if ((paramObject instanceof Float)) {
      return paramObject.equals(Float.valueOf(this.value));
    }
    return false;
  }
  
  public String toString()
  {
    return Float.toString(this.value);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCFloat
 * JD-Core Version:    0.7.0.1
 */