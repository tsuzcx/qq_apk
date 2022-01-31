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
  public int gXe;
  public int gXf;
  public String hko;
  public String hkp;
  public String iconUrl;
  public String nickname;
  public String pageId;
  public String username;
  
  static
  {
    AppMethodBeat.i(114918);
    CREATOR = new WxaExposedParams.1();
    AppMethodBeat.o(114918);
  }
  
  protected WxaExposedParams(Parcel paramParcel)
  {
    AppMethodBeat.i(114915);
    this.appId = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.gXe = paramParcel.readInt();
    this.gXf = paramParcel.readInt();
    this.hko = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.pageId = paramParcel.readString();
    this.hkp = paramParcel.readString();
    AppMethodBeat.o(114915);
  }
  
  private WxaExposedParams(WxaExposedParams.a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.gXe = parama.gXe;
    this.gXf = parama.gXf;
    this.hko = parama.hko;
    this.from = parama.from;
    this.pageId = parama.pageId;
    this.hkp = parama.hkp;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114917);
    String str = "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.gXe + ", pkgVersion=" + this.gXf + ", pkgMD5='" + this.hko + '\'' + ", from=" + this.from + ", pageId='" + this.pageId + '\'' + ", errorUrl='" + this.hkp + '\'' + '}';
    AppMethodBeat.o(114917);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114916);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.gXe);
    paramParcel.writeInt(this.gXf);
    paramParcel.writeString(this.hko);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.pageId);
    paramParcel.writeString(this.hkp);
    AppMethodBeat.o(114916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams
 * JD-Core Version:    0.7.0.1
 */