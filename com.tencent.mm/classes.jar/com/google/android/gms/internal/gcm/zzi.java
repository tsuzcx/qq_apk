package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzi
  extends WeakReference<Throwable>
{
  private final int zzdh;
  
  public zzi(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    AppMethodBeat.i(2582);
    if (paramThrowable == null)
    {
      paramThrowable = new NullPointerException("The referent cannot be null");
      AppMethodBeat.o(2582);
      throw paramThrowable;
    }
    this.zzdh = System.identityHashCode(paramThrowable);
    AppMethodBeat.o(2582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(2583);
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
    {
      AppMethodBeat.o(2583);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(2583);
      return true;
    }
    paramObject = (zzi)paramObject;
    if ((this.zzdh == paramObject.zzdh) && (get() == paramObject.get()))
    {
      AppMethodBeat.o(2583);
      return true;
    }
    AppMethodBeat.o(2583);
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzdh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzi
 * JD-Core Version:    0.7.0.1
 */