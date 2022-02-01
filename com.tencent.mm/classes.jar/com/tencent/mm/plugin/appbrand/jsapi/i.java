package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class i
  implements h
{
  public final Set<h.f> osr;
  public final Set<h.b> oss;
  public final Set<h.d> ost;
  public final Set<h.c> osu;
  public final Set<h.a> osv;
  public final Set<Object> osw;
  public final Set<h.e> osx;
  public final Set<Object> osy;
  private boolean osz;
  
  public i()
  {
    AppMethodBeat.i(140627);
    this.osr = Collections.newSetFromMap(new ConcurrentHashMap());
    this.oss = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ost = Collections.newSetFromMap(new ConcurrentHashMap());
    this.osu = Collections.newSetFromMap(new ConcurrentHashMap());
    this.osv = Collections.newSetFromMap(new ConcurrentHashMap());
    this.osw = Collections.newSetFromMap(new ConcurrentHashMap());
    this.osx = Collections.newSetFromMap(new ConcurrentHashMap());
    this.osy = Collections.newSetFromMap(new ConcurrentHashMap());
    this.osz = true;
    AppMethodBeat.o(140627);
  }
  
  public final void a(h.b paramb)
  {
    AppMethodBeat.i(140630);
    this.oss.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(h.c paramc)
  {
    AppMethodBeat.i(140634);
    this.osu.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(h.d paramd)
  {
    AppMethodBeat.i(140632);
    this.ost.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(h.e parame)
  {
    AppMethodBeat.i(174622);
    this.osx.add(parame);
    AppMethodBeat.o(174622);
  }
  
  public final void a(h.f paramf)
  {
    AppMethodBeat.i(140628);
    this.osr.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(h.b paramb)
  {
    AppMethodBeat.i(140631);
    this.oss.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(140635);
    this.osu.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(h.d paramd)
  {
    AppMethodBeat.i(140633);
    this.ost.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void b(h.e parame)
  {
    AppMethodBeat.i(174623);
    this.osx.remove(parame);
    AppMethodBeat.o(174623);
  }
  
  public final void b(h.f paramf)
  {
    AppMethodBeat.i(140629);
    this.osr.remove(paramf);
    AppMethodBeat.o(140629);
  }
  
  public final void hX(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.osz == true) && (!paramBoolean)) {
      localIterator = this.osy.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.osz) && (paramBoolean == true))
      {
        localIterator = this.osx.iterator();
        while (localIterator.hasNext()) {
          ((h.e)localIterator.next()).QX();
        }
      }
    }
    this.osz = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i
 * JD-Core Version:    0.7.0.1
 */