package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCDouble
  implements Parcelable
{
  public static final Parcelable.Creator<IPCDouble> CREATOR;
  public double value;
  
  static
  {
    AppMethodBeat.i(114144);
    CREATOR = new IPCDouble.1();
    AppMethodBeat.o(114144);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(114143);
    if (paramObject == this)
    {
      AppMethodBeat.o(114143);
      return true;
    }
    if ((paramObject instanceof IPCDouble))
    {
      paramObject = (IPCDouble)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(114143);
        return true;
      }
      AppMethodBeat.o(114143);
      return false;
    }
    if ((paramObject instanceof Double))
    {
      boolean bool = paramObject.equals(Double.valueOf(this.value));
      AppMethodBeat.o(114143);
      return bool;
    }
    AppMethodBeat.o(114143);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114142);
    String str = Double.toString(this.value);
    AppMethodBeat.o(114142);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114141);
    paramParcel.writeDouble(this.value);
    AppMethodBeat.o(114141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCDouble
 * JD-Core Version:    0.7.0.1
 */