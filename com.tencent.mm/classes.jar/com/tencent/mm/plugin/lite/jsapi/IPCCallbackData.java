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
  public boolean uYv;
  public String uYw;
  public String uYx;
  
  static
  {
    AppMethodBeat.i(214613);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(214613);
  }
  
  public IPCCallbackData()
  {
    this.uYv = false;
    this.uYw = null;
    this.uYx = null;
  }
  
  public IPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(214610);
    this.uYv = false;
    this.uYw = null;
    this.uYx = null;
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.uYv = bool;
      this.uYw = paramParcel.readString();
      this.uYx = paramParcel.readString();
      AppMethodBeat.o(214610);
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject dfD()
  {
    AppMethodBeat.i(214612);
    if (this.uYx == null)
    {
      AppMethodBeat.o(214612);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.uYx);
      AppMethodBeat.o(214612);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(214612);
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(214611);
    if (this.uYv) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.uYw);
      paramParcel.writeString(this.uYx);
      AppMethodBeat.o(214611);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.IPCCallbackData
 * JD-Core Version:    0.7.0.1
 */