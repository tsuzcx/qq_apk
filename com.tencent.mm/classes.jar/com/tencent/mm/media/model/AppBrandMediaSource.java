package com.tencent.mm.media.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandMediaSource
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandMediaSource> CREATOR;
  public String hnC;
  public String hnD;
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
    this.hnC = "";
    this.hnD = "";
  }
  
  public AppBrandMediaSource(Parcel paramParcel)
  {
    AppMethodBeat.i(184248);
    this.url = "";
    this.hnC = "";
    this.hnD = "";
    this.url = paramParcel.readString();
    this.hnC = paramParcel.readString();
    this.hnD = paramParcel.readString();
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
    paramParcel.writeString(this.hnC);
    paramParcel.writeString(this.hnD);
    AppMethodBeat.o(184249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.model.AppBrandMediaSource
 * JD-Core Version:    0.7.0.1
 */