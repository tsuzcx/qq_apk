package com.tencent.mm.plugin.appbrand.shortlink.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "Landroid/os/Parcelable;", "appId", "", "pageTitle", "path", "version", "", "versionType", "nickName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getNickName", "getPageTitle", "getPath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"})
public final class WxaShortLinkInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final a qQx;
  public final String appId;
  public final int cBU;
  public final String nickName;
  public final String path;
  private final String qbv;
  public final int version;
  
  static
  {
    AppMethodBeat.i(234797);
    qQx = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(234797);
  }
  
  public WxaShortLinkInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(234796);
    this.appId = paramString1;
    this.qbv = paramString2;
    this.path = paramString3;
    this.version = paramInt1;
    this.cBU = paramInt2;
    this.nickName = paramString4;
    AppMethodBeat.o(234796);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234799);
    if (this != paramObject)
    {
      if ((paramObject instanceof WxaShortLinkInfo))
      {
        paramObject = (WxaShortLinkInfo)paramObject;
        if ((!p.h(this.appId, paramObject.appId)) || (!p.h(this.qbv, paramObject.qbv)) || (!p.h(this.path, paramObject.path)) || (this.version != paramObject.version) || (this.cBU != paramObject.cBU) || (!p.h(this.nickName, paramObject.nickName))) {}
      }
    }
    else
    {
      AppMethodBeat.o(234799);
      return true;
    }
    AppMethodBeat.o(234799);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(234798);
    String str = this.appId;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.qbv;
      if (str == null) {
        break label129;
      }
      j = str.hashCode();
      label42:
      str = this.path;
      if (str == null) {
        break label134;
      }
    }
    label129:
    label134:
    for (int k = str.hashCode();; k = 0)
    {
      int n = this.version;
      int i1 = this.cBU;
      str = this.nickName;
      if (str != null) {
        m = str.hashCode();
      }
      AppMethodBeat.o(234798);
      return (((k + (j + i * 31) * 31) * 31 + n) * 31 + i1) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234794);
    String str = "WxaShortLinkInfo(\nappId='" + this.appId + "'\npageTitle='" + this.qbv + "'\npath='" + this.path + "'\nversion=" + this.version + '\n' + "versionType=" + this.cBU + '\n' + "nickName=" + this.nickName + ')';
    AppMethodBeat.o(234794);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(234800);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.qbv);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeString(this.nickName);
    AppMethodBeat.o(234800);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo$Companion;", "", "()V", "make", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckShortLinkResp;", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(251044);
      p.k(paramParcel, "in");
      paramParcel = new WxaShortLinkInfo(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString());
      AppMethodBeat.o(251044);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new WxaShortLinkInfo[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo
 * JD-Core Version:    0.7.0.1
 */