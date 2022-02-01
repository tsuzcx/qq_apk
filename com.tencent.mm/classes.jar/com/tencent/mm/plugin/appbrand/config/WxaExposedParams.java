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
  public String iconUrl;
  public int jIU;
  public String kar;
  public String kas;
  public String kat;
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
    this.jIU = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.kar = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.pageId = paramParcel.readString();
    this.kas = paramParcel.readString();
    this.kat = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    AppMethodBeat.o(153221);
  }
  
  private WxaExposedParams(a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.jIU = parama.jIU;
    this.pkgVersion = parama.pkgVersion;
    this.kar = parama.kar;
    this.from = parama.from;
    this.pageId = parama.pageId;
    this.kas = parama.kas;
    this.kat = parama.kat;
    this.sessionId = parama.sessionId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153223);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.jIU + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.kar + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.kas + '\'' + ", screenshotLocalId='" + this.kat + '\'' + ", sessionId='" + this.sessionId + '\'' + '}';
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
    paramParcel.writeInt(this.jIU);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeString(this.kar);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.kas);
    paramParcel.writeString(this.kat);
    paramParcel.writeString(this.sessionId);
    AppMethodBeat.o(153222);
  }
  
  public static final class a
  {
    public String appId = "";
    public int from = 0;
    public String iconUrl = "";
    public int jIU = -1;
    public String kar = "";
    public String kas = "";
    public String kat = "";
    public String nickname = "";
    public String pageId = "";
    public int pkgVersion = -1;
    public String sessionId = "";
    public String username = "";
    
    public final a NV(String paramString)
    {
      this.appId = paramString;
      return this;
    }
    
    public final a NW(String paramString)
    {
      this.username = paramString;
      return this;
    }
    
    public final a NX(String paramString)
    {
      this.nickname = paramString;
      return this;
    }
    
    public final a NY(String paramString)
    {
      this.iconUrl = paramString;
      return this;
    }
    
    public final a NZ(String paramString)
    {
      this.pageId = paramString;
      return this;
    }
    
    public final WxaExposedParams bet()
    {
      AppMethodBeat.i(153220);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
      AppMethodBeat.o(153220);
      return localWxaExposedParams;
    }
    
    public final a sg(int paramInt)
    {
      this.pkgVersion = paramInt;
      return this;
    }
    
    public final a sh(int paramInt)
    {
      this.jIU = paramInt;
      return this;
    }
    
    public final a si(int paramInt)
    {
      this.from = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams
 * JD-Core Version:    0.7.0.1
 */