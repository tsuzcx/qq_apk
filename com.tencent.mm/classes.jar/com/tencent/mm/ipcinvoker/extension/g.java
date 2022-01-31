package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.k;

public final class g
  implements a
{
  public final boolean X(Object paramObject)
  {
    return paramObject instanceof f;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    paramObject = (f)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramObject.d(paramParcel);
  }
  
  public final Object c(Parcel paramParcel)
  {
    f localf = (f)k.e(paramParcel.readString(), f.class);
    if (localf != null)
    {
      localf.readFromParcel(paramParcel);
      return localf;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.g
 * JD-Core Version:    0.7.0.1
 */