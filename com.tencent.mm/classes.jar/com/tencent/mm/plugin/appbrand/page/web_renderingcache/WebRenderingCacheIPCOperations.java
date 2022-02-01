package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.g.a.a;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations;", "", "()V", "TAG", "", "enqueueWorker", "", "block", "Lkotlin/Function0;", "IPC_accessRecord", "IPC_createRecord", "IPC_deleteRecord", "WebRenderingCacheRecordParcel", "plugin-appbrand-integration_release"})
public final class WebRenderingCacheIPCOperations
{
  public static final WebRenderingCacheIPCOperations lHf;
  
  static
  {
    AppMethodBeat.i(50983);
    lHf = new WebRenderingCacheIPCOperations();
    AppMethodBeat.o(50983);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "commLibVersionId", "appVersionId", "pageURL", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppVersionId", "getCommLibVersionId", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "getPageURL", "describeContents", "", "toDBBean", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  public static class WebRenderingCacheRecordParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<WebRenderingCacheRecordParcel> CREATOR;
    public static final a lHk;
    private final String appId;
    String filePath;
    private final String lHh;
    private final String lHi;
    private final String lHj;
    
    static
    {
      AppMethodBeat.i(50982);
      lHk = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50982);
    }
    
    public WebRenderingCacheRecordParcel(Parcel paramParcel)
    {
      this(str1, str2, str3, str4, paramParcel.readString());
      AppMethodBeat.i(50981);
      AppMethodBeat.o(50981);
    }
    
    private WebRenderingCacheRecordParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      AppMethodBeat.i(50980);
      this.appId = paramString1;
      this.lHh = paramString2;
      this.lHi = paramString3;
      this.lHj = paramString4;
      this.filePath = paramString5;
      AppMethodBeat.o(50980);
    }
    
    public final b brE()
    {
      AppMethodBeat.i(50979);
      b localb = new b();
      localb.field_appId = this.appId;
      localb.field_commLibVersionId = this.lHh;
      localb.field_appVersionId = this.lHi;
      localb.field_pageURL = this.lHj;
      AppMethodBeat.o(50979);
      return localb;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50978);
      k.h(paramParcel, "dest");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.lHh);
      paramParcel.writeString(this.lHi);
      paramParcel.writeString(this.lHj);
      paramParcel.writeString(this.filePath);
      AppMethodBeat.o(50978);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel>
    {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_accessRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel, IPCVoid>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
    public static final class a
      extends d.g.b.l
      implements a<y>
    {
      public a(WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel paramWebRenderingCacheRecordParcel)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_createRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel, IPCVoid>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
    public static final class a
      extends d.g.b.l
      implements a<y>
    {
      public a(WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel paramWebRenderingCacheRecordParcel)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_deleteRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class c
    implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel, IPCVoid>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
    public static final class a
      extends d.g.b.l
      implements a<y>
    {
      public a(WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel paramWebRenderingCacheRecordParcel)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheIPCOperations
 * JD-Core Version:    0.7.0.1
 */