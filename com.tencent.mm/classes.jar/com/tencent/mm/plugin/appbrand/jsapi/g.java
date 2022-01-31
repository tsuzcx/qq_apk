package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements f
{
  public final Set<f.e> hwQ;
  public final Set<f.b> hwR;
  public final Set<f.d> hwS;
  public final Set<f.c> hwT;
  public final Set<f.a> hwU;
  public final Set<f.f> hwV;
  
  public g()
  {
    AppMethodBeat.i(91017);
    this.hwQ = Collections.newSetFromMap(new ConcurrentHashMap());
    this.hwR = Collections.newSetFromMap(new ConcurrentHashMap());
    this.hwS = Collections.newSetFromMap(new ConcurrentHashMap());
    this.hwT = Collections.newSetFromMap(new ConcurrentHashMap());
    this.hwU = Collections.newSetFromMap(new ConcurrentHashMap());
    this.hwV = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(91017);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(91021);
    this.hwR.add(paramb);
    AppMethodBeat.o(91021);
  }
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(91025);
    this.hwT.add(paramc);
    AppMethodBeat.o(91025);
  }
  
  public final void a(f.d paramd)
  {
    AppMethodBeat.i(91023);
    this.hwS.add(paramd);
    AppMethodBeat.o(91023);
  }
  
  public final void a(f.e parame)
  {
    AppMethodBeat.i(91019);
    this.hwQ.add(parame);
    AppMethodBeat.o(91019);
  }
  
  public final void a(f.f paramf)
  {
    AppMethodBeat.i(91018);
    this.hwV.add(paramf);
    AppMethodBeat.o(91018);
  }
  
  public final void b(f.b paramb)
  {
    AppMethodBeat.i(91022);
    this.hwR.remove(paramb);
    AppMethodBeat.o(91022);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(91026);
    this.hwT.remove(paramc);
    AppMethodBeat.o(91026);
  }
  
  public final void b(f.d paramd)
  {
    AppMethodBeat.i(91024);
    this.hwS.remove(paramd);
    AppMethodBeat.o(91024);
  }
  
  public final void b(f.e parame)
  {
    AppMethodBeat.i(91020);
    this.hwQ.remove(parame);
    AppMethodBeat.o(91020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g
 * JD-Core Version:    0.7.0.1
 */