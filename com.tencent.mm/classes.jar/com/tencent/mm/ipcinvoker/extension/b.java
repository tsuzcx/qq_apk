package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.k;

public final class b
  implements a
{
  public final boolean X(Object paramObject)
  {
    return paramObject instanceof com.tencent.mm.ipcinvoker.d.a;
  }
  
  public final void a(Object paramObject, Parcel paramParcel)
  {
    paramObject = (com.tencent.mm.ipcinvoker.d.a)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramParcel.writeBundle(paramObject.toBundle());
  }
  
  public final Object c(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    paramParcel = paramParcel.readBundle();
    localObject = (com.tencent.mm.ipcinvoker.d.a)k.e((String)localObject, com.tencent.mm.ipcinvoker.d.a.class);
    if (localObject != null)
    {
      ((com.tencent.mm.ipcinvoker.d.a)localObject).fromBundle(paramParcel);
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.b
 * JD-Core Version:    0.7.0.1
 */