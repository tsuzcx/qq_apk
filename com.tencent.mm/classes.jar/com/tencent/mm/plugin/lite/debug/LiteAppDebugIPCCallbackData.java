package com.tencent.mm.plugin.lite.debug;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LiteAppDebugIPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<LiteAppDebugIPCCallbackData> CREATOR;
  public String efT;
  
  static
  {
    AppMethodBeat.i(271337);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(271337);
  }
  
  public LiteAppDebugIPCCallbackData()
  {
    this.efT = null;
  }
  
  public LiteAppDebugIPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(271334);
    this.efT = null;
    this.efT = paramParcel.readString();
    AppMethodBeat.o(271334);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(271343);
    paramParcel.writeString(this.efT);
    AppMethodBeat.o(271343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.debug.LiteAppDebugIPCCallbackData
 * JD-Core Version:    0.7.0.1
 */