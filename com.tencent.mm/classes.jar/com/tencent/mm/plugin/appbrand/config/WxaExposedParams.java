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
  public String hUf;
  public String iconUrl;
  public String msgId;
  public String nickname;
  public int pkgVersion;
  public int qHO;
  public String rcK;
  public String rcL;
  public String rcM;
  public String rcN;
  public String rcO;
  public String rcP;
  public String sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(153224);
    CREATOR = new WxaExposedParams.1();
    AppMethodBeat.o(153224);
  }
  
  protected WxaExposedParams(Parcel paramParcel)
  {
    AppMethodBeat.i(153221);
    this.rcK = "";
    this.rcL = "";
    this.appId = paramParcel.readString();
    this.rcK = paramParcel.readString();
    this.rcL = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.qHO = paramParcel.readInt();
    this.pkgVersion = paramParcel.readInt();
    this.rcM = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.hUf = paramParcel.readString();
    this.rcN = paramParcel.readString();
    this.rcO = paramParcel.readString();
    this.sessionId = paramParcel.readString();
    this.rcP = paramParcel.readString();
    this.msgId = paramParcel.readString();
    AppMethodBeat.o(153221);
  }
  
  private WxaExposedParams(a parama)
  {
    this.rcK = "";
    this.rcL = "";
    this.appId = parama.appId;
    this.rcK = parama.rcK;
    this.rcL = parama.rcL;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.qHO = parama.qHO;
    this.pkgVersion = parama.pkgVersion;
    this.rcM = parama.rcM;
    this.from = parama.from;
    this.hUf = parama.hUf;
    this.rcN = parama.rcN;
    this.rcO = parama.rcO;
    this.sessionId = parama.sessionId;
    this.rcP = parama.rcP;
    this.msgId = parama.msgId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(153223);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.qHO + ", pkgVersion=" + this.pkgVersion + ", pkgMD5='" + this.rcM + '\'' + ", from=" + this.from + ", pageId='" + this.hUf + '\'' + ", errorUrl='" + this.rcN + '\'' + ", screenshotLocalId='" + this.rcO + '\'' + ", sessionId='" + this.sessionId + '\'' + ", businessAppId='" + this.rcP + '\'' + ", msgId='" + this.msgId + '\'' + '}';
    AppMethodBeat.o(153223);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153222);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.rcK);
    paramParcel.writeString(this.rcL);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.qHO);
    paramParcel.writeInt(this.pkgVersion);
    paramParcel.writeString(this.rcM);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.hUf);
    paramParcel.writeString(this.rcN);
    paramParcel.writeString(this.rcO);
    paramParcel.writeString(this.sessionId);
    paramParcel.writeString(this.rcP);
    paramParcel.writeString(this.msgId);
    AppMethodBeat.o(153222);
  }
  
  public static final class a
  {
    public String appId = "";
    public int from = 0;
    public String hUf = "";
    public String iconUrl = "";
    public String msgId = "";
    public String nickname = "";
    public int pkgVersion = -1;
    public int qHO = -1;
    public String rcK = "";
    public String rcL = "";
    public String rcM = "";
    public String rcN = "";
    public String rcO = "";
    public String rcP = "";
    public String sessionId = "";
    public String username = "";
    
    public final WxaExposedParams cll()
    {
      AppMethodBeat.i(153220);
      WxaExposedParams localWxaExposedParams = new WxaExposedParams(this, (byte)0);
      AppMethodBeat.o(153220);
      return localWxaExposedParams;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams
 * JD-Core Version:    0.7.0.1
 */