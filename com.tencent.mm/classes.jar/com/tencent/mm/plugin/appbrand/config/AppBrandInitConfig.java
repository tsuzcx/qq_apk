package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandInitConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfig> CREATOR = new Parcelable.Creator() {};
  public String appId;
  public int bFB;
  public String bJw;
  public int fEL;
  public String fNK;
  public String fPq;
  public final AppBrandLaunchReferrer fPr;
  public boolean fPs;
  public String iconUrl;
  
  public AppBrandInitConfig()
  {
    this.fPr = new AppBrandLaunchReferrer();
  }
  
  protected AppBrandInitConfig(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.bJw = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.fEL = paramParcel.readInt();
    this.bFB = paramParcel.readInt();
    this.fPq = paramParcel.readString();
    this.fPr = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
    this.fNK = paramParcel.readString();
  }
  
  public boolean ZH()
  {
    return this.bFB == 4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.bJw);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.fEL);
    paramParcel.writeInt(this.bFB);
    paramParcel.writeString(this.fPq);
    paramParcel.writeParcelable(this.fPr, paramInt);
    paramParcel.writeString(this.fNK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig
 * JD-Core Version:    0.7.0.1
 */