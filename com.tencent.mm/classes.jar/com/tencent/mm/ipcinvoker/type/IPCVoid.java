package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCVoid
  implements Parcelable
{
  public static final Parcelable.Creator<IPCVoid> CREATOR = new IPCVoid.1();
  public static final IPCVoid dHo = new IPCVoid();
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCVoid
 * JD-Core Version:    0.7.0.1
 */