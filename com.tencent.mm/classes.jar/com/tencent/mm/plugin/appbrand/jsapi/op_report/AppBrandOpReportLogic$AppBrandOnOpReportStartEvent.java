package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.e;

public final class AppBrandOpReportLogic$AppBrandOnOpReportStartEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOnOpReportStartEvent> CREATOR;
  String appId;
  
  static
  {
    AppMethodBeat.i(147202);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147202);
  }
  
  AppBrandOpReportLogic$AppBrandOnOpReportStartEvent() {}
  
  AppBrandOpReportLogic$AppBrandOnOpReportStartEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(147201);
    this.appId = paramParcel.readString();
    AppMethodBeat.o(147201);
  }
  
  public static void Qp(String paramString)
  {
    AppMethodBeat.i(147199);
    AppBrandOnOpReportStartEvent localAppBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
    localAppBrandOnOpReportStartEvent.appId = paramString;
    e.b(paramString, localAppBrandOnOpReportStartEvent);
    AppMethodBeat.o(147199);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147200);
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(147200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent
 * JD-Core Version:    0.7.0.1
 */