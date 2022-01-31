package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;

public final class g
  implements a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(114101);
    paramObject = (f)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramObject.e(paramParcel);
    AppMethodBeat.o(114101);
  }
  
  public final boolean af(Object paramObject)
  {
    return paramObject instanceof f;
  }
  
  public final Object d(Parcel paramParcel)
  {
    AppMethodBeat.i(114102);
    f localf = (f)k.d(paramParcel.readString(), f.class);
    if (localf != null)
    {
      localf.readFromParcel(paramParcel);
      AppMethodBeat.o(114102);
      return localf;
    }
    AppMethodBeat.o(114102);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.g
 * JD-Core Version:    0.7.0.1
 */