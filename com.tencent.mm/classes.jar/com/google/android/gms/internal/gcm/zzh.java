package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzh
{
  private final ConcurrentHashMap<zzi, List<Throwable>> zzdf;
  private final ReferenceQueue<Throwable> zzdg;
  
  zzh()
  {
    AppMethodBeat.i(2580);
    this.zzdf = new ConcurrentHashMap(16, 0.75F, 10);
    this.zzdg = new ReferenceQueue();
    AppMethodBeat.o(2580);
  }
  
  public final List<Throwable> zzd(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(2581);
    for (Object localObject = this.zzdg.poll(); localObject != null; localObject = this.zzdg.poll()) {
      this.zzdf.remove(localObject);
    }
    localObject = new zzi(paramThrowable, null);
    localObject = (List)this.zzdf.get(localObject);
    if (localObject != null)
    {
      AppMethodBeat.o(2581);
      return localObject;
    }
    localObject = new Vector(2);
    paramThrowable = (List)this.zzdf.putIfAbsent(new zzi(paramThrowable, this.zzdg), localObject);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(2581);
      return localObject;
    }
    AppMethodBeat.o(2581);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zzh
 * JD-Core Version:    0.7.0.1
 */