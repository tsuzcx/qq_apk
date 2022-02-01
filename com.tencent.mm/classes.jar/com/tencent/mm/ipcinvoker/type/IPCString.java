package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCString
  implements Parcelable
{
  public static final Parcelable.Creator<IPCString> CREATOR;
  public String value;
  
  static
  {
    AppMethodBeat.i(158874);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158874);
  }
  
  public IPCString() {}
  
  public IPCString(String paramString)
  {
    this.value = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(158873);
    if (paramObject == this)
    {
      AppMethodBeat.o(158873);
      return true;
    }
    if ((paramObject instanceof IPCString))
    {
      paramObject = (IPCString)paramObject;
      if ((this.value == paramObject.value) || ((this.value != null) && (this.value.equals(paramObject.value))))
      {
        AppMethodBeat.o(158873);
        return true;
      }
      AppMethodBeat.o(158873);
      return false;
    }
    if ((paramObject instanceof String))
    {
      boolean bool = paramObject.equals(this.value);
      AppMethodBeat.o(158873);
      return bool;
    }
    AppMethodBeat.o(158873);
    return false;
  }
  
  public String toString()
  {
    return this.value;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158872);
    paramParcel.writeString(this.value);
    AppMethodBeat.o(158872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCString
 * JD-Core Version:    0.7.0.1
 */