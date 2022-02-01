package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzxg
  extends WeakReference<Throwable>
{
  private final int zzboc;
  
  public zzxg(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, null);
    AppMethodBeat.i(40331);
    if (paramThrowable == null)
    {
      paramThrowable = new NullPointerException("The referent cannot be null");
      AppMethodBeat.o(40331);
      throw paramThrowable;
    }
    this.zzboc = System.identityHashCode(paramThrowable);
    AppMethodBeat.o(40331);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40332);
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
    {
      AppMethodBeat.o(40332);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(40332);
      return true;
    }
    paramObject = (zzxg)paramObject;
    if ((this.zzboc == paramObject.zzboc) && (get() == paramObject.get()))
    {
      AppMethodBeat.o(40332);
      return true;
    }
    AppMethodBeat.o(40332);
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzboc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxg
 * JD-Core Version:    0.7.0.1
 */