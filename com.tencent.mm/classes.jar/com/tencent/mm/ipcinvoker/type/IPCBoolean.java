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
    AppMethodBeat.i(114134);
    CREATOR = new IPCBoolean.1();
    AppMethodBeat.o(114134);
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
    AppMethodBeat.i(114133);
    if (paramObject == this)
    {
      AppMethodBeat.o(114133);
      return true;
    }
    if ((paramObject instanceof IPCBoolean))
    {
      paramObject = (IPCBoolean)paramObject;
      if (this.value == paramObject.value)
      {
        AppMethodBeat.o(114133);
        return true;
      }
      AppMethodBeat.o(114133);
      return false;
    }
    if ((paramObject instanceof Boolean))
    {
      boolean bool = paramObject.equals(Boolean.valueOf(this.value));
      AppMethodBeat.o(114133);
      return bool;
    }
    AppMethodBeat.o(114133);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(114132);
    String str = Boolean.toString(this.value);
    AppMethodBeat.o(114132);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114131);
    if (this.value) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(114131);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCBoolean
 * JD-Core Version:    0.7.0.1
 */