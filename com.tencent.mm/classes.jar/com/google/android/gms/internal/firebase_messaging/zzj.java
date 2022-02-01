package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzj
{
  private final ConcurrentHashMap<zzk, List<Throwable>> zzh;
  private final ReferenceQueue<Throwable> zzi;
  
  zzj()
  {
    AppMethodBeat.i(4117);
    this.zzh = new ConcurrentHashMap(16, 0.75F, 10);
    this.zzi = new ReferenceQueue();
    AppMethodBeat.o(4117);
  }
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(4118);
    for (Object localObject = this.zzi.poll(); localObject != null; localObject = this.zzi.poll()) {
      this.zzh.remove(localObject);
    }
    localObject = new zzk(paramThrowable, null);
    localObject = (List)this.zzh.get(localObject);
    if (localObject != null)
    {
      AppMethodBeat.o(4118);
      return localObject;
    }
    localObject = new Vector(2);
    paramThrowable = (List)this.zzh.putIfAbsent(new zzk(paramThrowable, this.zzi), localObject);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(4118);
      return localObject;
    }
    AppMethodBeat.o(4118);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.firebase_messaging.zzj
 * JD-Core Version:    0.7.0.1
 */