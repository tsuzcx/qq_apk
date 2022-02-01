package com.tencent.mm.media.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandMediaSource
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandMediaSource> CREATOR;
  public String hkO;
  public String hkP;
  public String url;
  
  static
  {
    AppMethodBeat.i(184250);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(184250);
  }
  
  public AppBrandMediaSource()
  {
    this.url = "";
    this.hkO = "";
    this.hkP = "";
  }
  
  public AppBrandMediaSource(Parcel paramParcel)
  {
    AppMethodBeat.i(184248);
    this.url = "";
    this.hkO = "";
    this.hkP = "";
    this.url = paramParcel.readString();
    this.hkO = paramParcel.readString();
    this.hkP = paramParcel.readString();
    AppMethodBeat.o(184248);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(184249);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.hkO);
    paramParcel.writeString(this.hkP);
    AppMethodBeat.o(184249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.model.AppBrandMediaSource
 * JD-Core Version:    0.7.0.1
 */