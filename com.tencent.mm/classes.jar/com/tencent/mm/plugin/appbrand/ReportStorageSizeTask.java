package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;

public class ReportStorageSizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportStorageSizeTask> CREATOR = new ReportStorageSizeTask.1();
  public String appId;
  
  public final void Zu()
  {
    b localb = e.aaS();
    if (localb == null) {
      return;
    }
    h.nFQ.f(14073, new Object[] { this.appId, "", "", localb.rq(this.appId)[1], Long.valueOf(AppBrandLocalMediaObjectManager.getTmpFilesOccupation(this.appId)), Long.valueOf(AppBrandLocalMediaObjectManager.getStoredFilesOccupation(this.appId)) });
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */