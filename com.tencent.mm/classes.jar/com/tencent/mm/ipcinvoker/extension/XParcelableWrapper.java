package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XParcelableWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<XParcelableWrapper> CREATOR;
  public f gev;
  
  static
  {
    AppMethodBeat.i(158816);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(158816);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(158815);
    if (this.gev != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.gev.getClass().getName());
      this.gev.d(paramParcel);
      AppMethodBeat.o(158815);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(158815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */