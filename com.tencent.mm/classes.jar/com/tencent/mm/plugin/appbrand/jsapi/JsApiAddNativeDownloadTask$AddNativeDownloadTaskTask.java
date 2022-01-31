package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddNativeDownloadTaskTask> CREATOR = new JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask.2();
  public long bFb = 0L;
  public int bcw = 0;
  private c gfC;
  Runnable gfD;
  
  public final void Zu()
  {
    y.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[] { Integer.valueOf(this.bcw) });
    this.gfC = new JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask.1(this);
    a.udP.b(this.gfC);
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.bcw = paramParcel.readInt();
    this.bFb = paramParcel.readLong();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.bcw);
    paramParcel.writeLong(this.bFb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask
 * JD-Core Version:    0.7.0.1
 */