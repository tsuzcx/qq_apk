package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzk
  extends WeakReference<Throwable>
{
  private final int zzj;
  
  public zzk(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue)
  {
    super(paramThrowable, paramReferenceQueue);
    AppMethodBeat.i(108683);
    if (paramThrowable == null)
    {
      paramThrowable = new NullPointerException("The referent cannot be null");
      AppMethodBeat.o(108683);
      throw paramThrowable;
    }
    this.zzj = System.identityHashCode(paramThrowable);
    AppMethodBeat.o(108683);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108684);
    if ((paramObject == null) || (paramObject.getClass() != getClass()))
    {
      AppMethodBeat.o(108684);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(108684);
      return true;
    }
    paramObject = (zzk)paramObject;
    if ((this.zzj == paramObject.zzj) && (get() == paramObject.get()))
    {
      AppMethodBeat.o(108684);
      return true;
    }
    AppMethodBeat.o(108684);
    return false;
  }
  
  public final int hashCode()
  {
    return this.zzj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzk
 * JD-Core Version:    0.7.0.1
 */