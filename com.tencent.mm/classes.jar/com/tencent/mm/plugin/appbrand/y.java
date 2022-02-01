package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.c;
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
  private final Set<Class<? extends a>> jhH;
  private volatile d.a jhI;
  
  public y()
  {
    AppMethodBeat.i(134622);
    this.jhH = Collections.newSetFromMap(new ConcurrentHashMap());
    super.a(new d.a()
    {
      public final void a(Class<? extends a> paramAnonymousClass, a paramAnonymousa)
      {
        AppMethodBeat.i(134621);
        d.a locala = y.b(y.this);
        if (locala != null) {
          locala.a(paramAnonymousClass, paramAnonymousa);
        }
        AppMethodBeat.o(134621);
      }
      
      public final void a(Class<? extends a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(134619);
        y.a(y.this).add(paramAnonymousClass);
        d.a locala = y.b(y.this);
        if (locala != null) {
          locala.a(paramAnonymousClass, paramAnonymousc);
        }
        AppMethodBeat.o(134619);
      }
      
      public final void b(Class<? extends a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(134620);
        d.a locala = y.b(y.this);
        if (locala != null) {
          locala.b(paramAnonymousClass, paramAnonymousc);
        }
        AppMethodBeat.o(134620);
      }
    });
    AppMethodBeat.o(134622);
  }
  
  public final void a(d.a parama)
  {
    this.jhI = parama;
  }
  
  public final void unregisterAll()
  {
    AppMethodBeat.i(134623);
    Object localObject = new HashSet(this.jhH);
    this.jhH.clear();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      super.ac((Class)((Iterator)localObject).next());
    }
    AppMethodBeat.o(134623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y
 * JD-Core Version:    0.7.0.1
 */