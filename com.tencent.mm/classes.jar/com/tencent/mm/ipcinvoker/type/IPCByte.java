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
    AppMethodBeat.i(158850);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158850);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158849);
    if (paramObject == this)
    {
      AppMethodBeat.o(158849);
      return true;
    }
    if ((paramObject instanceof IPCByte))
    {
      paramObject = (IPCByte)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(158849);
        return true;
      }
      AppMethodBeat.o(158849);
      return false;
    }
    if ((paramObject instanceof Byte))
    {
      boolean bool = paramObject.equals(Byte.valueOf(this.value));
      AppMethodBeat.o(158849);
      return bool;
    }
    AppMethodBeat.o(158849);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158848);
    String str = Integer.toString(this.value);
    AppMethodBeat.o(158848);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158847);
    paramParcel.writeByte(this.value);
    AppMethodBeat.o(158847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCByte
 * JD-Core Version:    0.7.0.1
 */