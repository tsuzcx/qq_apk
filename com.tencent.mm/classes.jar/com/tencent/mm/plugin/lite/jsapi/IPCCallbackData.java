package com.tencent.mm.plugin.lite.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class IPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<IPCCallbackData> CREATOR;
  public Bundle kBP;
  public boolean tVR;
  public String tVS;
  
  static
  {
    AppMethodBeat.i(208149);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(208149);
  }
  
  public IPCCallbackData()
  {
    AppMethodBeat.i(208145);
    this.tVR = false;
    this.tVS = null;
    this.kBP = new Bundle();
    AppMethodBeat.o(208145);
  }
  
  public IPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(208146);
    this.tVR = false;
    this.tVS = null;
    this.kBP = new Bundle();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.tVR = bool;
      this.tVS = paramParcel.readString();
      this.kBP = paramParcel.readBundle();
      AppMethodBeat.o(208146);
      return;
      bool = false;
    }
  }
  
  public final JSONObject cWs()
  {
    AppMethodBeat.i(208148);
    if ((this.kBP == null) || (this.kBP.isEmpty()))
    {
      AppMethodBeat.o(208148);
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.kBP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, this.kBP.get(str));
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(208148);
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(208147);
    if (this.tVR) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.tVS);
      paramParcel.writeBundle(this.kBP);
      AppMethodBeat.o(208147);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.IPCCallbackData
 * JD-Core Version:    0.7.0.1
 */