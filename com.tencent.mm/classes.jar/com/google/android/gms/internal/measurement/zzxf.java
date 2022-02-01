package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzxf
{
  private final ConcurrentHashMap<zzxg, List<Throwable>> zzboa;
  private final ReferenceQueue<Throwable> zzbob;
  
  zzxf()
  {
    AppMethodBeat.i(40329);
    this.zzboa = new ConcurrentHashMap(16, 0.75F, 10);
    this.zzbob = new ReferenceQueue();
    AppMethodBeat.o(40329);
  }
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(40330);
    for (Reference localReference = this.zzbob.poll(); localReference != null; localReference = this.zzbob.poll()) {
      this.zzboa.remove(localReference);
    }
    paramThrowable = new zzxg(paramThrowable, null);
    paramThrowable = (List)this.zzboa.get(paramThrowable);
    AppMethodBeat.o(40330);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxf
 * JD-Core Version:    0.7.0.1
 */