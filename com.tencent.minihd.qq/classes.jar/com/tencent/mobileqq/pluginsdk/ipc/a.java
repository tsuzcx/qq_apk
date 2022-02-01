package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public ParcelableBinder a(Parcel paramParcel)
  {
    return new ParcelableBinder(paramParcel, null);
  }
  
  public ParcelableBinder[] a(int paramInt)
  {
    return new ParcelableBinder[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.a
 * JD-Core Version:    0.7.0.1
 */