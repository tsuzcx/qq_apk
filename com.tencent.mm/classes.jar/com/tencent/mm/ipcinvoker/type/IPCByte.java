package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCByte
  implements Parcelable
{
  public static final Parcelable.Creator<IPCByte> CREATOR = new IPCByte.1();
  public byte value;
  
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
      if (!(paramObject instanceof IPCByte)) {
        break;
      }
      paramObject = (IPCByte)paramObject;
    } while (this.value == paramObject.value);
    return false;
    if ((paramObject instanceof Byte)) {
      return paramObject.equals(Byte.valueOf(this.value));
    }
    return false;
  }
  
  public String toString()
  {
    return Integer.toString(this.value);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByte(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCByte
 * JD-Core Version:    0.7.0.1
 */