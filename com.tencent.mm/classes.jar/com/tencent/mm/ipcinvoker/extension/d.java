package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;

public final class d
  implements a
{
  public final boolean X(Object paramObject)
  {
    return paramObject instanceof Parcelable;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    paramParcel.writeParcelable((Parcelable)paramObject, 0);
  }
  
  public final Object c(Parcel paramParcel)
  {
    return paramParcel.readParcelable(getClass().getClassLoader());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.d
 * JD-Core Version:    0.7.0.1
 */