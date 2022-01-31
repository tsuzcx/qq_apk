package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DebuggerInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DebuggerInfo> CREATOR = new DebuggerInfo.1();
  public boolean fUV;
  public boolean fUW;
  public boolean fUX;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (this.fUV)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.fUW) {
        break label50;
      }
      paramInt = 1;
      label25:
      paramParcel.writeInt(paramInt);
      if (!this.fUX) {
        break label55;
      }
    }
    label50:
    label55:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label25;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo
 * JD-Core Version:    0.7.0.1
 */