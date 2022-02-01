package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.r;

public final class g
  implements a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(158812);
    paramObject = (f)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramObject.e(paramParcel);
    AppMethodBeat.o(158812);
  }
  
  public final boolean bp(Object paramObject)
  {
    return paramObject instanceof f;
  }
  
  public final Object d(Parcel paramParcel)
  {
    AppMethodBeat.i(158813);
    f localf = (f)r.c(paramParcel.readString(), f.class);
    if (localf != null)
    {
      localf.readFromParcel(paramParcel);
      AppMethodBeat.o(158813);
      return localf;
    }
    AppMethodBeat.o(158813);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.g
 * JD-Core Version:    0.7.0.1
 */