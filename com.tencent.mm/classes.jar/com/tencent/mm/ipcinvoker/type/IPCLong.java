package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCLong
  implements Parcelable
{
  public static final Parcelable.Creator<IPCLong> CREATOR;
  public long value;
  
  static
  {
    AppMethodBeat.i(114159);
    CREATOR = new IPCLong.1();
    AppMethodBeat.o(114159);
  }
  
  public IPCLong() {}
  
  public IPCLong(long paramLong)
  {
    this.value = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114158);
    if (paramObject == this)
    {
      AppMethodBeat.o(114158);
      return true;
    }
    if ((paramObject instanceof IPCLong))
    {
      paramObject = (IPCLong)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(114158);
        return true;
      }
      AppMethodBeat.o(114158);
      return false;
    }
    if ((paramObject instanceof Long))
    {
      boolean bool = paramObject.equals(Long.valueOf(this.value));
      AppMethodBeat.o(114158);
      return bool;
    }
    AppMethodBeat.o(114158);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114157);
    String str = Long.toString(this.value);
    AppMethodBeat.o(114157);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114156);
    paramParcel.writeLong(this.value);
    AppMethodBeat.o(114156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCLong
 * JD-Core Version:    0.7.0.1
 */