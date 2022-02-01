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
    AppMethodBeat.i(158870);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158870);
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
    AppMethodBeat.i(158869);
    if (paramObject == this)
    {
      AppMethodBeat.o(158869);
      return true;
    }
    if ((paramObject instanceof IPCLong))
    {
      paramObject = (IPCLong)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(158869);
        return true;
      }
      AppMethodBeat.o(158869);
      return false;
    }
    if ((paramObject instanceof Long))
    {
      boolean bool = paramObject.equals(Long.valueOf(this.value));
      AppMethodBeat.o(158869);
      return bool;
    }
    AppMethodBeat.o(158869);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158868);
    String str = Long.toString(this.value);
    AppMethodBeat.o(158868);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158867);
    paramParcel.writeLong(this.value);
    AppMethodBeat.o(158867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCLong
 * JD-Core Version:    0.7.0.1
 */