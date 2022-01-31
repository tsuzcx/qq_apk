package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseVideo$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR = new JsApiChooseVideo.ChooseResult.1();
  int aYY;
  AppBrandLocalVideoObject gvW;
  
  JsApiChooseVideo$ChooseResult() {}
  
  JsApiChooseVideo$ChooseResult(Parcel paramParcel)
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
    this.gvW = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aYY);
    paramParcel.writeParcelable(this.gvW, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult
 * JD-Core Version:    0.7.0.1
 */