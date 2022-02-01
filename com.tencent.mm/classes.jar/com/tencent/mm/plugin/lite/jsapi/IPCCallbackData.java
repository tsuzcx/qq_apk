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
  public boolean cqT;
  public String cqU;
  public String cqV;
  public boolean yEe;
  
  static
  {
    AppMethodBeat.i(198821);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(198821);
  }
  
  public IPCCallbackData()
  {
    this.cqT = false;
    this.yEe = false;
    this.cqU = null;
    this.cqV = null;
  }
  
  public IPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(198818);
    this.cqT = false;
    this.yEe = false;
    this.cqU = null;
    this.cqV = null;
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.cqT = bool1;
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.yEe = bool1;
      this.cqU = paramParcel.readString();
      this.cqV = paramParcel.readString();
      AppMethodBeat.o(198818);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final JSONObject ecy()
  {
    AppMethodBeat.i(198820);
    if (this.cqV == null)
    {
      AppMethodBeat.o(198820);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.cqV);
      AppMethodBeat.o(198820);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(198820);
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(198819);
    if (this.cqT)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.yEe) {
        break label62;
      }
    }
    label62:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.cqU);
      paramParcel.writeString(this.cqV);
      AppMethodBeat.o(198819);
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