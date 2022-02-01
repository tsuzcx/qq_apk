package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCFloat
  implements Parcelable
{
  public static final Parcelable.Creator<IPCFloat> CREATOR;
  public float value;
  
  static
  {
    AppMethodBeat.i(158860);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158860);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158859);
    if (paramObject == this)
    {
      AppMethodBeat.o(158859);
      return true;
    }
    if ((paramObject instanceof IPCFloat))
    {
      paramObject = (IPCFloat)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(158859);
        return true;
      }
      AppMethodBeat.o(158859);
      return false;
    }
    if ((paramObject instanceof Float))
    {
      boolean bool = paramObject.equals(Float.valueOf(this.value));
      AppMethodBeat.o(158859);
      return bool;
    }
    AppMethodBeat.o(158859);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158858);
    String str = Float.toString(this.value);
    AppMethodBeat.o(158858);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158857);
    paramParcel.writeFloat(this.value);
    AppMethodBeat.o(158857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCFloat
 * JD-Core Version:    0.7.0.1
 */