package com.tencent.tmassistant.aidl;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator
{
  public TMAssistantDownloadTaskInfo a(Parcel paramParcel)
  {
    return new TMAssistantDownloadTaskInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readString());
  }
  
  public TMAssistantDownloadTaskInfo[] a(int paramInt)
  {
    return new TMAssistantDownloadTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistant.aidl.g
 * JD-Core Version:    0.7.0.1
 */