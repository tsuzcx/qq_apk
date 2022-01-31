package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppBrandBackgroundFetchDataTokenStorageIPC$WxappParams
  implements Parcelable
{
  public static final Parcelable.Creator<WxappParams> CREATOR;
  public String token;
  public String username;
  
  static
  {
    AppMethodBeat.i(143080);
    CREATOR = new AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams.1();
    AppMethodBeat.o(143080);
  }
  
  public AppBrandBackgroundFetchDataTokenStorageIPC$WxappParams() {}
  
  protected AppBrandBackgroundFetchDataTokenStorageIPC$WxappParams(Parcel paramParcel)
  {
    AppMethodBeat.i(143079);
    this.username = paramParcel.readString();
    this.token = paramParcel.readString();
    AppMethodBeat.o(143079);
  }
  
  public AppBrandBackgroundFetchDataTokenStorageIPC$WxappParams(String paramString1, String paramString2)
  {
    this.username = paramString1;
    this.token = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143078);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.token);
    AppMethodBeat.o(143078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenStorageIPC.WxappParams
 * JD-Core Version:    0.7.0.1
 */