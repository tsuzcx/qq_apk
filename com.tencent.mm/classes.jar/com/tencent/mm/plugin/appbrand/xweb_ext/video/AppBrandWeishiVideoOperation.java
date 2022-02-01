package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandWeishiVideoOperation
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandWeishiVideoOperation> CREATOR;
  public long boX;
  public long length;
  public String url;
  
  static
  {
    AppMethodBeat.i(50037);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(50037);
  }
  
  protected AppBrandWeishiVideoOperation(Parcel paramParcel)
  {
    AppMethodBeat.i(50035);
    this.url = paramParcel.readString();
    this.boX = paramParcel.readLong();
    this.length = paramParcel.readLong();
    AppMethodBeat.o(50035);
  }
  
  public AppBrandWeishiVideoOperation(String paramString, long paramLong)
  {
    this.url = paramString;
    this.boX = 0L;
    this.length = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50036);
    paramParcel.writeString(this.url);
    paramParcel.writeLong(this.boX);
    paramParcel.writeLong(this.length);
    AppMethodBeat.o(50036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation
 * JD-Core Version:    0.7.0.1
 */