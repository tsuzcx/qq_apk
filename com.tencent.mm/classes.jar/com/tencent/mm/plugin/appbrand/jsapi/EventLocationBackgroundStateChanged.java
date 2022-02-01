package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EventLocationBackgroundStateChanged
  implements Parcelable
{
  public static final Parcelable.Creator<EventLocationBackgroundStateChanged> CREATOR;
  public boolean nSz;
  
  static
  {
    AppMethodBeat.i(134873);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134873);
  }
  
  protected EventLocationBackgroundStateChanged(Parcel paramParcel)
  {
    AppMethodBeat.i(134871);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.nSz = bool;
      AppMethodBeat.o(134871);
      return;
    }
  }
  
  public EventLocationBackgroundStateChanged(boolean paramBoolean)
  {
    this.nSz = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134872);
    if (this.nSz) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(134872);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.EventLocationBackgroundStateChanged
 * JD-Core Version:    0.7.0.1
 */