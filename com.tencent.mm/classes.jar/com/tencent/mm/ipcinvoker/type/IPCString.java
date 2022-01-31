package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCString
  implements Parcelable
{
  public static final Parcelable.Creator<IPCString> CREATOR = new IPCString.1();
  public String value;
  
  public IPCString() {}
  
  public IPCString(String paramString)
  {
    this.value = paramString;
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
      if (!(paramObject instanceof IPCString)) {
        break;
      }
      paramObject = (IPCString)paramObject;
    } while ((this.value == paramObject.value) || ((this.value != null) && (this.value.equals(paramObject.value))));
    return false;
    if ((paramObject instanceof String)) {
      return paramObject.equals(this.value);
    }
    return false;
  }
  
  public String toString()
  {
    return this.value;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCString
 * JD-Core Version:    0.7.0.1
 */