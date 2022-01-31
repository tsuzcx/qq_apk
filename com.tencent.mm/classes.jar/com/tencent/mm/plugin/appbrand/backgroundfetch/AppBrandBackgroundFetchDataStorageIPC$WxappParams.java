package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppBrandBackgroundFetchDataStorageIPC$WxappParams
  implements Parcelable
{
  public static final Parcelable.Creator<WxappParams> CREATOR;
  public String data;
  public int hdX;
  public String path;
  public String query;
  public int scene;
  public long time;
  public String username;
  
  static
  {
    AppMethodBeat.i(129796);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(129796);
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappParams() {}
  
  protected AppBrandBackgroundFetchDataStorageIPC$WxappParams(Parcel paramParcel)
  {
    AppMethodBeat.i(129795);
    this.username = paramParcel.readString();
    this.hdX = paramParcel.readInt();
    this.data = paramParcel.readString();
    this.path = paramParcel.readString();
    this.query = paramParcel.readString();
    this.scene = paramParcel.readInt();
    this.time = paramParcel.readLong();
    AppMethodBeat.o(129795);
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappParams(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, long paramLong)
  {
    this.username = paramString1;
    this.hdX = paramInt1;
    this.data = paramString2;
    this.path = paramString3;
    this.query = paramString4;
    this.scene = paramInt2;
    this.time = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(129794);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.hdX);
    paramParcel.writeString(this.data);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.query);
    paramParcel.writeInt(this.scene);
    paramParcel.writeLong(this.time);
    AppMethodBeat.o(129794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappParams
 * JD-Core Version:    0.7.0.1
 */