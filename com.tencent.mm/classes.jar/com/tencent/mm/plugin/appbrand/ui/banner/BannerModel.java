package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;

final class BannerModel
  implements Parcelable
{
  public static final Parcelable.Creator<BannerModel> CREATOR = new BannerModel.1();
  private static volatile BannerModel hfY;
  String appId;
  String appName;
  String fJY;
  int fJy;
  String hfX;
  
  BannerModel() {}
  
  private BannerModel(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.fJy = paramParcel.readInt();
    this.appName = paramParcel.readString();
    this.fJY = paramParcel.readString();
    this.hfX = paramParcel.readString();
  }
  
  static BannerModel apA()
  {
    try
    {
      BannerModel localBannerModel = hfY;
      return localBannerModel;
    }
    finally {}
  }
  
  static BannerModel apz()
  {
    try
    {
      BannerModel localBannerModel = ((e)g.r(e.class)).apq();
      hfY = localBannerModel;
      return localBannerModel;
    }
    finally {}
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.fJY);
    paramParcel.writeString(this.hfX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.BannerModel
 * JD-Core Version:    0.7.0.1
 */