package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiPrivateAddContact$AddContactResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<AddContactResult> CREATOR = new JsApiPrivateAddContact.AddContactResult.1();
  private int aYY;
  
  JsApiPrivateAddContact$AddContactResult() {}
  
  JsApiPrivateAddContact$AddContactResult(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    this.aYY = paramParcel.readInt();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aYY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult
 * JD-Core Version:    0.7.0.1
 */