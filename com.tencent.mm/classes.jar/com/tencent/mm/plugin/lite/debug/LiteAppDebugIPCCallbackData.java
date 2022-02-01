package com.tencent.mm.plugin.lite.debug;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LiteAppDebugIPCCallbackData
  implements Parcelable
{
  public static final Parcelable.Creator<LiteAppDebugIPCCallbackData> CREATOR;
  public String cqU;
  
  static
  {
    AppMethodBeat.i(198815);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(198815);
  }
  
  public LiteAppDebugIPCCallbackData()
  {
    this.cqU = null;
  }
  
  public LiteAppDebugIPCCallbackData(Parcel paramParcel)
  {
    AppMethodBeat.i(198813);
    this.cqU = null;
    this.cqU = paramParcel.readString();
    AppMethodBeat.o(198813);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(198814);
    paramParcel.writeString(this.cqU);
    AppMethodBeat.o(198814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.debug.LiteAppDebugIPCCallbackData
 * JD-Core Version:    0.7.0.1
 */