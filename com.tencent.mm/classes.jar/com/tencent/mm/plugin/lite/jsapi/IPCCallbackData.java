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
  public boolean EfR;
  public boolean coH;
  public String coI;
  public String coJ;
  
  static
  {
    AppMethodBeat.i(233949);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(233949);
  }
  
  public IPCCallbackData()
  {
    this.coH = false;
    this.EfR = false;
    this.coI = null;
    this.coJ = null;
  }
  
  public IPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(233942);
    this.coH = false;
    this.EfR = false;
    this.coI = null;
    this.coJ = null;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.coH = bool1;
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.EfR = bool1;
      this.coI = paramParcel.readString();
      this.coJ = paramParcel.readString();
      AppMethodBeat.o(233942);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject eLB()
  {
    AppMethodBeat.i(233947);
    if (this.coJ == null)
    {
      AppMethodBeat.o(233947);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.coJ);
      AppMethodBeat.o(233947);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(233947);
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(233945);
    if (this.coH)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.EfR) {
        break label62;
      }
    }
    label62:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.coI);
      paramParcel.writeString(this.coJ);
      AppMethodBeat.o(233945);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.IPCCallbackData
 * JD-Core Version:    0.7.0.1
 */