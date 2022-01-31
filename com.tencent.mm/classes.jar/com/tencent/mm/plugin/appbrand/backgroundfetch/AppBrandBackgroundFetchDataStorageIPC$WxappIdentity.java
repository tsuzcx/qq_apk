package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppBrandBackgroundFetchDataStorageIPC$WxappIdentity
  implements Parcelable
{
  public static final Parcelable.Creator<WxappIdentity> CREATOR;
  public int hdX;
  public String username;
  
  static
  {
    AppMethodBeat.i(129788);
    CREATOR = new AppBrandBackgroundFetchDataStorageIPC.WxappIdentity.1();
    AppMethodBeat.o(129788);
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappIdentity() {}
  
  protected AppBrandBackgroundFetchDataStorageIPC$WxappIdentity(Parcel paramParcel)
  {
    AppMethodBeat.i(129787);
    this.username = paramParcel.readString();
    this.hdX = paramParcel.readInt();
    AppMethodBeat.o(129787);
  }
  
  public AppBrandBackgroundFetchDataStorageIPC$WxappIdentity(String paramString, int paramInt)
  {
    this.username = paramString;
    this.hdX = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(129786);
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.hdX);
    AppMethodBeat.o(129786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataStorageIPC.WxappIdentity
 * JD-Core Version:    0.7.0.1
 */