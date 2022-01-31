package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.secinforeport.a.a;

class JsApiSetClipboardDataWC$ReportClipBoardTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportClipBoardTask> CREATOR = new JsApiSetClipboardDataWC.ReportClipBoardTask.1();
  private String gcH;
  private String mAppId;
  private int mLength;
  
  public JsApiSetClipboardDataWC$ReportClipBoardTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiSetClipboardDataWC$ReportClipBoardTask(String paramString1, String paramString2, int paramInt)
  {
    this.mAppId = paramString1;
    this.gcH = paramString2;
    this.mLength = paramInt;
  }
  
  public final void Zu()
  {
    a locala = a.nQo;
    a.t(this.mLength, this.mAppId, this.gcH);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.mAppId = paramParcel.readString();
    this.gcH = paramParcel.readString();
    this.mLength = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAppId);
    paramParcel.writeString(this.gcH);
    paramParcel.writeInt(this.mLength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC.ReportClipBoardTask
 * JD-Core Version:    0.7.0.1
 */