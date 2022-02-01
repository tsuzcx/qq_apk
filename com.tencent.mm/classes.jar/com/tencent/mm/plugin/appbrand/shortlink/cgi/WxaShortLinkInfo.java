package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "Landroid/os/Parcelable;", "appId", "", "pageTitle", "path", "version", "", "versionType", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getNickName", "getPageTitle", "getPath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxaShortLinkInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaShortLinkInfo> CREATOR;
  public static final WxaShortLinkInfo.a tVj;
  public final String appId;
  public final int euz;
  public final String nickName;
  public final String path;
  private final String tgw;
  public final int version;
  
  static
  {
    AppMethodBeat.i(321881);
    tVj = new WxaShortLinkInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(321881);
  }
  
  public WxaShortLinkInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(321872);
    this.appId = paramString1;
    this.tgw = paramString2;
    this.path = paramString3;
    this.version = paramInt1;
    this.euz = paramInt2;
    this.nickName = paramString4;
    AppMethodBeat.o(321872);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(321897);
    if (this == paramObject)
    {
      AppMethodBeat.o(321897);
      return true;
    }
    if (!(paramObject instanceof WxaShortLinkInfo))
    {
      AppMethodBeat.o(321897);
      return false;
    }
    paramObject = (WxaShortLinkInfo)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(321897);
      return false;
    }
    if (!s.p(this.tgw, paramObject.tgw))
    {
      AppMethodBeat.o(321897);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(321897);
      return false;
    }
    if (this.version != paramObject.version)
    {
      AppMethodBeat.o(321897);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(321897);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(321897);
      return false;
    }
    AppMethodBeat.o(321897);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(321896);
    int i = this.appId.hashCode();
    int j = this.tgw.hashCode();
    int k = this.path.hashCode();
    int m = this.version;
    int n = this.euz;
    int i1 = this.nickName.hashCode();
    AppMethodBeat.o(321896);
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(321891);
    String str = "WxaShortLinkInfo(\nappId='" + this.appId + "'\npageTitle='" + this.tgw + "'\npath='" + this.path + "'\nversion=" + this.version + "\nversionType=" + this.euz + "\nnickName=" + this.nickName + ')';
    AppMethodBeat.o(321891);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(321898);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.tgw);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.euz);
    paramParcel.writeString(this.nickName);
    AppMethodBeat.o(321898);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WxaShortLinkInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo
 * JD-Core Version:    0.7.0.1
 */