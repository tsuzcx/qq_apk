package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g
  implements f
{
  public final Set<f.f> jvM;
  public final Set<f.b> jvN;
  public final Set<f.d> jvO;
  public final Set<f.c> jvP;
  public final Set<f.a> jvQ;
  public final Set<Object> jvR;
  public final Set<f.e> jvS;
  public final Set<Object> jvT;
  private boolean jvU;
  
  public g()
  {
    AppMethodBeat.i(140627);
    this.jvM = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvN = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvO = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvP = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvQ = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvR = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvS = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvT = Collections.newSetFromMap(new ConcurrentHashMap());
    this.jvU = true;
    AppMethodBeat.o(140627);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(140630);
    this.jvN.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(140634);
    this.jvP.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(f.d paramd)
  {
    AppMethodBeat.i(140632);
    this.jvO.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(f.e parame)
  {
    AppMethodBeat.i(174622);
    this.jvS.add(parame);
    AppMethodBeat.o(174622);
  }
  
  public final void a(f.f paramf)
  {
    AppMethodBeat.i(140628);
    this.jvM.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(140631);
    this.jvN.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(140635);
    this.jvP.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(f.d paramd)
  {
    AppMethodBeat.i(140633);
    this.jvO.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void b(f.e parame)
  {
    AppMethodBeat.i(174623);
    this.jvS.remove(parame);
    AppMethodBeat.o(174623);
  }
  
  public final void b(f.f paramf)
  {
    AppMethodBeat.i(140629);
    this.jvM.remove(paramf);
    AppMethodBeat.o(140629);
  }
  
  public final void fL(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.jvU == true) && (!paramBoolean)) {
      localIterator = this.jvT.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.jvU) && (paramBoolean == true))
      {
        localIterator = this.jvS.iterator();
        while (localIterator.hasNext()) {
          ((f.e)localIterator.next()).Dv();
        }
      }
    }
    this.jvU = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g
 * JD-Core Version:    0.7.0.1
 */