package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetRuntimeConfig
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetRuntimeConfig> CREATOR = new WidgetRuntimeConfig.1();
  public String appId;
  public int fWQ = 32;
  public boolean fWR = false;
  public boolean fWS = true;
  public int fWz;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fWz);
    paramParcel.writeInt(this.fWQ);
    if (this.fWR)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.fWS) {
        break label60;
      }
    }
    label60:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig
 * JD-Core Version:    0.7.0.1
 */