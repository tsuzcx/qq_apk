package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import java.util.ArrayList;

final class JsApiChooseImage$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR = new Parcelable.Creator() {};
  int aYY;
  ArrayList<AppBrandLocalMediaObject> gvq;
  
  JsApiChooseImage$ChooseResult() {}
  
  JsApiChooseImage$ChooseResult(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    this.aYY = paramParcel.readInt();
    this.gvq = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aYY);
    paramParcel.writeTypedList(this.gvq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult
 * JD-Core Version:    0.7.0.1
 */