package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCInteger
  implements Parcelable
{
  public static final Parcelable.Creator<IPCInteger> CREATOR;
  public int value;
  
  static
  {
    AppMethodBeat.i(114154);
    CREATOR = new IPCInteger.1();
    AppMethodBeat.o(114154);
  }
  
  public IPCInteger() {}
  
  public IPCInteger(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114153);
    if (paramObject == this)
    {
      AppMethodBeat.o(114153);
      return true;
    }
    if ((paramObject instanceof IPCInteger))
    {
      paramObject = (IPCInteger)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(114153);
        return true;
      }
      AppMethodBeat.o(114153);
      return false;
    }
    if ((paramObject instanceof Integer))
    {
      boolean bool = paramObject.equals(Integer.valueOf(this.value));
      AppMethodBeat.o(114153);
      return bool;
    }
    AppMethodBeat.o(114153);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114152);
    String str = Integer.toString(this.value);
    AppMethodBeat.o(114152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114151);
    paramParcel.writeInt(this.value);
    AppMethodBeat.o(114151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCInteger
 * JD-Core Version:    0.7.0.1
 */