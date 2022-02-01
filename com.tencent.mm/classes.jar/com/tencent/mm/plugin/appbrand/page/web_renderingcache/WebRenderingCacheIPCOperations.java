package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations;", "", "()V", "TAG", "", "enqueueWorker", "", "block", "Lkotlin/Function0;", "IPC_accessRecord", "IPC_createRecord", "IPC_deleteRecord", "WebRenderingCacheRecordParcel", "plugin-appbrand-integration_release"})
public final class WebRenderingCacheIPCOperations
{
  public static final WebRenderingCacheIPCOperations mlQ;
  
  static
  {
    AppMethodBeat.i(50983);
    mlQ = new WebRenderingCacheIPCOperations();
    AppMethodBeat.o(50983);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "commLibVersionId", "appVersionId", "pageURL", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppVersionId", "getCommLibVersionId", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "getPageURL", "describeContents", "", "toDBBean", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
  public static class WebRenderingCacheRecordParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<WebRenderingCacheRecordParcel> CREATOR;
    public static final a mlV;
    private final String appId;
    String filePath;
    private final String mlS;
    private final String mlT;
    private final String mlU;
    
    static
    {
      AppMethodBeat.i(50982);
      mlV = new a((byte)0);
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
      this.mlS = paramString2;
      this.mlT = paramString3;
      this.mlU = paramString4;
      this.filePath = paramString5;
      AppMethodBeat.o(50980);
    }
    
    public final b bwz()
    {
      AppMethodBeat.i(50979);
      b localb = new b();
      localb.field_appId = this.appId;
      localb.field_commLibVersionId = this.mlS;
      localb.field_appVersionId = this.mlT;
      localb.field_pageURL = this.mlU;
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
      p.h(paramParcel, "dest");
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.mlS);
      paramParcel.writeString(this.mlT);
      paramParcel.writeString(this.mlU);
      paramParcel.writeString(this.filePath);
      AppMethodBeat.o(50978);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
    public static final class a {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
    public static final class b
      implements Parcelable.Creator<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel>
    {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_accessRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel, IPCVoid>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
    public static final class a
      extends q
      implements a<z>
    {
      public a(WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel paramWebRenderingCacheRecordParcel)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_createRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel, IPCVoid>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
    public static final class a
      extends q
      implements a<z>
    {
      public a(WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel paramWebRenderingCacheRecordParcel)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$IPC_deleteRecord;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class c
    implements com.tencent.mm.ipcinvoker.b<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel, IPCVoid>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$enqueueWorker$1"})
    public static final class a
      extends q
      implements a<z>
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