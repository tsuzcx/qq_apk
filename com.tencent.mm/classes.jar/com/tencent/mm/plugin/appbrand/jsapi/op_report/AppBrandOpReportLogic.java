package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public final class AppBrandOpReportLogic
{
  static final class ReportTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<ReportTask> CREATOR = new AppBrandOpReportLogic.ReportTask.1();
    String appId;
    String bFw;
    int caB;
    int cau;
    int fJy;
    int glj;
    String gyF;
    int scene;
    String username;
    
    ReportTask() {}
    
    ReportTask(Parcel paramParcel)
    {
      e(paramParcel);
    }
    
    public final void Zu()
    {
      AppBrandOpReportLogic.b.a(this);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      this.appId = paramParcel.readString();
      this.username = paramParcel.readString();
      this.fJy = paramParcel.readInt();
      this.cau = paramParcel.readInt();
      this.scene = paramParcel.readInt();
      this.caB = paramParcel.readInt();
      this.bFw = paramParcel.readString();
      this.glj = paramParcel.readInt();
      this.gyF = paramParcel.readString();
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.fJy);
      paramParcel.writeInt(this.cau);
      paramParcel.writeInt(this.scene);
      paramParcel.writeInt(this.caB);
      paramParcel.writeString(this.bFw);
      paramParcel.writeInt(this.glj);
      paramParcel.writeString(this.gyF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic
 * JD-Core Version:    0.7.0.1
 */