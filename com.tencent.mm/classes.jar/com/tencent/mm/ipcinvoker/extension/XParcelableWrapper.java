package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XParcelableWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<XParcelableWrapper> CREATOR;
  public f mzr;
  
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
    if (this.mzr != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.mzr.getClass().getName());
      this.mzr.g(paramParcel);
      AppMethodBeat.o(158815);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(158815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */