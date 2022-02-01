package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WxaAttributes$WxaEntryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaEntryInfo> CREATOR;
  public String iconUrl;
  public String obt;
  public String title;
  public String username;
  
  static
  {
    AppMethodBeat.i(123495);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123495);
  }
  
  public WxaAttributes$WxaEntryInfo() {}
  
  protected WxaAttributes$WxaEntryInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(123494);
    this.username = paramParcel.readString();
    this.title = paramParcel.readString();
    this.obt = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    AppMethodBeat.o(123494);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(123493);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.obt);
    paramParcel.writeString(this.iconUrl);
    AppMethodBeat.o(123493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo
 * JD-Core Version:    0.7.0.1
 */