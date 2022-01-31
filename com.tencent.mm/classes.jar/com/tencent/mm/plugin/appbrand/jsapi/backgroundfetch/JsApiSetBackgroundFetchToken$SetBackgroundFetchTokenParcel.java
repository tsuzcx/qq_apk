package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class JsApiSetBackgroundFetchToken$SetBackgroundFetchTokenParcel
  implements Parcelable
{
  public static final Parcelable.Creator<SetBackgroundFetchTokenParcel> CREATOR;
  String appId;
  String token;
  
  static
  {
    AppMethodBeat.i(143392);
    CREATOR = new JsApiSetBackgroundFetchToken.SetBackgroundFetchTokenParcel.1();
    AppMethodBeat.o(143392);
  }
  
  protected JsApiSetBackgroundFetchToken$SetBackgroundFetchTokenParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(143390);
    this.appId = paramParcel.readString();
    this.token = paramParcel.readString();
    AppMethodBeat.o(143390);
  }
  
  public JsApiSetBackgroundFetchToken$SetBackgroundFetchTokenParcel(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.token = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143391);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.token);
    AppMethodBeat.o(143391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken.SetBackgroundFetchTokenParcel
 * JD-Core Version:    0.7.0.1
 */