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
  public int jLV;
  public String kdI;
  public String kdJ;
  public String kdK;
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
    this.jLV = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.kdI = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.pageId = paramParcel.readString();
    this.kdJ = paramParcel.readString();
    this.kdK = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    AppMethodBeat.o(153221);
  }
  
  private WxaExposedParams(a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.jLV = parama.jLV;
    this.pkgVersion = parama.pkgVersion;
    this.kdI = parama.kdI;
    this.from = parama.from;
    this.pageId = parama.pageId;
    this.kdJ = parama.kdJ;
    this.kdK = parama.kdK;
    this.sessionId = parama.sessionId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153223);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.jLV + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.kdI + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.kdJ + '\'' + ", screenshotLocalId='" + this.kdK + '\'' + ", sessionId='" + this.sessionId + '\'' + '}';
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
    paramParcel.writeInt(this.jLV);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeString(this.kdI);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.kdJ);
    paramParcel.writeString(this.kdK);
    paramParcel.writeString(this.sessionId);
    AppMethodBeat.o(153222);
  }
  
  public static final class a
  {
    public String appId = "";
    public int from = 0;
    public String iconUrl = "";
    public int jLV = -1;
    public String kdI = "";
    public String kdJ = "";
    public String kdK = "";
    public String nickname = "";
    public String pageId = "";
    public int pkgVersion = -1;
    public String sessionId = "";
    public String username = "";
    
    public final a OC(String paramString)
    {
      this.appId = paramString;
      return this;
    }
    
    public final a OD(String paramString)
    {
      this.username = paramString;
      return this;
    }
    
    public final a OE(String paramString)
    {
      this.nickname = paramString;
      return this;
    }
    
    public final a OF(String paramString)
    {
      this.iconUrl = paramString;
      return this;
    }
    
    public final a OG(String paramString)
    {
      this.pageId = paramString;
      return this;
    }
    
    public final WxaExposedParams bfb()
    {
      AppMethodBeat.i(153220);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
      AppMethodBeat.o(153220);
      return localWxaExposedParams;
    }
    
    public final a sj(int paramInt)
    {
      this.pkgVersion = paramInt;
      return this;
    }
    
    public final a sk(int paramInt)
    {
      this.jLV = paramInt;
      return this;
    }
    
    public final a sl(int paramInt)
    {
      this.from = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams
 * JD-Core Version:    0.7.0.1
 */