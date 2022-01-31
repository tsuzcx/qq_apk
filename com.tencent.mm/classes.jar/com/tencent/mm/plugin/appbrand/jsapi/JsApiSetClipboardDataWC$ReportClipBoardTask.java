package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.secinforeport.a.a;

class JsApiSetClipboardDataWC$ReportClipBoardTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportClipBoardTask> CREATOR;
  private String hzM;
  private String mAppId;
  private int mLength;
  
  static
  {
    AppMethodBeat.i(130572);
    CREATOR = new JsApiSetClipboardDataWC.ReportClipBoardTask.1();
    AppMethodBeat.o(130572);
  }
  
  public JsApiSetClipboardDataWC$ReportClipBoardTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130569);
    f(paramParcel);
    AppMethodBeat.o(130569);
  }
  
  public JsApiSetClipboardDataWC$ReportClipBoardTask(String paramString1, String paramString2, int paramInt)
  {
    this.mAppId = paramString1;
    this.hzM = paramString2;
    this.mLength = paramInt;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130568);
    a locala = a.qEl;
    a.D(this.mLength, this.mAppId, this.hzM);
    AppMethodBeat.o(130568);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130570);
    this.mAppId = paramParcel.readString();
    this.hzM = paramParcel.readString();
    this.mLength = paramParcel.readInt();
    AppMethodBeat.o(130570);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130571);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.hzM);
    paramParcel.writeInt(this.mLength);
    AppMethodBeat.o(130571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC.ReportClipBoardTask
 * JD-Core Version:    0.7.0.1
 */