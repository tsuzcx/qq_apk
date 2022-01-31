package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

final class BannerModel
  implements Parcelable
{
  public static final Parcelable.Creator<BannerModel> CREATOR;
  private static volatile BannerModel iRm;
  String appId;
  String appName;
  String hcN;
  int hcr;
  String iRl;
  
  static
  {
    AppMethodBeat.i(133320);
    CREATOR = new BannerModel.1();
    AppMethodBeat.o(133320);
  }
  
  BannerModel() {}
  
  private BannerModel(Parcel paramParcel)
  {
    AppMethodBeat.i(133318);
    this.appId = paramParcel.readString();
    this.hcr = paramParcel.readInt();
    this.appName = paramParcel.readString();
    this.hcN = paramParcel.readString();
    this.iRl = paramParcel.readString();
    AppMethodBeat.o(133318);
  }
  
  static BannerModel aMP()
  {
    AppMethodBeat.i(133319);
    try
    {
      BannerModel localBannerModel = ((e)g.E(e.class)).aMG();
      iRm = localBannerModel;
      return localBannerModel;
    }
    finally
    {
      AppMethodBeat.o(133319);
    }
  }
  
  static BannerModel aMQ()
  {
    try
    {
      BannerModel localBannerModel = iRm;
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
    AppMethodBeat.i(133317);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.hcN);
    paramParcel.writeString(this.iRl);
    AppMethodBeat.o(133317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.BannerModel
 * JD-Core Version:    0.7.0.1
 */