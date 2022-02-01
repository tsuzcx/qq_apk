package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(158797);
    paramParcel.writeParcelable((Parcelable)paramObject, 0);
    AppMethodBeat.o(158797);
  }
  
  public final boolean bh(Object paramObject)
  {
    return paramObject instanceof Parcelable;
  }
  
  public final Object c(Parcel paramParcel)
  {
    AppMethodBeat.i(158798);
    paramParcel = paramParcel.readParcelable(getClass().getClassLoader());
    AppMethodBeat.o(158798);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.d
 * JD-Core Version:    0.7.0.1
 */