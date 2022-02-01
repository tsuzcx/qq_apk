package com.tencent.mm.plugin.lite.api;

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
  public boolean JZh;
  public boolean efS;
  public String efT;
  public String efU;
  
  static
  {
    AppMethodBeat.i(271475);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(271475);
  }
  
  public IPCCallbackData()
  {
    this.efS = false;
    this.JZh = false;
    this.efT = null;
    this.efU = null;
  }
  
  public IPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(271469);
    this.efS = false;
    this.JZh = false;
    this.efT = null;
    this.efU = null;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.efS = bool1;
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.JZh = bool1;
      this.efT = paramParcel.readString();
      this.efU = paramParcel.readString();
      AppMethodBeat.o(271469);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject fTV()
  {
    AppMethodBeat.i(271493);
    if (this.efU == null)
    {
      AppMethodBeat.o(271493);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.efU);
      AppMethodBeat.o(271493);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(271493);
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(271487);
    if (this.efS)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.JZh) {
        break label62;
      }
    }
    label62:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.efT);
      paramParcel.writeString(this.efU);
      AppMethodBeat.o(271487);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.api.IPCCallbackData
 * JD-Core Version:    0.7.0.1
 */