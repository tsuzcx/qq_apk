package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WxaAttributes$WxaVersionCoverImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaVersionCoverImageInfo> CREATOR;
  public String obw;
  public String obx;
  
  static
  {
    AppMethodBeat.i(123504);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123504);
  }
  
  public WxaAttributes$WxaVersionCoverImageInfo() {}
  
  protected WxaAttributes$WxaVersionCoverImageInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(123503);
    this.obw = paramParcel.readString();
    this.obx = paramParcel.readString();
    AppMethodBeat.o(123503);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123502);
    paramParcel.writeString(this.obw);
    paramParcel.writeString(this.obx);
    AppMethodBeat.o(123502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo
 * JD-Core Version:    0.7.0.1
 */