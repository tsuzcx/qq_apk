package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMedia$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR = new JsApiChooseMedia.ChooseResult.1();
  int aYY;
  String gvI;
  String type;
  
  JsApiChooseMedia$ChooseResult() {}
  
  JsApiChooseMedia$ChooseResult(Parcel paramParcel)
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
    this.type = paramParcel.readString();
    this.gvI = paramParcel.readString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aYY);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.gvI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseResult
 * JD-Core Version:    0.7.0.1
 */