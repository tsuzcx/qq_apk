package com.tencent.mobileqq.pluginsdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator
{
  public PluginBaseInfo a(Parcel paramParcel)
  {
    return new PluginBaseInfo(paramParcel);
  }
  
  public PluginBaseInfo[] a(int paramInt)
  {
    return new PluginBaseInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.b
 * JD-Core Version:    0.7.0.1
 */