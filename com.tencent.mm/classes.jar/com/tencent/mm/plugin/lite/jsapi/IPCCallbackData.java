package com.tencent.mm.plugin.lite.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class IPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<IPCCallbackData> CREATOR;
  public boolean vkk;
  public String vkl;
  public String vkm;
  
  static
  {
    AppMethodBeat.i(212366);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(212366);
  }
  
  public IPCCallbackData()
  {
    this.vkk = false;
    this.vkl = null;
    this.vkm = null;
  }
  
  public IPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(212363);
    this.vkk = false;
    this.vkl = null;
    this.vkm = null;
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.vkk = bool;
      this.vkl = paramParcel.readString();
      this.vkm = paramParcel.readString();
      AppMethodBeat.o(212363);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject dix()
  {
    AppMethodBeat.i(212365);
    if (this.vkm == null)
    {
      AppMethodBeat.o(212365);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.vkm);
      AppMethodBeat.o(212365);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(212365);
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(212364);
    if (this.vkk) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.vkl);
      paramParcel.writeString(this.vkm);
      AppMethodBeat.o(212364);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.IPCCallbackData
 * JD-Core Version:    0.7.0.1
 */