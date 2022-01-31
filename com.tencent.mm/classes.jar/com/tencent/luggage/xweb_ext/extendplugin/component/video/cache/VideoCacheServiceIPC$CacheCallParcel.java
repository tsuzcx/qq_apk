package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class VideoCacheServiceIPC$CacheCallParcel
  implements Parcelable
{
  public static final Parcelable.Creator<CacheCallParcel> CREATOR;
  private long aPF;
  private long position;
  private String url;
  
  static
  {
    AppMethodBeat.i(139895);
    CREATOR = new VideoCacheServiceIPC.CacheCallParcel.1();
    AppMethodBeat.o(139895);
  }
  
  protected VideoCacheServiceIPC$CacheCallParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(139893);
    this.url = paramParcel.readString();
    this.position = paramParcel.readLong();
    this.aPF = paramParcel.readLong();
    AppMethodBeat.o(139893);
  }
  
  public VideoCacheServiceIPC$CacheCallParcel(String paramString, long paramLong1, long paramLong2)
  {
    this.url = paramString;
    this.position = paramLong1;
    this.aPF = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(139894);
    paramParcel.writeString(this.url);
    paramParcel.writeLong(this.position);
    paramParcel.writeLong(this.aPF);
    AppMethodBeat.o(139894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.VideoCacheServiceIPC.CacheCallParcel
 * JD-Core Version:    0.7.0.1
 */