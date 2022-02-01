package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandMixExportLogicService$AppBrandOnStartReportCanvasDataEvent
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandOnStartReportCanvasDataEvent> CREATOR;
  public String appId;
  
  static
  {
    AppMethodBeat.i(44095);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(44095);
  }
  
  AppBrandMixExportLogicService$AppBrandOnStartReportCanvasDataEvent() {}
  
  AppBrandMixExportLogicService$AppBrandOnStartReportCanvasDataEvent(Parcel paramParcel)
  {
    AppMethodBeat.i(44094);
    this.appId = paramParcel.readString();
    AppMethodBeat.o(44094);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(44093);
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(44093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent
 * JD-Core Version:    0.7.0.1
 */