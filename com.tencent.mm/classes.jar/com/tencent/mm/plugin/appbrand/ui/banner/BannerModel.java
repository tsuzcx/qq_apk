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
  private static volatile BannerModel mNl;
  String appId;
  String appName;
  int hSZ;
  String jTr;
  String mNk;
  
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
    this.hSZ = paramParcel.readInt();
    this.appName = paramParcel.readString();
    this.jTr = paramParcel.readString();
    this.mNk = paramParcel.readString();
    AppMethodBeat.o(49037);
  }
  
  static BannerModel bBa()
  {
    AppMethodBeat.i(49038);
    try
    {
      BannerModel localBannerModel = ((e)g.ab(e.class)).bAR();
      mNl = localBannerModel;
      return localBannerModel;
    }
    finally
    {
      AppMethodBeat.o(49038);
    }
  }
  
  static BannerModel bBb()
  {
    try
    {
      BannerModel localBannerModel = mNl;
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
    AppMethodBeat.i(49036);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hSZ);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.jTr);
    paramParcel.writeString(this.mNk);
    AppMethodBeat.o(49036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.BannerModel
 * JD-Core Version:    0.7.0.1
 */