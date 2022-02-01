package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzn
  extends WeakReference<Throwable>
{
  private final int zzahl;
  
  public zzn(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    AppMethodBeat.i(5519);
    if (paramThrowable == null)
    {
      paramThrowable = new NullPointerException("The referent cannot be null");
      AppMethodBeat.o(5519);
      throw paramThrowable;
    }
    this.zzahl = System.identityHashCode(paramThrowable);
    AppMethodBeat.o(5519);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(5520);
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
    {
      AppMethodBeat.o(5520);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(5520);
      return true;
    }
    paramObject = (zzn)paramObject;
    if ((this.zzahl == paramObject.zzahl) && (get() == paramObject.get()))
    {
      AppMethodBeat.o(5520);
      return true;
    }
    AppMethodBeat.o(5520);
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzahl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzn
 * JD-Core Version:    0.7.0.1
 */