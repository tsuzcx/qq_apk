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
  public int kNW;
  public String lhn;
  public String lho;
  public String lhp;
  public String lhq;
  public String msgId;
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
    this.kNW = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.lhn = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.pageId = paramParcel.readString();
    this.lho = paramParcel.readString();
    this.lhp = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    this.lhq = paramParcel.readString();
    this.msgId = paramParcel.readString();
    AppMethodBeat.o(153221);
  }
  
  private WxaExposedParams(a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.kNW = parama.kNW;
    this.pkgVersion = parama.pkgVersion;
    this.lhn = parama.lhn;
    this.from = parama.from;
    this.pageId = parama.pageId;
    this.lho = parama.lho;
    this.lhp = parama.lhp;
    this.sessionId = parama.sessionId;
    this.lhq = parama.lhq;
    this.msgId = parama.msgId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153223);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.kNW + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.lhn + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.lho + '\'' + ", screenshotLocalId='" + this.lhp + '\'' + ", sessionId='" + this.sessionId + '\'' + ", businessAppId='" + this.lhq + '\'' + ", msgId='" + this.msgId + '\'' + '}';
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
    paramParcel.writeInt(this.kNW);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeString(this.lhn);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.lho);
    paramParcel.writeString(this.lhp);
    paramParcel.writeString(this.sessionId);
    paramParcel.writeString(this.lhq);
    paramParcel.writeString(this.msgId);
    AppMethodBeat.o(153222);
  }
  
  public static final class a
  {
    public String appId = "";
    public int from = 0;
    public String iconUrl = "";
    public int kNW = -1;
    public String lhn = "";
    public String lho = "";
    public String lhp = "";
    public String lhq = "";
    public String msgId = "";
    public String nickname = "";
    public String pageId = "";
    public int pkgVersion = -1;
    public String sessionId = "";
    public String username = "";
    
    public final a XN(String paramString)
    {
      this.appId = paramString;
      return this;
    }
    
    public final a XO(String paramString)
    {
      this.username = paramString;
      return this;
    }
    
    public final a XP(String paramString)
    {
      this.nickname = paramString;
      return this;
    }
    
    public final a XQ(String paramString)
    {
      this.iconUrl = paramString;
      return this;
    }
    
    public final a XR(String paramString)
    {
      this.pageId = paramString;
      return this;
    }
    
    public final WxaExposedParams bAv()
    {
      AppMethodBeat.i(153220);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
      AppMethodBeat.o(153220);
      return localWxaExposedParams;
    }
    
    public final a wf(int paramInt)
    {
      this.pkgVersion = paramInt;
      return this;
    }
    
    public final a wg(int paramInt)
    {
      this.kNW = paramInt;
      return this;
    }
    
    public final a wh(int paramInt)
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