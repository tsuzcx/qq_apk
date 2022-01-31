package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XParcelableWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<XParcelableWrapper> CREATOR;
  public f eEM;
  
  static
  {
    AppMethodBeat.i(114105);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(114105);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114104);
    if (this.eEM != null)
    {
      paramParcel.writeInt(1);
      paramParcel.writeString(this.eEM.getClass().getName());
      this.eEM.e(paramParcel);
      AppMethodBeat.o(114104);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(114104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.XParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */