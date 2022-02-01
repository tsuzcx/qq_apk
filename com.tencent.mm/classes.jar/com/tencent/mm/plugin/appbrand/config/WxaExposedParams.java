package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaExposedParams
  implements Parcelable
{
  public static final Parcelable.Creator<WxaExposedParams> CREATOR;
  public String appId;
  public int from;
  public int iOQ;
  public String iconUrl;
  public String jfT;
  public String jfU;
  public String jfV;
  public String nickname;
  public String pageId;
  public int pkgVersion;
  public String sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(153224);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(153224);
  }
  
  protected WxaExposedParams(Parcel paramParcel)
  {
    AppMethodBeat.i(153221);
    this.appId = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.iOQ = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.jfT = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.pageId = paramParcel.readString();
    this.jfU = paramParcel.readString();
    this.jfV = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    AppMethodBeat.o(153221);
  }
  
  private WxaExposedParams(a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.iOQ = parama.iOQ;
    this.pkgVersion = parama.pkgVersion;
    this.jfT = parama.jfT;
    this.from = parama.from;
    this.pageId = parama.pageId;
    this.jfU = parama.jfU;
    this.jfV = parama.jfV;
    this.sessionId = parama.sessionId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153223);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.iOQ + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.jfT + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.jfU + '\'' + ", screenshotLocalId='" + this.jfV + '\'' + ", sessionId='" + this.sessionId + '\'' + '}';
    AppMethodBeat.o(153223);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153222);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.iOQ);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeString(this.jfT);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.jfU);
    paramParcel.writeString(this.jfV);
    paramParcel.writeString(this.sessionId);
    AppMethodBeat.o(153222);
  }
  
  public static final class a
  {
    public String appId = "";
    public int from = 0;
    public int iOQ = -1;
    public String iconUrl = "";
    public String jfT = "";
    public String jfU = "";
    public String jfV = "";
    public String nickname = "";
    public String pageId = "";
    public int pkgVersion = -1;
    public String sessionId = "";
    public String username = "";
    
    public final a GA(String paramString)
    {
      this.nickname = paramString;
      return this;
    }
    
    public final a GB(String paramString)
    {
      this.iconUrl = paramString;
      return this;
    }
    
    public final a Gy(String paramString)
    {
      this.appId = paramString;
      return this;
    }
    
    public final a Gz(String paramString)
    {
      this.username = paramString;
      return this;
    }
    
    public final WxaExposedParams aTV()
    {
      AppMethodBeat.i(153220);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
      AppMethodBeat.o(153220);
      return localWxaExposedParams;
    }
    
    public final a qT(int paramInt)
    {
      this.from = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams
 * JD-Core Version:    0.7.0.1
 */