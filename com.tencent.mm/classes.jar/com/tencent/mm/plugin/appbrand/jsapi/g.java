package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g
  implements f
{
  public final Set<f.f> jWi;
  public final Set<f.b> jWj;
  public final Set<f.d> jWk;
  public final Set<f.c> jWl;
  public final Set<f.a> jWm;
  public final Set<Object> jWn;
  public final Set<f.e> jWo;
  public final Set<Object> jWp;
  private boolean jWq;
  
  public g()
  {
    AppMethodBeat.i(140627);
    this.jWi = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWj = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWk = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWl = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWm = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWn = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWo = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWp = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jWq = true;
    AppMethodBeat.o(140627);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(140630);
    this.jWj.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(140634);
    this.jWl.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(f.d paramd)
  {
    AppMethodBeat.i(140632);
    this.jWk.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(f.e parame)
  {
    AppMethodBeat.i(174622);
    this.jWo.add(parame);
    AppMethodBeat.o(174622);
  }
  
  public final void a(f.f paramf)
  {
    AppMethodBeat.i(140628);
    this.jWi.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(140631);
    this.jWj.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(140635);
    this.jWl.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(f.d paramd)
  {
    AppMethodBeat.i(140633);
    this.jWk.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void b(f.e parame)
  {
    AppMethodBeat.i(174623);
    this.jWo.remove(parame);
    AppMethodBeat.o(174623);
  }
  
  public final void b(f.f paramf)
  {
    AppMethodBeat.i(140629);
    this.jWi.remove(paramf);
    AppMethodBeat.o(140629);
  }
  
  public final void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.jWq == true) && (!paramBoolean)) {
      localIterator = this.jWp.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.jWq) && (paramBoolean == true))
      {
        localIterator = this.jWo.iterator();
        while (localIterator.hasNext()) {
          ((f.e)localIterator.next()).CY();
        }
      }
    }
    this.jWq = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g
 * JD-Core Version:    0.7.0.1
 */