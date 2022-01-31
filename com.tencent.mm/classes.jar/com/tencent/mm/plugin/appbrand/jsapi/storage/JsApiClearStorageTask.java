package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiClearStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiClearStorageTask> CREATOR = new JsApiClearStorageTask.1();
  public String appId;
  
  public JsApiClearStorageTask() {}
  
  public JsApiClearStorageTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    b localb = e.aaS();
    if (localb == null) {
      return;
    }
    localb.clear(this.appId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask
 * JD-Core Version:    0.7.0.1
 */