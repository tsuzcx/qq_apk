package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WxaAttributes$WxaEntryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaEntryInfo> CREATOR;
  public String hkc;
  public String iconUrl;
  public String title;
  public String username;
  
  static
  {
    AppMethodBeat.i(96165);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(96165);
  }
  
  public WxaAttributes$WxaEntryInfo() {}
  
  protected WxaAttributes$WxaEntryInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(96164);
    this.username = paramParcel.readString();
    this.title = paramParcel.readString();
    this.hkc = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    AppMethodBeat.o(96164);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96163);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.hkc);
    paramParcel.writeString(this.iconUrl);
    AppMethodBeat.o(96163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo
 * JD-Core Version:    0.7.0.1
 */