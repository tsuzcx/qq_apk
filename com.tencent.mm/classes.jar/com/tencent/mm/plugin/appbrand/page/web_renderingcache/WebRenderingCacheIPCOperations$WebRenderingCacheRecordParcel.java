package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appId", "", "commLibVersionId", "appVersionId", "pageURL", "filePath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppVersionId", "getCommLibVersionId", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "getPageURL", "describeContents", "", "toDBBean", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheAccessRecord;", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel
  implements Parcelable
{
  public static final Parcelable.Creator<WebRenderingCacheRecordParcel> CREATOR;
  public static final WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel.a tDo;
  private final String appId;
  String filePath;
  private final String tDp;
  private final String tDq;
  private final String tDr;
  
  static
  {
    AppMethodBeat.i(50982);
    tDo = new WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel.a((byte)0);
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
    this.tDp = paramString2;
    this.tDq = paramString3;
    this.tDr = paramString4;
    this.filePath = paramString5;
    AppMethodBeat.o(50980);
  }
  
  public final b cGx()
  {
    AppMethodBeat.i(50979);
    b localb = new b();
    localb.field_appId = this.appId;
    localb.field_commLibVersionId = this.tDp;
    localb.field_appVersionId = this.tDq;
    localb.field_pageURL = this.tDr;
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
    s.u(paramParcel, "dest");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.tDp);
    paramParcel.writeString(this.tDq);
    paramParcel.writeString(this.tDr);
    paramParcel.writeString(this.filePath);
    AppMethodBeat.o(50978);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheIPCOperations$WebRenderingCacheRecordParcel;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheIPCOperations.WebRenderingCacheRecordParcel
 * JD-Core Version:    0.7.0.1
 */