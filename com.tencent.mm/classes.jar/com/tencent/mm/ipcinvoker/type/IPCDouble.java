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
    AppMethodBeat.i(158855);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158855);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158854);
    if (paramObject == this)
    {
      AppMethodBeat.o(158854);
      return true;
    }
    if ((paramObject instanceof IPCDouble))
    {
      paramObject = (IPCDouble)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(158854);
        return true;
      }
      AppMethodBeat.o(158854);
      return false;
    }
    if ((paramObject instanceof Double))
    {
      boolean bool = paramObject.equals(Double.valueOf(this.value));
      AppMethodBeat.o(158854);
      return bool;
    }
    AppMethodBeat.o(158854);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158853);
    String str = Double.toString(this.value);
    AppMethodBeat.o(158853);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158852);
    paramParcel.writeDouble(this.value);
    AppMethodBeat.o(158852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCDouble
 * JD-Core Version:    0.7.0.1
 */