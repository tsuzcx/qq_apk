package com.tencent.mm.plugin.lite.debug;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LiteAppDebugIPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<LiteAppDebugIPCCallbackData> CREATOR;
  public String coI;
  
  static
  {
    AppMethodBeat.i(234070);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(234070);
  }
  
  public LiteAppDebugIPCCallbackData()
  {
    this.coI = null;
  }
  
  public LiteAppDebugIPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(234066);
    this.coI = null;
    this.coI = paramParcel.readString();
    AppMethodBeat.o(234066);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(234068);
    paramParcel.writeString(this.coI);
    AppMethodBeat.o(234068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.debug.LiteAppDebugIPCCallbackData
 * JD-Core Version:    0.7.0.1
 */