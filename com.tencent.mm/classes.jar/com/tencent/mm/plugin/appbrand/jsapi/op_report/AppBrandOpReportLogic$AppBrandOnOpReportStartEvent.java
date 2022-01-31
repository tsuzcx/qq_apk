package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class AppBrandOpReportLogic$AppBrandOnOpReportStartEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOnOpReportStartEvent> CREATOR = new AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.1();
  String appId;
  
  AppBrandOpReportLogic$AppBrandOnOpReportStartEvent() {}
  
  AppBrandOpReportLogic$AppBrandOnOpReportStartEvent(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
  }
  
  public static void uy(String paramString)
  {
    AppBrandOnOpReportStartEvent localAppBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
    localAppBrandOnOpReportStartEvent.appId = paramString;
    d.a(paramString, localAppBrandOnOpReportStartEvent);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent
 * JD-Core Version:    0.7.0.1
 */