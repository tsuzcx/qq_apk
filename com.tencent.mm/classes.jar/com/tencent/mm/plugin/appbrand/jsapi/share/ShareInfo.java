package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareInfo> CREATOR;
  public String cyq;
  public String cyr;
  
  static
  {
    AppMethodBeat.i(46818);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46818);
  }
  
  private ShareInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46817);
    this.cyr = paramParcel.readString();
    this.cyq = paramParcel.readString();
    AppMethodBeat.o(46817);
  }
  
  public ShareInfo(String paramString1, String paramString2)
  {
    this.cyr = paramString1;
    this.cyq = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46816);
    paramParcel.writeString(this.cyr);
    paramParcel.writeString(this.cyq);
    AppMethodBeat.o(46816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo
 * JD-Core Version:    0.7.0.1
 */