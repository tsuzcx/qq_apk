package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzabe
  implements Iterator<Map.Entry<K, V>>
{
  private int pos = -1;
  private boolean zzbug;
  private Iterator<Map.Entry<K, V>> zzbuh;
  
  private zzabe(zzaay paramzzaay) {}
  
  private final Iterator<Map.Entry<K, V>> zzup()
  {
    AppMethodBeat.i(40192);
    if (this.zzbuh == null) {
      this.zzbuh = zzaay.zzc(this.zzbuf).entrySet().iterator();
    }
    Iterator localIterator = this.zzbuh;
    AppMethodBeat.o(40192);
    return localIterator;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(40190);
    if ((this.pos + 1 < zzaay.zzb(this.zzbuf).size()) || ((!zzaay.zzc(this.zzbuf).isEmpty()) && (zzup().hasNext())))
    {
      AppMethodBeat.o(40190);
      return true;
    }
    AppMethodBeat.o(40190);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(40191);
    Object localObject;
    if (!this.zzbug)
    {
      localObject = new IllegalStateException("remove() was called before next()");
      AppMethodBeat.o(40191);
      throw ((Throwable)localObject);
    }
    this.zzbug = false;
    zzaay.zza(this.zzbuf);
    if (this.pos < zzaay.zzb(this.zzbuf).size())
    {
      localObject = this.zzbuf;
      int i = this.pos;
      this.pos = (i - 1);
      zzaay.zza((zzaay)localObject, i);
      AppMethodBeat.o(40191);
      return;
    }
    zzup().remove();
    AppMethodBeat.o(40191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabe
 * JD-Core Version:    0.7.0.1
 */