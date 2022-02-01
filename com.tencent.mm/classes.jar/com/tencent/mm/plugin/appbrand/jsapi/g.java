package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g
  implements f
{
  public final Set<f.b> kqA;
  public final Set<f.d> kqB;
  public final Set<f.c> kqC;
  public final Set<f.a> kqD;
  public final Set<Object> kqE;
  public final Set<f.e> kqF;
  public final Set<Object> kqG;
  private boolean kqH;
  public final Set<f.f> kqz;
  
  public g()
  {
    AppMethodBeat.i(140627);
    this.kqz = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqA = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqB = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqC = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqD = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqE = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqF = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqG = Collections.newSetFromMap(new ConcurrentHashMap());
    this.kqH = true;
    AppMethodBeat.o(140627);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(140630);
    this.kqA.add(paramb);
    AppMethodBeat.o(140630);
  }
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(140634);
    this.kqC.add(paramc);
    AppMethodBeat.o(140634);
  }
  
  public final void a(f.d paramd)
  {
    AppMethodBeat.i(140632);
    this.kqB.add(paramd);
    AppMethodBeat.o(140632);
  }
  
  public final void a(f.e parame)
  {
    AppMethodBeat.i(174622);
    this.kqF.add(parame);
    AppMethodBeat.o(174622);
  }
  
  public final void a(f.f paramf)
  {
    AppMethodBeat.i(140628);
    this.kqz.add(paramf);
    AppMethodBeat.o(140628);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(140631);
    this.kqA.remove(paramb);
    AppMethodBeat.o(140631);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(140635);
    this.kqC.remove(paramc);
    AppMethodBeat.o(140635);
  }
  
  public final void b(f.d paramd)
  {
    AppMethodBeat.i(140633);
    this.kqB.remove(paramd);
    AppMethodBeat.o(140633);
  }
  
  public final void b(f.e parame)
  {
    AppMethodBeat.i(174623);
    this.kqF.remove(parame);
    AppMethodBeat.o(174623);
  }
  
  public final void b(f.f paramf)
  {
    AppMethodBeat.i(140629);
    this.kqz.remove(paramf);
    AppMethodBeat.o(140629);
  }
  
  public final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(174621);
    Iterator localIterator;
    if ((this.kqH == true) && (!paramBoolean)) {
      localIterator = this.kqG.iterator();
    }
    while (localIterator.hasNext())
    {
      localIterator.next();
      continue;
      if ((!this.kqH) && (paramBoolean == true))
      {
        localIterator = this.kqF.iterator();
        while (localIterator.hasNext()) {
          ((f.e)localIterator.next()).Ex();
        }
      }
    }
    this.kqH = paramBoolean;
    AppMethodBeat.o(174621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g
 * JD-Core Version:    0.7.0.1
 */