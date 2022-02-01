package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class j
  implements i
{
  public final Set<i.f> lxE;
  public final Set<i.b> lxF;
  public final Set<i.d> lxG;
  public final Set<i.c> lxH;
  public final Set<i.a> lxI;
  public final Set<Object> lxJ;
  public final Set<i.e> lxK;
  public final Set<Object> lxL;
  private boolean lxM;
  
  public j()
  {
    AppMethodBeat.i(140627);
    this.lxE = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxF = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxG = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxH = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxI = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxJ = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxK = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxL = Collections.newSetFromMap(new ConcurrentHashMap());
    this.lxM = true;
    AppMethodBeat.o(140627);
  }
  
  public final void a(i.b paramb)
  {
    AppMethodBeat.i(140630);
    this.lxF.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(i.c paramc)
  {
    AppMethodBeat.i(140634);
    this.lxH.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(i.d paramd)
  {
    AppMethodBeat.i(140632);
    this.lxG.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(i.e parame)
  {
    AppMethodBeat.i(174622);
    this.lxK.add(parame);
    AppMethodBeat.o(174622);
  }
  
  public final void a(i.f paramf)
  {
    AppMethodBeat.i(140628);
    this.lxE.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(i.b paramb)
  {
    AppMethodBeat.i(140631);
    this.lxF.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(i.c paramc)
  {
    AppMethodBeat.i(140635);
    this.lxH.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(i.d paramd)
  {
    AppMethodBeat.i(140633);
    this.lxG.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void b(i.e parame)
  {
    AppMethodBeat.i(174623);
    this.lxK.remove(parame);
    AppMethodBeat.o(174623);
  }
  
  public final void b(i.f paramf)
  {
    AppMethodBeat.i(140629);
    this.lxE.remove(paramf);
    AppMethodBeat.o(140629);
  }
  
  public final void hh(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.lxM == true) && (!paramBoolean)) {
      localIterator = this.lxL.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.lxM) && (paramBoolean == true))
      {
        localIterator = this.lxK.iterator();
        while (localIterator.hasNext()) {
          ((i.e)localIterator.next()).NZ();
        }
      }
    }
    this.lxM = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j
 * JD-Core Version:    0.7.0.1
 */