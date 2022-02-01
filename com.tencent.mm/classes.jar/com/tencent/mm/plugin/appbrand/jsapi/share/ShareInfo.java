package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareInfo> CREATOR;
  public String ccc;
  public String ccd;
  
  static
  {
    AppMethodBeat.i(46818);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46818);
  }
  
  private ShareInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(46817);
    this.ccd = paramParcel.readString();
    this.ccc = paramParcel.readString();
    AppMethodBeat.o(46817);
  }
  
  public ShareInfo(String paramString1, String paramString2)
  {
    this.ccd = paramString1;
    this.ccc = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46816);
    paramParcel.writeString(this.ccd);
    paramParcel.writeString(this.ccc);
    AppMethodBeat.o(46816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo
 * JD-Core Version:    0.7.0.1
 */