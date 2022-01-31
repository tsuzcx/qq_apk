package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.y;

class AppBrandPerformanceManager$GetPkgDownloadCostTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetPkgDownloadCostTask> CREATOR = new AppBrandPerformanceManager.GetPkgDownloadCostTask.1();
  private long gWb;
  private String mAppId;
  
  public final void Zu()
  {
    y.d("MicroMsg.AppBrandPerformanceManager", "try to get pkg download cost in main process.");
    String str = this.mAppId + "_PkgDownloadCost";
    Object localObject = e.aaY();
    if (localObject == null)
    {
      y.e("MicroMsg.AppBrandPerformanceManager", "appBrandCommonKVDataStorage is null, return");
      ahI();
      return;
    }
    localObject = ((c)localObject).get(str, null);
    if (localObject != null) {
      e.aaY().bi(str, null);
    }
    try
    {
      this.gWb = Long.parseLong((String)localObject);
      ahI();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandPerformanceManager", "GetPkgDownloadCost error.");
      }
    }
  }
  
  public final void Zv()
  {
    y.d("MicroMsg.AppBrandPerformanceManager", "received pkg download cost from main process: %d ms", new Object[] { Long.valueOf(this.gWb) });
    if (this.gWb != 0L) {
      AppBrandPerformanceManager.b(this.mAppId, 201, this.gWb);
    }
    ahD();
  }
  
  public final void e(Parcel paramParcel)
  {
    this.mAppId = paramParcel.readString();
    this.gWb = paramParcel.readLong();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAppId);
    paramParcel.writeLong(this.gWb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.GetPkgDownloadCostTask
 * JD-Core Version:    0.7.0.1
 */