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

public final class ah
  extends d
{
  private final Set<Class<? extends a>> qxx;
  private volatile d.a qxy;
  
  public ah()
  {
    AppMethodBeat.i(134622);
    this.qxx = Collections.newSetFromMap(new ConcurrentHashMap());
    super.a(new d.a()
    {
      public final void a(Class<? extends a> paramAnonymousClass, a paramAnonymousa)
      {
        AppMethodBeat.i(134621);
        d.a locala = ah.b(ah.this);
        if (locala != null) {
          locala.a(paramAnonymousClass, paramAnonymousa);
        }
        AppMethodBeat.o(134621);
      }
      
      public final void a(Class<? extends a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(134619);
        ah.a(ah.this).add(paramAnonymousClass);
        d.a locala = ah.b(ah.this);
        if (locala != null) {
          locala.a(paramAnonymousClass, paramAnonymousc);
        }
        AppMethodBeat.o(134619);
      }
      
      public final void b(Class<? extends a> paramAnonymousClass, c paramAnonymousc)
      {
        AppMethodBeat.i(134620);
        d.a locala = ah.b(ah.this);
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
    this.qxy = parama;
  }
  
  public final void unregisterAll()
  {
    AppMethodBeat.i(134623);
    Object localObject = new HashSet(this.qxx);
    this.qxx.clear();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      super.ay((Class)((Iterator)localObject).next());
    }
    AppMethodBeat.o(134623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah
 * JD-Core Version:    0.7.0.1
 */