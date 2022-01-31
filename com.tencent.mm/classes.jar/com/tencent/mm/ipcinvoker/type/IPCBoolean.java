package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCBoolean
  implements Parcelable
{
  public static final Parcelable.Creator<IPCBoolean> CREATOR = new IPCBoolean.1();
  public boolean value;
  
  public IPCBoolean() {}
  
  public IPCBoolean(boolean paramBoolean)
  {
    this.value = paramBoolean;
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
      if (!(paramObject instanceof IPCBoolean)) {
        break;
      }
      paramObject = (IPCBoolean)paramObject;
    } while (this.value == paramObject.value);
    return false;
    if ((paramObject instanceof Boolean)) {
      return paramObject.equals(Boolean.valueOf(this.value));
    }
    return false;
  }
  
  public String toString()
  {
    return Boolean.toString(this.value);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.value) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCBoolean
 * JD-Core Version:    0.7.0.1
 */