package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareInfo> CREATOR;
  public String bCY;
  public String bCZ;
  
  static
  {
    AppMethodBeat.i(131482);
    CREATOR = new ShareInfo.1();
    AppMethodBeat.o(131482);
  }
  
  private ShareInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(131481);
    this.bCZ = paramParcel.readString();
    this.bCY = paramParcel.readString();
    AppMethodBeat.o(131481);
  }
  
  public ShareInfo(String paramString1, String paramString2)
  {
    this.bCZ = paramString1;
    this.bCY = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131480);
    paramParcel.writeString(this.bCZ);
    paramParcel.writeString(this.bCY);
    AppMethodBeat.o(131480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo
 * JD-Core Version:    0.7.0.1
 */