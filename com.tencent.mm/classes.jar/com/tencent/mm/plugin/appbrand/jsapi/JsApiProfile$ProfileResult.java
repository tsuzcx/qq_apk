package com.tencent.mm.plugin.appbrand.jsapi;

import a.d.b.g;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiProfile$ProfileResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final JsApiProfile.ProfileResult.a CREATOR = new JsApiProfile.ProfileResult.a((byte)0);
  int aYY;
  int ggZ;
  String username;
  
  public JsApiProfile$ProfileResult() {}
  
  public JsApiProfile$ProfileResult(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    g.k(paramParcel, "in");
    this.aYY = paramParcel.readInt();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.k(paramParcel, "dest");
    paramParcel.writeInt(this.aYY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiProfile.ProfileResult
 * JD-Core Version:    0.7.0.1
 */