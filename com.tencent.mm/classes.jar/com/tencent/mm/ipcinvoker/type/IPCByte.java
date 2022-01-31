package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCByte
  implements Parcelable
{
  public static final Parcelable.Creator<IPCByte> CREATOR;
  public byte value;
  
  static
  {
    AppMethodBeat.i(114139);
    CREATOR = new IPCByte.1();
    AppMethodBeat.o(114139);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114138);
    if (paramObject == this)
    {
      AppMethodBeat.o(114138);
      return true;
    }
    if ((paramObject instanceof IPCByte))
    {
      paramObject = (IPCByte)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(114138);
        return true;
      }
      AppMethodBeat.o(114138);
      return false;
    }
    if ((paramObject instanceof Byte))
    {
      boolean bool = paramObject.equals(Byte.valueOf(this.value));
      AppMethodBeat.o(114138);
      return bool;
    }
    AppMethodBeat.o(114138);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114137);
    String str = Integer.toString(this.value);
    AppMethodBeat.o(114137);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114136);
    paramParcel.writeByte(this.value);
    AppMethodBeat.o(114136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCByte
 * JD-Core Version:    0.7.0.1
 */