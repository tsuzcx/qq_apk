package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader_app.api.a.c;

public final class JsApiJumpDownloaderWidgetForNative
  extends com.tencent.mm.plugin.appbrand.jsapi.c<v>
{
  public static final int CTRL_INDEX = 671;
  public static final String NAME = "jumpDownloaderWidgetForNative";
  
  static class JumpDownloadWidgetRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<JumpDownloadWidgetRequest> CREATOR;
    public String appId;
    
    static
    {
      AppMethodBeat.i(45829);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45829);
    }
    
    JumpDownloadWidgetRequest() {}
    
    JumpDownloadWidgetRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(45828);
      k(paramParcel);
      AppMethodBeat.o(45828);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bOe()
    {
      return JsApiJumpDownloaderWidgetForNative.a.class;
    }
    
    public final boolean bPn()
    {
      return true;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(45826);
      this.appId = paramParcel.readString();
      AppMethodBeat.o(45826);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45827);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(45827);
    }
  }
  
  static class a
    extends AppBrandProxyUIProcessTask
  {
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(45831);
      if (paramProcessRequest != null) {}
      for (paramProcessRequest = ((JsApiJumpDownloaderWidgetForNative.JumpDownloadWidgetRequest)paramProcessRequest).appId;; paramProcessRequest = null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("appId", paramProcessRequest);
        localIntent.putExtra("view_task", true);
        ((com.tencent.mm.plugin.downloader_app.api.c)h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(bPf(), localIntent, new a.c()
        {
          public final void bPX()
          {
            AppMethodBeat.i(45830);
            JsApiJumpDownloaderWidgetForNative.a.a(JsApiJumpDownloaderWidgetForNative.a.this);
            AppMethodBeat.o(45830);
          }
        });
        AppMethodBeat.o(45831);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative
 * JD-Core Version:    0.7.0.1
 */