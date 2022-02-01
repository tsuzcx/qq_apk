package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "commLibVersionId", "appVersionId", "pageURL", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppVersionId", "getCommLibVersionId", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "getPageURL", "describeContents", "", "toDBBean", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
public class WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<WebRenderingCacheRecordParcel> CREATOR;
  public static final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel.a qyw;
  private final String appId;
  String filePath;
  private final String qyt;
  private final String qyu;
  private final String qyv;
  
  static
  {
    AppMethodBeat.i(50982);
    qyw = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50982);
  }
  
  public WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel(Parcel paramParcel)
  {
    this(str1, str2, str3, str4, paramParcel.readString());
    AppMethodBeat.i(50981);
    AppMethodBeat.o(50981);
  }
  
  private WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(50980);
    this.appId = paramString1;
    this.qyt = paramString2;
    this.qyu = paramString3;
    this.qyv = paramString4;
    this.filePath = paramString5;
    AppMethodBeat.o(50980);
  }
  
  public final b cfK()
  {
    AppMethodBeat.i(50979);
    b localb = new b();
    localb.field_appId = this.appId;
    localb.field_commLibVersionId = this.qyt;
    localb.field_appVersionId = this.qyu;
    localb.field_pageURL = this.qyv;
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
    p.k(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.qyt);
    paramParcel.writeString(this.qyu);
    paramParcel.writeString(this.qyv);
    paramParcel.writeString(this.filePath);
    AppMethodBeat.o(50978);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel
 * JD-Core Version:    0.7.0.1
 */