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
  Object eEI;
  
  static
  {
    AppMethodBeat.i(114108);
    CREATOR = new WrapperParcelable.1();
    AppMethodBeat.o(114108);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114107);
    if (this.eEI != null)
    {
      a locala = c.ag(this.eEI);
      if (locala != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeString(locala.getClass().getName());
        locala.a(this.eEI, paramParcel);
        AppMethodBeat.o(114107);
        return;
      }
    }
    paramParcel.writeInt(1);
    AppMethodBeat.o(114107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.event.WrapperParcelable
 * JD-Core Version:    0.7.0.1
 */