package com.tencent.mm.plugin.appbrand.jsapi;

import a.d.b.g;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiProfile$ProfileRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final JsApiProfile.ProfileRequest.a CREATOR = new JsApiProfile.ProfileRequest.a((byte)0);
  int scene = 122;
  String username;
  
  public JsApiProfile$ProfileRequest() {}
  
  public JsApiProfile$ProfileRequest(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  protected final Class<? extends AppBrandProxyUIProcessTask> ahH()
  {
    return JsApiProfile.b.class;
  }
  
  public final void h(Parcel paramParcel)
  {
    g.k(paramParcel, "parcel");
    this.username = paramParcel.readString();
    this.scene = paramParcel.readInt();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.k(paramParcel, "dest");
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiProfile.ProfileRequest
 * JD-Core Version:    0.7.0.1
 */