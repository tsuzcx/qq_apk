package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.a;

public final class e
  implements a
{
  public final boolean X(Object paramObject)
  {
    return paramObject instanceof Parcel;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    paramObject = (Parcel)paramObject;
    paramObject.setDataPosition(0);
    paramParcel.writeInt(paramObject.dataSize());
    paramParcel.appendFrom(paramObject, 0, paramObject.dataSize());
  }
  
  public final Object c(Parcel paramParcel)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    int i = paramParcel.readInt();
    localParcel.appendFrom(paramParcel, paramParcel.dataPosition(), i);
    localParcel.setDataPosition(0);
    return localParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.e
 * JD-Core Version:    0.7.0.1
 */