package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.o;

public final class b
  implements a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(158790);
    paramObject = (com.tencent.mm.ipcinvoker.d.a)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramParcel.writeBundle(paramObject.toBundle());
    AppMethodBeat.o(158790);
  }
  
  public final boolean bp(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.ipcinvoker.d.a;
  }
  
  public final Object d(Parcel paramParcel)
  {
    AppMethodBeat.i(158791);
    Object localObject = paramParcel.readString();
    paramParcel = paramParcel.readBundle();
    localObject = (com.tencent.mm.ipcinvoker.d.a)o.c((String)localObject, com.tencent.mm.ipcinvoker.d.a.class);
    if (localObject != null)
    {
      ((com.tencent.mm.ipcinvoker.d.a)localObject).fromBundle(paramParcel);
      AppMethodBeat.o(158791);
      return localObject;
    }
    AppMethodBeat.o(158791);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.b
 * JD-Core Version:    0.7.0.1
 */