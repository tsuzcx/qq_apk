package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCBoolean
  implements Parcelable
{
  public static final Parcelable.Creator<IPCBoolean> CREATOR;
  public boolean value;
  
  static
  {
    AppMethodBeat.i(158845);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158845);
  }
  
  public IPCBoolean() {}
  
  public IPCBoolean(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158844);
    if (paramObject == this)
    {
      AppMethodBeat.o(158844);
      return true;
    }
    if ((paramObject instanceof IPCBoolean))
    {
      paramObject = (IPCBoolean)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(158844);
        return true;
      }
      AppMethodBeat.o(158844);
      return false;
    }
    if ((paramObject instanceof Boolean))
    {
      boolean bool = paramObject.equals(Boolean.valueOf(this.value));
      AppMethodBeat.o(158844);
      return bool;
    }
    AppMethodBeat.o(158844);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158843);
    String str = Boolean.toString(this.value);
    AppMethodBeat.o(158843);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158842);
    if (this.value) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(158842);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCBoolean
 * JD-Core Version:    0.7.0.1
 */