package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetSysConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetSysConfig> CREATOR = new WidgetSysConfig.1();
  public int fON;
  public int fOO;
  public int fOP;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.fON);
    paramParcel.writeInt(this.fOO);
    paramParcel.writeInt(this.fOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig
 * JD-Core Version:    0.7.0.1
 */