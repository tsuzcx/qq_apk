package com.tencent.mm.plugin.appbrand.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandBackgroundFetchDataTokenParcel
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandBackgroundFetchDataTokenParcel> CREATOR;
  public String token;
  public String username;
  
  static
  {
    AppMethodBeat.i(143067);
    CREATOR = new AppBrandBackgroundFetchDataTokenParcel.1();
    AppMethodBeat.o(143067);
  }
  
  public AppBrandBackgroundFetchDataTokenParcel() {}
  
  protected AppBrandBackgroundFetchDataTokenParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(143065);
    this.username = paramParcel.readString();
    this.token = paramParcel.readString();
    AppMethodBeat.o(143065);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143066);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.token);
    AppMethodBeat.o(143066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.AppBrandBackgroundFetchDataTokenParcel
 * JD-Core Version:    0.7.0.1
 */