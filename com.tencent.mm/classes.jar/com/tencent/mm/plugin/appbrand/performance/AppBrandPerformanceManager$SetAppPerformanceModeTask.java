package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class AppBrandPerformanceManager$SetAppPerformanceModeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetAppPerformanceModeTask> CREATOR = new AppBrandPerformanceManager.SetAppPerformanceModeTask.1();
  private String mAppId;
  private boolean mEnable;
  
  public final void Zu()
  {
    c localc = e.aaY();
    String str2 = this.mAppId + "_PerformancePanelEnabled";
    if (this.mEnable) {}
    for (String str1 = "1";; str1 = "0")
    {
      localc.bi(str2, str1);
      return;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.mAppId = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mEnable = bool;
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAppId);
    if (this.mEnable) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.SetAppPerformanceModeTask
 * JD-Core Version:    0.7.0.1
 */