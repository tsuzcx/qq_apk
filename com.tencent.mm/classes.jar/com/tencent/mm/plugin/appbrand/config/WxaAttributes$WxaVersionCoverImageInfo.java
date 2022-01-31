package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WxaAttributes$WxaVersionCoverImageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaVersionCoverImageInfo> CREATOR;
  public String hiF;
  public String hiG;
  
  static
  {
    AppMethodBeat.i(140086);
    CREATOR = new WxaAttributes.WxaVersionCoverImageInfo.1();
    AppMethodBeat.o(140086);
  }
  
  public WxaAttributes$WxaVersionCoverImageInfo() {}
  
  protected WxaAttributes$WxaVersionCoverImageInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(140085);
    this.hiF = paramParcel.readString();
    this.hiG = paramParcel.readString();
    AppMethodBeat.o(140085);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(140084);
    paramParcel.writeString(this.hiF);
    paramParcel.writeString(this.hiG);
    AppMethodBeat.o(140084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo
 * JD-Core Version:    0.7.0.1
 */