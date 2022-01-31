package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCDouble
  implements Parcelable
{
  public static final Parcelable.Creator<IPCDouble> CREATOR = new IPCDouble.1();
  public double value;
  
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
      if (!(paramObject instanceof IPCDouble)) {
        break;
      }
      paramObject = (IPCDouble)paramObject;
    } while (this.value == paramObject.value);
    return false;
    if ((paramObject instanceof Double)) {
      return paramObject.equals(Double.valueOf(this.value));
    }
    return false;
  }
  
  public String toString()
  {
    return Double.toString(this.value);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCDouble
 * JD-Core Version:    0.7.0.1
 */