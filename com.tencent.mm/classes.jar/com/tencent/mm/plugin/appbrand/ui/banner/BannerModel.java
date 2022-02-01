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
  private static volatile BannerModel lFN;
  String appId;
  String appName;
  int gXn;
  String iVP;
  String lFM;
  
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
    this.gXn = paramParcel.readInt();
    this.appName = paramParcel.readString();
    this.iVP = paramParcel.readString();
    this.lFM = paramParcel.readString();
    AppMethodBeat.o(49037);
  }
  
  static BannerModel bpe()
  {
    AppMethodBeat.i(49038);
    try
    {
      BannerModel localBannerModel = ((e)g.ab(e.class)).boV();
      lFN = localBannerModel;
      return localBannerModel;
    }
    finally
    {
      AppMethodBeat.o(49038);
    }
  }
  
  static BannerModel bpf()
  {
    try
    {
      BannerModel localBannerModel = lFN;
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
    paramParcel.writeInt(this.gXn);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.iVP);
    paramParcel.writeString(this.lFM);
    AppMethodBeat.o(49036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.BannerModel
 * JD-Core Version:    0.7.0.1
 */