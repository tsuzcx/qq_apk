package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCVoid
  implements Parcelable
{
  public static final Parcelable.Creator<IPCVoid> CREATOR;
  public static final IPCVoid eER;
  
  static
  {
    AppMethodBeat.i(114165);
    eER = new IPCVoid();
    CREATOR = new IPCVoid.1();
    AppMethodBeat.o(114165);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCVoid
 * JD-Core Version:    0.7.0.1
 */