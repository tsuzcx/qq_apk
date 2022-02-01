package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WxaAttributes$HalfPage
  implements Parcelable
{
  public static final Parcelable.Creator<HalfPage> CREATOR;
  public String oaT;
  
  static
  {
    AppMethodBeat.i(187375);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(187375);
  }
  
  protected WxaAttributes$HalfPage()
  {
    this.oaT = "default";
  }
  
  protected WxaAttributes$HalfPage(Parcel paramParcel)
  {
    AppMethodBeat.i(187367);
    this.oaT = "default";
    this.oaT = paramParcel.readString();
    AppMethodBeat.o(187367);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(187372);
    paramParcel.writeString(this.oaT);
    AppMethodBeat.o(187372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.HalfPage
 * JD-Core Version:    0.7.0.1
 */