package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class j
  implements i
{
  public final Set<i.f> rwl;
  public final Set<i.b> rwm;
  public final Set<i.d> rwn;
  public final Set<i.c> rwo;
  public final Set<i.a> rwp;
  public final Set<Object> rwq;
  public final Set<i.e> rwr;
  public final Set<Object> rws;
  private boolean rwt;
  public final AtomicBoolean rwu;
  
  public j()
  {
    AppMethodBeat.i(140627);
    this.rwl = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwm = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwn = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwo = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwp = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwq = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwr = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rws = Collections.newSetFromMap(new ConcurrentHashMap());
    this.rwt = true;
    this.rwu = new AtomicBoolean(false);
    AppMethodBeat.o(140627);
  }
  
  public final void a(i.b paramb)
  {
    AppMethodBeat.i(140630);
    this.rwm.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(140634);
    this.rwo.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(i.d paramd)
  {
    AppMethodBeat.i(140632);
    this.rwn.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(i.f paramf)
  {
    AppMethodBeat.i(140628);
    if (paramf == null)
    {
      AppMethodBeat.o(140628);
      return;
    }
    if (this.rwu.get())
    {
      paramf.onReady();
      AppMethodBeat.o(140628);
      return;
    }
    this.rwl.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(i.b paramb)
  {
    AppMethodBeat.i(140631);
    this.rwm.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(i.c paramc)
  {
    AppMethodBeat.i(140635);
    this.rwo.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(i.d paramd)
  {
    AppMethodBeat.i(140633);
    this.rwn.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.rwt == true) && (!paramBoolean)) {
      localIterator = this.rws.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.rwt) && (paramBoolean == true))
      {
        localIterator = this.rwr.iterator();
        while (localIterator.hasNext()) {
          ((i.e)localIterator.next()).arj();
        }
      }
    }
    this.rwt = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j
 * JD-Core Version:    0.7.0.1
 */