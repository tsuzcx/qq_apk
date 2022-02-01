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
  public String msgId;
  public int nHY;
  public String nickname;
  public String obW;
  public String obX;
  public String obY;
  public String obZ;
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
    this.nHY = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.obW = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.pageId = paramParcel.readString();
    this.obX = paramParcel.readString();
    this.obY = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    this.obZ = paramParcel.readString();
    this.msgId = paramParcel.readString();
    AppMethodBeat.o(153221);
  }
  
  private WxaExposedParams(a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.nHY = parama.nHY;
    this.pkgVersion = parama.pkgVersion;
    this.obW = parama.obW;
    this.from = parama.from;
    this.pageId = parama.pageId;
    this.obX = parama.obX;
    this.obY = parama.obY;
    this.sessionId = parama.sessionId;
    this.obZ = parama.obZ;
    this.msgId = parama.msgId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153223);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.nHY + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.obW + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.obX + '\'' + ", screenshotLocalId='" + this.obY + '\'' + ", sessionId='" + this.sessionId + '\'' + ", businessAppId='" + this.obZ + '\'' + ", msgId='" + this.msgId + '\'' + '}';
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
    paramParcel.writeInt(this.nHY);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeString(this.obW);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.obX);
    paramParcel.writeString(this.obY);
    paramParcel.writeString(this.sessionId);
    paramParcel.writeString(this.obZ);
    paramParcel.writeString(this.msgId);
    AppMethodBeat.o(153222);
  }
  
  public static final class a
  {
    public String appId = "";
    public int from = 0;
    public String iconUrl = "";
    public String msgId = "";
    public int nHY = -1;
    public String nickname = "";
    public String obW = "";
    public String obX = "";
    public String obY = "";
    public String obZ = "";
    public String pageId = "";
    public int pkgVersion = -1;
    public String sessionId = "";
    public String username = "";
    
    public final a afA(String paramString)
    {
      this.username = paramString;
      return this;
    }
    
    public final a afB(String paramString)
    {
      this.nickname = paramString;
      return this;
    }
    
    public final a afC(String paramString)
    {
      this.iconUrl = paramString;
      return this;
    }
    
    public final a afD(String paramString)
    {
      this.pageId = paramString;
      return this;
    }
    
    public final a afz(String paramString)
    {
      this.appId = paramString;
      return this;
    }
    
    public final WxaExposedParams bLN()
    {
      AppMethodBeat.i(153220);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
      AppMethodBeat.o(153220);
      return localWxaExposedParams;
    }
    
    public final a zs(int paramInt)
    {
      this.pkgVersion = paramInt;
      return this;
    }
    
    public final a zt(int paramInt)
    {
      this.nHY = paramInt;
      return this;
    }
    
    public final a zu(int paramInt)
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