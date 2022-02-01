package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;

final class BannerModel
  implements Parcelable
{
  public static final Parcelable.Creator<BannerModel> CREATOR;
  private static volatile BannerModel rcd;
  String appId;
  String appName;
  int cBU;
  String nQm;
  String rcc;
  
  static
  {
    AppMethodBeat.i(49039);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(49039);
  }
  
  BannerModel() {}
  
  private BannerModel(Parcel paramParcel)
  {
    AppMethodBeat.i(49037);
    this.appId = paramParcel.readString();
    this.cBU = paramParcel.readInt();
    this.appName = paramParcel.readString();
    this.nQm = paramParcel.readString();
    this.rcc = paramParcel.readString();
    AppMethodBeat.o(49037);
  }
  
  static BannerModel ckP()
  {
    AppMethodBeat.i(49038);
    try
    {
      BannerModel localBannerModel = ((e)h.ae(e.class)).ckH();
      rcd = localBannerModel;
      return localBannerModel;
    }
    finally
    {
      AppMethodBeat.o(49038);
    }
  }
  
  static BannerModel ckQ()
  {
    try
    {
      BannerModel localBannerModel = rcd;
      return localBannerModel;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(49036);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.nQm);
    paramParcel.writeString(this.rcc);
    AppMethodBeat.o(49036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.BannerModel
 * JD-Core Version:    0.7.0.1
 */