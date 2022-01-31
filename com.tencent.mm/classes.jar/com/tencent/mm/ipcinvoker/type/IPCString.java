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
    AppMethodBeat.i(114163);
    CREATOR = new IPCString.1();
    AppMethodBeat.o(114163);
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
    AppMethodBeat.i(114162);
    if (paramObject == this)
    {
      AppMethodBeat.o(114162);
      return true;
    }
    if ((paramObject instanceof IPCString))
    {
      paramObject = (IPCString)paramObject;
      if ((this.value == paramObject.value) || ((this.value != null) && (this.value.equals(paramObject.value))))
      {
        AppMethodBeat.o(114162);
        return true;
      }
      AppMethodBeat.o(114162);
      return false;
    }
    if ((paramObject instanceof String))
    {
      boolean bool = paramObject.equals(this.value);
      AppMethodBeat.o(114162);
      return bool;
    }
    AppMethodBeat.o(114162);
    return false;
  }
  
  public String toString()
  {
    return this.value;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114161);
    paramParcel.writeString(this.value);
    AppMethodBeat.o(114161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.type.IPCString
 * JD-Core Version:    0.7.0.1
 */