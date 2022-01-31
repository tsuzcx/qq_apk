package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiOpenDocument$OpenRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<OpenRequest> CREATOR = new JsApiOpenDocument.OpenRequest.1();
  public String fGv;
  public String filePath;
  
  JsApiOpenDocument$OpenRequest() {}
  
  JsApiOpenDocument$OpenRequest(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  protected final String ahG()
  {
    return "QbDocumentReader";
  }
  
  protected final Class<? extends AppBrandProxyUIProcessTask> ahH()
  {
    return JsApiOpenDocument.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    super.h(paramParcel);
    this.filePath = paramParcel.readString();
    this.fGv = paramParcel.readString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.fGv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument.OpenRequest
 * JD-Core Version:    0.7.0.1
 */