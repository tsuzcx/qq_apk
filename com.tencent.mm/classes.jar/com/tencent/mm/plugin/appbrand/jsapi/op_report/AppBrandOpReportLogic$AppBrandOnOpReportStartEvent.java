package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class AppBrandOpReportLogic$AppBrandOnOpReportStartEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOnOpReportStartEvent> CREATOR;
  String appId;
  
  static
  {
    AppMethodBeat.i(101998);
    CREATOR = new AppBrandOpReportLogic.AppBrandOnOpReportStartEvent.1();
    AppMethodBeat.o(101998);
  }
  
  AppBrandOpReportLogic$AppBrandOnOpReportStartEvent() {}
  
  AppBrandOpReportLogic$AppBrandOnOpReportStartEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(101997);
    this.appId = paramParcel.readString();
    AppMethodBeat.o(101997);
  }
  
  public static void CK(String paramString)
  {
    AppMethodBeat.i(101995);
    AppBrandOnOpReportStartEvent localAppBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
    localAppBrandOnOpReportStartEvent.appId = paramString;
    d.a(paramString, localAppBrandOnOpReportStartEvent);
    AppMethodBeat.o(101995);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101996);
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(101996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent
 * JD-Core Version:    0.7.0.1
 */