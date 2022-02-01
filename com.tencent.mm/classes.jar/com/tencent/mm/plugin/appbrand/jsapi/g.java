package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g
  implements f
{
  public final Set<f.f> ktO;
  public final Set<f.b> ktP;
  public final Set<f.d> ktQ;
  public final Set<f.c> ktR;
  public final Set<f.a> ktS;
  public final Set<Object> ktT;
  public final Set<f.e> ktU;
  public final Set<Object> ktV;
  private boolean ktW;
  
  public g()
  {
    AppMethodBeat.i(140627);
    this.ktO = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktP = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktQ = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktR = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktS = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktT = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktU = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktV = Collections.newSetFromMap(new ConcurrentHashMap());
    this.ktW = true;
    AppMethodBeat.o(140627);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(140630);
    this.ktP.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(140634);
    this.ktR.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(f.d paramd)
  {
    AppMethodBeat.i(140632);
    this.ktQ.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(f.e parame)
  {
    AppMethodBeat.i(174622);
    this.ktU.add(parame);
    AppMethodBeat.o(174622);
  }
  
  public final void a(f.f paramf)
  {
    AppMethodBeat.i(140628);
    this.ktO.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(140631);
    this.ktP.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(140635);
    this.ktR.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(f.d paramd)
  {
    AppMethodBeat.i(140633);
    this.ktQ.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void b(f.e parame)
  {
    AppMethodBeat.i(174623);
    this.ktU.remove(parame);
    AppMethodBeat.o(174623);
  }
  
  public final void b(f.f paramf)
  {
    AppMethodBeat.i(140629);
    this.ktO.remove(paramf);
    AppMethodBeat.o(140629);
  }
  
  public final void gk(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.ktW == true) && (!paramBoolean)) {
      localIterator = this.ktV.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.ktW) && (paramBoolean == true))
      {
        localIterator = this.ktU.iterator();
        while (localIterator.hasNext()) {
          ((f.e)localIterator.next()).Ez();
        }
      }
    }
    this.ktW = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g
 * JD-Core Version:    0.7.0.1
 */