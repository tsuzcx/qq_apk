package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<WrapperParcelable> CREATOR;
  Object fZL;
  
  static
  {
    AppMethodBeat.i(158819);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158819);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158818);
    if (this.fZL != null)
    {
      a locala = c.bi(this.fZL);
      if (locala != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeString(locala.getClass().getName());
        locala.a(this.fZL, paramParcel);
        AppMethodBeat.o(158818);
        return;
      }
    }
    paramParcel.writeInt(1);
    AppMethodBeat.o(158818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.event.WrapperParcelable
 * JD-Core Version:    0.7.0.1
 */