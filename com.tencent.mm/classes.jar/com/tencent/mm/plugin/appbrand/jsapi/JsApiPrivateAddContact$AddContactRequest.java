package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiPrivateAddContact$AddContactRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<AddContactRequest> CREATOR = new JsApiPrivateAddContact.AddContactRequest.1();
  int ggV;
  int scene;
  String userName;
  
  JsApiPrivateAddContact$AddContactRequest() {}
  
  JsApiPrivateAddContact$AddContactRequest(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  protected final Class<? extends AppBrandProxyUIProcessTask> ahH()
  {
    return JsApiPrivateAddContact.a.class;
  }
  
  public final void h(Parcel paramParcel)
  {
    this.userName = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.ggV = paramParcel.readInt();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.userName);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.ggV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactRequest
 * JD-Core Version:    0.7.0.1
 */