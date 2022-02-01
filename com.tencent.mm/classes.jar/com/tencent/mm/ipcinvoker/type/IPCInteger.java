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
    AppMethodBeat.i(158865);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158865);
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
    AppMethodBeat.i(158864);
    if (paramObject == this)
    {
      AppMethodBeat.o(158864);
      return true;
    }
    if ((paramObject instanceof IPCInteger))
    {
      paramObject = (IPCInteger)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(158864);
        return true;
      }
      AppMethodBeat.o(158864);
      return false;
    }
    if ((paramObject instanceof Integer))
    {
      boolean bool = paramObject.equals(Integer.valueOf(this.value));
      AppMethodBeat.o(158864);
      return bool;
    }
    AppMethodBeat.o(158864);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158863);
    String str = Integer.toString(this.value);
    AppMethodBeat.o(158863);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158862);
    paramParcel.writeInt(this.value);
    AppMethodBeat.o(158862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCInteger
 * JD-Core Version:    0.7.0.1
 */