package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.c.d.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class y
  extends d
{
  private final Set<Class<? extends a>> gRY;
  private volatile d.a gRZ;
  
  public y()
  {
    AppMethodBeat.i(141643);
    this.gRY = Collections.newSetFromMap(new ConcurrentHashMap());
    super.a(new y.1(this));
    AppMethodBeat.o(141643);
  }
  
  public final void a(d.a parama)
  {
    this.gRZ = parama;
  }
  
  public final void unregisterAll()
  {
    AppMethodBeat.i(141644);
    Object localObject = new HashSet(this.gRY);
    this.gRY.clear();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      super.F((Class)((Iterator)localObject).next());
    }
    AppMethodBeat.o(141644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y
 * JD-Core Version:    0.7.0.1
 */