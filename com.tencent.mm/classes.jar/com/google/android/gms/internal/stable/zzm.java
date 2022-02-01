package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzm
{
  private final ConcurrentHashMap<zzn, List<Throwable>> zzahj;
  private final ReferenceQueue<Throwable> zzahk;
  
  zzm()
  {
    AppMethodBeat.i(5517);
    this.zzahj = new ConcurrentHashMap(16, 0.75F, 10);
    this.zzahk = new ReferenceQueue();
    AppMethodBeat.o(5517);
  }
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean)
  {
    AppMethodBeat.i(5518);
    for (Object localObject = this.zzahk.poll(); localObject != null; localObject = this.zzahk.poll()) {
      this.zzahj.remove(localObject);
    }
    localObject = new zzn(paramThrowable, null);
    localObject = (List)this.zzahj.get(localObject);
    if (localObject != null)
    {
      AppMethodBeat.o(5518);
      return localObject;
    }
    localObject = new Vector(2);
    paramThrowable = (List)this.zzahj.putIfAbsent(new zzn(paramThrowable, this.zzahk), localObject);
    if (paramThrowable == null)
    {
      AppMethodBeat.o(5518);
      return localObject;
    }
    AppMethodBeat.o(5518);
    return paramThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzm
 * JD-Core Version:    0.7.0.1
 */