package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WxaExposedParams
  implements Parcelable
{
  public static final Parcelable.Creator<WxaExposedParams> CREATOR = new WxaExposedParams.1();
  public String appId;
  public String bUo;
  public int fEM;
  public int fEN;
  public String fRx;
  public String fRy;
  public int from;
  public String iconUrl;
  public String nickname;
  public String username;
  
  protected WxaExposedParams(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.fEM = paramParcel.readInt();
    this.fEN = paramParcel.readInt();
    this.fRx = paramParcel.readString();
    this.from = paramParcel.readInt();
    this.bUo = paramParcel.readString();
    this.fRy = paramParcel.readString();
  }
  
  private WxaExposedParams(WxaExposedParams.a parama)
  {
    this.appId = parama.appId;
    this.username = parama.username;
    this.nickname = parama.nickname;
    this.iconUrl = parama.iconUrl;
    this.fEM = parama.fEM;
    this.fEN = parama.fEN;
    this.fRx = parama.fRx;
    this.from = parama.from;
    this.bUo = parama.bUo;
    this.fRy = parama.fRy;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.fEM + ", pkgVersion=" + this.fEN + ", pkgMD5='" + this.fRx + '\'' + ", from=" + this.from + ", pageId='" + this.bUo + '\'' + ", errorUrl='" + this.fRy + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.fEM);
    paramParcel.writeInt(this.fEN);
    paramParcel.writeString(this.fRx);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.bUo);
    paramParcel.writeString(this.fRy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaExposedParams
 * JD-Core Version:    0.7.0.1
 */