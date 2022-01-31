package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

class JsApiJumpDownloaderWidgetForNative$JumpDownloadWidgetRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<JumpDownloadWidgetRequest> CREATOR;
  public String appId;
  
  static
  {
    AppMethodBeat.i(143327);
    CREATOR = new JsApiJumpDownloaderWidgetForNative.JumpDownloadWidgetRequest.1();
    AppMethodBeat.o(143327);
  }
  
  JsApiJumpDownloaderWidgetForNative$JumpDownloadWidgetRequest() {}
  
  JsApiJumpDownloaderWidgetForNative$JumpDownloadWidgetRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(143326);
    j(paramParcel);
    AppMethodBeat.o(143326);
  }
  
  public final boolean aBm()
  {
    return true;
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return JsApiJumpDownloaderWidgetForNative.a.class;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(143324);
    this.appId = paramParcel.readString();
    AppMethodBeat.o(143324);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143325);
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(143325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative.JumpDownloadWidgetRequest
 * JD-Core Version:    0.7.0.1
 */