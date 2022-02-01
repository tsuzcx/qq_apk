package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;

public final class d
  implements a
{
  public final void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(146414);
    paramObject = (Parcel)paramObject;
    paramObject.setDataPosition(0);
    paramParcel.writeInt(paramObject.dataSize());
    paramParcel.appendFrom(paramObject, 0, paramObject.dataSize());
    AppMethodBeat.o(146414);
  }
  
  public final boolean cJ(Object paramObject)
  {
    return paramObject instanceof Parcel;
  }
  
  public final Object f(Parcel paramParcel)
  {
    AppMethodBeat.i(146415);
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    int i = paramParcel.readInt();
    localParcel.appendFrom(paramParcel, paramParcel.dataPosition(), i);
    localParcel.setDataPosition(0);
    AppMethodBeat.o(146415);
    return localParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.d
 * JD-Core Version:    0.7.0.1
 */